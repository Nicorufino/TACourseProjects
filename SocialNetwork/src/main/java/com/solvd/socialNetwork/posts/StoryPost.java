package com.solvd.socialNetwork.posts;

import com.solvd.socialNetwork.Media;
import com.solvd.socialNetwork.interfaces.IAutoDelete;

public class StoryPost extends Post implements IAutoDelete {
    private int storyDuration;
    private Media storyMedia;
    protected int timeUntilDeletion;

    public int getStoryDuration() {
        return storyDuration;
    }

    public void setStoryDuration(int storyDuration) {
        this.storyDuration = storyDuration;
    }

    public Media getStoryMedia() {
        return storyMedia;
    }

    public void setStoryMedia(Media storyMedia) {
        this.storyMedia = storyMedia;
    }

    public int getTimeUntilDeletion() {
        return timeUntilDeletion;
    }

    public void setTimeUntilDeletion(int timeUntilDeletion) {
        this.timeUntilDeletion = timeUntilDeletion;
    }


    @Override
    public void autoDelete() {
        if (this.timeUntilDeletion == 0) {
            // implement logic to delete the shared post
        }
    }
}
