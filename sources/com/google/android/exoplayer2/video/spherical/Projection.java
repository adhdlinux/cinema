package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;

final class Projection {

    /* renamed from: a  reason: collision with root package name */
    public final Mesh f28982a;

    /* renamed from: b  reason: collision with root package name */
    public final Mesh f28983b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28984c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f28985d;

    public static final class Mesh {

        /* renamed from: a  reason: collision with root package name */
        private final SubMesh[] f28986a;

        public Mesh(SubMesh... subMeshArr) {
            this.f28986a = subMeshArr;
        }

        public SubMesh a(int i2) {
            return this.f28986a[i2];
        }

        public int b() {
            return this.f28986a.length;
        }
    }

    public static final class SubMesh {

        /* renamed from: a  reason: collision with root package name */
        public final int f28987a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28988b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f28989c;

        /* renamed from: d  reason: collision with root package name */
        public final float[] f28990d;

        public SubMesh(int i2, float[] fArr, float[] fArr2, int i3) {
            boolean z2;
            this.f28987a = i2;
            if (((long) fArr.length) * 2 == ((long) fArr2.length) * 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f28989c = fArr;
            this.f28990d = fArr2;
            this.f28988b = i3;
        }

        public int a() {
            return this.f28989c.length / 3;
        }
    }

    public Projection(Mesh mesh, int i2) {
        this(mesh, mesh, i2);
    }

    public static Projection a(float f2, int i2, int i3, float f3, float f4, int i4) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        float f5;
        float[] fArr;
        int i6;
        int i7;
        int i8;
        float f6 = f2;
        int i9 = i2;
        int i10 = i3;
        float f7 = f3;
        float f8 = f4;
        if (f6 > 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (i9 >= 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        if (i10 >= 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.a(z4);
        if (f7 <= 0.0f || f7 > 180.0f) {
            z5 = false;
        } else {
            z5 = true;
        }
        Assertions.a(z5);
        if (f8 <= 0.0f || f8 > 360.0f) {
            z6 = false;
        } else {
            z6 = true;
        }
        Assertions.a(z6);
        float radians = (float) Math.toRadians((double) f7);
        float radians2 = (float) Math.toRadians((double) f8);
        float f9 = radians / ((float) i9);
        float f10 = radians2 / ((float) i10);
        int i11 = i10 + 1;
        int i12 = ((i11 * 2) + 2) * i9;
        float[] fArr2 = new float[(i12 * 3)];
        float[] fArr3 = new float[(i12 * 2)];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < i9) {
            float f11 = radians / 2.0f;
            float f12 = (((float) i13) * f9) - f11;
            int i16 = i13 + 1;
            float f13 = (((float) i16) * f9) - f11;
            int i17 = 0;
            while (i17 < i11) {
                float f14 = f12;
                int i18 = i16;
                int i19 = 0;
                int i20 = 2;
                while (i19 < i20) {
                    if (i19 == 0) {
                        f5 = f14;
                        i5 = i11;
                    } else {
                        i5 = i11;
                        f5 = f13;
                    }
                    float f15 = ((float) i17) * f10;
                    float f16 = f10;
                    int i21 = i14 + 1;
                    int i22 = i17;
                    double d2 = (double) f6;
                    float f17 = f9;
                    double d3 = (double) ((f15 + 3.1415927f) - (radians2 / 2.0f));
                    int i23 = i19;
                    double d4 = (double) f5;
                    float[] fArr4 = fArr3;
                    float f18 = f13;
                    fArr2[i14] = -((float) (Math.sin(d3) * d2 * Math.cos(d4)));
                    int i24 = i21 + 1;
                    int i25 = i13;
                    fArr2[i21] = (float) (d2 * Math.sin(d4));
                    int i26 = i24 + 1;
                    fArr2[i24] = (float) (d2 * Math.cos(d3) * Math.cos(d4));
                    int i27 = i15 + 1;
                    fArr4[i15] = f15 / radians2;
                    int i28 = i27 + 1;
                    fArr4[i27] = (((float) (i25 + i23)) * f17) / radians;
                    if (i22 == 0 && i23 == 0) {
                        i8 = i3;
                        i7 = i22;
                        i6 = i23;
                    } else {
                        i8 = i3;
                        i7 = i22;
                        i6 = i23;
                        if (!(i7 == i8 && i6 == 1)) {
                            fArr = fArr4;
                            i15 = i28;
                            i14 = i26;
                            int i29 = i6 + 1;
                            fArr3 = fArr;
                            i13 = i25;
                            i11 = i5;
                            f10 = f16;
                            f9 = f17;
                            f13 = f18;
                            i20 = 2;
                            int i30 = i29;
                            i10 = i8;
                            i17 = i7;
                            i19 = i30;
                        }
                    }
                    System.arraycopy(fArr2, i26 - 3, fArr2, i26, 3);
                    i26 += 3;
                    fArr = fArr4;
                    System.arraycopy(fArr, i28 - 2, fArr, i28, 2);
                    i28 += 2;
                    i15 = i28;
                    i14 = i26;
                    int i292 = i6 + 1;
                    fArr3 = fArr;
                    i13 = i25;
                    i11 = i5;
                    f10 = f16;
                    f9 = f17;
                    f13 = f18;
                    i20 = 2;
                    int i302 = i292;
                    i10 = i8;
                    i17 = i7;
                    i19 = i302;
                }
                int i31 = i17;
                int i32 = i10;
                float f19 = f9;
                float f20 = f10;
                float[] fArr5 = fArr3;
                float f21 = f13;
                int i33 = i13;
                int i34 = i31 + 1;
                f12 = f14;
                i16 = i18;
                i11 = i11;
                f10 = f20;
                f13 = f21;
                int i35 = i34;
                i10 = i32;
                i17 = i35;
            }
            i9 = i2;
            i13 = i16;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr2, fArr3, 1)), i4);
    }

    public static Projection b(int i2) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i2);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i2) {
        this.f28982a = mesh;
        this.f28983b = mesh2;
        this.f28984c = i2;
        this.f28985d = mesh == mesh2;
    }
}
