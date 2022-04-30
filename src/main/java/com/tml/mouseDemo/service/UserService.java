package com.tml.mouseDemo.service;

import java.util.concurrent.ExecutionException;

public interface UserService {

    String printUser(String userName,String value);


    void executorLogTest() throws Exception;

    void executorSubmitTest() throws ExecutionException, InterruptedException;

    void customExecutor() throws InterruptedException;
}
