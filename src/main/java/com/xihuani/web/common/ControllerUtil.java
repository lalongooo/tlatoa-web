package com.xihuani.web.common;

public class ControllerUtil {
	
	public static String redirect(Object... arguments) {
		String url = "redirect:";
		for(Object argument: arguments) {
			url += "/" + argument;
		}
		return url;
	}

}
