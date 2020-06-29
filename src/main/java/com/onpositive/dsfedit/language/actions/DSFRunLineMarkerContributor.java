package com.onpositive.dsfedit.language.actions;

import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonPoint;
import com.onpositive.dsfedit.language.parser.psi.DSFPolygonWinding;
import com.onpositive.dsfedit.language.parser.psi.DSFTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DSFRunLineMarkerContributor extends RunLineMarkerContributor {
    @Override
    public @Nullable Info getInfo(@NotNull PsiElement element) {
        if (element instanceof DSFPolygonWinding) {
            List<DSFPolygonPoint> polygonPointList = ((DSFPolygonWinding) element).getPolygonPointList();
            List<Point2D> points = new ArrayList<>();
            for (DSFPolygonPoint point: polygonPointList) {
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
            if (points.size() < 2 || points.stream().anyMatch(curPoint -> curPoint == null)) {
                return null;
            }
            points = reScale(points);
            return new Info(IconLoader.getIcon("/icons/preview-16.png"), null, new PolygonPreviewAction(points));
        }
        return null;
    }

    private List<Point2D> reScale(List<Point2D> points) {
        Point2D pt0 = points.get(0);
        double factor = Math.cos(pt0.getY());
        double minX = points.stream().mapToDouble(Point2D::getX).min().getAsDouble();
        double minY = points.stream().mapToDouble(Point2D::getY).min().getAsDouble();
        double maxX = points.stream().mapToDouble(Point2D::getX).max().getAsDouble();
        double maxY = points.stream().mapToDouble(Point2D::getY).max().getAsDouble();

        double size = 256;

        double multiplier = Math.min(size / (maxY - minY), size / (maxX - minX));

        return points.stream()
                .map(pt -> new Point2D.Double((pt.getX() - minX) * multiplier, (pt.getY() - minY) / factor * multiplier))
                .collect(Collectors.toList());
    }

    private Point2D parsePoint(String text) {
        String[] splitted = text.trim().split(" ");
        if (splitted.length >1) {
            try {
                double lat = Double.parseDouble(splitted[0].trim());
                double lon = Double.parseDouble(splitted[1].trim());
                return new Point2D.Double(lon,lat);
            } catch (NumberFormatException e) {
                //Best effort
            }
        }
        return null;
    }
}
