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

import co.reyesmagos.studiappcolegios.R;

/**
 * Created by Alexis-PC on 09/12/2014.
 */
public class CustomAdapterNotificaciones extends BaseAdapter {

    private Context context;
    private List<String> listNotificaciones;

    public CustomAdapterNotificaciones(Context context, List<String> notificacionesList) {
        super();
        this.context = context;
        this.listNotificaciones = notificacionesList;
    }

    @Override
    public int getCount() {
        return listNotificaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return listNotificaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listNotificaciones.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        LayoutInflater layoutInflater = (LayoutInflater) context.
                getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.notificaciones_custom_listview, null);

            viewHolder = new ViewHolder();
            viewHolder.imgIcon1 = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.imgIcon2 = (ImageView) convertView.findViewById(R.id.imageView2);
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.txtText = (TextView) convertView.findViewById(R.id.textView2);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.imgIcon1.setImageResource(R.drawable.ic_launcher);
        viewHolder.imgIcon2.setImageResource(R.drawable.ic_launcher);
        viewHolder.txtTitle.setText("Nombre Tarea");
        viewHolder.txtText.setText("Descripción de la tarea");

        return convertView;
    }

    private class ViewHolder {
        ImageView imgIcon1;
        ImageView imgIcon2;
        TextView txtTitle;
        TextView txtText;


    }
}
