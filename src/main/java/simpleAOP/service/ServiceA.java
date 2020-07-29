package simpleAOP.service;

import date20200716annotation.SimpleInject;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/07/16 18:24 <br>
 * @see date20200716annotation <br>
 */
public class ServiceA {
    @SimpleInject
    public ServiceB serviceB;
    public void callB () {
        serviceB.action();
    }

}
