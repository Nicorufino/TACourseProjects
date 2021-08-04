package com.solvd.socialNetwork.interfaces;

import com.solvd.socialNetwork.exceptions.NotInGroupException;
import com.solvd.socialNetwork.messages.GroupMessage;

public interface ILeaveGroup {
    public void leaveGroup(GroupMessage groupToLeave) throws NotInGroupException;
}
