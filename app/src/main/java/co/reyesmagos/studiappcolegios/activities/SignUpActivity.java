package co.reyesmagos.studiappcolegios.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.controladores.RegisterController;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.User;

/**
 * Created by Alexis-PC on 09/01/2015.
 */
public class SignUpActivity extends Activity {

    private EditText txtUserName;
    private EditText txtPassword;
    private EditText txtEmail;
    private Spinner spinnerRol;

    private String userName;
    private String password;
    private String email;
    private String rol;

    private RegisterController registerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        initComponents();
    }

    public void initComponents() {

        this.txtUserName = (EditText) super.findViewById(R.id.edit_txt_user_name);
        this.txtPassword = (EditText) super.findViewById(R.id.edit_txt_pass);
        this.txtEmail = (EditText) super.findViewById(R.id.edit_txt_email);
        this.spinnerRol = (Spinner) super.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> rolesAdapter = ArrayAdapter.createFromResource(this, R.array.rol_array,
                android.R.layout.simple_spinner_item);
        rolesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRol.setAdapter(rolesAdapter);

        this.spinnerRol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rol = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                rol = "Padre";
            }
        });
    }

    public void onRegisterClick(View view) {
        //Obtenemos los datos ingresados
        this.userName = this.txtUserName.getText().toString();
        this.password = this.txtPassword.getText().toString();
        this.email = this.txtEmail.getText().toString();

        //creamos el usuario
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setRol(rol);

        //llamar al controlador
        this.registerController = new RegisterController(this);
        registerController.registerUser(user);

    }
}
