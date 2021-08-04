package com.solvd.socialNetwork.accounts;

public class ModeratorAccount extends Account{
    private String permissionLevel;

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public void moderatePost(){}

    @Override
    public String toString() {
        return "ModeratorAccount{" +
                "permissionLevel='" + permissionLevel + '\'' +
                "} " + super.toString();
    }
}
