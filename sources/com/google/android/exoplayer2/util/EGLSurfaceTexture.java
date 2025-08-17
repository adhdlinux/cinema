package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import com.google.android.exoplayer2.util.GlUtil;

public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f28664h = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: b  reason: collision with root package name */
    private final Handler f28665b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f28666c;

    /* renamed from: d  reason: collision with root package name */
    private EGLDisplay f28667d;

    /* renamed from: e  reason: collision with root package name */
    private EGLContext f28668e;

    /* renamed from: f  reason: collision with root package name */
    private EGLSurface f28669f;

    /* renamed from: g  reason: collision with root package name */
    private SurfaceTexture f28670g;

    public interface TextureImageListener {
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, (TextureImageListener) null);
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) throws GlUtil.GlException {
        boolean z2;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f28664h, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!eglChooseConfig || iArr[0] <= 0 || eGLConfigArr[0] == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        GlUtil.c(z2, Util.C("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        return eGLConfigArr[0];
    }

    private static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) throws GlUtil.GlException {
        int[] iArr;
        if (i2 == 0) {
            iArr = new int[]{12440, 2, 12344};
        } else {
            iArr = new int[]{12440, 2, 12992, 1, 12344};
        }
        boolean z2 = false;
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
        if (eglCreateContext != null) {
            z2 = true;
        }
        GlUtil.c(z2, "eglCreateContext failed");
        return eglCreateContext;
    }

    private static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i2) throws GlUtil.GlException {
        EGLSurface eGLSurface;
        int[] iArr;
        boolean z2 = true;
        if (i2 == 1) {
            eGLSurface = EGL14.EGL_NO_SURFACE;
        } else {
            if (i2 == 2) {
                iArr = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                iArr = new int[]{12375, 1, 12374, 1, 12344};
            }
            eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr, 0);
            if (eGLSurface == null) {
                z2 = false;
            }
            GlUtil.c(z2, "eglCreatePbufferSurface failed");
        }
        GlUtil.c(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext), "eglMakeCurrent failed");
        return eGLSurface;
    }

    private void d() {
    }

    private static void e(int[] iArr) throws GlUtil.GlException {
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.b();
    }

    private static EGLDisplay f() throws GlUtil.GlException {
        boolean z2;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        GlUtil.c(z2, "eglGetDisplay failed");
        int[] iArr = new int[2];
        GlUtil.c(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
        return eglGetDisplay;
    }

    public SurfaceTexture g() {
        return (SurfaceTexture) Assertions.e(this.f28670g);
    }

    public void h(int i2) throws GlUtil.GlException {
        EGLDisplay f2 = f();
        this.f28667d = f2;
        EGLConfig a2 = a(f2);
        EGLContext b2 = b(this.f28667d, a2, i2);
        this.f28668e = b2;
        this.f28669f = c(this.f28667d, a2, b2, i2);
        e(this.f28666c);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f28666c[0]);
        this.f28670g = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public void i() {
        this.f28665b.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f28670g;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f28666c, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f28667d;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f28667d;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f28669f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f28667d, this.f28669f);
            }
            EGLContext eGLContext = this.f28668e;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f28667d, eGLContext);
            }
            if (Util.f28808a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f28667d;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f28667d);
            }
            this.f28667d = null;
            this.f28668e = null;
            this.f28669f = null;
            this.f28670g = null;
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f28665b.post(this);
    }

    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.f28670g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, TextureImageListener textureImageListener) {
        this.f28665b = handler;
        this.f28666c = new int[1];
    }
}
