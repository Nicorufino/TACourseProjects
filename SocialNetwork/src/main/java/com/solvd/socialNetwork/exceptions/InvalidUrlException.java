package com.solvd.socialNetwork.exceptions;

import org.apache.log4j.Logger;

public class InvalidUrlException extends Exception {
    private final static Logger LOGGER = Logger.getLogger(InvalidUrlException.class.getName());
    public InvalidUrlException() {
        LOGGER.debug("Invalid URL");
    }

    public InvalidUrlException(String message) {
        LOGGER.debug(message);
    }
}
