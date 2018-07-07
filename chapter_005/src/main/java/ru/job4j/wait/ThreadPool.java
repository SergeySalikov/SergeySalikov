package ru.job4j.wait;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private boolean isShutDown = false;

    ThreadPool() {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threads.add(i, new Thread(new PoolThread()));
            threads.get(i).start();
        }
    }

    public void work(Runnable job) {
        if (!isShutDown) {
            tasks.offer(job);
        }
    }

    public void shutdown() {
        isShutDown = true;
    }

    private class PoolThread implements Runnable {
        Queue<Runnable> threadTask;

        PoolThread() {
            this.threadTask = tasks;
        }

        @Override
        public void run() {
            while (!isShutDown) {
                Runnable nextTask = tasks.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
