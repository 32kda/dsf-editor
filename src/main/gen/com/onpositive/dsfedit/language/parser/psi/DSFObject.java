// This is a generated file. Not intended for manual editing.
package com.onpositive.dsfedit.language.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.onpositive.dsfedit.language.psi.DSFNamedElement;
import com.intellij.psi.PsiReference;

public interface DSFObject extends DSFNamedElement {

  @NotNull
  DSFIntRef getIntRef();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  PsiReference[] getReferences();

}
