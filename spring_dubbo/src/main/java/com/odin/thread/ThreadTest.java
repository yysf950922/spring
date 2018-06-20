package com.odin.thread;

/**
 * Created by Administrator on 2018/6/19.
 */
public class ThreadTest {
    // 多线程入门
    public static void main(String[] args) {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("1" + Thread.currentThread().getName());
                    System.out.println("2" + this.getName());
                }
            }
        };
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("1" + Thread.currentThread().getName());
                }
            }
        });
        thread1.start();


        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("runnable" + Thread.currentThread().getName());
                }
            }
        }) {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("1" + Thread.currentThread().getName());
                }
            }
        }.start();
    }



}
