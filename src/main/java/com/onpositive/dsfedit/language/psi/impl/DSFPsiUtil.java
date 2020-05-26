package com.onpositive.dsfedit.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;

public class DSFPsiUtil {

    public static PsiElement getNameIdentifier(PsiElement element) {
        ASTNode keyNode = element.getNode().findChildByType(DSFTypes.INT_REF);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

}
