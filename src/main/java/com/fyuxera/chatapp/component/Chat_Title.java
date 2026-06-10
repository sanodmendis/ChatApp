package com.fyuxera.chatapp.component;

import java.awt.Color;

public class Chat_Title extends javax.swing.JPanel {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public Chat_Title() {
        initComponents();
    }

    public void setUserName(String userName) {
        setUserName(userName, true);
    }

    public void setUserName(String userName, boolean online) {
        this.userId = userName;
        lbName.setText(userName);
        if (online) {
            statusActive();
        } else {
            setStatusText("Offline");
        }
    }

    public void updateUserStatus(boolean online) {
        if (online) {
            statusActive();
        } else {
            setStatusText("Offline");
        }
    }

    public void statusActive() {
        lbStatus.setText("Active now");
        lbStatus.setForeground(new Color(40, 147, 59));
    }

    public void setStatusText(String text) {
        lbStatus.setText(text);
        lbStatus.setForeground(new Color(160, 160, 160));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0,
                new java.awt.Color(220, 220, 220)));

        layer.setLayout(new java.awt.GridLayout(0, 1, 0, 2));

        lbName.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        lbName.setForeground(new java.awt.Color(30, 30, 30));
        lbName.setText("Select a contact");
        layer.add(lbName);

        lbStatus.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 11));
        lbStatus.setForeground(new java.awt.Color(40, 147, 59));
        lbStatus.setText("Choose a contact to start chatting");
        layer.add(lbStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(layer, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
