package com.github.g4l9.plugin.symbol

import com.intellij.codeInsight.template.*
import net.datafaker.Faker

class FakeMacro : Macro() {

    override fun getName(): String = "fakeMacro"

    override fun getPresentableName(): String = "FakeMacro"

    override fun calculateResult(params: Array<Expression>, context: ExpressionContext): Result {
        if (params.size != 1) return TextResult("")

        val functionResult = params[0].calculateResult(context) as? TextResult ?: return TextResult("")
        val function = functionResult.text

        val functions = function.split(".").drop(1) // skip first part if needed
        if (functions.size < 2) return TextResult("")

        try {
            val methodName = functions[0]
            val firstMethod = clazz.getMethod(methodName)

            val innerObject = firstMethod.invoke(faker)

            val subMethodName = functions[1]
            val secondMethod = innerObject.javaClass.getMethod(subMethodName)

            val randomValue = secondMethod.invoke(innerObject).toString()

            return TextResult(randomValue)
        } catch (_: Exception) {
            return TextResult("")
        }
    }

    companion object {
        private val faker = Faker()
        private val clazz = faker.javaClass
    }
}
