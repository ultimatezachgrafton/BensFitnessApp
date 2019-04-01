package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import database.ReportDbSchema.ReportTable;

// ReportBaseHelper is a SQLiteOpenHelper which:
// Checks to see whether the database already exists.
// If it does not, creates it and creates the tables and initial data it needs.
// If it does, opens it up and sees what version of your ReportDbSchema it has.
// If it is an old version, upgrade it to a newer version.

public class ReportBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "reportBase.db";

    public ReportBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ReportTable.NAME + "(" + "_id integer primary key autoincrement, " +
                ReportTable.Cols.UUID + ", " +
                ReportTable.Cols.DATE + ", " +
                ReportTable.Cols.CLIENT +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}