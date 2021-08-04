package com.solvd.socialNetwork.enums;

public enum Month {

        JANUARY("january", 1),
        FEBRUARY("february", 2),
        MARCH("march", 3),
        APRIL("april", 4),
        MAY("may", 5),
        JUNE("june", 6),
        JULY("july", 7),
        AUGUST("august", 8),
        SEPTEMBER("september", 9),
        OCTOBER("october", 10),
        NOVEMBER("november", 11),
        DECEMBER("december", 12);




        final private String name;
        final private int number;

        Month(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }

    }
