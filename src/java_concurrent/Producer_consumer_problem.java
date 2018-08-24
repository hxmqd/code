package java_concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer {

    private final Lock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    private int maxSize;
    private List<Object> storage;

    Buffer(int size) {

        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        maxSize = size;
        storage = new LinkedList<>();
    }

    public void put() {
        lock.lock();
        try {
            while (storage.size() == maxSize) {
                System.out.println(Thread.currentThread().getName() + ": wait, 队列满了");
                notFull.await();
            }
            storage.add(new Object());
            System.out.println(Thread.currentThread().getName() + ": put, size：" + storage.size());
            Thread.sleep(200);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " wait， 队列为空");
                notEmpty.await();
            }
            storage.remove(storage.size() - 1);
            System.out.println(Thread.currentThread().getName() + " take, size:" + storage.size());
            Thread.sleep(200);
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    Producer(Buffer b) {
        buffer = b;
    }

    @Override
    public void run() {
        while (true) {
            buffer.put();
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    Consumer(Buffer b) {
        buffer = b;
    }

    @Override
    public void run() {
        while (true) {
            buffer.take();
        }
    }
}

class Producer_consumer_problem {
    public static void main(String[] arg) {
        Buffer buffer = new Buffer(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        for (int i = 0; i < 3; i++) {
            new Thread(producer, "producer-" + i).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(consumer, "consumer-" + i).start();
        }
    }
}
