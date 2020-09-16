package threadPractise;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/09/16 20:05 <br>
 * @see threadPractise <br>
 */
public class Test222 {
    static int index = 1;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        while (index % 3 != 1) {
                            try {
                                lock.wait();
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("A");
                        index++;
                        lock.notifyAll();
                    }
                }
            }
        }, "t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        while (index % 3 != 2) {
                            try {
                                lock.wait();
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        index++;
                        lock.notifyAll();
                    }
                }
            }
        }, "t3").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        while (index % 3 != 0) {
                            try {
                                lock.wait();
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        index++;
                        lock.notifyAll();
                    }
                }
            }
        }, "t3").start();

    }
}
