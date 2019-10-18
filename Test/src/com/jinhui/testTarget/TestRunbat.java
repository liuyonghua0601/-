package com.jinhui.testTarget;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * 2018-6-1下午04:57:15
 * TestRunbat.java
 * author:liuyonghua
 */
public class TestRunbat {

	public static void main(String[] args) {
		try {
			String command = "cmd /c C: && cd C:/Users/dell/Desktop/JHRobotCON && start run.bat";
			//String command = "cmd /c C:/Users/dell/Desktop/JHRobotCON/run.bat ";
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(command);
			//System.out.println(p.waitFor());
			//System.out.println(getProcessID());
//			Process p2 = r.exec("run.bat");
//			System.out.println(p2.waitFor());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static final int getProcessID() {  
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
       // System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])  
                .intValue();  
    } 
}
