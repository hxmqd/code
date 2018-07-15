package java_concurrent;

import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_pt_BR;

import java.util.concurrent.Semaphore;

public class Reader_writer_problem {
    public static void main(String[] args) {
        Semaphore wmutex = new Semaphore(1);
        Semaphore rmutex = new Semaphore(1);
        for (int i = 0; i != 5; ++i) {
            new Thread(new Writer(wmutex)).start();
            new Thread(new Reader(rmutex, wmutex)).start();
        }
    }
}

class Reader implements Runnable{
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
        while(true){
            try {
                rmutex.acquire();
                if(readCount == 0){
                    wmutex.acquire();
                }
                readCount ++;
                rmutex.release();
                //执行读操作
                System.out.println(id+"num reader is reading");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rmutex.release();
            readCount--;
            if (readCount == 0) {
                wmutex.release();
            }
            System.out.println(id+"num reader over read, current have "+ readCount+"reader is reading");
        }
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
        while (true) {
            try {
                wmutex.acquire();
                // 执行写操作
                System.out.println(id + "num writer is writing");
                wmutex.release();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
