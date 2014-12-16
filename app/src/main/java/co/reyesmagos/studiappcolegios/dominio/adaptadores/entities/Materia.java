package co.reyesmagos.studiappcolegios.dominio.adaptadores.entities;

import android.graphics.Bitmap;

/**
 * Created by oscargallon on 16/12/14.
 */
public class Materia {

    private String nombre;
    private Bitmap image;

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
}
