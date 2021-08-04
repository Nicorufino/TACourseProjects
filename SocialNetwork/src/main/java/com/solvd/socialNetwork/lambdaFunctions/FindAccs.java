package com.solvd.socialNetwork.lambdaFunctions;

import com.solvd.socialNetwork.accounts.Account;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface FindAccs {
    List<Account> findAcc(ArrayList<Account> list, String criteria);
}
