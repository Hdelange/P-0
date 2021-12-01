package dao;

import models.Users;

import java.util.List;

//
public interface UsersDao {

    List<Users> getAllUsers();
    Users getOneUsers(Integer usersId);
    void createUsers(Users users);
    void updateUsers(Integer usersId);
    void deleteUsers(Integer usersId);
}
