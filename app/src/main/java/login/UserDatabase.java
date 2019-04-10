package login;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import android.content.Context;

@Database(entities = User.class, version = 3, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract MyDataAccessObject myDao();
    //public static final String SP_NAME = "userDetails";
    //UserDatabase userLocalDatabase;
}