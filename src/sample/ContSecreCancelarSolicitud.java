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

public class ContSecreCancelarSolicitud implements Initializable {

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private TableView<Viaje> tabladeViajes;

    @FXML
    private TableColumn<Viaje, String> viaID;

    @FXML
    private TableColumn<Viaje, String> viaPuntoDeSalida;

    @FXML
    private TableColumn<Viaje, String> viaDestino;

    @FXML
    private TableColumn<Viaje, String> viaFecha;

    @FXML
    private TableColumn<Viaje, String> viaHoraInicio;

    @FXML
    private TableColumn<Viaje, String> viaHoraFinal;

    @FXML
    private TableColumn<Viaje, String> viaEstado;

    @FXML
    private TableColumn<Viaje, String> viaKmInicial;

    @FXML
    private TableColumn<Viaje, String> viaKmFinal;

    @FXML
    private TableColumn<Viaje, String> viaTiempoIngresado;


    @FXML
    private JFXTextField idDeViajeACancelar;

    @FXML
    void cancelarViaje(ActionEvent event) throws IOException {
        if(idDeViajeACancelar.getText()!=null){
            for(Viaje v : Main.getListaDeViajes()){
                if(v.getConsecutivoDeViajes().equals(idDeViajeACancelar.getText()))
                    v.setEstado(3);
            }
            Main.guardarListaDeViajes();
            tabladeViajes.getItems().clear(); //Esto refresca el table view
            tabladeViajes.setItems(agarrarLosViajes(Main.getListaDeViajes()));

        }else {
            System.out.println("ERROR: Por favor ingresar que viaja desea cancelar");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabladeViajes.getColumns().clear();
        viaID.setCellValueFactory(new PropertyValueFactory<>("consecutivoDeViajes"));
        viaPuntoDeSalida.setCellValueFactory(new PropertyValueFactory<>("puntoDeSalida"));
        viaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        viaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        viaHoraInicio.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        viaHoraFinal.setCellValueFactory(new PropertyValueFactory<>("horaFinal"));
        viaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        viaKmInicial.setCellValueFactory(new PropertyValueFactory<>("kilometrajeInicial"));
        viaKmFinal.setCellValueFactory(new PropertyValueFactory<>("kilometrajeFinal"));
        viaTiempoIngresado.setCellValueFactory(new PropertyValueFactory<>("tiempoQueViajeFueIngresado"));

        tabladeViajes.setItems(agarrarLosViajes(Main.getListaDeViajes()));
        tabladeViajes.getColumns().addAll(viaID,viaPuntoDeSalida,viaDestino,viaFecha,viaHoraInicio,viaHoraFinal,viaEstado,viaKmInicial,viaKmFinal,viaTiempoIngresado);
    }

    public ObservableList<Viaje> agarrarLosViajes(ArrayList<Viaje> arrVia){ //Convierte la lista a un observable list
        ObservableList<Viaje> viaObservable = FXCollections.observableArrayList();
        viaObservable.addAll(arrVia);
        return viaObservable;
    }
}
