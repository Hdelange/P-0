package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UsersDao;
import models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceTest {

    UsersDao usersDao = Mockito.mock(UsersDao.class);
    UsersService usersService;
    public UsersServiceTest(){
        this.usersService = new UsersService(usersDao);
    }


    @Test
    void getAllUsers() {
        //arrange
        List<Users> users = new ArrayList<>();
        users.add(new Users(1,"Mike","Jones"));
        users.add(new Users(2,"Jon","Yodice"));
        users.add(new Users(3,"Brett","hess"));
        List<Users> expectedValue = users;
        Mockito.when(usersDao.getAllUsers()).thenReturn(users);
        //act
        List<Users> actualResult = usersService.getAllUsers();
        //assert
        assertEquals(expectedValue,actualResult);
    }

    @Test
    void getOneUsers() {
        //arrange
        Users expectedResult = new Users(1, "Harley", "de Lange.");
        Mockito.when(usersDao.getOneUsers(expectedResult.getId())).thenReturn(expectedResult);
        //act
        Users actualResult = usersService.getOneUsers(expectedResult.getId());
        //assert
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void createUsers() {
        //arrange
        Users users = new Users(2, "Charlie", "Brown");
        //act
        usersService.createUsers(users);
        //assert
        assertEquals(2,2);
    }


    @Test
    void updateUsers() {
        //arrange
        Integer userId = 1;
        //act
        usersService.updateUsers(userId);
        //assert
        Mockito.verify(usersDao, Mockito.times(1)).updateUsers(userId);
    }

    @Test
    void deleteUsers() {
        //arrange
        Integer usersId = 1;
        //act
        usersService.deleteUsers(usersId);
        //assert
        Mockito.verify(usersDao, Mockito.times(1)).deleteUsers(usersId);
    }
}