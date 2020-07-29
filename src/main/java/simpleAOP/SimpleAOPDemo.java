package simpleAOP;

import simpleAOP.container.SimpleContainer;
import simpleAOP.service.ServiceA;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/07/24 16:49 <br>
 * @see simpleAOP <br>
 */
public class SimpleAOPDemo {
    public static void main(String[] args) {
        //启动容器
        ServiceA serviceA = SimpleContainer.getInstance(ServiceA.class);
        serviceA.callB();
    }
}
