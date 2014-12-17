package co.reyesmagos.studiappcolegios.dominio.adaptadores.entities;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by oscargallon on 16/12/14.
 */
public class Materia {

    private String nombre;
    private Bitmap image;
    private List<Nota> listaNotas;
    private Nota notaFinal;

    public void calculaNotaFinal() {
        double i = 0;
        double nota = 0;
        for (Nota n : this.listaNotas) {
            if (n.getNota() != -1) {
                nota += (n.getNota() * n.getPorcentaje());
                i += n.getPorcentaje();
            }
        }
        Nota n1= new Nota();
        n1.setNota(nota/i);
        n1.setPorcentaje(i);
        this.notaFinal=n1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public Nota getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Nota notaFinal) {
        this.notaFinal = notaFinal;
    }

}
