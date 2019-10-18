package com.jinhui.test.tcp;
/**
 * 2017-12-1下午03:42:21
 * tcpmodbus.java
 * author:liuyonghua
 */
import java.util.Date;  
  
import com.serotonin.modbus4j.ModbusFactory;  
import com.serotonin.modbus4j.ModbusLocator;
import com.serotonin.modbus4j.ModbusMaster;  
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.serotonin.modbus4j.exception.ModbusInitException;  
import com.serotonin.modbus4j.exception.ModbusTransportException;  
import com.serotonin.modbus4j.ip.IpParameters;  
import com.serotonin.modbus4j.msg.ModbusRequest;  
import com.serotonin.modbus4j.msg.ModbusResponse;  
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;  
import com.serotonin.modbus4j.msg.WriteRegistersRequest;  
import com.serotonin.modbus4j.msg.WriteRegistersResponse;  
import com.serotonin.util.queue.ByteQueue;   
public class tcpmodbus {  
    public static void modbusWTCP(String ip, int port, int slaveId, int start, short[] values) {  
        ModbusFactory modbusFactory = new ModbusFactory();  
        // 设备ModbusTCP的Ip与端口，如果不设定端口则默认为502  
        IpParameters params = new IpParameters();  
        params.setHost(ip);  
        if (502 != port) {  
            params.setPort(port);  
        }// 设置端口，默认502  
        ModbusMaster tcpMaster = null;  
        // 参数1：IP和端口信息 参数2：保持连接激活  
        tcpMaster = modbusFactory.createTcpMaster(params, true);  
        try {  
            tcpMaster.init();  
            System.out.println("===============" + 1111111);  
        } catch (ModbusInitException e) {  
            // System.out.println("11111111111111=="+"此处出现问题了啊!");  
            // 如果出现了通信异常信息，则保存到数据库中  
             //CommunityExceptionRecord cer = new CommunityExceptionRecord();  
            //cer.setDate(new Date());  
            //cer.setIp(ip);  
            // cer.setRemark(bgName+"出现连接异常");  
            // batteryGroupRecordService.saveCommunityException(cer);  
        }  
        try {  
            WriteRegistersRequest request = new WriteRegistersRequest(slaveId, start, values);  
            WriteRegistersResponse response = (WriteRegistersResponse) tcpMaster.send(request);  
            if (response.isException())  
                System.out.println("Exception response: message=" + response.getExceptionMessage());  
            else  
                System.out.println("Success");  
        } catch (ModbusTransportException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static ByteQueue modbusTCP(String ip, int port, int start,int readLenth) {  
        ModbusFactory modbusFactory = new ModbusFactory();  
        // 设备ModbusTCP的Ip与端口，如果不设定端口则默认为502  
        IpParameters params = new IpParameters();  
        params.setHost(ip);  
        if(502!=port){params.setPort(port);}//设置端口，默认502  
        ModbusMaster tcpMaster = null;  
            tcpMaster = modbusFactory.createTcpMaster(params, true);  
            try {  
                tcpMaster.init();
                System.out.println("==============="+1111111);  
            } catch (ModbusInitException e) {  
                return null;  
            }  
           /* ModbusRequest modbusRequest=null;  
            try {  
                modbusRequest = new ReadHoldingRegistersRequest(1, start, readLenth);//功能码03
            } catch (ModbusTransportException e) {  
                e.printStackTrace();  
            }  
            ModbusResponse modbusResponse=null;  
            try {  
            	//tcpMaster.
                modbusResponse = tcpMaster.send(modbusRequest); 
            } catch (ModbusTransportException e) {  
                e.printStackTrace();  
            }  
            ByteQueue byteQueue= new ByteQueue(36);  
            modbusResponse.write(byteQueue);  
            System.out.println("功能码:"+modbusRequest.getFunctionCode());  
            System.out.println("从站地址:"+modbusRequest.getSlaveId());  
            System.out.println("收到的响应信息大小:"+byteQueue.size());  
            System.out.println("收到的响应信息值:"+byteQueue);  
            return byteQueue;  */
            ModbusLocator locator = new ModbusLocator(1,
                    02, 0,
                    DataType.TWO_BYTE_INT_UNSIGNED);

            Object xx = null;
            try {
                xx = tcpMaster.getValue(locator);
            }catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
            return null;
    }  
    
    public static void main(String[] args) {
		modbusTCP("192.168.127.254", 502, 0, 3);
	}
}  
