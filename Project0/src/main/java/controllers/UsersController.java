package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UsersDaoImpl;
import io.javalin.http.Context;
import models.Users;
import services.UsersService;

import java.util.List;

public class UsersController {

    static UsersService usersService = new UsersService(new UsersDaoImpl());

    public static void getAllUsers(io.javalin.http.Context context) throws JsonProcessingException {
        context.contentType("application/json"); //sending back json

        List<Users> usersList = usersService.getAllUsers(); //get all todos from db

        String jsonString = new ObjectMapper().writeValueAsString(usersList); //we used jackson to convert our list object to a json string

        context.result(jsonString); //send data back
    }


    public static void getOneUsers(io.javalin.http.Context context) throws JsonProcessingException {
        context.contentType("application/json"); //sending back json

        Integer usersId = Integer.parseInt(context.pathParam("id"));

        Users users = usersService.getOneUsers(usersId);

        context.result(new ObjectMapper().writeValueAsString(users));
    }

    public static void createUsers(io.javalin.http.Context context) throws JsonProcessingException {

        Users users = context.bodyAsClass(Users.class);

        usersService.createUsers(users);

        context.result(new ObjectMapper().writeValueAsString(users));

    }
    public static void updateUsers(io.javalin.http.Context context) throws JsonProcessingException{
        context.contentType("application/json"); //sending back json

        Integer usersId = Integer.parseInt(context.pathParam("id"));

        usersService.updateUsers(usersId);

        context.result("Users with id " + usersId + " has been completed");
    }

    public static void deleteUsers(io.javalin.http.Context context) throws JsonProcessingException{
        context.contentType("application/json"); //sending back json

        Integer usersId = Integer.parseInt(context.pathParam("id"));

        usersService.deleteUsers(usersId);

        context.result("Deleted users with id " + usersId);
    }
}
