package com.facebook.ads.internal.p.b;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class h implements n {

    /* renamed from: a  reason: collision with root package name */
    public final String f20523a;

    /* renamed from: b  reason: collision with root package name */
    private HttpURLConnection f20524b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f20525c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f20526d;

    /* renamed from: e  reason: collision with root package name */
    private volatile String f20527e;

    public h(h hVar) {
        this.f20526d = Integer.MIN_VALUE;
        this.f20523a = hVar.f20523a;
        this.f20527e = hVar.f20527e;
        this.f20526d = hVar.f20526d;
    }

    public h(String str) {
        this(str, m.a(str));
    }

    public h(String str, String str2) {
        this.f20526d = Integer.MIN_VALUE;
        this.f20523a = (String) j.a(str);
        this.f20527e = str2;
    }

    private int a(HttpURLConnection httpURLConnection, int i2, int i3) {
        int contentLength = httpURLConnection.getContentLength();
        return i3 == 200 ? contentLength : i3 == 206 ? contentLength + i2 : this.f20526d;
    }

    private HttpURLConnection a(int i2, int i3) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z2;
        String str2 = this.f20523a;
        int i4 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (i2 > 0) {
                str = " with offset " + i2;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            Log.d("ProxyCache", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            if (i2 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i2 + "-");
            }
            if (i3 > 0) {
                httpURLConnection.setConnectTimeout(i3);
                httpURLConnection.setReadTimeout(i3);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z2 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z2) {
                str2 = httpURLConnection.getHeaderField("Location");
                i4++;
                httpURLConnection.disconnect();
            }
            if (i4 > 5) {
                throw new l("Too many redirects: " + i4);
            }
        } while (z2);
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Read content info from "
            r0.append(r1)
            java.lang.String r1 = r6.f20523a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ProxyCache"
            android.util.Log.d(r1, r0)
            r0 = 0
            r2 = 10000(0x2710, float:1.4013E-41)
            r3 = 0
            java.net.HttpURLConnection r0 = r6.a(r0, r2)     // Catch:{ IOException -> 0x0065, all -> 0x0062 }
            int r2 = r0.getContentLength()     // Catch:{ IOException -> 0x0060 }
            r6.f20526d = r2     // Catch:{ IOException -> 0x0060 }
            java.lang.String r2 = r0.getContentType()     // Catch:{ IOException -> 0x0060 }
            r6.f20527e = r2     // Catch:{ IOException -> 0x0060 }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ IOException -> 0x0060 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060 }
            r2.<init>()     // Catch:{ IOException -> 0x0060 }
            java.lang.String r4 = "Content info for `"
            r2.append(r4)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r4 = r6.f20523a     // Catch:{ IOException -> 0x0060 }
            r2.append(r4)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r4 = "`: mime: "
            r2.append(r4)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r4 = r6.f20527e     // Catch:{ IOException -> 0x0060 }
            r2.append(r4)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r4 = ", content-length: "
            r2.append(r4)     // Catch:{ IOException -> 0x0060 }
            int r4 = r6.f20526d     // Catch:{ IOException -> 0x0060 }
            r2.append(r4)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0060 }
            android.util.Log.i(r1, r2)     // Catch:{ IOException -> 0x0060 }
            com.facebook.ads.internal.p.b.m.a((java.io.Closeable) r3)
            goto L_0x0082
        L_0x005e:
            r1 = move-exception
            goto L_0x0086
        L_0x0060:
            r2 = move-exception
            goto L_0x0067
        L_0x0062:
            r1 = move-exception
            r0 = r3
            goto L_0x0086
        L_0x0065:
            r2 = move-exception
            r0 = r3
        L_0x0067:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r4.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r5 = "Error fetching info from "
            r4.append(r5)     // Catch:{ all -> 0x005e }
            java.lang.String r5 = r6.f20523a     // Catch:{ all -> 0x005e }
            r4.append(r5)     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005e }
            android.util.Log.e(r1, r4, r2)     // Catch:{ all -> 0x005e }
            com.facebook.ads.internal.p.b.m.a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x0085
        L_0x0082:
            r0.disconnect()
        L_0x0085:
            return
        L_0x0086:
            com.facebook.ads.internal.p.b.m.a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x008e
            r0.disconnect()
        L_0x008e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.b.h.d():void");
    }

    public synchronized int a() {
        if (this.f20526d == Integer.MIN_VALUE) {
            d();
        }
        return this.f20526d;
    }

    public int a(byte[] bArr) {
        InputStream inputStream = this.f20525c;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e2) {
                throw new i("Reading source " + this.f20523a + " is interrupted", e2);
            } catch (IOException e3) {
                throw new l("Error reading data from " + this.f20523a, e3);
            }
        } else {
            throw new l("Error reading data from " + this.f20523a + ": connection is absent!");
        }
    }

    public void a(int i2) {
        try {
            HttpURLConnection a2 = a(i2, -1);
            this.f20524b = a2;
            this.f20527e = a2.getContentType();
            this.f20525c = new BufferedInputStream(this.f20524b.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f20524b;
            this.f20526d = a(httpURLConnection, i2, httpURLConnection.getResponseCode());
        } catch (IOException e2) {
            throw new l("Error opening connection for " + this.f20523a + " with offset " + i2, e2);
        }
    }

    public void b() {
        HttpURLConnection httpURLConnection = this.f20524b;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (NullPointerException e2) {
                throw new l("Error disconnecting HttpUrlConnection", e2);
            }
        }
    }

    public synchronized String c() {
        if (TextUtils.isEmpty(this.f20527e)) {
            d();
        }
        return this.f20527e;
    }

    public String toString() {
        return "HttpUrlSource{url='" + this.f20523a + "}";
    }
}
