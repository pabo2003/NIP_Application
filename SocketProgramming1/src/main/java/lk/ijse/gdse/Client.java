package lk.ijse.gdse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            boolean rem = true;
            //remote socket
            Socket socket = new Socket("localhost",3000);
            do {
                //request to the server
                System.out.println("Enter Massage : ");
                String massage = new Scanner(System.in).nextLine();
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(massage);
                dataOutputStream.flush();

//                System.out.println("Client accepted.");
                //data reading option
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String massage1 = dataInputStream.readUTF();
                if (massage1 != null) {
                    System.out.println("Reply : " + massage1);
                } else {
                    System.out.println("massage is null");
                    rem = false;
                }
            }while (rem);
            //close
            socket.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
