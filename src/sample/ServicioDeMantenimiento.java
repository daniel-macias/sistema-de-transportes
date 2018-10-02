package sample;

import java.time.LocalDate;

public class ServicioDeMantenimiento {
    enum TipoDeServicio{
        PREVENTIVO,CORRECTIVO
    }
    private static int numDeServiciosDeMantemiento;
    private String idDeServicio;
    private LocalDate fechaDeInicio;
    private LocalDate fechaDeFinalizacion;
    private float montoPagado;
    private String detalleDeActividad;
    private TipoDeServicio tipoDeServicio;
    private EmprezaDeMantenimiento emprezaRealizadora;

    public ServicioDeMantenimiento(String idDeServicio, LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, float montoPagado, String detalleDeActividad, int tipoDeServicio, EmprezaDeMantenimiento emprezaRealizadora) {
        this.idDeServicio = idDeServicio;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
        this.montoPagado = montoPagado;
        this.detalleDeActividad = detalleDeActividad;
        this.emprezaRealizadora = emprezaRealizadora;

        switch (tipoDeServicio){
            case 1:
                this.tipoDeServicio = TipoDeServicio.PREVENTIVO;
                break;
            case 2:
                this.tipoDeServicio = TipoDeServicio.CORRECTIVO;
                break;
        }
    }

    public static int getNumDeServiciosDeMantemiento() {
        return numDeServiciosDeMantemiento;
    }

    public String getIdDeServicio() {
        return idDeServicio;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public LocalDate getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    public float getMontoPagado() {
        return montoPagado;
    }

    public String getDetalleDeActividad() {
        return detalleDeActividad;
    }

    public int getTipoDeServicio() {
        switch (tipoDeServicio){
            case PREVENTIVO:
                return 1;
            case CORRECTIVO:
                return 2;
        }
        return 0;
    }

    public EmprezaDeMantenimiento getEmprezaRealizadora() {
        return emprezaRealizadora;
    }
}
