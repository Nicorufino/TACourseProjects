package com.solvd.socialNetwork.messages;

import com.solvd.socialNetwork.Date;
import com.solvd.socialNetwork.Media;

public class Message {
    private String messageText;
    private Media messageMedia;
    private Date messageDate;
    private long receiverID;


    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Media getMessageMedia() {
        return messageMedia;
    }

    public void setMessageMedia(Media messageMedia) {
        this.messageMedia = messageMedia;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public long getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(long receiverID) {
        this.receiverID = receiverID;
    }
}
