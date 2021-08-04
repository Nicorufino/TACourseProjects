package com.solvd.newsPortal;

public class Comment {
    private Long id;
    private String comment_text;
    private Long Users_id;
    private Long Articles_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Long getUsers_id() {
        return Users_id;
    }

    public void setUsers_id(Long users_id) {
        Users_id = users_id;
    }

    public Long getArticles_id() {
        return Articles_id;
    }

    public void setArticles_id(Long articles_id) {
        Articles_id = articles_id;
    }
}
