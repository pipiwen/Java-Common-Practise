package java8interface;

public interface MyInterFace {
    default String getName(String name){
        return name;
    }
    public static void show(){
        System.out.println("shaodiao");
    }
}
