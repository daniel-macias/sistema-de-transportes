package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ContAdminRegVehiculo implements Initializable {

    @FXML
    private JFXTextField placa;

    @FXML
    private JFXTextField anioDeFabricacion;

    @FXML
    private JFXTextField color;

    @FXML
    private JFXTextField marca;

    @FXML
    private JFXTextField capacidad;

    @FXML
    private JFXTextField kilometraje;

    @FXML
    private JFXTextField numeroVin;

    @FXML
    private JFXTextField sedeDePertenencia;

    @FXML
    private JFXComboBox<String> estado;
    ObservableList<String> list = FXCollections.observableArrayList("En Servicio", "En Mantenimiento", "Fuera de Servicio");

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    void registrarVehiculo(ActionEvent event) {
        if(placa.getText()!=null && anioDeFabricacion.getText()!=null && color.getText()!=null && marca.getText()!=null && capacidad.getText()!=null && kilometraje.getText()!=null && numeroVin.getText()!=null &&sedeDePertenencia.getText()!=null){
            boolean yaExisteVehiculo = false;
            for(Vehiculo v : Main.getListaDeVehiculos()){
                if(v.getPlaca().equals(placa.getText()))
                    yaExisteVehiculo = true;
            }

            if(!yaExisteVehiculo){
                try{
                    int tempEstado;
                    if(estado.getValue().equals("En Servicio"))
                        tempEstado = 1;
                    else if(estado.getValue().equals("En Mantenimiento"))
                        tempEstado = 2;
                    else
                        tempEstado = 3;
                    Vehiculo tempVehiculo = new Vehiculo(placa.getText(),Integer.parseInt(anioDeFabricacion.getText()), color.getText(), marca.getText(), Integer.parseInt(capacidad.getText()), Float.parseFloat(kilometraje.getText()), numeroVin.getText(),sedeDePertenencia.getText(), tempEstado);
                    Main.getListaDeVehiculos().add(tempVehiculo);
                }catch (Exception e){
                    System.out.println("ERROR: numero ingresado no es valido");
                }


            }else {
                System.out.println("ERROR: Ese vehiculo ya existe");
            }

        }else {
            System.out.println("ERROR: recordar ingresar todos los datos");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        estado.setItems(list); //meta las cosas al combobox

    }
}
