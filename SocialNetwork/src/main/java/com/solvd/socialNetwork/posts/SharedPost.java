package com.solvd.socialNetwork.posts;

// this class works like a citation from twitter where you can show the original post and add something yourself

import com.solvd.socialNetwork.accounts.Account;
import com.solvd.socialNetwork.interfaces.IAutoDelete;

public class SharedPost extends Post implements IAutoDelete {
    private Account originalPoster;
    private Post originalPost;
    private Post addedContent;

    public Account getOriginalPoster() {
        return originalPoster;
    }

    public void setOriginalPoster(Account originalPoster) {
        this.originalPoster = originalPoster;
    }

    public Post getOriginalPost() {
        return originalPost;
    }

    public void setOriginalPost(Post originalPost) {
        this.originalPost = originalPost;
    }

    public Post getAddedContent() {
        return addedContent;
    }

    public void setAddedContent(Post addedContent) {
        this.addedContent = addedContent;
    }


    @Override
    public void autoDelete() {
        if (this.originalPost instanceof StoryPost && ((StoryPost) this.originalPost).timeUntilDeletion == 0){
            // implement logic to delete the shared post
            }
    }
}
