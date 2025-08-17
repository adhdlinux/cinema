package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Headers f16696b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f16697c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16698d;

    /* renamed from: e  reason: collision with root package name */
    private String f16699e;

    /* renamed from: f  reason: collision with root package name */
    private URL f16700f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f16701g;

    /* renamed from: h  reason: collision with root package name */
    private int f16702h;

    public GlideUrl(URL url) {
        this(url, Headers.f16704b);
    }

    private byte[] d() {
        if (this.f16701g == null) {
            this.f16701g = c().getBytes(Key.f16305a);
        }
        return this.f16701g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f16699e)) {
            String str = this.f16698d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.d(this.f16697c)).toString();
            }
            this.f16699e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f16699e;
    }

    private URL g() throws MalformedURLException {
        if (this.f16700f == null) {
            this.f16700f = new URL(f());
        }
        return this.f16700f;
    }

    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f16698d;
        return str != null ? str : ((URL) Preconditions.d(this.f16697c)).toString();
    }

    public Map<String, String> e() {
        return this.f16696b.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!c().equals(glideUrl.c()) || !this.f16696b.equals(glideUrl.f16696b)) {
            return false;
        }
        return true;
    }

    public String h() {
        return f();
    }

    public int hashCode() {
        if (this.f16702h == 0) {
            int hashCode = c().hashCode();
            this.f16702h = hashCode;
            this.f16702h = (hashCode * 31) + this.f16696b.hashCode();
        }
        return this.f16702h;
    }

    public URL i() throws MalformedURLException {
        return g();
    }

    public String toString() {
        return c();
    }

    public GlideUrl(String str) {
        this(str, Headers.f16704b);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f16697c = (URL) Preconditions.d(url);
        this.f16698d = null;
        this.f16696b = (Headers) Preconditions.d(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f16697c = null;
        this.f16698d = Preconditions.b(str);
        this.f16696b = (Headers) Preconditions.d(headers);
    }
}
