package com.solvd.socialNetwork.generics;

import com.solvd.socialNetwork.messages.Message;

public class MessageGeneric<T extends Message> {
    private T t;

    public MessageGeneric() {
    }

    public MessageGeneric(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

