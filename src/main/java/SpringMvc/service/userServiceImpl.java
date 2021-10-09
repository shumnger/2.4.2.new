package SpringMvc.service;

import SpringMvc.dao.userDao;
import SpringMvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class userServiceImpl implements userService {

    private userDao userDao;

    @Autowired
    public void setUserDao(userDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
