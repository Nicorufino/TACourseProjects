package com.solvd.socialNetwork.exceptions;

import org.apache.log4j.Logger;

public class InvalidTextException extends Exception {
    private final static Logger LOGGER = Logger.getLogger(InvalidTextException.class.getName());
    public InvalidTextException() {
     LOGGER.debug("Text should not be empty");
    }

    public InvalidTextException(String message){
        LOGGER.debug(message);
    }
}
