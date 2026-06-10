package com.fyuxera.chatapp;

import com.fyuxera.chatapp.core.auth.AuthManager;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Register extends javax.swing.JFrame {

    private AuthManager authManager;

    public Register() {
        initComponents();
        setLocationRelativeTo(null);
        authManager = AuthManager.getInstance();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSignin = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/app-icon.png")).getImage());
        setTitle("ChatApp - Register");
        setResizable(false);

        txtFname.setBackground(new java.awt.Color(235, 238, 245));
        txtFname.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtFname.setForeground(new java.awt.Color(30, 30, 30));

        txtLname.setBackground(new java.awt.Color(235, 238, 245));
        txtLname.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtLname.setForeground(new java.awt.Color(30, 30, 30));

        txtUsername.setBackground(new java.awt.Color(235, 238, 245));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtUsername.setForeground(new java.awt.Color(30, 30, 30));

        txtEmail.setBackground(new java.awt.Color(235, 238, 245));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtEmail.setForeground(new java.awt.Color(30, 30, 30));

        txtPassword.setBackground(new java.awt.Color(235, 238, 245));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtPassword.setForeground(new java.awt.Color(30, 30, 30));

        txtConfirmPass.setBackground(new java.awt.Color(235, 238, 245));
        txtConfirmPass.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtConfirmPass.setForeground(new java.awt.Color(30, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11));
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11));
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11));
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11));
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Email Address");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11));
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11));
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Confirm Password");

        jPanel1.setBackground(new java.awt.Color(70, 130, 180));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 32));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Join Us");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel8.setForeground(new java.awt.Color(200, 220, 240));
        jLabel8.setText("Start connecting today");

        jLabel9.setForeground(new java.awt.Color(200, 220, 240));
        jLabel9.setText("Already have an account?");

        btnSignin.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnSignin.setForeground(new java.awt.Color(70, 130, 180));
        btnSignin.setText("Sign In");
        btnSignin.setBorderPainted(false);
        btnSignin.setFocusPainted(false);
        btnSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigninActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(btnSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(btnSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCreate.setBackground(new java.awt.Color(70, 130, 180));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create Account");
        btnCreate.setBorderPainted(false);
        btnCreate.setFocusPainted(false);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 26));
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Create Account");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13));
        jLabel11.setForeground(new java.awt.Color(120, 120, 120));
        jLabel11.setText("Fill in the details to get started");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1)
                    .addComponent(txtFname, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtLname, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigninActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSigninActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        handleRegister();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void handleRegister() {
        String fn = txtFname.getText().trim();
        String ln = txtLname.getText().trim();
        String un = txtUsername.getText().trim();
        String em = txtEmail.getText().trim();
        String pwd = new String(txtPassword.getPassword());
        String conf = new String(txtConfirmPass.getPassword());

        if (fn.isEmpty() || ln.isEmpty() || un.isEmpty() || em.isEmpty() || pwd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (un.length() < 3) {
            JOptionPane.showMessageDialog(this, "Username must be at least 3 characters long", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!pwd.equals(conf)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String fullName = fn + " " + ln;
            boolean success = authManager.register(un, em, pwd, fullName);
            
            if (success) {
                JOptionPane.showMessageDialog(this,
                    "Registration successful!\nPlease login with your account.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                new Login().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Registration failed. Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Registration failed: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnSignin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
