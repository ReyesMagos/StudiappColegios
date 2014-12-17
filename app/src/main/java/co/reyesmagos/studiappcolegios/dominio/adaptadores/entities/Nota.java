package co.reyesmagos.studiappcolegios.dominio.adaptadores.entities;

/**
 * Created by oscargallon on 15/12/14.
 */
public class Nota {


    private double nota;
    private double porcentaje;
    private String motivo;

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
