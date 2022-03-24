package com.tml.mouseDemo.core.jvm;

public class SingleTon {

    private static SingleTon INSTANCE;

    private int flag = 100;

    /**
     * 双重校验锁
     * DCL
     *
     * @return
     */
    public static SingleTon getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleTon.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleTon();
                }
            }
        }

        return INSTANCE;
    }

    private SingleTon() {

    }


    public static void main(String[] args) {


        for (int i = 0; i < 20; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (SingleTon.getInstance().flag == 0) {
                        System.out.println("单例异常！");
                    }
                }
            }).start();


        }


    }

}
