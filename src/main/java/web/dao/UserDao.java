package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    User findUserByName(String name);
    User findUser(int id);
    List<User> listUsers();
    void deleteUser(int id);
    void updateUser(User user);
}
