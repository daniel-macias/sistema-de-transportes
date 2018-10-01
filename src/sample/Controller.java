package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller{


    private Admin administrador = new Admin();
    private ArrayList<Secretaria> listaDeSecretarias = new ArrayList<>();

    @FXML
    private JFXTextField usuarioField;

    @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXButton ingresar;

    @FXML
    void intentarIngresar(ActionEvent event) {
        String nombreUsuarioTemp = usuarioField.getText();
        String passTemp = passField.getText();

        if (nombreUsuarioTemp.equals(administrador.getUsuario()) && passTemp.equals(administrador.getPassword())) {
            //TODO INGRESAR COMO ADMINISTRADOR
            System.out.println("ingreso CORRECTAMENTE");

        } else if(listaDeSecretarias.size() > 0) {
            for (Secretaria secre : listaDeSecretarias) {
                if (secre.getUsuario() == nombreUsuarioTemp && secre.getPassword() == passTemp) {
                    //TODO INGRESAR COMO SECRETARIA
                }
            }
        }

    }
}
