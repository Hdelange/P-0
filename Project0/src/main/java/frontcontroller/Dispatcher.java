package frontcontroller;

import controllers.AccountsController;
import controllers.UsersController;
import io.javalin.Javalin;
import models.Accounts;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {

    public Dispatcher(Javalin app) {



       app.routes(() -> {
            path("users", () -> {
                get(UsersController::getAllUsers); // /todo GET
                post(UsersController::createUsers); // /todo POST
                path("{id}", () -> {
                    get(UsersController::getOneUsers); // /todo/3 GET   get todo with todo id that is 3
                    patch(UsersController::updateUsers); // /todo/3 PATCH
                    delete(UsersController::deleteUsers); // /todo/3 DELETE
                });
            });

        });
        app.routes(() -> {
            path("accounts", () -> {
                get(AccountsController::getAllAccounts); // /todo GET
                post(AccountsController::createAccounts); // /todo POST
                path("{id}", () -> {
                    get(AccountsController::getOneAccounts); // /todo/3 GET   get todo with todo id that is 3
                    patch(AccountsController::updateAccounts); // /todo/3 PATCH
                    delete(AccountsController::deleteAccounts); // /todo/3 DELETE
                });
            });

        });

    }
}
/*app.get("/getAllUsers", UsersController::getAllUsers);
        app.get("/getOneUsers", UsersController::getOneUsers);
        app.post("/createUsers", UsersController::createUsers);
        app.get("/updateUsers", UsersController::updateUsers);
        app.get("/deleteUsers", UsersController::deleteUsers);

        app.get("/getAllAccounts", AccountsController::getAllAccounts);
        app.get("/getOneAccounts", AccountsController::getOneAccounts);
        app.post("/createAccounts", AccountsController::createAccounts);
        app.get("/updateAccounts", AccountsController::updateAccounts);
        app.get("/deleteAccounts", AccountsController::deleteAccounts);
*/
/*app.error(201,"/createUsers", UsersController::createUsers);*/