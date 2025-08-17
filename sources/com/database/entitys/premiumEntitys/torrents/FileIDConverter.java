package com.database.entitys.premiumEntitys.torrents;

import java.util.Arrays;
import java.util.List;

public class FileIDConverter {
    public static String a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
            sb.append(",");
        }
        String sb2 = sb.toString();
        return sb2.substring(0, sb2.length() - 1);
    }

    public static List<String> b(String str) {
        return Arrays.asList(str.split(","));
    }
}
