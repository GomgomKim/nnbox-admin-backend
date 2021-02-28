package com.nnbox.admin.common.utils;

public class PasswordUtil {
	public static boolean isStrong(String password) {
		
		String includeRegex = "^([a-zA-Z0-9!@#\\$%\\^&\\*]{8,15})$";
		String strongRegex = "^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])";

	    if (!password.matches(includeRegex) || !password.matches(strongRegex)) {
			return false;
	    }
	    return true;
	}
}
