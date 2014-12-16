package co.reyesmagos.studiappcolegios.fragments.adaptadores.util;

import android.widget.TextView;

/**
 * Created by Alexis-PC on 15/12/2014.
 */
public class TareaDetail {

    private TextView txtDescription;
    private TextView txtDate;

    public TareaDetail() {
        super();
    }

    public TextView getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(TextView txtDate) {
        this.txtDate = txtDate;
    }

    public TextView getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(TextView txtDescription) {
        this.txtDescription = txtDescription;
    }
}
