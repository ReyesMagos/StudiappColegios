package co.reyesmagos.studiappcolegios.controladores;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import co.reyesmagos.studiappcolegios.activities.LoginActivity;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.User;
import co.reyesmagos.studiappcolegios.services.util.Utilities;

/**
 * Created by Alexis-PC on 09/01/2015.
 */
public class RegisterController {

    private Activity context;

    public RegisterController(Activity context) {
        super();
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public void registerUser(User user) {
        final Utilities utilities = new Utilities(context);
        utilities.showDialog("Registrando","Registrando espere por favor", false );

        ParseUser parseUser = new ParseUser();
        parseUser.setUsername(user.getName());
        parseUser.setPassword(user.getPassword());
        parseUser.setEmail(user.getEmail());
        parseUser.put("rol", user.getRol());

        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    utilities.cancelDialog();
                    Toast.makeText(context, "El Registro fue exitoso", Toast.LENGTH_LONG).show();
                    context.finish();

                } else {
                    utilities.cancelDialog();
                    Toast.makeText(context, "Hubo un problema a la hora del registro, intentalo de nuevo mas tarde",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        Log.d("RegisterController", "Sali del registro");

    }
}
