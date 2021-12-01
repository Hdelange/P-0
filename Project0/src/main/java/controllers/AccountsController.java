package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountsDaoImpl;
import dao.UsersDaoImpl;
import models.Accounts;
import models.Users;
import services.AccountsService;
import services.UsersService;

import java.util.List;

public class AccountsController {


        static AccountsService accountsService = new AccountsService(new AccountsDaoImpl());

        public static void getAllAccounts(io.javalin.http.Context context) throws JsonProcessingException {
            context.contentType("application/json"); //sending back json

            List<Accounts> accountsList = accountsService.getAllAccounts(); //get all todos from db

            String jsonString = new ObjectMapper().writeValueAsString(accountsList); //we used jackson to convert our list object to a json string

            context.result(jsonString); //send data back
        }


        public static void getOneAccounts(io.javalin.http.Context context) throws JsonProcessingException {
            context.contentType("application/json"); //sending back json

            Integer accountsId = Integer.parseInt(context.pathParam("id"));

            Accounts accounts = accountsService.getOneAccounts(accountsId);

            context.result(new ObjectMapper().writeValueAsString(accounts));
        }

        public static void createAccounts(io.javalin.http.Context context) throws JsonProcessingException {

            Accounts accounts = context.bodyAsClass(Accounts.class);

            accountsService.createAccounts(accounts);

            context.result(new ObjectMapper().writeValueAsString(accounts));

        }
        public static void updateAccounts(io.javalin.http.Context context) throws JsonProcessingException{
            context.contentType("application/json"); //sending back json

            Integer accountsId = Integer.parseInt(context.pathParam("id"));

            accountsService.updateAccounts(accountsId);

            context.result("Accounts with id " + accountsId + " has been completed");
        }

        public static void deleteAccounts(io.javalin.http.Context context) throws JsonProcessingException{
            context.contentType("application/json"); //sending back json

            Integer accountsId = Integer.parseInt(context.pathParam("id"));

            accountsService.deleteAccounts(accountsId);

            context.result("Deleted accounts with id " + accountsId + " if it exists");
        }
    }


