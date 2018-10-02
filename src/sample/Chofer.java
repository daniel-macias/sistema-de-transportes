package sample;

import java.util.ArrayList;

public class Chofer {
    private String nombre;
    private int telefono;
    private String email;
    private String cedula;
    private ArrayList<Licencia> listaDeLicencias;

    public Chofer(String nombre, int telefono, String email, String cedula, ArrayList<Licencia> listaDeLicencias) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.cedula = cedula;
        this.listaDeLicencias = listaDeLicencias;
    }

    public void aniadirLicencia(Licencia licAAniadir){
        listaDeLicencias.add(licAAniadir);
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getCedula() {
        return cedula;
    }

    public ArrayList<Licencia> getListaDeLicencias() {
        return listaDeLicencias;
    }


}
