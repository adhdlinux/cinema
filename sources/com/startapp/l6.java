package com.startapp;

import java.lang.Comparable;
import java.util.regex.Pattern;

public class l6<T extends Comparable<T>> implements Comparable<l6<T>> {

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f34858a = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f34859b = Pattern.compile("((\\d{1,2})|(100))%");

    /* renamed from: c  reason: collision with root package name */
    public final String f34860c;

    /* renamed from: d  reason: collision with root package name */
    public final T f34861d;

    public l6(String str, T t2) {
        this.f34860c = str;
        this.f34861d = t2;
    }

    public static boolean a(String str) {
        return f34858a.matcher(str).matches();
    }

    public static Integer b(String str) {
        String[] split = str.split(":");
        if (split.length != 3) {
            return null;
        }
        try {
            return Integer.valueOf((Integer.parseInt(split[0]) * 60 * 60 * 1000) + (Integer.parseInt(split[1]) * 60 * 1000) + ((int) (Float.parseFloat(split[2]) * 1000.0f)));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public int compareTo(Object obj) {
        return this.f34861d.compareTo(((l6) obj).f34861d);
    }
}
