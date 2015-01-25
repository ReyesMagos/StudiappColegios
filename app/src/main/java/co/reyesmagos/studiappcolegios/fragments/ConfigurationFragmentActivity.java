package co.reyesmagos.studiappcolegios.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by Alexis-PC on 09/01/2015.
 */
public class ConfigurationFragmentActivity extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.configuration_screen);
    }
}
