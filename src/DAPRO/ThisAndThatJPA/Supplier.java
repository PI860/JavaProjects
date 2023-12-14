//package DAPRO.ThisAndThatJPA;
//
//import jakarta.persistence.Basic;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
///**
// * @author Paulina Pyczot
// * @date 14.11.2023
// **/
//
//@Entity
//public class Supplier {
//
//    @Id
//    @Basic(optional = false) //sets "supplier_id" tells entity manager that this column is not optional (it will be not tried to save a value if it's not given before it wants to be saved to db)
//    @Column(nullable = false)
//    private int supplier_id;
//
//    @Column(nullable = false)
//    private String supplier;
//    //private int address_id; // muss aus class address eigentlich übergeben werden, da Fremdschlüssel!
//
//    @Column(nullable = false)
//    private boolean deleted;
//
//    public int getSupplier_id() {
//        return supplier_id;
//    }
//
//    public void setSupplier_id(int supplier_id) {
//        this.supplier_id = supplier_id;
//    }
//
//    public String getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(String supplier) {
//        this.supplier = supplier;
//    }
//
////    public int getAddress_id() {
////        return address_id;
////    }
//
////    public void setAddress_id(int address_id) {
////        this.address_id = address_id;
////    }
//
//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//    }
//}
