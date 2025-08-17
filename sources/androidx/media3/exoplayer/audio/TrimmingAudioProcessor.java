package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

final class TrimmingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private int f5846i;

    /* renamed from: j  reason: collision with root package name */
    private int f5847j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5848k;

    /* renamed from: l  reason: collision with root package name */
    private int f5849l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f5850m = Util.f4719f;

    /* renamed from: n  reason: collision with root package name */
    private int f5851n;

    /* renamed from: o  reason: collision with root package name */
    private long f5852o;

    public boolean a() {
        return super.a() && this.f5851n == 0;
    }

    public ByteBuffer b() {
        int i2;
        if (super.a() && (i2 = this.f5851n) > 0) {
            k(i2).put(this.f5850m, 0, this.f5851n).flip();
            this.f5851n = 0;
        }
        return super.b();
    }

    public void c(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (i2 != 0) {
            int min = Math.min(i2, this.f5849l);
            this.f5852o += (long) (min / this.f4505b.f4503d);
            this.f5849l -= min;
            byteBuffer.position(position + min);
            if (this.f5849l <= 0) {
                int i3 = i2 - min;
                int length = (this.f5851n + i3) - this.f5850m.length;
                ByteBuffer k2 = k(length);
                int p2 = Util.p(length, 0, this.f5851n);
                k2.put(this.f5850m, 0, p2);
                int p3 = Util.p(length - p2, 0, i3);
                byteBuffer.limit(byteBuffer.position() + p3);
                k2.put(byteBuffer);
                byteBuffer.limit(limit);
                int i4 = i3 - p3;
                int i5 = this.f5851n - p2;
                this.f5851n = i5;
                byte[] bArr = this.f5850m;
                System.arraycopy(bArr, p2, bArr, 0, i5);
                byteBuffer.get(this.f5850m, this.f5851n, i4);
                this.f5851n += i4;
                k2.flip();
            }
        }
    }

    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f4502c == 2) {
            this.f5848k = true;
            if (this.f5846i == 0 && this.f5847j == 0) {
                return AudioProcessor.AudioFormat.f4499e;
            }
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (this.f5848k) {
            this.f5848k = false;
            int i2 = this.f5847j;
            int i3 = this.f4505b.f4503d;
            this.f5850m = new byte[(i2 * i3)];
            this.f5849l = this.f5846i * i3;
        }
        this.f5851n = 0;
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (this.f5848k) {
            int i2 = this.f5851n;
            if (i2 > 0) {
                this.f5852o += (long) (i2 / this.f4505b.f4503d);
            }
            this.f5851n = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f5850m = Util.f4719f;
    }

    public long l() {
        return this.f5852o;
    }

    public void m() {
        this.f5852o = 0;
    }

    public void n(int i2, int i3) {
        this.f5846i = i2;
        this.f5847j = i3;
    }
}
