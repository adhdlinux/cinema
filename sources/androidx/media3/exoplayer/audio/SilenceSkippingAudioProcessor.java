package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.imageutils.JfifUtil;
import com.startapp.y1;
import java.nio.ByteBuffer;

public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private final float f5831i;

    /* renamed from: j  reason: collision with root package name */
    private final short f5832j;

    /* renamed from: k  reason: collision with root package name */
    private final int f5833k;

    /* renamed from: l  reason: collision with root package name */
    private final long f5834l;

    /* renamed from: m  reason: collision with root package name */
    private final long f5835m;

    /* renamed from: n  reason: collision with root package name */
    private int f5836n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5837o;

    /* renamed from: p  reason: collision with root package name */
    private int f5838p;

    /* renamed from: q  reason: collision with root package name */
    private long f5839q;

    /* renamed from: r  reason: collision with root package name */
    private int f5840r;

    /* renamed from: s  reason: collision with root package name */
    private byte[] f5841s;

    /* renamed from: t  reason: collision with root package name */
    private int f5842t;

    /* renamed from: u  reason: collision with root package name */
    private int f5843u;

    /* renamed from: v  reason: collision with root package name */
    private byte[] f5844v;

    public SilenceSkippingAudioProcessor() {
        this(100000, 0.2f, 2000000, 10, 1024);
    }

    private void A(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f5841s.length));
        int r2 = r(byteBuffer);
        if (r2 == byteBuffer.position()) {
            this.f5838p = 1;
        } else {
            byteBuffer.limit(Math.min(r2, byteBuffer.capacity()));
            w(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private static void B(byte[] bArr, int i2, int i3) {
        if (i3 >= 32767) {
            bArr[i2] = -1;
            bArr[i2 + 1] = Byte.MAX_VALUE;
        } else if (i3 <= -32768) {
            bArr[i2] = 0;
            bArr[i2 + 1] = y1.f36938c;
        } else {
            bArr[i2] = (byte) (i3 & JfifUtil.MARKER_FIRST_BYTE);
            bArr[i2 + 1] = (byte) (i3 >> 8);
        }
    }

    private void D(ByteBuffer byteBuffer) {
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (this.f5842t < this.f5841s.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        int limit = byteBuffer.limit();
        int s2 = s(byteBuffer);
        int position = s2 - byteBuffer.position();
        int i4 = this.f5842t;
        int i5 = this.f5843u;
        int i6 = i4 + i5;
        byte[] bArr = this.f5841s;
        if (i6 < bArr.length) {
            i2 = bArr.length - (i5 + i4);
            i3 = i4 + i5;
        } else {
            int length = i5 - (bArr.length - i4);
            i2 = i4 - length;
            i3 = length;
        }
        if (s2 < limit) {
            z3 = true;
        } else {
            z3 = false;
        }
        int min = Math.min(position, i2);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.f5841s, i3, min);
        int i7 = this.f5843u + min;
        this.f5843u = i7;
        if (i7 <= this.f5841s.length) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.h(z4);
        if (!z3 || position >= i2) {
            z5 = false;
        }
        y(z5);
        if (z5) {
            this.f5838p = 0;
            this.f5840r = 0;
        }
        byteBuffer.limit(limit);
    }

    private static int E(byte b2, byte b3) {
        return (b2 << 8) | (b3 & 255);
    }

    private int l(float f2) {
        return m((int) f2);
    }

    private int m(int i2) {
        int i3 = this.f5836n;
        return (i2 / i3) * i3;
    }

    private int n(int i2, int i3) {
        int i4 = this.f5833k;
        return i4 + ((((100 - i4) * (i2 * 1000)) / i3) / 1000);
    }

    private int o(int i2, int i3) {
        return (((this.f5833k - 100) * ((i2 * 1000) / i3)) / 1000) + 100;
    }

    private int p(int i2) {
        boolean z2;
        int q2 = ((q(this.f5835m) - this.f5840r) * this.f5836n) - (this.f5841s.length / 2);
        if (q2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        return l(Math.min((((float) i2) * this.f5831i) + 0.5f, (float) q2));
    }

    private int q(long j2) {
        return (int) ((j2 * ((long) this.f4505b.f4500a)) / 1000000);
    }

    private int r(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (u(byteBuffer.get(limit), byteBuffer.get(limit - 1))) {
                int i2 = this.f5836n;
                return ((limit / i2) * i2) + i2;
            }
        }
        return byteBuffer.position();
    }

    private int s(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (u(byteBuffer.get(position), byteBuffer.get(position - 1))) {
                int i2 = this.f5836n;
                return i2 * (position / i2);
            }
        }
        return byteBuffer.limit();
    }

    private boolean u(byte b2, byte b3) {
        return Math.abs(E(b2, b3)) > this.f5832j;
    }

    private void v(byte[] bArr, int i2, int i3) {
        int i4;
        if (i3 != 3) {
            for (int i5 = 0; i5 < i2; i5 += 2) {
                int E = E(bArr[i5 + 1], bArr[i5]);
                if (i3 == 0) {
                    i4 = o(i5, i2 - 1);
                } else if (i3 == 2) {
                    i4 = n(i5, i2 - 1);
                } else {
                    i4 = this.f5833k;
                }
                B(bArr, i5, (E * i4) / 100);
            }
        }
    }

    private void w(ByteBuffer byteBuffer) {
        k(byteBuffer.remaining()).put(byteBuffer).flip();
    }

    private void x(byte[] bArr, int i2, int i3) {
        boolean z2;
        if (i2 % this.f5836n == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.b(z2, "byteOutput size is not aligned to frame size " + i2);
        v(bArr, i2, i3);
        k(i2).put(bArr, 0, i2).flip();
    }

    private void y(boolean z2) {
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        int i4 = this.f5843u;
        byte[] bArr = this.f5841s;
        if (i4 == bArr.length || z2) {
            boolean z5 = false;
            if (this.f5840r == 0) {
                if (z2) {
                    z(i4, 3);
                    i2 = i4;
                } else {
                    if (i4 >= bArr.length / 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Assertions.h(z4);
                    i2 = this.f5841s.length / 2;
                    z(i2, 0);
                }
                i3 = i2;
            } else if (z2) {
                int length = i4 - (bArr.length / 2);
                int length2 = (bArr.length / 2) + length;
                int p2 = p(length) + (this.f5841s.length / 2);
                z(p2, 2);
                int i5 = length2;
                i3 = p2;
                i2 = i5;
            } else {
                i2 = i4 - (bArr.length / 2);
                i3 = p(i2);
                z(i3, 1);
            }
            if (i2 % this.f5836n == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.i(z3, "bytesConsumed is not aligned to frame size: %s" + i2);
            if (i4 >= i3) {
                z5 = true;
            }
            Assertions.h(z5);
            this.f5843u -= i2;
            int i6 = this.f5842t + i2;
            this.f5842t = i6;
            this.f5842t = i6 % this.f5841s.length;
            int i7 = this.f5840r;
            int i8 = this.f5836n;
            this.f5840r = i7 + (i3 / i8);
            this.f5839q += (long) ((i2 - i3) / i8);
        }
    }

    private void z(int i2, int i3) {
        boolean z2;
        boolean z3;
        if (i2 != 0) {
            boolean z4 = true;
            if (this.f5843u >= i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            if (i3 == 2) {
                int i4 = this.f5842t;
                int i5 = this.f5843u;
                int i6 = i4 + i5;
                byte[] bArr = this.f5841s;
                if (i6 <= bArr.length) {
                    System.arraycopy(bArr, (i4 + i5) - i2, this.f5844v, 0, i2);
                } else {
                    int length = i5 - (bArr.length - i4);
                    if (length >= i2) {
                        System.arraycopy(bArr, length - i2, this.f5844v, 0, i2);
                    } else {
                        int i7 = i2 - length;
                        System.arraycopy(bArr, bArr.length - i7, this.f5844v, 0, i7);
                        System.arraycopy(this.f5841s, 0, this.f5844v, i7, length);
                    }
                }
            } else {
                int i8 = this.f5842t;
                int i9 = i8 + i2;
                byte[] bArr2 = this.f5841s;
                if (i9 <= bArr2.length) {
                    System.arraycopy(bArr2, i8, this.f5844v, 0, i2);
                } else {
                    int length2 = bArr2.length - i8;
                    System.arraycopy(bArr2, i8, this.f5844v, 0, length2);
                    System.arraycopy(this.f5841s, 0, this.f5844v, length2, i2 - length2);
                }
            }
            if (i2 % this.f5836n == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.b(z3, "sizeToOutput is not aligned to frame size: " + i2);
            if (this.f5842t >= this.f5841s.length) {
                z4 = false;
            }
            Assertions.h(z4);
            x(this.f5844v, i2, i3);
        }
    }

    public void C(boolean z2) {
        this.f5837o = z2;
    }

    public void c(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !f()) {
            int i2 = this.f5838p;
            if (i2 == 0) {
                A(byteBuffer);
            } else if (i2 == 1) {
                D(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f4502c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        } else if (audioFormat.f4500a == -1) {
            return AudioProcessor.AudioFormat.f4499e;
        } else {
            return audioFormat;
        }
    }

    public void h() {
        if (isActive()) {
            this.f5836n = this.f4505b.f4501b * 2;
            int m2 = m(q(this.f5834l) / 2) * 2;
            if (this.f5841s.length != m2) {
                this.f5841s = new byte[m2];
                this.f5844v = new byte[m2];
            }
        }
        this.f5838p = 0;
        this.f5839q = 0;
        this.f5840r = 0;
        this.f5842t = 0;
        this.f5843u = 0;
    }

    public void i() {
        if (this.f5843u > 0) {
            y(true);
            this.f5840r = 0;
        }
    }

    public boolean isActive() {
        return super.isActive() && this.f5837o;
    }

    public void j() {
        this.f5837o = false;
        byte[] bArr = Util.f4719f;
        this.f5841s = bArr;
        this.f5844v = bArr;
    }

    public long t() {
        return this.f5839q;
    }

    public SilenceSkippingAudioProcessor(long j2, float f2, long j3, int i2, short s2) {
        boolean z2 = false;
        this.f5840r = 0;
        this.f5842t = 0;
        this.f5843u = 0;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            z2 = true;
        }
        Assertions.a(z2);
        this.f5834l = j2;
        this.f5831i = f2;
        this.f5835m = j3;
        this.f5833k = i2;
        this.f5832j = s2;
        byte[] bArr = Util.f4719f;
        this.f5841s = bArr;
        this.f5844v = bArr;
    }
}
