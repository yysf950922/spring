package com.odin.thread;

import javax.sound.midi.Soundbank;

/**
 * Created by Administrator on 2018/6/20.
 */
public class TraditionThreadSynchronized {
    public static void main(String[] args) {
        new TraditionThreadSynchronized().init();
    }

    private void init() {
        // 在静态方法中不能new内部类的实例对象
        final OutPuter outPuter = new OutPuter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output3("薛涛");
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output("奥丁");
                }
            }
        }).start();
    }

   static class  OutPuter {
        public void output(String name) {
            int length = name.length();
            synchronized (OutPuter.class) {
                for (int i = 0; i < length; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
        public synchronized void output2(String name) {
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        // 锁使用的字节码对象
        public static synchronized void output3(String name) {
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

    }
}
