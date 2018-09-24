package com.thoughtworks.aopverify.repository;

import com.thoughtworks.aopverify.annotation.MyLogger;
import com.thoughtworks.aopverify.annotation.MySecondLogger;
import com.thoughtworks.aopverify.annotation.MyThirdLogger;
import org.springframework.stereotype.Repository;

@Repository
public class DataManager {

    @MyLogger
    public void startProduce(){
    }

    @MySecondLogger
    public void doProduce() throws Exception {
        throw new Exception();
    }

    @MyThirdLogger
    public String getResource(){
        return "OK";
    }
}
