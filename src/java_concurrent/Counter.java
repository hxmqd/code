package java_concurrent;

import java.util.concurrent.atomic.AtomicInteger;
//原子类
public class Counter  {

   public static void main(String[] args) throws InterruptedException {
       Task task = new Task();
       Thread[] threads = new Thread[20];
       for (int i=0;i<20;i++){
           threads[i] = new Thread(task);
           threads[i].start();
       }

       for (int j=0;j<20;j++){
           threads[j].join();
       }
       System.out.print("count:"+task.count);
   }
}

class Task implements Runnable {

public  AtomicInteger  count = new AtomicInteger();


@Override
public void run() {

        try {
        Thread.sleep(100);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        count.incrementAndGet();

        }
}


