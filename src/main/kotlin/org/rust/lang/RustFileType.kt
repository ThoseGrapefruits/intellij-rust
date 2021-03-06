package org.rust.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import org.rust.lang.icons.RustIcons
import javax.swing.Icon

object RustFileType : LanguageFileType(RustLanguage) {

    public object DEFAULTS {
        public val EXTENSION: String = "rs";
    }

    override fun getName(): String = "Rust"

    override fun getIcon(): Icon = RustIcons.RUST;

    override fun getDefaultExtension(): String = DEFAULTS.EXTENSION

    override fun getCharset(file: VirtualFile, content: ByteArray): String =
            "UTF-8"

    override fun getDescription(): String {
        return "Rust Files"
    }
}

