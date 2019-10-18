/**  
 * @Title: TestJudgeIp.java
 * @Package com.jinhui.test.tcp
 * @Description: TODO
 * @author liuyh
 * @date 2019年5月21日
 */
package com.jinhui.test.tcp;

import sun.net.util.IPAddressUtil;

/**  
 * @Title: TestJudgeIp.java
 * @Package com.jinhui.test.tcp
 * @Description: TODO
 * @author liuyh
 * @date 2019年5月21日下午4:50:29
 */
public class TestJudgeIp {

	public static void main(String[] args) {
		System.out.println(internalIp("192.168.81.167"));
		System.out.println(internalIp("111.204.170.175"));
	}
	public static boolean internalIp(String ip) {
	    byte[] addr = IPAddressUtil.textToNumericFormatV4(ip);
	    return internalIp(addr);
	}


	public static boolean internalIp(byte[] addr) {
	    final byte b0 = addr[0];
	    final byte b1 = addr[1];
	    //10.x.x.x/8
	    final byte SECTION_1 = 0x0A;
	    //172.16.x.x/12
	    final byte SECTION_2 = (byte) 0xAC;
	    final byte SECTION_3 = (byte) 0x10;
	    final byte SECTION_4 = (byte) 0x1F;
	    //192.168.x.x/16
	    final byte SECTION_5 = (byte) 0xC0;
	    final byte SECTION_6 = (byte) 0xA8;
	    switch (b0) {
	        case SECTION_1:
	            return true;
	        case SECTION_2:
	            if (b1 >= SECTION_3 && b1 <= SECTION_4) {
	                return true;
	            }
	        case SECTION_5:
	            switch (b1) {
	                case SECTION_6:
	                    return true;
	            }
	        default:
	            return false;

	    }
	}
}
