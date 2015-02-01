package co.reyesmagos.studiappcolegios.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.factories.impl.FactoryMaterias;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterNotasMateria;

public class MateriaActivity extends Activity {

    private ListView lvNotas;
    private TextView txtNotaFinal;
    private TextView txtMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);
        initComponents();
    }

    public void initComponents() {
        lvNotas = (ListView) findViewById(R.id.lv_notas);
        txtNotaFinal = (TextView) findViewById(R.id.txt_nota_final);
        txtMateria = (TextView) findViewById(R.id.txt_materia);
        txtMateria.setText(FactoryMaterias.getInstance().getMateriaAMostrar().getNombre());
        CustomAdapterNotasMateria customAdapterNotasMateria = new CustomAdapterNotasMateria(
                getApplicationContext(), FactoryMaterias.getInstance().getMateriaAMostrar().
                getListaNotas());
        lvNotas.setAdapter(customAdapterNotasMateria);
        Double notis=FactoryMaterias.getInstance().getMateriaAMostrar().
                getNotaFinal().getNota();

        if(notis>0 && notis<1)
            txtNotaFinal.setText("D");
        else if(notis>=1 && notis <3)
            txtNotaFinal.setText("I");
        else if(notis>=3 && notis <3.8)
            txtNotaFinal.setText("A");
        else if(notis>=3.8 && notis <4.5)
            txtNotaFinal.setText("S");
        else if(notis>=4.5 && notis <=5)
            txtNotaFinal.setText("E");


        //txtNotaFinal.setText(new DecimalFormat("##.##").format(notaF));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_materia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
