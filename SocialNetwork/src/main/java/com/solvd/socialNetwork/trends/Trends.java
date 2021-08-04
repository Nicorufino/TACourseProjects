package com.solvd.socialNetwork.trends;

import com.solvd.socialNetwork.posts.Post;

import java.util.List;


public class Trends {
    private String trendName;
    private List<Post> trendPosts;

    public String getTrendName() {
        return trendName;
    }

    public void setTrendName(String trendName) {
        this.trendName = trendName;
    }

    public List<Post> getTrendPosts() {
        return trendPosts;
    }

    public void setTrendPosts(List<Post> trendPosts) {
        this.trendPosts = trendPosts;
    }

    public void showOnHomePage(){}
}
