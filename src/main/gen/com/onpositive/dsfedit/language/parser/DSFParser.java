// This is a generated file. Not intended for manual editing.
package com.onpositive.dsfedit.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.onpositive.dsfedit.language.parser.psi.DSFTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class DSFParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return dsfFile(b, l + 1);
  }

  /* ********************************************************** */
  // float_num  float_num
  static boolean coords(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coords")) return false;
    if (!nextTokenIs(b, FLOAT_NUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FLOAT_NUM, FLOAT_NUM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'SHAPE_POINT_CURVED'  coords  float_num  coords  float_num eol
  public static boolean curved_point(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "curved_point")) return false;
    if (!nextTokenIs(b, SHAPE_POINT_CURVED_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHAPE_POINT_CURVED_KEYWORD);
    r = r && coords(b, l + 1);
    r = r && consumeToken(b, FLOAT_NUM);
    r = r && coords(b, l + 1);
    r = r && consumeTokens(b, 0, FLOAT_NUM, EOL);
    exit_section_(b, m, CURVED_POINT, r);
    return r;
  }

  /* ********************************************************** */
  // properties object_defs polygon_defs network_defs
  static boolean declarations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declarations")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = properties(b, l + 1);
    r = r && object_defs(b, l + 1);
    r = r && polygon_defs(b, l + 1);
    r = r && network_defs(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dsfHeader declarations entities
  static boolean dsfFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dsfFile")) return false;
    if (!nextTokenIs(b, "", A_KEYWORD, I_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dsfHeader(b, l + 1);
    r = r && declarations(b, l + 1);
    r = r && entities(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('I'|'A') eol int_num eol id eol
  public static boolean dsfHeader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dsfHeader")) return false;
    if (!nextTokenIs(b, "<dsf header>", A_KEYWORD, I_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DSF_HEADER, "<dsf header>");
    r = dsfHeader_0(b, l + 1);
    r = r && consumeTokens(b, 0, EOL, INT_NUM, EOL, ID, EOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'I'|'A'
  private static boolean dsfHeader_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dsfHeader_0")) return false;
    boolean r;
    r = consumeToken(b, I_KEYWORD);
    if (!r) r = consumeToken(b, A_KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // entity*
  static boolean entities(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entities")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entities", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // object | polygon | segment | eol
  public static boolean entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY, "<entity>");
    r = object(b, l + 1);
    if (!r) r = polygon(b, l + 1);
    if (!r) r = segment(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // comment | eol
  static boolean ignored(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignored")) return false;
    if (!nextTokenIs(b, "", COMMENT, EOL)) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // 'NETWORK_DEF'  value_string
  public static boolean network_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "network_def")) return false;
    if (!nextTokenIs(b, NETWORK_DEF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NETWORK_DEF_KEYWORD, VALUE_STRING);
    exit_section_(b, m, NETWORK_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // (network_def | ignored )*
  static boolean network_defs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "network_defs")) return false;
    while (true) {
      int c = current_position_(b);
      if (!network_defs_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "network_defs", c)) break;
    }
    return true;
  }

  // network_def | ignored
  private static boolean network_defs_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "network_defs_0")) return false;
    boolean r;
    r = network_def(b, l + 1);
    if (!r) r = ignored(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'OBJECT'  int_num  coords  float_num eol
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    if (!nextTokenIs(b, OBJECT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OBJECT_KEYWORD, INT_NUM);
    r = r && coords(b, l + 1);
    r = r && consumeTokens(b, 0, FLOAT_NUM, EOL);
    exit_section_(b, m, OBJECT, r);
    return r;
  }

  /* ********************************************************** */
  // 'OBJECT_DEF'  value_string
  public static boolean object_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_def")) return false;
    if (!nextTokenIs(b, OBJECT_DEF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OBJECT_DEF_KEYWORD, VALUE_STRING);
    exit_section_(b, m, OBJECT_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // (object_def | ignored )*
  static boolean object_defs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_defs")) return false;
    while (true) {
      int c = current_position_(b);
      if (!object_defs_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "object_defs", c)) break;
    }
    return true;
  }

  // object_def | ignored
  private static boolean object_defs_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_defs_0")) return false;
    boolean r;
    r = object_def(b, l + 1);
    if (!r) r = ignored(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'BEGIN_POLYGON'  polygon_header eol (polygon_winding)+ 'END_POLYGON' eol
  public static boolean polygon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon")) return false;
    if (!nextTokenIs(b, BEGIN_POLYGON_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGIN_POLYGON_KEYWORD);
    r = r && polygon_header(b, l + 1);
    r = r && consumeToken(b, EOL);
    r = r && polygon_3(b, l + 1);
    r = r && consumeTokens(b, 0, END_POLYGON_KEYWORD, EOL);
    exit_section_(b, m, POLYGON, r);
    return r;
  }

  // (polygon_winding)+
  private static boolean polygon_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = polygon_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!polygon_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "polygon_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (polygon_winding)
  private static boolean polygon_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = polygon_winding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'POLYGON_DEF'  value_string
  public static boolean polygon_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_def")) return false;
    if (!nextTokenIs(b, POLYGON_DEF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, POLYGON_DEF_KEYWORD, VALUE_STRING);
    exit_section_(b, m, POLYGON_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // (polygon_def | ignored )*
  static boolean polygon_defs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_defs")) return false;
    while (true) {
      int c = current_position_(b);
      if (!polygon_defs_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "polygon_defs", c)) break;
    }
    return true;
  }

  // polygon_def | ignored
  private static boolean polygon_defs_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_defs_0")) return false;
    boolean r;
    r = polygon_def(b, l + 1);
    if (!r) r = ignored(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // int_num  int_num  int_num
  public static boolean polygon_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_header")) return false;
    if (!nextTokenIs(b, INT_NUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INT_NUM, INT_NUM, INT_NUM);
    exit_section_(b, m, POLYGON_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // 'POLYGON_POINT'  coords eol
  public static boolean polygon_point(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_point")) return false;
    if (!nextTokenIs(b, POLYGON_POINT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POLYGON_POINT_KEYWORD);
    r = r && coords(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, POLYGON_POINT, r);
    return r;
  }

  /* ********************************************************** */
  // 'BEGIN_WINDING' eol polygon_point+ 'END_WINDING' eol
  public static boolean polygon_winding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_winding")) return false;
    if (!nextTokenIs(b, BEGIN_WINDING_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BEGIN_WINDING_KEYWORD, EOL);
    r = r && polygon_winding_2(b, l + 1);
    r = r && consumeTokens(b, 0, END_WINDING_KEYWORD, EOL);
    exit_section_(b, m, POLYGON_WINDING, r);
    return r;
  }

  // polygon_point+
  private static boolean polygon_winding_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_winding_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = polygon_point(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!polygon_point(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "polygon_winding_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (property | ignored) *
  static boolean properties(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "properties")) return false;
    while (true) {
      int c = current_position_(b);
      if (!properties_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "properties", c)) break;
    }
    return true;
  }

  // property | ignored
  private static boolean properties_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "properties_0")) return false;
    boolean r;
    r = property(b, l + 1);
    if (!r) r = ignored(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'PROPERTY' space? prop_id value_string
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, PROPERTY_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY_KEYWORD);
    r = r && property_1(b, l + 1);
    r = r && consumeTokens(b, 0, PROP_ID, VALUE_STRING);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  // space?
  private static boolean property_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_1")) return false;
    consumeToken(b, SPACE);
    return true;
  }

  /* ********************************************************** */
  // 'BEGIN_SEGMENT'  segment_header  segment_coords eol segment_point* 'END_SEGMENT'  int_num  segment_coords eol
  public static boolean segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment")) return false;
    if (!nextTokenIs(b, BEGIN_SEGMENT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGIN_SEGMENT_KEYWORD);
    r = r && segment_header(b, l + 1);
    r = r && segment_coords(b, l + 1);
    r = r && consumeToken(b, EOL);
    r = r && segment_4(b, l + 1);
    r = r && consumeTokens(b, 0, END_SEGMEN_KEYWORD, INT_NUM);
    r = r && segment_coords(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, SEGMENT, r);
    return r;
  }

  // segment_point*
  private static boolean segment_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!segment_point(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "segment_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // coords  float_num
  static boolean segment_coords(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_coords")) return false;
    if (!nextTokenIs(b, FLOAT_NUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = coords(b, l + 1);
    r = r && consumeToken(b, FLOAT_NUM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // int_num  int_num  int_num
  public static boolean segment_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_header")) return false;
    if (!nextTokenIs(b, INT_NUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INT_NUM, INT_NUM, INT_NUM);
    exit_section_(b, m, SEGMENT_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // simple_point | curved_point
  public static boolean segment_point(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_point")) return false;
    if (!nextTokenIs(b, "<segment point>", SHAPE_POINT_CURVED_KEYWORD, SHAPE_POINT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEGMENT_POINT, "<segment point>");
    r = simple_point(b, l + 1);
    if (!r) r = curved_point(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'SHAPE_POINT'  coords  float_num eol
  public static boolean simple_point(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_point")) return false;
    if (!nextTokenIs(b, SHAPE_POINT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHAPE_POINT_KEYWORD);
    r = r && coords(b, l + 1);
    r = r && consumeTokens(b, 0, FLOAT_NUM, EOL);
    exit_section_(b, m, SIMPLE_POINT, r);
    return r;
  }

}
