package dao;

import models.Accounts;
import models.Users;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDaoImpl implements AccountsDao{

    String url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/project0";
    String username = System.getenv("RDS_USERNAME");
    String password = System.getenv("RDS_PASSWORD");

    Logger logger = Logger.getLogger(UsersDaoImpl.class);


    @Override
    public List<Accounts> getAllAccounts() {
        List<Accounts> accounts = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM accounts;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                accounts.add(new Accounts(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
            }

        }catch (SQLException e){
            logger.error(e);
        }
        return accounts;
    }

    @Override
    public Accounts getOneAccounts(Integer accountsId) {

        Accounts accounts = null;
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM accounts where id = 1;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accountsId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                accounts = new Accounts(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
            }

            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }
        return accounts;
    }

    @Override
    public void createAccounts(Accounts accounts) {
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO accounts VALUES (DEFAULT, '?');";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, accounts.getAccount_type());

            ps.executeUpdate();
            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void updateAccounts(Integer accountsId) {
        try{
            //creating connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql that I will be executing
            String sql = "UPDATE accounts SET balance =6000 WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            //set value of question mark. The parameter index is which question mark you want to assign
            ps.setInt(1,accountsId);

            ps.executeUpdate();

            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void deleteAccounts(Integer accountsId) {
        try{
            //creating connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //sql that I will be executing
            String sql = "DELETE FROM accounts WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            //set value of question mark. The parameter index is which question mark you want to assign
            ps.setInt(1,accountsId);

            ps.executeUpdate();

            conn.close();

        }catch (SQLException e){
            logger.error(e);
        }
    }

}
