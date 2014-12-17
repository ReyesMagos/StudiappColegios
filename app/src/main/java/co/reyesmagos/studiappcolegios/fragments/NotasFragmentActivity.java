package co.reyesmagos.studiappcolegios.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.activities.MateriaActivity;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.NotaCustomAdapter;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Materia;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.factories.impl.FactoryMaterias;

/**
 * Created by oscargallon on 15/12/14.
 */
public class NotasFragmentActivity extends Fragment {

    private View rootView;
    private GridView gridNotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.grid_notas_layout, container,
                false);
        setHasOptionsMenu(true);
        initComponents();
        return rootView;

    }

    public void initComponents() {
        gridNotas = (GridView) rootView.findViewById(R.id.grid_notas);
        FactoryMaterias.getInstance().cretateMaterias(getActivity().getApplicationContext());
        NotaCustomAdapter notaCustomAdapter = new NotaCustomAdapter(getActivity().getApplicationContext(),
                FactoryMaterias.getInstance().getMaterias());
        gridNotas.setAdapter(notaCustomAdapter);
        gridNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Materia materia = (Materia) adapterView.getAdapter().getItem(i);
                FactoryMaterias.getInstance().setMateriaAMostrar(materia);
                Intent intent = new Intent(getActivity(), MateriaActivity.class);
                getActivity().startActivity(intent);

            }
        });


    }

}