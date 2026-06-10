package com.fyuxera.chatapp.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Modern Notification Component
 * Used for displaying toast-like notifications
 */
public class ModernNotification extends JPanel {
    private String title;
    private String message;
    private NotificationType type;

    public enum NotificationType {
        SUCCESS(ModernColors.SUCCESS),
        ERROR(ModernColors.ERROR),
        WARNING(ModernColors.WARNING),
        INFO(ModernColors.INFO);

        private final Color color;

        NotificationType(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    public ModernNotification(String title, String message, NotificationType type) {
        this.title = title;
        this.message = message;
        this.type = type;

        setLayout(new BorderLayout(10, 5));
        setBorder(new EmptyBorder(12, 12, 12, 12));
        setBackground(ModernColors.BG_SECONDARY);
        setOpaque(true);

        // Icon
        JLabel iconLabel = new JLabel("●");
        iconLabel.setFont(new Font("Arial", Font.BOLD, 20));
        iconLabel.setForeground(type.getColor());

        // Text panel
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        titleLabel.setForeground(ModernColors.TEXT_PRIMARY);

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        messageLabel.setForeground(ModernColors.TEXT_SECONDARY);

        textPanel.add(titleLabel);
        textPanel.add(messageLabel);

        add(iconLabel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 80);
    }
}
