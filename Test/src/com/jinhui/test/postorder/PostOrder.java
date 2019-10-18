package com.jinhui.test.postorder;

import java.io.FileInputStream;
import java.util.Properties;


/**
 * 2017-9-8上午09:39:35
 * PostOrder.java
 * author:liuyonghua
 */
public class PostOrder {

	public static void main(String[] args) {
		String webip = "";
		String webport = "";
		String weborder = "";
		//测试时用这个
		Properties m_props = new Properties();
		String urlpath = Thread.currentThread().getContextClassLoader()
		.getResource("").getPath().substring(1);
		
		if (urlpath.contains("%20")) {
			urlpath = urlpath.replaceAll("%20", " ");
		}
		String path = urlpath + "socketconfig.properties";
		//打包时用这个
		//String path = "socketconfig.properties";
		
		try {
			m_props.load(new FileInputStream(path));
			webip = m_props.getProperty("webip"); 
			webport = m_props.getProperty("webport"); 
			//weborder = m_props.getProperty("weborder");
			String rmethod = m_props.getProperty("rmethod");
			String types = m_props.getProperty("types");
			String action = m_props.getProperty("action");
			String speed = m_props.getProperty("speed");
			String positionX = m_props.getProperty("positionX");
			String positionY = m_props.getProperty("positionY");
			String angel = m_props.getProperty("angel");
			String distance = m_props.getProperty("distance");
			String user = m_props.getProperty("user");
			String password = m_props.getProperty("password");
			String robotuuid = m_props.getProperty("robotuuid");
			String times = m_props.getProperty("times");
			String zooms = m_props.getProperty("zooms");
			
			String taskuuid = m_props.getProperty("taskuuid");
			String tasktype = m_props.getProperty("tasktype");
			String taskname = m_props.getProperty("taskname");
			String autotasktype = m_props.getProperty("autotasktype");
			String autotime = m_props.getProperty("autotime");
			String isactive = m_props.getProperty("isactive");
			String seq = m_props.getProperty("seq");
			String pathdes = m_props.getProperty("pathdes");
			String createuser = m_props.getProperty("createuser");
			String createtime = m_props.getProperty("createtime");
			String remark = m_props.getProperty("remark");
			String stopids = m_props.getProperty("stopids");
			
			String position = m_props.getProperty("position");
			String pointuuid = m_props.getProperty("pointuuid");
			
			String switchs = m_props.getProperty("switchs");
			String filename = m_props.getProperty("filename");
			
			String doortype = m_props.getProperty("doortype");
			String dooruuid = m_props.getProperty("dooruuid");
			
			String jsonStu = "",method = "";
			if("1".equals(rmethod)){
				method = "/JhRobotServer/robotcontrl.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\",\"types\":\""+types+"\",\"action\":\""+action+"\",\"speed\":\""+speed+"\"" +
						",\"positionX\":\""+positionX+"\",\"positionY\":\""+positionY+"\",\"angel\":\""+angel+"\",\"distance\":\""+distance+"\"}";
			}else if("2".equals(rmethod)){
				method = "/JhRobotServer/taskctrl.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\",\"types\":\""+types+"\",\"uuid\":\""+taskuuid+"\",\"position\":\""+position+"\",\"pointuuid\":\""+pointuuid+"\"}";
			}else if("3".equals(rmethod)){
				method = "/JhRobotServer/getrobotstat.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\"}";
			}else if("4".equals(rmethod)){
				method = "/JhRobotServer/login.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\"}";
			}else if("5".equals(rmethod)){
				method = "/JhRobotServer/infrcameractrl.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\",\"types\":\""+types+"\",\"times\":\""+times+"\",\"zooms\":\""+zooms+"\",\"switchs\":\""+switchs+"\",\"filename\":\""+filename+"\"}";
			}else if("6".equals(rmethod)){
				method = "/JhRobotServer/ptzcontrol.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\",\"action\":\""+action+"\",\"speed\":\""+speed+"\"}";
			}else if("7".equals(rmethod)){
				method = "/JhRobotServer/taskedit.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\"," +
						"\"types\":\""+types+"\",\"tasktype\":\""+tasktype+"\"," +
						"\"uuid\":\""+taskuuid+"\",\"taskname\":\""+taskname+"\"," +
						"\"robotuuid\":\""+robotuuid+"\"," +
						"\"autotasktype\":\""+autotasktype+"\",\"autotime\":\""+autotime+"\"," +
						"\"isactive\":\""+isactive+"\",\"seq\":\""+seq+"\"," +
						"\"pathdes\":\""+pathdes+"\",\"createuser\":\""+createuser+"\"," +
						"\"createtime\":\""+createtime+"\",\"remark\":\""+remark+"\"," +
						"\"stopids\":"+stopids+"}";
			}else if("8".equals(rmethod)){
				method = "/JhRobotServer/cameractrl.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\",\"types\":\""+types+"\",\"times\":\""+times+"\",\"zooms\":\""+zooms+"\"}";
			}else if("9".equals(rmethod)){
				method = "/JhRobotServer/doorctrl.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\",\"type\":\""+types+"\",\"doortype\":\""+doortype+"\",\"dooruuid\":\""+dooruuid+"\"}";
			}else if("10".equals(rmethod)){
				method = "/JhRobotServer/alarmque.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\",\"robotuuid\":\""+robotuuid+"\",\"type\":\""+types+"\"}";
			}else if("11".equals(rmethod)){
				method = "/JhRobotServer/getrobotlist.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\"}";
			}else if("12".equals(rmethod)){
				method = "/JhRobotServer/getweatherinfo.jh";
				jsonStu = "{\"user\":\""+user+"\",\"password\":\""+password+"\"}";
			}
			String result = PostJson.post("http://"+webip+":"+webport+method, jsonStu.toString());
			//String result = PostJson.post("http://192.168.92.145:8088/JhRobotServer/ptzcontrol.jh", jsonStu.toString());
			//String result = PostJson.post("http://127.0.0.1:8088/socialFaceAuthAPI/heartbeatREQ.do", jsonStu.toString());
			System.out.println(result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
