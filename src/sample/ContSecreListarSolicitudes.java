package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContSecreListarSolicitudes {

    @FXML
    private JFXButton btnSearchDestino;

    @FXML
    private JFXButton btnSearchFecha;

    @FXML
    private JFXButton btnSearchEstado;

    @FXML
    private TableView<?> tablaViajes;

    @FXML
    private TableColumn<?, ?> viaID;

    @FXML
    private TableColumn<?, ?> viaFechaIngreso;

    @FXML
    private TableColumn<?, ?> viaEstado;

    @FXML
    private TableColumn<?, ?> viaDestino;

    @FXML
    private TableColumn<?, ?> viaInicioViaje;

    @FXML
    private TableView<?> tablaPasajeros;

    @FXML
    private TableColumn<?, ?> nombrePasajero;

    @FXML
    private TableColumn<?, ?> nombreCarne;

    @FXML
    void buscarPorDestino(ActionEvent event) {

    }

    @FXML
    void buscarPorEstado(ActionEvent event) {

    }

    @FXML
    void buscarPorFecha(ActionEvent event) {

    }

}
