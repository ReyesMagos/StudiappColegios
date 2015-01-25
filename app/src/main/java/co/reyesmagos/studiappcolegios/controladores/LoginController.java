package co.reyesmagos.studiappcolegios.controladores;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import co.reyesmagos.studiappcolegios.activities.NavigationActivityMain;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.User;
import co.reyesmagos.studiappcolegios.services.util.Utilities;

/**
 * Created by Alexis-PC on 09/01/2015.
 */
public class LoginController {

    private Activity context;

    public LoginController(Activity context) {
        super();
        this.context = context;
    }

    public void loginUser(User user) {
        final Utilities utilities = new Utilities(context);
        utilities.showDialog("Iniciando Sesión", "Iniciando Sesión, por favor espere", false);

        ParseUser.logInInBackground(user.getName(), user.getPassword(), new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    utilities.cancelDialog();
                    context.startActivity(new Intent(context.getApplicationContext(), NavigationActivityMain.class));
                } else {
                    utilities.cancelDialog();
                    utilities.showAlertMessage("Ocurrio un error, por favor verifique sus datos",
                            "Error al iniciar Sesión");
                }
            }
        });
    }

    public void verifyCurrentUser() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Toast.makeText(context, "Welcome " + currentUser.getString("username"), Toast.LENGTH_LONG).show();
            context.startActivity(new Intent(context.getApplicationContext(), NavigationActivityMain.class));
        }
    }

    public void logoutUser() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context).setMessage("¿Desea cerrar Sesión?")
                .setTitle("Alerta").setCancelable(true).setPositiveButton("Salir", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ParseUser.logOut();
                        ParseUser parseUser = ParseUser.getCurrentUser();

                        System.exit(1);

                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alertDialog2 = alertDialog.create();

        alertDialog2.show();
    }
}
