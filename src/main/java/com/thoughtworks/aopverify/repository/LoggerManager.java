package com.thoughtworks.aopverify.repository;

import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LoggerManager {
    public void log(String message){
        LogFactory.getLog(LoggerManager.class).info(message);
    }

}
