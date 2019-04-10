package login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import androidx.fragment.app.Fragment;
import androidx.room.Room;
import zachg.bensfitnessapp.R;

import static java.util.UUID.randomUUID;

// TODO: authenticaTE/VALIDATE

public class RegisterFragment extends Fragment implements View.OnClickListener {

    public RegisterFragment() {
        // Required empty constructor
    }

    Button bRegister;
    EditText etPassword, etConfirmPassword, etClientName;
    public static UserDatabase sUserDatabase;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate layout for fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        etPassword = view.findViewById(R.id.etPassword);
        etConfirmPassword = view.findViewById(R.id.etConfirmPassword);
        bRegister = view.findViewById(R.id.bRegister);
        etClientName = view.findViewById(R.id.etClientName);

        bRegister.setOnClickListener(this);

        sUserDatabase = Room.databaseBuilder(getActivity(), UserDatabase.class, "userdb").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bRegister:
                String clientName = etClientName.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (password == confirmPassword) {

                    User registeredData = new User();

                    UUID uuid = UUID.randomUUID();
                    String id = uuid.toString();
                    registeredData.setId(id);
                    registeredData.setClientName(clientName);
                    registeredData.setPassword(password);
                    registeredData.setAdmin(false);

                    RegisterFragment.sUserDatabase.myDao().addUser(registeredData);

                    Toast.makeText(getActivity(), "You are registered!", Toast.LENGTH_SHORT).show();

                    //go back to login where this is true:
                    etClientName.setText(clientName);
                    etPassword.setText(password);
                } else {
                    Toast.makeText(getActivity(), "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
