package com.squareup.picasso;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class OkHttp3Downloader implements Downloader {
    private final Cache cache;
    final Call.Factory client;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public Response load(Request request) throws IOException {
        return this.client.newCall(request).execute();
    }

    public void shutdown() {
        Cache cache2;
        if (!this.sharedClient && (cache2 = this.cache) != null) {
            try {
                cache2.close();
            } catch (IOException unused) {
            }
        }
    }

    public OkHttp3Downloader(File file) {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    public OkHttp3Downloader(Context context, long j2) {
        this(Utils.createDefaultCacheDir(context), j2);
    }

    public OkHttp3Downloader(File file, long j2) {
        this(new OkHttpClient.Builder().cache(new Cache(file, j2)).build());
        this.sharedClient = false;
    }

    public OkHttp3Downloader(OkHttpClient okHttpClient) {
        this.sharedClient = true;
        this.client = okHttpClient;
        this.cache = okHttpClient.cache();
    }

    public OkHttp3Downloader(Call.Factory factory) {
        this.sharedClient = true;
        this.client = factory;
        this.cache = null;
    }
}
