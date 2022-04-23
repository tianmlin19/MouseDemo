package com.tml.mouseDemo.core.jvm;


import com.tml.mouseDemo.model.User;

import java.lang.ref.SoftReference;

/**
 * 软引用测试
 * -Xmx 10m -Xms 10m
 */
public class SoftReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        SoftReference<User> softReference = new SoftReference<>(new User(1L,"123","456"));

        System.out.println(softReference.get());

        System.out.println("after gc!");

        System.gc();


        Thread.sleep(3000);
        System.out.println(softReference.get());

        try{
            byte[] bytes = new byte[1024 * 1024 * 7];
        }catch (Throwable e){
            e.printStackTrace();

        }finally {
            System.out.println(softReference.get());
        }

    }
}
