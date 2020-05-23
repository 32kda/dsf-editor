package com.onpositive.dsfedit.language;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DSFFileType extends LanguageFileType {

    public static final DSFFileType INSTANCE = new DSFFileType();

    public DSFFileType() {
        super(DSFLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "DSF Source";
    }

    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    @Override
    public String getDescription() {
        return "X-Plane DSF file source";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "txt";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return DSFIcons.FILE;
    }
}
