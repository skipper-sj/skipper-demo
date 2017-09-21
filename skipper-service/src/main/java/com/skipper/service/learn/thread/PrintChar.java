package com.skipper.service.learn.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shoujian on 2017/6/21.
 */
public class PrintChar implements Runnable {
    private StringBuffer sb = new StringBuffer();
    private ReentrantLock lock = new ReentrantLock();
    private Condition aThreadCondition = lock.newCondition(); // 重入锁条件
    private Condition bThreadCondition = lock.newCondition();
    private Condition cThreadCondition = lock.newCondition();
    private int status; // 状态0-A 线程打印， 状态1-B 线程打印, 状态2-B 线程打印
    private int index = 1;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int threada = 0;
    private int threadb = 0;
    private int threadc = 0;

    @Override
    public void run() {
        while (sb.length() < 200) {
            try {
                lock.lock();
                if ((sb.length() + index) >= 200) {
                    index = 200 - sb.length();
                }
                if (status == 0) {
                    threada++;
                    for (int i = 0; i < index; i++) {
                        sb.append("A");
                        a++;
                    }
                    index++;
                    bThreadCondition.signal();
                    status = 1;
                    aThreadCondition.await();
                }

                if (status == 1) {
                    threadb++;
                    for (int i = 0; i < index; i++) {
                        sb.append("B");
                        b++;
                    }
                    index++;
                    cThreadCondition.signal();
                    status = 2;
                    bThreadCondition.await();
                }

                if (status == 2) {
                    threadc++;
                    for (int i = 0; i < index; i++) {
                        sb.append("C");
                        c++;
                    }
                    index++;
                    aThreadCondition.signal();
                    status = 0;
                    cThreadCondition.await();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        System.out.println("打印完毕 : " + sb);
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("threada:" + threada);
        System.out.println("threadb:" + threadb);
        System.out.println("threadc:" + threadc);

    }

    public static void main(String[] args) {
        PrintChar printChar = new PrintChar();
        new Thread(printChar, "A-thread").start();
        new Thread(printChar, "B-thread").start();
        new Thread(printChar, "C-thread").start();
    }
}
