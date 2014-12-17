package co.reyesmagos.studiappcolegios.dominio.adaptadores.factories.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

import co.reyesmagos.studiappcolegios.R;
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
        Materia materia= new Materia();
        materia.setImage(imMateria);
        materia.setNombre(nombre);
        return materia;
    }

    @Override
    public void cretateMaterias(Context context) {

        this.listaMaterias= new ArrayList<Materia>();
        Materia a = createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.mate),context.getResources().getString(R.string.matematicas_label));
        listaMaterias.add(a);

        a= createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.artistica),context.getResources().getString(R.string.artistica_label));

        listaMaterias.add(a);

        a= createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.espanol),context.getResources().getString(R.string.espanol_label));

        listaMaterias.add(a);

        a= createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ingles),context.getResources().getString(R.string.ingles_label));

        listaMaterias.add(a);

    }


}
