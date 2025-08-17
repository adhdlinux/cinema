package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class GlUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f28686a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f28687b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f28688c = {12344};

    public static final class GlException extends Exception {
        public GlException(String str) {
            super(str);
        }
    }

    private GlUtil() {
    }

    public static void a(int i2, int i3) throws GlException {
        GLES20.glBindTexture(i2, i3);
        b();
        GLES20.glTexParameteri(i2, 10240, 9729);
        b();
        GLES20.glTexParameteri(i2, 10241, 9729);
        b();
        GLES20.glTexParameteri(i2, 10242, 33071);
        b();
        GLES20.glTexParameteri(i2, 10243, 33071);
        b();
    }

    public static void b() throws GlException {
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z2) {
                sb.append(10);
            }
            sb.append("glError: ");
            sb.append(GLU.gluErrorString(glGetError));
            z2 = true;
        }
        if (z2) {
            throw new GlException(sb.toString());
        }
    }

    public static void c(boolean z2, String str) throws GlException {
        if (!z2) {
            throw new GlException(str);
        }
    }

    private static FloatBuffer d(int i2) {
        return ByteBuffer.allocateDirect(i2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) d(fArr.length).put(fArr).flip();
    }

    public static int f() throws GlException {
        int g2 = g();
        a(36197, g2);
        return g2;
    }

    private static int g() throws GlException {
        c(!Util.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    public static boolean h(Context context) {
        String eglQueryString;
        int i2 = Util.f28808a;
        if (i2 < 24) {
            return false;
        }
        if (i2 < 26 && ("samsung".equals(Util.f28810c) || "XT1650".equals(Util.f28811d))) {
            return false;
        }
        if ((i2 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content")) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        String eglQueryString;
        if (Util.f28808a >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_KHR_surfaceless_context")) {
            return true;
        }
        return false;
    }

    public static void j(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
