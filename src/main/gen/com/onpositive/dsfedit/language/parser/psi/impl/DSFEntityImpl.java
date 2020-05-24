// This is a generated file. Not intended for manual editing.
package com.onpositive.dsfedit.language.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.onpositive.dsfedit.language.parser.psi.DSFTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.onpositive.dsfedit.language.parser.psi.*;

public class DSFEntityImpl extends ASTWrapperPsiElement implements DSFEntity {

  public DSFEntityImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull DSFVisitor visitor) {
    visitor.visitEntity(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DSFVisitor) accept((DSFVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DSFObject getObject() {
    return findChildByClass(DSFObject.class);
  }

  @Override
  @Nullable
  public DSFPolygon getPolygon() {
    return findChildByClass(DSFPolygon.class);
  }

  @Override
  @Nullable
  public DSFSegment getSegment() {
    return findChildByClass(DSFSegment.class);
  }

}
