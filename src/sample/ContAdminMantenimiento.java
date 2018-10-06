package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContAdminMantenimiento {

    @FXML
    private JFXTextField empRazon;

    @FXML
    private JFXTextField empTelefono;

    @FXML
    private JFXTextField empDireccion;

    @FXML
    private JFXTextField empCedula;

    @FXML
    private JFXTextField fieldMonto;

    @FXML
    private JFXTextField fieldTipoDeServicio;

    @FXML
    private JFXButton btnRegistrarEmpreza;

    @FXML
    private JFXDatePicker fieldFechaInicio;

    @FXML
    private JFXDatePicker fieldFechaFinal;

    @FXML
    private JFXButton btnMandarAMantenimiento;

    @FXML
    private TableView<?> tablaVehiculos;

    @FXML
    private TableColumn<?, ?> colVehPlaca;

    @FXML
    private TableColumn<?, ?> colVehEstado;

    @FXML
    private JFXTextField fieldPlaca;

    @FXML
    private JFXTextField fieldDetalle;

    @FXML
    private TableView<?> tablaEmprezas;

    @FXML
    private TableColumn<?, ?> colEmpCedula;

    @FXML
    private TableColumn<?, ?> colEmpTelefono;

    @FXML
    private JFXTextField fieldCedulaEmpreza;

    @FXML
    void mandarAMantenimiento(ActionEvent event) {

    }

    @FXML
    void registrarEmpreza(ActionEvent event) {

    }

}
