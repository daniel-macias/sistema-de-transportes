package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ContAdminMantenimiento implements Initializable {

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
    private TableView<Vehiculo> tablaVehiculos;

    @FXML
    private TableColumn<Vehiculo, String> colVehPlaca;

    @FXML
    private TableColumn<Vehiculo, String> colVehEstado;

    @FXML
    private JFXTextField fieldPlaca;

    @FXML
    private JFXTextField fieldDetalle;

    @FXML
    private TableView<EmprezaDeMantenimiento> tablaEmprezas;

    @FXML
    private TableColumn<EmprezaDeMantenimiento, String> colEmpCedula;

    @FXML
    private TableColumn<EmprezaDeMantenimiento, String> colEmpTelefono;

    @FXML
    private JFXTextField fieldCedulaEmpreza;

    @FXML
    private TableView<ServicioDeMantenimiento> tablaServicios;

    @FXML
    private TableColumn<ServicioDeMantenimiento, String> colSerId;

    @FXML
    private TableColumn<ServicioDeMantenimiento, String> colSerTipo;

    @FXML
    void mandarAMantenimiento(ActionEvent event) {
        if(fieldCedulaEmpreza.getText()!=null && fieldDetalle.getText()!=null && fieldFechaFinal.getValue()!=null && fieldFechaInicio.getValue() != null
                && fieldMonto.getText()!=null && fieldPlaca.getText()!=null && fieldTipoDeServicio.getText()!=null){
            try{
                boolean existeEmpreza = false;
                boolean existeVehiculo = false;
                EmprezaDeMantenimiento empAMeter = new EmprezaDeMantenimiento("0","0",0,"0");
                for(EmprezaDeMantenimiento emp : Main.getListaDeEmprezasDeMantenimiento()){
                    if(fieldCedulaEmpreza.equals(emp.getNumCedula())){
                        existeEmpreza = true;
                        empAMeter = emp;
                    }


                }
                for(Vehiculo veh : Main.getListaDeVehiculos()){
                    if(fieldPlaca.equals(veh.getPlaca()))
                        existeVehiculo = true;
                }

                if(existeEmpreza && existeVehiculo){
                    ServicioDeMantenimiento serMan = new ServicioDeMantenimiento(fieldFechaInicio.getValue(),fieldFechaFinal.getValue(),Float.parseFloat(fieldMonto.getText()),fieldDetalle.getText(),
                            Integer.parseInt(fieldTipoDeServicio.getText()),empAMeter);
                    Main.getListaDeServiciosDeMantenimiento().add(serMan);

                    tablaServicios.getItems().clear(); //Esto refresca el table view
                    tablaServicios.setItems(agarrarLosServiciosDeMantenimiento());
                }
            }catch (Exception e){
                System.out.println("ERROR: numero ingresado no valido");
            }
        }else{
            System.out.println("ERROR: Ingresar todos los datos");
        }

    }

    @FXML
    void registrarEmpreza(ActionEvent event) {
        if(empCedula.getText()!=null && empDireccion.getText()!=null && empRazon.getText()!=null &&empTelefono.getText()!=null){
            try{
                boolean yaExisteEmp = false;
                for(EmprezaDeMantenimiento emp : Main.getListaDeEmprezasDeMantenimiento()){
                    if(emp.getNumCedula().equals(empCedula.getText()))
                        yaExisteEmp = true;
                }
                if(!yaExisteEmp){
                    EmprezaDeMantenimiento empNueva = new EmprezaDeMantenimiento(empRazon.getText(),empCedula.getText(),Integer.parseInt(empTelefono.getText()),empDireccion.getText());
                    Main.getListaDeEmprezasDeMantenimiento().add(empNueva);

                    tablaEmprezas.getItems().clear(); //Esto refresca el table view
                    tablaEmprezas.setItems(agarrarLasEmprezasDeMantenimiento());
                }
            }catch (Exception e){
                System.out.println("ERROR: Numero ingresado no valido");
            }
        }else {
            System.out.println("ERROR: Por favor ingresar todos los falores");
        }
    }

    public ObservableList<Vehiculo> agarrarLosVehiculos(){ //Convierte la lista a un observable list
        ObservableList<Vehiculo> licObservable = FXCollections.observableArrayList();
        licObservable.addAll(Main.getListaDeVehiculos());
        return licObservable;
    }

    public ObservableList<EmprezaDeMantenimiento> agarrarLasEmprezasDeMantenimiento(){ //Convierte la lista a un observable list
        ObservableList<EmprezaDeMantenimiento> mantObservable = FXCollections.observableArrayList();
        mantObservable.addAll(Main.getListaDeEmprezasDeMantenimiento());
        return mantObservable;
    }

    public ObservableList<ServicioDeMantenimiento> agarrarLosServiciosDeMantenimiento(){ //Convierte la lista a un observable list
        ObservableList<ServicioDeMantenimiento> mantObservable = FXCollections.observableArrayList();
        mantObservable.addAll(Main.getListaDeServiciosDeMantenimiento());
        return mantObservable;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaEmprezas.getColumns().clear();                                        //Elementos de emprezas
        colEmpCedula.setCellValueFactory(new PropertyValueFactory<>("numCedula"));
        colEmpTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tablaEmprezas.setItems(agarrarLasEmprezasDeMantenimiento());
        tablaEmprezas.getColumns().addAll(colEmpCedula,colEmpTelefono);

        tablaVehiculos.getColumns().clear();                                        //Elementos de vehiculos
        colVehEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colVehPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tablaVehiculos.setItems(agarrarLosVehiculos());
        tablaVehiculos.getColumns().addAll(colVehEstado,colVehPlaca);

        tablaServicios.getColumns().clear();                                        //Elementos de servicios
        colSerId.setCellValueFactory(new PropertyValueFactory<>("idDeServicio"));
        colSerTipo.setCellValueFactory(new PropertyValueFactory<>("tipoDeServicio"));
        tablaServicios.setItems(agarrarLosServiciosDeMantenimiento());
        tablaServicios.getColumns().addAll(colSerId,colSerTipo);
    }
}