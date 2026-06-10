package com.fyuxera.chatapp.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI extends BasicScrollBarUI {

    private static final int ALPHA_NORMAL = 50;
    private static final int ALPHA_ROLLOVER = 100;
    private static final int THUMB_SIZE = 8;
    private static final Color THUMB_COLOR = Color.BLACK;

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return button();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return button();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle bounds) {
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle bounds) {
        int alpha = isThumbRollover() ? ALPHA_ROLLOVER : ALPHA_NORMAL;
        boolean vertical = scrollbar.getOrientation() == JScrollBar.VERTICAL;
        int x = bounds.x;
        int y = bounds.y;
        int w = vertical ? THUMB_SIZE : Math.max(bounds.width, THUMB_SIZE);
        int h = vertical ? Math.max(bounds.height, THUMB_SIZE) : THUMB_SIZE;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
        g2.fillRect(x, y, w, h);
        g2.dispose();
    }

    private static JButton button() {
        JButton b = new JButton();
        b.setOpaque(false);
        b.setFocusable(false);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder());
        return b;
    }
}
