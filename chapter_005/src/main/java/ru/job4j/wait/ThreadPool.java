package ru.job4j.wait;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();

    public ThreadPool() {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threads.add(i, new Thread(new PoolThread()));
            threads.get(i).start();
        }
    }

    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private class PoolThread extends Thread {
        Queue<Runnable> threadTask;

        PoolThread() {
            this.threadTask = tasks;
        }

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Runnable nextTask = tasks.take();
                    nextTask.run();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " " + "end");
            }
        }
    }
}

