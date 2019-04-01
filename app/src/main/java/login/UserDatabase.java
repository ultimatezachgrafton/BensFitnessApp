package login;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import android.content.Context;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract MyDataAccessObject myDao();

    public static final String SP_NAME = "userDetails";

    public UserDatabase(UserDatabase userLocalDatabase) {
        this.userLocalDatabase = userLocalDatabase;
    }

    UserDatabase userLocalDatabase;



    /* Sets admin
    public void setAdmin() {
        if (!userLocalDatabase.contains("Admin")) {
            SharedPreferences.Editor spEditor = userLocalDatabase.edit();
            spEditor.putString("name", "Ben Jammin");
            spEditor.putString("birthday", "");
            spEditor.putString("username", "Admin");
            spEditor.putString("password", "benjammin");
            spEditor.putString("gender", "dude");
            spEditor.putBoolean("isAdmin", true);
        }
    }

    public void storeUserData(User user) {
        // Adds user info to database
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name", user.clientName);
        spEditor.putString("birthday", user.birthday);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.putString("gender", user.gender);
        spEditor.putBoolean("isAdmin", user.isAdmin);
    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == true) {
            return true;
        } else {
            return false;
        }
    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

    public User getLoggedInUser() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == false) {
            return null;
        }

        String name = userLocalDatabase.getString("name", "");
        String birthday = userLocalDatabase.getString("birthday", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        String gender = userLocalDatabase.getString("gender", "");
        boolean isAdmin = userLocalDatabase.getBoolean("isAdmin", false);

        User storedUser = new User();
        return storedUser;
    }*/
}