package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {
    private static ArrayList<Pasajero> listaDePasajeros = new ArrayList<>();
    private static ArrayList<Chofer> listaDeChoferes = new ArrayList<>();
    private static ArrayList<Viaje> listaDeViajes = new ArrayList<>();
    private static ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadListaDePasajeros();
        loadListaDeChoferes();
        loadListaDeViajes();
        loadListaDeVehiculos();
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

    public static void loadListaDePasajeros() throws FileNotFoundException {

        JsonReader readerPasajeros = new JsonReader(new FileReader(System.getProperty("user.dir") + "/DB/pasajerosDB.json"));
        listaDePasajeros = new Gson().fromJson(readerPasajeros, new TypeToken<ArrayList<Pasajero>>(){}.getType());
    }

    public static void loadListaDeChoferes() throws FileNotFoundException {

        JsonReader readerChoferes = new JsonReader(new FileReader(System.getProperty("user.dir") + "/DB/choferesDB.json"));
        listaDeChoferes = new Gson().fromJson(readerChoferes, new TypeToken<ArrayList<Chofer>>(){}.getType());
    }

    public static void loadListaDeViajes() throws FileNotFoundException {

        JsonReader readerViajes = new JsonReader(new FileReader(System.getProperty("user.dir") + "/DB/viajesDB.json"));
        listaDeViajes = new Gson().fromJson(readerViajes, new TypeToken<ArrayList<Viaje>>(){}.getType());
    }

    public static void loadListaDeVehiculos() throws FileNotFoundException {

        JsonReader readerVehiculos = new JsonReader(new FileReader(System.getProperty("user.dir") + "/DB/vehiculosDB.json"));
        listaDeVehiculos = new Gson().fromJson(readerVehiculos, new TypeToken<ArrayList<Vehiculo>>(){}.getType());
    }

    public static void guardarListaDePasajeros() throws IOException {

        BufferedWriter writerPasajeros = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/DB/pasajerosDB.json"));
        writerPasajeros.write(new Gson().toJson(listaDePasajeros));
        writerPasajeros.close();
    }

    public static void guardarListaDeChoferes() throws IOException {

        BufferedWriter writerChoferes = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/DB/choferesDB.json"));
        writerChoferes.write(new Gson().toJson(listaDeChoferes));
        writerChoferes.close();
    }

    public static void guardarListaDeViajes() throws IOException {

        BufferedWriter writerViajes = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/DB/viajesDB.json"));
        writerViajes.write(new Gson().toJson(listaDeViajes));
        writerViajes.close();
    }

    public static void guardarListaDeVehiculos() throws IOException {

        BufferedWriter writerVehiculos = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/DB/vehiculosDB.json"));
        writerVehiculos.write(new Gson().toJson(listaDeVehiculos));
        writerVehiculos.close();
    }
}
