package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    private static ArrayList<Pasajero> listaDePasajeros = new ArrayList<>();
    private static ArrayList<Chofer> listaDeChoferes = new ArrayList<>();
    private static ArrayList<Viaje> listaDeViajes = new ArrayList<>();
    private static ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Sistema de Transporte");
        primaryStage.setScene(new Scene(root, 724, 508));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static ArrayList<Pasajero> getListaDePasajeros() {
        return listaDePasajeros;
    }

    public static ArrayList<Chofer> getListaDeChoferes() {
        return listaDeChoferes;
    }

    public static ArrayList<Viaje> getListaDeViajes() {
        return listaDeViajes;
    }

    public static ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }
}
