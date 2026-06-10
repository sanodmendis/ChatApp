package com.fyuxera.chatapp;

import javax.swing.UIManager;

public class ChatApp {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Initializing ChatApp...");
        System.out.println("REST API configured. Opening Login screen...");

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
