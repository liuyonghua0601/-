package com.jinhui.test.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2017-5-8上午09:33:09
 * TestPattern.java
 * author:liuyonghua
 */
public class TestPattern {

	public static void main(String[] args) {
		///^[^(mtalk)(talk)(talkx\.l)(talk\.l)]\.google\.com$/g
		Pattern pattern = Pattern.compile("^.*[sina\\.com]*.$");
		Matcher matcher = pattern.matcher("http://www.sina.codb");
		boolean result = matcher.matches();
		System.out.println(result);
	}
}
