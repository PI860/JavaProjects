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
//public class Article {
//    @Id
//    @Basic(optional = false)
//    @Column(nullable = false)
//    private int article_id; //primary key
//
//    @Column(nullable = false)
//    private String article;
//
//    @Column(nullable = false)
//    private double price;
//    private String currency;
//    @Column(nullable = false)
//    private boolean deleted;
//
//    public int getArticle_id() {
//        return article_id;
//    }
//
//    public void setArticle_id(int article_id) {
//        this.article_id = article_id;
//    }
//
//    public String getArticle() {
//        return article;
//    }
//
//    public void setArticle(String article) {
//        this.article = article;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//    }
//}
