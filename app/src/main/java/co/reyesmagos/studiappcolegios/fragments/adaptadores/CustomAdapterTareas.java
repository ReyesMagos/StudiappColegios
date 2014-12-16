package co.reyesmagos.studiappcolegios.fragments.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Tareas;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.util.TareaDetail;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.util.TareaHeader;

/**
 * Created by Alexis-PC on 11/12/2014.
 */
public class CustomAdapterTareas extends BaseExpandableListAdapter {

    private Context context;
    private List<Tareas> tareasList;

    public CustomAdapterTareas(Context context, List<Tareas> tareasList) {
        super();
        this.context = context;
        this.tareasList = tareasList;
    }


    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.tareasList.get(groupPosition);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        TareaDetail tareaDetail;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView =  layoutInflater.inflate(R.layout.tareas_list_customized, null);

            tareaDetail = new TareaDetail();
            tareaDetail.setTxtDescription((TextView)convertView.findViewById(R.id.description_txt));
            tareaDetail.setTxtDate((TextView)convertView.findViewById(R.id.date_text_txt));

            convertView.setTag(tareaDetail);
        }else{
            tareaDetail = (TareaDetail)convertView.getTag();
        }

        Tareas tarea = (Tareas)getGroup(groupPosition);
        tareaDetail.getTxtDescription().setText(tarea.getDescription());
        tareaDetail.getTxtDate().setText(tarea.getDate());

        return convertView;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return tareasList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return tareasList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        TareaHeader tareaHeader;

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.tareas_list_header, null);

            tareaHeader = new TareaHeader();
            tareaHeader.setHomeworkNameCheckBox((CheckBox)convertView.findViewById(R.id.checkBox));
            tareaHeader.setMateriaTxt((TextView)convertView.findViewById(R.id.materia_name_txt));

            convertView.setTag(tareaHeader);

        }else{
            tareaHeader = (TareaHeader)convertView.getTag();
        }

        Tareas tareas = (Tareas)getGroup(groupPosition);
        tareaHeader.getHomeworkNameCheckBox().setText(tareas.getName());
        tareaHeader.getMateriaTxt().setText(tareas.getMateria());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


}
