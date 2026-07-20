package com.github.g4l9.plugin.symbol

import com.intellij.codeInsight.template.*

abstract class SymbolTemplateContextType(presentableName: String) :
    TemplateContextType(presentableName) {

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean =
        templateActionContext.file.isWritable
}