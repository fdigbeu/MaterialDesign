package lveapp.fr.materialdesign.View.Activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Hashtable;

import lveapp.fr.materialdesign.Presenter.LoginPresenter;
import lveapp.fr.materialdesign.R;
import lveapp.fr.materialdesign.View.Interfaces.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView.ILogin {

    private LoginPresenter loginPresenter;

    private TextInputEditText userEmail, userPassword;
    private Button btnLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //--
        loginPresenter = new LoginPresenter(this);
        loginPresenter.loadData();
    }

    @Override
    public void initialize() {
        userEmail = (TextInputEditText)findViewById(R.id.userEmail);
        userPassword = (TextInputEditText)findViewById(R.id.userPassword);
        btnLoginPassword = (Button)findViewById(R.id.btnLoginPassword);
    }

    @Override
    public void events() {
        btnLoginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hashtable<String, String> enterData = new Hashtable<>();
                enterData.put("email", userEmail.getText().toString().trim());
                enterData.put("password", userPassword.getText().toString().trim());
                loginPresenter.retrieveUserAction(view, enterData);
            }
        });
    }

    @Override
    public void closeActivity() {
        finish();
    }

    @Override
    public void displayEmailError() {
        userEmail.setError(getResources().getString(R.string.enterValidEmail));
    }

    @Override
    public void displayPasswordError() {
        userPassword.setError(getResources().getString(R.string.enterValidPassword));
    }

    @Override
    public void displayToast(String text) {
        Toast.makeText(LoginActivity.this, text, Toast.LENGTH_LONG).show();
    }
}
