package dao;

import models.Users;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao{

    String url;
    String username;
    String password;

    Logger logger = Logger.getLogger(UsersDaoImpl.class);

    public UsersDaoImpl(){
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/project0";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public UsersDaoImpl(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;

    }


    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM users;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                users.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }

            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Users getOneUsers(Integer usersId) {

        Users users = null;

        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM users where id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,usersId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                users = new Users(rs.getInt(1),rs.getString(2),rs.getString(3));
            }

            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }
        return users;
    }

    @Override
    public void createUsers(Users users) {

        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO users VALUES (DEFAULT, '?');";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, users.getFirst_name());

            ps.executeUpdate();
            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void updateUsers(Integer usersId) {
        try{
            //creating connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql that I will be executing
            String sql = "UPDATE users SET last_name = 'de Lange.' WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            //set value of question mark. The parameter index is which question mark you want to assign
            ps.setInt(1,usersId);

            ps.executeUpdate();

            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void deleteUsers(Integer usersId) {
        try{
            //creating connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql that I will be executing
            String sql = "DELETE FROM users WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            //set value of question mark. The parameter index is which question mark you want to assign
            ps.setInt(1,usersId);

            ps.executeUpdate();

            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }
    }
}
