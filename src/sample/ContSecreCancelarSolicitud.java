package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContSecreCancelarSolicitud {

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private TableView<?> tabladeViajes;

    @FXML
    private TableColumn<?, ?> viaID;

    @FXML
    private TableColumn<?, ?> viaPuntoDeSalida;

    @FXML
    private TableColumn<?, ?> viaDestino;

    @FXML
    private TableColumn<?, ?> viaFecha;

    @FXML
    private TableColumn<?, ?> viaHoraInicio;

    @FXML
    private TableColumn<?, ?> viaHoraFinal;

    @FXML
    private TableColumn<?, ?> viaEstado;

    @FXML
    private JFXTextField idDeViajeACancelar;

    @FXML
    void cancelarViaje(ActionEvent event) {

    }

}
