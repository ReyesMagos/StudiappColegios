package co.reyesmagos.studiappcolegios.controladores;

import android.app.Activity;

/**
 * Created by oscargallon on 25/01/15.
 */
public  abstract class AbstractController {

    public Activity context;

    public AbstractController(Activity context) {
        this.context = context;
    }

    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }
}
