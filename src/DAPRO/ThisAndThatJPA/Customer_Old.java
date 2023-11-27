//package DAPRO.ThisAndThatJPA;
//
//import jakarta.persistence.Basic;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
////import jakarta.persistence.Table;
///**
// * @author Paulina Pyczot
// * @date 14.11.2023
// **/
//
//@Entity
////@Table(name="customer") //eher für Python
//public class Customer_Old {
//
//    @Id
//    private int customer_id;
//
//    @Basic (optional = false) //sets "lastname" tells entity manager that this column is not optional (it will be not tried to save a value if it's not given before it wants to be saved to db)
//    @Column (nullable = false) //sets primary identifier "lastname" to NN (right now it is set to be nullable); only used for creating table structures
//    // -> lastname can never be optional if you set it up like this!
//    private String lastname;
//
//    private String salutation;
//
//    @Column(nullable = false)
//    private String firstname;
//
//    // private int invoiceAddressId; // Foreign key
//
//    // private int deliverAddressId; // Foreign key
//    @Column(nullable = false)
//    private String customer_type;
//
//    @Column(nullable = false)
//    private boolean deleted;
//
//    // Generate Getters and Setters:
//    public int getCustomer_id() {
//        return customer_id;
//    }
//
//    public void setCustomer_id(int customer_id) {
//        this.customer_id = customer_id;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
////    public String getCustomer_type() {
////        return customer_type;
////    }
//
////    public void setCustomer_type(String customer_type) {
////        this.customer_type = customer_type;
////    }
//
//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    public String getSalutation() {
//        return salutation;
//    }
//
//    public void setSalutation(String salutation) {
//        this.salutation = salutation;
//    }
//
//    public String getCustomer_type() {
//        return customer_type;
//    }
//
//    public void setCustomer_type(String customer_type) {
//        this.customer_type = customer_type;
//    }
//
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//
//
//    }
//}
