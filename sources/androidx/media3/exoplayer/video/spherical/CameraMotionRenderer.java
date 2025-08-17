package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.source.MediaSource;
import e.x;
import java.nio.ByteBuffer;

public final class CameraMotionRenderer extends BaseRenderer {

    /* renamed from: s  reason: collision with root package name */
    private final DecoderInputBuffer f7792s = new DecoderInputBuffer(1);

    /* renamed from: t  reason: collision with root package name */
    private final ParsableByteArray f7793t = new ParsableByteArray();

    /* renamed from: u  reason: collision with root package name */
    private long f7794u;

    /* renamed from: v  reason: collision with root package name */
    private CameraMotionListener f7795v;

    /* renamed from: w  reason: collision with root package name */
    private long f7796w;

    public CameraMotionRenderer() {
        super(6);
    }

    private float[] c0(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f7793t.S(byteBuffer.array(), byteBuffer.limit());
        this.f7793t.U(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr[i2] = Float.intBitsToFloat(this.f7793t.u());
        }
        return fArr;
    }

    private void d0() {
        CameraMotionListener cameraMotionListener = this.f7795v;
        if (cameraMotionListener != null) {
            cameraMotionListener.c();
        }
    }

    /* access modifiers changed from: protected */
    public void O() {
        d0();
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) {
        this.f7796w = Long.MIN_VALUE;
        d0();
    }

    /* access modifiers changed from: protected */
    public void X(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f7794u = j3;
    }

    public boolean a() {
        return g();
    }

    public int c(Format format) {
        if ("application/x-camera-motion".equals(format.f4015n)) {
            return x.a(4);
        }
        return x.a(0);
    }

    public void f(long j2, long j3) {
        while (!g() && this.f7796w < 100000 + j2) {
            this.f7792s.clear();
            boolean z2 = false;
            if (Z(I(), this.f7792s, 0) == -4 && !this.f7792s.isEndOfStream()) {
                long j4 = this.f7792s.f5069f;
                this.f7796w = j4;
                if (j4 < K()) {
                    z2 = true;
                }
                if (this.f7795v != null && !z2) {
                    this.f7792s.g();
                    float[] c02 = c0((ByteBuffer) Util.i(this.f7792s.f5067d));
                    if (c02 != null) {
                        ((CameraMotionListener) Util.i(this.f7795v)).b(this.f7796w - this.f7794u, c02);
                    }
                }
            } else {
                return;
            }
        }
    }

    public String getName() {
        return "CameraMotionRenderer";
    }

    public boolean isReady() {
        return true;
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 8) {
            this.f7795v = (CameraMotionListener) obj;
        } else {
            super.j(i2, obj);
        }
    }
}
