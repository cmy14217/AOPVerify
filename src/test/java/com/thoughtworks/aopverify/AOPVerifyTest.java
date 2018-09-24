package com.thoughtworks.aopverify;

import com.thoughtworks.aopverify.aspect.MyAspect;
import com.thoughtworks.aopverify.aspect.MyAspectForReturn;
import com.thoughtworks.aopverify.aspect.MyAspectForThrow;
import com.thoughtworks.aopverify.repository.DataManager;
import com.thoughtworks.aopverify.repository.LoggerManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AOPVerifyTest {

    @Autowired
    DataManager dataManager;

    @Autowired
    LoggerManager loggerManager;

    @Autowired
    MyAspect myAspect;

    @Autowired
    MyAspectForThrow myAspectForThrow;

    @Autowired
    MyAspectForReturn myAspectForReturn;

    @Test
    void should_log_around_before_around_after_when_method_is_normal() {
        dataManager.startProduce();
    }

    @Test
    void should_log_when_method_throw_exception() throws Exception {
        dataManager.doProduce();
    }

    @Test
    void should_log_when_method_return() {
        assertThat(dataManager.getResource()).isEqualTo("OK");
    }
}
