package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil;
import java.util.HashMap;
import java.util.Map;

public final class GlProgram {

    /* renamed from: a  reason: collision with root package name */
    private final int f28674a;

    /* renamed from: b  reason: collision with root package name */
    private final Attribute[] f28675b;

    /* renamed from: c  reason: collision with root package name */
    private final Uniform[] f28676c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Attribute> f28677d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Uniform> f28678e;

    private static final class Attribute {

        /* renamed from: a  reason: collision with root package name */
        public final String f28679a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28680b;

        /* renamed from: c  reason: collision with root package name */
        private final int f28681c;

        private Attribute(String str, int i2, int i3) {
            this.f28679a = str;
            this.f28680b = i2;
            this.f28681c = i3;
        }

        public static Attribute a(int i2, int i3) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i2, 35722, iArr, 0);
            int i4 = iArr[0];
            byte[] bArr = new byte[i4];
            GLES20.glGetActiveAttrib(i2, i3, i4, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.h(bArr));
            return new Attribute(str, i3, GlProgram.f(i2, str));
        }
    }

    private static final class Uniform {

        /* renamed from: a  reason: collision with root package name */
        public final String f28682a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28683b;

        /* renamed from: c  reason: collision with root package name */
        private final int f28684c;

        /* renamed from: d  reason: collision with root package name */
        private final float[] f28685d = new float[16];

        private Uniform(String str, int i2, int i3) {
            this.f28682a = str;
            this.f28683b = i2;
            this.f28684c = i3;
        }

        public static Uniform a(int i2, int i3) {
            int i4 = i2;
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i2, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i5 = iArr[0];
            byte[] bArr = new byte[i5];
            GLES20.glGetActiveUniform(i2, i3, i5, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.h(bArr));
            return new Uniform(str, GlProgram.i(i2, str), iArr2[0]);
        }
    }

    public GlProgram(String str, String str2) throws GlUtil.GlException {
        boolean z2;
        int glCreateProgram = GLES20.glCreateProgram();
        this.f28674a = glCreateProgram;
        GlUtil.b();
        d(glCreateProgram, 35633, str);
        d(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        GlUtil.c(z2, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.f28677d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f28675b = new Attribute[iArr2[0]];
        for (int i2 = 0; i2 < iArr2[0]; i2++) {
            Attribute a2 = Attribute.a(this.f28674a, i2);
            this.f28675b[i2] = a2;
            this.f28677d.put(a2.f28679a, a2);
        }
        this.f28678e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f28674a, 35718, iArr3, 0);
        this.f28676c = new Uniform[iArr3[0]];
        for (int i3 = 0; i3 < iArr3[0]; i3++) {
            Uniform a3 = Uniform.a(this.f28674a, i3);
            this.f28676c[i3] = a3;
            this.f28678e.put(a3.f28682a, a3);
        }
        GlUtil.b();
    }

    private static void d(int i2, int i3, String str) throws GlUtil.GlException {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        boolean z2 = true;
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            z2 = false;
        }
        GlUtil.c(z2, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i2, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.b();
    }

    /* access modifiers changed from: private */
    public static int f(int i2, String str) {
        return GLES20.glGetAttribLocation(i2, str);
    }

    private int g(String str) {
        return f(this.f28674a, str);
    }

    /* access modifiers changed from: private */
    public static int h(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] == 0) {
                return i2;
            }
        }
        return bArr.length;
    }

    /* access modifiers changed from: private */
    public static int i(int i2, String str) {
        return GLES20.glGetUniformLocation(i2, str);
    }

    public int e(String str) throws GlUtil.GlException {
        int g2 = g(str);
        GLES20.glEnableVertexAttribArray(g2);
        GlUtil.b();
        return g2;
    }

    public int j(String str) {
        return i(this.f28674a, str);
    }
}
