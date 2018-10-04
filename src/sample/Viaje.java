package sample;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Viaje {
    enum Estado{
        EN_CONFECCION, APROVADO, CANCELADO, NO_APROVADO
    }
    public static int numTotalDeViajes;
    private String puntoDeSalida;
    private String destino;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private Chofer chofer;
    private Vehiculo vehiculo;
    private float kilometrajeInicial;
    private float kilometrajeFinal;
    private ArrayList<Pasajero> listaDePasajeros;
    private String consecutivoDeViajes;
    private Estado estado;
    private LocalDate tiempoQueViajeFueIngresado;

    public Viaje(String puntoDeSalida, String destino, LocalDate fecha, LocalTime horaInicio, LocalTime horaFinal, float kilometrajeInicial, float kilometrajeFinal, ArrayList<Pasajero> listaDePasajeros) {
        this.puntoDeSalida = puntoDeSalida;
        this.destino = destino;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.chofer = new Chofer();
        this.vehiculo = new Vehiculo();
        this.kilometrajeInicial = kilometrajeInicial;
        this.kilometrajeFinal = kilometrajeFinal;
        this.listaDePasajeros = listaDePasajeros;
        String numDeCeros = "";                             //Coloca la cantidad de ceros necesario para el consecutivo de viajes
        if(numTotalDeViajes<10)
            numDeCeros="00";
        else if(numTotalDeViajes<100)
            numDeCeros="0";
        this.consecutivoDeViajes = "VIA-" +numDeCeros+numTotalDeViajes;
        this.estado = Estado.EN_CONFECCION;
        this.tiempoQueViajeFueIngresado = LocalDate.now();

    }

    public static int getNumTotalDeViajes() {
        return numTotalDeViajes;
    }

    public String getPuntoDeSalida() {
        return puntoDeSalida;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public float getKilometrajeInicial() {
        return kilometrajeInicial;
    }

    public float getKilometrajeFinal() {
        return kilometrajeFinal;
    }

    public ArrayList<Pasajero> getListaDePasajeros() {
        return listaDePasajeros;
    }

    public String getConsecutivoDeViajes() {
        return consecutivoDeViajes;
    }

    public int getEstado() {
        switch (estado){
            case EN_CONFECCION:
                return 1;
            case APROVADO:
                return 2;
            case CANCELADO:
                return 3;
            case NO_APROVADO:
                return 4;
        }
        return 0;
    }

    public void setEstado(int estado) {
        switch (estado){
            case 1:
                this.estado = Estado.EN_CONFECCION;
                break;
            case 2:
                this.estado = Estado.APROVADO;
                break;
            case 3:
                this.estado = Estado.CANCELADO;
                break;
            case 4:
                this.estado = Estado.NO_APROVADO;
                break;
        }
    }

    public LocalDate getTiempoQueViajeFueIngresado() {
        return tiempoQueViajeFueIngresado;
    }
}
