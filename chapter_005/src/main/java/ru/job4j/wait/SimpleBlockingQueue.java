package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private volatile Queue<T> queue = new LinkedList<>();
    private final Object lock = new Object();


    public void offer(T value) {
        synchronized (this.lock) {
            while (queue.size() >= 10) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(value);
            lock.notify();
        }
    }

    public T poll() {
        T result;
        synchronized (this.lock) {
            while (queue.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result = queue.poll();
            lock.notify();
        }
        return result;
    }
}