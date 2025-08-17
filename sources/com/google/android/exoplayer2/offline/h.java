package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.upstream.cache.CacheWriter;

public final /* synthetic */ class h implements CacheWriter.ProgressListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressiveDownloader f25645a;

    public /* synthetic */ h(ProgressiveDownloader progressiveDownloader) {
        this.f25645a = progressiveDownloader;
    }

    public final void a(long j2, long j3, long j4) {
        this.f25645a.d(j2, j3, j4);
    }
}
