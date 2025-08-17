package com.facebook.ads.internal.p.a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private int f20474a;

    /* renamed from: b  reason: collision with root package name */
    private String f20475b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<String>> f20476c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f20477d;

    public n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f20474a = httpURLConnection.getResponseCode();
            this.f20475b = httpURLConnection.getURL().toString();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f20476c = httpURLConnection.getHeaderFields();
        this.f20477d = bArr;
    }

    public int a() {
        return this.f20474a;
    }

    public String b() {
        return this.f20475b;
    }

    public Map<String, List<String>> c() {
        return this.f20476c;
    }

    public byte[] d() {
        return this.f20477d;
    }

    public String e() {
        byte[] bArr = this.f20477d;
        if (bArr != null) {
            return new String(bArr);
        }
        return null;
    }
}
