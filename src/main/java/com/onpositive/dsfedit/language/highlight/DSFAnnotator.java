package com.onpositive.dsfedit.language.highlight;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.onpositive.dsfedit.language.parser.psi.DSFObjectDef;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonDef;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import com.onpositive.dsfedit.language.psi.IDSFDefinition;
import com.onpositive.dsfedit.util.FilePathUtil;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class DSFAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof DSFObjectDef || element instanceof DSFPolygonDef) {
            ASTNode valueNode = element.getNode().findChildByType(DSFTypes.VALUE_STRING);
            if (valueNode != null) {
                String filePath = valueNode.getText();
                if (!filePath.trim().isEmpty()) {
                    File linkedFile = FilePathUtil.getLinkedFile((IDSFDefinition) element);
                    if (linkedFile == null) {
                            holder.newAnnotation(HighlightSeverity.WARNING,  "File not found").range(valueNode.getTextRange()).create();
                    }
                }
            }
        }

    }

}
