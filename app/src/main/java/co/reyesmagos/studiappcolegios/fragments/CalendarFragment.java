package co.reyesmagos.studiappcolegios.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by Alexis-PC on 16/01/2015.
 */
public class CalendarFragment extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.calendar_activity, container, false);

        //initComponents();
        return rootView;
    }
}
