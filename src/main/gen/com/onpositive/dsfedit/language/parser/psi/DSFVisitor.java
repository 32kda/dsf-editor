// This is a generated file. Not intended for manual editing.
package com.onpositive.dsfedit.language.parser.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.onpositive.dsfedit.language.psi.IDSFDefinition;
import com.onpositive.dsfedit.language.psi.DSFNamedElement;

public class DSFVisitor extends PsiElementVisitor {

  public void visitCurvedPoint(@NotNull DSFCurvedPoint o) {
    visitPsiElement(o);
  }

  public void visitDsfHeader(@NotNull DSFDsfHeader o) {
    visitPsiElement(o);
  }

  public void visitIntRef(@NotNull DSFIntRef o) {
    visitPsiElement(o);
  }

  public void visitNetworkDef(@NotNull DSFNetworkDef o) {
    visitIDSFDefinition(o);
  }

  public void visitNetworkDefs(@NotNull DSFNetworkDefs o) {
    visitPsiElement(o);
  }

  public void visitObject(@NotNull DSFObject o) {
    visitNamedElement(o);
  }

  public void visitObjectDef(@NotNull DSFObjectDef o) {
    visitIDSFDefinition(o);
  }

  public void visitObjectDefs(@NotNull DSFObjectDefs o) {
    visitPsiElement(o);
  }

  public void visitPolygon(@NotNull DSFPolygon o) {
    visitNamedElement(o);
  }

  public void visitPolygonDef(@NotNull DSFPolygonDef o) {
    visitIDSFDefinition(o);
  }

  public void visitPolygonDefs(@NotNull DSFPolygonDefs o) {
    visitPsiElement(o);
  }

  public void visitPolygonPoint(@NotNull DSFPolygonPoint o) {
    visitPsiElement(o);
  }

  public void visitPolygonWinding(@NotNull DSFPolygonWinding o) {
    visitPsiElement(o);
  }

  public void visitProperties(@NotNull DSFProperties o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull DSFProperty o) {
    visitPsiElement(o);
  }

  public void visitSegment(@NotNull DSFSegment o) {
    visitPsiElement(o);
  }

  public void visitSegmentHeader(@NotNull DSFSegmentHeader o) {
    visitPsiElement(o);
  }

  public void visitSegmentPoint(@NotNull DSFSegmentPoint o) {
    visitPsiElement(o);
  }

  public void visitSimplePoint(@NotNull DSFSimplePoint o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull DSFNamedElement o) {
    visitPsiElement(o);
  }

  public void visitIDSFDefinition(@NotNull IDSFDefinition o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
