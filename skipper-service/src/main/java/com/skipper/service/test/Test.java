package com.skipper.service.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author shoujian
 * Date: 2017-10-17
 * Time: 下午3:28
 */
public class Test {

    private final LinkedList<Integer> list = new LinkedList<Integer>();

    private static final LimitQueue<String> queue = new LimitQueue<String>(3);

    private static ExecutorService service = Executors.newFixedThreadPool(30);

    private Integer number = 0;

    private class newThread implements Runnable {
        private Integer threadNumber;

        private newThread(Integer threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            while (true) {
                Long start = System.currentTimeMillis();
                System.out.println(number);
                // System.out.println("Writing " + letter);
                // System.out.flush();
                number++;
                queue.offer(number + "");
//                System.out.println(threadNumber + " : " + queue.size());
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("time:" + (System.currentTimeMillis() - start));
            }
        }
    }

    public void threadController() {
        for (int i = 0; i < 40; i++) {
            service.execute(new newThread(i));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Test test = new Test();

        test.threadController();
    }
}
