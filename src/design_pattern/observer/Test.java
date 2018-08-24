package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

//定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新

/*
    被观察者接口
 */
interface Observed {

    public void registerObserver(Observer o);

    public boolean removeObserver(Observer o);

    public void notifyObserver();
}

/*
    观察者接口
 */
interface Observer {
    public void update(String message);
}

class WechatServer implements Observed {

    private List<Observer> list;

    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public boolean removeObserver(Observer o) {
        return list.remove(o);
    }

    @Override
    public void notifyObserver() {

        for (Observer oserver : list) {
            oserver.update(message);
        }

    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息：" + s);
        notifyObserver();
    }
}

class User implements Observer {

    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + "收到推送消息：" + message);
    }

}

public class Test {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        Observer userZhang = new User("zhangsan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
    }
}