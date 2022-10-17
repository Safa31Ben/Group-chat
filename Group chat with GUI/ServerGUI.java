package chatserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Safa BENABDESSADOK
 */
public class ServerGUI extends javax.swing.JFrame {

    /* create the server and make it wait for clients sockets */
    public ServerGUI() {
        initComponents();
        try {
            this.server = new ServerSocket(PORT);
            this.serverStatus.setText(" running ");
            new Accept().start();
        } catch (IOException ex) {
        }
    }

    static final int PORT = 2090;
    static ServerSocket server;
    static HashMap connectedClientList = new HashMap();

    /* start waiting clients sockets and save them in Hash map (clineName : clineSocket) */
    class Accept extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Socket socket = server.accept();
                    String name = (String) new ObjectInputStream(socket.getInputStream()).readObject();
                    if (connectedClientList.containsKey(name)) {
                        new ObjectOutputStream(socket.getOutputStream()).writeObject("choose an other name");
                    } else {
                        connectedClientList.put(name, socket);
                        new ObjectOutputStream(socket.getOutputStream()).writeObject("connected");
                        displayMsgs.append(name + " connected\n");
                        new Read(socket).start();
                        /*inform old clients the join of the new one */
                        for (Iterator it = connectedClientList.keySet().iterator(); it.hasNext();) {
                            Object key = it.next();
                            Socket clientSocket = (Socket) connectedClientList.get(key);
                            new ObjectOutputStream(clientSocket.getOutputStream()).writeObject("newClient=" + name);
                        }
                        /*inform new client the connected clients */
                        for (Iterator it = connectedClientList.keySet().iterator(); it.hasNext();) {
                            Object key = it.next();
                            new ObjectOutputStream(socket.getOutputStream()).writeObject("newClient=" + key);
                        }
                    }
                } catch (IOException | ClassNotFoundException ex) {

                }
            }
        }
    }

    /* read client messages and share it's  */
    class Read extends Thread {

        Socket socket;

        Read(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (!connectedClientList.isEmpty()) {
                try {
                    /* read the message */
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    String msg = (String) in.readObject();
                    if (msg.length() > 10 && msg.substring(0, 10).equals("disconnect")) {
                        /* inform clients that there is a client left the chet group*/
                        String key = msg.substring(11);
                        displayMsgs.append(key + " disconnected\n");
                        connectedClientList.remove(key);
                        for (Iterator it = connectedClientList.keySet().iterator(); it.hasNext();) {
                            Object key1 = it.next();
                            Socket clientSocket = (Socket) connectedClientList.get(key1);

                            new ObjectOutputStream(clientSocket.getOutputStream()).writeObject("deletClient=" + key);
                        }
                    } else if (msg.contains("=")) {
                        /* forward private messages*/
                        String toName = msg.substring(0, msg.indexOf("="));
                        Socket clientSocket = (Socket) connectedClientList.get(toName);
                        String me = msg.substring(msg.indexOf("=") + 1, msg.indexOf(":") - 1);

                        new ObjectOutputStream(clientSocket.getOutputStream()).writeObject("\"" + me + "\" to you : " + msg.substring(msg.indexOf(":") + 1));
                        displayMsgs.append("\"" + me + "\" to " + toName + " : " + msg.substring(msg.indexOf(":") + 1) + "\n");
                    } else {
                        /* loop in the client socket map to share the message*/
                        displayMsgs.append(msg + "\n");
                        for (Iterator it = connectedClientList.keySet().iterator(); it.hasNext();) {
                            Object key = it.next();
                            Socket clientSocket = (Socket) connectedClientList.get(key);
                            try {
                                new ObjectOutputStream(clientSocket.getOutputStream()).writeObject(msg);
                            } catch (IOException e) {
                            }
                        }
                    }
                } catch (IOException | ClassNotFoundException ex) {
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ServerStatusLabel = new javax.swing.JLabel();
        serverStatus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayMsgs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        ServerStatusLabel.setBackground(new java.awt.Color(204, 204, 255));
        ServerStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ServerStatusLabel.setForeground(new java.awt.Color(0, 0, 0));
        ServerStatusLabel.setText("Server :");

        serverStatus.setBackground(new java.awt.Color(204, 204, 255));
        serverStatus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        serverStatus.setForeground(new java.awt.Color(0, 0, 0));
        serverStatus.setText("..............................");

        displayMsgs.setEditable(false);
        displayMsgs.setColumns(20);
        displayMsgs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        displayMsgs.setRows(5);
        jScrollPane2.setViewportView(displayMsgs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(ServerStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(serverStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerStatusLabel)
                    .addComponent(serverStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ServerStatusLabel;
    private javax.swing.JTextArea displayMsgs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel serverStatus;
    // End of variables declaration//GEN-END:variables
}
