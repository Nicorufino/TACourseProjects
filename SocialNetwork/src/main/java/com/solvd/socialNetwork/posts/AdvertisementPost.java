package com.solvd.socialNetwork.posts;

public class AdvertisementPost extends Post{
    private String adUrl;

    public AdvertisementPost(){}

    public AdvertisementPost(String text, String adUrl) {
        this.adUrl = adUrl;
        setText(text);
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public void openAd(){}
}
