package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContSecreListarSolicitudes implements Initializable {

    @FXML
    private JFXTextField buscadorDestino;

    @FXML
    private JFXDatePicker buscadorFecha;

    @FXML
    private JFXComboBox<String> buscadorEstado;
    ObservableList<String> list = FXCollections.observableArrayList("En confeccion","Aprobado","Cancelado","No aprobado");

    @FXML
    private JFXButton btnSearchDestino;

    @FXML
    private JFXButton btnSearchFecha;

    @FXML
    private JFXButton btnSearchEstado;

    @FXML
    private TableView<Viaje> tablaViajes;

    @FXML
    private TableColumn<Viaje, String> viaID;

    @FXML
    private TableColumn<Viaje, String> viaFechaIngreso;

    @FXML
    private TableColumn<Viaje, String> viaEstado;

    @FXML
    private TableColumn<Viaje, String> viaDestino;

    @FXML
    private TableColumn<Viaje, String> viaInicioViaje;

    @FXML
    private TableView<Pasajero> tablaPasajeros;

    @FXML
    private TableColumn<Pasajero, String> nombrePasajero;

    @FXML
    private TableColumn<Pasajero, String> nombreCarne;

    @FXML
    private JFXTextField viajeEspecifico;

    @FXML
    private JFXButton btnMostrarInfo;

    @FXML
    private Text choferSelec;

    @FXML
    private Text vehiculoSelec;

    @FXML
    void buscarPorDestino(ActionEvent event) {
        ArrayList<Viaje>resultadosDeBusqueda = new ArrayList<>();
        for(Viaje v: Main.getListaDeViajes()){
            if(v.getDestino().equals(buscadorDestino.getText()))
                resultadosDeBusqueda.add(v);
        }
        tablaViajes.getItems().clear(); //Esto refresca el table view
        tablaViajes.setItems(agarrarLosViajes(resultadosDeBusqueda));
    }

    @FXML
    void buscarPorEstado(ActionEvent event) {
        ArrayList<Viaje>resultadosDeBusqueda = new ArrayList<>();
        int estadoTemp;
        if(buscadorEstado.getValue().equals("En confeccion"))
            estadoTemp=1;
        else if(buscadorEstado.getValue().equals("Aprobado"))
            estadoTemp=2;
        else if (buscadorEstado.getValue().equals("Cancelado"))
            estadoTemp=3;
        else if (buscadorEstado.getValue().equals("No aprobado"))
            estadoTemp=4;
        else
            estadoTemp =0;

        for(Viaje v: Main.getListaDeViajes()){
            if(v.getEstado()==estadoTemp)
                resultadosDeBusqueda.add(v);
        }
        tablaViajes.getItems().clear(); //Esto refresca el table view
        tablaViajes.setItems(agarrarLosViajes(resultadosDeBusqueda));


    }

    @FXML
    void buscarPorFecha(ActionEvent event) {
        ArrayList<Viaje>resultadosDeBusqueda = new ArrayList<>();
        for(Viaje v: Main.getListaDeViajes()){
            if(v.getTiempoQueViajeFueIngresado().equals(buscadorFecha.getValue()))
                resultadosDeBusqueda.add(v);
        }
        tablaViajes.getItems().clear(); //Esto refresca el table view
        tablaViajes.setItems(agarrarLosViajes(resultadosDeBusqueda));
    }

    @FXML
    void mostrarInfoEspecifica(ActionEvent event) {
        Viaje tempViaje = null;
        for(Viaje v: Main.getListaDeViajes()){
            if(v.getConsecutivoDeViajes().equals(viajeEspecifico.getText()))
                tempViaje = v;
        }

        if(tempViaje!=null){

            tablaPasajeros.getItems().clear();
            tablaPasajeros.setItems(agarrarLosPasajeros(tempViaje.getListaDePasajeros()));



            vehiculoSelec.setText(tempViaje.getVehiculo().getPlaca());
            choferSelec.setText(tempViaje.getChofer().getCedula());

            for(Pasajero p : tempViaje.getListaDePasajeros())
                System.out.println(p.getNombre());

            System.out.println("Largo de pasajeros " + tempViaje.getListaDePasajeros().size());

        }
    }

    public ObservableList<Pasajero> agarrarLosPasajeros(ArrayList<Pasajero> arrTemp){ //Convierte la lista a un observable list
        ObservableList<Pasajero> pasajerosObservable = FXCollections.observableArrayList();
        pasajerosObservable.addAll(arrTemp);
        return pasajerosObservable;
    }
    public ObservableList<Viaje> agarrarLosViajes(ArrayList<Viaje> arrTemp){ //Convierte la lista a un observable list
        ObservableList<Viaje> pasajerosObservable = FXCollections.observableArrayList();
        pasajerosObservable.addAll(arrTemp);
        return pasajerosObservable;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaViajes.getColumns().clear();
        //Metiendo los valores iniciales de viajes
        viaID.setCellValueFactory(new PropertyValueFactory<>("consecutivoDeViajes"));
        viaFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("tiempoQueViajeFueIngresado"));
        viaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        viaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        viaInicioViaje.setCellValueFactory(new PropertyValueFactory<>("puntoDeSalida"));
        tablaViajes.setItems(agarrarLosViajes(Main.getListaDeViajes()));
        tablaViajes.getColumns().addAll(viaID,viaFechaIngreso,viaEstado,viaDestino,viaInicioViaje);
        //Metiendo los valores de pasajeros
        tablaPasajeros.getColumns().clear();
        nombreCarne.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        nombrePasajero.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaPasajeros.getColumns().addAll(nombreCarne,nombrePasajero);

        buscadorEstado.setItems(list); //meta las cosas al combobox
    }
}
