package com.solvd.socialNetwork.enums;

public enum Day {
    SUNDAY("sunday", 1),
    MONDAY("monday", 2),
    TUESDAY("tuesday", 3),
    WEDNESDAY("wednesday", 4),
    THURSDAY("thursday", 5),
    FRIDAY("friday", 6),
    SATURDAY("saturday", 7);

    private String name;
    private int number;

    Day(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isWorkingDay(){
        return (this.number != 1 && this.number != 7);
    }
}
