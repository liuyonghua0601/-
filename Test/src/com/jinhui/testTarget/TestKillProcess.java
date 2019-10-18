package com.jinhui.testTarget;

import java.io.IOException;

/**
 * 2018-5-31下午03:46:59
 * TestKillProcess.java
 * author:liuyonghua
 */
public class TestKillProcess {

	public static void main(String[] args) {
		String command = "taskkill /pid 16548 /f";
		Runtime r = Runtime.getRuntime();
		try {
			Thread.sleep(3000);
			Process p = Runtime.getRuntime().exec(command);
			System.out.println(p.waitFor());
			System.out.println(p.exitValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			command = "cmd /c cd C:/Users/dell/Desktop/JHRobotCON && C: && start run.bat";
			//String command = "cmd /c C:/Users/dell/Desktop/JHRobotCON/run.bat ";
			Process p = r.exec(command);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
