package chatclient;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author nedjmou
 */

/*
    + msg vue une seul fois
 */
public class ClientGUI extends javax.swing.JFrame {

    private String name = "";
    private Socket socket;
    DefaultListModel listModel;

    ArrayList<String> userList = new ArrayList<String>();

    public ClientGUI() {
        initComponents();
        listModel = new DefaultListModel();
        list.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        messagingPanel = new javax.swing.JPanel();
        hello = new javax.swing.JLabel();
        connectedName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        messageField = new javax.swing.JTextField();
        sendBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        unselectUsers = new javax.swing.JButton();
        connectPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        ServerAddressLabel = new javax.swing.JLabel();
        addressServerField = new javax.swing.JTextField();
        connectBtn = new javax.swing.JButton();
        connectPanelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Client");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        messagingPanel.setBackground(new java.awt.Color(153, 255, 255));

        hello.setBackground(new java.awt.Color(153, 255, 255));
        hello.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hello.setForeground(new java.awt.Color(0, 0, 0));
        hello.setText("Hello : ");

        connectedName.setBackground(new java.awt.Color(153, 255, 255));
        connectedName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        connectedName.setForeground(new java.awt.Color(0, 0, 0));
        connectedName.setText("..........................");

        messageArea.setEditable(false);
        messageArea.setBackground(new java.awt.Color(255, 255, 255));
        messageArea.setColumns(20);
        messageArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        messageArea.setForeground(new java.awt.Color(0, 0, 0));
        messageArea.setRows(5);
        jScrollPane1.setViewportView(messageArea);

        messageField.setBackground(new java.awt.Color(255, 255, 255));
        messageField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        messageField.setForeground(new java.awt.Color(0, 0, 0));
        messageField.setToolTipText("");
        messageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageFieldKeyPressed(evt);
            }
        });

        sendBtn.setBackground(new java.awt.Color(0, 204, 204));
        sendBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sendBtn.setForeground(new java.awt.Color(0, 0, 0));
        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        list.setBackground(new java.awt.Color(255, 255, 255));
        list.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(list);

        unselectUsers.setBackground(new java.awt.Color(0, 102, 102));
        unselectUsers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        unselectUsers.setForeground(new java.awt.Color(0, 0, 0));
        unselectUsers.setText("Unselect");
        unselectUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unselectUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout messagingPanelLayout = new javax.swing.GroupLayout(messagingPanel);
        messagingPanel.setLayout(messagingPanelLayout);
        messagingPanelLayout.setHorizontalGroup(
            messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagingPanelLayout.createSequentialGroup()
                .addGroup(messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messagingPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(hello, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectedName, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(messagingPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(messageField, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(unselectUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        messagingPanelLayout.setVerticalGroup(
            messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagingPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hello)
                    .addComponent(connectedName))
                .addGroup(messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(messagingPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(messagingPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unselectUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(messagingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(messageField)
                    .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        connectPanel.setBackground(new java.awt.Color(153, 255, 255));
        connectPanel.setName(""); // NOI18N

        nameLabel.setBackground(new java.awt.Color(153, 255, 255));
        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Your name :");

        nameField.setBackground(new java.awt.Color(255, 255, 255));
        nameField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 0, 0));
        nameField.setToolTipText("");

        ServerAddressLabel.setBackground(new java.awt.Color(153, 255, 255));
        ServerAddressLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ServerAddressLabel.setForeground(new java.awt.Color(0, 0, 0));
        ServerAddressLabel.setText("Server address :");

        addressServerField.setBackground(new java.awt.Color(255, 255, 255));
        addressServerField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addressServerField.setForeground(new java.awt.Color(0, 0, 0));

        connectBtn.setBackground(new java.awt.Color(0, 153, 153));
        connectBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        connectBtn.setForeground(new java.awt.Color(0, 0, 0));
        connectBtn.setText("Connect");
        connectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtnActionPerformed(evt);
            }
        });

        connectPanelTitle.setBackground(new java.awt.Color(153, 255, 255));
        connectPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        connectPanelTitle.setForeground(new java.awt.Color(0, 0, 0));
        connectPanelTitle.setText("Connect to the server");

        javax.swing.GroupLayout connectPanelLayout = new javax.swing.GroupLayout(connectPanel);
        connectPanel.setLayout(connectPanelLayout);
        connectPanelLayout.setHorizontalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(connectPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(connectPanelLayout.createSequentialGroup()
                                .addComponent(ServerAddressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameField)
                                    .addComponent(addressServerField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(nameLabel)))
                    .addGroup(connectPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(connectPanelTitle))
                    .addGroup(connectPanelLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(connectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        connectPanelLayout.setVerticalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(connectPanelTitle)
                .addGap(78, 78, 78)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressServerField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(connectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        jLayeredPane1.setLayer(messagingPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(connectPanel, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(connectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(messagingPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(connectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(messagingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* connect to the server */
    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtnActionPerformed

        try {
            this.name = nameField.getText();
            String serverAddr = addressServerField.getText();
            if (name != null && serverAddr != null) {
                this.socket = new Socket(serverAddr, 2090);
                new ObjectOutputStream(socket.getOutputStream()).writeObject(name);
                String m = (String) new ObjectInputStream(socket.getInputStream()).readObject();
                if (m.equals("choose an other name")) {
                    new ErrorMessage("Name exist, choose an other one").setVisible(true);
                } else {
                    new Read().start();
                    this.connectedName.setText(name);

                    this.connectPanel.setVisible(false);
                    this.messagingPanel.setVisible(true);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            new ErrorMessage("Incorrect server address").setVisible(true);
        }
    }//GEN-LAST:event_connectBtnActionPerformed

    /* Recived messages */
    class Read extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    String m = (String) new ObjectInputStream(socket.getInputStream()).readObject();

                    if (m.length() > 10 && m.substring(0, 10).equals("newClient=")) {
                        /* server inform client that there is a new client join the chat group*/
                        if (!m.substring(m.indexOf("=") + 1).equals(name)) {
                            listModel.addElement(m.substring(m.indexOf("=") + 1));
                        }
                    } else if (m.length() > 12 && m.substring(0, 12).equals("deletClient=")) {
                        /* server inform client that there is a new client left the chat group*/
                        listModel.removeElement(m.substring(m.indexOf("=") + 1));
                    } else {
                        /* read group and private messages */
                        messageArea.append(m + "\n");
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
            }
        }
    }

    /* Send messages */
    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed

        try {
            String m = this.messageField.getText();
            if (m != null) {
                if (list.getSelectedIndex() != -1) {
                    /* send message in private */
                    String toName = list.getSelectedValue();
                    new ObjectOutputStream(socket.getOutputStream()).writeObject(toName + "=" + name + " : " + m);
                    this.messageField.setText("");
                } else {
                    /* send message to all */
                    new ObjectOutputStream(socket.getOutputStream()).writeObject(name + " : " + m);
                    this.messageField.setText("");
                }
            }
        } catch (IOException e) {
            this.messageField.setText("");
            messageArea.append("\"Server was shut down\"\n");
        }
    }//GEN-LAST:event_sendBtnActionPerformed

    /* disconnect */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            new ObjectOutputStream(socket.getOutputStream()).writeObject("disconnect " + name);
        } catch (IOException ex) {
        } finally {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void messageFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageFieldKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String m = this.messageField.getText();
                if (m != null) {
                    if (list.getSelectedIndex() != -1) {
                        /* send message in private */
                        String toName = list.getSelectedValue();
                        new ObjectOutputStream(socket.getOutputStream()).writeObject(toName + "=" + name + " : " + m);
                        this.messageField.setText("");
                        messageArea.append("You to \"" + toName + "\" : " + m + "\n");
                    } else {
                        /* send message to all */
                        new ObjectOutputStream(socket.getOutputStream()).writeObject(name + " : " + m);
                        this.messageField.setText("");
                    }
                }
            } catch (IOException e) {
                this.messageField.setText("");
                messageArea.append("\"Server was shut down\"\n");
            }
        }
    }//GEN-LAST:event_messageFieldKeyPressed

    private void unselectUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unselectUsersActionPerformed
       /* unselect users */
        list.clearSelection();
    }//GEN-LAST:event_unselectUsersActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ServerAddressLabel;
    private javax.swing.JTextField addressServerField;
    private javax.swing.JButton connectBtn;
    private javax.swing.JPanel connectPanel;
    private javax.swing.JLabel connectPanelTitle;
    private javax.swing.JLabel connectedName;
    private javax.swing.JLabel hello;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> list;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JTextField messageField;
    private javax.swing.JPanel messagingPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton sendBtn;
    private javax.swing.JButton unselectUsers;
    // End of variables declaration//GEN-END:variables
}
