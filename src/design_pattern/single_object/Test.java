package design_pattern.single_object;

/*这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。
  这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象
 */
public class Test {
    public static void main(String[] args) {
        Singleton5.getSingleton();
    }
}

// 1、懒汉式，线程不安全
class Singleton1 {

    private static Singleton1 instance;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

// 2、懒汉式，线程安全
// 优点：第一次调用才初始化，避免内存浪费
// 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
class Singleton2 {
    private static Singleton2 instance;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

// 3、饿汉式 线程安全
// 基于 classloder 机制避免了多线程的同步问题,instance 在类装载时就实例化,没有达到 lazy loading 的效果
class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    public static Singleton3 getInstance() {
        return instance;
    }
}

//双检锁/双重校验锁（DCL，即 double-checked locking）
// java并发编程的艺术 68页 ,使用 volatile禁止创建对象重排序
class Singleton4 {
    private volatile static Singleton4 singleton;

    public static Singleton4 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
}

//登记式/静态内部类
class Singleton5 {

    private static class SingletonHolder {
        public static Singleton5 instance = new Singleton5();
    }


    public static Singleton5 getSingleton() {
        return SingletonHolder.instance;
    }
}