import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UsersDao;
import dao.UsersDaoImpl;
import frontcontroller.FrontController;
import io.javalin.Javalin;
import models.Users;
import services.UsersService;
import javax.naming.Context;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(9000);
        new FrontController(app);


    }
}
