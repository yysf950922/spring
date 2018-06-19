package com.odin.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/6/19.
 */
public class TraditionTimerTest {

    private static int count ;

    // 定时器
    public static void main(String[] args) {
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("bombing!");
//            }
//        },10000,3000);


        class MyTimerTask extends TimerTask{
            public void run() {
                count = (count+1)%2;
                System.out.println("bombing!");
                new Timer().schedule(new MyTimerTask(), 2000+2000*count);
            }
        }
        new Timer().schedule(new MyTimerTask(),2000);
        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
