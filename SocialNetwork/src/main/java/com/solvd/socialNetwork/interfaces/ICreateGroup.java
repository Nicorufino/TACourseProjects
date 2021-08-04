package com.solvd.socialNetwork.interfaces;

import com.solvd.socialNetwork.exceptions.InvalidIdsException;
import com.solvd.socialNetwork.messages.GroupMessage;

import java.util.ArrayList;

public interface ICreateGroup {
    public GroupMessage createGroup(ArrayList<Long> membersIds) throws InvalidIdsException;
}
