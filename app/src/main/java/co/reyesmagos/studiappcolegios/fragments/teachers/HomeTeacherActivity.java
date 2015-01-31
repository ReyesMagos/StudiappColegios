package co.reyesmagos.studiappcolegios.fragments.teachers;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by Alexis-PC on 29/01/2015.
 */
public class HomeTeacherActivity extends Fragment {

    private View rootView;
    private TextView textViewDateDay;
    private TextView textViewDateMonth;
    private TextView textViewDateYear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.teacher_today_fragment, container,false);
        setHasOptionsMenu(true);
        initComponents();
        return rootView;

    }

    public void initComponents(){
        this.textViewDateDay = (TextView)rootView.findViewById(R.id.textView_date_day);
        //this.textViewDateMonth = (TextView)rootView.findViewById(R.id.textView_date_month);
        //this.textViewDateYear = (TextView)rootView.findViewById(R.id.textView_date_year);

        DateFormat dateFormat = new SimpleDateFormat("dd, MMMM, yyyy");
        Date date = new Date();
        this.textViewDateDay.setText(dateFormat.format(date));


    }
}
