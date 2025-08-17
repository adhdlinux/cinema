package com.yoku.house.ads.helper.cacheImages;

import android.content.Context;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class PicassoHelper {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f38021a = false;

    public static void a(Context context) {
        if (!f38021a) {
            File b2 = CacheUtils.b(context);
            Cache cache = new Cache(b2, CacheUtils.a(b2));
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Picasso.setSingletonInstance(new Picasso.Builder(context).indicatorsEnabled(false).downloader(new OkHttp3Downloader(builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).cache(cache).build())).loggingEnabled(false).build());
            f38021a = true;
        }
    }

    public static RequestCreator b(String str) {
        if (!f38021a) {
            System.out.println("Must initialize first");
        }
        return Picasso.get().load(str);
    }
}
