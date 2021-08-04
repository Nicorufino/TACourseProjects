package com.solvd.socialNetwork.exceptions;


import org.apache.log4j.Logger;

public class InvalidIdsException extends Exception{
    private final static Logger LOGGER = Logger.getLogger(InvalidIdsException.class.getName());
    public InvalidIdsException(){
        LOGGER.debug("Invalid ids");
    }

    public InvalidIdsException(String message){
        LOGGER.debug(message);
    }
}
