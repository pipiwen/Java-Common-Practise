package threadPractise;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/09/15 22:50 <br>
 * @see threadPractise <br>
 */
public class Demo1 {
    enum ThreadToRun { T1, T2 };
    //一定要加volatile保证内存可见性
    static volatile ThreadToRun currentRun = ThreadToRun.T1;
    //使用自旋锁交替输出1A2B3C....
    public static void main(String[] args) {
        char[] numChars = "123456".toCharArray();
        char[] leterChars = "ABCDEF".toCharArray();
        //第一个线程输出数字
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : numChars) {
                    while (currentRun != ThreadToRun.T1) {};
                    System.out.println(c);
                    currentRun = ThreadToRun.T2;
                }
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : leterChars) {
                    while (currentRun != ThreadToRun.T2) {}
                    System.out.println(c);
                    currentRun = ThreadToRun.T1;
                }
            }
        }, "t2").start();
    }
}
