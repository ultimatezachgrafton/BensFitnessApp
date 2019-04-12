package zachg.bensfitnessapp;

import android.os.Bundle;
import android.widget.Toast;

import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import login.LoginFragment;
import login.UserDatabase;

//import static zachg.bensfitnessapp.R.id.fragment_container;
import static zachg.bensfitnessapp.SingleFragmentActivity.fm;

// MainActivity launches LoginFragment and RegisterFragment

public class MainActivity extends SingleFragmentActivity {
    //public static FragmentManager fm;

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }
}
