package com.onpositive.dsfedit.language.psi;

import com.intellij.psi.tree.IElementType;
import com.onpositive.dsfedit.language.DSFLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class DSFElementType extends IElementType {

    public DSFElementType(@NotNull @NonNls String debugName){
        super(debugName, DSFLanguage.INSTANCE);
    }

}
