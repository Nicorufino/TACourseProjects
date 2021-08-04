package com.solvd.socialNetwork;

import com.solvd.socialNetwork.accounts.Account;
import com.solvd.socialNetwork.posts.Post;
import com.solvd.socialNetwork.trends.Trends;

import java.lang.reflect.Array;
import java.util.*;

public class SocialNetwork {
    protected List<Account> accounts;
    protected Map<Post, Account> posts;
    protected Set<Trends> trends;


    public SocialNetwork(){
        this.accounts = new ArrayList<Account>();
        this.posts = new HashMap<Post, Account>();
        this.trends = new LinkedHashSet<Trends>();

    }

    public SocialNetwork(ArrayList<Account> accounts, Map<Post, Account> posts, LinkedHashSet<Trends> trends) {
        this.accounts = accounts;
        this.posts = posts;
        this.trends = trends;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Map<Post, Account> getPosts() {
        return posts;
    }

    public void setPosts(Map<Post, Account> posts) {
        this.posts = posts;
    }

    public Set<Trends> getTrends() {
        return trends;
    }

    public void setTrends(Set<Trends> trends) {
        this.trends = trends;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "accounts=" + accounts +
                ", posts=" + posts +
                ", trends=" + trends +
                '}';
    }
}
