package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.applovin.mediation.MaxErrorCode;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import v0.c;

public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {

    /* renamed from: a  reason: collision with root package name */
    private final DataSpec f25610a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ParsingLoadable.Parser<M> f25611b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<StreamKey> f25612c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheDataSource.Factory f25613d;

    /* renamed from: e  reason: collision with root package name */
    private final Cache f25614e;

    /* renamed from: f  reason: collision with root package name */
    private final CacheKeyFactory f25615f;

    /* renamed from: g  reason: collision with root package name */
    private final PriorityTaskManager f25616g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f25617h;

    /* renamed from: i  reason: collision with root package name */
    private final long f25618i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<RunnableFutureTask<?, ?>> f25619j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f25620k;

    private static final class ProgressNotifier implements CacheWriter.ProgressListener {

        /* renamed from: a  reason: collision with root package name */
        private final Downloader.ProgressListener f25624a;

        /* renamed from: b  reason: collision with root package name */
        private final long f25625b;

        /* renamed from: c  reason: collision with root package name */
        private final int f25626c;

        /* renamed from: d  reason: collision with root package name */
        private long f25627d;

        /* renamed from: e  reason: collision with root package name */
        private int f25628e;

        public ProgressNotifier(Downloader.ProgressListener progressListener, long j2, int i2, long j3, int i3) {
            this.f25624a = progressListener;
            this.f25625b = j2;
            this.f25626c = i2;
            this.f25627d = j3;
            this.f25628e = i3;
        }

        private float b() {
            long j2 = this.f25625b;
            if (j2 != -1 && j2 != 0) {
                return (((float) this.f25627d) * 100.0f) / ((float) j2);
            }
            int i2 = this.f25626c;
            if (i2 != 0) {
                return (((float) this.f25628e) * 100.0f) / ((float) i2);
            }
            return -1.0f;
        }

        public void a(long j2, long j3, long j4) {
            long j5 = this.f25627d + j4;
            this.f25627d = j5;
            this.f25624a.a(this.f25625b, j5, b());
        }

        public void c() {
            this.f25628e++;
            this.f25624a.a(this.f25625b, this.f25627d, b());
        }
    }

    protected static class Segment implements Comparable<Segment> {

        /* renamed from: b  reason: collision with root package name */
        public final long f25629b;

        /* renamed from: c  reason: collision with root package name */
        public final DataSpec f25630c;

        public Segment(long j2, DataSpec dataSpec) {
            this.f25629b = j2;
            this.f25630c = dataSpec;
        }

        /* renamed from: a */
        public int compareTo(Segment segment) {
            return Util.o(this.f25629b, segment.f25629b);
        }
    }

    private static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {

        /* renamed from: i  reason: collision with root package name */
        public final Segment f25631i;

        /* renamed from: j  reason: collision with root package name */
        public final CacheDataSource f25632j;

        /* renamed from: k  reason: collision with root package name */
        private final ProgressNotifier f25633k;

        /* renamed from: l  reason: collision with root package name */
        public final byte[] f25634l;

        /* renamed from: m  reason: collision with root package name */
        private final CacheWriter f25635m;

        public SegmentDownloadRunnable(Segment segment, CacheDataSource cacheDataSource, ProgressNotifier progressNotifier, byte[] bArr) {
            this.f25631i = segment;
            this.f25632j = cacheDataSource;
            this.f25633k = progressNotifier;
            this.f25634l = bArr;
            this.f25635m = new CacheWriter(cacheDataSource, segment.f25630c, bArr, progressNotifier);
        }

        /* access modifiers changed from: protected */
        public void c() {
            this.f25635m.b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public Void d() throws IOException {
            this.f25635m.a();
            ProgressNotifier progressNotifier = this.f25633k;
            if (progressNotifier == null) {
                return null;
            }
            progressNotifier.c();
            return null;
        }
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        Assertions.e(mediaItem.f23129c);
        this.f25610a = f(mediaItem.f23129c.f23202a);
        this.f25611b = parser;
        this.f25612c = new ArrayList<>(mediaItem.f23129c.f23205d);
        this.f25613d = factory;
        this.f25617h = executor;
        this.f25614e = (Cache) Assertions.e(factory.f());
        this.f25615f = factory.g();
        this.f25616g = factory.h();
        this.f25618i = Util.F0(j2);
    }

    private <T> void c(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.f25619j) {
            if (!this.f25620k) {
                this.f25619j.add(runnableFutureTask);
            } else {
                throw new InterruptedException();
            }
        }
    }

    private static boolean d(DataSpec dataSpec, DataSpec dataSpec2) {
        if (dataSpec.f28339a.equals(dataSpec2.f28339a)) {
            long j2 = dataSpec.f28346h;
            if (j2 == -1 || dataSpec.f28345g + j2 != dataSpec2.f28345g || !Util.c(dataSpec.f28347i, dataSpec2.f28347i) || dataSpec.f28348j != dataSpec2.f28348j || dataSpec.f28341c != dataSpec2.f28341c || !dataSpec.f28343e.equals(dataSpec2.f28343e)) {
                return false;
            }
            return true;
        }
        return false;
    }

    protected static DataSpec f(Uri uri) {
        return new DataSpec.Builder().i(uri).b(1).a();
    }

    private static void i(List<Segment> list, CacheKeyFactory cacheKeyFactory, long j2) {
        Segment segment;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Segment segment2 = list.get(i3);
            String a2 = cacheKeyFactory.a(segment2.f25630c);
            Integer num = (Integer) hashMap.get(a2);
            if (num == null) {
                segment = null;
            } else {
                segment = list.get(num.intValue());
            }
            if (segment == null || segment2.f25629b > segment.f25629b + j2 || !d(segment.f25630c, segment2.f25630c)) {
                hashMap.put(a2, Integer.valueOf(i2));
                list.set(i2, segment2);
                i2++;
            } else {
                long j3 = segment2.f25630c.f28346h;
                long j4 = -1;
                if (j3 != -1) {
                    j4 = segment.f25630c.f28346h + j3;
                }
                list.set(((Integer) Assertions.e(num)).intValue(), new Segment(segment.f25629b, segment.f25630c.f(0, j4)));
            }
        }
        Util.Q0(list, i2, list.size());
    }

    private void j(int i2) {
        synchronized (this.f25619j) {
            this.f25619j.remove(i2);
        }
    }

    private void k(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.f25619j) {
            this.f25619j.remove(runnableFutureTask);
        }
    }

    public final void a(Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        ProgressNotifier progressNotifier;
        CacheDataSource cacheDataSource;
        byte[] bArr;
        int size;
        SegmentDownloadRunnable segmentDownloadRunnable;
        int i2;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager = this.f25616g;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(MaxErrorCode.NETWORK_ERROR);
        }
        try {
            CacheDataSource c2 = this.f25613d.c();
            FilterableManifest g2 = g(c2, this.f25610a, false);
            if (!this.f25612c.isEmpty()) {
                g2 = (FilterableManifest) g2.a(this.f25612c);
            }
            List<Segment> h2 = h(c2, g2, false);
            Collections.sort(h2);
            i(h2, this.f25615f, this.f25618i);
            int size2 = h2.size();
            long j2 = 0;
            long j3 = 0;
            int i3 = 0;
            for (int size3 = h2.size() - 1; size3 >= 0; size3 = i2 - 1) {
                DataSpec dataSpec = h2.get(size3).f25630c;
                String a2 = this.f25615f.a(dataSpec);
                long j4 = dataSpec.f28346h;
                if (j4 == -1) {
                    long a3 = c.a(this.f25614e.b(a2));
                    if (a3 != -1) {
                        j4 = a3 - dataSpec.f28345g;
                    }
                }
                int i4 = size3;
                long g3 = this.f25614e.g(a2, dataSpec.f28345g, j4);
                j3 += g3;
                if (j4 != -1) {
                    if (j4 == g3) {
                        i3++;
                        i2 = i4;
                        h2.remove(i2);
                    } else {
                        i2 = i4;
                    }
                    if (j2 != -1) {
                        j2 += j4;
                    }
                } else {
                    i2 = i4;
                    j2 = -1;
                }
            }
            if (progressListener != null) {
                progressNotifier = new ProgressNotifier(progressListener, j2, size2, j3, i3);
            } else {
                progressNotifier = null;
            }
            arrayDeque.addAll(h2);
            while (!this.f25620k && !arrayDeque.isEmpty()) {
                PriorityTaskManager priorityTaskManager2 = this.f25616g;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(MaxErrorCode.NETWORK_ERROR);
                }
                if (!arrayDeque2.isEmpty()) {
                    SegmentDownloadRunnable segmentDownloadRunnable2 = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                    cacheDataSource = segmentDownloadRunnable2.f25632j;
                    bArr = segmentDownloadRunnable2.f25634l;
                } else {
                    cacheDataSource = this.f25613d.c();
                    bArr = new byte[131072];
                }
                SegmentDownloadRunnable segmentDownloadRunnable3 = new SegmentDownloadRunnable((Segment) arrayDeque.removeFirst(), cacheDataSource, progressNotifier, bArr);
                c(segmentDownloadRunnable3);
                this.f25617h.execute(segmentDownloadRunnable3);
                size = this.f25619j.size() - 1;
                while (size >= 0) {
                    segmentDownloadRunnable = (SegmentDownloadRunnable) this.f25619j.get(size);
                    if (arrayDeque.isEmpty() || segmentDownloadRunnable.isDone()) {
                        segmentDownloadRunnable.get();
                        j(size);
                        arrayDeque2.addLast(segmentDownloadRunnable);
                    }
                    size--;
                }
                segmentDownloadRunnable3.b();
            }
            for (int i5 = 0; i5 < this.f25619j.size(); i5++) {
                this.f25619j.get(i5).cancel(true);
            }
            for (int size4 = this.f25619j.size() - 1; size4 >= 0; size4--) {
                this.f25619j.get(size4).a();
                j(size4);
            }
            PriorityTaskManager priorityTaskManager3 = this.f25616g;
            if (priorityTaskManager3 != null) {
                priorityTaskManager3.d(MaxErrorCode.NETWORK_ERROR);
            }
        } catch (ExecutionException e2) {
            Throwable th = (Throwable) Assertions.e(e2.getCause());
            if (th instanceof PriorityTaskManager.PriorityTooLowException) {
                arrayDeque.addFirst(segmentDownloadRunnable.f25631i);
                j(size);
                arrayDeque2.addLast(segmentDownloadRunnable);
            } else if (!(th instanceof IOException)) {
                Util.U0(th);
            } else {
                throw ((IOException) th);
            }
        } catch (Throwable th2) {
            for (int i6 = 0; i6 < this.f25619j.size(); i6++) {
                this.f25619j.get(i6).cancel(true);
            }
            for (int size5 = this.f25619j.size() - 1; size5 >= 0; size5--) {
                this.f25619j.get(size5).a();
                j(size5);
            }
            PriorityTaskManager priorityTaskManager4 = this.f25616g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.d(MaxErrorCode.NETWORK_ERROR);
            }
            throw th2;
        }
    }

    public void cancel() {
        synchronized (this.f25619j) {
            this.f25620k = true;
            for (int i2 = 0; i2 < this.f25619j.size(); i2++) {
                this.f25619j.get(i2).cancel(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final <T> T e(RunnableFutureTask<T, ?> runnableFutureTask, boolean z2) throws InterruptedException, IOException {
        if (z2) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e2) {
                Throwable th = (Throwable) Assertions.e(e2.getCause());
                if (!(th instanceof IOException)) {
                    Util.U0(e2);
                } else {
                    throw ((IOException) th);
                }
            }
        }
        while (!this.f25620k) {
            PriorityTaskManager priorityTaskManager = this.f25616g;
            if (priorityTaskManager != null) {
                priorityTaskManager.b(MaxErrorCode.NETWORK_ERROR);
            }
            c(runnableFutureTask);
            this.f25617h.execute(runnableFutureTask);
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e3) {
                Throwable th2 = (Throwable) Assertions.e(e3.getCause());
                if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th2 instanceof IOException)) {
                        Util.U0(e3);
                    } else {
                        throw ((IOException) th2);
                    }
                }
            } finally {
                runnableFutureTask.a();
                k(runnableFutureTask);
            }
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public final M g(final DataSource dataSource, final DataSpec dataSpec, boolean z2) throws InterruptedException, IOException {
        return (FilterableManifest) e(new RunnableFutureTask<M, IOException>() {
            /* access modifiers changed from: protected */
            /* renamed from: f */
            public M d() throws IOException {
                return (FilterableManifest) ParsingLoadable.g(dataSource, SegmentDownloader.this.f25611b, dataSpec, 4);
            }
        }, z2);
    }

    /* access modifiers changed from: protected */
    public abstract List<Segment> h(DataSource dataSource, M m2, boolean z2) throws IOException, InterruptedException;

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void remove() {
        /*
            r5 = this;
            com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory r0 = r5.f25613d
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r0 = r0.d()
            com.google.android.exoplayer2.upstream.DataSpec r1 = r5.f25610a     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2 = 1
            com.google.android.exoplayer2.offline.FilterableManifest r1 = r5.g(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.util.List r0 = r5.h(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r1 = 0
        L_0x0012:
            int r2 = r0.size()     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            if (r1 >= r2) goto L_0x0030
            com.google.android.exoplayer2.upstream.cache.Cache r2 = r5.f25614e     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r3 = r5.f25615f     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.Object r4 = r0.get(r1)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r4 = (com.google.android.exoplayer2.offline.SegmentDownloader.Segment) r4     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.upstream.DataSpec r4 = r4.f25630c     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.String r3 = r3.a(r4)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2.k(r3)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            int r1 = r1 + 1
            goto L_0x0012
        L_0x002e:
            r0 = move-exception
            goto L_0x0047
        L_0x0030:
            com.google.android.exoplayer2.upstream.cache.Cache r0 = r5.f25614e
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r1 = r5.f25615f
            com.google.android.exoplayer2.upstream.DataSpec r2 = r5.f25610a
            java.lang.String r1 = r1.a(r2)
            r0.k(r1)
            goto L_0x0046
        L_0x003e:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002e }
            r0.interrupt()     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x0046:
            return
        L_0x0047:
            com.google.android.exoplayer2.upstream.cache.Cache r1 = r5.f25614e
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r2 = r5.f25615f
            com.google.android.exoplayer2.upstream.DataSpec r3 = r5.f25610a
            java.lang.String r2 = r2.a(r3)
            r1.k(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.remove():void");
    }
}
