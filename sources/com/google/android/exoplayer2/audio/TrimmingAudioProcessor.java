package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class TrimmingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private int f23893i;

    /* renamed from: j  reason: collision with root package name */
    private int f23894j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23895k;

    /* renamed from: l  reason: collision with root package name */
    private int f23896l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f23897m = Util.f28813f;

    /* renamed from: n  reason: collision with root package name */
    private int f23898n;

    /* renamed from: o  reason: collision with root package name */
    private long f23899o;

    public boolean a() {
        return super.a() && this.f23898n == 0;
    }

    public ByteBuffer b() {
        int i2;
        if (super.a() && (i2 = this.f23898n) > 0) {
            k(i2).put(this.f23897m, 0, this.f23898n).flip();
            this.f23898n = 0;
        }
        return super.b();
    }

    public void c(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (i2 != 0) {
            int min = Math.min(i2, this.f23896l);
            this.f23899o += (long) (min / this.f23736b.f23685d);
            this.f23896l -= min;
            byteBuffer.position(position + min);
            if (this.f23896l <= 0) {
                int i3 = i2 - min;
                int length = (this.f23898n + i3) - this.f23897m.length;
                ByteBuffer k2 = k(length);
                int q2 = Util.q(length, 0, this.f23898n);
                k2.put(this.f23897m, 0, q2);
                int q3 = Util.q(length - q2, 0, i3);
                byteBuffer.limit(byteBuffer.position() + q3);
                k2.put(byteBuffer);
                byteBuffer.limit(limit);
                int i4 = i3 - q3;
                int i5 = this.f23898n - q2;
                this.f23898n = i5;
                byte[] bArr = this.f23897m;
                System.arraycopy(bArr, q2, bArr, 0, i5);
                byteBuffer.get(this.f23897m, this.f23898n, i4);
                this.f23898n += i4;
                k2.flip();
            }
        }
    }

    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f23684c == 2) {
            this.f23895k = true;
            if (this.f23893i == 0 && this.f23894j == 0) {
                return AudioProcessor.AudioFormat.f23681e;
            }
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (this.f23895k) {
            this.f23895k = false;
            int i2 = this.f23894j;
            int i3 = this.f23736b.f23685d;
            this.f23897m = new byte[(i2 * i3)];
            this.f23896l = this.f23893i * i3;
        }
        this.f23898n = 0;
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (this.f23895k) {
            int i2 = this.f23898n;
            if (i2 > 0) {
                this.f23899o += (long) (i2 / this.f23736b.f23685d);
            }
            this.f23898n = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f23897m = Util.f28813f;
    }

    public long l() {
        return this.f23899o;
    }

    public void m() {
        this.f23899o = 0;
    }

    public void n(int i2, int i3) {
        this.f23893i = i2;
        this.f23894j = i3;
    }
}
