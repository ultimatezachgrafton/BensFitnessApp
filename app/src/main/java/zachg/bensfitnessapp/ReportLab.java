package zachg.bensfitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import database.ReportBaseHelper;
import database.ReportCursorWrapper;
import database.ReportDbSchema;

// A class to control the aggregate Report objects

public class ReportLab {

    private static ReportLab sReportLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ReportLab get(Context context) {
        if (sReportLab == null) {
            sReportLab = new ReportLab(context);
        }
        return sReportLab;
    }
    private ReportLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ReportBaseHelper(mContext).getWritableDatabase();
    }

    public void addReport(Report c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(ReportDbSchema.ReportTable.NAME, null, values);
    }

    public List<Report> getReports() {
        List<Report> reports = new ArrayList<>();
        ReportCursorWrapper cursor = queryReports(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                reports.add(cursor.getReport());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return reports;
    }

    public Report getReport(UUID id) {
        ReportCursorWrapper cursor = queryReports(ReportDbSchema.ReportTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getReport();
        } finally {
            cursor.close();
        }
    }

    public File getPhotoFile(Report report) {
        File filesDir = mContext.getFilesDir();
        return new File(filesDir, report.getPhotoFilename());
    }

    public void updateReport(Report report) {
        String uuidString = report.getId().toString();
        ContentValues values = getContentValues(report);

        mDatabase.update(ReportDbSchema.ReportTable.NAME, values,
                ReportDbSchema.ReportTable.Cols.UUID + " = ?", new String[]{uuidString});
    }

    private ReportCursorWrapper queryReports(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ReportDbSchema.ReportTable.NAME,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null, //groupBy
                null, // having
                null // orderBy
        );
        return new ReportCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Report report) {
        ContentValues values = new ContentValues();
        values.put(ReportDbSchema.ReportTable.Cols.UUID, report.getId().toString());
        values.put(ReportDbSchema.ReportTable.Cols.DATE, report.getDate().getTime());
        values.put(ReportDbSchema.ReportTable.Cols.CLIENT, report.getClient());

        return values;
    }
}
