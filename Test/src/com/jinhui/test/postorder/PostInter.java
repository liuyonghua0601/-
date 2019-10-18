/**  
 * @Title: PostInter.java
 * @Package com.jinhui.test.postorder
 * @Description: TODO
 * @author liuyh
 * @date 2019年7月12日
 */
package com.jinhui.test.postorder;


import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**  
 * @Title: PostInter.java
 * @Package com.jinhui.test.postorder
 * @Description: TODO
 * @author liuyh
 * @date 2019年7月12日上午9:32:28
 */
public class PostInter {

	public static void main(String[] args) {
		//test();
		testhttps();
	}
	
	public static void test(){
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("method", "enterquery");
        jsonObject.put("token", "xiyangyang");
        jsonObject.put("name", "");
        String result = PostJson.post("https://sslaq2.aqiansoftware.cn/miniProgramService/visitor", jsonObject.toString());
        System.out.println(result);
	}
	
	public static void testhttps(){
		String url = "https://sslaq2.aqiansoftware.cn/miniProgramService/visitor";
		Map<String,String> pmap = new HashMap<String, String>();
		pmap.put("method", "staffregister");
		pmap.put("token", "xiyangyang");
//		pmap.put("name", "李乐乐");
//		pmap.put("enterprise", "002");
//		pmap.put("tel", "123456");
		pmap.put("entercode", "002");
		pmap.put("starttime", "2019-06-26 19:02:32");
		pmap.put("endtime", "2019-06-30 19:02:32");
		try {
			String result = PostJson.https(url, pmap);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
