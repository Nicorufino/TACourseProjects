package com.solvd.socialNetwork.generics;

import com.solvd.socialNetwork.accounts.Account;

public class AccountGeneric<T extends Account> {
    private T t;

    public AccountGeneric() {
    }

    public AccountGeneric(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
