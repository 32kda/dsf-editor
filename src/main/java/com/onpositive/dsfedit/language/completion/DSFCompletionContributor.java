package com.onpositive.dsfedit.language.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import org.jetbrains.annotations.NotNull;

public class DSFCompletionContributor extends CompletionContributor {

    public DSFCompletionContributor() {
        super();
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(DSFTypes.ID),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Hello"));
                    }
                });
    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}
