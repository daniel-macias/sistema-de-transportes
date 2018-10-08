package sample;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller{


    private Admin administrador = new Admin();
    private static ArrayList<Secretaria> listaDeSecretarias = new ArrayList<>();


    @FXML
    private AnchorPane loginPane;

    @FXML
    private JFXTextField usuarioField;

    @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXButton ingresar;

    @FXML
    void intentarIngresar(ActionEvent event) throws FileNotFoundException {
        String nombreUsuarioTemp = usuarioField.getText();
        String passTemp = passField.getText();
        loadListaDeSecretarias();

        if (nombreUsuarioTemp.equals(administrador.getUsuario()) && passTemp.equals(administrador.getPassword())) {
            System.out.println("ingreso CORRECTAMENTE COMO ADMIN");
            hacerFadeOut(1);

        } else if(listaDeSecretarias.size() > 0) {
            for (Secretaria secre : listaDeSecretarias) {
                if (secre.getUsuario().equals(nombreUsuarioTemp)&& secre.getPassword().equals(passTemp)) {
                    System.out.println("ingreso CORRECTAMENTE COMO SECRETARIA");
                    hacerFadeOut(2);
                }
            }
        }

    }

    private void hacerFadeOut(int idEscena){
        FadeTransition fT = new FadeTransition();
        fT.setDuration(Duration.millis(500));
        fT.setNode(loginPane);
        fT.setFromValue(1);
        fT.setToValue(0);

        fT.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cargarSiguienteScene(idEscena);
            }
        });
        fT.play();
    }

    private void cargarSiguienteScene(int idEscena){  //Acepta el id de escena a cual quiere cambiar
        try {
            Parent sigScn;
            if(idEscena == 1)
                sigScn = (AnchorPane) FXMLLoader.load(getClass().getResource("guiadmin.fxml"));
            else //TODO ESTE ELSE TIENE QUE SER SI NINGUNO DE LOS LOS DOS ES USO
                sigScn = (AnchorPane) FXMLLoader.load(getClass().getResource("guisecre.fxml"));

            Scene newScene = new Scene(sigScn);

            Stage curStage = (Stage) loginPane.getScene().getWindow();

            curStage.setScene(newScene);
        }catch (IOException ex){
            System.out.println("Error al cargar la otras escena");
        }

    }

    public static ArrayList<Secretaria> getListaDeSecretarias() {
        return listaDeSecretarias;
    }

    public static void loadListaDeSecretarias() throws FileNotFoundException {

        JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/DB/usuariosDB.json"));
        listaDeSecretarias = new Gson().fromJson(reader, new TypeToken<ArrayList<Secretaria>>(){}.getType());
    }

    public static void guardarListaDeSecretarias() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/DB/usuariosDB.json"));
        writer.write(new Gson().toJson(listaDeSecretarias));
        writer.close();
    }
}
