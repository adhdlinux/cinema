package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher<InputStream> {

    /* renamed from: h  reason: collision with root package name */
    static final HttpUrlConnectionFactory f16330h = new DefaultHttpUrlConnectionFactory();

    /* renamed from: b  reason: collision with root package name */
    private final GlideUrl f16331b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16332c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpUrlConnectionFactory f16333d;

    /* renamed from: e  reason: collision with root package name */
    private HttpURLConnection f16334e;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f16335f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f16336g;

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface HttpUrlConnectionFactory {
        HttpURLConnection a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i2) {
        this(glideUrl, i2, f16330h);
    }

    private InputStream c(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f16335f = ContentLengthInputStream.f(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f16335f = httpURLConnection.getInputStream();
        }
        return this.f16335f;
    }

    private static boolean f(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean g(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream h(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f16334e = this.f16333d.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.f16334e.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f16334e.setConnectTimeout(this.f16332c);
            this.f16334e.setReadTimeout(this.f16332c);
            this.f16334e.setUseCaches(false);
            this.f16334e.setDoInput(true);
            this.f16334e.setInstanceFollowRedirects(false);
            this.f16334e.connect();
            this.f16335f = this.f16334e.getInputStream();
            if (this.f16336g) {
                return null;
            }
            int responseCode = this.f16334e.getResponseCode();
            if (f(responseCode)) {
                return c(this.f16334e);
            }
            if (g(responseCode)) {
                String headerField = this.f16334e.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return h(url3, i2 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f16334e.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.f16335f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f16334e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f16334e = null;
    }

    public void cancel() {
        this.f16336g = true;
    }

    public DataSource d() {
        return DataSource.REMOTE;
    }

    public void e(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long b2 = LogTime.b();
        try {
            dataCallback.f(h(this.f16331b.i(), 0, (URL) null, this.f16331b.e()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.a(b2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
            }
            dataCallback.c(e2);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(b2));
            }
            throw th;
        }
    }

    HttpUrlFetcher(GlideUrl glideUrl, int i2, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.f16331b = glideUrl;
        this.f16332c = i2;
        this.f16333d = httpUrlConnectionFactory;
    }
}
