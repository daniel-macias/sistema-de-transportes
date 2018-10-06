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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContAdminRegChofer implements Initializable {
    ArrayList<Licencia> tempListaDeLicencias = new ArrayList<>();
    ArrayList<Licencia> licenciasDelChoferAAgregar = new ArrayList<>();

    @FXML
    private JFXTextField nombreC;

    @FXML
    private JFXTextField telefonoC;

    @FXML
    private JFXTextField emailC;

    @FXML
    private JFXTextField cedulaC;

    @FXML
    private JFXTextField numeroL;

    @FXML
    private JFXTextField tipoL;

    @FXML
    private JFXButton btnRegistrarChofer;

    @FXML
    private JFXDatePicker fechaDeEmisionL;

    @FXML
    private JFXDatePicker fechaDeExpiracionL;

    @FXML
    private JFXButton btnCrearLicencia;

    @FXML
    private TableView<Licencia> tablaLicencias;

    @FXML
    private TableColumn<Licencia, String> colNumero;

    @FXML
    private TableColumn<Licencia, String> colExpiracion;

    @FXML
    private JFXTextField ingresadorDeCedula;

    @FXML
    private JFXButton btnAgregarLicencia;

    @FXML
    void agregarLicencia(ActionEvent event) {
        for(Licencia l : tempListaDeLicencias){
            if(l.getNumero() == Integer.parseInt(ingresadorDeCedula.getText())){
                licenciasDelChoferAAgregar.add(l);
                System.out.println("Licencia agregada!!");
            }
        }

    }

    @FXML
    void crearLicencia(ActionEvent event) {
        if(numeroL.getText()!=null && tipoL.getText()!=null && fechaDeEmisionL.getValue()!=null && fechaDeExpiracionL.getValue()!=null){
            try{
                boolean yaExisteLicencia = false;
                for(Licencia l : tempListaDeLicencias){ //ver si ya existe licencia
                    if(l.getNumero()==Integer.parseInt(numeroL.getText()))
                        yaExisteLicencia = true;
                }
                if(!yaExisteLicencia){
                    Licencia tempL = new Licencia(Integer.parseInt(numeroL.getText()),tipoL.getText(),fechaDeEmisionL.getValue(),fechaDeExpiracionL.getValue());
                    tempListaDeLicencias.add(tempL);

                    tablaLicencias.getItems().clear(); //Esto refresca el table view
                    tablaLicencias.setItems(agarrarLasLicencias());

                }else {
                    System.out.println("ERROR: esa licencia ya existe");
                }

            }catch (Exception e ){
                System.out.println("ERROR:  numero de licencia no  valido");
            }
        }else{
            System.out.println("ERROR: recordar llenar todos los valores");
        }
    }

    @FXML
    void registrarChofer(ActionEvent event) {
        if(nombreC.getText()!=null && telefonoC.getText()!=null && emailC.getText()!=null && cedulaC.getText()!=null && tempListaDeLicencias.size() > 0){
            try {
                boolean yaExisteChofer = false;
                for(Chofer c : Main.getListaDeChoferes()){  //ver si ya existe chofer
                    if(cedulaC.getText().equals(c.getCedula()))
                        yaExisteChofer = true;
                }
                if (!yaExisteChofer) {
                    Chofer tempChofer = new Chofer(nombreC.getText(), Integer.parseInt(telefonoC.getText()), emailC.getText(),cedulaC.getText(),licenciasDelChoferAAgregar);
                    Main.getListaDeChoferes().add(tempChofer);
                    System.out.println("Chofer añadido");
                }else {
                    System.out.println("ERROR: ese chofer ya fue agregado");
                }

            }catch (Exception e){
                System.out.println("ERROR: numero de licencia no valido");
            }

        }else {
            System.out.println("ERROR: recordar llenar todos los valores incluyendo mas de una licencia");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaLicencias.getColumns().clear();
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colExpiracion.setCellValueFactory(new PropertyValueFactory<>("fechaDeExpiracion"));
        tablaLicencias.setItems(agarrarLasLicencias());
        tablaLicencias.getColumns().addAll(colNumero,colExpiracion);
    }

    public ObservableList<Licencia> agarrarLasLicencias(){ //Convierte la lista a un observable list
        ObservableList<Licencia> licObservable = FXCollections.observableArrayList();
        licObservable.addAll(tempListaDeLicencias);
        return licObservable;
    }
}
