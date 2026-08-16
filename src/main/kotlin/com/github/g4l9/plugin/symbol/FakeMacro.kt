package com.github.g4l9.plugin.symbol

import com.intellij.codeInsight.template.*
import net.datafaker.Faker

class FakeMacro : Macro() {

    override fun getName(): String = "fakeMacro"

    override fun getPresentableName(): String = "FakeMacro"

    override fun calculateResult(params: Array<Expression>, context: ExpressionContext): Result {
        if (params.size != 1) {
            return emptyText
        }

        val firstParam = params[0]
        val calculatedResult = firstParam.calculateResult(context)
        val textResult = calculatedResult as? TextResult ?: emptyText
        val methodPathTxt = textResult.text

        val methodPath = methodPathTxt.split(".").drop(1)
        if (methodPath.size < 2) {
            return emptyText
        }

        try {
            val firstMethodName = methodPath[0]
            val firstMethod = clazz.getMethod(firstMethodName)

            val innerObject = firstMethod.invoke(faker)

            val secondMethodName = methodPath[1]
            val secondMethod = innerObject.javaClass.getMethod(secondMethodName)

            val randomValue = secondMethod.invoke(innerObject).toString()

            return TextResult(randomValue)
        } catch (_: Exception) {
            return emptyText
        }
    }

    companion object {
        private val faker = Faker()
        private val clazz = faker.javaClass
        private val emptyText = TextResult("")
    }
}
