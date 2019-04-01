package login;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import zachg.bensfitnessapp.R;


// RegisterActivity class creates the User profiles to be stored
// Admin will be pre-registered via setAdmin() during onCreate()

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etUsername, etPassword, etClientName, etBirthday, etGender;
    public static UserDatabase sUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        bRegister = findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);

        sUserDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "userdb")
                .allowMainThreadQueries().build();
    }

    @Override
    public void onClick(View v) {
       switch(v.getId()) {
           case R.id.bRegister:
               String clientName = etClientName.getText().toString();
               String username = etUsername.getText().toString();
               String password = etPassword.getText().toString();
               String birthday = etBirthday.getText().toString();
               String gender = etGender.getText().toString();
               User registeredData = new User();

               registeredData.setClientName(clientName);
               registeredData.setUsername(username);
               registeredData.setPassword(password);
               registeredData.setBirthday(birthday);
               registeredData.setGender(gender);
               registeredData.setAdmin(false);

               RegisterActivity.sUserDatabase.myDao().addUser(registeredData);

               Toast.makeText(getApplicationContext(), "You are registered!", Toast.LENGTH_SHORT).show();
               break;
       }
    }
}
