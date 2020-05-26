package com.onpositive.dsfedit.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.onpositive.dsfedit.language.parser.psi.DSFIntRef;
import org.jetbrains.annotations.NotNull;
import org.picocontainer.defaults.SimpleReference;

public class DSFReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(DSFIntRef.class),
            new PsiReferenceProvider() {
                @NotNull
                @Override
                public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                             @NotNull ProcessingContext context) {
                    return new PsiReference[]{new DSFReference(element, element.getTextRange())};
                }
            });
    }

}
