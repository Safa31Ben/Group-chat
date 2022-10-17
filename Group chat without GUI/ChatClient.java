package chatclient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Safa BENABDESSADOK
 */

 
public class ChatClient extends Thread {

    private String name = "";
    private String server = "";
    private Socket socket;

    /*get client information "name" and server @*/
    ChatClient() {
        try {
            System.out.print("enter name : ");
            this.name = new Scanner(System.in).nextLine();
            System.out.print("enter server address : ");
            this.server = new Scanner(System.in).nextLine();
            this.socket = new Socket(server, 2090);
            new ObjectOutputStream(socket.getOutputStream()).writeObject(name);
        } catch (IOException ex) {
        }
    }

    /*enter the conversation*/
    @Override
    public void run() {
        new Read().start();
        new Send().start();
    }

    /* Send messages */
    class Send extends Thread {

        @Override
        public void run() {
            System.out.println(name + " start sending massage ");
            while (true) {
                try {
                    String m = new Scanner(System.in).nextLine();
                    new ObjectOutputStream(socket.getOutputStream()).writeObject(name + " : " + m);
                } catch (IOException e) {
                }
            }
        }
    }

    /* Recived messages */
    class Read extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    String m = (String) new ObjectInputStream(socket.getInputStream()).readObject();
                    if (m != null) {
                        System.out.println(m);
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
            }
        }
    }

    public static void main(String[] args) {
        new ChatClient().start();
    }
}
