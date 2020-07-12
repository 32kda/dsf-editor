package com.onpositive.dsfedit.language.actions;

import com.intellij.ui.JBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class PolygonPreviewAction extends AbstractPreviewAction {
    private List<Point2D> points;

    public PolygonPreviewAction(List<Point2D> points) {
        super("Preview polygon");
        if (points.size() < 2) {
            throw new IllegalArgumentException("Need at least two points for preview!");
        }
        this.points = points;
    }

    @Override
    protected JComponent createPreviewComponent() {
        JPanel canvas = new JPanel() {
            @Override
            public void paint(Graphics g) {
                Graphics2D graphic2d = (Graphics2D) g;
                graphic2d.setColor(JBColor.ORANGE);
                Polygon polygon = new Polygon();
                for (Point2D point2D: points) {
                    polygon.addPoint((int) point2D.getX(),
                            (int) point2D.getY());
                }
                graphic2d.setStroke(new BasicStroke(3));
                graphic2d.draw(polygon);
            }
        };
        double maxX = points.stream().mapToDouble(Point2D::getX).max().getAsDouble();
        double maxY = points.stream().mapToDouble(Point2D::getY).max().getAsDouble();

        canvas.setPreferredSize(new Dimension((int) Math.round(maxX), (int) Math.round(maxY)));
        return canvas;
    }

}
