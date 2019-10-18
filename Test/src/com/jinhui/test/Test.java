package com.jinhui.test;

import java.awt.image.RescaleOp;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 2017-7-10下午02:12:17
 * Test.java
 * author:liuyonghua
 */
public class Test {

	public static void main(String[] args) {
		/*Calendar calendar = Calendar.getInstance();
		calendar.add(calendar.MONTH, -1);
		int month = calendar.get(calendar.MONTH)+1;
		int year = calendar.get(calendar.YEAR);
		System.out.println(month);
		System.out.println(year);
		
		String[] a={"a","b","c"};
		String[] b=new String[5];
		System.out.println(a[0]);
		System.out.println(b[0]);
		a[0]="d";
		System.out.println(a[0]);
		System.out.println(b[0]);*/
		/*System.out.println("------------helloword----");
		String result = StringUtils.leftPad("E", 100000, " ");
		System.out.println(result.length());
		System.out.println(UUID.randomUUID());*/
		/*float ptz_x = 360;
    	int intx=(int)(ptz_x*100);
    	String devIdStr = Integer.toHexString(intx);
    	devIdStr = StringUtils.leftPad(devIdStr, 4, "0");
    	String jd1 = devIdStr.substring(0,2);
    	String jd2 = devIdStr.substring(2);
		byte devBin1 = (byte) Integer.parseInt(jd1, 16);
		byte devBin2 = (byte) Integer.parseInt(jd2, 16);
		System.out.println(devBin1+"--"+devBin2);*/
		
		/*String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		System.err.println(uuid);
		int speed = -5;
		String ispeed = ((float)(Math.PI/180)*speed)+"";
		System.out.println(ispeed);
		if(ispeed.length()>6){
			ispeed = ispeed.substring(0,6);
		}else{
			ispeed = StringUtils.rightPad(ispeed, 6, "0");
		}
		ispeed = StringUtils.leftPad(ispeed, 24, "0");
		System.out.println(ispeed);*/
		/*URL url;
		try {
			url = new URL("http://www.sina.com.cn");
			System.out.println(url.getHost());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println(Long.valueOf("1"));
		/*byte[] r = new byte[5];
		r[0]=(byte)0xff;
		r[1]=(byte)0x03;
		r[2]=(byte)0x04;
		r[3]=(byte)0x0F;
		r[4]=(byte)0x01;
		System.out.println(r[0]&2);
		System.out.println(r[1]&2);
		System.out.println(r[2]&2);
		System.out.println(r[3]&2);
		System.out.println(r[4]&2);*/
		/*int i = 140;
		System.out.println((byte)i);*/
		byte[] ttypes = new byte[16];
		
		Map rmap = new HashMap<String, Object>();
		Map tempmap = new HashMap<String, Object>();
		
		ttypes[8] = (byte)0x0E;
		ttypes[9] = (byte)0xA0;
		int a= ttypes[8] & 0xff;
		int b= ttypes[9] & 0xff;
		float avg = (a*(256)+b)/100f;
		tempmap.put("avg", avg);
		
		ttypes[10] = (byte)0x0E;
		ttypes[11] = (byte)0xD9;
		int c= ttypes[10] & 0xff;
		int d= ttypes[11] & 0xff;
		float max = (c*(256)+d)/100f;
		tempmap.put("max", max);
		
		ttypes[12] = (byte)0x0E;
		ttypes[13] = (byte)0x93;
		int e= ttypes[12] & 0xff;
		int f= ttypes[13] & 0xff;
		float min = (e*(256)+f)/100f;
		tempmap.put("min", min);
		rmap.put("resultcode", 0);
		rmap.put("tempdata", tempmap);
		
		String result = JSONObject.fromObject(rmap).toString();
		System.out.println(result);
	}
}
