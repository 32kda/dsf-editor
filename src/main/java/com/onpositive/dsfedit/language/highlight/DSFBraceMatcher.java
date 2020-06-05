package com.onpositive.dsfedit.language.highlight;

import com.intellij.json.JsonElementTypes;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DSFBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = {
            new BracePair(DSFTypes.BEGIN_POLYGON_KEYWORD, DSFTypes.END_POLYGON_KEYWORD, true),
            new BracePair(DSFTypes.BEGIN_WINDING_KEYWORD, DSFTypes.END_WINDING_KEYWORD, true),
            new BracePair(DSFTypes.BEGIN_SEGMENT_KEYWORD, DSFTypes.END_SEGMENT_KEYWORD, true),
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }

}
