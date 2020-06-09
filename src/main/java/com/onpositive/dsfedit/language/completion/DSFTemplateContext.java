package com.onpositive.dsfedit.language.completion;

import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.onpositive.dsfedit.language.psi.DSFFile;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

public class DSFTemplateContext extends TemplateContextType {

    public DSFTemplateContext() {
        super("DSF", "DSF");
    }

    @Override
    public boolean isInContext(@NotNull PsiFile file, int offset) {
        PsiElement psiElement = file.findElementAt(offset);
        if (psiElement == null && offset > 0) {
            psiElement = file.findElementAt(offset - 1);
        }
        PsiElement parent = psiElement.getParent();
        return (parent != null && parent.getParent() instanceof DSFFile);
    }
}
