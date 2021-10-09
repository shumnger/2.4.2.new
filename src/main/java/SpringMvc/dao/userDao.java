package SpringMvc.dao;

import SpringMvc.model.User;

import java.util.List;

public interface userDao {

    void addUser(User user);

    void updateUser(User user);

    void removeUserById(long id);

    User getUserById(long id);

    List<User> getAllUsers();

    User getUserByName(String username);
}
