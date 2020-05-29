package com.onpositive.dsfedit.language;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.onpositive.dsfedit.language.parser.psi.DSFIntRef;
import org.jetbrains.annotations.NotNull;

public class DSFReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiElement.class),
            new PsiReferenceProvider() {
                @NotNull
                @Override
                public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                             @NotNull ProcessingContext context) {
                    if (element instanceof DSFIntRef) {
                        return new PsiReference[]{new DSFReference(element, element.getTextRange(), element.getText())};
                    }
                    DSFIntRef child = PsiTreeUtil.findChildOfType(element, DSFIntRef.class);
                    if (child != null) {
                        return new PsiReference[]{new DSFReference(element, child.getTextRangeInParent(), child.getText())};
                    }
                    return new PsiReference[0];
                }
            });
    }

}
