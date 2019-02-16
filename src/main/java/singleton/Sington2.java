package singleton;

/**
 * 懒汉式（线程安全）
 */
public class Sington2 {
    //私有化构造方法
    private Sington2(){}
    private static Sington2 instance=null;//创建单列引用
    public static Sington2 getInstance(){
        if(instance==null){
            synchronized (Sington2.class){
                if(instance==null){
                    instance=new Sington2();
                }
            }
        }
        return instance;
    }
}
