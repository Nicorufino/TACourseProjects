package com.solvd.socialNetwork.exceptions;

import org.apache.log4j.Logger;

public class InvalidRegionException extends Exception {
    private final static Logger LOGGER = Logger.getLogger(InvalidRegionException.class.getName());
    public InvalidRegionException() {
        LOGGER.debug("Invalid region");
    }

    public InvalidRegionException(String message) {
        LOGGER.debug(message);
    }
}
