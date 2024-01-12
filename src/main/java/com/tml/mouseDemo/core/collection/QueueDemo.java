package com.tml.mouseDemo.core.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueDemo {
    public static void main(String[] args) {






    }

    public static void testSynchronousQueue(){
        BlockingQueue<String> queue = new SynchronousQueue<>();

        queue.add("hello");
    }

    /**
     * 测试优先队列
     */
    public static void testPriorityQueue(){
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(8);
        queue.add(3);
        queue.add(18);

        Integer poll = queue.poll();
        Integer poll1 = queue.poll();
        Integer poll2 = queue.poll();

        System.out.println(poll);
    }


    /**
     * 测试双端队列
     */
    public static void testBlockingDeque(){
        BlockingDeque<Integer> deque = new LinkedBlockingDeque(2);
        deque.addFirst(5);
        deque.addFirst(8);
        deque.addLast(4);
        System.out.println(deque);
    }
}
