package com.startapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f34072a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f34073b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f34074c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f34075d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f34076e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f34077f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f34078g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

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
}
