package com.system.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeacherController {
	 public static void main(String[] args) {
		 String zz = "周一第1、2节<>周二第3、4节";
		 String[] aa = zz.split("<>");
		 Pattern pattern = Pattern.compile("周一第1、2节");
		 Matcher matcher = pattern.matcher(zz);
		 System.out.println(matcher.group(0));
	 }
}
