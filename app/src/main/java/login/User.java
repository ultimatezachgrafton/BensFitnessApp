package login;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey @NonNull
    public String id;
    @ColumnInfo
    public String clientName;
    @ColumnInfo(name = "birthday")
    public String birthday;
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "gender")
    public String gender;
    @ColumnInfo(name = "isAdmin")
    public boolean isAdmin;

    public String getId(){ return id; }

    public void setId(String id){ this.id = id; }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = false;
    }
}