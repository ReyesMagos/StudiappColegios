package co.reyesmagos.studiappcolegios.activities.teachers;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.teacher.Group;
import co.reyesmagos.studiappcolegios.fragments.adaptadores.teacher.CustomAdapterAddHomework;

public class HomeWorksFragment extends Fragment {

    private ListView lvGroups;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = inflater.inflate(R.layout.activity_home_works, container,
                false);
        setHasOptionsMenu(true);

        List<Group> list= new ArrayList<Group>();
        Group group = new Group();
        group.setTitle("Primero A");
        group.setDescription("Ingles 1-A");
        list.add(group);


        group = new Group();
        group.setTitle("Segundo A");
        group.setDescription("Ingles 2-A");
        list.add(group);

        group = new Group();
        group.setTitle("Segundo B");
        group.setDescription("Ingles 2-B");
        list.add(group);

        init(list);
        return rootView;
    }

    public void init(List<Group> groupList) {
        lvGroups = (ListView) rootView.findViewById(R.id.lv_groups);
        CustomAdapterAddHomework customAdapterAddHomework = new CustomAdapterAddHomework(groupList, getActivity().getApplicationContext());
        lvGroups.setAdapter(customAdapterAddHomework);
        lvGroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               /*/
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity().getApplicationContext());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.create_homework, null);
                dialogBuilder.setView(dialogView);

                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                /*/
                Intent in = new Intent(getActivity(), AddHomeworkActitivy.class);
                getActivity().startActivity(in);
            }
        });
    }


}
