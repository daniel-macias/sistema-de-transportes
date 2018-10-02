package sample;

import java.time.LocalDate;

public class Licencia {
    private int numero;
    private String tipo;
    private LocalDate fechaDeEmision;
    private LocalDate fechaDeExpiracion;

    public Licencia(int numero, String tipo, LocalDate fechaDeEmision, LocalDate fechaDeExpiracion) {
        this.numero = numero;
        this.tipo = tipo;
        this.fechaDeEmision = fechaDeEmision;
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getFechaDeEmision() {
        return fechaDeEmision;
    }

    public LocalDate getFechaDeExpiracion() {
        return fechaDeExpiracion;
    }
}
