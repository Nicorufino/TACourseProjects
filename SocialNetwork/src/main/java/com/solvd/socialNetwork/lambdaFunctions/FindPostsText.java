package com.solvd.socialNetwork.lambdaFunctions;

import com.solvd.socialNetwork.accounts.Account;
import com.solvd.socialNetwork.posts.Post;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface FindPostsText {
    List<Post> findPost(Map<Post, Account> list, String criteria);
}


