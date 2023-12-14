package Article; /**
 * @author Paulina Pyczot
 * @date 28.11.2023
 **/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DBConnectionTest {

    private static Connection con;

    public static void main(String[] args) {

        String localURL = "jdbc:mysql://localhost:3306/";
        String db = "user01_thisandthat";
        String user = "user01";
        String pw = "user01";

        try {
            con = DriverManager.getConnection(localURL + db, user, pw);
            con.setAutoCommit(false);
            //testConnection();
            deleteSomething();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }


    public static void testConnection() throws SQLException {

        Statement sta = con.createStatement();

        String sqlQuery = "SELECT * FROM CUSTOMER;";

        ResultSet rs = sta.executeQuery(sqlQuery);

        while(rs.next()) {

            System.out.println(rs.getString("SALUTATION") + " " + rs.getString("LASTNAME"));

        }
        sta.close();
        rs.close();
    }

    private static void deleteSomething() throws SQLException {

        int id = 0;

        //Statement sta = con.createStatement();


        String sqlUpdate = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";

        PreparedStatement psta = con.prepareStatement(sqlUpdate);
        psta.setInt(1, id);

        int affRows = psta.executeUpdate();
        con.commit();

        System.out.println(affRows);


    }

}
