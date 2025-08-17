package com.google.android.exoplayer2.offline;

import android.util.SparseArray;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.dash.offline.DashDownloader;
import com.google.android.exoplayer2.source.hls.offline.HlsDownloader;
import com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

public class DefaultDownloaderFactory implements DownloaderFactory {

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<Constructor<? extends Downloader>> f25516c = c();

    /* renamed from: a  reason: collision with root package name */
    private final CacheDataSource.Factory f25517a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f25518b;

    public DefaultDownloaderFactory(CacheDataSource.Factory factory, Executor executor) {
        this.f25517a = (CacheDataSource.Factory) Assertions.e(factory);
        this.f25518b = (Executor) Assertions.e(executor);
    }

    private Downloader b(DownloadRequest downloadRequest, int i2) {
        Constructor constructor = f25516c.get(i2);
        if (constructor != null) {
            try {
                return (Downloader) constructor.newInstance(new Object[]{new MediaItem.Builder().i(downloadRequest.f25573c).f(downloadRequest.f25575e).b(downloadRequest.f25577g).a(), this.f25517a, this.f25518b});
            } catch (Exception e2) {
                throw new IllegalStateException("Failed to instantiate downloader for content type " + i2, e2);
            }
        } else {
            throw new IllegalStateException("Module missing for content type " + i2);
        }
    }

    private static SparseArray<Constructor<? extends Downloader>> c() {
        SparseArray<Constructor<? extends Downloader>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, d(DashDownloader.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, d(HlsDownloader.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, d(SsDownloader.class));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    private static Constructor<? extends Downloader> d(Class<?> cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(new Class[]{MediaItem.class, CacheDataSource.Factory.class, Executor.class});
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException("Downloader constructor missing", e2);
        }
    }

    public Downloader a(DownloadRequest downloadRequest) {
        int s02 = Util.s0(downloadRequest.f25573c, downloadRequest.f25574d);
        if (s02 == 0 || s02 == 1 || s02 == 2) {
            return b(downloadRequest, s02);
        }
        if (s02 == 4) {
            return new ProgressiveDownloader(new MediaItem.Builder().i(downloadRequest.f25573c).b(downloadRequest.f25577g).a(), this.f25517a, this.f25518b);
        }
        throw new IllegalArgumentException("Unsupported type: " + s02);
    }
}
