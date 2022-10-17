package chatserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Safa BENABDESSADOK
 */
public class ChatServer {

    static final int PORT = 2090;
    static ServerSocket server;
    static HashMap connectedClientList = new HashMap();
    static ArrayList<String> disconnectedClientList = new ArrayList<String>();


    /* create the server and make it wait for clients sockets */
    ChatServer() {
        System.out.println("running");
        try {
            ChatServer.server = new ServerSocket(PORT);
            new Accept().start();
        } catch (IOException ex) {
        }
    }

    /* start waiting clients sockets and save them in Hash map (clineName : clineSocket) */
    class Accept extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Socket socket = server.accept();
                    String name = (String) new ObjectInputStream(socket.getInputStream()).readObject();
                    connectedClientList.put(name, socket);
                    System.out.println(name + " connected");
                    new Read(socket).start();
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
                    String msg;
                    msg = (String) in.readObject();
                    System.out.println(msg);
                    /* loop in the client socket map to share the message*/
                    for (Iterator it = connectedClientList.keySet().iterator(); it.hasNext();) {
                        Object key = it.next();
                        Socket clientSocket = (Socket) connectedClientList.get(key);
                        try {
                            if (!disconnectedClientList.contains(key)) {
                                new ObjectOutputStream(clientSocket.getOutputStream()).writeObject(msg);
                            }
                        } catch (IOException e) {
                            /* remove client who left the conversation */
                            disconnectedClientList.add((String) key);
                            System.out.println("disconnect " + key);
                        }
                    }
                    for (String key : disconnectedClientList) {
                        connectedClientList.remove(key);   
                    }
                } catch (IOException | ClassNotFoundException ex) {
                }
            }
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
