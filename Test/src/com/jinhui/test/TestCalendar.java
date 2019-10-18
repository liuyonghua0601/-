package com.jinhui.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 2018-8-8下午05:07:36
 * TestCalendar.java
 * author:liuyonghua
 */
public class TestCalendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		/*将日历日期推后1天*/
	    cal.add(cal.DATE,-7);
		/*获取一周七天的值*/
		    /*获取当前日历的日期的星期数（1:星期天）*/
		    Date date=cal.getTime(); 
		    /*日期格式化 yyyy-MM-dd M必须大写*/
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String dateString = formatter.format(date);
		    System.out.println(dateString);

		    
	}
}
