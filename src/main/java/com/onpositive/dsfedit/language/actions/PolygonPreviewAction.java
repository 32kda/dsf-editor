package com.onpositive.dsfedit.language.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.openapi.wm.ex.WindowManagerEx;
import com.intellij.ui.JBColor;
import com.intellij.ui.awt.RelativePoint;
import com.intellij.ui.popup.PopupFactoryImpl;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.List;

public class PolygonPreviewAction extends AnAction {
    private List<Point2D> points;

    public PolygonPreviewAction(List<Point2D> points) {
        super("Preview polygon");
        if (points.size() < 2) {
            throw new IllegalArgumentException("Need at least two points for preview!");
        }
        this.points = points;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        DataContext context = e.getDataContext();
        Component contextComponent = null;
        InputEvent inputEvent = e.getInputEvent();
        if (inputEvent instanceof MouseEvent) {
            contextComponent = inputEvent.getComponent();
        }

        Balloon balloon = JBPopupFactory.getInstance().createBalloonBuilder(createCanvas())
                .setHideOnClickOutside(true)
                .setHideOnKeyOutside(true)
                .setFadeoutTime(2000)
                .setShowCallout(true)
                .createBalloon();

        this.showPopup(context, balloon, contextComponent);
    }

    protected void showPopup(DataContext context, Balloon popup, Component contextComponent) {
        Component focusedComponent = contextComponent != null ? contextComponent : (Component) PlatformDataKeys.CONTEXT_COMPONENT.getData(context);
        if (focusedComponent != null) {
            popup.show(new RelativePoint(focusedComponent, new Point(focusedComponent.getBounds().x,focusedComponent.getBounds().y)), Balloon.Position.above);
        } else {
            focusedComponent = WindowManagerEx.getInstanceEx().getFocusedComponent((Project)null);
            Rectangle r = WindowManagerEx.getInstanceEx().getScreenBounds();
            int x = r.x + r.width / 2;
            int y = r.y + r.height / 2;
            Point point = new Point(x, y);
            SwingUtilities.convertPointToScreen(point, focusedComponent.getParent());
            popup.show(RelativePoint.fromScreen(point), Balloon.Position.above);
        }

    }

    private JComponent createCanvas() {
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

//        canvas.setSize(256,256);
        canvas.setPreferredSize(new Dimension((int) Math.round(maxX), (int) Math.round(maxY)));
        return canvas;
    }
}
