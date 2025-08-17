package com.iab.omid.library.adcolony;

import com.iab.omid.library.adcolony.d.e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f31392a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f31393b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f31394c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f31395d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f31396e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f31397f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f31398g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    static String a(String str, String str2) {
        return e(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    private static boolean b(int i2, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i2 >= iArr2[0] && i2 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean c(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i2 = 0;
        while (matcher.find(i2)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!b(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i2 = end;
        }
        return false;
    }

    private static int[][] d(String str) {
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

    static String e(String str, String str2) {
        e.f(str, "HTML is null or empty");
        int[][] d2 = d(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (f(str, sb, f31393b, str2, d2)) {
            return sb.toString();
        }
        if (c(str, sb, f31392a, str2, d2)) {
            return sb.toString();
        }
        if (f(str, sb, f31395d, str2, d2)) {
            return sb.toString();
        }
        if (c(str, sb, f31394c, str2, d2)) {
            return sb.toString();
        }
        if (f(str, sb, f31397f, str2, d2)) {
            return sb.toString();
        }
        if (c(str, sb, f31396e, str2, d2)) {
            return sb.toString();
        }
        if (c(str, sb, f31398g, str2, d2)) {
            return sb.toString();
        }
        return str2 + str;
    }

    private static boolean f(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i2 = 0;
        while (matcher.find(i2)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!b(start, iArr)) {
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
}
