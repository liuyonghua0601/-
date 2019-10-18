package com.jinhui.test.hook;

import com.jinhui.test.hook.TestHook.ActionCode;

/**
 * 2017-8-24下午03:57:30
 * Http11Processor.java
 * author:liuyonghua
 */
public class Http11Processor implements ActionHook {
    public void action(ActionCode actionCode,Object param) {
             if (actionCode ==ActionCode.CLOSE) {
                      System.out.println("Beforeclosing");
             } else if (actionCode ==ActionCode.COMMIT) {
                      System.out.println("Beforecommitting");
             }
    }

}
