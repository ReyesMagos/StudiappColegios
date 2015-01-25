package co.reyesmagos.studiappcolegios.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.SparseBooleanArray;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Tareas;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterTareas;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.util.TareaDetail;
import co.reyesmagos.studiappcolegios.mocks.TareasFactory;

/**
 * Created by Alexis-PC on 27/11/2014.
 */
public class TareasFragmentActivity extends Fragment {

    private View rootView;
    private ExpandableListView listView;
    private ExpandableListView expandableListView2;
    private MenuItem mItem = null;
    CustomAdapterTareas customAdapterTareas2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tareas_activity, container, false);
        customAdapterTareas2 = new CustomAdapterTareas(rootView.getContext());
        setHasOptionsMenu(true);
        initComponents();
        return rootView;
    }


    public void initComponents() {
        expandableListView2 = (ExpandableListView)rootView.findViewById(R.id.expandableListView2);
        
        expandableListView2.setIndicatorBounds(expandableListView2.getRight() - 60, expandableListView2.getWidth() - 8);
        customAdapterTareas2 = new CustomAdapterTareas(rootView.getContext());


        boolean entro = true;
        for (int i = 0; i < TareasFactory.getInstance().size(); i++) {

            Date date = Calendar.getInstance().getTime();
            Date aux = TareasFactory.getInstance().get(i).getDate();

            if((aux.getMonth() == date.getMonth()) && (aux.getDay() > date.getDay() && aux.getDay() < date.getDay() + 7)){
                if(i == 0){
                   Tareas tareaAux = TareasFactory.getInstance().get(i);
                    tareaAux.setHeaderTitle("Próximos 7 días");
                    customAdapterTareas2.addSectionHeaderItem(tareaAux);
                    customAdapterTareas2.addTareaItem(TareasFactory.getInstance().get(i));
                }else{
                    customAdapterTareas2.addTareaItem(TareasFactory.getInstance().get(i));
                }
            }else if(entro){
                Tareas tarAux = TareasFactory.getInstance().get(i);
                tarAux.setHeaderTitle("Próximas semanas");
                customAdapterTareas2.addSectionHeaderItem(tarAux);
                entro = false;
            }else{
                customAdapterTareas2.addTareaItem(TareasFactory.getInstance().get(i));
            }

        }
        //expandableListView2.addHeaderView(getActivity().getLayoutInflater().inflate(R.layout.separator_tareas_list, null));
        expandableListView2.setAdapter(customAdapterTareas2);

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setDisplayShowTitleEnabled(false);

        expandableListView2.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long id) {

                for(int i = 0; i < customAdapterTareas2.getSectionHeader().size(); i++){
                    if(customAdapterTareas2.getSectionHeader().contains(groupPosition)){
                        return true;
                    }else
                        return false;
                }
                return false;
            }
        });

    }

    public ExpandableListView getListView() {
        return expandableListView2;
    }

    public void setListView(ExpandableListView listView) {
        this.expandableListView2 = listView;
    }

    public CustomAdapterTareas getCustomAdapterTareas2() {
        return customAdapterTareas2;
    }

    public void setCustomAdapterTareas2(CustomAdapterTareas customAdapterTareas2) {
        this.customAdapterTareas2 = customAdapterTareas2;
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

    public void fillOption(String option) {
        List<Tareas> tareas = TareasFactory.getInstance();
        List<Tareas> aux = new ArrayList<Tareas>();
        Tareas tareaAux = null;

        for (int i = 0; i < tareas.size(); i++) {
            tareaAux = tareas.get(i);
            if (option.equalsIgnoreCase("Matematicas")) {
                if (tareaAux.getMateria().equalsIgnoreCase("Matemáticas")) {
                    aux.add(tareaAux);
                }
            } else if (option.equalsIgnoreCase("Castellano")) {
                if (tareaAux.getMateria().equalsIgnoreCase("Castellano")) {
                    aux.add(tareaAux);
                }
            } else if (option.equalsIgnoreCase("Artistica")) {
                if (tareaAux.getMateria().equalsIgnoreCase("Artistica")) {
                    aux.add(tareaAux);
                }
            } else {
                aux = tareas;
            }
        }

        customAdapterTareas2 = new CustomAdapterTareas(rootView.getContext());

        boolean entro = true;
        for (int i = 0; i < aux.size(); i++) {

            Date date = Calendar.getInstance().getTime();
            Date aux1 = aux.get(i).getDate();

            if((aux1.getMonth() == date.getMonth()) && (aux1.getDay() > date.getDay() && aux1.getDay() < date.getDay() + 7)){
                if(i == 0){
                    Tareas tareaAux1 = aux.get(i);
                    tareaAux.setHeaderTitle("Próximos 7 días");
                    customAdapterTareas2.addSectionHeaderItem(tareaAux);
                    customAdapterTareas2.addTareaItem(aux.get(i));
                }else{
                    customAdapterTareas2.addTareaItem(aux.get(i));
                }
            }else if(entro){
                Tareas tarAux = aux.get(i);
                tarAux.setHeaderTitle("Próximas semanas");
                customAdapterTareas2.addSectionHeaderItem(tarAux);
                entro = false;
            }else{
                customAdapterTareas2.addTareaItem(aux.get(i));
            }

        }

        expandableListView2.setAdapter(customAdapterTareas2);
    }


}
