package org.rust.lang.core.resolve.scope

import org.rust.lang.core.psi.RustCompositeElement
import org.rust.lang.core.psi.RustDeclaringElement

public interface RustResolveScope : RustCompositeElement {
    fun getDeclarations(): Collection<RustDeclaringElement>
}

