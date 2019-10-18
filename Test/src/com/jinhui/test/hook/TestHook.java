package com.jinhui.test.hook;
/**
 * 2017-8-24下午03:54:50
 * TestHook.java
 * author:liuyonghua
 */
public class TestHook {

	public static void main(String[] args) {
		ActionHook actionHook=new Http11Processor();
	      Response response=new Response();
	      response.setHook(actionHook);
	      response.action(ActionCode.COMMIT, null);
	     System.out.println("commit...");
	      response.action(ActionCode.CLOSE, null);
	      System.out.println("close...");
	}
	
	public enum ActionCode {
		CLOSE, COMMIT
	}
	
}
