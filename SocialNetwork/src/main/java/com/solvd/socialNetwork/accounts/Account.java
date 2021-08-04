package com.solvd.socialNetwork.accounts;

import com.solvd.socialNetwork.messages.Message;
import com.solvd.socialNetwork.posts.Post;

import java.util.List;

public abstract class Account {
    private String name;
    private long id;
    private int followers;
    private List<Message> directMessages;

    public Account(){}
    public Account(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public List<Message> getDirectMessages() {
        return directMessages;
    }

    public void setDirectMessages(List<Message> directMessages) {
        this.directMessages = directMessages;
    }

    public void follow(){}
    public void sendMessage(){};
    public void likePost(Post post){
        post.setLikes(post.getLikes()+1);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
