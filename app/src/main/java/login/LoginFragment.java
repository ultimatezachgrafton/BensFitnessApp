package login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import zachg.bensfitnessapp.MainActivity;
import zachg.bensfitnessapp.R;
import zachg.bensfitnessapp.SingleFragmentActivity;

// TODO: authenticate/validate

public class LoginFragment extends Fragment implements View.OnClickListener {

    private Button bLogin, bReadUser; //temp! delete after testing!
    private EditText etUsername, etPassword;
    private TextView tvRegisterLink;
    UserDatabase userDatabase; //storage space of current user

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        bLogin = (Button) view.findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        tvRegisterLink = (TextView) view.findViewById(R.id.tvRegisterLink);
        tvRegisterLink.setOnClickListener(this);

        // temp! delete after testing!
        bReadUser = (Button) view.findViewById(R.id.bReadUser);
        bReadUser.setOnClickListener(this);


        return view;
    }

    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.bLogin:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                User user = new User();
                Toast.makeText(getActivity(), "CLICK CLICK!", Toast.LENGTH_SHORT).show();

                if (userDatabase != null) {
                    userDatabase.myDao();
                    //userDatabase.setUserLoggedIn(true);
                    //authenticate(user);
                }
                break;
            case R.id.tvRegisterLink:
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container,
                    new RegisterFragment()).addToBackStack(null).commit();
                Toast.makeText(getActivity(), "CLICK CLICK!", Toast.LENGTH_SHORT).show();
                break;

                // delete after testing!
            case R.id.bReadUser:
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container, new ReadUserFragment()).addToBackStack(null).commit();
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