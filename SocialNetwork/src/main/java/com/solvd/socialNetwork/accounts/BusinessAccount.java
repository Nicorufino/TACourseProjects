package com.solvd.socialNetwork.accounts;

import com.solvd.socialNetwork.exceptions.InvalidTextException;
import com.solvd.socialNetwork.exceptions.InvalidUrlException;
import com.solvd.socialNetwork.interfaces.IAdvertise;
import com.solvd.socialNetwork.interfaces.IPost;
import com.solvd.socialNetwork.posts.AdvertisementPost;
import com.solvd.socialNetwork.posts.Post;
import org.apache.log4j.Logger;


public class BusinessAccount extends Account implements IPost, IAdvertise {
    private String businessType;
    private final static Logger LOGGER = Logger.getLogger(BusinessAccount.class);

    public BusinessAccount(){}
    public BusinessAccount(String name, long id, String businessType) {
        super(name, id);
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Override
    public AdvertisementPost advertisement(String text, String adUrl) throws InvalidUrlException{
        AdvertisementPost ad = new AdvertisementPost();
        try {
            if (adUrl.equals("")) {
                throw new InvalidUrlException();
            } else {
                ad.setText(text);
                ad.setAdUrl(adUrl);
                ad.setAuthor(this);
            }

        }  catch (InvalidUrlException e){
            LOGGER.error(e);
        }
        return ad;
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
}
