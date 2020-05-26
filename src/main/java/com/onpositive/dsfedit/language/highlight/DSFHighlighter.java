package com.onpositive.dsfedit.language.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.onpositive.dsfedit.language.DSFLexerAdapter;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import com.thaiopensource.xml.dtd.om.Def;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;

public class DSFHighlighter extends SyntaxHighlighterBase {

    private static final TokenSet KEYWORDS = TokenSet.create(DSFTypes.A_KEYWORD, DSFTypes.I_KEYWORD, DSFTypes.PROPERTY_KEYWORD,
            DSFTypes.BEGIN_POLYGON_KEYWORD, DSFTypes.BEGIN_SEGMENT_KEYWORD, DSFTypes.END_POLYGON_KEYWORD, DSFTypes.END_POLYGON_KEYWORD,
            DSFTypes.BEGIN_WINDING_KEYWORD, DSFTypes.END_WINDING_KEYWORD, DSFTypes.OBJECT_DEF_KEYWORD, DSFTypes.POLYGON_DEF_KEYWORD,
            DSFTypes.NETWORK_DEF_KEYWORD, DSFTypes.OBJECT_KEYWORD, DSFTypes.NETWORK_DEF_KEYWORD, DSFTypes.SHAPE_POINT_KEYWORD,
            DSFTypes.SHAPE_POINT_CURVED_KEYWORD, DSFTypes.POLYGON_POINT_KEYWORD);

    private static final TokenSet NUMBERS = TokenSet.create(DSFTypes.INT_NUM, DSFTypes.FLOAT_NUM);
    private static final TokenSet IDS = TokenSet.create(DSFTypes.ID, DSFTypes.PROP_ID);

    private static final Map<IElementType, TextAttributesKey> ourMap1 = new HashMap<>();

    public static final TextAttributesKey DSF_KEYWORD = TextAttributesKey.createTextAttributesKey("DSF.KEYWORD", KEYWORD);
    public static final TextAttributesKey DSF_NUMBER = TextAttributesKey.createTextAttributesKey("DSF.NUMBER", NUMBER);
    public static final TextAttributesKey DSF_COMMENT = TextAttributesKey.createTextAttributesKey("DSF.COMMENT", LINE_COMMENT);
    public static final TextAttributesKey DSF_VALUE_STRING = TextAttributesKey.createTextAttributesKey("DSF.VALUE_STRING", STRING);

    static {
        fillMap(ourMap1, KEYWORDS, DSF_KEYWORD);
        fillMap(ourMap1, NUMBERS, DSF_NUMBER);

        ourMap1.put(DSFTypes.COMMENT, DSF_COMMENT);
        ourMap1.put(DSFTypes.VALUE_STRING, DSF_VALUE_STRING);
    }

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new DSFLexerAdapter();
    }

    @Override
    public @NotNull TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ourMap1.get(tokenType));
    }
}
