package co.reyesmagos.studiappcolegios.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Tareas;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterNotificaciones;
import co.reyesmagos.studiappcolegios.mocks.TareasFactory;

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

        List<Object> novedades = new ArrayList<Object>();
        List<Tareas> tareasList = TareasFactory.getInstance();

        for(int i = 0; i < tareasList.size(); i++){
            novedades.add(tareasList.get(i));
        }

        CustomAdapterNotificaciones customAdapterNotificaciones = new CustomAdapterNotificaciones(rootView.getContext(),
                novedades);


        listView.setAdapter(customAdapterNotificaciones);
    }
}
