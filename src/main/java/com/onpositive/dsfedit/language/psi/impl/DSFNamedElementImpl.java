package com.onpositive.dsfedit.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import com.onpositive.dsfedit.language.psi.DSFNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class DSFNamedElementImpl extends ASTWrapperPsiElement implements DSFNamedElement {
    public DSFNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}