package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public final class CameraMotionRenderer extends BaseRenderer {

    /* renamed from: o  reason: collision with root package name */
    private final DecoderInputBuffer f28966o = new DecoderInputBuffer(1);

    /* renamed from: p  reason: collision with root package name */
    private final ParsableByteArray f28967p = new ParsableByteArray();

    /* renamed from: q  reason: collision with root package name */
    private long f28968q;

    /* renamed from: r  reason: collision with root package name */
    private CameraMotionListener f28969r;

    /* renamed from: s  reason: collision with root package name */
    private long f28970s;

    public CameraMotionRenderer() {
        super(6);
    }

    private float[] N(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f28967p.S(byteBuffer.array(), byteBuffer.limit());
        this.f28967p.U(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr[i2] = Float.intBitsToFloat(this.f28967p.u());
        }
        return fArr;
    }

    private void O() {
        CameraMotionListener cameraMotionListener = this.f28969r;
        if (cameraMotionListener != null) {
            cameraMotionListener.c();
        }
    }

    /* access modifiers changed from: protected */
    public void D() {
        O();
    }

    /* access modifiers changed from: protected */
    public void F(long j2, boolean z2) {
        this.f28970s = Long.MIN_VALUE;
        O();
    }

    /* access modifiers changed from: protected */
    public void J(Format[] formatArr, long j2, long j3) {
        this.f28968q = j3;
    }

    public boolean a() {
        return g();
    }

    public int c(Format format) {
        if ("application/x-camera-motion".equals(format.f23071m)) {
            return b2.a(4);
        }
        return b2.a(0);
    }

    public void f(long j2, long j3) {
        while (!g() && this.f28970s < 100000 + j2) {
            this.f28966o.f();
            if (K(y(), this.f28966o, 0) == -4 && !this.f28966o.k()) {
                DecoderInputBuffer decoderInputBuffer = this.f28966o;
                this.f28970s = decoderInputBuffer.f23963f;
                if (this.f28969r != null && !decoderInputBuffer.j()) {
                    this.f28966o.r();
                    float[] N = N((ByteBuffer) Util.j(this.f28966o.f23961d));
                    if (N != null) {
                        ((CameraMotionListener) Util.j(this.f28969r)).b(this.f28970s - this.f28968q, N);
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
            this.f28969r = (CameraMotionListener) obj;
        } else {
            super.j(i2, obj);
        }
    }
}
