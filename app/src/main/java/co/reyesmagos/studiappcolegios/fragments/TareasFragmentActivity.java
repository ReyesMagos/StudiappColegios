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

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterTareas;
import co.reyesmagos.studiappcolegios.mocks.TareasFactory;

/**
 * Created by Alexis-PC on 27/11/2014.
 */
public class TareasFragmentActivity extends Fragment {

    private View rootView;
    private ExpandableListView listView;
    private MenuItem mItem = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tareas_activity, container, false);
        setHasOptionsMenu(true);
        initComponents();
        return rootView;
    }

    /**
     * changes commmit
     */
    public void initComponents() {
        listView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);

        listView.setIndicatorBounds(listView.getRight() - 60, listView.getWidth() - 8);
        CustomAdapterTareas customAdapterTareas = new CustomAdapterTareas(rootView.getContext(), TareasFactory.getInstance());
        listView.setAdapter(customAdapterTareas);

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setDisplayShowTitleEnabled(false);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(),
                R.array.spinner_items, android.R.layout.simple_spinner_item);

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

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
