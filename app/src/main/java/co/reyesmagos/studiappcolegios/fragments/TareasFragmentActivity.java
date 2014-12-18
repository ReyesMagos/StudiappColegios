package co.reyesmagos.studiappcolegios.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Tareas;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterTareas;
import co.reyesmagos.studiappcolegios.mocks.TareasFactory;

/**
 * Created by Alexis-PC on 27/11/2014.
 */
public class TareasFragmentActivity extends Fragment {

    private View rootView;
    private ExpandableListView listView;
    private MenuItem mItem = null;
    CustomAdapterTareas customAdapterTareas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tareas_activity, container, false);
        setHasOptionsMenu(true);
        initComponents();
        return rootView;
    }


    public void initComponents() {
        listView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);


        listView.setIndicatorBounds(listView.getRight() - 60, listView.getWidth() - 8);
        customAdapterTareas = new CustomAdapterTareas(rootView.getContext(), TareasFactory.getInstance());
        listView.setAdapter(customAdapterTareas);

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setDisplayShowTitleEnabled(false);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(),
                R.array.spinner_items, android.R.layout.simple_spinner_dropdown_item);

        menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.tarea_menu_spinner, menu);
        mItem = menu.findItem(R.id.menu_spinner);

        View view = mItem.getActionView();
        if (view instanceof Spinner) {
            final Spinner spinner = (Spinner) view;
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String optionSelected = adapterView.getSelectedItem().toString();
                    fillOption(optionSelected);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void fillOption(String option){
        List<Tareas> tareas = TareasFactory.getInstance();
        List<Tareas> aux = new ArrayList<Tareas>();
        Tareas tareaAux = null;

        for(int i = 0; i < tareas.size(); i++){
            tareaAux = tareas.get(i);
            if(option.equalsIgnoreCase("Matematicas")){
                if(tareaAux.getMateria().equalsIgnoreCase("Matemáticas")){
                    aux.add(tareaAux);
                }
            }else if (option.equalsIgnoreCase("Castellano")){
                if(tareaAux.getMateria().equalsIgnoreCase("Castellano")){
                    aux.add(tareaAux);
                }
            }else if (option.equalsIgnoreCase("Artistica")){
                if(tareaAux.getMateria().equalsIgnoreCase("Artistica")){
                    aux.add(tareaAux);
                }
            }else{
                aux = tareas;
            }
        }

        customAdapterTareas = new CustomAdapterTareas(rootView.getContext(), aux);
        listView.setAdapter(customAdapterTareas);
    }
}
