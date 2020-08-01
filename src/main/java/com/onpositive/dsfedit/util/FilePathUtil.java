package com.onpositive.dsfedit.util;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.vfs.VirtualFile;
import com.onpositive.dsfedit.language.parser.psi.DSFObjectDef;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonDef;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import com.onpositive.dsfedit.language.psi.IDSFDefinition;

import java.io.File;

public class FilePathUtil {

    public static File getLinkedFile(IDSFDefinition definition) {
        if (definition instanceof DSFObjectDef || definition instanceof DSFPolygonDef) {
            ASTNode valueNode = definition.getNode().findChildByType(DSFTypes.VALUE_STRING);
            if (valueNode != null) {
                String filePath = valueNode.getText();
                VirtualFile virtualFile = definition.getContainingFile().getVirtualFile();
                if (virtualFile.isInLocalFileSystem()) {
                    String path = virtualFile.getPath();
                    if (path.indexOf('/') > 0) {
                        File rootDir = FilePathUtil.getSceneryRootDir(new File(path));
                        File file = new File(rootDir, filePath);
                        if (file.exists()) {
                            return file;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static File getSceneryRootDir(File file) {
        File parent = file.getParentFile();
        while (parent != null && !new File(parent,"Earth nav data").exists()) {
            parent = parent.getParentFile();
        }
        return parent;
    }


}
