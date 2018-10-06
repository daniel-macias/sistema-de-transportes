package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ContAdminListarViajes implements Initializable {

    @FXML
    private JFXButton btnAprobar;

    @FXML
    private JFXButton btnDenegar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXTextField idField;

    @FXML
    private JFXTextField carneField;

    @FXML
    private JFXTextField placaField;

    @FXML
    private TableView<Viaje> tablaViajes;

    @FXML
    private TableColumn<Viaje, String> viaId;

    @FXML
    private TableColumn<Viaje, String> viaPuntDestino;

    @FXML
    private TableColumn<Viaje, String> viaFechaIngreso;

    @FXML
    private TableColumn<Viaje, String> viaEstado;

    @FXML
    private TableColumn<Viaje, String> viaEscuela;

    @FXML
    private TableView<Chofer> tablaChofer;

    @FXML
    private TableColumn<Chofer, String> choNombre;

    @FXML
    private TableColumn<Chofer, String> choCedula;

    @FXML
    private TableView<Vehiculo> tablaVehiculo;

    @FXML
    private TableColumn<Vehiculo, String> vehPlaca;

    @FXML
    private TableColumn<Vehiculo, String> vehEstado;

    @FXML
    private TableColumn<Vehiculo, String> vehCapacidad;

    @FXML
    void aprobarViaje(ActionEvent event) {

    }

    @FXML
    void cancelarViaje(ActionEvent event) {

    }

    @FXML
    void denegarViaje(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
