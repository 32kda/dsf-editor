package com.onpositive.dsfedit.language;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageUtil;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorLinePainter;
import com.intellij.openapi.editor.LineExtensionInfo;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.file.PsiFileImplUtil;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.DocumentUtil;
import com.onpositive.dsfedit.language.highlight.DSFColorSettingsPage;
import com.onpositive.dsfedit.language.highlight.DSFHighlighter;
import com.onpositive.dsfedit.language.parser.psi.DSFObjectDef;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonDef;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonRef;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;

public class DSFEditorLinePainter extends EditorLinePainter {
    @Override
    public @Nullable Collection<LineExtensionInfo> getLineExtensions(@NotNull Project project, @NotNull VirtualFile file, int lineNumber) {
        Language fileLanguage = LanguageUtil.getFileLanguage(file);
        if (fileLanguage != DSFLanguage.INSTANCE) {
            return null;
        }
        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
        if (psiFile != null) {
            Document document = FileDocumentManager.getInstance().getDocument(file);
            if (document != null) {
                int lineStartOffset = document.getLineStartOffset(lineNumber);
                PsiElement element = psiFile.findElementAt(lineStartOffset);
                if (element != null && (element.getNode().getElementType() == DSFTypes.OBJECT_KEYWORD || element.getNode().getElementType() == DSFTypes.BEGIN_POLYGON_KEYWORD)) {
                    element = element.getParent();
                    @NotNull PsiReference[] references = PsiReferenceService.getService().getContributedReferences(element);
                    for (PsiReference reference: references) {
                        if (reference instanceof DSFReference) {
                            DSFReference dsfReference = (DSFReference) reference;
                            PsiElement original = dsfReference.resolve();
                            if (original instanceof DSFPolygonDef || original instanceof DSFObjectDef) {
                                String text = original.getText().trim();
                                int idx = text.indexOf(' ');
                                if (idx > 0) {
                                    String path = text.substring(idx + 1);
                                    final EditorColorsScheme scheme = EditorColorsManager.getInstance().getGlobalScheme();
                                    TextAttributes attributes = scheme.getAttributes(DSFHighlighter.DSF_COMMENT);
                                    return Collections.singletonList( new LineExtensionInfo(" " + path, attributes));
                                }

                            }
                        }
                    }
                }
            }

        }
        return null;
    }
}
