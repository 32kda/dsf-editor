package com.onpositive.dsfedit.language.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.onpositive.dsfedit.language.parser.psi.DSFProperties;
import com.onpositive.dsfedit.language.parser.psi.DSFProperty;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DSFPropCompletionContributor extends CompletionContributor {

    private static List<String> SUPPORTED_PROPS = new ArrayList<>();

    static {
        SUPPORTED_PROPS.add("sim/north");
        SUPPORTED_PROPS.add("sim/south");
        SUPPORTED_PROPS.add("sim/east");
        SUPPORTED_PROPS.add("sim/west");
        SUPPORTED_PROPS.add("sim/planet");

        SUPPORTED_PROPS.add("sim/require_object");
        SUPPORTED_PROPS.add("sim/require_agp");
        SUPPORTED_PROPS.add("sim/require_facade");

        SUPPORTED_PROPS.add("sim/overlay");
        SUPPORTED_PROPS.add("sim/exclude_obj");
        SUPPORTED_PROPS.add("sim/exclude_fac");
        SUPPORTED_PROPS.add("sim/exclude_for");
        SUPPORTED_PROPS.add("sim/exclude_bch");
        SUPPORTED_PROPS.add("sim/exclude_net");
        SUPPORTED_PROPS.add("sim/exclude_lin");
        SUPPORTED_PROPS.add("sim/exclude_pol");
        SUPPORTED_PROPS.add("sim/exclude_str");

        SUPPORTED_PROPS.add("sim/creation_agent");
        SUPPORTED_PROPS.add("sim/internal_revision");
    }

    public DSFPropCompletionContributor() {
        super();
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withParent(DSFProperty.class),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        if (parameters.getPosition().getParent() instanceof DSFProperty) {
                            Set<String> existingProps = getExistingProps(parameters.getPosition().getParent().getParent());
                            for (String propId: SUPPORTED_PROPS) {
                                if (!existingProps.contains(propId)) {
                                    resultSet.addElement(LookupElementBuilder.create(propId));
                                }
                            }
                        }
                    }
                });
    }

    private Set<String> getExistingProps(PsiElement parent) {
        Set<String> existingIds = new HashSet<>();
        if (parent instanceof DSFProperties) {
            DSFProperties dsfProperties = (DSFProperties) parent;
            for (DSFProperty property: dsfProperties.getPropertyList()) {
                ASTNode propIdNode = property.getNode().findChildByType(DSFTypes.PROP_ID);
                if (propIdNode != null) {
                    existingIds.add(propIdNode.getText().trim());
                }
            }
        }
        return existingIds;
    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}
