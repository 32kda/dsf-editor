package com.onpositive.dsfedit.language;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.util.io.ByteSequence;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DSFFileTypeDetector implements FileTypeRegistry.FileTypeDetector {
    @Override
    public @Nullable FileType detect(@NotNull VirtualFile file, @NotNull ByteSequence firstBytes, @Nullable CharSequence firstCharsIfText) {
        if (firstCharsIfText.length() > 10 && firstCharsIfText.charAt(0) == 'A' || firstCharsIfText.charAt(0) == 'I') {
            return DSFFileType.INSTANCE;
        }
        return null;
    }


    @Override
    public int getVersion() {
        return 0;
    }
}
