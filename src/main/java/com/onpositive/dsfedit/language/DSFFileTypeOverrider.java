package com.onpositive.dsfedit.language;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.impl.FileTypeOverrider;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DSFFileTypeOverrider implements FileTypeOverrider {

    final int MAX_CAPACITY = 200;
    Map<String, Boolean> typeCache = new LinkedHashMap<String, Boolean>(MAX_CAPACITY, 0.75f, true){
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_CAPACITY;
        }
    };

    @Override
    public @Nullable FileType getOverriddenFileType(@NotNull VirtualFile file) {
        if ("txt".equalsIgnoreCase(file.getExtension())) {
            Boolean isDSF = typeCache.get(file.getPath());
            if (isDSF == null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                    List<String> list = new ArrayList<>();
                    int i = 0;
                    while (reader.ready() && i < 3) {
                        String line = reader.readLine().trim();
                        if (!line.isEmpty()) {
                            list.add(line);
                            i++;
                        }
                    }
                    isDSF = list.size() >= 3;
                    if (isDSF) { //Check further only if we have 3 lines
                        if (!"I".equals(list.get(0)) && !("A".equals(list.get(0)))) {
                            isDSF = false;
                        }
                        try {
                            Integer.parseInt(list.get(1));
                        } catch (NumberFormatException e) {
                            isDSF = false;
                        }
                        if (!list.get(2).startsWith("DSF")) {
                            isDSF = false;
                        }
                    }
                    typeCache.put(file.getPath(), isDSF);
                } catch (IOException e) {
                    Logger.getInstance(getClass()).error(e);
                    return null;
                }
            }
            return isDSF ? DSFFileType.INSTANCE : null;
        }
        return null;
    }
}
