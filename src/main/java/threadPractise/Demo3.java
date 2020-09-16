package threadPractise;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/09/16 0:13 <br>
 * @see threadPractise <br>
 */
public class Demo3 {
    enum ThreadToRun { T1, T2, T3 };
    private static volatile ThreadToRun currentRun = ThreadToRun.T1;
    public static void main(String[] args) {
        final Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {

                    for (int i = 0; i < 10; i++) {
                        while (currentRun == ThreadToRun.T2 || currentRun == ThreadToRun.T3) {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("A");
                        currentRun = ThreadToRun.T2;
                        o.notifyAll();
                    }
                }
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {

                    for (int i = 0; i < 10; i++) {
                        while (currentRun == ThreadToRun.T1 || currentRun == ThreadToRun.T3) {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        currentRun = ThreadToRun.T3;
                        o.notifyAll();
                    }
                }
            }
        }, "t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (int i = 0; i < 10; i++) {
                        while (currentRun == ThreadToRun.T2 || currentRun == ThreadToRun.T1) {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        currentRun = ThreadToRun.T1;
                        o.notifyAll();
                    }
                }
            }
        }, "t3").start();
    }
}
