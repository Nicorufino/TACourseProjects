package com.solvd.socialNetwork.interfaces;

import com.solvd.socialNetwork.exceptions.InvalidIdsException;
import com.solvd.socialNetwork.exceptions.InvalidTextException;
import com.solvd.socialNetwork.posts.Post;


public interface IPost {
        public Post post(String text);
    };

