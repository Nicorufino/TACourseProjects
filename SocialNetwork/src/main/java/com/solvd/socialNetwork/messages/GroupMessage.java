package com.solvd.socialNetwork.messages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GroupMessage extends Message{
    private List<Long> membersIds;


    public GroupMessage(){
        this.membersIds = new ArrayList<Long>();
    }
    public GroupMessage(ArrayList<Long> membersIds) {
        this.membersIds = membersIds;
    }


    public List<Long> getMembersIds() {
        return membersIds;
    }

    public void setMembersIds(List<Long> membersIds) {
        this.membersIds = membersIds;
    }

    public void addMember(ArrayList<Long> memberIDs){}
    public void removeMember(ArrayList<Long> memberIDs){}
}
