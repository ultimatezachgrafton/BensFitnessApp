package login;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import zachg.bensfitnessapp.MainActivity;
import zachg.bensfitnessapp.R;
import zachg.bensfitnessapp.SingleFragmentActivity;

import static zachg.bensfitnessapp.SingleFragmentActivity.sUserDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {
    private TextView Txtinfo;

    public ReadUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        Txtinfo = view.findViewById(R.id.txtinfo);
        String info = "";

        if (sUserDatabase != null) {
            List<User> users = sUserDatabase.myDao().getUsers();

            for (User user : users) {
                String name = user.getClientName();
                String birthday = user.getBirthday();
                info = info + "\n\n" + "\n Name: " + name + "birthday: " + birthday;
            }
            Txtinfo.setText(info);
        } else {
            Txtinfo.setText("null");
        }
        return view;
    }

}
