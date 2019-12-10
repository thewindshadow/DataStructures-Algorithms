package com.battle;

import com.battle.queue.ArrayQueue;
import com.battle.queue.LoopQueue;
import com.battle.queue.Queue;

import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 100000000.0;
    }

    public static void main(String[] args) {
        int opCont = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time = testQueue(arrayQueue, opCont);
        System.out.println(" ArrayQueue, time :" + time + "s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(loopQueue, opCont);
        System.out.println("LoopQueue time :  " + time1 + "s");
    }
}
