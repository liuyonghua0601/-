package com.jinhui.test.hook;

import com.jinhui.test.hook.TestHook.ActionCode;

/**
 * 2017-8-24下午03:59:16
 * Response.java
 * author:liuyonghua
 */
public class Response {
    public ActionHook hook;
    public ActionHook getHook() {
             return hook;
    }
    public void setHook(ActionHook hook) {
             this.hook = hook;
    }
    public void action(ActionCode actionCode,Object param) {
             hook.action(actionCode, param);
    }
}
