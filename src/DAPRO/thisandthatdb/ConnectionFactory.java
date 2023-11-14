package DAPRO.thisandthatdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Paulina Pyczot
 * @date 07.11.2023
 **/

public class ConnectionFactory {
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String host = "localhost:3306/";
    public static final String db = "user01_thisandthat";
    public static final String user = "user01";
    public static final String pw = "user01";

    //public static final String user1 = "root";
    //public static final String pw1 = "root";

    public static final String url = "jdbc:mysql://"+host+db;
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private ConnectionFactory(){
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection createConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,pw);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to connect to database! (PP)");;
        }
        return con;
    }
    public static Connection getConnection() {
        return instance.createConnection();
    }
}
