package co.reyesmagos.studiappcolegios.fragments.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Tareas;
import co.reyesmagos.studiappcolegios.fragments.TareasFragmentActivity;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.util.TareaDetail;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.util.TareaHeader;

/**
 * Created by Alexis-PC on 11/12/2014.
 */
public class CustomAdapterTareas extends BaseExpandableListAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private Context context;
    private List<Tareas> tareasList = new ArrayList<Tareas>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
    private boolean checked = false;



    public CustomAdapterTareas(Context context, List<Tareas> tareasList) {
        super();
        this.context = context;
        this.tareasList = tareasList;
    }

    public CustomAdapterTareas(Context context){
        super();
        this.context = context;

    }

    public void addTareaItem(final Tareas tarea) {
        tareasList.add(tarea);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final Tareas tarea) {
        tareasList.add(tarea);
        sectionHeader.add(tareasList.size() - 1);
        notifyDataSetChanged();
    }

    public void removeTareaItem(final int id){
        tareasList.remove(id);
        notifyDataSetChanged();
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
    public int getGroupType(int groupPosition) {
        return sectionHeader.contains(groupPosition) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getGroupTypeCount() {
        return 2;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        TareaDetail tareaDetail = null;
        int rowType = getChildType(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.tareas_list_customized, null);

            tareaDetail = new TareaDetail();
            tareaDetail.setTxtDescription((TextView) convertView.findViewById(R.id.description_txt));
            tareaDetail.setTxtDate((TextView) convertView.findViewById(R.id.date_text_txt));
            convertView.setTag(tareaDetail);
        } else {
            tareaDetail = (TareaDetail) convertView.getTag();
        }


        Tareas tarea = (Tareas) getGroup(groupPosition);
        tareaDetail.getTxtDescription().setText(tarea.getDescription());
        tareaDetail.getTxtDate().setText(new SimpleDateFormat("EEE,MMM d, yyyy").format(tarea.getDate()));
        //tareaDetail.getTxtDate().setText(tarea.getDate().toString());

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

        TareaHeader tareaHeader = null;
        int rowType = getGroupType(groupPosition);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            tareaHeader = new TareaHeader();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = layoutInflater.inflate(R.layout.tareas_list_header, null);
                    tareaHeader.setHomeworkNameCheckBox((CheckBox) convertView.findViewById(R.id.checkBox));
                    tareaHeader.setMateriaTxt((TextView) convertView.findViewById(R.id.materia_name_txt));
                    break;
                case TYPE_SEPARATOR:

                    //poner lo del separador acá
                    convertView = layoutInflater.inflate(R.layout.separator_tareas_list, null);
                    tareaHeader.setMateriaTxt((TextView) convertView.findViewById(R.id.textSeparator));
                    break;
            }

            convertView.setTag(tareaHeader);

        } else {
            tareaHeader = (TareaHeader) convertView.getTag();
        }

        Tareas tareas = (Tareas) getGroup(groupPosition);
        switch (rowType){
            case TYPE_ITEM:

                tareaHeader.getHomeworkNameCheckBox().setText(tareas.getName());
                tareaHeader.getMateriaTxt().setText(tareas.getMateria());

                final TareaHeader finalTareaHeader = tareaHeader;
                tareaHeader.getHomeworkNameCheckBox().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(context,"Me cheqeuaron", Toast.LENGTH_LONG).show();
                        setChecked(finalTareaHeader.getHomeworkNameCheckBox().isChecked());
                    }
                });

                break;
            case TYPE_SEPARATOR:
                tareaHeader.getMateriaTxt().setText(tareas.getHeaderTitle());
                break;
        }

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

    public TreeSet<Integer> getSectionHeader() {
        return sectionHeader;
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId()){
            case R.id.checkBox:
                if(checked){

                }else {

                }
                break;

        }
    }
}
