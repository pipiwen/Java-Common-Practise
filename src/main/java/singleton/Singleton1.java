package singleton;

/**
 * 饿汉式（立即加载方式）
 */
public class Singleton1 {
    //私有化构造方法
    private Singleton1(){

    }
    private static Singleton1 instance=new Singleton1();
    public static Singleton1 getInstance(){
        return instance;
    }
}
