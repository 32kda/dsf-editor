package com.onpositive.dsfedit.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiTreeUtil;
import com.onpositive.dsfedit.language.parser.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DSFReference extends PsiReferenceBase<PsiElement> {

    private final String key;

    public DSFReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        try {
            int index = Integer.parseInt(key);
            if (myElement.getParent() instanceof DSFObject) {
                Collection<DSFObjectDef> children = PsiTreeUtil.findChildrenOfType(myElement.getParent(), DSFObjectDef.class);
                if (children.size() > index) {
                    return new ArrayList<>(children).get(index);
                }
            } else if (myElement.getParent() instanceof DSFPolygon) {
                Collection<DSFPolygonDef> children = PsiTreeUtil.findChildrenOfType(myElement.getParent(), DSFPolygonDef.class);
                if (children.size() > index) {
                    return new ArrayList<>(children).get(index);
                }
            }
        } catch (NumberFormatException e) {
            // Best effort
        }
        return null;
    }

}
