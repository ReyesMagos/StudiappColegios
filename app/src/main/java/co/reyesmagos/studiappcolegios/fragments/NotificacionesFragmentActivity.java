package co.reyesmagos.studiappcolegios.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterNotificaciones;

/**
 * Created by Alexis-PC on 27/11/2014.
 */
public class NotificacionesFragmentActivity extends Fragment {

    private ListView listView;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.novedades_fragment_activity, container, false);

        initComponents();
        return rootView;
    }

    public void initComponents() {
        this.listView = (ListView) rootView.findViewById(R.id.listView);

        List<String> novedades = new ArrayList<String>();
        novedades.add("Tareas");

        CustomAdapterNotificaciones customAdapterNotificaciones = new CustomAdapterNotificaciones(rootView.getContext(), novedades);

        listView.setAdapter(customAdapterNotificaciones);
    }
}
