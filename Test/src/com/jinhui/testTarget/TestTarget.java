package com.jinhui.testTarget;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * 2018-5-31下午03:40:40
 * TestTarget.java
 * author:liuyonghua
 */
public class TestTarget {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(getProcessID());
        while(true) {
            Thread.sleep(10000);
        }
    }

    public static final int getProcessID() {  
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
       // System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])  
                .intValue();  
    } 

}

