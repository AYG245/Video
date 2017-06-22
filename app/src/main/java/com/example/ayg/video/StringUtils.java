package com.example.ayg.video;

/**
 * Created by AYG on 2017/6/21.
 */

import java.sql.Date;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;

public class StringUtils {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd hh:mm:ss";
    public final static String EMPTY = "";

    /**
     * 格式化日期字符串
     */
    public static String formatDate(java.util.Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 格式化日期字符串
     */
    public static String formatDate(java.util.Date date) {
        return formatDate(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * 获取当前时间 格式为yyyy-MM-dd 例如2011-07-08
     */
    public static String getDate() {
        return formatDate(new java.util.Date(), DEFAULT_DATE_PATTERN);
    }

    /**
     * 获取当前时间
     */
    public static String getDateTime() {
        return formatDate(new java.util.Date(), DEFAULT_DATETIME_PATTERN);
    }

    /**
     * 格式化日期时间字符串
     */
    public static String formatDateTime(java.util.Date date) {
        return formatDate(date, DEFAULT_DATETIME_PATTERN);
    }

    public static String join(final ArrayList<String> array, String separator) {
        StringBuffer result = new StringBuffer();
        if (array != null && array.size() > 0) {
            for (String str : array) {
                result.append(str);
                result.append(separator);
            }
            result.delete(result.length() - 1, result.length());
        }
        return result.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }


}