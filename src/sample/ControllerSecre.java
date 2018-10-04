package sample;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSecre implements Initializable {

    @FXML
    private AnchorPane secrePane;

    @FXML
    private BorderPane panelQueCambiara;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        secrePane.setOpacity(0);//Esto hace el fade in desde el scene de logint
        hacerFadeIn();

        try {
            VBox boxMenu = FXMLLoader.load(getClass().getResource("SecreDrawerContent.fxml"));
            drawer.setSidePane(boxMenu);

            for(Node node : boxMenu.getChildren()){
                if(node.getAccessibleText() != null){
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch (node.getAccessibleText()){ //Revisa si esta eligiendo una de las opciones del menu
                            case "registrar_pasajero":
                                cargarSceneAlGeneral("SecreRegistrarPasajero");
                                break;
                            case "solicitar_viaje":
                                cargarSceneAlGeneral("SecreSolicitarViaje");
                                break;
                            case "listar_solicitudes_de_viaje":
                                cargarSceneAlGeneral("SecreListarSolicitudes");   //Accidentalmente estal al revez pero dejar asi
                                break;
                            case "cancelar_solicitud_de_viaje":
                                cargarSceneAlGeneral("SecreCancelarSolicitud");
                                break;
                            case "salir":
                                System.out.println("Saliendo");
                                cargarSceneAlGeneral("sample");
                                break;
                        }
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
        burgerTask2.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();

            if(drawer.isClosed()){
                drawer.open();
            } else {
                drawer.close();
            }
        });
    }

    private void hacerFadeIn(){
        FadeTransition fT = new FadeTransition();
        fT.setDuration(Duration.millis(500));
        fT.setNode(secrePane);
        fT.setFromValue(0);
        fT.setToValue(1);
        fT.play();
    }

    private void cargarSceneAlGeneral(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panelQueCambiara.setCenter(root);

        if(ui.equals("sample")){
            secrePane.getChildren().setAll(root);
        }

    }

}
