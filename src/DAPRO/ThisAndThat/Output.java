//package DAPRO.thisandthatdb;
//
//import java.sql.*;
//
///**
// * @author Paulina Pyczot
// * @date 07.11.2023
// **/
//
//public class Output {
//
//    private Connection con;
//    private Statement stm;
//    private PreparedStatement pst;
//
//    public void getArticle() {
//        String queryShowArticle = "SELECT * FROM ARTICLE";
//
//        ResultSet rs1 = null;
//
//        try {
//            con = ConnectionFactory.getConnection();
//            pst = con.prepareStatement(queryShowArticle);
//            Statement st = con.createStatement();
//            //String query1 = "SELECT * FROM CUSTOMER";
//            String query1 = "SELECT * FROM CUSTOMERs"; // test of the exception Handler: CUSTOMERs table does not exist -> gives out an error!
//
//            ResultSet rs = st.executeQuery(query1);
//
//            //That's like opening a file:
//            while (rs.next()) {
//                String firstname = rs.getString("FIRSTNAME");
//                String lastname = rs.getString("LASTNAME");
//
//                System.out.println(firstname + " " + lastname);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
