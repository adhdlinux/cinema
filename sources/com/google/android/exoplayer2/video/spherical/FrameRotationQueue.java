package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;

final class FrameRotationQueue {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f28971a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f28972b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final TimedValueQueue<float[]> f28973c = new TimedValueQueue<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f28974d;

    public static void a(float[] fArr, float[] fArr2) {
        GlUtil.j(fArr);
        float f2 = fArr2[10];
        float f3 = fArr2[8];
        float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        float f4 = fArr2[10];
        fArr[0] = f4 / sqrt;
        float f5 = fArr2[8];
        fArr[2] = f5 / sqrt;
        fArr[8] = (-f5) / sqrt;
        fArr[10] = f4 / sqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f2 = fArr2[0];
        float f3 = -fArr2[1];
        float f4 = -fArr2[2];
        float length = Matrix.length(f2, f3, f4);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees((double) length), f2 / length, f3 / length, f4 / length);
            return;
        }
        GlUtil.j(fArr);
    }

    public boolean c(float[] fArr, long j2) {
        float[] j3 = this.f28973c.j(j2);
        if (j3 == null) {
            return false;
        }
        b(this.f28972b, j3);
        if (!this.f28974d) {
            a(this.f28971a, this.f28972b);
            this.f28974d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f28971a, 0, this.f28972b, 0);
        return true;
    }

    public void d() {
        this.f28973c.c();
        this.f28974d = false;
    }

    public void e(long j2, float[] fArr) {
        this.f28973c.a(j2, fArr);
    }
}
