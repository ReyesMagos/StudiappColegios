package co.reyesmagos.studiappcolegios.fragments.adaptadores.teacher;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by oscargallon on 1/02/15.
 */
public class HorarioFragment extends Fragment {
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.agenda, container, false);

        //initComponents();
        return rootView;
    }



}
