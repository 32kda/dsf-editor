package com.onpositive.dsfedit.language.actions;

import javax.swing.*;
import java.awt.*;

public class FacadePreviewAction extends AbstractPreviewAction  {
    public static final Dimension MAX_SIZE = new Dimension(256, 256);
    private final Image previewImage;

    public FacadePreviewAction(Image previewImage) {
        super("Preview Facade");
        this.previewImage = previewImage;
    }

    @Override
    protected JComponent createPreviewComponent() {

        Dimension originalSize = new Dimension(previewImage.getWidth(null), previewImage.getHeight(null));
        Dimension scaledDimension = getScaledDimension(originalSize, MAX_SIZE);
        JPanel canvas = new JPanel() {
            @Override
            public void paint(Graphics g) {
                Graphics2D graphic2d = (Graphics2D) g;
                graphic2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                graphic2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                graphic2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphic2d.drawImage(previewImage,0,0,originalSize.width,originalSize.height,0,0,scaledDimension.width,scaledDimension.height,Color.YELLOW, null);
            }
        };
        canvas.setPreferredSize(scaledDimension);
        return canvas;
    }

    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int originalWidth = imgSize.width;
        int originalHeight = imgSize.height;
        int boundWidth = boundary.width;
        int boundHeight = boundary.height;
        int newWidth = originalWidth;
        int newHeight = originalHeight;

        // first check if we need to scale width
        if (originalWidth > boundWidth) {
            //scale width to fit
            newWidth = boundWidth;
            //scale height to maintain aspect ratio
            newHeight = (newWidth * originalHeight) / originalWidth;
        }

        // then check if we need to scale even with the new height
        if (newHeight > boundHeight) {
            //scale height to fit instead
            newHeight = boundHeight;
            //scale width to maintain aspect ratio
            newWidth = (newHeight * originalWidth) / originalHeight;
        }

        return new Dimension(newWidth, newHeight);
    }
}
