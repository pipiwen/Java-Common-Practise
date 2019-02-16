package staticproxy;

public class PersonProxy implements Human{
    private Person p;
    public PersonProxy(Person p){
        this.p=p;
    }
    public void eat() {
        p.eat();
        try {
            Thread.sleep(1000);
            System.out.println("吃饱了！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep() {
        p.sleep();
        try {
            Thread.sleep(2000);
            System.out.println("睡醒了！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
