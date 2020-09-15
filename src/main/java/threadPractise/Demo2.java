package threadPractise;

import org.apache.tools.ant.taskdefs.Sync;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/09/16 0:13 <br>
 * @see threadPractise <br>
 */
public class Demo2 {
    static volatile Boolean flag = false;
    public static void main(String[] args) {
        char[] numChars = "123456".toCharArray();
        char[] letterChars = "ABCDEF".toCharArray();
        final Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    if (!flag) {
                        flag = true;
                        try {
                            o.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (char c : letterChars) {
                        System.out.print(c);

                        o.notify();
                        try {
                            o.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //不加这行程序不会退出(总会有个线程处于等待队列)
                    o.notify();
                }
            }
        }, "t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (char c : numChars) {
                        System.out.print(c);

                        o.notify();
                        try {
                            o.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //不加这行程序不会退出(总会有个线程处于等待队列)
                    o.notify();
                }
            }
        }, "t1").start();


    }
}
