package androidx.media3.exoplayer.source.chunk;

import java.util.NoSuchElementException;

public abstract class BaseMediaChunkIterator implements MediaChunkIterator {

    /* renamed from: b  reason: collision with root package name */
    private final long f7192b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7193c;

    /* renamed from: d  reason: collision with root package name */
    private long f7194d;

    public BaseMediaChunkIterator(long j2, long j3) {
        this.f7192b = j2;
        this.f7193c = j3;
        f();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        long j2 = this.f7194d;
        if (j2 < this.f7192b || j2 > this.f7193c) {
            throw new NoSuchElementException();
        }
    }

    /* access modifiers changed from: protected */
    public final long d() {
        return this.f7194d;
    }

    public boolean e() {
        return this.f7194d > this.f7193c;
    }

    public void f() {
        this.f7194d = this.f7192b - 1;
    }

    public boolean next() {
        this.f7194d++;
        return !e();
    }
}
