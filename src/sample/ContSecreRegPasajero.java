package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ContSecreRegPasajero {

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField cedula;

    @FXML
    private JFXTextField direccion;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField telefono;

    @FXML
    private JFXButton registrar;

    @FXML
    void registrarPasajero(ActionEvent event) {
        if(nombre.getText()!=null && cedula.getText()!=null && direccion.getText()!=null && email.getText()!=null && telefono.getText()!=null){//mira si no están vacíos
            try{
                boolean pasajeroYaExiste = false;
                for(Pasajero p : Main.getListaDePasajeros()){ //Prueba para ver si ese pasajero ya existe
                    if(p.getCedula().equals(cedula.getText()))
                        pasajeroYaExiste = true;
                }
                if(!pasajeroYaExiste){
                    int tempNum = Integer.parseInt(telefono.getText());
                    Pasajero pa = new Pasajero(nombre.getText(), cedula.getText(), direccion.getText(), email.getText(), tempNum);
                    Main.getListaDePasajeros().add(pa);
                    System.out.println("Pasajero añadido: " + pa.getCedula());
                }else{
                    System.out.println("ERROR: Pasajero ya existía");
                }

            }catch(Exception e){
                System.out.println("ERROR: Ese número no es válido");
            }

        }else{
            System.out.println("ERROR: Todos los valores deben estar ingresados");
        }


    }
}
