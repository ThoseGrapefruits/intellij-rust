package org.rust.lang.icons

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * @author Evgeny.Kurbatsky
 */
public object RustIcons {

    public val NORMAL:  Icon = IconLoader.getIcon("/org/rust/icons/rust16.png")
    public val BIG:     Icon = IconLoader.getIcon("/org/rust/icons/rust32.png")

    public val TRAIT = AllIcons.Nodes.Interface
    public val CLASS = AllIcons.Nodes.Class
    public val IMPL = AllIcons.Nodes.AbstractClass
    public val ENUM   = AllIcons.Nodes.Enum
    public val FIELD   = AllIcons.Nodes.Field
    public val FUNCTION = AllIcons.Nodes.Function
    public val METHOD   = AllIcons.Nodes.Method
    public val ABSTRACT_METHOD   = AllIcons.Nodes.AbstractMethod

    public val STATIC_MARK   = AllIcons.Nodes.StaticMark
    public val TEST_MARK   = AllIcons.Nodes.JunitTestMark
}
