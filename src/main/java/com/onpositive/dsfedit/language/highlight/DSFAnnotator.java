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
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class DSFAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof DSFObjectDef || element instanceof DSFPolygonDef) {
            ASTNode valueNode = element.getNode().findChildByType(DSFTypes.VALUE_STRING);
            if (valueNode != null) {
                String filePath = valueNode.getText();
                VirtualFile virtualFile = element.getContainingFile().getVirtualFile();
                if (virtualFile.isInLocalFileSystem()) {
                    String path = virtualFile.getPath();
                    if (path.indexOf('/') > 0) {
                        File rootDir = new File(path).getParentFile().getParentFile();
                        if (rootDir != null && !new File(rootDir, filePath).exists()) {
                            holder.newAnnotation(HighlightSeverity.WARNING,  "File not found").range(valueNode.getTextRange()).create();
                        }
                    }
                }
            }
        }

    }
}
