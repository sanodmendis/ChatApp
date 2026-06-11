package com.fyuxera.chatapp.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class IconLoader {

    public static ImageIcon loadIcon(String name, int w, int h) {
        try {
            ImageIcon icon = new ImageIcon(IconLoader.class.getResource("/icons/" + name));
            Image scaled = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } catch (Exception e) {
            // Handle exception
            return null;
        }
    }

    public static ImageIcon loadIcon(String name) {
        try {
            return new ImageIcon(IconLoader.class.getResource("/icons/" + name));
        } catch (Exception e) {
            // Handle exception
            return null;
        }
    }

    public static ImageIcon tintedIcon(String name, int w, int h, Color tint) {
        try {
            ImageIcon icon = new ImageIcon(IconLoader.class.getResource("/icons/" + name));
            BufferedImage buf = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = buf.createGraphics();
            g.drawImage(icon.getImage(), 0, 0, w, h, null);
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    int argb = buf.getRGB(x, y);
                    int a = (argb >> 24) & 0xff;
                    if (a > 0) {
                        buf.setRGB(x, y, (a << 24) | (tint.getRGB() & 0xffffff));
                    }
                }
            }
            g.dispose();
            return new ImageIcon(buf);
        } catch (Exception e) {
            // Handle exception
            return null;
        }
    }
}
