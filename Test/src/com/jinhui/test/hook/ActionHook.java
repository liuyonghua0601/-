package com.jinhui.test.hook;

import com.jinhui.test.hook.TestHook.ActionCode;

/**
 * 2017-8-24下午03:58:33
 * ActionHook.java
 * author:liuyonghua
 */
public interface ActionHook {
	   public void action(ActionCode actionCode, Object param);
}