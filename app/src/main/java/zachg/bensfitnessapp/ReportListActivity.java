package zachg.bensfitnessapp;

import android.content.Intent;
import androidx.fragment.app.Fragment;

public class ReportListActivity extends SingleFragmentActivity
        implements ReportListFragment.Callbacks, ReportFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new ReportListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onReportSelected(Report report) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = ReportPagerActivity.newIntent(this, report.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = ReportFragment.newInstance(report.getId());
            getSupportFragmentManager().beginTransaction().replace
                    (R.id.detail_fragment_container, newDetail).commit();
        }
    }
    public void onReportUpdated(Report report) {
        ReportListFragment listFragment = (ReportListFragment)getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
