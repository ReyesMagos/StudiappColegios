package co.reyesmagos.studiappcolegios.dominio.adaptadores.factories.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Nota;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.factories.IFactoryMaterias;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Materia;

/**
 * Created by oscargallon on 16/12/14.
 */
public class FactoryMaterias implements IFactoryMaterias {

    private List<Materia> listaMaterias;
    public static FactoryMaterias instance;
    private Materia materiaAMostrar;

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
        Materia materia = new Materia();
        materia.setImage(imMateria);
        materia.setNombre(nombre);
        return materia;
    }

    @Override
    public void cretateMaterias(Context context) {

        this.listaMaterias = new ArrayList<Materia>();
        Materia a = createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.mate), context.getResources().getString(R.string.matematicas_label));

        List<Nota> listaNotas = new ArrayList<Nota>();
        Nota nota = new Nota();


        nota.setNota(4.2);
        nota.setMotivo(context.getResources().getString(R.string.tarea1_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(2.2);
        nota.setMotivo(context.getResources().getString(R.string.tarea2_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(3.2);
        nota.setMotivo(context.getResources().getString(R.string.tarea3_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(-1);
        nota.setMotivo(context.getResources().getString(R.string.tarea4_label));
        listaNotas.add(nota);

        a.setListaNotas(listaNotas);
        a.calculaNotaFinal();
        listaMaterias.add(a);


        a = createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.artistica), context.getResources().getString(R.string.artistica_label));

        listaNotas = new ArrayList<Nota>();

        nota = new Nota();

        nota.setNota(2.2);
        nota.setMotivo(context.getResources().getString(R.string.tarea1_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(2.4);
        nota.setMotivo(context.getResources().getString(R.string.tarea2_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(1.4);
        nota.setMotivo(context.getResources().getString(R.string.tarea3_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(3.8);
        nota.setMotivo(context.getResources().getString(R.string.evaluacion1_label));
        listaNotas.add(nota);

        a.setListaNotas(listaNotas);
        a.calculaNotaFinal();


        listaMaterias.add(a);

        a = createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.espanol), context.getResources().getString(R.string.espanol_label));

        listaNotas = new ArrayList<Nota>();

        nota = new Nota();
        nota.setNota(1.2);
        nota.setMotivo(context.getResources().getString(R.string.tarea1_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(3.2);
        nota.setMotivo(context.getResources().getString(R.string.tarea2_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(2.0);
        nota.setMotivo(context.getResources().getString(R.string.tarea3_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(-1);
        nota.setMotivo(context.getResources().getString(R.string.tarea4_label));
        listaNotas.add(nota);

        a.setListaNotas(listaNotas);
        a.calculaNotaFinal();


        listaMaterias.add(a);

        a = createMateria(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ingles), context.getResources().getString(R.string.ingles_label));

        listaNotas = new ArrayList<Nota>();

        nota = new Nota();
        nota.setNota(4.2);
        nota.setMotivo(context.getResources().getString(R.string.tarea1_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(4.2);
        nota.setMotivo(context.getResources().getString(R.string.evaluacion1_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(4.0);
        nota.setMotivo(context.getResources().getString(R.string.tarea2_label));
        listaNotas.add(nota);

        nota = new Nota();
        nota.setNota(-1);
        nota.setMotivo(context.getResources().getString(R.string.evaluacion2_label));
        listaNotas.add(nota);

        a.setListaNotas(listaNotas);
        a.calculaNotaFinal();

        listaMaterias.add(a);

    }

    public Materia getMateriaAMostrar() {
        return materiaAMostrar;
    }

    public void setMateriaAMostrar(Materia materiaAMostrar) {
        this.materiaAMostrar = materiaAMostrar;
    }
}
