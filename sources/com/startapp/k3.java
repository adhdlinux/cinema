package com.startapp;

import android.app.Activity;
import com.startapp.ic;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class k3 {

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f34800a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34801b;

    /* renamed from: c  reason: collision with root package name */
    public final ic.a f34802c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f34803d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f34804e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34805f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34806g;

    /* renamed from: h  reason: collision with root package name */
    public long f34807h;

    /* renamed from: i  reason: collision with root package name */
    public long f34808i;

    /* renamed from: j  reason: collision with root package name */
    public long f34809j;

    /* renamed from: k  reason: collision with root package name */
    public long f34810k;

    /* renamed from: l  reason: collision with root package name */
    public int f34811l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f34812m;

    public k3(String str, ic.a aVar, boolean z2, boolean z3) {
        this.f34801b = str;
        this.f34802c = aVar;
        this.f34803d = z2;
        this.f34804e = z3;
    }

    public static void a(StringBuilder sb, String str, String str2, boolean z2) {
        if (str != null) {
            sb.append(str);
            sb.append('=');
        }
        if (z2) {
            sb.append('(');
            sb.append(str2);
            sb.append(')');
        } else {
            sb.append(str2);
        }
        sb.append(", ");
    }

    public static void a(StringBuilder sb) {
        if (sb.length() >= 2 && sb.substring(sb.length() - 2, sb.length()).equals(", ")) {
            sb.delete(sb.length() - 2, sb.length());
        }
    }

    public static String a(long j2) {
        boolean z2 = true;
        String format = String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(((float) j2) / 1000000.0f)});
        Map<Activity, Integer> map = lb.f34876a;
        int length = format.length() - 1;
        int i2 = 0;
        while (length >= 0) {
            char charAt = format.charAt(length);
            if (charAt == '0') {
                if (z2) {
                    i2++;
                }
            } else if (charAt == '.') {
                if (!z2) {
                    length = format.length() - i2;
                }
                return format.substring(0, length);
            } else {
                z2 = false;
            }
            length--;
        }
        return format;
    }
}
