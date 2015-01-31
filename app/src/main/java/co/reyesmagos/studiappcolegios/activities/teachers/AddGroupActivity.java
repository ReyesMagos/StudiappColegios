package co.reyesmagos.studiappcolegios.activities.teachers;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.teacher.Group;

/**
 * Created by Alexis-PC on 30/01/2015.
 */
public class AddGroupActivity extends Activity {

    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*public void addGroup(View view) {
        final Dialog dialog = new Dialog(this);
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
            }
        });


    }*/
}
