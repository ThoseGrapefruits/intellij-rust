package org.rust.lang.formatter

import com.intellij.psi.formatter.FormatterTestCase
import org.rust.lang.RustTestCase

class RustFormatterTestCase : FormatterTestCase() {
    override fun getTestDataPath() = "src/test/resources"

    override fun getBasePath() = "org/rust/lang/formatter/fixtures"

    override fun getFileExtension() = "rs"

    override fun getTestName(lowercaseFirstLetter: Boolean): String? {
        val camelCase = super.getTestName(lowercaseFirstLetter)
        return RustTestCase.camelToSnake(camelCase)
    }

    fun testBlocks() = doTest()
    fun testItems() = doTest()
    fun testExpressions() = doTest()
    fun testArgumentAlignment() = doTest()
    fun testArgumentIndent() = doTest()
    fun testTraits() = doTest()
}
