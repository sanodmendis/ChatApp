package com.fyuxera.chatapp.ui;

import java.awt.Color;

public final class ModernColors {

    public static final Color PRIMARY_BLUE = new Color(70, 130, 180);
    public static final Color PRIMARY_BLUE_DARK = new Color(50, 110, 160);
    public static final Color PRIMARY_BLUE_LIGHT = new Color(100, 160, 210);

    public static final Color BG_PRIMARY = new Color(245, 248, 250);
    public static final Color BG_SECONDARY = new Color(255, 255, 255);
    public static final Color BG_HOVER = new Color(240, 245, 250);

    public static final Color TEXT_PRIMARY = new Color(30, 40, 50);
    public static final Color TEXT_SECONDARY = new Color(100, 120, 140);
    public static final Color TEXT_HINT = new Color(150, 160, 170);

    public static final Color SUCCESS = new Color(76, 175, 80);
    public static final Color ERROR = new Color(244, 67, 54);
    public static final Color WARNING = new Color(255, 152, 0);
    public static final Color INFO = new Color(33, 150, 243);

    public static final Color SENT_MESSAGE_BG = new Color(70, 130, 180);
    public static final Color RECEIVED_MESSAGE_BG = new Color(230, 240, 250);
    public static final Color SENT_MESSAGE_TEXT = Color.WHITE;
    public static final Color RECEIVED_MESSAGE_TEXT = new Color(30, 40, 50);

    public static final Color BORDER_LIGHT = new Color(220, 230, 240);
    public static final Color BORDER_MEDIUM = new Color(180, 200, 220);
    public static final Color BORDER_DARK = new Color(100, 120, 140);

    public static final Color ACCENT_GREEN = new Color(76, 175, 80);
    public static final Color ACCENT_ORANGE = new Color(255, 152, 0);

    private ModernColors() {
    }

    public static Color withAlpha(Color c, int alpha) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
    }
}
