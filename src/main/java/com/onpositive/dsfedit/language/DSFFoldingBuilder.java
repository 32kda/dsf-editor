package com.onpositive.dsfedit.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.util.PsiTreeUtil;
import com.onpositive.dsfedit.language.parser.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DSFFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> resList = new ArrayList<>();
        Collection<PsiElement> nodes = PsiTreeUtil.findChildrenOfAnyType(root, DSFProperties.class, DSFObjectDefs.class, DSFPolygonDefs.class, DSFSegment.class, DSFPolygon.class);

        int i = 0;
        for (PsiElement element: nodes) {
            resList.add(new FoldingDescriptor(element.getNode(),
                    new TextRange(element.getTextRange().getStartOffset(),
                            element.getTextRange().getEndOffset() - 1),
                    FoldingGroup.newGroup(element.toString() + " " + i++)) );

        }
        return resList.toArray(new FoldingDescriptor[0]);
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        if (node.getElementType() == DSFTypes.PROPERTIES) {
            return "PROPERTY...";
        }
        if (node.getElementType() == DSFTypes.OBJECT_DEFS) {
            return "OBJECT_DEF...";
        }
        if (node.getElementType() == DSFTypes.POLYGON_DEFS) {
            return "POLYGON_DEF...";
        }
        if (node.getElementType() == DSFTypes.POLYGON || node.getElementType() == DSFTypes.SEGMENT) {
            return firstLine(node.getText()) + "...";
        }
        return "...";
    }

    private String firstLine(String text) {
        int idx = text.indexOf('\n');
        if (idx < 0) {
            idx = text.indexOf('\r');
        }
        if (idx > 0) {
            return text.substring(0,idx).trim();
        }
        return text;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
