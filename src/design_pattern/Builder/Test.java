package design_pattern.Builder;

import java.util.ArrayList;

import java.util.List;

/**
 * 1. 指挥者（Director）直接和客户（Client）进行需求沟通；
 * 2. 沟通后指挥者将客户创建产品的需求划分为各个部件的建造请求（Builder）；
 * 3. 将各个部件的建造请求委派到具体的建造者（ConcreteBuilder）；
 * 4. 各个具体建造者负责进行产品部件的构建；
 * 5. 最终构建成具体产品（Product）。
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        //装机人员去装电脑
        director.construct(builder);
        Computer computer = builder.getComputer();
        computer.show();
    }
}

//定义组装的过程（Builder）：组装电脑的过程
abstract class Builder {
    public abstract void buildCPU();

    public abstract void buildMainboard();

    public abstract void buildHD();

    public abstract Computer getComputer();
}

//委派任务给装机人员（Director）
class Director {
    //装机人员组装电脑
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainboard();
        builder.buildHD();
    }
}

//创建具体的建造者（ConcreteBuilder）:装机人员
class ConcreteBuilder extends Builder {
    //创建产品实例
    Computer computer = new Computer();

    //组装产品
    @Override
    public void buildCPU() {
        computer.add("组装CPU");
    }

    @Override
    public void buildMainboard() {
        computer.add("组装主板");
    }

    @Override
    public void buildHD() {
        computer.add("组装主板");
    }

    //返回组装成功的电脑
    @Override
    public Computer getComputer() {
        return computer;
    }

}

// 定义具体产品类（Product）：电脑
class Computer {
    private List<String> parts;

    public Computer() {
        parts = new ArrayList<>();
    }

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件" + parts.get(i) + "装好了");
        }
        System.out.println("电脑组装完成，请验收");
    }
}
