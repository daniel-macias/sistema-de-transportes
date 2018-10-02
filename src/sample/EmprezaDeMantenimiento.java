package sample;

public class EmprezaDeMantenimiento {
    String razonSocial;
    String numCedula;
    int telefono;
    String direccion;

    public EmprezaDeMantenimiento(String razonSocial, String numCedula, int telefono, String direccion) {
        this.razonSocial = razonSocial;
        this.numCedula = numCedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
