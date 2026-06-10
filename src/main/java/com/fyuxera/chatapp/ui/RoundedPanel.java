package com.fyuxera.chatapp.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
    private int cornerRadius;
    private Color borderColor;
    private int borderWidth = 0;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }

    public RoundedPanel(int cornerRadius, Color background) {
        this.cornerRadius = cornerRadius;
        setBackground(background);
        setOpaque(false);
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }

    public void setBorder(int width, Color color) {
        this.borderWidth = width;
        this.borderColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        if (borderWidth > 0 && borderColor != null) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderWidth));
            g2.drawRoundRect(borderWidth / 2, borderWidth / 2, 
                           getWidth() - borderWidth, getHeight() - borderWidth, 
                           cornerRadius, cornerRadius);
        }

        g2.dispose();
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
