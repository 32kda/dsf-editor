// This is a generated file. Not intended for manual editing.
package com.onpositive.dsfedit.language.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.onpositive.dsfedit.language.psi.DSFElementType;
import com.onpositive.dsfedit.language.psi.DSFTokenType;
import com.onpositive.dsfedit.language.parser.psi.impl.*;

public interface DSFTypes {

  IElementType COORDS = new DSFElementType("COORDS");
  IElementType CURVED_POINT = new DSFElementType("CURVED_POINT");
  IElementType DECLARATIONS = new DSFElementType("DECLARATIONS");
  IElementType DSF_HEADER = new DSFElementType("DSF_HEADER");
  IElementType ENTITY = new DSFElementType("ENTITY");
  IElementType IGNORED = new DSFElementType("IGNORED");
  IElementType NETWORK_DEFS = new DSFElementType("NETWORK_DEFS");
  IElementType OBJECT = new DSFElementType("OBJECT");
  IElementType OBJECT_DEFS = new DSFElementType("OBJECT_DEFS");
  IElementType POLYGON = new DSFElementType("POLYGON");
  IElementType POLYGON_DEFS = new DSFElementType("POLYGON_DEFS");
  IElementType POLYGON_HEADER = new DSFElementType("POLYGON_HEADER");
  IElementType POLYGON_POINT = new DSFElementType("POLYGON_POINT");
  IElementType POLYGON_WINDING = new DSFElementType("POLYGON_WINDING");
  IElementType PROPERTIES = new DSFElementType("PROPERTIES");
  IElementType PROPERTY = new DSFElementType("PROPERTY");
  IElementType SEGMENT = new DSFElementType("SEGMENT");
  IElementType SEGMENT_COORDS = new DSFElementType("SEGMENT_COORDS");
  IElementType SEGMENT_HEADER = new DSFElementType("SEGMENT_HEADER");
  IElementType SEGMENT_POINT = new DSFElementType("SEGMENT_POINT");
  IElementType SIMPLE_POINT = new DSFElementType("SIMPLE_POINT");

  IElementType A_KEYWORD = new DSFTokenType("A");
  IElementType BEGIN_POLYGON_KEYWORD = new DSFTokenType("BEGIN_POLYGON");
  IElementType BEGIN_SEGMENT_KEYWORD = new DSFTokenType("BEGIN_SEGMENT");
  IElementType BEGIN_WINDING_KEYWORD = new DSFTokenType("BEGIN_WINDING");
  IElementType COMMENT = new DSFTokenType("comment");
  IElementType END_POLYGON_KEYWORD = new DSFTokenType("END_POLYGON");
  IElementType END_SEGMEN_KEYWORD = new DSFTokenType("END_SEGMENT");
  IElementType END_WINDING_KEYWORD = new DSFTokenType("END_WINDING");
  IElementType EOL = new DSFTokenType("eol");
  IElementType FLOAT_NUM = new DSFTokenType("float_num");
  IElementType ID = new DSFTokenType("id");
  IElementType INT_NUM = new DSFTokenType("int_num");
  IElementType I_KEYWORD = new DSFTokenType("I");
  IElementType NETWORK_DEF_KEYWORD = new DSFTokenType("NETWORK_DEF");
  IElementType OBJECT_DEF_KEYWORD = new DSFTokenType("OBJECT_DEF");
  IElementType OBJECT_KEYWORD = new DSFTokenType("OBJECT");
  IElementType POLYGON_DEF_KEYWORD = new DSFTokenType("POLYGON_DEF");
  IElementType POLYGON_POINT_KEYWORD = new DSFTokenType("POLYGON_POINT");
  IElementType PROPERTY_KEYWORD = new DSFTokenType("PROPERTY");
  IElementType PROP_ID = new DSFTokenType("prop_id");
  IElementType SHAPE_POINT_CURVED_KEYWORD = new DSFTokenType("SHAPE_POINT_CURVED");
  IElementType SHAPE_POINT_KEYWORD = new DSFTokenType("SHAPE_POINT");
  IElementType SPACE = new DSFTokenType("space");
  IElementType VALUE_STRING = new DSFTokenType("value_string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COORDS) {
        return new DSFCoordsImpl(node);
      }
      else if (type == CURVED_POINT) {
        return new DSFCurvedPointImpl(node);
      }
      else if (type == DECLARATIONS) {
        return new DSFDeclarationsImpl(node);
      }
      else if (type == DSF_HEADER) {
        return new DSFDsfHeaderImpl(node);
      }
      else if (type == ENTITY) {
        return new DSFEntityImpl(node);
      }
      else if (type == IGNORED) {
        return new DSFIgnoredImpl(node);
      }
      else if (type == NETWORK_DEFS) {
        return new DSFNetworkDefsImpl(node);
      }
      else if (type == OBJECT) {
        return new DSFObjectImpl(node);
      }
      else if (type == OBJECT_DEFS) {
        return new DSFObjectDefsImpl(node);
      }
      else if (type == POLYGON) {
        return new DSFPolygonImpl(node);
      }
      else if (type == POLYGON_DEFS) {
        return new DSFPolygonDefsImpl(node);
      }
      else if (type == POLYGON_HEADER) {
        return new DSFPolygonHeaderImpl(node);
      }
      else if (type == POLYGON_POINT) {
        return new DSFPolygonPointImpl(node);
      }
      else if (type == POLYGON_WINDING) {
        return new DSFPolygonWindingImpl(node);
      }
      else if (type == PROPERTIES) {
        return new DSFPropertiesImpl(node);
      }
      else if (type == PROPERTY) {
        return new DSFPropertyImpl(node);
      }
      else if (type == SEGMENT) {
        return new DSFSegmentImpl(node);
      }
      else if (type == SEGMENT_COORDS) {
        return new DSFSegmentCoordsImpl(node);
      }
      else if (type == SEGMENT_HEADER) {
        return new DSFSegmentHeaderImpl(node);
      }
      else if (type == SEGMENT_POINT) {
        return new DSFSegmentPointImpl(node);
      }
      else if (type == SIMPLE_POINT) {
        return new DSFSimplePointImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
