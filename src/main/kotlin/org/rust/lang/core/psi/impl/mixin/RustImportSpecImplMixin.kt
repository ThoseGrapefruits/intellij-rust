package org.rust.lang.core.psi.impl.mixin

import com.intellij.lang.ASTNode
import org.rust.lang.core.psi.RustImportSpec
import org.rust.lang.core.psi.impl.RustNamedElementImpl
import org.rust.lang.core.resolve.ref.RustImportSpecReferenceImpl
import org.rust.lang.core.resolve.ref.RustReference

abstract class RustImportSpecImplMixin(node: ASTNode) : RustNamedElementImpl(node), RustImportSpec {
    override fun getReference(): RustReference =
            RustImportSpecReferenceImpl(this)
}
