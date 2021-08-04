package com.solvd.socialNetwork.accounts;

import com.solvd.socialNetwork.exceptions.InvalidIdsException;
import com.solvd.socialNetwork.exceptions.InvalidTextException;
import com.solvd.socialNetwork.exceptions.NotInGroupException;
import com.solvd.socialNetwork.interfaces.ICreateGroup;
import com.solvd.socialNetwork.interfaces.ILeaveGroup;
import com.solvd.socialNetwork.interfaces.IPost;
import com.solvd.socialNetwork.messages.GroupMessage;
import com.solvd.socialNetwork.posts.Post;
import org.apache.log4j.Logger;

import java.util.ArrayList;


public class UserAccount extends Account implements IPost, ICreateGroup, ILeaveGroup {
    private boolean isVerified;

    private final static Logger LOGGER = Logger.getLogger(UserAccount.class);

    public UserAccount(String name, long id, boolean isVerified) {
        super(name, id);
        this.isVerified = isVerified;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public void reportPost() {
    }

    @Override
    public Post post(String text) {
        Post post = new Post();
        try {
            if (text == "") {
                throw new InvalidTextException();
            } else {
                post.setText(text);
                post.setAuthor(this);
            }
        } catch (InvalidTextException e) {
            LOGGER.error(e);
        }
        return post;
    }

    @Override
    public GroupMessage createGroup(ArrayList<Long> membersIds) throws InvalidIdsException {
        GroupMessage newGroup = new GroupMessage();
        try {
            if (membersIds.isEmpty()) {
                throw new InvalidIdsException();

            } else {
                newGroup.setMembersIds(membersIds);
            }
        } catch (InvalidIdsException e) {
            LOGGER.error(e);
        }
        return newGroup;

    }

    @Override
    public void leaveGroup(GroupMessage groupToLeave) throws NotInGroupException {


            if (groupToLeave.getMembersIds().contains(this.getId())) {
                LOGGER.debug("Group left");
            } else {
                throw new NotInGroupException();
            }
    }


    @Override
    public String toString() {
        return  super.toString() +
                "isVerified=" + isVerified +
                "}";
    }
}