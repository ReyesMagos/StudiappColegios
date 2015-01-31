package co.reyesmagos.studiappcolegios.fragments.teachers;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.teacher.Group;
import co.reyesmagos.studiappcolegios.mocks.GroupFactory;

/**
 * Created by Alexis-PC on 30/01/2015.
 */
public class GroupsActivityFragment extends Fragment {

    private View rootView;
    private ListView groupListView;
    private ImageView btnAddGroup;
    private Group group;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.teacher_group_list_fragment, container, false);
        setHasOptionsMenu(true);
        initComponents();
        return rootView;

    }

    public void initComponents() {
        this.groupListView = (ListView) rootView.findViewById(R.id.listView_groups);
        this.btnAddGroup = (ImageView) rootView.findViewById(R.id.imageView_add_group);

        btnAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(rootView.getContext());
                dialog.setContentView(R.layout.register_group);
                dialog.setTitle("Nuevo Grupo");

                final EditText txtGroupName = (EditText) dialog.findViewById(R.id.editText_group_title);
                final EditText txtGroupSubtitle = (EditText) dialog.findViewById(R.id.editText_group_subtitle_);
                final EditText txtGroupDescription = (EditText) dialog.findViewById(R.id.editText_group_description);
                ImageView btnSave = (ImageView) dialog.findViewById(R.id.imageView_save);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String groupName = txtGroupName.getText().toString();
                        String groupSubtitle = txtGroupSubtitle.getText().toString();
                        String groupDescription = txtGroupDescription.getText().toString();

                        group = new Group();
                        group.setTitle(groupName);
                        group.setSubTitle(groupSubtitle);
                        group.setDescription(groupDescription);

                        GroupFactory.addGroup(group);
                    }
                });
            }
        });

        List<Group> groupList = GroupFactory.getInstance();
        String[] groups = new String[]{"Biología", "Matemáticas", "Ciencias Naturales"};
        ArrayAdapter adapter = new ArrayAdapter(rootView.getContext(), android.R.layout.simple_list_item_1,
                groups);

        groupListView.setAdapter(adapter);

    }


    public void addGroup(View view) {
        final Dialog dialog = new Dialog(rootView.getContext());
        dialog.setContentView(R.layout.register_group);
        dialog.setTitle("Nuevo Grupo");


        final EditText txtGroupName = (EditText) dialog.findViewById(R.id.editText_group_title);
        final EditText txtGroupSubtitle = (EditText) dialog.findViewById(R.id.editText_group_subtitle_);
        final EditText txtGroupDescription = (EditText) dialog.findViewById(R.id.editText_group_description);
        ImageView btnSave = (ImageView) dialog.findViewById(R.id.imageView_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String groupName = txtGroupName.getText().toString();
                String groupSubtitle = txtGroupSubtitle.getText().toString();
                String groupDescription = txtGroupDescription.getText().toString();

                group = new Group();
                group.setTitle(groupName);
                group.setSubTitle(groupSubtitle);
                group.setDescription(groupDescription);

                GroupFactory.addGroup(group);
            }
        });


    }
}
