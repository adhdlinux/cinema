package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.Util;

public final class DecoderCounters {

    /* renamed from: a  reason: collision with root package name */
    public int f23948a;

    /* renamed from: b  reason: collision with root package name */
    public int f23949b;

    /* renamed from: c  reason: collision with root package name */
    public int f23950c;

    /* renamed from: d  reason: collision with root package name */
    public int f23951d;

    /* renamed from: e  reason: collision with root package name */
    public int f23952e;

    /* renamed from: f  reason: collision with root package name */
    public int f23953f;

    /* renamed from: g  reason: collision with root package name */
    public int f23954g;

    /* renamed from: h  reason: collision with root package name */
    public int f23955h;

    /* renamed from: i  reason: collision with root package name */
    public int f23956i;

    /* renamed from: j  reason: collision with root package name */
    public int f23957j;

    /* renamed from: k  reason: collision with root package name */
    public long f23958k;

    /* renamed from: l  reason: collision with root package name */
    public int f23959l;

    private void b(long j2, int i2) {
        this.f23958k += j2;
        this.f23959l += i2;
    }

    public void a(long j2) {
        b(j2, 1);
    }

    public synchronized void c() {
    }

    public String toString() {
        return Util.C("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f23948a), Integer.valueOf(this.f23949b), Integer.valueOf(this.f23950c), Integer.valueOf(this.f23951d), Integer.valueOf(this.f23952e), Integer.valueOf(this.f23953f), Integer.valueOf(this.f23954g), Integer.valueOf(this.f23955h), Integer.valueOf(this.f23956i), Integer.valueOf(this.f23957j), Long.valueOf(this.f23958k), Integer.valueOf(this.f23959l));
    }
}
