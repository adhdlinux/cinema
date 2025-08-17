package androidx.media3.exoplayer;

import androidx.media3.common.util.Util;

public final class DecoderCounters {

    /* renamed from: a  reason: collision with root package name */
    public int f5150a;

    /* renamed from: b  reason: collision with root package name */
    public int f5151b;

    /* renamed from: c  reason: collision with root package name */
    public int f5152c;

    /* renamed from: d  reason: collision with root package name */
    public int f5153d;

    /* renamed from: e  reason: collision with root package name */
    public int f5154e;

    /* renamed from: f  reason: collision with root package name */
    public int f5155f;

    /* renamed from: g  reason: collision with root package name */
    public int f5156g;

    /* renamed from: h  reason: collision with root package name */
    public int f5157h;

    /* renamed from: i  reason: collision with root package name */
    public int f5158i;

    /* renamed from: j  reason: collision with root package name */
    public int f5159j;

    /* renamed from: k  reason: collision with root package name */
    public long f5160k;

    /* renamed from: l  reason: collision with root package name */
    public int f5161l;

    private void b(long j2, int i2) {
        this.f5160k += j2;
        this.f5161l += i2;
    }

    public void a(long j2) {
        b(j2, 1);
    }

    public synchronized void c() {
    }

    public String toString() {
        return Util.G("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f5150a), Integer.valueOf(this.f5151b), Integer.valueOf(this.f5152c), Integer.valueOf(this.f5153d), Integer.valueOf(this.f5154e), Integer.valueOf(this.f5155f), Integer.valueOf(this.f5156g), Integer.valueOf(this.f5157h), Integer.valueOf(this.f5158i), Integer.valueOf(this.f5159j), Long.valueOf(this.f5160k), Integer.valueOf(this.f5161l));
    }
}
