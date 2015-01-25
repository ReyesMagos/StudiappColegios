package co.reyesmagos.studiappcolegios.services.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by Alexis-PC on 09/01/2015.
 */
public class Utilities {

    private Activity context;
    private ProgressDialog progressDialog;

    public Utilities(Activity context) {
        super();
        this.context = context;
    }

    public void showDialog(String titulo, String mensaje, Boolean isCancelable) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(titulo);
        progressDialog.setMessage(mensaje);
        progressDialog.setCancelable(isCancelable);
        progressDialog.show();

    }

    public void cancelDialog() {
        progressDialog.dismiss();
    }

    public void showAlertMessage(String mensaje, String titulo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(context.getResources().getDrawable(R.drawable.ic_launcher));
        builder.setTitle(titulo);

        builder.setMessage(mensaje).setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog dialog = builder.show();
        dialog.show();

    }

    public void showAlertDialogOptions(String message, String title, String positiveButton, String negativeButton,
                                       boolean cancelable) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message).setTitle(title).setCancelable(cancelable);
        alertDialog.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(1);

            }
        });
        alertDialog.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog2 = alertDialog.create();

        alertDialog2.show();
    }

}
