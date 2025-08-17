package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private final long f23844i;

    /* renamed from: j  reason: collision with root package name */
    private final long f23845j;

    /* renamed from: k  reason: collision with root package name */
    private final short f23846k;

    /* renamed from: l  reason: collision with root package name */
    private int f23847l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23848m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f23849n;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f23850o;

    /* renamed from: p  reason: collision with root package name */
    private int f23851p;

    /* renamed from: q  reason: collision with root package name */
    private int f23852q;

    /* renamed from: r  reason: collision with root package name */
    private int f23853r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f23854s;

    /* renamed from: t  reason: collision with root package name */
    private long f23855t;

    public SilenceSkippingAudioProcessor() {
        this(150000, 20000, 1024);
    }

    private int l(long j2) {
        return (int) ((j2 * ((long) this.f23736b.f23682a)) / 1000000);
    }

    private int m(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        while (true) {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
            if (Math.abs(byteBuffer.getShort(limit)) > this.f23846k) {
                int i2 = this.f23847l;
                return ((limit / i2) * i2) + i2;
            }
        }
    }

    private int n(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > this.f23846k) {
                int i2 = this.f23847l;
                return i2 * (position / i2);
            }
        }
        return byteBuffer.limit();
    }

    private void p(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        k(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.f23854s = true;
        }
    }

    private void q(byte[] bArr, int i2) {
        k(i2).put(bArr, 0, i2).flip();
        if (i2 > 0) {
            this.f23854s = true;
        }
    }

    private void r(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int n2 = n(byteBuffer);
        int position = n2 - byteBuffer.position();
        byte[] bArr = this.f23849n;
        int length = bArr.length;
        int i2 = this.f23852q;
        int i3 = length - i2;
        if (n2 >= limit || position >= i3) {
            int min = Math.min(position, i3);
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer.get(this.f23849n, this.f23852q, min);
            int i4 = this.f23852q + min;
            this.f23852q = i4;
            byte[] bArr2 = this.f23849n;
            if (i4 == bArr2.length) {
                if (this.f23854s) {
                    q(bArr2, this.f23853r);
                    this.f23855t += (long) ((this.f23852q - (this.f23853r * 2)) / this.f23847l);
                } else {
                    this.f23855t += (long) ((i4 - this.f23853r) / this.f23847l);
                }
                v(byteBuffer, this.f23849n, this.f23852q);
                this.f23852q = 0;
                this.f23851p = 2;
            }
            byteBuffer.limit(limit);
            return;
        }
        q(bArr, i2);
        this.f23852q = 0;
        this.f23851p = 0;
    }

    private void s(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f23849n.length));
        int m2 = m(byteBuffer);
        if (m2 == byteBuffer.position()) {
            this.f23851p = 1;
        } else {
            byteBuffer.limit(m2);
            p(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void t(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int n2 = n(byteBuffer);
        byteBuffer.limit(n2);
        this.f23855t += (long) (byteBuffer.remaining() / this.f23847l);
        v(byteBuffer, this.f23850o, this.f23853r);
        if (n2 < limit) {
            q(this.f23850o, this.f23853r);
            this.f23851p = 0;
            byteBuffer.limit(limit);
        }
    }

    private void v(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int min = Math.min(byteBuffer.remaining(), this.f23853r);
        int i3 = this.f23853r - min;
        System.arraycopy(bArr, i2 - i3, this.f23850o, 0, i3);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f23850o, i3, min);
    }

    public void c(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !f()) {
            int i2 = this.f23851p;
            if (i2 == 0) {
                s(byteBuffer);
            } else if (i2 == 1) {
                r(byteBuffer);
            } else if (i2 == 2) {
                t(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f23684c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        } else if (this.f23848m) {
            return audioFormat;
        } else {
            return AudioProcessor.AudioFormat.f23681e;
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (this.f23848m) {
            this.f23847l = this.f23736b.f23685d;
            int l2 = l(this.f23844i) * this.f23847l;
            if (this.f23849n.length != l2) {
                this.f23849n = new byte[l2];
            }
            int l3 = l(this.f23845j) * this.f23847l;
            this.f23853r = l3;
            if (this.f23850o.length != l3) {
                this.f23850o = new byte[l3];
            }
        }
        this.f23851p = 0;
        this.f23855t = 0;
        this.f23852q = 0;
        this.f23854s = false;
    }

    /* access modifiers changed from: protected */
    public void i() {
        int i2 = this.f23852q;
        if (i2 > 0) {
            q(this.f23849n, i2);
        }
        if (!this.f23854s) {
            this.f23855t += (long) (this.f23853r / this.f23847l);
        }
    }

    public boolean isActive() {
        return this.f23848m;
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f23848m = false;
        this.f23853r = 0;
        byte[] bArr = Util.f28813f;
        this.f23849n = bArr;
        this.f23850o = bArr;
    }

    public long o() {
        return this.f23855t;
    }

    public void u(boolean z2) {
        this.f23848m = z2;
    }

    public SilenceSkippingAudioProcessor(long j2, long j3, short s2) {
        Assertions.a(j3 <= j2);
        this.f23844i = j2;
        this.f23845j = j3;
        this.f23846k = s2;
        byte[] bArr = Util.f28813f;
        this.f23849n = bArr;
        this.f23850o = bArr;
    }
}
