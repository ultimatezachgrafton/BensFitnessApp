package zachg.bensfitnessapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import login.LoginFragment;
import login.UserDatabase;

//import static zachg.bensfitnessapp.R.id.fragment_container;
import static zachg.bensfitnessapp.SingleFragmentActivity.fm;

// MainActivity launches LoginFragment and RegisterFragment

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fm = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container)!=null) {
            if (savedInstanceState!=null) {
                return;
            }
            fm.beginTransaction().add(R.id.fragment_container, new LoginFragment()).commit();
        }
    }
}
