package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ContAdminRegSecretaria {

    @FXML
    private JFXTextField user;

    @FXML
    private JFXButton registrar;

    @FXML
    private JFXPasswordField pass;

    @FXML
    void registrarSecretaria(ActionEvent event) throws IOException {
        Secretaria secre = new Secretaria(pass.getText(),user.getText());
        boolean yaExiste = false;
        for(Secretaria s : Controller.getListaDeSecretarias()){
            if(s.getUsuario().equals(user.getText()) || s.getUsuario().equals("admin"))
                yaExiste = true;
        }
        if(!yaExiste) {
            Controller.getListaDeSecretarias().add(secre);
            Controller.guardarListaDeSecretarias();
            System.out.println("USUARIO: " + secre.getUsuario() + "REGISTRADO");
        }
        else
            System.out.println("ERROR: ESE USUARIO YA EXISTE");
    }

}
