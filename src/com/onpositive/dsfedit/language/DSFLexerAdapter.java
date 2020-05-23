package com.onpositive.dsfedit.language;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class DSFLexerAdapter extends FlexAdapter {
    public DSFLexerAdapter() {
        super(new _DSFLexer(null));
    }
}
