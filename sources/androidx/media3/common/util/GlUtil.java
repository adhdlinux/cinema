package androidx.media3.common.util;

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
    public static final int[] f4648a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f4649b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f4650c = {12445, 13120, 12344, 12344};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f4651d = {12445, 13632, 12344, 12344};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f4652e = {12344};

    public static final class GlException extends Exception {
        public GlException(String str) {
            super(str);
        }
    }

    private GlUtil() {
    }

    public static void a(int i2, int i3, int i4) throws GlException {
        GLES20.glBindTexture(i2, i3);
        b();
        GLES20.glTexParameteri(i2, 10240, i4);
        b();
        GLES20.glTexParameteri(i2, 10241, i4);
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
            String gluErrorString = GLU.gluErrorString(glGetError);
            if (gluErrorString == null) {
                gluErrorString = "error code: 0x" + Integer.toHexString(glGetError);
            }
            sb.append("glError: ");
            sb.append(gluErrorString);
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
        a(36197, g2, 9729);
        return g2;
    }

    public static int g() throws GlException {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    private static boolean h(String str) {
        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        if (eglQueryString == null || !eglQueryString.contains(str)) {
            return false;
        }
        return true;
    }

    public static boolean i(Context context) {
        int i2 = Util.f4714a;
        if (i2 < 24) {
            return false;
        }
        if (i2 < 26 && ("samsung".equals(Util.f4716c) || "XT1650".equals(Util.f4717d))) {
            return false;
        }
        if (i2 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return h("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean j() {
        return h("EGL_KHR_surfaceless_context");
    }

    public static void k(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
