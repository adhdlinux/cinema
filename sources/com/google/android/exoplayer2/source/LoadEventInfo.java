package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class LoadEventInfo {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLong f25757h = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public final long f25758a;

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f25759b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f25760c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, List<String>> f25761d;

    /* renamed from: e  reason: collision with root package name */
    public final long f25762e;

    /* renamed from: f  reason: collision with root package name */
    public final long f25763f;

    /* renamed from: g  reason: collision with root package name */
    public final long f25764g;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoadEventInfo(long r13, com.google.android.exoplayer2.upstream.DataSpec r15, long r16) {
        /*
            r12 = this;
            r3 = r15
            android.net.Uri r4 = r3.f28339a
            java.util.Map r5 = java.util.Collections.emptyMap()
            r8 = 0
            r10 = 0
            r0 = r12
            r1 = r13
            r6 = r16
            r0.<init>(r1, r3, r4, r5, r6, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.LoadEventInfo.<init>(long, com.google.android.exoplayer2.upstream.DataSpec, long):void");
    }

    public static long a() {
        return f25757h.getAndIncrement();
    }

    public LoadEventInfo(long j2, DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j3, long j4, long j5) {
        this.f25758a = j2;
        this.f25759b = dataSpec;
        this.f25760c = uri;
        this.f25761d = map;
        this.f25762e = j3;
        this.f25763f = j4;
        this.f25764g = j5;
    }
}
