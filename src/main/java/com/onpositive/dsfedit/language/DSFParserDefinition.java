package com.onpositive.dsfedit.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.onpositive.dsfedit.language.parser.DSFParser;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import com.onpositive.dsfedit.language.psi.DSFFile;
import org.jetbrains.annotations.NotNull;

public class DSFParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(DSFTypes.SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(DSFTypes.COMMENT);
    public static final TokenSet LITERALS = TokenSet.create(DSFTypes.VALUE_STRING);

    public static final IFileElementType FILE = new IFileElementType(DSFLanguage.INSTANCE);
    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new DSFLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new DSFParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return LITERALS;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return DSFTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new DSFFile(fileViewProvider);
    }

}
