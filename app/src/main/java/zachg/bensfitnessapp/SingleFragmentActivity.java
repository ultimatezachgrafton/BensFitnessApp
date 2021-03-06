package zachg.bensfitnessapp;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import login.LoginFragment;
import login.MyDataAccessObject;
import login.UserDatabase;

// Controls the various fragments

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public static FragmentManager fm;
    protected abstract Fragment createFragment();

    // Returns ID of layout that the activity will inflate
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        UserDatabase sUserDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "users")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();

        if (findViewById(R.id.fragment_container)!=null) {
            if (savedInstanceState!=null) {
                return;
            }
            fm.beginTransaction().add(R.id.fragment_container, new LoginFragment()).commit();
        }
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


}