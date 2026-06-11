/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fyuxera.chatapp.ui.dialogs;

import com.fyuxera.chatapp.service.ContactService;
import com.google.gson.JsonObject;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class AddContact extends javax.swing.JFrame {

    private ContactService contactService;
    private Runnable onContactAdded;

    public AddContact() {
        this(null);
    }

    public AddContact(Runnable onContactAdded) {
        this.onContactAdded = onContactAdded;
        initComponents();
        setLocationRelativeTo(null);
        contactService = new ContactService();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add to Contacts");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Username");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String username = txtUsername.getText().trim();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a username", "Input Required",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        btnAdd.setEnabled(false);
        btnAdd.setText("Adding...");

        new Thread(() -> {
            try {
                JsonObject contact = contactService.addContact(username);

                java.awt.EventQueue.invokeLater(() -> {
                    if (contact != null) {
                        String fullName = contact.has("full_name")
                                ? contact.get("full_name").getAsString()
                                : username;
                        JOptionPane.showMessageDialog(this,
                                "Contact '" + fullName + "' added successfully!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        if (onContactAdded != null) {
                            onContactAdded.run();
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Failed to add contact. The user may not exist " +
                                "or is already your contact.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        btnAdd.setEnabled(true);
                        btnAdd.setText("Add");
                    }
                });
            } catch (Exception e) {
                java.awt.EventQueue.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this,
                            "Error: " + e.getMessage(),
                            "Connection Error", JOptionPane.ERROR_MESSAGE);
                    btnAdd.setEnabled(true);
                    btnAdd.setText("Add");
                });
            }
        }).start();
    }//GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
