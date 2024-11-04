package com.fruitweb.util;

/**
 * ClassName:StringUtil
 * Package:com.fruitweb.util
 * Description:
 *
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        boolean b = str == null || "".equals(str);
        return b;
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
