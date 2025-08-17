package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {

    /* renamed from: b  reason: collision with root package name */
    private final Call.Factory f16272b;

    /* renamed from: c  reason: collision with root package name */
    private final GlideUrl f16273c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f16274d;

    /* renamed from: e  reason: collision with root package name */
    private ResponseBody f16275e;

    /* renamed from: f  reason: collision with root package name */
    private DataFetcher.DataCallback<? super InputStream> f16276f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Call f16277g;

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        this.f16272b = factory;
        this.f16273c = glideUrl;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        try {
            InputStream inputStream = this.f16274d;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f16275e;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f16276f = null;
    }

    public void cancel() {
        Call call = this.f16277g;
        if (call != null) {
            call.cancel();
        }
    }

    public DataSource d() {
        return DataSource.REMOTE;
    }

    public void e(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder url = new Request.Builder().url(this.f16273c.h());
        for (Map.Entry next : this.f16273c.e().entrySet()) {
            url.addHeader((String) next.getKey(), (String) next.getValue());
        }
        Request build = url.build();
        this.f16276f = dataCallback;
        this.f16277g = this.f16272b.newCall(build);
        this.f16277g.enqueue(this);
    }

    public void onFailure(Call call, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f16276f.c(iOException);
    }

    public void onResponse(Call call, Response response) {
        this.f16275e = response.body();
        if (response.isSuccessful()) {
            InputStream f2 = ContentLengthInputStream.f(this.f16275e.byteStream(), ((ResponseBody) Preconditions.d(this.f16275e)).contentLength());
            this.f16274d = f2;
            this.f16276f.f(f2);
            return;
        }
        this.f16276f.c(new HttpException(response.message(), response.code()));
    }
}
