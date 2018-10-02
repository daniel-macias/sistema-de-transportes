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
    private float kilometrajeInicial;
    private float kilometrajeFinal;
    private ArrayList<Pasajero> listaDePasajeros;
    private String consecutivoDeViajes;
    private Estado estado;

    public Viaje(String puntoDeSalida, String destino, LocalDate fecha, LocalTime horaInicio, LocalTime horaFinal, Chofer chofer, float kilometrajeInicial, float kilometrajeFinal, ArrayList<Pasajero> listaDePasajeros, String consecutivoDeViajes, int estado) {
        this.puntoDeSalida = puntoDeSalida;
        this.destino = destino;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.chofer = chofer;
        this.kilometrajeInicial = kilometrajeInicial;
        this.kilometrajeFinal = kilometrajeFinal;
        this.listaDePasajeros = listaDePasajeros;
        this.consecutivoDeViajes = consecutivoDeViajes;

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
}
