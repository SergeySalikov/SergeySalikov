package ru.job4j.pool;

import java.util.concurrent.BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class EmailNotification {
    private final BlockingQueue<User> userStore;

    public EmailNotification(LinkedBlockingQueue<User> userStore) {
        this.userStore = userStore;
    }

    public void emailTo() {
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        while (!userStore.isEmpty()) {
            pool.submit(new Runnable() {
                String subject;
                String body;

                @Override
                public void run() {
                    User user = userStore.poll();
                    subject = "Notification" + user.getUserName() + " to " + "email " + user.getEmail();
                    body = "Add a new event to " + user.getUserName();
                    send(subject, body, user.getEmail());
                }
            });
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Execute " + Thread.currentThread().getName());
    }


    private void send(String subject, String body, String email) {
    }
}
