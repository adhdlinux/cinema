package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class SonicAudioProcessor implements AudioProcessor {

    /* renamed from: b  reason: collision with root package name */
    private int f4534b;

    /* renamed from: c  reason: collision with root package name */
    private float f4535c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f4536d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4537e;

    /* renamed from: f  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4538f;

    /* renamed from: g  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4539g;

    /* renamed from: h  reason: collision with root package name */
    private AudioProcessor.AudioFormat f4540h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4541i;

    /* renamed from: j  reason: collision with root package name */
    private Sonic f4542j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f4543k;

    /* renamed from: l  reason: collision with root package name */
    private ShortBuffer f4544l;

    /* renamed from: m  reason: collision with root package name */
    private ByteBuffer f4545m;

    /* renamed from: n  reason: collision with root package name */
    private long f4546n;

    /* renamed from: o  reason: collision with root package name */
    private long f4547o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4548p;

    public SonicAudioProcessor() {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f4499e;
        this.f4537e = audioFormat;
        this.f4538f = audioFormat;
        this.f4539g = audioFormat;
        this.f4540h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f4498a;
        this.f4543k = byteBuffer;
        this.f4544l = byteBuffer.asShortBuffer();
        this.f4545m = byteBuffer;
        this.f4534b = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f4542j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r1 = this;
            boolean r0 = r1.f4548p
            if (r0 == 0) goto L_0x0010
            androidx.media3.common.audio.Sonic r0 = r1.f4542j
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.audio.SonicAudioProcessor.a():boolean");
    }

    public final ByteBuffer b() {
        int k2;
        Sonic sonic = this.f4542j;
        if (sonic != null && (k2 = sonic.k()) > 0) {
            if (this.f4543k.capacity() < k2) {
                ByteBuffer order = ByteBuffer.allocateDirect(k2).order(ByteOrder.nativeOrder());
                this.f4543k = order;
                this.f4544l = order.asShortBuffer();
            } else {
                this.f4543k.clear();
                this.f4544l.clear();
            }
            sonic.j(this.f4544l);
            this.f4547o += (long) k2;
            this.f4543k.limit(k2);
            this.f4545m = this.f4543k;
        }
        ByteBuffer byteBuffer = this.f4545m;
        this.f4545m = AudioProcessor.f4498a;
        return byteBuffer;
    }

    public final void c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f4546n += (long) remaining;
            ((Sonic) Assertions.f(this.f4542j)).t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void d() {
        Sonic sonic = this.f4542j;
        if (sonic != null) {
            sonic.s();
        }
        this.f4548p = true;
    }

    public final AudioProcessor.AudioFormat e(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f4502c == 2) {
            int i2 = this.f4534b;
            if (i2 == -1) {
                i2 = audioFormat.f4500a;
            }
            this.f4537e = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i2, audioFormat.f4501b, 2);
            this.f4538f = audioFormat2;
            this.f4541i = true;
            return audioFormat2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public final long f(long j2) {
        if (this.f4547o < 1024) {
            return (long) (((double) this.f4535c) * ((double) j2));
        }
        long l2 = this.f4546n - ((long) ((Sonic) Assertions.f(this.f4542j)).l());
        int i2 = this.f4540h.f4500a;
        int i3 = this.f4539g.f4500a;
        if (i2 == i3) {
            return Util.c1(j2, l2, this.f4547o);
        }
        return Util.c1(j2, l2 * ((long) i2), this.f4547o * ((long) i3));
    }

    public final void flush() {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.f4537e;
            this.f4539g = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.f4538f;
            this.f4540h = audioFormat2;
            if (this.f4541i) {
                this.f4542j = new Sonic(audioFormat.f4500a, audioFormat.f4501b, this.f4535c, this.f4536d, audioFormat2.f4500a);
            } else {
                Sonic sonic = this.f4542j;
                if (sonic != null) {
                    sonic.i();
                }
            }
        }
        this.f4545m = AudioProcessor.f4498a;
        this.f4546n = 0;
        this.f4547o = 0;
        this.f4548p = false;
    }

    public final void g(float f2) {
        if (this.f4536d != f2) {
            this.f4536d = f2;
            this.f4541i = true;
        }
    }

    public final void h(float f2) {
        if (this.f4535c != f2) {
            this.f4535c = f2;
            this.f4541i = true;
        }
    }

    public final boolean isActive() {
        if (this.f4538f.f4500a == -1 || (Math.abs(this.f4535c - 1.0f) < 1.0E-4f && Math.abs(this.f4536d - 1.0f) < 1.0E-4f && this.f4538f.f4500a == this.f4537e.f4500a)) {
            return false;
        }
        return true;
    }

    public final void reset() {
        this.f4535c = 1.0f;
        this.f4536d = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f4499e;
        this.f4537e = audioFormat;
        this.f4538f = audioFormat;
        this.f4539g = audioFormat;
        this.f4540h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f4498a;
        this.f4543k = byteBuffer;
        this.f4544l = byteBuffer.asShortBuffer();
        this.f4545m = byteBuffer;
        this.f4534b = -1;
        this.f4541i = false;
        this.f4542j = null;
        this.f4546n = 0;
        this.f4547o = 0;
        this.f4548p = false;
    }
}
