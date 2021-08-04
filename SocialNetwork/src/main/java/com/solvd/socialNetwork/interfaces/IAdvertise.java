package com.solvd.socialNetwork.interfaces;

import com.solvd.socialNetwork.exceptions.InvalidUrlException;
import com.solvd.socialNetwork.posts.AdvertisementPost;

public interface IAdvertise {
    public AdvertisementPost advertisement(String text, String adUrl) throws InvalidUrlException;
}
