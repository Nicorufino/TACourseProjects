package com.solvd.socialNetwork.enums;

public enum Genre {
    MALE, FEMALE, OTHER;

    public boolean isGenreDeclared(){
        return this != OTHER;
    }
}
