package com.chartboost.sdk.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.chartboost.sdk.impl.f3;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.DefaultDatabaseProvider;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.PlatformScheduler;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class h4 {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.chartboost.sdk.impl.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: com.chartboost.sdk.impl.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.chartboost.sdk.impl.f3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.google.android.exoplayer2.upstream.cache.Cache a(com.chartboost.sdk.impl.m5 r7, com.google.android.exoplayer2.database.DatabaseProvider r8, com.chartboost.sdk.impl.vc r9, com.chartboost.sdk.impl.f3.b r10, com.google.android.exoplayer2.upstream.cache.CacheEvictor r11, int r12, java.lang.Object r13) {
        /*
            r12 = r12 & 16
            if (r12 == 0) goto L_0x0012
            com.chartboost.sdk.impl.f3 r11 = new com.chartboost.sdk.impl.f3
            long r1 = r9.b()
            r4 = 0
            r5 = 4
            r6 = 0
            r0 = r11
            r3 = r10
            r0.<init>(r1, r3, r4, r5, r6)
        L_0x0012:
            com.google.android.exoplayer2.upstream.cache.Cache r7 = a(r7, r8, r9, r10, r11)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.h4.a(com.chartboost.sdk.impl.m5, com.google.android.exoplayer2.database.DatabaseProvider, com.chartboost.sdk.impl.vc, com.chartboost.sdk.impl.f3$b, com.google.android.exoplayer2.upstream.cache.CacheEvictor, int, java.lang.Object):com.google.android.exoplayer2.upstream.cache.Cache");
    }

    public static final File b(Context context) {
        Intrinsics.f(context, "<this>");
        File file = new w5(context.getCacheDir()).f18894h;
        Intrinsics.e(file, "FileCacheLocations(cacheDir).precacheDir");
        return file;
    }

    public static final File c(Context context) {
        Intrinsics.f(context, "<this>");
        File file = new w5(context.getCacheDir()).f18895i;
        Intrinsics.e(file, "FileCacheLocations(cacheDir).precacheQueueDir");
        return file;
    }

    public static final Cache a(m5 m5Var, DatabaseProvider databaseProvider, vc vcVar, f3.b bVar, CacheEvictor cacheEvictor) {
        Intrinsics.f(m5Var, "fileCaching");
        Intrinsics.f(databaseProvider, "databaseProvider");
        Intrinsics.f(vcVar, "cachePolicy");
        Intrinsics.f(bVar, "evictorCallback");
        Intrinsics.f(cacheEvictor, "evictor");
        return new SimpleCache(m5Var.b(), cacheEvictor, databaseProvider);
    }

    public static final CacheDataSource.Factory a(Cache cache, HttpDataSource$Factory httpDataSource$Factory) {
        Intrinsics.f(cache, "cache");
        Intrinsics.f(httpDataSource$Factory, "httpDataSourceFactory");
        CacheDataSource.Factory j2 = new CacheDataSource.Factory().i(cache).k(httpDataSource$Factory).j((DataSink.Factory) null);
        Intrinsics.e(j2, "Factory()\n    .setCache(…riteDataSinkFactory(null)");
        return j2;
    }

    public static /* synthetic */ DownloadManager a(Context context, DatabaseProvider databaseProvider, Cache cache, HttpDataSource$Factory httpDataSource$Factory, DownloadManager.Listener listener, int i2, int i3, int i4, Object obj) {
        return a(context, databaseProvider, cache, httpDataSource$Factory, listener, (i4 & 32) != 0 ? 2 : i2, (i4 & 64) != 0 ? 1 : i3);
    }

    public static final DownloadManager a(Context context, DatabaseProvider databaseProvider, Cache cache, HttpDataSource$Factory httpDataSource$Factory, DownloadManager.Listener listener, int i2, int i3) {
        Intrinsics.f(context, "context");
        Intrinsics.f(databaseProvider, "databaseProvider");
        Intrinsics.f(cache, "cache");
        Intrinsics.f(httpDataSource$Factory, "httpDataSourceFactory");
        Intrinsics.f(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        DownloadManager downloadManager = new DownloadManager(context, databaseProvider, cache, httpDataSource$Factory, Executors.newFixedThreadPool(i2));
        downloadManager.y(i3);
        downloadManager.d(listener);
        return downloadManager;
    }

    public static final DatabaseProvider a(Context context) {
        Intrinsics.f(context, "context");
        return new DefaultDatabaseProvider(new p5(context, (String) null, (SQLiteDatabase.CursorFactory) null, 0, 14, (DefaultConstructorMarker) null));
    }

    public static final void a() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        CookieHandler.setDefault(cookieManager);
    }

    public static /* synthetic */ LoadControl a(int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 500;
        }
        if ((i4 & 2) != 0) {
            i3 = 50000;
        }
        return a(i2, i3);
    }

    public static final LoadControl a(int i2, int i3) {
        DefaultLoadControl a2 = new DefaultLoadControl.Builder().b(i2, i3, i2, i2).a();
        Intrinsics.e(a2, "Builder()\n    .setBuffer…minBufferMs\n    ).build()");
        return a2;
    }

    public static final MediaSource.Factory a(DataSource.Factory factory) {
        Intrinsics.f(factory, "<this>");
        return new DefaultMediaSourceFactory(factory);
    }

    public static /* synthetic */ Scheduler a(Context context, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        return a(context, i2);
    }

    public static final Scheduler a(Context context, int i2) {
        Intrinsics.f(context, "context");
        if (Util.f28808a >= 21) {
            return new PlatformScheduler(context, i2);
        }
        return null;
    }
}
