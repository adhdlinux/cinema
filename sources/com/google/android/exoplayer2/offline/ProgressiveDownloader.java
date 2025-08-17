package com.google.android.exoplayer2.offline;

import com.applovin.mediation.MaxErrorCode;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class ProgressiveDownloader implements Downloader {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f25601a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSpec f25602b;

    /* renamed from: c  reason: collision with root package name */
    private final CacheDataSource f25603c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final CacheWriter f25604d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityTaskManager f25605e;

    /* renamed from: f  reason: collision with root package name */
    private Downloader.ProgressListener f25606f;

    /* renamed from: g  reason: collision with root package name */
    private volatile RunnableFutureTask<Void, IOException> f25607g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f25608h;

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this.f25601a = (Executor) Assertions.e(executor);
        Assertions.e(mediaItem.f23129c);
        DataSpec a2 = new DataSpec.Builder().i(mediaItem.f23129c.f23202a).f(mediaItem.f23129c.f23206e).b(4).a();
        this.f25602b = a2;
        CacheDataSource c2 = factory.c();
        this.f25603c = c2;
        this.f25604d = new CacheWriter(c2, a2, (byte[]) null, new h(this));
        this.f25605e = factory.h();
    }

    /* access modifiers changed from: private */
    public void d(long j2, long j3, long j4) {
        float f2;
        Downloader.ProgressListener progressListener = this.f25606f;
        if (progressListener != null) {
            if (j2 == -1 || j2 == 0) {
                f2 = -1.0f;
            } else {
                f2 = (((float) j3) * 100.0f) / ((float) j2);
            }
            progressListener.a(j2, j3, f2);
        }
    }

    public void a(Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        this.f25606f = progressListener;
        PriorityTaskManager priorityTaskManager = this.f25605e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(MaxErrorCode.NETWORK_ERROR);
        }
        boolean z2 = false;
        while (!z2) {
            try {
                if (this.f25608h) {
                    break;
                }
                this.f25607g = new RunnableFutureTask<Void, IOException>() {
                    /* access modifiers changed from: protected */
                    public void c() {
                        ProgressiveDownloader.this.f25604d.b();
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: f */
                    public Void d() throws IOException {
                        ProgressiveDownloader.this.f25604d.a();
                        return null;
                    }
                };
                PriorityTaskManager priorityTaskManager2 = this.f25605e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(MaxErrorCode.NETWORK_ERROR);
                }
                this.f25601a.execute(this.f25607g);
                this.f25607g.get();
                z2 = true;
            } catch (ExecutionException e2) {
                Throwable th = (Throwable) Assertions.e(e2.getCause());
                if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th instanceof IOException)) {
                        Util.U0(th);
                    } else {
                        throw ((IOException) th);
                    }
                }
            } catch (Throwable th2) {
                ((RunnableFutureTask) Assertions.e(this.f25607g)).a();
                PriorityTaskManager priorityTaskManager3 = this.f25605e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.d(MaxErrorCode.NETWORK_ERROR);
                }
                throw th2;
            }
        }
        ((RunnableFutureTask) Assertions.e(this.f25607g)).a();
        PriorityTaskManager priorityTaskManager4 = this.f25605e;
        if (priorityTaskManager4 != null) {
            priorityTaskManager4.d(MaxErrorCode.NETWORK_ERROR);
        }
    }

    public void cancel() {
        this.f25608h = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.f25607g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    public void remove() {
        this.f25603c.s().k(this.f25603c.t().a(this.f25602b));
    }
}
