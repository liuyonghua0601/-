package com.jinhui.test.postpic;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author User
 *
 */
public class UrlUtils {
	
	
	public UrlUtils() {
	}

	/**URL验证***/
	public static String regularExpression(String url){
		if(url == null){
			return null;
		}
		Pattern p = Pattern.compile("^(http)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$",Pattern.CASE_INSENSITIVE );
		 Matcher m = p.matcher(url);
		 if(m.find()){
			 return url;
		 }else{
			 return null;
		 }
		
	}
	
	public static String UrlCorrected(String url){
		if(url==null) return null;
		
		url = url.replaceAll("\\\\", "/");
		
		if(!url.startsWith("http://") ){
			url = "http://"+url;
		}
		return url;
	}
	
	
	public static String getHost(String urlStr){
		try {
			URL url = new URL(urlStr);
			return url.getHost();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String getFirstHost(String urlStrs){
		if(urlStrs==null || "".equals(urlStrs)) return "";
		String[] urls = urlStrs.split("\n");
		if(urls!=null && urls.length>0)
			return getHost(urls[0]);
		return "";
	}
	
	
	public static boolean isIp(String ipStr){
	     String ipPattern="^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])(\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])){3}$";
	     try{
	    	 return Pattern.matches(ipPattern, ipStr);
	     }catch(Exception er){
	    	 er.printStackTrace();
	    	 return false;
	     }
	}
	
	public static void main(String[] args) {
		
//		ReportBean report	= new ReportBean();
//		report.setSiteurl("http://http://www.163.com/");
//		report.setPageurl("https://www.baidu.com/\r\nhttp://ws.xx.us/\r\nhttp://www.huaweisymantec.com/cn/About_Us/Contact_Us/\r\nhttp://www.huaweisymantec.com/cn/About_Us/Contact_Us/\r\nhttp://www.huaweisymantec.com/cn/About_Us/Contact_Us1/");
//		report.setReporttype(Constants.REPORTTYPE_COMMONSITE);
//		List[] lists	=	UrlUtils.AssemblyUrl(report);
//		for(int i=0;i<lists[0].size();i++){
//			System.out.println(lists[0].get(i));
//		}
//		System.out.println("---");
//		for(int i=0;i<lists[1].size();i++){
//			System.out.println(lists[1].get(i));
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(getUrl("http://www.heixiuhei.com/portal.php"));
//		}
		//测试时用这个
		Properties m_props = new Properties();
//		String urlpath = Thread.currentThread().getContextClassLoader()
//		.getResource("").getPath().substring(1);
//		
//		if (urlpath.contains("%20")) {
//			urlpath = urlpath.replaceAll("%20", " ");
//		}
//		String path = urlpath + "fileconfig.properties";
		//打包时用这个
		String path = "fileconfig.properties";
		String url = "";
		try {
			m_props.load(new FileInputStream(path));
			url = m_props.getProperty("url"); 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String[] uarr = url.split(",");
		for (int i = 0; i < uarr.length; i++) {
			ReportBean report = new ReportBean();
			report.setPageurl(uarr[i]);
			report.setReporttype(0);
			AssemblyUrl(report);
		}
	}
	
	/**
	 * 组装url，返回url集合
	 * @param task
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static synchronized List[] AssemblyUrl(ReportBean report) {
		
		List[] lists	=	new List[2];
		lists[0] = new ArrayList();//存储未判定状态的URL
		lists[1] = new ArrayList();//存储未判定能成功访问状态的URL	
		
	
		
		System.out.println("开始装配URL,Name="+Thread.currentThread().getName());
		
		if (null != report) {
			int reporttype=report.getReporttype()==null?0:report.getReporttype();
			if (reporttype != 2 && reporttype != 6 && reporttype != 7) {
				String urltmp = report.getPageurl();
				String siteUrl = report.getSiteurl()==null?"":report.getSiteurl().trim();
//				if(urltmp == null) urltmp = "http://null";
//				if(siteUrl == null) siteUrl = "http://null";
				if(urltmp == null) urltmp = "";
				if(siteUrl !=null || !"".equals(siteUrl)){
					if(!urltmp.contains(siteUrl)){
						urltmp = urltmp +"\r\n" +siteUrl;
						System.out.println("装配获取URL :  "+urltmp+",举报编号="+report.getId());
					 }
				}
				System.out.println("-----urltmp="+urltmp);
				if(urltmp != null && !"".equals(urltmp)){
				
					/**取出举报录入的URL***/
					String urlArr[] = urltmp.split("\r\n");
					/**转成LIST**存储所有预处理的URL**/
					if(urlArr!=null){
						for(int i=0;i<urlArr.length;i++){
							String url =	urlArr[i];
							if(!lists[0].contains(url)) lists[0].add(url);
							if(!lists[1].contains(url)){
								url=urlFileter(url);
								String str = UrlUtils.getUrl(url);
								if(str != null) lists[1].add(str);
							}
						}
					}
				}
				
			}
			System.out.println("完成装配URL,所有URL数="+lists[0].size()+"，能访问的URL数="+lists[1].size()+",Name="+Thread.currentThread().getName());

		}else
			System.out.println("装配URL错误,未找到对应的Report对象,name="+Thread.currentThread().getName());
		
		
		
		//return list_unique(urlList);
		return lists;

	}
	
	
//	public class TrustAnyHostnameVerifier implements HostnameVerifier {
//        public boolean verify(String hostname, SSLSession session) {
//            // 直接返回true
//            return true;
//        }
//	}
	public static String getUrl(String url){
		HttpURLConnection  connection = null;
		try{
			System.out.println("---url="+url+"---geturl");
			if(url.startsWith("https://")){
				return getUrlHttps(url);
			}
		  URL urls = new URL(url);
		  
		  connection = (HttpURLConnection) urls.openConnection();
		  connection.setConnectTimeout(30000);//30秒超时
		  connection.setReadTimeout(30000);//read超时
		  connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		  int   state = connection.getResponseCode();
		  System.out.println("---url="+url+"---state="+state);
		  if(!String.valueOf(state).contains("404")){
			  return url;
		  }else{
			  return null;
		  }
		} catch (ConnectException e) {
			e.printStackTrace();
			String em = e.getMessage();
			if(em!=null&&(em.contains("Software caused connection abort")||em.contains("Connection reset"))){
				return url;
			}else{
				return getUrlSecond(url);
			}
		} catch (SocketTimeoutException e) {
			// TODO: handle exception
			e.printStackTrace();
			return getUrlSecond(url);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(connection!=null)
			connection.disconnect();
		}
	}
	/**
	 * 二次判断url有效性
	 * @param url
	 * @return
	 */
	public static String getUrlSecond(String url){
		HttpURLConnection  connection = null;
		try{
			System.out.println("---url="+url+"---getUrlSecond");
		  URL urls = new URL(url);
		  
		  connection = (HttpURLConnection) urls.openConnection();
		  connection.setConnectTimeout(30000);//30秒超时
		  connection.setReadTimeout(30000);//read超时
		  connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		  int   state = connection.getResponseCode();
		  System.out.println("---url="+url+"---state="+state+"---getUrlSecond");
		  if(!String.valueOf(state).contains("404")){
			  return url;
		  }else{
			  return null;
		  }
		} catch (ConnectException e) {
			e.printStackTrace();
//			String em = e.getMessage();
//			if(em!=null&&(em.contains("Software caused connection abort")||em.contains("Connection reset"))){
				return url;
//			}else{
//				return null;
//			}
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(connection!=null)
			connection.disconnect();
		}
	}
	private static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	public static String getUrlHttps(String url){
		HttpsURLConnection conn = null;
		try{
			 System.out.println("---url="+url+"---getUrlHttps");
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
					new java.security.SecureRandom());

			URL console = new URL(url);
			conn = (HttpsURLConnection) console.openConnection();
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.setDoOutput(true);
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			conn.connect();
		  int   state = conn.getResponseCode();
		  System.out.println("---url="+url+"---getUrlHttps---state="+state);
		  if(!String.valueOf(state).contains("404")){
			  return url;
		  }else{
			  return null;
		  }
		} catch (ConnectException e) {
			e.printStackTrace();
			String em = e.getMessage();
			if(em!=null&&(em.contains("Software caused connection abort")||em.contains("Connection reset"))){
				return url;
			}else{
				return getUrlHttpsSecond(url);
			}
		} catch (SocketTimeoutException e) {
			// TODO: handle exception
			e.printStackTrace();
			return getUrlHttpsSecond(url);
		} catch (Exception e) {
			e.printStackTrace();
			HttpsURLConnection connection = null;
			try {
				URL urls = new URL(url);
				 connection=(HttpsURLConnection)urls.openConnection();
				  connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
//			      connection.connect();
				  connection.setConnectTimeout(30000);//30秒超时
				  connection.setReadTimeout(30000);//read超时
				  connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				  int   state = connection.getResponseCode();
				  if(!String.valueOf(state).contains("404")){
					  return url;
				  }else{
					  return null;
				  }
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				System.out.println("--url="+url+"--异常--"+e2.getMessage());
			}finally{
				if(connection!=null)connection.disconnect();
			}
			return null;
		}finally{
			if(conn!=null)conn.disconnect();
		}
	}
	public static String getUrlHttpsSecond(String url){
		HttpsURLConnection conn = null;
		try{
			 System.out.println("---url="+url+"---getUrlHttpsSecond");
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
					new java.security.SecureRandom());

			URL console = new URL(url);
			conn = (HttpsURLConnection) console.openConnection();
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.setDoOutput(true);
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			conn.connect();
		  int state = conn.getResponseCode();
		  System.out.println("---url="+url+"---getUrlHttpsSecond---state="+state);
		  if(!String.valueOf(state).contains("404")){
			  return url;
		  }else{
			  return null;
		  }
		} catch (ConnectException e) {
			e.printStackTrace();
//			String em = e.getMessage();
//			if(em!=null&&(em.contains("Software caused connection abort")||em.contains("Connection reset"))){
				return url;
//			}else{
//				return null;
//			}
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(conn!=null)conn.disconnect();
		}
	}
	/**
	 * 多个http://容错
	 * @param url
	 * @return
	 */
	public static String urlFileter(String url){
		if(url!=null&&!"".equals(url)){
			if(url.startsWith("http://http://")){
				url = url.replaceAll("http://", "");
				url = "http://"+url;
			}else if(url.startsWith("https://https://")){
				url = url.replace("https://", "");
				url = "https://"+url;
			}else if(url.startsWith("http://https://")){
				url = url.replaceAll("http://", "");
				url = url.replace("https://", "");
				url = "https://"+url;
			}
		}
		return url;
	}
	
	public static int getresCode(String url){
		int   state = -1;
		try {
			URL hp = new URL(url);
			HttpURLConnection  connection = (HttpURLConnection) hp.openConnection();
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(10000);
			state = connection.getResponseCode();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return state;
	}

}
