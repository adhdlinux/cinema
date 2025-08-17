package com.applovin.impl.sdk.d;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private long f15295a;

    /* renamed from: b  reason: collision with root package name */
    private long f15296b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15297c;

    /* renamed from: d  reason: collision with root package name */
    private long f15298d;

    /* renamed from: e  reason: collision with root package name */
    private long f15299e;

    /* renamed from: f  reason: collision with root package name */
    private int f15300f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f15301g;

    public void a() {
        this.f15297c = true;
    }

    public void a(int i2) {
        this.f15300f = i2;
    }

    public void a(long j2) {
        this.f15295a += j2;
    }

    public void a(Exception exc) {
        this.f15301g = exc;
    }

    public void b(long j2) {
        this.f15296b += j2;
    }

    public boolean b() {
        return this.f15297c;
    }

    public long c() {
        return this.f15295a;
    }

    public long d() {
        return this.f15296b;
    }

    public void e() {
        this.f15298d++;
    }

    public void f() {
        this.f15299e++;
    }

    public long g() {
        return this.f15298d;
    }

    public long h() {
        return this.f15299e;
    }

    public Exception i() {
        return this.f15301g;
    }

    public int j() {
        return this.f15300f;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.f15295a + ", totalCachedBytes=" + this.f15296b + ", isHTMLCachingCancelled=" + this.f15297c + ", htmlResourceCacheSuccessCount=" + this.f15298d + ", htmlResourceCacheFailureCount=" + this.f15299e + '}';
    }
}
