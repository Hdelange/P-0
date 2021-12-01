package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Util {
    public static String url = "jdbc:h2:./h2/db";
    public static String username = "sa";
    public static String password = "sa";

    public static void createTable() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "CREATE TABLE userss(\n" +
                    "\tid serial PRIMARY KEY,\n" +
                    "\tfirst_name varchar(50),\n" +
                    "\tlast_name varchar(50)\n" +
                    ");";
            String sql2 = "CREATE TABLE accounts(\n" +
                    "\tid serial PRIMARY KEY,\n" +
                    "\taccount_type varchar(50),\n" +
                    "\tbalance double PRECISION DEFAULT 0.00,\n" +
                    "\tusers_id_fk int REFERENCES users(id)\t\t\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps2 = conn.prepareStatement(sql2);

            ps.executeUpdate();
            ps2.executeUpdate();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void dropTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DROP TABLE users";
            String sql2 = "DROP TABLE accounts";

            PreparedStatement ps = conn.prepareStatement(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
