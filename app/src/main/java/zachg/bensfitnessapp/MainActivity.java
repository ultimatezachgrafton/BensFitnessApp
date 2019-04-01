package zachg.bensfitnessapp;

import android.os.Bundle;
import android.service.autofill.UserData;
import androidx.appcompat.app.ActionBar;

import androidx.appcompat.app.AppCompatActivity;
import login.UserDatabase;

// MainActivity hosts the LoginActivity screen which leads to the Report fragment for users
// or the Admin fragment for Admin

public class MainActivity extends AppCompatActivity {

    UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserDatabase userDatabase;
    }
}

/*public class MainActivity extends SingleFragmentActivity
    @Override
    protected Fragment createFragment() {
        UUID reportId = (UUID) getIntent().getSerializableExtra(EXTRA_REPORT_ID);
        return ReportFragment.newInstance(reportId);
    }

    // Creates explicit intent, and pass in a Serializable key value to create new Reports
    private static final String EXTRA_REPORT_ID = "zachg.bensfitnessapp.report_id";
    public static Intent newIntent(Context packageContext, UUID reportId) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(EXTRA_REPORT_ID, reportId);
        return intent;
    }
}
*/