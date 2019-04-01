package login;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MyDataAccessObject {

    @Insert
    public void addUser(User user);
}
