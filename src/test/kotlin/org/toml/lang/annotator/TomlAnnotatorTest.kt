package org.toml.lang.annotator

import org.toml.lang.TomlTestCase

class TomlAnnotatorTest : TomlTestCase() {
    override fun getTestDataPath() = "src/test/resources/org/toml/lang/annotator/fixtures"
    private fun doTestInfo() = myFixture.testHighlighting(true, true, true, fileName)

    fun testInlineTables() {
        doTestInfo()
    }
}
