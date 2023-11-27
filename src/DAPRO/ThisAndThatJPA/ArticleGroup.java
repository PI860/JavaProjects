package DAPRO.ThisAndThatJPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Paulina Pyczot
 * @date 14.11.2023
 **/

@Entity
public class ArticleGroup {
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private int articleGroup_id; // primary key

    @Column(nullable = false)
    private String articleGroup;

    @Column(nullable = false)
    private boolean deleted;

    public int getArticleGroup_id() {
        return articleGroup_id;
    }

    public void setArticleGroup_id(int articleGroup_id) {
        this.articleGroup_id = articleGroup_id;
    }

    public String getArticleGroup() {
        return articleGroup;
    }

    public void setArticleGroup(String articleGroup) {
        this.articleGroup = articleGroup;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
