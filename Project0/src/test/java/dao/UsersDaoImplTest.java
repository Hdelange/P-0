package dao;

import models.Users;
import org.h2.engine.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.H2Util;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersDaoImplTest {

    UsersDao usersDao;

    public  UsersDaoImplTest(){
        this.usersDao = new UsersDaoImpl(H2Util.url,H2Util.username,H2Util.password);
    }
    @BeforeEach
    void setUp(){
        H2Util.createTable();
    }

    @AfterEach
    void tearDown(){
        H2Util.dropTable();
    }
    @Test
    void getAllUsers() {
        //arrange
        List<Users> expectedResult = new ArrayList<>();
        expectedResult.add(new Users(1,"Harley","de Lange."));
        expectedResult.add(new Users(2,"Charlie","Brown"));
        usersDao.createUsers(expectedResult.get(1));
        usersDao.createUsers(expectedResult.get(2));

        //act
        List<Users> actualResult = usersDao.getAllUsers();

        //assert
        assertEquals(expectedResult,actualResult);

    }

    @Test
    void getOneUsers() {
        //arrange
        List<Users> expectedResult = new ArrayList<>();
        expectedResult.add(new Users(1,"Harley","de Lange."));
        expectedResult.add(new Users(2,"Charlie","Brown"));
        usersDao.createUsers(expectedResult.get(0));
        usersDao.createUsers(expectedResult.get(1));


        //act
        Users actualResult = usersDao.getOneUsers(2);

        //assert
        assertEquals(expectedResult.get(1).toString(),actualResult);
    }

    @Test
    void createUsers() {
        List<Users> expectedResult = new ArrayList<>();
        expectedResult.add(new Users(1,"Harley","de Lange."));
        expectedResult.add(new Users(2,"Charlie","Brown"));
        usersDao.createUsers(expectedResult.get(0));
        usersDao.createUsers(expectedResult.get(1));

        Integer actualResult = usersDao.getAllUsers().size();

        assertEquals(expectedResult.size(), actualResult);

    }

    @Test
    void updateUsers() {
        //arrange
        Users usersToPass = new Users(1,"Harley","de Lange.");
        Users expectedResult = new Users(1,"Harley","de Lange.");
        usersDao.createUsers(usersToPass);

        //act
        usersDao.updateUsers(usersToPass.getId());
        Users actualResult = usersDao.getOneUsers(usersToPass.getId());

        //assert
        assertEquals(expectedResult,actualResult);

    }

    @Test
    void deleteUsers() {
        List<Users> expectedResult = new ArrayList<>();
        expectedResult.add(new Users(1,"Harley","de Lange."));
        expectedResult.add(new Users(2,"Charlie","Brown"));
        usersDao.createUsers(expectedResult.get(0));
        usersDao.createUsers(expectedResult.get(1));

        usersDao.deleteUsers(2);
        expectedResult.remove(1);

        List<Users> actualResult = usersDao.getAllUsers();

        assertEquals(expectedResult,actualResult);


    }
}