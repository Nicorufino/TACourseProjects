package com.solvd.socialNetwork.posts;

import com.solvd.socialNetwork.Date;
import com.solvd.socialNetwork.accounts.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Post {
    private String text;
    private Account author;
    private Date postDate;
    private int likes;
    private List<Queue<Post>> responses;


    public Post() {
    }

    public Post(String text) {
        this.text = text;
        this.responses = new ArrayList<Queue<Post>>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Queue<Post>> getResponses() {
        return responses;
    }

    public void setResponses(List<Queue<Post>> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", author=" + author +
                ", likes=" + likes +
                '}';
    }

}


