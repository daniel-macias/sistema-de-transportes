package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    void aprobarViaje(ActionEvent event) throws IOException {
        Vehiculo vehiculoAMeter = new Vehiculo();
        Chofer choferAMeter = new Chofer();
        int condicionesAceptadas = 0; //esto es usado para saber si se llenaron los valores para hacer un viaje

        if(idField.getText()!= null && carneField.getText() != null && placaField != null){ //Verificando que esta lleno
            for(Vehiculo v : Main.getListaDeVehiculos()){  //Buscando el vehiculo para meterlo al viaje
                if(v.getPlaca().equals(placaField.getText())){
                    vehiculoAMeter = v;
                    condicionesAceptadas++;
                }

            }

            for(Chofer c: Main.getListaDeChoferes()){
                if(c.getCedula().equals(carneField.getText())){
                    choferAMeter = c;
                    condicionesAceptadas++;
                }
            }

        }else {
            System.out.println("ERROR: Llenar todos los valores por favor");
        }

        if(condicionesAceptadas > 1){
            //Primero se busca la existencia de este viaje
            Viaje viajeAModificar = null;
            for(Viaje v: Main.getListaDeViajes()){
                if(v.getConsecutivoDeViajes().equals(idField.getText()))
                    viajeAModificar = v;
            }
            if(viajeAModificar!=null){
                viajeAModificar.setEstado(2); //Cambiando el estado del viaje
                viajeAModificar.setChofer(choferAMeter);
                viajeAModificar.setVehiculo(vehiculoAMeter);
                Main.guardarListaDeViajes();
                tablaViajes.getItems().clear(); //Esto refresca el table view
                tablaViajes.setItems(agarrarLosViajes(Main.getListaDeViajes()));
                String direcciones = "";
                for (Pasajero p : viajeAModificar.getListaDePasajeros()){
                    direcciones += p.getEmail();
                    direcciones += ",";
                }
                direcciones += viajeAModificar.getChofer().getEmail();
                new Mailing().sendMail(direcciones, "Viaje aprobado", "El viaje con sentido " + viajeAModificar.getPuntoDeSalida()
                        + " - " + viajeAModificar.getDestino() + " que sale a las " + viajeAModificar.getHoraInicio() + " el dia "
                        + viajeAModificar.getFecha() + " ha sido aprobado.");
                System.out.println("Viaje aprobado!");
            }else {
                System.out.println("ERROR: Ese viaje no existe");
            }
        }
    }

    @FXML
    void cancelarViaje(ActionEvent event) throws IOException {
        //Primero se busca la existencia de este viaje
        Viaje viajeAModificar = null;
        for(Viaje v: Main.getListaDeViajes()){
            if(v.getConsecutivoDeViajes().equals(idField.getText()))
                viajeAModificar = v;
        }
        if(viajeAModificar!=null){
            viajeAModificar.setEstado(3); //Cambiando el estado del viaje
            Main.guardarListaDeViajes();
            tablaViajes.getItems().clear(); //Esto refresca el table view
            tablaViajes.setItems(agarrarLosViajes(Main.getListaDeViajes()));
            String direcciones = "";
            for (Pasajero p : viajeAModificar.getListaDePasajeros()){
                direcciones += p.getEmail();
                direcciones += ",";
            }
            direcciones += viajeAModificar.getChofer().getEmail();
            new Mailing().sendMail(direcciones, "Viaje cancelado", "El viaje con sentido " + viajeAModificar.getPuntoDeSalida()
                    + " - " + viajeAModificar.getDestino() + " que sale a las " + viajeAModificar.getHoraInicio() + " el dia "
                    + viajeAModificar.getFecha() + " ha sido cancelado.");
            System.out.println("Viaje cancelado!");
        }else {
            System.out.println("ERROR: Ese viaje no existe");
        }
    }

    @FXML
    void denegarViaje(ActionEvent event) throws IOException {
        //Primero se busca la existencia de este viaje
        Viaje viajeAModificar = null;
        for(Viaje v: Main.getListaDeViajes()){
            if(v.getConsecutivoDeViajes().equals(idField.getText()))
                viajeAModificar = v;
        }
        if(viajeAModificar!=null){
            viajeAModificar.setEstado(4); //Cambiando el estado del viaje
            Main.guardarListaDeViajes();
            tablaViajes.getItems().clear(); //Esto refresca el table view
            tablaViajes.setItems(agarrarLosViajes(Main.getListaDeViajes()));
            String direcciones = "";
            for (Pasajero p : viajeAModificar.getListaDePasajeros()){
                direcciones += p.getEmail();
                direcciones += ",";
            }
            direcciones += viajeAModificar.getChofer().getEmail();
            new Mailing().sendMail(direcciones, "Viaje denegado", "El viaje con sentido " + viajeAModificar.getPuntoDeSalida()
                    + " - " + viajeAModificar.getDestino() + " que sale a las " + viajeAModificar.getHoraInicio() + " el dia "
                    + viajeAModificar.getFecha() + " ha sido denegado.");
            System.out.println("Viaje denegado!");
        }else {
            System.out.println("ERROR: Ese viaje no existe");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Acciones para la tabla de viajes
        tablaViajes.getColumns().clear();
        viaId.setCellValueFactory(new PropertyValueFactory<>("consecutivoDeViajes"));
        viaPuntDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        viaFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("tiempoQueViajeFueIngresado"));
        viaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        viaEscuela.setCellValueFactory(new PropertyValueFactory<>("departamento"));

        tablaViajes.setItems(agarrarLosViajes(Main.getListaDeViajes()));
        tablaViajes.getColumns().addAll(viaId,viaPuntDestino,viaFechaIngreso,viaEstado,viaEscuela);

        //Acciones para la tabla de choferes
        tablaChofer.getColumns().clear();
        choNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        choCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));

        tablaChofer.setItems(agarrarLosChoferes(Main.getListaDeChoferes()));
        tablaChofer.getColumns().addAll(choNombre,choCedula);

        //Acciones para la tabla de vehiculos
        tablaVehiculo.getColumns().clear();
        vehPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        vehEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        vehCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));

        tablaVehiculo.setItems(agarrarLosVehiculos(Main.getListaDeVehiculos()));
        tablaVehiculo.getColumns().addAll(vehPlaca,vehEstado,vehCapacidad);

    }

    public ObservableList<Viaje> agarrarLosViajes(ArrayList<Viaje> arrVia){ //Convierte la lista a un observable list
        ObservableList<Viaje> viaObservable = FXCollections.observableArrayList();
        viaObservable.addAll(arrVia);
        return viaObservable;
    }

    public ObservableList<Vehiculo> agarrarLosVehiculos(ArrayList<Vehiculo> arrVeh){ //Convierte la lista a un observable list
        ObservableList<Vehiculo> vehObservable = FXCollections.observableArrayList();
        vehObservable.addAll(arrVeh);
        return vehObservable;
    }

    public ObservableList<Chofer> agarrarLosChoferes(ArrayList<Chofer> arrCho){ //Convierte la lista a un observable list
        ObservableList<Chofer> choObservable = FXCollections.observableArrayList();
        choObservable.addAll(arrCho);
        return choObservable;
    }
}
