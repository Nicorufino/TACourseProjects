package com.solvd.newsPortal.models.comment;

import com.solvd.newsPortal.models.article.Article;
import com.solvd.newsPortal.models.user.User;

public class Comment {
    private Long id;
    private String comment_text;
    private User user;
    private Article article;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment_text='" + comment_text + '\'' +
                ", user=" + user +
                ", article=" + article +
                '}';
    }
}
