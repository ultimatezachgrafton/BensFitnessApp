package login;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MyDataAccessObject {

    @Insert
    void addUser(User user);

    @Query("select * from users")
    List<User> getUsers();

}
