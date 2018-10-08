package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ContAdminRegSecretaria {

    @FXML
    private JFXTextField user;

    @FXML
    private JFXButton registrar;

    @FXML
    private JFXTextField correo;

    @FXML
    void registrarSecretaria(ActionEvent event) throws IOException {
        Secretaria secre = new Secretaria(generarContrasenia(),user.getText(), correo.getText());
        boolean yaExiste = false;
        for(Secretaria s : Controller.getListaDeSecretarias()){
            if(s.getUsuario().equals(user.getText()) || s.getUsuario().equals("admin"))
                yaExiste = true;
        }
        if(!yaExiste) {
            Controller.getListaDeSecretarias().add(secre);
            Controller.guardarListaDeSecretarias();
            System.out.println("USUARIO: " + secre.getUsuario() + " REGISTRADO");
        }
        else
            System.out.println("ERROR: ESE USUARIO YA EXISTE");
    }

    private String generarContrasenia(){

        String password = new RandomString(ThreadLocalRandom.current().nextInt(8, 12), ThreadLocalRandom.current()
                , "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890").nextString();
        password += new RandomString(1, ThreadLocalRandom.current(), "!#$?@^~").nextString();
        return password;
    }
}
