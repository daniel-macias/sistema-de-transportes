package sample;

public class Pasajero {
    private String nombre;
    private String cedula;
    private String direccion;
    private String email;
    private int telefono;

    public Pasajero(String nombre, String cedula, String direccion, String email, int telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }
}
