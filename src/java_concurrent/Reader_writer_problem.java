package java_concurrent;

import java.util.concurrent.Semaphore;

/*Semaphore信号量上有两种操作： acquire（获取） 和 release（释放）
Semaphore类表示信号量 Semaphore内部主要通过AQS（AbstractQueuedSynchronizer）实现线程的管理。
Semaphore构造函数，参数permits表示许可数，它最后传递给了AQS的state值。
线程在运行时首先获取许可，如果成功，许可数就减1，线程运行，当线程运行结束就释放许可，许可数就加1。
如果许可数为0，则获取失败，线程位于AQS的等待队列中，它会被其它释放许可的线程唤醒。*/
public class Reader_writer_problem {
    public static void main(String[] args) {
        Semaphore wmutex = new Semaphore(1);
        Semaphore rmutex = new Semaphore(1);
        for (int i = 0; i != 20; ++i) {
            new Thread(new Reader(rmutex, wmutex)).start();
        }
        for (int i = 0; i != 10; ++i) {
            new Thread(new Writer(wmutex)).start();
        }
    }
}

class Reader implements Runnable {
    private static int total = 0;
    private int id;
    private Semaphore rmutex, wmutex;
    private static int readCount = 0;

    public Reader(Semaphore rmutex, Semaphore wmutex) {
        id = ++total;
        this.rmutex = rmutex;
        this.wmutex = wmutex;
    }

    @Override
    public void run() {
        try {
            if (readCount == 0) {
                wmutex.acquire();
            }
            rmutex.acquire();
            readCount++;
            rmutex.release();
            System.out.println(id + "num reader is reading");
            Thread.sleep(100);
            rmutex.acquire();
            readCount--;
            rmutex.release();
            //执行读操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (readCount == 0) {
                wmutex.release();
            }
        }

        System.out.println(id + "num reader finished reading current have " + readCount + " reader is reading");
    }
}

class Writer implements Runnable {
    private static int total = 0;
    private int id;
    private Semaphore wmutex;

    public Writer(Semaphore wmutex) {
        id = ++total;
        this.wmutex = wmutex;
    }

    @Override
    public void run() {
        try {
            wmutex.acquire();
            // 执行写操作
            System.out.println(id + "num writer is writing");
            Thread.sleep(100);
            wmutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
