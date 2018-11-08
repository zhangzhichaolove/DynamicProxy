package com.peak.chao.all;

public class InterFaceTest {

    public static void main(String[] args) {
        //相当于创造一个实现MyInterFace接口的类，然后调用print()方法
        //这些匿名类也只是实现了这些接口，并且必须覆写接口的中的方法。
        //总而言之 ，接口是不能实例化的，因为接口中只有方法名称，没有方法体，所以没办法实例化
        //对于一些实现了接口的内部匿名类，虽然表面形式是接口被new 出来了，但是不要被表象迷惑了，其本质只是一个 实现了某种接口的类
        MyInterFace myInterFace = new MyInterFace() {
            @Override
            public void print(String str) {
                System.err.println("输出内容：" + str);
            }
        };
        myInterFace.print("Hello");
    }

    public interface MyInterFace {
        void print(String str);
    }
}
