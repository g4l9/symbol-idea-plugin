package com.github.g4l9.plugin.symbol

import com.github.javafaker.Faker
import com.intellij.codeInsight.template.*

class FakeMacro : Macro() {

    override fun getName(): String = "fakeMacro"

    override fun getPresentableName(): String = "FakeMacro"

    override fun calculateResult(params: Array<Expression>, context: ExpressionContext): Result? {
        if (params.size != 1) return TextResult("")

        val functionResult = params[0].calculateResult(context) as? TextResult ?: return TextResult("")
        val function = functionResult.text

        val functions = function.split(".").drop(1) // skip first part if needed
        if (functions.size < 2) return TextResult("")

        try {
            val firstMethod = clazz.getDeclaredMethod(functions[0])
            val innerObject = firstMethod.invoke(faker)

            val secondMethod = innerObject.javaClass.getDeclaredMethod(functions[1])
            val randomValue = secondMethod.invoke(innerObject).toString()

            return TextResult(randomValue)
        } catch (_: Exception) {
            return TextResult("")
        }
    }

    companion object {
        private val faker = Faker.instance()
        private val clazz = faker.javaClass
    }
}