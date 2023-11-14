package DAPRO.thisandthatdb;

import java.sql.*;

/**
 * @author Paulina Pyczot
 * @date 07.11.2023
 **/

public class DBConnectionTest {

    static String host = "localhost:3306/";
    static String db = "user01_thisandthat";
    static String user = "user01";
    static String pw = "user01";

    static String user1 = "root";
    static String pw1 = "root";
    static String url = "jdbc:mysql://"+host+db;

    public static Connection con;

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(url, user, pw);
            //con = DriverManager.getConnection(url, user1, pw1); // root user privileges
            con.setAutoCommit(false);
            testConnection();
            deleteSomething();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testConnection() {
        try {
            Statement st = con.createStatement();
            //String query1 = "SELECT * FROM CUSTOMER";
            String query1 = "SELECT * FROM CUSTOMERs"; // test of the exception Handler: CUSTOMERs table does not exist -> gives out an error!
            st.executeQuery(query1);

            ResultSet rs = st.executeQuery(query1);

            //That's like opening a file:
            while (rs.next()) {
                String firstname = rs.getString("FIRSTNAME");
                String lastname = rs.getString("LASTNAME");

                System.out.println(firstname + " " + lastname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteSomething() {
        int customerId = 0;
        String delete = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?"; // ? = placeholder, can be replaced with actual values
        try {
            PreparedStatement pst = con.prepareStatement(delete); // precompiled, but not executed in the db
            pst.setInt(1, customerId);
            int rows = pst.executeUpdate();
            // Commit of the changes in the connection (everything will be committed):
            con.commit();

            System.out.println(rows);
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }


    }

}
