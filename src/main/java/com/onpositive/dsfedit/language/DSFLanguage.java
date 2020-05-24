package com.onpositive.dsfedit.language;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class DSFLanguage extends Language {

    public static final DSFLanguage INSTANCE = new DSFLanguage();

    public DSFLanguage() {
        super("DSF");
    }


}
