package com.skipper.service.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author shoujian
 * Date: 2017-10-17
 * Time: 下午3:30
 */
public class LimitQueue<E> implements Queue<E> {

    /**
     * 队列长度，实例化类的时候指定
     */
    private int limit;

    Queue<E> queue = new ArrayBlockingQueue<E>(10);

    public LimitQueue(int limit) {
        this.limit = limit;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * 入队
     */
    public boolean offer(E e) {
        System.out.println("size:=========" + queue.size());

        if (queue.size() >= limit) {
            System.out.println("size:------------" + queue.size());

            //如果超出长度,入队时,先出队
            if (queue.size() > 3) {
                System.out.println(queue.size());
            }
            queue.poll();
        }
        System.out.println("size:------------" + queue.size());
        return queue.offer(e);
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    public static void main(String[] args) {
        Queue<String> queues = new ArrayBlockingQueue<String>(3);
        queues.offer("1");
        queues.offer("2");
        queues.poll();
        String[] strings = new String[10];
        queues.toArray(strings);
        System.out.println("1 : " + strings[0]);
        System.out.println("2 : " + strings[1]);
    }
}
