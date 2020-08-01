package com.onpositive.dsfedit.language.actions;

import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.onpositive.dsfedit.facades.FacadesHelper;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonPoint;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonWinding;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import com.onpositive.dsfedit.language.psi.IDSFDefinition;
import com.onpositive.dsfedit.util.FilePathUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DSFRunLineMarkerContributor extends RunLineMarkerContributor {

    public static final double DEG_TO_RAD = 0.01745329252;

    @Override
    public @Nullable Info getInfo(@NotNull PsiElement element) {
        if (element.getNode().getElementType() == DSFTypes.BEGIN_WINDING_KEYWORD) {
            List<DSFPolygonPoint> polygonPointList = ((DSFPolygonWinding) element.getParent()).getPolygonPointList();
            List<Point2D> points = new ArrayList<>();
            for (DSFPolygonPoint point : polygonPointList) {
                @NotNull ASTNode[] astNodes = point.getNode().getChildren(TokenSet.create(DSFTypes.FLOAT_NUM));
                if (astNodes.length == 2) {
                    try {
                        double lon = Double.parseDouble(astNodes[0].getText());
                        double lat = Double.parseDouble(astNodes[1].getText());
                        points.add(new Point2D.Double(lon, lat));
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            }
            if (points.size() < 2 || points.stream().anyMatch(Objects::isNull)) {
                return null;
            }
            points = reScale(points);
            return new Info(IconLoader.getIcon("/icons/preview-16.png"), null, new PolygonPreviewAction(points));
        } else if (element.getNode().getElementType() == DSFTypes.POLYGON_DEF_KEYWORD) {
            File linkedFile = FilePathUtil.getLinkedFile((IDSFDefinition) element.getParent());
            if (linkedFile != null) {
                Image previewImage = FacadesHelper.getPreviewImage(linkedFile);
                if (previewImage != null) {
                    return new Info(IconLoader.getIcon("/icons/preview-16.png"), null, new FacadePreviewAction(previewImage));
                }
            }
        }
        return null;
    }

    private List<Point2D> reScale(List<Point2D> points) {
        Point2D pt0 = points.get(0);
        double factor = Math.abs(Math.cos(pt0.getY() * DEG_TO_RAD));
        double minX = points.stream().mapToDouble(Point2D::getX).min().getAsDouble();
        double minY = points.stream().mapToDouble(Point2D::getY).min().getAsDouble();
        double maxX = points.stream().mapToDouble(Point2D::getX).max().getAsDouble();
        double maxY = points.stream().mapToDouble(Point2D::getY).max().getAsDouble();

        double size = 256;

        double multiplier = Math.min(size / Math.abs(maxY - minY), size / (Math.abs(maxX - minX) * factor));

        return points.stream()
                .map(pt -> new Point2D.Double((pt.getX() - minX) * factor * multiplier, (maxY - pt.getY()) * multiplier))
                .collect(Collectors.toList());
    }

}
