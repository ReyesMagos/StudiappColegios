package co.reyesmagos.studiappcolegios.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.Parse;

import co.reyesmagos.studiappcolegios.R;
import co.reyesmagos.studiappcolegios.controladores.LoginController;
import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.User;


public class LoginActivity extends Activity {

    private ImageView loginButton;
    private EditText txtUserName;
    private EditText txtPassword;

    private String userName;
    private String password;

    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getResources().getString(R.string.application_id), getResources().getString(R.string.client_key));
        initComponents();
        this.loginController = new LoginController(this);
        this.loginController.verifyCurrentUser();

    }

    public void initComponents() {
        this.loginButton = (ImageView) super.findViewById(R.id.imageView);
        this.txtUserName = (EditText) super.findViewById(R.id.editText_user_name);
        this.txtPassword = (EditText) super.findViewById(R.id.editText_password);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        this.userName = this.txtUserName.getText().toString();
        this.password = this.txtPassword.getText().toString();

        User user = new User();
        user.setName(userName);
        user.setPassword(password);

        this.loginController = new LoginController(this);
        loginController.loginUser(user);
    }

    public void onStartRegisterActivity(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }
}
