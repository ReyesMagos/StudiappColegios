package co.reyesmagos.studiappcolegios.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterTareas;
import co.reyesmagos.studiappcolegios.mocks.TareasFactory;

/**
 * Created by Alexis-PC on 27/11/2014.
 */
public class TareasFragmentActivity extends Fragment {

    private View rootView;
    private ExpandableListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.tareas_activity, container, false);
        initComponents();
        return rootView;
    }

    /**
     * Updating commit
     */
    public void initComponents(){
        listView = (ExpandableListView)rootView.findViewById(R.id.expandableListView);

        listView.setIndicatorBounds(listView.getRight() - 60,listView.getWidth() - 8);
        CustomAdapterTareas customAdapterTareas = new CustomAdapterTareas(rootView.getContext(), TareasFactory.getInstance());
        listView.setAdapter(customAdapterTareas);

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

    }

}
