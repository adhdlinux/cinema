package com.chartboost.sdk.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class pe {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f18390a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f18391b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f18392c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f18393d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f18394e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f18395f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f18396g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    public static String a(String str, String str2) {
        df.a(str, "HTML is null or empty");
        int[][] a2 = a(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (b(str, sb, f18391b, str2, a2)) {
            return sb.toString();
        }
        if (a(str, sb, f18390a, str2, a2)) {
            return sb.toString();
        }
        if (b(str, sb, f18393d, str2, a2)) {
            return sb.toString();
        }
        if (a(str, sb, f18392c, str2, a2)) {
            return sb.toString();
        }
        if (b(str, sb, f18395f, str2, a2)) {
            return sb.toString();
        }
        if (a(str, sb, f18394e, str2, a2)) {
            return sb.toString();
        }
        if (a(str, sb, f18396g, str2, a2)) {
            return sb.toString();
        }
        return str2 + str;
    }

    public static String b(String str, String str2) {
        return a(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    public static boolean a(int i2, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i2 >= iArr2[0] && i2 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i2 = 0;
        while (matcher.find(i2)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i2 = end;
        }
        return false;
    }

    public static boolean a(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i2 = 0;
        while (matcher.find(i2)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i2 = end;
        }
        return false;
    }

    public static int[][] a(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int indexOf = str.indexOf("<!--", i2);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i2 = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i2 = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2}));
    }
}
