package com.onpositive.dsfedit.language.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.wm.ex.WindowManagerEx;
import com.intellij.ui.awt.RelativePoint;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public abstract class AbstractPreviewAction extends AnAction {

    public AbstractPreviewAction(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text) {
        super(text);
    }

    protected abstract JComponent createPreviewComponent();

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        DataContext context = e.getDataContext();
        Component contextComponent = null;
        InputEvent inputEvent = e.getInputEvent();
        if (inputEvent instanceof MouseEvent) {
            contextComponent = inputEvent.getComponent();
        }

        Balloon balloon = JBPopupFactory.getInstance().createBalloonBuilder(createPreviewComponent())
                .setHideOnClickOutside(true)
                .setHideOnKeyOutside(true)
                .setFadeoutTime(2000)
                .setShowCallout(true)
                .createBalloon();

        this.showPopup(context, balloon, contextComponent);
    }

    protected void showPopup(DataContext context, Balloon popup, Component contextComponent) {
        Point point = new Point(0,0);
        Component focusedComponent = contextComponent != null ? contextComponent: (Component) PlatformDataKeys.CONTEXT_COMPONENT.getData(context);
        if (focusedComponent != null) {
            SwingUtilities.convertPointToScreen(point,focusedComponent);
        } else {
            focusedComponent = WindowManagerEx.getInstanceEx().getFocusedComponent((Project)null);
            Rectangle r = WindowManagerEx.getInstanceEx().getScreenBounds();
            int x = r.x + r.width / 2;
            int y = r.y + r.height / 2;
            point = new Point(x, y);
            SwingUtilities.convertPointToScreen(point, focusedComponent.getParent());
        }
        popup.show(RelativePoint.fromScreen(point), Balloon.Position.atRight);

    }
}
