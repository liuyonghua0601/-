package com.jinhui.test;
/**
 * 2017-3-28下午05:21:53
 * TestPK.java
 * author:liuyonghua
 */
public class TestPK {

	public static void main(String[] args) {
		/*double a=5l;
		for (int i = 0; i < 25; i++) {
			a=(float) (a*1.7);
			a=Math.floor(a*10)/10;
			System.out.println(a);
		}*/
		
		/*String str = "   abc   bcv  \r\n sss  ddd  ";
		System.out.println(str.trim());*/
		String speedX = "00.209"; 
		speedX = "00-0.0";
		int num = speedX.indexOf(".");
		if(speedX.contains("-")){
			speedX = speedX.substring(num-2,speedX.length());
		}else{
			speedX = speedX.substring(num-1,speedX.length());
		}
		System.out.println(speedX);
	}
}
