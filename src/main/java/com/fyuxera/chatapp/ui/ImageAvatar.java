package com.fyuxera.chatapp.ui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImageAvatar extends JComponent {

    private Icon image;
    private int borderSize = 5;
    private Color borderColor = new Color(60, 60, 60);

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            int iw = image.getIconWidth();
            int ih = image.getIconHeight();
            int d = Math.min(iw, ih);

            BufferedImage mask = new BufferedImage(iw, ih, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = mask.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.fillOval(0, 0, d - 1, d - 1);
            g2d.dispose();

            BufferedImage masked = new BufferedImage(d, d, BufferedImage.TYPE_INT_ARGB);
            g2d = masked.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(toImage(image), (d - iw) / 2, (d - ih) / 2, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2d.drawImage(mask, 0, 0, null);
            g2d.dispose();

            Icon clipped = new ImageIcon(masked);
            Rectangle size = fitSize(clipped);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(toImage(clipped), size.x, size.y, size.width, size.height, null);

            if (borderSize > 0) {
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(borderColor);
                g2.setStroke(new BasicStroke(borderSize));
                g2.drawOval(size.x + (borderSize / 2), size.y + (borderSize / 2),
                        size.width - borderSize, size.height - borderSize);
            }
        }
        super.paint(g);
    }

    private Rectangle fitSize(Icon icon) {
        int cw = getWidth();
        int ch = getHeight();
        int iw = icon.getIconWidth();
        int ih = icon.getIconHeight();
        double sx = (double) cw / iw;
        double sy = (double) ch / ih;
        double s = Math.max(sx, sy);
        int w = (int) (s * iw);
        int h = (int) (s * ih);
        return new Rectangle(new Point((cw - w) / 2, (ch - h) / 2), new Dimension(w, h));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}
