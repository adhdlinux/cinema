package com.facebook.ads.internal.p.a;

import com.uwetrottmann.trakt5.TraktV2;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.internal.http2.Http2;

public abstract class f implements q {

    /* renamed from: a  reason: collision with root package name */
    private final r f20459a;

    public f() {
        this(new g());
    }

    public f(r rVar) {
        this.f20459a = rVar;
    }

    public OutputStream a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    public HttpURLConnection a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public void a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    public void a(HttpURLConnection httpURLConnection, j jVar, String str) {
        httpURLConnection.setRequestMethod(jVar.c());
        httpURLConnection.setDoOutput(jVar.b());
        httpURLConnection.setDoInput(jVar.a());
        if (str != null) {
            httpURLConnection.setRequestProperty(TraktV2.HEADER_CONTENT_TYPE, str);
        }
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
    }

    public boolean a(m mVar) {
        n a2 = mVar.a();
        if (this.f20459a.a()) {
            this.f20459a.a("BasicRequestHandler.onError got");
            mVar.printStackTrace();
        }
        return a2 != null && a2.a() > 0;
    }

    public byte[] a(InputStream inputStream) {
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public InputStream b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
