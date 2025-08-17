package com.google.ar.core;

import com.google.ar.core.annotations.UsedByNative;
import java.util.Locale;

@UsedByNative("session_jni_wrapper.cc")
class Quaternion {

    /* renamed from: a  reason: collision with root package name */
    public static final Quaternion f30230a = new Quaternion();
    @UsedByNative("session_jni_wrapper.cc")

    /* renamed from: w  reason: collision with root package name */
    private float f30231w = 1.0f;
    @UsedByNative("session_jni_wrapper.cc")

    /* renamed from: x  reason: collision with root package name */
    private float f30232x = 0.0f;
    @UsedByNative("session_jni_wrapper.cc")

    /* renamed from: y  reason: collision with root package name */
    private float f30233y = 0.0f;
    @UsedByNative("session_jni_wrapper.cc")

    /* renamed from: z  reason: collision with root package name */
    private float f30234z = 0.0f;

    public Quaternion() {
        a(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public static Quaternion i(Quaternion quaternion, Quaternion quaternion2, float f2) {
        float f3;
        Quaternion quaternion3 = new Quaternion();
        float f4 = (quaternion.f30232x * quaternion2.f30232x) + (quaternion.f30233y * quaternion2.f30233y) + (quaternion.f30234z * quaternion2.f30234z) + (quaternion.f30231w * quaternion2.f30231w);
        if (f4 < 0.0f) {
            Quaternion quaternion4 = new Quaternion(quaternion2);
            f4 = -f4;
            quaternion4.f30232x = -quaternion4.f30232x;
            quaternion4.f30233y = -quaternion4.f30233y;
            quaternion4.f30234z = -quaternion4.f30234z;
            quaternion4.f30231w = -quaternion4.f30231w;
            quaternion2 = quaternion4;
        }
        float acos = (float) Math.acos((double) f4);
        float sqrt = (float) Math.sqrt((double) (1.0f - (f4 * f4)));
        if (((double) Math.abs(sqrt)) > 0.001d) {
            float f5 = 1.0f / sqrt;
            f2 = ((float) Math.sin((double) (f2 * acos))) * f5;
            f3 = ((float) Math.sin((double) ((1.0f - f2) * acos))) * f5;
        } else {
            f3 = 1.0f - f2;
        }
        float f6 = (quaternion.f30232x * f3) + (quaternion2.f30232x * f2);
        quaternion3.f30232x = f6;
        float f7 = (quaternion.f30233y * f3) + (quaternion2.f30233y * f2);
        quaternion3.f30233y = f7;
        float f8 = (quaternion.f30234z * f3) + (quaternion2.f30234z * f2);
        quaternion3.f30234z = f8;
        float f9 = (f3 * quaternion.f30231w) + (f2 * quaternion2.f30231w);
        quaternion3.f30231w = f9;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((((f6 * f6) + (f7 * f7)) + (f8 * f8)) + (f9 * f9))));
        quaternion3.f30232x *= sqrt2;
        quaternion3.f30233y *= sqrt2;
        quaternion3.f30234z *= sqrt2;
        quaternion3.f30231w *= sqrt2;
        return quaternion3;
    }

    public static void j(Quaternion quaternion, float[] fArr, int i2, float[] fArr2, int i3) {
        Quaternion quaternion2 = quaternion;
        float f2 = fArr[i2];
        float f3 = fArr[i2 + 1];
        float f4 = fArr[i2 + 2];
        float f5 = quaternion2.f30232x;
        float f6 = quaternion2.f30233y;
        float f7 = quaternion2.f30234z;
        float f8 = quaternion2.f30231w;
        float f9 = f6 * f4;
        float f10 = f7 * f3;
        float f11 = f8 * f3;
        float f12 = f7 * f2;
        float f13 = f5 * f4;
        float f14 = f8 * f4;
        float f15 = f5 * f3;
        float f16 = f6 * f2;
        float f17 = -f5;
        float f18 = f3 * f6;
        float f19 = f4 * f7;
        float f20 = ((f8 * f2) + f9) - f10;
        float f21 = -f7;
        float f22 = -f6;
        float f23 = (f14 + f15) - f16;
        float f24 = (f11 + f12) - f13;
        float f25 = ((f2 * f17) - f18) - f19;
        fArr2[i3] = (((f20 * f8) + (f25 * f17)) + (f24 * f21)) - (f23 * f22);
        fArr2[i3 + 1] = (((f24 * f8) + (f25 * f22)) + (f23 * f17)) - (f20 * f21);
        fArr2[i3 + 2] = (((f23 * f8) + (f25 * f21)) + (f20 * f22)) - (f24 * f17);
    }

    public final void a(float f2, float f3, float f4, float f5) {
        this.f30232x = f2;
        this.f30233y = f3;
        this.f30234z = f4;
        this.f30231w = f5;
    }

    public final float b() {
        return this.f30232x;
    }

    public final float c() {
        return this.f30233y;
    }

    public final float d() {
        return this.f30234z;
    }

    public final float e() {
        return this.f30231w;
    }

    public final void f(float[] fArr, int i2) {
        fArr[i2] = this.f30232x;
        fArr[i2 + 1] = this.f30233y;
        fArr[i2 + 2] = this.f30234z;
        fArr[i2 + 3] = this.f30231w;
    }

    public final Quaternion g() {
        return new Quaternion(-this.f30232x, -this.f30233y, -this.f30234z, this.f30231w);
    }

    public final Quaternion h(Quaternion quaternion) {
        Quaternion quaternion2 = new Quaternion();
        float f2 = this.f30232x;
        float f3 = quaternion.f30231w;
        float f4 = this.f30233y;
        float f5 = quaternion.f30234z;
        float f6 = this.f30234z;
        float f7 = quaternion.f30233y;
        float f8 = this.f30231w;
        quaternion2.f30232x = (((f2 * f3) + (f4 * f5)) - (f6 * f7)) + (quaternion.f30232x * f8);
        float f9 = this.f30232x;
        float f10 = -f9;
        float f11 = quaternion.f30232x;
        quaternion2.f30233y = (f10 * f5) + (f4 * f3) + (f6 * f11) + (f7 * f8);
        float f12 = quaternion.f30233y;
        float f13 = this.f30233y;
        quaternion2.f30234z = ((f9 * f12) - (f13 * f11)) + (f6 * f3) + (f5 * f8);
        quaternion2.f30231w = (((f10 * f11) - (f13 * f12)) - (this.f30234z * quaternion.f30234z)) + (f8 * f3);
        return quaternion2;
    }

    public final void k(float[] fArr, int i2) {
        float f2 = this.f30232x;
        float f3 = this.f30233y;
        float f4 = this.f30234z;
        float f5 = this.f30231w;
        float f6 = (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5);
        float f7 = 0.0f;
        if (f6 > 0.0f) {
            f7 = 2.0f / f6;
        }
        float f8 = f2 * f7;
        float f9 = f3 * f7;
        float f10 = f7 * f4;
        float f11 = f5 * f8;
        float f12 = f5 * f9;
        float f13 = f5 * f10;
        float f14 = f8 * f2;
        float f15 = f2 * f9;
        float f16 = f2 * f10;
        float f17 = f9 * f3;
        float f18 = f3 * f10;
        float f19 = f4 * f10;
        fArr[i2] = 1.0f - (f17 + f19);
        fArr[i2 + 4] = f15 - f13;
        fArr[i2 + 8] = f16 + f12;
        fArr[i2 + 1] = f15 + f13;
        fArr[i2 + 5] = 1.0f - (f19 + f14);
        fArr[i2 + 9] = f18 - f11;
        fArr[i2 + 2] = f16 - f12;
        fArr[i2 + 6] = f18 + f11;
        fArr[i2 + 10] = 1.0f - (f14 + f17);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "[%.3f, %.3f, %.3f, %.3f]", new Object[]{Float.valueOf(this.f30232x), Float.valueOf(this.f30233y), Float.valueOf(this.f30234z), Float.valueOf(this.f30231w)});
    }

    @UsedByNative("session_jni_wrapper.cc")
    public Quaternion(float f2, float f3, float f4, float f5) {
        a(f2, f3, f4, f5);
    }

    public Quaternion(Quaternion quaternion) {
        a(quaternion.f30232x, quaternion.f30233y, quaternion.f30234z, quaternion.f30231w);
    }
}
