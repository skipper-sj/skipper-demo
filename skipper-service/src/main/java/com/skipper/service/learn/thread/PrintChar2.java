package com.skipper.service.learn.thread;

import java.util.Map;

/**
 * Created by shoujian on 2017/6/22.
 */
public class PrintChar2 {


    public void print(){
        // 多线程执行
        final StringBuffer sb2 = new StringBuffer(); // 拼接的字符串，需要final修饰
        final ObjectLock objectLock = new ObjectLock(); // 这个是通信的锁
        objectLock.setIndex(1);

        // 启动三个线程
        new Thread(new Runnable() {

            public void run() {
                // 轮询查看是否轮到当前线程打印机会
                while (true) {
                    try {
                        Thread.currentThread().sleep(20);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    if (objectLock.getIndex() % 3 == 1) {
                        // 如果当前打印的次数%3 == 1,此线程获取锁，得到打印机会
                        synchronized (objectLock) {
                            // 唤醒其他打印线程
                            objectLock.notifyAll();
                            System.out.println(Thread.currentThread().getName() + " 加锁对象");
                            try {
                                for (int i = 0; i < objectLock.getIndex(); i++) {
                                    sb2.append('A');
                                }
                                System.out.println(sb2);
                                // 设置标记，避免重复打印
                                objectLock.setPrint(true);
                                // 设置计数
                                Map<Character, Long> map = objectLock.getCounterMap();
                                Long count = map.get('A');
                                if (count == null) {
                                    count = 0l;
                                }
                                count += 1l;
                                map.put('A', count);
                                objectLock.wait(); // 释放锁
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }

        }, "thread--A").start();
        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    try {
                        Thread.currentThread().sleep(20);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    if (objectLock.getIndex() % 3 == 2) {
                        synchronized (objectLock) {
                            objectLock.notifyAll();
                            System.out.println(Thread.currentThread().getName() + " 加锁对象");
                            try {
                                Thread.currentThread().sleep(1000);
                                for (int i = 0; i < objectLock.getIndex(); i++) {
                                    sb2.append('B');
                                }
                                System.out.println(sb2);
                                objectLock.setPrint(true);

                                Map<Character, Long> map = objectLock.getCounterMap();
                                Long count = map.get('B');
                                if (count == null) {
                                    count = 0l;
                                }
                                count += 1l;
                                map.put('B', count);
                                objectLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }

        }, "thread--B").start();
        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    try {
                        Thread.currentThread().sleep(20);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    if (objectLock.getIndex() % 3 == 0) {
                        synchronized (objectLock) {
                            objectLock.notifyAll();
                            System.out.println(Thread.currentThread().getName() + " 加锁对象");
                            try {
                                Thread.currentThread().sleep(1000);
                                for (int i = 0; i < objectLock.getIndex(); i++) {
                                    sb2.append('C');
                                }
                                System.out.println(sb2);
                                objectLock.setPrint(true);

                                Map<Character, Long> map = objectLock.getCounterMap();
                                Long count = map.get('C');
                                if (count == null) {
                                    count = 0l;
                                }
                                count += 1l;
                                map.put('C', count);
                                objectLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }

        }, "thread--C").start();
        while (sb2.length() <= 200) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (objectLock.isPrint()) {
                objectLock.setIndex(objectLock.getIndex() + 1);
                objectLock.setPrint(false);

                System.out.println(objectLock.getCounterMap());
            }
        }
    }


    public static void main(String[] args) {
        PrintChar2 printChar2 = new PrintChar2();
        printChar2.print();

    }

}
