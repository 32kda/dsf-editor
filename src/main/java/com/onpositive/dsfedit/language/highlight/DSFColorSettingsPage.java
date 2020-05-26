package com.onpositive.dsfedit.language.highlight;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.onpositive.dsfedit.language.DSFIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class DSFColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", DSFHighlighter.DSF_KEYWORD),
            new AttributesDescriptor("Number", DSFHighlighter.DSF_NUMBER),
            new AttributesDescriptor("Value String", DSFHighlighter.DSF_VALUE_STRING),
            new AttributesDescriptor("Comment", DSFHighlighter.DSF_COMMENT)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return DSFIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new DSFHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "I\n" +
                "800\n" +
                "DSF2TEXT\n" +
                "\n" +
                "# file: +54+082.dsf\n" +
                "\n" +
                "PROPERTY sim/planet earth\n" +
                "PROPERTY sim/overlay 1\n" +
                "PROPERTY sim/require_object 1/0\n" +
                "PROPERTY sim/require_facade 1/0\n" +
                "PROPERTY sim/exclude_obj 82.98137875/54.87219329/82.99038443/54.87937409";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "DSF";
    }

}
