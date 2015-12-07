package org.rust.lang.core.resolve.ref

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReferenceBase
import org.rust.lang.core.psi.RustImportSpec
import org.rust.lang.core.psi.RustItem
import org.rust.lang.core.psi.RustNamedElement
import org.rust.lang.core.resolve.RustResolveEngine

class RustImportSpecReferenceImpl(importSpec: RustImportSpec)
    : PsiReferenceBase<RustImportSpec>(importSpec, importSpec.identifierRange, /* soft = */ false)
    , RustReference {

    override fun getVariants(): Array<out Any> = EMPTY_ARRAY

    override fun resolve(): RustNamedElement? {
        return RustResolveEngine.resolveImportSpec(element).element
    }
}


private val RustImportSpec.identifierRange: TextRange
    get() {
        // NOTE(matklad): EMPTY_RANGE case is impossible
        val name = (identifier ?: self) ?: return TextRange.EMPTY_RANGE
        return TextRange.from(name.startOffsetInParent, name.textLength)
    }
