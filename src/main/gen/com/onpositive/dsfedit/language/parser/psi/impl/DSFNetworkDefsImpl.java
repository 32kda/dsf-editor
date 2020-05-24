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

public class DSFNetworkDefsImpl extends ASTWrapperPsiElement implements DSFNetworkDefs {

  public DSFNetworkDefsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull DSFVisitor visitor) {
    visitor.visitNetworkDefs(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DSFVisitor) accept((DSFVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DSFIgnored> getIgnoredList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DSFIgnored.class);
  }

}
