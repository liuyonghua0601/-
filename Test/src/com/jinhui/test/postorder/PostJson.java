package com.jinhui.test.postorder;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.sf.json.JSONObject;


/**
 * 2016-9-27下午08:11:04
 * PostJson.java
 * author:liuyonghua
 */
public class PostJson {

	public static String post(String strURL, String params) {  
        try {  
        	strURL = strURL;
            URL url = new URL(strURL);// 创建连接  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 设置请求方式  
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式  
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.setRequestProperty("Accept-Encoding", "identity");
//            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();  
            
//            SSLContext sc = SSLContext.getInstance("SSL");
//			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
//					new java.security.SecureRandom());
//			URL console = new URL(strURL);
//			HttpsURLConnection connection = (HttpsURLConnection) console.openConnection();
//			connection.setSSLSocketFactory(sc.getSocketFactory());
//			connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
//			connection.setDoOutput(true);
//			connection.setRequestMethod("POST");
//			connection.connect();
			
            OutputStreamWriter out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
            out.append(params);  
            out.flush();  
            out.close();  
            // 读取响应  
            int length = (int) connection.getContentLength();// 获取长度  
            InputStream is = connection.getInputStream();
            //length = is.available();
//            if (length != -1) {  
//                byte[] data = new byte[length];  
//                byte[] temp = new byte[512];  
//                int readLen = 0;  
//                int destPos = 0;  
//                while ((readLen = is.read(temp)) > 0) {  
//                    System.arraycopy(temp, 0, data, destPos, readLen);  
//                    destPos += readLen;  
//                }  
//                String result = new String(data, "UTF-8"); // utf-8编码  
//                System.out.println(result);  
//                return result;  
//            }  
            try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buff = new byte[4096];
            int len;
            while((len = is.read(buff)) != -1){
                baos.write(buff, 0, len);
            }
            byte[] bytes = baos.toByteArray();
            is.close();
            String result = new String(bytes, "UTF-8"); // utf-8编码  
          System.out.println(result);  
          return result;  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "error"; // 自定义错误信息  
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
	
	private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        }};
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static   String https(String url, Map<String, String> params) throws Exception {
        // 构建请求参数
                String result = "";
                PrintWriter out = null;
                BufferedReader in = null;
                
                String sendString = "";
                JSONObject json = JSONObject.fromObject(params);
                System.out.println("发送报文:" + json.toString());
                sendString = json.toString();

                System.out.println("ERP连接:" + url);
                System.out.println("发送给ERP信息:" + sendString);
                 
                 try {
                     trustAllHosts();
                   // URL url2 = new URL(url);
                    URL url2= new URL(null, url, new sun.net.www.protocol.https.Handler());
                    HttpsURLConnection urlCon = (HttpsURLConnection) url2.openConnection();
                    urlCon.setHostnameVerifier(DO_NOT_VERIFY);
                    urlCon.setDoOutput(true);
                    urlCon.setDoInput(true);
                    urlCon.setRequestMethod("POST");
                    urlCon.setRequestProperty("Content-type", "application/json;charset=UTF-8");
                    // 发送POST请求必须设置如下两行
                    urlCon.setDoOutput(true);
                    urlCon.setDoInput(true);
                    // 获取URLConnection对象对应的输出流
                    OutputStream os = urlCon.getOutputStream(); 
                    //参数是键值队  , 不以"?"开始 
                    os.write(sendString.getBytes()); 
                    //os.write("googleTokenKey=&username=admin&password=5df5c29ae86331e1b5b526ad90d767e4".getBytes()); 
                    os.flush();
                    // 发送请求参数
                    //out.print(a);
                    // flush输出流的缓冲
                    //out.flush();
                    // 定义BufferedReader输入流来读取URL的响应
                    in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        result += line;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {// 使用finally块来关闭输出流、输入流
                    try {
                        if (out != null) {
                            out.close();
                        }
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                return result;
    }
	
}
