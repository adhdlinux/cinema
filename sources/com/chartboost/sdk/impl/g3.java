package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.upstream.cache.CacheSpan;

public abstract class g3 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17716a = f3.class.getSimpleName();

    public static final int b(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j2 = cacheSpan.f28586g;
        long j3 = cacheSpan2.f28586g;
        if (j2 - j3 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        if (j2 < j3) {
            return -1;
        }
        return 1;
    }
}
