package co.reyesmagos.studiappcolegios.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by Alexis-PC on 27/11/2014.
 */
public class NotasFragmentActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notas_fragment_activity, container, false);
        return rootView;
    }
}
