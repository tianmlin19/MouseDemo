package com.tml.mouseDemo.core.jvm;

import com.tml.mouseDemo.model.User;

import java.lang.ref.WeakReference;

/**
 * 若引用
 */
public class WeakReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        WeakReference<User> weakReference = null;

        System.out.println(weakReference.get());

        System.out.println("after gc!");

        System.gc();


        Thread.sleep(3000);
        System.out.println(weakReference.get());
    }
}
