package com.onpositive.dsfedit.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
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

    public static String getName(PsiElement element) {
        ASTNode keyNode = element.getNode().findChildByType(DSFTypes.INT_REF);
        if (keyNode != null) {
            return keyNode.getText();
        }
        return null;
    }

    public static PsiElement setName(PsiElement element, String newName) {
        //XXX Do nothing
        return element;
    }

    public static PsiReference[] getReferences(PsiElement element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

}
