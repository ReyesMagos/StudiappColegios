package co.reyesmagos.studiappcolegios.fragments.adaptadores.util;

import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Alexis-PC on 15/12/2014.
 */
public class TareaHeader {

    private CheckBox homeworkNameCheckBox;
    private TextView materiaTxt;


    public TareaHeader(){
        super();
    }

    public CheckBox getHomeworkNameCheckBox() {
        return homeworkNameCheckBox;
    }

    public void setHomeworkNameCheckBox(CheckBox homeworkNameCheckBox) {
        this.homeworkNameCheckBox = homeworkNameCheckBox;
    }

    public TextView getMateriaTxt() {
        return materiaTxt;
    }

    public void setMateriaTxt(TextView materiaTxt) {
        this.materiaTxt = materiaTxt;
    }
}
