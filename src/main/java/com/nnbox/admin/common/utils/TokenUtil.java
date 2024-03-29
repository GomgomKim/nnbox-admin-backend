package com.nnbox.admin.common.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenUtil {

	public static String genToken() throws Exception{
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[32];
		random.nextBytes(bytes);
		String token = Base64.getEncoder().encodeToString(bytes);
		token = token.replaceAll("\\+", "a");
		token = token.replaceAll("/", "b");
		token = token.replaceAll("=", "c");
		return token;
	}
}
