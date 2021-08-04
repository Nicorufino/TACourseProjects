package com.solvd.socialNetwork.generics;

import com.solvd.socialNetwork.posts.Post;

public class PostGeneric<T extends Post> {
    private T t;

    public PostGeneric() {
    }

    public PostGeneric(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
