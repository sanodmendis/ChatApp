package com.fyuxera.chatapp.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class PictureBox extends JLayeredPane {

    private Icon image;

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image != null) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle r = fit(image);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(toImage(image), r.x, r.y, r.width, r.height, null);
        }
        super.paintComponent(g);
    }

    private Rectangle fit(Icon icon) {
        int cw = getWidth();
        int ch = getHeight();
        int iw = icon.getIconWidth();
        int ih = icon.getIconHeight();
        cw = Math.min(cw, iw);
        ch = Math.min(ch, ih);
        double sx = (double) cw / iw;
        double sy = (double) ch / ih;
        double s = Math.min(sx, sy);
        int w = (int) (s * iw);
        int h = (int) (s * ih);
        return new Rectangle(new Point((getWidth() - w) / 2, (getHeight() - h) / 2), new Dimension(w, h));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}
