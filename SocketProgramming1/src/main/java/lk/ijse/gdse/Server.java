package lk.ijse.gdse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //server socket
            ServerSocket serverSocket = new ServerSocket(3000);
            //local socket
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted!");

            String massage1 = "hello!I'm Server";
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.flush();
            dataOutputStream.writeUTF(massage1);
            //data reading option
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //sout
            String massage = dataInputStream.readUTF();
            System.out.println(massage);
            //close
            socket.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}