package java_concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock由最后成功获得但尚未释放锁的线程拥有，线程调用锁将返回，成功获取锁
// 如果当前线程已拥有该锁，则lock()方法将立即返回
public class ThreadLocalTest {


    public static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
        protected Object initialValue() {
            //调用get方法时，若当前线程共享变量没有设置，调用initialValue获取默认值
            System.out.println(Thread.currentThread().getName()+" invoke initialValue");
            return null;
        }

    };

    private final ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        ReentrantLockTask task = new ReentrantLockTask();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();



    }
}



    class ReentrantLockTask implements Runnable {


        @Override
        public void run() {
         for (int i = 0; i < 5; i++) {
                if (null == ThreadLocalTest.threadLocal.get()) {
                    ThreadLocalTest.threadLocal.set(0);
                } else {
                    int num = (Integer) ThreadLocalTest.threadLocal.get();
                    ThreadLocalTest.threadLocal.set(num + 1);
                    System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalTest.threadLocal.get());
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
