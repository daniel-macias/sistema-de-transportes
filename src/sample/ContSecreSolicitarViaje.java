package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContSecreSolicitarViaje implements Initializable  {
    private ArrayList<Pasajero> tempListaDePasajerosEnViaje = new ArrayList<>();

    @FXML
    private JFXTextField puntoDeSalida;

    @FXML
    private JFXTextField destino;

    @FXML
    private JFXTextField kmInicial;

    @FXML
    private JFXTextField kmFinal;

    @FXML
    private JFXButton solicitarViaje;

    @FXML
    private JFXDatePicker fecha;

    @FXML
    private JFXTimePicker horaDeInicio;

    @FXML
    private JFXTimePicker horaFinal;

    @FXML
    private JFXButton aniadirPasajero;

    @FXML
    private TableView<Pasajero> listaDePasajeros;

    @FXML
    private TableColumn<Pasajero, String> nombrePasajero;

    @FXML
    private TableColumn<Pasajero, String> nombreCarne;

    @FXML
    private JFXTextField carneDePasajero;

    @FXML
    private JFXTextField departamento;


    @FXML
    void aniadirPasajeroApretado(ActionEvent event) {           //Añade el pasajero que desea ser metido al viaje
        boolean pasajeroYaEstaEnViaje = false;
        for(Pasajero p : tempListaDePasajerosEnViaje){          //Verifica si este pasajero ya está en el viaje
            if(p.getCedula().equals(carneDePasajero.getText()))
                pasajeroYaEstaEnViaje = true;

        }
        if(!pasajeroYaEstaEnViaje){
            for(Pasajero p : Main.getListaDePasajeros()){
                if(p.getCedula().equals(carneDePasajero.getText())){
                    tempListaDePasajerosEnViaje.add(p);
                    System.out.println("Pasajero aniadido al viaje");
                }
            }
        }else {
            System.out.println("ERROR: ESTE PASAJERO YA ESTA EN ESTE VIAJE");
        }
    }

    @FXML
    void solicitarViajeApretado(ActionEvent event) { //La accion de solicitar el viaje en si
        try{ //Es para saber si es un float los valores de los kilomemtros

            //Esto seria para evitar el bug de pasar por referencia
            ArrayList<Pasajero> realAAgregar = new ArrayList<>();  //El new es el que arregla el error
            for(Pasajero p: tempListaDePasajerosEnViaje)
                realAAgregar.add(p);

            if(puntoDeSalida.getText()!=null && destino.getText()!=null && kmFinal.getText()!=null
                    && kmInicial.getText()!=null && fecha.getValue()!=null && horaDeInicio.getValue()!=null && horaFinal.getValue()!=null &&tempListaDePasajerosEnViaje.size() > 0){ //Verifica si esta lleno
                Viaje viajeTemp = new Viaje(puntoDeSalida.getText(),destino.getText(),fecha.getValue(),horaDeInicio.getValue(),horaFinal.getValue(),
                        Float.valueOf(kmInicial.getText()),Float.valueOf(kmFinal.getText()),realAAgregar);

                if(departamento.getText()!=null){
                    viajeTemp.setDepartamento(departamento.getText());
                }else {
                    System.out.println("ADVERTENCIA: un departamento no fue especificado");
                }

                Main.getListaDeViajes().add(viajeTemp);
                Viaje.numTotalDeViajes++;

                System.out.println("Viaje aniadido");
            }else {
                System.out.println("ERROR: Se deben llenar todos los valores");
            }
        }catch (Exception e){
            System.out.println("ERROR: Ese valor de kilometros no es valido");
        }
        tempListaDePasajerosEnViaje.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaDePasajeros.getColumns().clear();
        nombreCarne.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        nombrePasajero.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        listaDePasajeros.setItems(agarrarLosPasajeros());
        listaDePasajeros.getColumns().addAll(nombreCarne,nombrePasajero);

    }

    public ObservableList<Pasajero> agarrarLosPasajeros(){ //Convierte la lista a un observable list
        ObservableList<Pasajero> pasajerosObservable = FXCollections.observableArrayList();
        pasajerosObservable.addAll(Main.getListaDePasajeros());
        return pasajerosObservable;
    }
}

