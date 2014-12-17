package co.reyesmagos.studiappcolegios.fragments.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeoutException;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Materia;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Nota;

/**
 * Created by oscargallon on 17/12/14.
 */
public class CustomAdapterNotasMateria extends BaseAdapter {

    private Context context;
    private List<Nota> listaNotas;

    public CustomAdapterNotasMateria(Context context, List<Nota> listaNotas) {
        this.context = context;
        this.listaNotas = listaNotas;
    }

    @Override
    public int getCount() {
        return this.listaNotas.size();
    }

    @Override
    public Nota getItem(int i) {
        return this.listaNotas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.listaNotas.indexOf(getItem(i));
    }



    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.notas_materia_custom_adapter, null);

            viewHolder = new ViewHolder();
            viewHolder.txtMotivo = (TextView) convertView.findViewById(R.id.txt_motivo);
            viewHolder.txtPorcentaje = (TextView) convertView.findViewById(R.id.txt_porcentaje);
            viewHolder.txtNota = (TextView) convertView.findViewById(R.id.txt_nota);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Nota nota = getItem(position);
        viewHolder.txtMotivo.setText(nota.getMotivo());
        viewHolder.txtPorcentaje.setText(Double.toString(nota.getPorcentaje()));
        viewHolder.txtNota.setText(Double.toString(nota.getNota()));


        return convertView;
    }

    private class ViewHolder {

        TextView txtMotivo;
        TextView txtPorcentaje;
        TextView txtNota;
    }
}
