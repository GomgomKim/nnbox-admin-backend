package com.nnbox.admin.common.utils;

public class Endian {
	public static String changeHexOrder(String s) {
	    char[] arr = s.toCharArray();
	    char tmp;
	    for (int i = 0; i < arr.length / 2; i += 2) {
	        tmp = arr[i];
	        arr[i] = arr[arr.length-i-2];
	        arr[arr.length-i-2] = tmp;

	        tmp = arr[i+1];
	        arr[i+1] = arr[arr.length-i-1];
	        arr[arr.length-i-1] = tmp;
	    }
	    return new String(arr);
	}
}
