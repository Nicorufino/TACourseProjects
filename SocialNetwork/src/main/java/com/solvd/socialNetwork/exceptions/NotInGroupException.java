package com.solvd.socialNetwork.exceptions;

import org.apache.log4j.Logger;

public class NotInGroupException extends Exception {
    private final static Logger LOGGER = Logger.getLogger(NotInGroupException.class.getName());
    public NotInGroupException() {
        LOGGER.debug("You're not in this group");
    }

    public NotInGroupException(String message) {
        LOGGER.debug(message);
    }
}
