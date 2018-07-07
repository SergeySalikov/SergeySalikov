package ru.job4j.wait;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {

    public class Producer extends Thread {
        private SimpleBlockingQueue<Integer> blockingQueue;

        Producer(SimpleBlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                blockingQueue.offer(i);
            }
        }
    }

    public class Consumer extends Thread {
        private SimpleBlockingQueue<Integer> queue;
        private int counter = 0;
        private int[] arr = new int[10];

        Consumer(SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (counter != arr.length) {
                arr[counter++] = queue.poll();
            }
        }

        public int[] getArr() {
            return this.arr;
        }
    }

    @Test
    public void thenProducerConsumer() throws InterruptedException {
        SimpleBlockingQueue queue = new SimpleBlockingQueue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
        consumer.join();
        String result = Arrays.toString(consumer.getArr());
        String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";
        assertThat(result, is(expected));
    }

}
