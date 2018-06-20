package com.odin.thread;

/**
 * Created by Administrator on 2018/6/20.
 */
public class ThreadInterviewQuestions {
    public static void main(String[] args) {
        /**
         *  子线程循环10次，接着主线程循环100次，接着子线程又循环10次，再回到主线程循环100次
         *  如此往复下去
         */
        final Bussines bussines = new Bussines();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    bussines.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            bussines.main(i);
        }
    }

}

class Bussines {

    private boolean aBoolean = true;
    public synchronized void sub(int i) {
        if (!aBoolean){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread sequece of" + j + "，第" + i + "次循环");
        }
        aBoolean =false;
        this.notify();
    }

    public synchronized void main(int i) {
        if (aBoolean){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread sequece of" + j + "，第" + i + "次循环");
        }
        aBoolean=true;
        this.notify();
    }
}
