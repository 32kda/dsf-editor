// This is a generated file. Not intended for manual editing.
package com.onpositive.dsfedit.language.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DSFSegment extends PsiElement {

  @Nullable
  DSFSegmentHeader getSegmentHeader();

  @NotNull
  List<DSFSegmentPoint> getSegmentPointList();

}
