package database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import zachg.bensfitnessapp.Report;

// ReportCursorWrapper allows easier retrieval of information written to the database

public class ReportCursorWrapper extends CursorWrapper {
    public ReportCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Report getReport() {
        String uuidString = getString(getColumnIndex(ReportDbSchema.ReportTable.Cols.UUID));
        long date = getLong(getColumnIndex(ReportDbSchema.ReportTable.Cols.DATE));
        String client = getString(getColumnIndex(ReportDbSchema.ReportTable.Cols.CLIENT));

        Report report = new Report(UUID.fromString(uuidString));
        report.setDate(new Date(date));
        report.setClient(client);

        return report;
    }

}
