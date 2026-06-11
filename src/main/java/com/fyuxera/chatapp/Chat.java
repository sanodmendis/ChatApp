package com.fyuxera.chatapp;

import com.fyuxera.chatapp.component.Chat_Body;
import com.fyuxera.chatapp.component.Chat_Bottom;
import com.fyuxera.chatapp.component.Chat_Title;
import com.fyuxera.chatapp.component.Item_People;
import com.fyuxera.chatapp.service.UserService;
import com.fyuxera.chatapp.service.ContactService;
import com.fyuxera.chatapp.service.MessageService;
import com.fyuxera.chatapp.model.User;
import com.fyuxera.chatapp.model.Message;
import com.fyuxera.chatapp.core.session.SessionManager;
import com.fyuxera.chatapp.api.RestApiClient;
import com.fyuxera.chatapp.ui.ScrollBar;
import com.fyuxera.chatapp.ui.dialogs.AddContact;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;

public class Chat extends javax.swing.JFrame {

    private UserService userService;
    private ContactService contactService;
    private MessageService messageService;
    private int selectedContactId = -1;
    private String selectedContactName = "";
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private int editingMessageId = -1;
    private Chat_RightAdapter editingComponent;

    public Chat() {
        initComponents();
        initCustomComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        userService = new UserService();
        contactService = new ContactService();
        messageService = new MessageService();
        setupForm();
    }

    public void showFrame() {
        setVisible(true);
    }

    private void initCustomComponents() {
        chatBody = new Chat_Body();
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(chatBody, java.awt.BorderLayout.CENTER);
        menuList.setLayout(new BoxLayout(menuList, BoxLayout.Y_AXIS));
    }

    private void setupForm() {
        User currentUser = SessionManager.getInstance().getCurrentUser();
        if (currentUser != null) {
            jLabel1.setText("ChatApp  —  " + currentUser.getFirstName());
        }
        loadContacts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnAddContact = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/app-icon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(842, 555));

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ChatApp");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLogout))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(245, 246, 250));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(245, 246, 250));

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel4.setText("Friends");

        btnAddContact.setText("Add");
        btnAddContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddContact)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddContact)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Select a contact");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(70, 160, 70));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Choose a contact to start chatting");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setBackground(new java.awt.Color(245, 246, 250));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(30, 30, 30));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/send.png"))); // NOI18N
        btnSend.setBorderPainted(false);
        btnSend.setContentAreaFilled(false);
        btnSend.setFocusPainted(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTextField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend)
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to logout?", "Logout",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm != JOptionPane.YES_OPTION) return;

        SessionManager.getInstance().logout();
        RestApiClient.getInstance().clearTokens();

        dispose();
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAddContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddContactActionPerformed
        new AddContact(this::loadContacts).setVisible(true);
    }//GEN-LAST:event_btnAddContactActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        sendMessage();
    }//GEN-LAST:event_btnSendActionPerformed

    // business logic

    private void loadContacts() {
        new Thread(() -> {
            try {
                // Use ContactService to get actual contacts
                JsonArray contacts = contactService.getContacts();
                User currentUser = SessionManager.getInstance().getCurrentUser();

                SwingUtilities.invokeLater(() -> {
                    menuList.removeAll();
                    if (contacts != null && contacts.size() > 0) {
                        for (int i = 0; i < contacts.size(); i++) {
                            JsonObject contactJson = contacts.get(i).getAsJsonObject();
                            int contactUserId = contactJson.get("contact_user_id").getAsInt();
                            String fullName = contactJson.has("contact_full_name") 
                                    ? contactJson.get("contact_full_name").getAsString() 
                                    : contactJson.get("contact_username").getAsString();

                            Item_People item = new Item_People(fullName, false);
                            item.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
                            final int finalUserId = contactUserId;
                            item.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    selectContact(finalUserId, fullName);
                                }
                            });
                            menuList.add(item);
                            javax.swing.JSeparator sep = new javax.swing.JSeparator();
                            sep.setForeground(new Color(220, 220, 220));
                            sep.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 1));
                            sep.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
                            menuList.add(sep);
                        }
                    } else {
                        // Show placeholder when no contacts exist
                        JLabel emptyLabel = new JLabel("  No contacts yet. Click \"Add\" to add friends.");
                        emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
                        emptyLabel.setForeground(new Color(150, 150, 150));
                        emptyLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
                        emptyLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        menuList.add(emptyLabel);
                    }
                    menuList.repaint();
                    menuList.revalidate();
                });
            } catch (Exception e) {
                System.err.println("Error loading contacts: " + e.getMessage());
                SwingUtilities.invokeLater(() -> {
                    menuList.removeAll();
                    JLabel errorLabel = new JLabel("  Error loading contacts. Check connection.");
                    errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                    errorLabel.setForeground(new Color(200, 50, 50));
                    errorLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
                    errorLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    menuList.add(errorLabel);
                    menuList.repaint();
                    menuList.revalidate();
                });
            }
        }).start();
    }

    private void selectContact(int userId, String name) {
        cancelEdit();
        selectedContactId = userId;
        selectedContactName = name;
        jLabel7.setText(name);
        jLabel8.setText("Active now");
        jLabel8.setForeground(new Color(40, 147, 59));
        chatBody.clearChat();
        loadConversation();
        jTextField1.requestFocus();
    }

    private void cancelEdit() {
        if (editingMessageId != -1) {
            editingMessageId = -1;
            editingComponent = null;
            jTextField1.setText("");
        }
    }

    private void loadConversation() {
        new Thread(() -> {
            try {
                User currentUser = SessionManager.getInstance().getCurrentUser();
                JsonArray messages = messageService.getConversation(
                        currentUser.getUserId(), selectedContactId);

                SwingUtilities.invokeLater(() -> {
                    chatBody.clearChat();
                    String lastDate = "";
                    for (int i = 0; i < messages.size(); i++) {
                        JsonObject msgJson = messages.get(i).getAsJsonObject();
                        int messageId = msgJson.get("message_id").getAsInt();
                        int senderId = msgJson.get("sender_id").getAsInt();
                        String messageText = msgJson.get("message_content").getAsString();
                        String createdAt = msgJson.get("created_at").getAsString();
                        
                        String msgDate = createdAt.substring(0, 10);
                        if (!msgDate.equals(lastDate)) {
                            chatBody.addDate(msgDate);
                            lastDate = msgDate;
                        }
                        String time = createdAt.substring(11, 16);

                        if (senderId == currentUser.getUserId()) {
                            Chat_RightAdapter right = new Chat_RightAdapter(messageText, time);
                            right.setMessageId(messageId);
                            chatBody.addRightComponent(right);
                        } else {
                            chatBody.addItemLeft(messageText, selectedContactName);
                        }
                    }
                    jTextField1.requestFocus();
                });
            } catch (Exception e) {
                System.err.println("Error loading conversation: " + e.getMessage());
            }
        }).start();
    }

    private void sendMessage() {
        String message = jTextField1.getText().trim();

        if (editingMessageId != -1) {
            if (message.isEmpty()) {
                cancelEdit();
                return;
            }
            updateExistingMessage(message);
            return;
        }

        if (selectedContactId == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a contact first", "No Contact Selected",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (message.isEmpty()) return;

        User currentUser = SessionManager.getInstance().getCurrentUser();
        jTextField1.setText("");

        new Thread(() -> {
            try {
                int msgId = messageService.sendMessage(
                        currentUser.getUserId(), selectedContactId, message);

                SwingUtilities.invokeLater(() -> {
                    if (msgId != -1) {
                        String time = timeFormat.format(new Date());
                        Chat_RightAdapter right = new Chat_RightAdapter(message, time);
                        right.setMessageId(msgId);
                        chatBody.addRightComponent(right);
                        jTextField1.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(Chat.this,
                                "Failed to send message", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                });
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        Chat.this, "Error: " + e.getMessage(),
                        "Send Error", JOptionPane.ERROR_MESSAGE));
            }
        }).start();
    }

    private void updateExistingMessage(String newText) {
        final int msgId = editingMessageId;
        final Chat_RightAdapter comp = editingComponent;
        if (msgId <= 0 || comp == null) {
            cancelEdit();
            return;
        }
        jTextField1.setText("");
        new Thread(() -> {
            try {
                boolean ok = messageService.updateMessage(msgId, newText);
                if (ok) {
                    SwingUtilities.invokeLater(() -> {
                        comp.updateText(newText);
                        cancelEdit();
                    });
                } else {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(Chat.this,
                            "Failed to update message", "Error",
                            JOptionPane.ERROR_MESSAGE);
                        cancelEdit();
                    });
                }
            } catch (Exception ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(Chat.this,
                        "Error: " + ex.getMessage(), "Update Error",
                        JOptionPane.ERROR_MESSAGE);
                    cancelEdit();
                });
            }
        }).start();
    }

    // inner adapter for right-side (sent) messages

    private class Chat_RightAdapter extends JPanel {
        private final JLabel textLabel;
        private final JLabel timeLabel;
        private String rawText;
        private int messageId = -1;
        private JMenuItem editItem;

        public Chat_RightAdapter(String text, String time) {
            this.rawText = text;
            setLayout(new java.awt.BorderLayout());
            setBackground(new Color(179, 229, 255));
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 0));

            textLabel = new JLabel();
            textLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            textLabel.setBorder(BorderFactory.createEmptyBorder(8, 12, 4, 12));
            setDisplayText(text);

            timeLabel = new JLabel(time);
            timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
            timeLabel.setForeground(new Color(110, 110, 110));
            timeLabel.setBorder(BorderFactory.createEmptyBorder(0, 12, 6, 12));

            add(textLabel, java.awt.BorderLayout.CENTER);
            add(timeLabel, java.awt.BorderLayout.SOUTH);
            initContextMenu();
        }

        public void setMessageId(int id) {
            this.messageId = id;
            if (editItem != null) editItem.setEnabled(id != -1);
        }

        public void updateText(String newText) {
            this.rawText = newText;
            setDisplayText(newText);
        }

        private void setDisplayText(String text) {
            textLabel.setText("<html><p style=\"width:200px\">"
                    + text.replace("\n", "<br>") + "</p></html>");
        }

        private void initContextMenu() {
            JPopupMenu popup = new JPopupMenu();
            JMenuItem copyItem = new JMenuItem("Copy");
            copyItem.addActionListener(e -> {
                StringSelection sel = new StringSelection(rawText);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
            });
            editItem = new JMenuItem("Edit");
            editItem.addActionListener(e -> {
                editingMessageId = messageId;
                editingComponent = Chat_RightAdapter.this;
                jTextField1.setText(rawText);
                jTextField1.requestFocus();
            });
            JMenuItem deleteItem = new JMenuItem("Delete");
            deleteItem.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(Chat.this,
                        "Delete this message?", "Confirm Delete",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm != JOptionPane.YES_OPTION) return;
                if (messageId <= 0) return;
                if (editingComponent == Chat_RightAdapter.this) cancelEdit();
                final int delId = messageId;
                new Thread(() -> {
                    try {
                        boolean ok = messageService.deleteMessage(delId);
                        if (ok) {
                            SwingUtilities.invokeLater(() -> {
                                Container parent = getParent();
                                if (parent != null) {
                                    parent.remove(Chat_RightAdapter.this);
                                    parent.repaint();
                                    parent.revalidate();
                                }
                            });
                        } else {
                            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                                    Chat.this, "Failed to delete message",
                                    "Error", JOptionPane.ERROR_MESSAGE));
                        }
                    } catch (Exception ex) {
                        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                                Chat.this, "Error: " + ex.getMessage(),
                                "Delete Error", JOptionPane.ERROR_MESSAGE));
                    }
                }).start();
            });
            popup.add(copyItem);
            popup.add(editItem);
            popup.add(deleteItem);
            addMouseListener(new MouseAdapter() {
                @Override public void mousePressed(MouseEvent e) {
                    if (e.isPopupTrigger()) popup.show(Chat_RightAdapter.this, e.getX(), e.getY());
                }
                @Override public void mouseReleased(MouseEvent e) {
                    if (e.isPopupTrigger()) popup.show(Chat_RightAdapter.this, e.getX(), e.getY());
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddContact;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables

    // custom components
    private Chat_Body chatBody;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Chat().setVisible(true));
    }
}
