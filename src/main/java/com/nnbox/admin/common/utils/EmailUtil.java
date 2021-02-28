package com.nnbox.admin.common.utils;

import java.util.regex.Pattern;

public class EmailUtil {

    public static boolean isEmail(String email) {
        if (email==null) return false;
        boolean b = Pattern.matches(
            "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", 
            email.trim());
        return b;
    }
}
