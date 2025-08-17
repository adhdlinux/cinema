package androidx.media3.common.util;

import android.opengl.GLES20;
import androidx.media3.common.util.GlUtil;
import java.util.HashMap;
import java.util.Map;

public final class GlProgram {

    /* renamed from: a  reason: collision with root package name */
    private final int f4636a;

    /* renamed from: b  reason: collision with root package name */
    private final Attribute[] f4637b;

    /* renamed from: c  reason: collision with root package name */
    private final Uniform[] f4638c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Attribute> f4639d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Uniform> f4640e;

    private static final class Attribute {

        /* renamed from: a  reason: collision with root package name */
        public final String f4641a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4642b;

        private Attribute(String str, int i2) {
            this.f4641a = str;
            this.f4642b = i2;
        }

        public static Attribute a(int i2, int i3) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i2, 35722, iArr, 0);
            int i4 = iArr[0];
            byte[] bArr = new byte[i4];
            GLES20.glGetActiveAttrib(i2, i3, i4, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.h(bArr));
            return new Attribute(str, GlProgram.f(i2, str));
        }
    }

    private static final class Uniform {

        /* renamed from: a  reason: collision with root package name */
        public final String f4643a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4644b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4645c;

        /* renamed from: d  reason: collision with root package name */
        private final float[] f4646d = new float[16];

        /* renamed from: e  reason: collision with root package name */
        private final int[] f4647e = new int[4];

        private Uniform(String str, int i2, int i3) {
            this.f4643a = str;
            this.f4644b = i2;
            this.f4645c = i3;
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
        this.f4636a = glCreateProgram;
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
        this.f4639d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f4637b = new Attribute[iArr2[0]];
        for (int i2 = 0; i2 < iArr2[0]; i2++) {
            Attribute a2 = Attribute.a(this.f4636a, i2);
            this.f4637b[i2] = a2;
            this.f4639d.put(a2.f4641a, a2);
        }
        this.f4640e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f4636a, 35718, iArr3, 0);
        this.f4638c = new Uniform[iArr3[0]];
        for (int i3 = 0; i3 < iArr3[0]; i3++) {
            Uniform a3 = Uniform.a(this.f4636a, i3);
            this.f4638c[i3] = a3;
            this.f4640e.put(a3.f4643a, a3);
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
        GlUtil.c(z2, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: \n" + str);
        GLES20.glAttachShader(i2, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.b();
    }

    /* access modifiers changed from: private */
    public static int f(int i2, String str) {
        return GLES20.glGetAttribLocation(i2, str);
    }

    private int g(String str) {
        return f(this.f4636a, str);
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
        return i(this.f4636a, str);
    }
}
