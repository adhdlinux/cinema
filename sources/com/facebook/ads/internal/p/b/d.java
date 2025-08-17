package com.facebook.ads.internal.p.b;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class d {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f20489d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f20490e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a  reason: collision with root package name */
    public final String f20491a;

    /* renamed from: b  reason: collision with root package name */
    public final long f20492b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f20493c;

    public d(String str) {
        j.a(str);
        long a2 = a(str);
        this.f20492b = Math.max(0, a2);
        this.f20493c = a2 >= 0;
        this.f20491a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f20489d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1;
    }

    public static d a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine);
            sb.append(10);
        }
    }

    private String b(String str) {
        Matcher matcher = f20490e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f20492b + ", partial=" + this.f20493c + ", uri='" + this.f20491a + '\'' + '}';
    }
}
