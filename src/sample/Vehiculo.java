package sample;

public class Vehiculo {
    enum Estado{
        EN_SERVICIO, EN_MANTENIMIENTO, FUERA_DE_SERVICIO
    }

    private String placa;
    private int anioFabricacion;
    private String color;
    private String marca;
    private int capacidad;
    private float kilometraje;
    private String numVin;
    private String sedePertenencia;
    private Estado estado;

    public Vehiculo(String placa, int anioFabricacion, String color, String marca, int capacidad, float kilometraje, String numVin, String sedePertenencia, int estado) {
        this.placa = placa;
        this.anioFabricacion = anioFabricacion;
        this.color = color;
        this.marca = marca;
        this.capacidad = capacidad;
        this.kilometraje = kilometraje;
        this.numVin = numVin;
        this.sedePertenencia = sedePertenencia;
        switch (estado){
            case 1:
                this.estado = Estado.EN_SERVICIO;
                break;
            case 2:
                this.estado = Estado.EN_MANTENIMIENTO;
                break;
            case 3:
                this.estado = Estado.FUERA_DE_SERVICIO;
                break;
        }
    }

    public String getPlaca() {
        return placa;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public String getNumVin() {
        return numVin;
    }

    public String getSedePertenencia() {
        return sedePertenencia;
    }

    public int getEstado(){
        switch (estado){
            case EN_SERVICIO:
                return 1;
            case EN_MANTENIMIENTO:
                return 2;
            case FUERA_DE_SERVICIO:
                return 3;
        }
        return 0;
    }
}
