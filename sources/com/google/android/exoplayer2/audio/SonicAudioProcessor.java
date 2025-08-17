package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private int f23878b;

    /* renamed from: c  reason: collision with root package name */
    private float f23879c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f23880d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f23881e;

    /* renamed from: f  reason: collision with root package name */
    private AudioProcessor.AudioFormat f23882f;

    /* renamed from: g  reason: collision with root package name */
    private AudioProcessor.AudioFormat f23883g;

    /* renamed from: h  reason: collision with root package name */
    private AudioProcessor.AudioFormat f23884h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23885i;

    /* renamed from: j  reason: collision with root package name */
    private Sonic f23886j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f23887k;

    /* renamed from: l  reason: collision with root package name */
    private ShortBuffer f23888l;

    /* renamed from: m  reason: collision with root package name */
    private ByteBuffer f23889m;

    /* renamed from: n  reason: collision with root package name */
    private long f23890n;

    /* renamed from: o  reason: collision with root package name */
    private long f23891o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f23892p;

    public SonicAudioProcessor() {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f23681e;
        this.f23881e = audioFormat;
        this.f23882f = audioFormat;
        this.f23883g = audioFormat;
        this.f23884h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f23680a;
        this.f23887k = byteBuffer;
        this.f23888l = byteBuffer.asShortBuffer();
        this.f23889m = byteBuffer;
        this.f23878b = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f23886j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r1 = this;
            boolean r0 = r1.f23892p
            if (r0 == 0) goto L_0x0010
            com.google.android.exoplayer2.audio.Sonic r0 = r1.f23886j
            if (r0 == 0) goto L_0x000e
            int r0 = r0.k()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.SonicAudioProcessor.a():boolean");
    }

    public ByteBuffer b() {
        int k2;
        Sonic sonic = this.f23886j;
        if (sonic != null && (k2 = sonic.k()) > 0) {
            if (this.f23887k.capacity() < k2) {
                ByteBuffer order = ByteBuffer.allocateDirect(k2).order(ByteOrder.nativeOrder());
                this.f23887k = order;
                this.f23888l = order.asShortBuffer();
            } else {
                this.f23887k.clear();
                this.f23888l.clear();
            }
            sonic.j(this.f23888l);
            this.f23891o += (long) k2;
            this.f23887k.limit(k2);
            this.f23889m = this.f23887k;
        }
        ByteBuffer byteBuffer = this.f23889m;
        this.f23889m = AudioProcessor.f23680a;
        return byteBuffer;
    }

    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f23890n += (long) remaining;
            ((Sonic) Assertions.e(this.f23886j)).t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public void d() {
        Sonic sonic = this.f23886j;
        if (sonic != null) {
            sonic.s();
        }
        this.f23892p = true;
    }

    public AudioProcessor.AudioFormat e(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f23684c == 2) {
            int i2 = this.f23878b;
            if (i2 == -1) {
                i2 = audioFormat.f23682a;
            }
            this.f23881e = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i2, audioFormat.f23683b, 2);
            this.f23882f = audioFormat2;
            this.f23885i = true;
            return audioFormat2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public long f(long j2) {
        if (this.f23891o < 1024) {
            return (long) (((double) this.f23879c) * ((double) j2));
        }
        long l2 = this.f23890n - ((long) ((Sonic) Assertions.e(this.f23886j)).l());
        int i2 = this.f23884h.f23682a;
        int i3 = this.f23883g.f23682a;
        if (i2 == i3) {
            return Util.R0(j2, l2, this.f23891o);
        }
        return Util.R0(j2, l2 * ((long) i2), this.f23891o * ((long) i3));
    }

    public void flush() {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.f23881e;
            this.f23883g = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.f23882f;
            this.f23884h = audioFormat2;
            if (this.f23885i) {
                this.f23886j = new Sonic(audioFormat.f23682a, audioFormat.f23683b, this.f23879c, this.f23880d, audioFormat2.f23682a);
            } else {
                Sonic sonic = this.f23886j;
                if (sonic != null) {
                    sonic.i();
                }
            }
        }
        this.f23889m = AudioProcessor.f23680a;
        this.f23890n = 0;
        this.f23891o = 0;
        this.f23892p = false;
    }

    public void g(float f2) {
        if (this.f23880d != f2) {
            this.f23880d = f2;
            this.f23885i = true;
        }
    }

    public void h(float f2) {
        if (this.f23879c != f2) {
            this.f23879c = f2;
            this.f23885i = true;
        }
    }

    public boolean isActive() {
        if (this.f23882f.f23682a == -1 || (Math.abs(this.f23879c - 1.0f) < 1.0E-4f && Math.abs(this.f23880d - 1.0f) < 1.0E-4f && this.f23882f.f23682a == this.f23881e.f23682a)) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.f23879c = 1.0f;
        this.f23880d = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f23681e;
        this.f23881e = audioFormat;
        this.f23882f = audioFormat;
        this.f23883g = audioFormat;
        this.f23884h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f23680a;
        this.f23887k = byteBuffer;
        this.f23888l = byteBuffer.asShortBuffer();
        this.f23889m = byteBuffer;
        this.f23878b = -1;
        this.f23885i = false;
        this.f23886j = null;
        this.f23890n = 0;
        this.f23891o = 0;
        this.f23892p = false;
    }
}
