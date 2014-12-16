package co.reyesmagos.studiappcolegios.dominio.adaptadores.factories.impl;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.List;

import co.reyesmagos.studiappcolegios.dominio.adaptadores.factories.IFactoryMaterias;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Materia;

/**
 * Created by oscargallon on 16/12/14.
 */
public class FactoryMaterias implements IFactoryMaterias {

    private List<Materia> listaMaterias;
    public static FactoryMaterias instance;

    private FactoryMaterias() {

    }

    public static FactoryMaterias getInstance() {
        if (instance == null)
            instance = new FactoryMaterias();
        return instance;
    }

    @Override
    public List<Materia> getMaterias() {
        return this.listaMaterias;
    }

    @Override
    public Materia createMateria(Bitmap imMateria, String nombre) {
        return null;
    }

    @Override
    public void cretateMaterias(Context context) {

    }


}
