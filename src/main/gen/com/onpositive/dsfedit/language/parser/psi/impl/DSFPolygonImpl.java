// This is a generated file. Not intended for manual editing.
package com.onpositive.dsfedit.language.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.onpositive.dsfedit.language.parser.psi.DSFTypes.*;
import com.onpositive.dsfedit.language.psi.impl.DSFNamedElementImpl;
import com.onpositive.dsfedit.language.parser.psi.*;
import com.onpositive.dsfedit.language.psi.impl.DSFPsiUtil;
import com.intellij.psi.PsiReference;

public class DSFPolygonImpl extends DSFNamedElementImpl implements DSFPolygon {

  public DSFPolygonImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull DSFVisitor visitor) {
    visitor.visitPolygon(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DSFVisitor) accept((DSFVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DSFIntRef getIntRef() {
    return findNotNullChildByClass(DSFIntRef.class);
  }

  @Override
  @NotNull
  public List<DSFPolygonWinding> getPolygonWindingList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DSFPolygonWinding.class);
  }

  @Override
  public String getName() {
    return DSFPsiUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return DSFPsiUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return DSFPsiUtil.getNameIdentifier(this);
  }

  @Override
  public PsiReference[] getReferences() {
    return DSFPsiUtil.getReferences(this);
  }

}
