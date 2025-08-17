package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

public abstract class BaseMediaChunkIterator implements MediaChunkIterator {

    /* renamed from: b  reason: collision with root package name */
    private final long f26055b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26056c;

    /* renamed from: d  reason: collision with root package name */
    private long f26057d;

    public BaseMediaChunkIterator(long j2, long j3) {
        this.f26055b = j2;
        this.f26056c = j3;
        f();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        long j2 = this.f26057d;
        if (j2 < this.f26055b || j2 > this.f26056c) {
            throw new NoSuchElementException();
        }
    }

    /* access modifiers changed from: protected */
    public final long d() {
        return this.f26057d;
    }

    public boolean e() {
        return this.f26057d > this.f26056c;
    }

    public void f() {
        this.f26057d = this.f26055b - 1;
    }

    public boolean next() {
        this.f26057d++;
        return !e();
    }
}
