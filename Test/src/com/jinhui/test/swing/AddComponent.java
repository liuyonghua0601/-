package com.jinhui.test.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * 2017-6-13下午01:34:54
 * AddComponent.java
 * author:liuyonghua
 */
public class AddComponent extends JFrame {

	public AddComponent(){  
        initGUI();  
    }  
    private void initGUI(){  
        setVisible(true);  
        setSize(300,200);  
        setLocationRelativeTo(null);  
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  
           
        //创建元件  
        JButton jButton1 = new JButton("jButton1");  
        //添加元件  
        add(jButton1);  
    }  
    public static void main(String[] args) {  
        SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                AddComponent f = new AddComponent();  
            }                 
        });  
    }  
}
