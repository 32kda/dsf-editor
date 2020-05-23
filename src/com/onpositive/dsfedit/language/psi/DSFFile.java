package com.onpositive.dsfedit.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.onpositive.dsfedit.language.DSFFileType;
import com.onpositive.dsfedit.language.DSFLanguage;
import org.jetbrains.annotations.NotNull;

public class DSFFile extends PsiFileBase {

    protected DSFFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, DSFLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return DSFFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "DSF file";
    }
}
