package zachg.bensfitnessapp;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.*;

public class ReportListFragment extends Fragment {

    private RecyclerView mReportRecyclerView;
    private ReportAdapter mAdapter;
    private Callbacks mCallbacks;

    // Required interface for hosting activities
    public interface Callbacks {
        void onReportSelected(Report report);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_list, container, false);

        mReportRecyclerView = (RecyclerView) view.findViewById(R.id.report_recycler_view);
        mReportRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_report_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_report:
                Toast.makeText(getActivity(),"Hi", LENGTH_SHORT).show();
                Report report = new Report();
                ReportLab.get(getActivity()).addReport(report);
                updateUI();
                mCallbacks.onReportSelected(report);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void updateUI() {
        ReportLab reportLab = ReportLab.get(getActivity());
        List<Report> reports = reportLab.getReports();

        if (mAdapter == null) {
            mAdapter = new ReportAdapter(reports);
            mReportRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setReports(reports);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ReportHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mDateTextView;
        private Report mReport;


        public ReportHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_report, parent, false));
            itemView.setOnClickListener(this);

            mDateTextView = (TextView) itemView.findViewById(R.id.report_date);
        }

        public void bind(Report report) {
            mReport = report;
            mDateTextView.setText(mReport.getDate().toString());
        }

        // Takes the generated ID
        @Override
        public void onClick(View view) {
            mCallbacks.onReportSelected(mReport);
        }
    }

    private class ReportAdapter extends RecyclerView.Adapter<ReportHolder> {
        private List<Report> mReports;

        public ReportAdapter(List<Report> reports) {
            mReports = reports;
        }

        @Override
        public ReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ReportHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ReportHolder holder, int position) {
            Report report = mReports.get(position);
            holder.bind(report);
        }

        @Override
        public int getItemCount() {
            return mReports.size();
        }

        public void setReports(List<Report> reports) {
            mReports = reports;
        }
    }
}
