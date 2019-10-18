package com.jinhui.test.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import com.jinhui.utils.temputil;

/**
 * 2017-6-15上午11:38:54
 * AesUtilTools.java
 * author:liuyonghua
 */
public class AesUtilTools extends JFrame implements ActionListener{

	GridBagLayout g=new GridBagLayout();
	GridBagConstraints c=new GridBagConstraints();
	AesUtilTools(String str){
		super(str);
		
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(g);
		//调用方法
		addComponent();
		submit.addActionListener(this);
		submit1.addActionListener(this);
		try {
			//设置窗口图标
			Image imgae= ImageIO.read(this.getClass().getResource("/jinhui.png"));
			setIconImage(imgae);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setResizable(false);//标上窗口拉伸及最大化
		setVisible(true);
		setLocationRelativeTo(null);//设居中显示;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//在这个方法中将会添加所有的组件;

//使用的网格包布局;希望楼主能看懂;

	public void addComponent(){
		//个人信息登记
		noteInformation=new JLabel("AES加解密",JLabel.CENTER);
		noteInformation.setForeground(Color.black);
		noteInformation.setFont(new Font("宋体",Font.BOLD, 30));
		add(g,c,noteInformation,0,0,5,1);
		//用户名
		userName=new JLabel("密  钥:");
		add(g,c,userName,0,1,1,1);
		//用户名输入框
		textUserName=new JTextField(15);
		add(g,c,textUserName,1,1,3,1);
		//密码：
		password=new JLabel("要加密的内容:");
		add(g,c,password,0,2,1,1);
		
		//密码：
		password1=new JLabel("加密后的内容:");
		add(g,c,password1,4,2,1,1);
		//密码输入框
		textUserPassword=new JTextArea(15,30);
		textUserPassword.setLineWrap(true); //激活自动换行功能 
		textUserPassword.setWrapStyleWord(true);
		JPanel panelInput;
		panelInput = new JPanel();
		panelInput.add(new JScrollPane(textUserPassword));//解决文字域超长滚动条问题
		add(g,c,panelInput,0,7,2,4);
		//submit按钮
		submit=new JButton("加密>>");
		c.insets=new Insets(7,0,4,0);
		add(g,c,submit,2,8,1,1);
		
		submit1=new JButton("<<解密");
		add(g,c,submit1,2,10,1,1);
		
		result=new JTextArea(15,30);
		result.setLineWrap(true); //激活自动换行功能 
		result.setWrapStyleWord(true);//换行的时候不会造成断字的现象
		JPanel panelOutput;
	    panelOutput = new JPanel();
	    panelOutput.add(new JScrollPane(result));//解决文字域超长滚动条问题
		add(g,c,panelOutput,4,7,2,4);
		
	}

	public void add(GridBagLayout g,GridBagConstraints c,JComponent jc,int x ,int y,int gw,int gh){
		c.gridx=x;
		c.gridy=y;
		c.anchor=GridBagConstraints.WEST;
		c.gridwidth=gw;
		c.gridheight=gh;
		g.setConstraints(jc,c);
		add(jc);
	}
	public static void main(String args[]){
		new AesUtilTools("AES加解密");
	}
	JLabel noteInformation,userName,password,password1;
	JTextField textUserName;
	JTextArea textUserPassword;
	JButton submit;
	JButton submit1;
	JTextArea result;
	@Override
	public void actionPerformed(ActionEvent arg0){
		try {
			String name = arg0.getActionCommand();
			String s=textUserName.getText();
			String key = s;
			if(StringUtils.isNotBlank(key)){
				if("加密>>".equals(name)){
					String t=textUserPassword.getText();
					if(StringUtils.isNotBlank(t)){
						String data = t.trim();
						String resultstr = temputil.encrypt(key, data);
						result.setText(resultstr);
					}else{
						
					}
				}else if("<<解密".equals(name)){
					String d = result.getText();
					if(StringUtils.isNotBlank(d)){
						d = d.trim();
						String resultstr = temputil.decrypt(key, d);
						textUserPassword.setText(resultstr);
					}else{
						
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
