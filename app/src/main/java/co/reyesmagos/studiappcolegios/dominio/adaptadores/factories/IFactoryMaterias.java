package co.reyesmagos.studiappcolegios.dominio.adaptadores.factories;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.List;

import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Materia;

/**
 * Created by oscargallon on 16/12/14.
 */
public interface IFactoryMaterias {

    public List<Materia> getMaterias();

    public Materia createMateria(Bitmap imMateria, String nombre);

    public void cretateMaterias(Context context);
}
