package com.onpositive.dsfedit.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.onpositive.dsfedit.language.parser.psi.DSFTypes.*;

%%

%{
  public _DSFLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _DSFLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=[ \t]*\R
WHITE_SPACE=\s+

SPACE=[ \t]+
COMMENT=#.*
INT_NUM=[0-9]+
FLOAT_NUM=[0-9]+(\.[0-9]*)?
ID=[:letter:][a-zA-Z_0-9]*
PROP_ID=[:letter:][a-zA-Z_0-9]*\/[:letter:][a-zA-Z_0-9]*
VALUE_STRING=[^ \t\n\x0B\f\r].*\R

%state WAITING_VALUE
%state WAITING_PROP

%%
<YYINITIAL> {
  //{WHITE_SPACE}       {yybegin(YYINITIAL); return WHITE_SPACE; }

  "PROPERTY"          { yybegin(WAITING_PROP); return PROPERTY_KEYWORD; }
  "OBJECT_DEF"        { yybegin(WAITING_VALUE); return OBJECT_DEF_KEYWORD; }
  "POLYGON_DEF"       { yybegin(WAITING_VALUE); return POLYGON_DEF_KEYWORD; }
  "NETWORK_DEF"       { yybegin(WAITING_VALUE); return NETWORK_DEF_KEYWORD; }
      
  "OBJECT"               { yybegin(YYINITIAL); return OBJECT_KEYWORD; }       
  "BEGIN_POLYGON"        { yybegin(YYINITIAL); return BEGIN_POLYGON_KEYWORD; }
  "END_POLYGON"          { yybegin(YYINITIAL); return END_POLYGON_KEYWORD; }  
  "BEGIN_WINDING"        { yybegin(YYINITIAL); return BEGIN_WINDING_KEYWORD; }
  "END_WINDING"          { yybegin(YYINITIAL); return END_WINDING_KEYWORD; }  
  "POLYGON_POINT"        { yybegin(YYINITIAL); return POLYGON_POINT_KEYWORD; }
  "BEGIN_SEGMENT"        { yybegin(YYINITIAL); return BEGIN_SEGMENT_KEYWORD; }
  "END_SEGMENT"          { yybegin(YYINITIAL); return END_SEGMEN_KEYWORD; }   
  "SHAPE_POINT"          { yybegin(YYINITIAL); return SHAPE_POINT_KEYWORD; }  
  "SHAPE_POINT_CURVED"   { yybegin(YYINITIAL); return SHAPE_POINT_CURVED_KEYWORD; }
  "I"                    { yybegin(YYINITIAL); return I_KEYWORD; }
  "A"                    { yybegin(YYINITIAL); return A_KEYWORD; }

  {EOL}               { yybegin(YYINITIAL); return EOL; }
  {SPACE}             { yybegin(YYINITIAL); return SPACE; }
  {COMMENT}           { yybegin(YYINITIAL); return COMMENT; }
  {INT_NUM}           { yybegin(YYINITIAL); return INT_NUM; }
  {FLOAT_NUM}         { yybegin(YYINITIAL); return FLOAT_NUM; }
  {ID}                { yybegin(YYINITIAL); return ID; }

}

<WAITING_PROP> {
  {SPACE}             { return SPACE; }
  {PROP_ID}           { yybegin(WAITING_VALUE); return PROP_ID; }
}

<WAITING_VALUE> {
  {SPACE}             { return SPACE; }
  {VALUE_STRING}      { yybegin(YYINITIAL); return VALUE_STRING; }
}

[^] { return BAD_CHARACTER; }
