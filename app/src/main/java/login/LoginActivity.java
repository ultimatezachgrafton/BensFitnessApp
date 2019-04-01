package login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import zachg.bensfitnessapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserDatabase userDatabase; //storage space of current user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        // Checks if database contains Admin - if not, sets them
        // Not sure if best way to implement this - will research
        //userLocalStore.setAdmin();
    }

  @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bLogin:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                User user = new User();

                userDatabase.myDao();
                //userDatabase.setUserLoggedIn(true);
                //authenticate(user);
                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

        }

    }
/*
    private void authenticate(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.fetchUserDataAsyncTask(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }
        });
    }
    */
}
