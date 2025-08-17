package com.chartboost.sdk.impl;

import android.util.Log;
import b0.r;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class f3 implements CacheEvictor {

    /* renamed from: a  reason: collision with root package name */
    public final long f17675a;

    /* renamed from: b  reason: collision with root package name */
    public final b f17676b;

    /* renamed from: c  reason: collision with root package name */
    public final Function0 f17677c;

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f17678d;

    /* renamed from: e  reason: collision with root package name */
    public long f17679e;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17680b = new a();

        /* renamed from: com.chartboost.sdk.impl.f3$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0023a extends FunctionReferenceImpl implements Function2 {

            /* renamed from: b  reason: collision with root package name */
            public static final C0023a f17681b = new C0023a();

            public C0023a() {
                super(2, g3.class, "compare", "compare(Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;)I", 1);
            }

            /* renamed from: a */
            public final Integer invoke(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
                Intrinsics.f(cacheSpan, "p0");
                Intrinsics.f(cacheSpan2, "p1");
                return Integer.valueOf(g3.b(cacheSpan, cacheSpan2));
            }
        }

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final TreeSet invoke() {
            return new TreeSet(new r(C0023a.f17681b));
        }

        public static final int a(Function2 function2, Object obj, Object obj2) {
            Intrinsics.f(function2, "$tmp0");
            return ((Number) function2.invoke(obj, obj2)).intValue();
        }
    }

    public interface b {
        void c(String str);
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f3 f17682b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f3 f3Var) {
            super(0);
            this.f17682b = f3Var;
        }

        /* renamed from: a */
        public final TreeSet invoke() {
            return (TreeSet) this.f17682b.f17677c.invoke();
        }
    }

    public f3(long j2, b bVar, Function0 function0) {
        Intrinsics.f(bVar, "evictUrlCallback");
        Intrinsics.f(function0, "treeSetFactory");
        this.f17675a = j2;
        this.f17676b = bVar;
        this.f17677c = function0;
        this.f17678d = LazyKt__LazyJVMKt.b(new c(this));
    }

    public void onCacheInitialized() {
    }

    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        Intrinsics.f(cache, "cache");
        Intrinsics.f(cacheSpan, "span");
        a().add(cacheSpan);
        this.f17679e += cacheSpan.f28583d;
        a(cache, 0);
    }

    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        Intrinsics.f(cache, "cache");
        Intrinsics.f(cacheSpan, "span");
        a().remove(cacheSpan);
        this.f17679e -= cacheSpan.f28583d;
    }

    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        Intrinsics.f(cache, "cache");
        Intrinsics.f(cacheSpan, "oldSpan");
        Intrinsics.f(cacheSpan2, "newSpan");
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    public void onStartFile(Cache cache, String str, long j2, long j3) {
        Intrinsics.f(cache, "cache");
        Intrinsics.f(str, "key");
        if (j3 != -1) {
            a(cache, j3);
        }
    }

    public boolean requiresCacheSpanTouches() {
        return true;
    }

    public final TreeSet a() {
        return (TreeSet) this.f17678d.getValue();
    }

    public final void a(Cache cache, long j2) {
        while (this.f17679e + j2 > this.f17675a && !a().isEmpty()) {
            CacheSpan cacheSpan = (CacheSpan) a().first();
            String a2 = g3.f17716a;
            Log.d(a2, "evictCache() - " + cacheSpan.f28581b);
            cache.j(cacheSpan);
            b bVar = this.f17676b;
            String str = cacheSpan.f28581b;
            Intrinsics.e(str, "cacheSpanToEvict.key");
            bVar.c(str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f3(long j2, b bVar, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, bVar, (i2 & 4) != 0 ? a.f17680b : function0);
    }
}
