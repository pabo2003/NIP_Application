package lk.ijse.gdse.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;import javafx.scene.control.Button;
import javafx.scene.control.TextArea;import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.*;import java.net.ServerSocket;
import java.net.Socket;
public class ServerPageController {
    @FXML
    private Button btnServer;

    @FXML
    private AnchorPane serverPage;

    @FXML
    private TextField txtServer;

    @FXML
    private TextArea txtareaServer;

    String message = "";
    DataInputStream dataInputStream;    DataOutputStream dataOutputStream;
    public void initialize() {
        new Thread(() -> {
        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            txtareaServer.appendText("Server is started");
            Socket socket = serverSocket.accept();
            txtareaServer.appendText("\n client connected\n");
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (!message.equals("exit")) {

                message = dataInputStream.readUTF();
                txtareaServer.appendText("Client : " + message);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);            }
    }).start();
    }
    public void btnServerOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtServer.getText().trim());
        dataOutputStream.flush();
    }
}