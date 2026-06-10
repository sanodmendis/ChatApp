package com.fyuxera.chatapp.ui.dialogs;

import javax.swing.*;

/**
 * Progress Dialog - Shows progress during operations
 * @author Sanod
 */
public class ProgressDialog extends JDialog {
    
    private JLabel lblMessage;
    private JProgressBar progressBar;
    private JLabel lblStatus;
    private JPanel jPanel1;
    
    public ProgressDialog(JFrame parent) {
        super(parent, true);
        initComponents();
        setupDialog();
    }
    
    public ProgressDialog(JDialog parent) {
        super(parent, true);
        initComponents();
        setupDialog();
    }
    
    private void setupDialog() {
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Processing");
        setUndecorated(true);
        setSize(400, 150);
    }
    
    private void initComponents() {
        jPanel1 = new JPanel();
        lblMessage = new JLabel("Processing...");
        progressBar = new JProgressBar();
        lblStatus = new JLabel("Please wait...");
        
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        progressBar.setIndeterminate(true);
        
        lblMessage.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblMessage.setHorizontalAlignment(JLabel.CENTER);
        
        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblStatus.setHorizontalAlignment(JLabel.CENTER);
        
        GroupLayout layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup()
                    .addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblMessage)
                .addGap(10, 10, 10)
                .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblStatus)
                .addGap(15, 15, 15)
        );
        
        GroupLayout mainLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup()
                .addComponent(jPanel1)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup()
                .addComponent(jPanel1)
        );
    }
    
    public void setMessage(String message) {
        if (message != null) {
            lblMessage.setText(message);
        }
    }
    
    public void setStatus(String status) {
        if (status != null) {
            lblStatus.setText(status);
        }
    }
    
    public void setProgress(int percentage) {
        progressBar.setIndeterminate(false);
        progressBar.setValue(percentage);
    }
    
    public void closeDialog() {
        setVisible(false);
        dispose();
    }
}
