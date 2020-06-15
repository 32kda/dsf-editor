package com.onpositive.dsfedit.language.structure;

import com.intellij.icons.AllIcons;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.onpositive.dsfedit.language.DSFIcons;
import com.onpositive.dsfedit.language.parser.psi.*;
import com.onpositive.dsfedit.language.psi.DSFFile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DSFStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

    private final NavigatablePsiElement myElement;

    public DSFStructureViewElement(NavigatablePsiElement element) {
        this.myElement = element;
    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @Override
    public void navigate(boolean requestFocus) {
        myElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return myElement.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return myElement.canNavigateToSource();
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        String name = myElement.getName();
        return name != null ? name : "";
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        int length = myElement.getChildren().length;
        if (myElement instanceof DSFProperties) {
            return new PresentationData("Properties","("+((DSFProperties) myElement).getPropertyList().size()+")", AllIcons.FileTypes.Properties, null);
        }
        if (myElement instanceof DSFObjectDefs) {
            return new PresentationData("Object definitions","("+((DSFObjectDefs) myElement).getObjectDefList().size()+")", DSFIcons.OBJECT_DEF, null);
        }
        if (myElement instanceof DSFPolygonDefs) {
            return new PresentationData("Polygon definitions","("+((DSFPolygonDefs) myElement).getPolygonDefList().size()+")", DSFIcons.POLYGON_DEF, null);
        }
        if (myElement instanceof DSFPolygon) {
            return new PresentationData("Polygon","", DSFIcons.POLYGON, null);
        }
        if (myElement instanceof DSFSegment) {
            return new PresentationData("Segment","", DSFIcons.LINE, null);
        }

        ItemPresentation presentation = myElement.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        if (myElement instanceof DSFFile) {
            Collection<PsiElement> nodes = PsiTreeUtil.findChildrenOfAnyType(myElement, DSFProperties.class, DSFObjectDefs.class, DSFPolygonDefs.class, DSFSegment.class, DSFPolygon.class);

            List<TreeElement> treeElements = new ArrayList<>(nodes.size());
            for (PsiElement element: nodes) {
                treeElements.add(new DSFStructureViewElement((NavigatablePsiElement) element));
            }
            return treeElements.toArray(new TreeElement[0]);
        }
        return EMPTY_ARRAY;
    }

}
