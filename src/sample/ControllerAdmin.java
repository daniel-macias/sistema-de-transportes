package sample;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerAdmin implements Initializable {

    @FXML
    private AnchorPane adminPane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private BorderPane panelQueCambiara;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminPane.setOpacity(0);//Esto hace el fade in desde el scene de logint
        hacerFadeIn();

        try {
            VBox boxMenu = FXMLLoader.load(getClass().getResource("AdminDrawerContent.fxml"));
            drawer.setSidePane(boxMenu);

            for(Node node : boxMenu.getChildren()){
                if(node.getAccessibleText() != null){
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch (node.getAccessibleText()){ //Revisa si esta eligiendo una de las opciones del menu
                            case "aprobar_solicitud":
                                cargarSceneAlGeneral("AdminListarViajes");
                                break;
                            case "registrar_secretaria":
                                cargarSceneAlGeneral("AdminRegistrarSecretaria");
                                break;
                            case "registrar_vehiculo":
                                cargarSceneAlGeneral("AdminRegistrarChofer");   //Accidentalmente estal al revez pero dejar asi
                                break;
                            case "registrar_chofer":
                                cargarSceneAlGeneral("AdminRegistrarVehiculo");
                                break;
                            case "consultar_top_choferes":
                                cargarSceneAlGeneral("AdminConsultarTopChoferes");
                                break;
                            case "consultar_top_escuelas":
                                cargarSceneAlGeneral("AdminConsultarTopEscuelas");
                                break;
                            case "mantenimiento":                                   //Nuevas adiciones
                                cargarSceneAlGeneral("AdminMantenimiento");
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
        fT.setNode(adminPane);
        fT.setFromValue(0);
        fT.setToValue(1);
        fT.play();
    }

    private void cargarSceneAlGeneral(String ui){
        panelQueCambiara.getChildren().clear();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panelQueCambiara.setCenter(root);

        if(ui.equals("sample")){
            adminPane.getChildren().setAll(root);
        }

    }
}
