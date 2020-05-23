package com.onpositive.dsfedit.language.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.onpositive.dsfedit.language.DSFLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DSFTokenType extends IElementType {
    public DSFTokenType(@NotNull String debugName) {
        super(debugName, DSFLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "DSFTokenType." + super.toString();
    }
}
