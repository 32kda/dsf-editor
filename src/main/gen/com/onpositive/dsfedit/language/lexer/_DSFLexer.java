/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.onpositive.dsfedit.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.onpositive.dsfedit.language.parser.psi.DSFTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>_DSFLexer.flex</tt>
 */
public class _DSFLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WAITING_VALUE = 2;
  public static final int WAITING_PROP = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [11, 6, 4]
   * Total runtime size is 14112 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>10]<<6)|((ch>>4)&0x3f)]<<4)|(ch&0xf)];
  }

  /* The ZZ_CMAP_Z table has 1088 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\11\1\12\1\13\6\14\1\15\23\14\1\16"+
    "\1\14\1\17\1\20\12\14\1\21\10\11\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
    "\32\1\33\1\34\1\35\2\11\1\14\1\36\3\11\1\37\10\11\1\40\1\41\5\14\1\42\1\43"+
    "\11\11\1\44\2\11\1\45\5\11\1\46\4\11\1\47\1\50\4\11\51\14\1\51\3\14\1\52\1"+
    "\53\4\14\1\54\12\11\1\55\u0381\11");

  /* The ZZ_CMAP_Y table has 2944 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\11\1\12\1\13\1\14\1\13\1\14\34"+
    "\13\1\15\1\16\1\17\10\1\1\20\1\21\1\13\1\22\4\13\1\23\10\13\1\24\12\13\1\25"+
    "\1\13\1\26\1\25\1\13\1\27\4\1\1\13\1\30\1\31\2\1\2\13\1\30\1\1\1\32\1\25\5"+
    "\13\1\33\1\34\1\35\1\1\1\36\1\13\1\1\1\37\5\13\1\40\1\41\1\42\1\13\1\30\1"+
    "\43\1\13\1\44\1\45\1\1\1\13\1\46\4\1\1\13\1\47\4\1\1\50\2\13\1\51\1\1\1\52"+
    "\1\16\1\25\1\53\1\54\1\55\1\56\1\57\1\60\2\16\1\61\1\54\1\55\1\62\1\1\1\63"+
    "\1\1\1\64\1\65\1\22\1\55\1\66\1\1\1\67\1\16\1\70\1\71\1\54\1\55\1\66\1\1\1"+
    "\60\1\16\1\41\1\72\1\73\1\74\1\75\1\1\1\67\2\1\1\76\1\36\1\55\1\51\1\1\1\77"+
    "\1\16\1\1\1\100\1\36\1\55\1\101\1\1\1\57\1\16\1\102\1\76\1\36\1\13\1\103\1"+
    "\57\1\104\1\16\1\42\1\105\1\106\1\13\1\107\1\110\3\1\1\25\2\13\1\111\1\110"+
    "\3\1\1\112\1\113\1\114\1\115\1\116\1\117\2\1\1\67\3\1\1\120\1\13\1\121\1\1"+
    "\1\122\7\1\2\13\1\30\1\123\1\1\1\124\1\125\1\126\1\127\1\1\2\13\1\130\2\13"+
    "\1\131\24\13\1\132\1\133\2\13\1\132\2\13\1\134\1\135\1\14\3\13\1\135\3\13"+
    "\1\30\2\1\1\13\1\1\5\13\1\136\1\25\45\13\1\137\1\13\1\25\1\30\4\13\1\30\1"+
    "\140\1\141\1\16\1\13\1\16\1\13\1\16\1\141\1\67\3\13\1\142\1\1\1\143\4\1\5"+
    "\13\1\27\1\144\1\13\1\145\4\13\1\40\1\13\1\146\3\1\1\13\1\147\1\150\2\13\1"+
    "\151\1\13\1\75\3\1\1\13\1\110\3\13\1\150\4\1\1\152\5\1\1\105\2\13\1\142\1"+
    "\153\3\1\1\154\1\13\1\155\1\42\2\13\1\40\1\1\2\13\1\142\1\1\1\37\1\42\1\13"+
    "\1\147\1\46\5\1\1\156\1\157\14\13\4\1\21\13\1\136\2\13\1\136\1\160\1\13\1"+
    "\147\3\13\1\161\1\162\1\163\1\121\1\162\2\1\1\164\4\1\1\165\1\1\1\121\6\1"+
    "\1\166\1\167\1\170\1\171\1\172\3\1\1\173\147\1\2\13\1\146\2\13\1\146\10\13"+
    "\1\174\1\175\2\13\1\130\3\13\1\176\1\1\1\13\1\110\4\177\4\1\1\123\35\1\1\200"+
    "\2\1\1\201\1\25\4\13\1\202\1\25\4\13\1\131\1\105\1\13\1\147\1\25\4\13\1\146"+
    "\1\1\1\13\1\30\3\1\1\13\40\1\133\13\1\40\4\1\135\13\1\40\2\1\10\13\1\121\4"+
    "\1\2\13\1\147\20\13\1\121\1\13\1\203\1\1\2\13\1\146\1\123\1\13\1\147\4\13"+
    "\1\40\2\1\1\204\1\205\5\13\1\206\1\13\1\146\1\27\3\1\1\204\1\207\1\13\1\31"+
    "\1\1\3\13\1\142\1\205\2\13\1\142\3\1\1\210\1\42\1\13\1\40\1\13\1\110\1\1\1"+
    "\13\1\121\1\50\2\13\1\31\1\123\1\1\1\211\1\212\2\13\1\46\1\1\1\213\1\1\1\13"+
    "\1\214\3\13\1\215\1\216\1\217\1\30\1\64\1\220\1\221\1\177\2\13\1\131\1\40"+
    "\7\13\1\31\1\1\72\13\1\142\1\13\1\222\2\13\1\151\20\1\26\13\1\147\6\13\1\75"+
    "\2\1\1\110\1\223\1\55\1\224\1\225\6\13\1\16\1\1\1\154\25\13\1\147\1\1\4\13"+
    "\1\205\2\13\1\27\2\1\1\151\7\1\1\211\7\13\1\121\2\1\1\25\1\30\1\25\1\30\1"+
    "\226\4\13\1\146\1\227\1\230\2\1\1\231\1\13\1\14\1\232\2\147\2\1\7\13\1\30"+
    "\30\1\1\13\1\121\3\13\1\67\2\1\2\13\1\1\1\13\1\233\2\13\1\40\1\13\1\147\2"+
    "\13\1\234\3\1\11\13\1\147\1\1\2\13\1\234\1\13\1\151\2\13\1\27\3\13\1\142\11"+
    "\1\23\13\1\110\1\13\1\40\1\27\11\1\1\235\2\13\1\236\1\13\1\40\1\13\1\110\1"+
    "\13\1\146\4\1\1\13\1\237\1\13\1\40\1\13\1\75\4\1\3\13\1\240\4\1\1\67\1\241"+
    "\1\13\1\142\2\1\1\13\1\121\1\13\1\121\2\1\1\120\1\13\1\150\1\1\3\13\1\40\1"+
    "\13\1\40\1\13\1\31\1\13\1\16\6\1\4\13\1\46\3\1\3\13\1\31\3\13\1\31\60\1\1"+
    "\154\2\13\1\27\4\1\1\154\2\13\2\1\1\13\1\46\1\1\1\154\1\13\1\110\2\1\2\13"+
    "\1\242\1\154\2\13\1\31\1\243\1\244\2\1\1\13\1\22\1\151\5\1\1\245\1\246\1\46"+
    "\2\13\1\146\2\1\1\71\1\54\1\55\1\66\1\1\1\247\1\16\11\1\3\13\1\150\1\250\3"+
    "\1\3\13\1\1\1\251\13\1\2\13\1\146\2\1\1\252\2\1\3\13\1\1\1\253\3\1\2\13\1"+
    "\30\5\1\1\13\1\75\30\1\4\13\1\1\1\123\34\1\3\13\1\46\20\1\1\55\1\13\1\146"+
    "\1\1\1\67\2\1\1\205\1\13\67\1\71\13\1\75\16\1\14\13\1\142\53\1\2\13\1\146"+
    "\75\1\44\13\1\110\33\1\43\13\1\46\1\13\1\146\7\1\1\13\1\147\1\1\3\13\1\1\1"+
    "\142\1\1\1\154\1\254\1\13\67\1\4\13\1\150\1\67\3\1\1\154\4\1\1\67\1\1\76\13"+
    "\1\121\1\1\57\13\1\31\20\1\1\16\77\1\6\13\1\30\1\121\1\46\1\75\66\1\5\13\1"+
    "\211\3\13\1\141\1\255\1\256\1\257\3\13\1\260\1\261\1\13\1\262\1\263\1\36\24"+
    "\13\1\264\1\13\1\36\1\131\1\13\1\131\1\13\1\211\1\13\1\211\1\146\1\13\1\146"+
    "\1\13\1\55\1\13\1\55\1\13\1\213\3\1\14\13\1\150\3\1\4\13\1\142\113\1\1\257"+
    "\1\13\1\265\1\266\1\267\1\270\1\271\1\272\1\273\1\151\1\274\1\151\24\1\55"+
    "\13\1\110\2\1\103\13\1\150\15\13\1\147\150\13\1\16\25\1\41\13\1\147\36\1");

  /* The ZZ_CMAP_A table has 3024 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\1\1\3\2\6\1\4\22\0\1\1\2\0\1\5\12\0\1\10\1\14\12\7\7\0\1\41\1\23\1"+
    "\25\1\26\1\20\1\27\1\31\1\40\1\35\1\24\1\34\1\30\1\37\1\32\1\17\1\15\1\13"+
    "\1\16\1\36\1\21\1\42\1\43\1\33\1\13\1\22\1\13\4\0\1\12\1\0\32\13\12\0\1\2"+
    "\24\0\1\11\12\0\1\11\4\0\1\11\5\0\27\11\1\0\12\11\4\0\14\11\16\0\5\11\7\0"+
    "\1\11\1\0\1\11\1\0\5\11\1\0\2\11\2\0\4\11\1\0\1\11\6\0\1\11\1\0\3\11\1\0\1"+
    "\11\1\0\4\11\1\0\23\11\1\0\13\11\10\0\6\11\1\0\26\11\2\0\1\11\6\0\10\11\10"+
    "\0\13\11\5\0\3\11\33\0\6\11\1\0\1\11\17\0\2\11\7\0\2\11\12\0\3\11\2\0\2\11"+
    "\1\0\16\11\15\0\11\11\13\0\1\11\30\0\6\11\4\0\2\11\4\0\1\11\5\0\6\11\4\0\1"+
    "\11\11\0\1\11\3\0\1\11\7\0\11\11\7\0\5\11\1\0\10\11\6\0\26\11\3\0\1\11\2\0"+
    "\1\11\7\0\11\11\4\0\10\11\2\0\2\11\2\0\26\11\1\0\7\11\1\0\1\11\3\0\4\11\3"+
    "\0\1\11\20\0\1\11\15\0\2\11\1\0\1\11\5\0\6\11\4\0\2\11\1\0\2\11\1\0\2\11\1"+
    "\0\2\11\17\0\4\11\1\0\1\11\3\0\3\11\20\0\11\11\1\0\2\11\1\0\2\11\1\0\5\11"+
    "\3\0\1\11\2\0\1\11\30\0\1\11\13\0\10\11\2\0\1\11\3\0\1\11\1\0\6\11\3\0\3\11"+
    "\1\0\4\11\3\0\2\11\1\0\1\11\1\0\2\11\3\0\2\11\3\0\3\11\3\0\14\11\13\0\10\11"+
    "\1\0\2\11\10\0\3\11\5\0\1\11\4\0\10\11\1\0\6\11\1\0\5\11\3\0\1\11\3\0\2\11"+
    "\15\0\13\11\2\0\1\11\6\0\3\11\10\0\1\11\5\0\22\11\3\0\10\11\1\0\11\11\1\0"+
    "\1\11\2\0\7\11\11\0\1\11\1\0\2\11\15\0\2\11\1\0\1\11\2\0\2\11\1\0\1\11\2\0"+
    "\1\11\6\0\4\11\1\0\7\11\1\0\3\11\1\0\1\11\1\0\1\11\2\0\2\11\1\0\4\11\1\0\2"+
    "\11\11\0\1\11\2\0\5\11\1\0\1\11\25\0\14\11\1\0\24\11\13\0\5\11\22\0\7\11\4"+
    "\0\4\11\3\0\1\11\3\0\2\11\7\0\3\11\4\0\15\11\14\0\1\11\1\0\6\11\1\0\1\11\5"+
    "\0\1\11\2\0\13\11\1\0\15\11\1\0\4\11\2\0\7\11\1\0\1\11\1\0\4\11\2\0\1\11\1"+
    "\0\4\11\2\0\7\11\1\0\1\11\1\0\4\11\2\0\16\11\2\0\6\11\2\0\15\11\2\0\1\11\1"+
    "\0\10\11\7\0\15\11\1\0\6\11\23\0\1\11\4\0\1\11\3\0\5\11\2\0\22\11\1\0\1\11"+
    "\5\0\17\11\1\0\16\11\2\0\5\11\13\0\14\11\13\0\1\11\15\0\7\11\7\0\16\11\15"+
    "\0\2\11\11\0\4\11\1\0\4\11\3\0\2\11\11\0\10\11\1\0\1\11\1\0\1\11\1\0\1\11"+
    "\1\0\6\11\1\0\7\11\1\0\1\11\3\0\3\11\1\0\7\11\3\0\4\11\2\0\6\11\14\0\2\2\7"+
    "\0\1\11\15\0\1\11\2\0\1\11\4\0\1\11\2\0\12\11\1\0\1\11\3\0\5\11\6\0\1\11\1"+
    "\0\1\11\1\0\1\11\1\0\4\11\1\0\13\11\2\0\4\11\5\0\5\11\4\0\1\11\4\0\2\11\13"+
    "\0\5\11\6\0\4\11\3\0\2\11\14\0\10\11\7\0\10\11\1\0\7\11\6\0\2\11\12\0\5\11"+
    "\5\0\2\11\3\0\7\11\6\0\3\11\12\0\2\11\13\0\11\11\2\0\27\11\2\0\7\11\1\0\3"+
    "\11\1\0\4\11\1\0\4\11\2\0\6\11\3\0\1\11\1\0\1\11\2\0\5\11\1\0\12\11\12\0\5"+
    "\11\1\0\3\11\1\0\10\11\4\0\7\11\3\0\1\11\3\0\2\11\1\0\1\11\3\0\2\11\2\0\5"+
    "\11\2\0\1\11\1\0\1\11\30\0\3\11\3\0\6\11\2\0\6\11\2\0\6\11\11\0\7\11\4\0\5"+
    "\11\3\0\5\11\5\0\1\11\1\0\10\11\1\0\5\11\1\0\1\11\1\0\2\11\1\0\2\11\1\0\12"+
    "\11\6\0\12\11\2\0\6\11\2\0\6\11\2\0\6\11\2\0\3\11\3\0\14\11\1\0\16\11\1\0"+
    "\2\11\1\0\2\11\1\0\10\11\6\0\4\11\4\0\16\11\2\0\1\11\1\0\14\11\1\0\2\11\3"+
    "\0\1\11\2\0\4\11\1\0\2\11\12\0\10\11\6\0\6\11\1\0\3\11\1\0\12\11\3\0\1\11"+
    "\12\0\4\11\25\0\1\11\1\0\1\11\3\0\7\11\1\0\1\11\1\0\4\11\1\0\17\11\1\0\2\11"+
    "\14\0\3\11\7\0\4\11\11\0\2\11\1\0\1\11\20\0\4\11\10\0\1\11\13\0\10\11\5\0"+
    "\3\11\2\0\1\11\2\0\2\11\2\0\4\11\1\0\14\11\1\0\1\11\1\0\7\11\1\0\21\11\1\0"+
    "\4\11\2\0\10\11\1\0\7\11\1\0\14\11\1\0\4\11\1\0\5\11\1\0\1\11\3\0\14\11\2"+
    "\0\10\11\1\0\2\11\1\0\1\11\2\0\1\11\1\0\12\11\1\0\4\11\1\0\1\11\1\0\1\11\6"+
    "\0\1\11\4\0\1\11\1\0\1\11\1\0\1\11\1\0\3\11\1\0\2\11\1\0\1\11\2\0\1\11\1\0"+
    "\1\11\1\0\1\11\1\0\1\11\1\0\1\11\1\0\2\11\1\0\1\11\2\0\4\11\1\0\7\11\1\0\4"+
    "\11\1\0\4\11\1\0\1\11\1\0\12\11\1\0\5\11\1\0\3\11\1\0\5\11\1\0\5\11");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\2\3\1\4\1\5\6\6\1\7"+
    "\1\6\1\10\1\11\1\12\1\1\1\13\7\6\2\0"+
    "\7\6\1\14\22\6\1\15\21\6\1\16\27\6\1\17"+
    "\11\6\1\20\1\21\1\22\1\23\3\6\1\24\1\25"+
    "\5\6\1\26\1\27\1\30\1\31\5\6\1\32";

  private static int [] zzUnpackAction() {
    int [] result = new int[133];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\44\0\110\0\154\0\220\0\154\0\264\0\330"+
    "\0\374\0\u0120\0\u0144\0\u0168\0\u018c\0\u01b0\0\u01d4\0\u0120"+
    "\0\u01f8\0\u0120\0\u021c\0\u0240\0\u0264\0\u0288\0\u02ac\0\u02d0"+
    "\0\u02f4\0\u0318\0\u033c\0\u0360\0\u0384\0\u0264\0\u03a8\0\u03cc"+
    "\0\u03f0\0\u0414\0\u0438\0\u045c\0\u0480\0\u04a4\0\u04c8\0\u04ec"+
    "\0\u0510\0\u0534\0\u0558\0\u057c\0\u05a0\0\u05c4\0\u05e8\0\u060c"+
    "\0\u0630\0\u0654\0\u0678\0\u069c\0\u06c0\0\u06e4\0\u0708\0\u072c"+
    "\0\u0750\0\u0774\0\u0798\0\u07bc\0\u07e0\0\u0804\0\u0828\0\u084c"+
    "\0\u0870\0\u0894\0\u08b8\0\u08dc\0\u0900\0\u0924\0\u0948\0\u096c"+
    "\0\u0990\0\u09b4\0\u09d8\0\u0120\0\u09fc\0\u0a20\0\u0a44\0\u0a68"+
    "\0\u0a8c\0\u0ab0\0\u0ad4\0\u0af8\0\u0b1c\0\u0b40\0\u0b64\0\u0b88"+
    "\0\u0bac\0\u0bd0\0\u0bf4\0\u0c18\0\u0c3c\0\u0c60\0\u0c84\0\u0ca8"+
    "\0\u0ccc\0\u0cf0\0\u0d14\0\u0120\0\u0d38\0\u0d5c\0\u0d80\0\u0da4"+
    "\0\u0dc8\0\u0dec\0\u0e10\0\u0e34\0\u0e58\0\u0120\0\u0120\0\u0120"+
    "\0\u0120\0\u0e7c\0\u0ea0\0\u0ec4\0\u0120\0\u0ee8\0\u0f0c\0\u0f30"+
    "\0\u0f54\0\u0f78\0\u0f9c\0\u0120\0\u0120\0\u0120\0\u0120\0\u0fc0"+
    "\0\u0fe4\0\u1008\0\u102c\0\u1050\0\u0120";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[133];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\2\6\1\7\1\10\1\6\1\11\1\4"+
    "\1\12\1\4\1\12\1\4\1\13\1\12\1\14\1\15"+
    "\2\12\1\16\6\12\1\17\2\12\1\20\1\21\2\12"+
    "\1\22\2\12\1\23\1\24\1\23\2\4\1\23\1\4"+
    "\35\23\1\4\1\24\7\4\1\25\1\4\1\25\1\4"+
    "\27\25\45\0\1\5\2\6\1\7\1\0\1\6\40\0"+
    "\1\6\40\0\2\10\3\0\1\10\1\0\35\10\7\0"+
    "\1\11\1\26\42\0\1\12\2\0\2\12\1\0\27\12"+
    "\7\0\1\12\2\0\2\12\1\0\1\12\1\27\1\30"+
    "\24\12\7\0\1\12\2\0\2\12\1\0\6\12\1\31"+
    "\20\12\7\0\1\12\2\0\2\12\1\0\15\12\1\32"+
    "\11\12\7\0\1\12\2\0\2\12\1\0\3\12\1\33"+
    "\23\12\7\0\1\12\2\0\2\12\1\0\3\12\1\34"+
    "\23\12\7\0\1\12\2\0\2\12\1\0\23\12\1\35"+
    "\3\12\2\23\3\0\1\23\1\0\35\23\1\0\1\24"+
    "\51\0\1\36\2\0\2\36\1\37\27\36\7\0\1\26"+
    "\43\0\1\12\2\0\2\12\1\0\2\12\1\40\24\12"+
    "\7\0\1\12\2\0\2\12\1\0\13\12\1\41\13\12"+
    "\7\0\1\12\2\0\2\12\1\0\7\12\1\42\17\12"+
    "\7\0\1\12\2\0\2\12\1\0\11\12\1\43\15\12"+
    "\7\0\1\12\2\0\2\12\1\0\14\12\1\44\12\12"+
    "\7\0\1\12\2\0\2\12\1\0\4\12\1\45\22\12"+
    "\7\0\1\12\2\0\2\12\1\0\24\12\1\46\2\12"+
    "\11\0\1\47\1\0\1\47\1\0\27\47\7\0\1\12"+
    "\2\0\2\12\1\0\1\50\26\12\7\0\1\12\2\0"+
    "\2\12\1\0\5\12\1\51\21\12\7\0\1\12\2\0"+
    "\2\12\1\0\3\12\1\52\23\12\7\0\1\12\2\0"+
    "\1\53\1\12\1\0\27\12\7\0\1\12\2\0\2\12"+
    "\1\0\20\12\1\54\6\12\7\0\1\12\2\0\2\12"+
    "\1\0\16\12\1\55\10\12\7\0\1\12\2\0\2\12"+
    "\1\0\1\56\26\12\7\0\1\47\2\0\2\47\1\0"+
    "\27\47\7\0\1\12\2\0\2\12\1\0\3\12\1\57"+
    "\23\12\7\0\1\12\2\0\2\12\1\0\14\12\1\60"+
    "\12\12\7\0\1\12\2\0\2\12\1\0\10\12\1\61"+
    "\16\12\7\0\1\12\2\0\2\12\1\0\1\62\15\12"+
    "\1\63\2\12\1\64\5\12\7\0\1\12\2\0\2\12"+
    "\1\0\15\12\1\65\11\12\7\0\1\12\2\0\2\12"+
    "\1\0\2\12\1\66\24\12\7\0\1\12\2\0\2\12"+
    "\1\0\3\12\1\67\23\12\7\0\1\12\2\0\2\12"+
    "\1\0\1\12\1\70\25\12\7\0\1\12\2\0\2\12"+
    "\1\0\2\12\1\71\24\12\7\0\1\12\2\0\2\12"+
    "\1\0\4\12\1\72\22\12\7\0\1\12\2\0\2\12"+
    "\1\0\2\12\1\73\24\12\7\0\1\12\2\0\2\12"+
    "\1\0\20\12\1\74\6\12\7\0\1\12\2\0\2\12"+
    "\1\0\3\12\1\75\23\12\7\0\1\12\2\0\1\76"+
    "\1\12\1\0\27\12\7\0\1\12\2\0\2\12\1\0"+
    "\1\12\1\77\25\12\7\0\1\12\2\0\1\100\1\12"+
    "\1\0\27\12\7\0\1\12\2\0\2\12\1\0\4\12"+
    "\1\101\22\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\102\11\12\7\0\1\12\2\0\1\103\1\12\1\0"+
    "\27\12\7\0\1\12\2\0\2\12\1\0\13\12\1\104"+
    "\13\12\7\0\1\12\2\0\2\12\1\0\15\12\1\105"+
    "\11\12\7\0\1\12\2\0\2\12\1\0\14\12\1\106"+
    "\12\12\7\0\1\12\2\0\2\12\1\0\1\107\15\12"+
    "\1\110\2\12\1\111\5\12\7\0\1\12\2\0\2\12"+
    "\1\0\17\12\1\112\7\12\7\0\1\12\2\0\2\12"+
    "\1\0\1\113\26\12\7\0\1\12\2\0\2\12\1\0"+
    "\5\12\1\114\21\12\7\0\1\12\2\0\1\115\1\12"+
    "\1\0\27\12\7\0\1\12\2\0\2\12\1\0\11\12"+
    "\1\116\15\12\7\0\1\12\2\0\2\12\1\0\5\12"+
    "\1\117\21\12\7\0\1\12\2\0\2\12\1\0\11\12"+
    "\1\120\15\12\7\0\1\12\2\0\2\12\1\0\22\12"+
    "\1\121\4\12\7\0\1\12\2\0\2\12\1\0\2\12"+
    "\1\122\24\12\7\0\1\12\2\0\2\12\1\0\20\12"+
    "\1\123\6\12\7\0\1\12\2\0\2\12\1\0\3\12"+
    "\1\124\23\12\7\0\1\12\2\0\1\125\1\12\1\0"+
    "\27\12\7\0\1\12\2\0\2\12\1\0\2\12\1\126"+
    "\24\12\7\0\1\12\2\0\2\12\1\0\1\127\10\12"+
    "\1\130\15\12\7\0\1\12\2\0\2\12\1\0\3\12"+
    "\1\131\23\12\7\0\1\12\2\0\2\12\1\0\14\12"+
    "\1\132\12\12\7\0\1\12\2\0\2\12\1\0\20\12"+
    "\1\133\6\12\7\0\1\12\2\0\2\12\1\0\3\12"+
    "\1\134\23\12\7\0\1\12\2\0\2\12\1\0\13\12"+
    "\1\135\13\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\136\11\12\7\0\1\12\2\0\2\12\1\0\14\12"+
    "\1\137\12\12\7\0\1\12\2\0\2\12\1\0\11\12"+
    "\1\140\15\12\7\0\1\12\2\0\2\12\1\0\20\12"+
    "\1\141\6\12\7\0\1\12\2\0\2\12\1\0\2\12"+
    "\1\142\24\12\7\0\1\12\2\0\2\12\1\0\3\12"+
    "\1\143\23\12\7\0\1\12\2\0\2\12\1\0\12\12"+
    "\1\144\14\12\7\0\1\12\2\0\2\12\1\0\2\12"+
    "\1\145\24\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\146\11\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\147\11\12\7\0\1\12\2\0\2\12\1\0\5\12"+
    "\1\150\21\12\7\0\1\12\2\0\2\12\1\0\11\12"+
    "\1\151\15\12\7\0\1\12\2\0\2\12\1\0\22\12"+
    "\1\152\4\12\7\0\1\12\2\0\2\12\1\0\3\12"+
    "\1\153\23\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\154\11\12\7\0\1\12\2\0\2\12\1\0\20\12"+
    "\1\155\6\12\7\0\1\12\2\0\2\12\1\0\12\12"+
    "\1\156\14\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\157\11\12\7\0\1\12\2\0\2\12\1\0\14\12"+
    "\1\160\12\12\7\0\1\12\2\0\2\12\1\0\4\12"+
    "\1\161\22\12\7\0\1\12\2\0\2\12\1\0\14\12"+
    "\1\162\12\12\7\0\1\12\2\0\2\12\1\0\20\12"+
    "\1\163\6\12\7\0\1\12\2\0\2\12\1\0\3\12"+
    "\1\164\23\12\7\0\1\12\2\0\2\12\1\0\12\12"+
    "\1\165\14\12\7\0\1\12\2\0\2\12\1\0\4\12"+
    "\1\166\22\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\167\11\12\7\0\1\12\2\0\2\12\1\0\2\12"+
    "\1\170\24\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\171\11\12\7\0\1\12\2\0\2\12\1\0\15\12"+
    "\1\172\11\12\7\0\1\12\2\0\1\173\1\12\1\0"+
    "\27\12\7\0\1\12\2\0\2\12\1\0\4\12\1\174"+
    "\22\12\7\0\1\12\2\0\2\12\1\0\15\12\1\175"+
    "\11\12\7\0\1\12\2\0\2\12\1\0\14\12\1\176"+
    "\12\12\7\0\1\12\2\0\2\12\1\0\4\12\1\177"+
    "\22\12\7\0\1\12\2\0\2\12\1\0\10\12\1\200"+
    "\16\12\7\0\1\12\2\0\2\12\1\0\25\12\1\201"+
    "\1\12\7\0\1\12\2\0\2\12\1\0\1\12\1\202"+
    "\25\12\7\0\1\12\2\0\2\12\1\0\26\12\1\203"+
    "\7\0\1\12\2\0\2\12\1\0\3\12\1\204\23\12"+
    "\7\0\1\12\2\0\2\12\1\0\11\12\1\205\15\12";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4212];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\1\1\1\11\27\1\2\0\146\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[133];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _DSFLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _DSFLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 27: break;
          case 2: 
            { yybegin(YYINITIAL); return SPACE;
            } 
            // fall through
          case 28: break;
          case 3: 
            { yybegin(YYINITIAL); return EOL;
            } 
            // fall through
          case 29: break;
          case 4: 
            { yybegin(YYINITIAL); return COMMENT;
            } 
            // fall through
          case 30: break;
          case 5: 
            { yybegin(YYINITIAL); return INT_NUM;
            } 
            // fall through
          case 31: break;
          case 6: 
            { yybegin(YYINITIAL); return ID;
            } 
            // fall through
          case 32: break;
          case 7: 
            { yybegin(YYINITIAL); return I_KEYWORD;
            } 
            // fall through
          case 33: break;
          case 8: 
            { yybegin(YYINITIAL); return A_KEYWORD;
            } 
            // fall through
          case 34: break;
          case 9: 
            { yybegin(YYINITIAL); return VALUE_STRING;
            } 
            // fall through
          case 35: break;
          case 10: 
            { return SPACE;
            } 
            // fall through
          case 36: break;
          case 11: 
            { yybegin(YYINITIAL); return FLOAT_NUM;
            } 
            // fall through
          case 37: break;
          case 12: 
            { yybegin(WAITING_VALUE); return PROP_ID;
            } 
            // fall through
          case 38: break;
          case 13: 
            { yybegin(YYINITIAL); return OBJECT_KEYWORD;
            } 
            // fall through
          case 39: break;
          case 14: 
            { yybegin(WAITING_PROP); return PROPERTY_KEYWORD;
            } 
            // fall through
          case 40: break;
          case 15: 
            { yybegin(WAITING_VALUE); return OBJECT_DEF_KEYWORD;
            } 
            // fall through
          case 41: break;
          case 16: 
            { yybegin(WAITING_VALUE); return POLYGON_DEF_KEYWORD;
            } 
            // fall through
          case 42: break;
          case 17: 
            { yybegin(YYINITIAL); return END_POLYGON_KEYWORD;
            } 
            // fall through
          case 43: break;
          case 18: 
            { yybegin(YYINITIAL); return END_WINDING_KEYWORD;
            } 
            // fall through
          case 44: break;
          case 19: 
            { yybegin(YYINITIAL); return END_SEGMEN_KEYWORD;
            } 
            // fall through
          case 45: break;
          case 20: 
            { yybegin(WAITING_VALUE); return NETWORK_DEF_KEYWORD;
            } 
            // fall through
          case 46: break;
          case 21: 
            { yybegin(YYINITIAL); return SHAPE_POINT_KEYWORD;
            } 
            // fall through
          case 47: break;
          case 22: 
            { yybegin(YYINITIAL); return POLYGON_POINT_KEYWORD;
            } 
            // fall through
          case 48: break;
          case 23: 
            { yybegin(YYINITIAL); return BEGIN_POLYGON_KEYWORD;
            } 
            // fall through
          case 49: break;
          case 24: 
            { yybegin(YYINITIAL); return BEGIN_WINDING_KEYWORD;
            } 
            // fall through
          case 50: break;
          case 25: 
            { yybegin(YYINITIAL); return BEGIN_SEGMENT_KEYWORD;
            } 
            // fall through
          case 51: break;
          case 26: 
            { yybegin(YYINITIAL); return SHAPE_POINT_CURVED_KEYWORD;
            } 
            // fall through
          case 52: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
