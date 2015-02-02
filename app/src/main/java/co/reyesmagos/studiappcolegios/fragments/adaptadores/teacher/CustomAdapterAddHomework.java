package co.reyesmagos.studiappcolegios.fragments.adaptadores.teacher;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.teacher.Group;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.CustomAdapterNotasMateria;

/**
 * Created by oscargallon on 1/02/15.
 */
public class CustomAdapterAddHomework extends BaseAdapter {

    private List<Group> groupList;
    private Context context;
    public CustomAdapterAddHomework(List<Group> groupList, Context context){
        this.groupList= groupList;
        this.context= context;

    }

    @Override
    public int getCount() {
        return this.groupList.size();
    }

    @Override
    public Group getItem(int i) {
        return this.groupList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.groupList.indexOf(getItem(i));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.custom_add_homework_layout, null);

            viewHolder = new ViewHolder();
            viewHolder.txtGroup = (TextView) convertView.findViewById(R.id.txt_group);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Group group = getItem(position);
        viewHolder.txtGroup.setText(group.getTitle());


        return convertView;
    }

    private class ViewHolder {

        TextView txtGroup;

    }
}
