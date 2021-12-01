package services;

import dao.UsersDao;
import models.Users;

import java.util.List;

public class UsersService {
    UsersDao usersDao;

    public UsersService(UsersDao usersDao){

        this.usersDao = usersDao;
    }

    public List<Users> getAllUsers(){

        return usersDao.getAllUsers();
    }
    public Users getOneUsers(Integer id){

        return usersDao.getOneUsers(id);
    }

    public void createUsers(Users users){

        usersDao.createUsers(users);
    }
    public void updateUsers(Integer usersId){
        System.out.println("User id: " + usersId + "is updated");

        usersDao.updateUsers(usersId);
    }

    public void deleteUsers(Integer userId){

        usersDao.deleteUsers(userId);
    }
}
