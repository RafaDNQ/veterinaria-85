
package Entidades;

public class Tratamiento {
    
    private int idTratamiento;
    private String tipoTratamiento;
    private String descripcion;
    private double importe;
    private boolean activo;

    public Tratamiento(int idTratamiento, String tipoTratamiento, String descripcion, double inporte, boolean activo) {
        this.idTratamiento = idTratamiento;
        this.tipoTratamiento = tipoTratamiento;
        this.descripcion = descripcion;
        this.importe = inporte;
        this.activo = activo;
    }

    public Tratamiento(String tipoTratamiento, String descripcion, double inporte, boolean activo) {
        this.tipoTratamiento = tipoTratamiento;
        this.descripcion = descripcion;
        this.importe = inporte;
        this.activo = activo;
    }

    public Tratamiento() {
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double inporte) {
        this.importe = inporte;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return tipoTratamiento;
    }

   
    
    
    
    
    
}
