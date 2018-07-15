package java_concurrent;

public class DoubleCheckedlocking {
    private volatile static Instance instance;

    public static Instance getInstance(){
        if(instance == null){
            synchronized(DoubleCheckedlocking.class){
                if(instance == null)
                    instance = new Instance();
            }
        }
        return instance;
    }
}

class Instance {}
