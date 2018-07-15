package java_concurrent;

//类初始化延迟加载方法
public class InstanceFactory {

    private static class InstanceHolder{
        public static Instance instance = new Instance();
    }


    public static Instance getInstance() {
        return InstanceHolder.instance;
    }
}
