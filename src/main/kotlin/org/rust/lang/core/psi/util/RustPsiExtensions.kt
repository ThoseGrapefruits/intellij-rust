package org.rust.lang.core.psi.util

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.rust.lang.core.lexer.RustTokenElementTypes
import org.rust.lang.core.psi.*


//
// Extension points
//

inline fun <reified T : PsiElement> PsiElement.parentOfType(strict: Boolean = true): T? {
    var current = if (strict) parent else this
    while (current != null) {
        when (current) {
            is T -> return current
            else -> current = current.parent
        }
    }
    return null
}


fun PsiElement?.getNextNonPhantomSibling(): PsiElement? =
    this?.let {
        val next = it.nextSibling
        val et = next.node.elementType

        if (et in RustTokenElementTypes.PHANTOM_TOKEN_SET)
            return next.getNextNonPhantomSibling()
        else
            return next
    }

val PsiElement.parentRelativeRange: TextRange?
    get() = this.parent?.let {
        TextRange(startOffsetInParent, startOffsetInParent + textLength)
    }

fun PsiElement.isBefore(other: PsiElement): Boolean = textOffset < other.textOffset


val RustPat.boundElements: List<RustNamedElement>
    get() {
        val result = arrayListOf<RustNamedElement>()

        accept(object : RecursiveRustVisitor() {
            override fun visitElement(element: PsiElement?) {
                if (element is RustNamedElement)
                    result.add(element)
                super.visitElement(element)
            }
        })
        return result
    }


fun RustItem.isPublic() = vis != null


val RustPatBinding.isMut: Boolean
    get()  = bindingMode?.mut != null

val RustCompositeElement.containingMod: RustModItem?
    get() = parentOfType<RustModItem>()
