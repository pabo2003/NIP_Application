package lk.ijse.gdse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            //remote socket
            Socket socket = new Socket("localhost",3000);
            //request to the server
            String massage = "Hi!I'm from client";
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.flush();
            //send the data
            dataOutputStream.writeUTF(massage);

            /*DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String massage1 = dataInputStream.readUTF();
            System.out.println(massage1);*/

            //close
            socket.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
