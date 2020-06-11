package com.onpositive.dsfedit.language.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.onpositive.dsfedit.language.parser.psi.*;
import com.onpositive.dsfedit.language.psi.IDSFDefinition;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DSFCompletionContributor extends CompletionContributor {

    public static final String PROPERTY = "PROPERTY";
    public static final String OBJECT_DEF = "OBJECT_DEF";
    public static final String POLYGON_DEF = "POLYGON_DEF";
    public static final String NETWORK_DEF = "NETWORK_DEF";
    private final List<String> definitionConstants = new ArrayList<>();

    public DSFCompletionContributor() {
        super();
        definitionConstants.add(PROPERTY);
        definitionConstants.add(OBJECT_DEF);
        definitionConstants.add(POLYGON_DEF);
        definitionConstants.add(NETWORK_DEF);
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(DSFTypes.ID),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        Document document = parameters.getEditor().getDocument();
                        int offset = parameters.getOffset();
                        int curLine = document.getLineNumber(offset);
                        PsiFile containingFile = parameters.getPosition().getContainingFile();
                        String prevMatchedConstant = null;
                        for (int i = curLine; i > 0; i--) {
                            PsiElement elementAt = containingFile.findElementAt(document.getLineStartOffset(i));
                            if (elementAt != null) {
                                String elementText = elementAt.getText();
                                if (definitionConstants.contains(elementText)) {
                                    resultSet.addElement(LookupElementBuilder.create(elementText));
                                    prevMatchedConstant = elementText;
                                    break;
                                }
                            }
                        }
                        String nextMatchedConstant = null;
                        for (int i = curLine; i < document.getLineCount(); i++) {
                            PsiElement elementAt = containingFile.findElementAt(document.getLineStartOffset(i));
                            if (elementAt != null) {
                                String elementText = elementAt.getText();
                                if (definitionConstants.contains(elementText)) {
                                    if (!elementText.equals(prevMatchedConstant)) {
                                        resultSet.addElement(LookupElementBuilder.create(elementText));
                                    }
                                    nextMatchedConstant = elementText;
                                    break;
                                }
                                PsiElement incorrectParent = PsiTreeUtil.getNonStrictParentOfType(elementAt, DSFPolygon.class, DSFSegment.class, DSFObject.class);
                                if (incorrectParent != null) { //Stop searching, if we are out of definitions section already
                                    break;
                                }
                            }
                        }
                        int firstIdx = prevMatchedConstant != null ? definitionConstants.indexOf(prevMatchedConstant) + 1 : 0;
                        int lastIdx = nextMatchedConstant != null ? definitionConstants.indexOf(nextMatchedConstant) - 1 : definitionConstants.size() - 1;
                        if (firstIdx <= lastIdx) {
                            for (int i = firstIdx; i <= lastIdx; i++) {
                                resultSet.addElement(LookupElementBuilder.create(definitionConstants.get(i)));
                            }
                        }
                    }
                });
    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}
