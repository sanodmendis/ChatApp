package com.fyuxera.chatapp.component;

import com.fyuxera.chatapp.ui.ActiveStatus;
import com.fyuxera.chatapp.ui.ImageAvatar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Item_People extends javax.swing.JPanel {

    private boolean mouseOver;
    private final String userName;
    private final boolean online;

    public interface SelectionListener {
        void onSelected(Item_People item);
    }

    private SelectionListener selectionListener;

    public void setSelectionListener(SelectionListener listener) {
        this.selectionListener = listener;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isOnline() {
        return online;
    }

    public Item_People(String userName, boolean online) {
        this.userName = userName;
        this.online = online;
        initComponents();
        lb.setText(userName);
        activeStatus.setActive(online);
        init();
    }

    public void updateStatus(boolean active) {
        activeStatus.setActive(active);
    }

    private void init() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Fixed compact height — prevents BoxLayout from stretching items
        setPreferredSize(new Dimension(260, 48));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        setMinimumSize(new Dimension(0, 48));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(225, 228, 235));
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(242, 242, 242));
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (mouseOver && selectionListener != null) {
                    selectionListener.onSelected(Item_People.this);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.fyuxera.chatapp.ui.ImageAvatar();
        lb = new javax.swing.JLabel();
        activeStatus = new com.fyuxera.chatapp.ui.ActiveStatus();

        setBackground(new java.awt.Color(242, 242, 242));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(
                getClass().getResource("/icons/user.png")));

        lb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
        lb.setText("Name");

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lb, 0, 0, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lb)
            .addComponent(activeStatus, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fyuxera.chatapp.ui.ActiveStatus activeStatus;
    private com.fyuxera.chatapp.ui.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
