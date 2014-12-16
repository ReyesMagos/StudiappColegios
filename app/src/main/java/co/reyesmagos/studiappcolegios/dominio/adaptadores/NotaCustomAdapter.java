package co.reyesmagos.studiappcolegios.dominio.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Materia;

/**
 * Created by oscargallon on 15/12/14.
 */
public class NotaCustomAdapter extends BaseAdapter {
    private Context context;
    private List<Materia> listaMaterias;

    public NotaCustomAdapter(Context context, List<Materia> listaMaterias) {
        this.context = context;
        this.listaMaterias = listaMaterias;
    }

    @Override
    public int getCount() {
        return this.listaMaterias.size();
    }

    @Override
    public Materia getItem(int i) {
        return this.listaMaterias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.listaMaterias.indexOf(getItem(i));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.nota_custom_grid, null);

            viewHolder = new ViewHolder();
            viewHolder.imNombre = (ImageView) convertView.findViewById(R.id.im_materia);
            viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.txt_nombre);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Materia materia = getItem(position);
        viewHolder.imNombre.setImageBitmap(materia.getImage());
        viewHolder.txtNombre.setText(materia.getNombre());


        return convertView;
    }

    private class ViewHolder {
        ImageView imNombre;
        TextView txtNombre;
    }

}
