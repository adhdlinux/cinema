package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class zzcby extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcbw {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzcbx zzb;
    private final float[] zzc = new float[9];
    private final float[] zzd = new float[9];
    private final float[] zze = new float[9];
    private final float[] zzf = new float[9];
    private final float[] zzg = new float[9];
    private final float[] zzh = new float[9];
    private final float[] zzi = new float[9];
    private float zzj = Float.NaN;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzcby(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zza;
        int length = fArr.length;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        zzcbx zzcbx = new zzcbx(context);
        this.zzb = zzcbx;
        zzcbx.zza(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", str + ": glError " + glGetError);
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        float f2 = fArr2[1];
        float f3 = fArr3[3];
        float f4 = fArr2[2];
        float f5 = fArr3[6];
        fArr[0] = (fArr2[0] * fArr3[0]) + (f2 * f3) + (f4 * f5);
        float f6 = fArr2[0];
        float f7 = fArr3[4];
        float f8 = fArr3[7];
        fArr[1] = (fArr3[1] * f6) + (f2 * f7) + (f4 * f8);
        float f9 = f6 * fArr3[2];
        float f10 = fArr2[1];
        float f11 = fArr3[5];
        float f12 = fArr3[8];
        fArr[2] = f9 + (f10 * f11) + (f4 * f12);
        float f13 = fArr2[3];
        float f14 = fArr3[0];
        float f15 = fArr2[4];
        float f16 = fArr2[5];
        fArr[3] = (f13 * f14) + (f3 * f15) + (f16 * f5);
        float f17 = fArr2[3];
        float f18 = fArr3[1];
        fArr[4] = (f17 * f18) + (f15 * f7) + (f16 * f8);
        float f19 = fArr3[2];
        fArr[5] = (f17 * f19) + (fArr2[4] * f11) + (f16 * f12);
        float f20 = fArr2[6] * f14;
        float f21 = fArr2[7];
        float f22 = fArr2[8];
        fArr[6] = f20 + (fArr3[3] * f21) + (f5 * f22);
        float f23 = fArr2[6];
        fArr[7] = (f18 * f23) + (f21 * fArr3[4]) + (f8 * f22);
        fArr[8] = (f23 * f19) + (fArr2[7] * fArr3[5]) + (f22 * f12);
    }

    private static final void zzj(float[] fArr, float f2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d2 = (double) f2;
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = (float) (-Math.sin(d2));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d2);
        fArr[8] = (float) Math.cos(d2);
    }

    private static final void zzk(float[] fArr, float f2) {
        double d2 = (double) f2;
        fArr[0] = (float) Math.cos(d2);
        fArr[1] = (float) (-Math.sin(d2));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d2);
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        zzh("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i2 + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01bf A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            android.graphics.SurfaceTexture r0 = r14.zzp
            if (r0 == 0) goto L_0x0379
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r14.zzw = r0
            java.lang.Object r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r1)
            r14.zzx = r0
            javax.microedition.khronos.egl.EGLDisplay r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r0 != r1) goto L_0x0020
        L_0x001d:
            r0 = 0
            goto L_0x0087
        L_0x0020:
            int[] r1 = new int[r3]
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzw
            boolean r0 = r7.eglInitialize(r0, r1)
            if (r0 != 0) goto L_0x002b
            goto L_0x001d
        L_0x002b:
            int[] r0 = new int[r5]
            javax.microedition.khronos.egl.EGLConfig[] r1 = new javax.microedition.khronos.egl.EGLConfig[r5]
            r7 = 11
            int[] r9 = new int[r7]
            r9 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzx
            r11 = 1
            r10 = r1
            r12 = r0
            boolean r7 = r7.eglChooseConfig(r8, r9, r10, r11, r12)
            if (r7 != 0) goto L_0x0045
        L_0x0043:
            r0 = r4
            goto L_0x004b
        L_0x0045:
            r0 = r0[r6]
            if (r0 <= 0) goto L_0x0043
            r0 = r1[r6]
        L_0x004b:
            if (r0 != 0) goto L_0x004e
            goto L_0x001d
        L_0x004e:
            int[] r1 = new int[r2]
            r1 = {12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzx
            javax.microedition.khronos.egl.EGLContext r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r1 = r7.eglCreateContext(r8, r0, r9, r1)
            r14.zzy = r1
            if (r1 == 0) goto L_0x001d
            javax.microedition.khronos.egl.EGLContext r7 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r1 != r7) goto L_0x0066
            goto L_0x001d
        L_0x0066:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzx
            android.graphics.SurfaceTexture r8 = r14.zzp
            javax.microedition.khronos.egl.EGLSurface r0 = r1.eglCreateWindowSurface(r7, r0, r8, r4)
            r14.zzz = r0
            if (r0 == 0) goto L_0x001d
            javax.microedition.khronos.egl.EGLSurface r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r1) goto L_0x0079
            goto L_0x001d
        L_0x0079:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzx
            javax.microedition.khronos.egl.EGLContext r8 = r14.zzy
            boolean r0 = r1.eglMakeCurrent(r7, r0, r0, r8)
            if (r0 != 0) goto L_0x0086
            goto L_0x001d
        L_0x0086:
            r0 = 1
        L_0x0087:
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzbf
            com.google.android.gms.internal.ads.zzbbk r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r7 = r7.zzb(r1)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r1.zzm()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzbbk r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r7.zzb(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r1 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00aa:
            r7 = 35633(0x8b31, float:4.9932E-41)
            int r1 = zzl(r7, r1)
            if (r1 != 0) goto L_0x00b6
        L_0x00b3:
            r9 = 0
            goto L_0x0138
        L_0x00b6:
            com.google.android.gms.internal.ads.zzbbe r7 = com.google.android.gms.internal.ads.zzbbm.zzbg
            com.google.android.gms.internal.ads.zzbbk r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r8 = r8.zzb(r7)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r7.zzm()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzbbk r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r7 = r8.zzb(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00d9
        L_0x00d7:
            java.lang.String r7 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00d9:
            r8 = 35632(0x8b30, float:4.9931E-41)
            int r7 = zzl(r8, r7)
            if (r7 != 0) goto L_0x00e3
            goto L_0x00b3
        L_0x00e3:
            java.lang.String r8 = "createProgram"
            int r9 = android.opengl.GLES20.glCreateProgram()
            zzh(r8)
            if (r9 == 0) goto L_0x0138
            android.opengl.GLES20.glAttachShader(r9, r1)
            java.lang.String r1 = "attachShader"
            zzh(r1)
            android.opengl.GLES20.glAttachShader(r9, r7)
            java.lang.String r1 = "attachShader"
            zzh(r1)
            android.opengl.GLES20.glLinkProgram(r9)
            java.lang.String r1 = "linkProgram"
            zzh(r1)
            int[] r1 = new int[r5]
            r7 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r9, r7, r1, r6)
            java.lang.String r7 = "getProgramiv"
            zzh(r7)
            r1 = r1[r6]
            if (r1 == r5) goto L_0x0130
            java.lang.String r1 = "SphericalVideoRenderer"
            java.lang.String r7 = "Could not link program: "
            android.util.Log.e(r1, r7)
            java.lang.String r1 = android.opengl.GLES20.glGetProgramInfoLog(r9)
            java.lang.String r7 = "SphericalVideoRenderer"
            android.util.Log.e(r7, r1)
            android.opengl.GLES20.glDeleteProgram(r9)
            java.lang.String r1 = "deleteProgram"
            zzh(r1)
            goto L_0x00b3
        L_0x0130:
            android.opengl.GLES20.glValidateProgram(r9)
            java.lang.String r1 = "validateProgram"
            zzh(r1)
        L_0x0138:
            r14.zzq = r9
            android.opengl.GLES20.glUseProgram(r9)
            java.lang.String r1 = "useProgram"
            zzh(r1)
            int r1 = r14.zzq
            java.lang.String r7 = "aPosition"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r7)
            r9 = 3
            r10 = 5126(0x1406, float:7.183E-42)
            r11 = 0
            r12 = 12
            java.nio.FloatBuffer r13 = r14.zzt
            r8 = r1
            android.opengl.GLES20.glVertexAttribPointer(r8, r9, r10, r11, r12, r13)
            java.lang.String r7 = "vertexAttribPointer"
            zzh(r7)
            android.opengl.GLES20.glEnableVertexAttribArray(r1)
            java.lang.String r1 = "enableVertexAttribArray"
            zzh(r1)
            int[] r1 = new int[r5]
            android.opengl.GLES20.glGenTextures(r5, r1, r6)
            java.lang.String r7 = "genTextures"
            zzh(r7)
            r1 = r1[r6]
            r7 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r7, r1)
            java.lang.String r8 = "bindTextures"
            zzh(r8)
            r8 = 10240(0x2800, float:1.4349E-41)
            r9 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzh(r8)
            r8 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzh(r8)
            r8 = 10242(0x2802, float:1.4352E-41)
            r9 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzh(r8)
            r8 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r7 = "texParameteri"
            zzh(r7)
            int r7 = r14.zzq
            java.lang.String r8 = "uVMat"
            int r7 = android.opengl.GLES20.glGetUniformLocation(r7, r8)
            r14.zzr = r7
            r8 = 9
            float[] r8 = new float[r8]
            r8 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            android.opengl.GLES20.glUniformMatrix3fv(r7, r5, r6, r8, r6)
            int r7 = r14.zzq
            if (r0 == 0) goto L_0x034b
            if (r7 != 0) goto L_0x01c3
            goto L_0x034b
        L_0x01c3:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r1)
            r14.zzo = r0
            r0.setOnFrameAvailableListener(r14)
            java.util.concurrent.CountDownLatch r0 = r14.zzu
            r0.countDown()
            com.google.android.gms.internal.ads.zzcbx r0 = r14.zzb
            r0.zzb()
            r14.zzA = r5     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
        L_0x01d9:
            boolean r0 = r14.zzB     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            if (r0 != 0) goto L_0x02f6
        L_0x01dd:
            int r0 = r14.zzs     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            if (r0 <= 0) goto L_0x01ed
            android.graphics.SurfaceTexture r0 = r14.zzo     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r0 = r14.zzs     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r0 = r0 + -1
            r14.zzs = r0     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            goto L_0x01dd
        L_0x01ed:
            com.google.android.gms.internal.ads.zzcbx r0 = r14.zzb     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r1 = r14.zzc     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            boolean r0 = r0.zzd(r1)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r1 = 5
            r7 = 4
            r8 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            if (r0 == 0) goto L_0x0245
            float r0 = r14.zzj     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            if (r0 == 0) goto L_0x023a
            float[] r0 = r14.zzc     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r9 = r0[r6]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r10 = 0
            float r9 = r9 * r10
            r11 = r0[r5]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r12 = 1065353216(0x3f800000, float:1.0)
            float r11 = r11 * r12
            float r9 = r9 + r11
            r11 = r0[r3]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r11 = r11 * r10
            float r9 = r9 + r11
            r11 = r0[r2]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r11 = r11 * r10
            r13 = r0[r7]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r13 = r13 * r12
            float r11 = r11 + r13
            r12 = r0[r1]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r12 = r12 * r10
            float r11 = r11 + r12
            r10 = 6
            r10 = r0[r10]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r10 = 7
            r10 = r0[r10]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r10 = 8
            r0 = r0[r10]     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            double r10 = (double) r11     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            double r12 = (double) r9     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            double r9 = java.lang.Math.atan2(r10, r12)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r0 = (float) r9     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r0 = r0 + r8
            float r0 = -r0
            r14.zzj = r0     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
        L_0x023a:
            float[] r0 = r14.zzh     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r8 = r14.zzj     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r9 = r14.zzk     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r8 = r8 + r9
            zzk(r0, r8)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            goto L_0x0251
        L_0x0245:
            float[] r0 = r14.zzc     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            zzj(r0, r8)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r0 = r14.zzh     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r8 = r14.zzk     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            zzk(r0, r8)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
        L_0x0251:
            float[] r0 = r14.zzd     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r8 = 1070141403(0x3fc90fdb, float:1.5707964)
            zzj(r0, r8)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r0 = r14.zze     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r8 = r14.zzh     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r9 = r14.zzd     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            zzi(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r0 = r14.zzf     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r8 = r14.zzc     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r9 = r14.zze     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            zzi(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r0 = r14.zzg     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r8 = r14.zzl     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            zzj(r0, r8)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r0 = r14.zzi     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r8 = r14.zzg     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r9 = r14.zzf     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            zzi(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r0 = r14.zzr     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float[] r8 = r14.zzi     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r5, r6, r8, r6)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            android.opengl.GLES20.glDrawArrays(r1, r6, r7)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            java.lang.String r0 = "drawArrays"
            zzh(r0)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzw     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.zzx     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            javax.microedition.khronos.egl.EGLSurface r7 = r14.zzz     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r0.eglSwapBuffers(r1, r7)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            boolean r0 = r14.zzA     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            if (r0 == 0) goto L_0x02dc
            int r0 = r14.zzn     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r1 = r14.zzm     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            android.opengl.GLES20.glViewport(r6, r6, r0, r1)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            java.lang.String r0 = "viewport"
            zzh(r0)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r0 = r14.zzq     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            java.lang.String r1 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r1 = r14.zzq     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            java.lang.String r7 = "uFOVy"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r7)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r7 = r14.zzn     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r8 = r14.zzm     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            r9 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r7 <= r8) goto L_0x02cf
            android.opengl.GLES20.glUniform1f(r0, r9)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            int r0 = r14.zzm     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r0 = r0 * r9
            int r7 = r14.zzn     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r0 = r0 / r7
            android.opengl.GLES20.glUniform1f(r1, r0)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            goto L_0x02da
        L_0x02cf:
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r7 = r7 * r9
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            float r7 = r7 / r8
            android.opengl.GLES20.glUniform1f(r0, r7)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
            android.opengl.GLES20.glUniform1f(r1, r9)     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
        L_0x02da:
            r14.zzA = r6     // Catch:{ IllegalStateException -> 0x0325, all -> 0x0306 }
        L_0x02dc:
            java.lang.Object r0 = r14.zzv     // Catch:{ InterruptedException -> 0x01d9 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x01d9 }
            boolean r1 = r14.zzB     // Catch:{ all -> 0x02f3 }
            if (r1 != 0) goto L_0x02f0
            boolean r1 = r14.zzA     // Catch:{ all -> 0x02f3 }
            if (r1 != 0) goto L_0x02f0
            int r1 = r14.zzs     // Catch:{ all -> 0x02f3 }
            if (r1 != 0) goto L_0x02f0
            java.lang.Object r1 = r14.zzv     // Catch:{ all -> 0x02f3 }
            r1.wait()     // Catch:{ all -> 0x02f3 }
        L_0x02f0:
            monitor-exit(r0)     // Catch:{ all -> 0x02f3 }
            goto L_0x01d9
        L_0x02f3:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x02f3 }
            throw r1     // Catch:{ InterruptedException -> 0x01d9 }
        L_0x02f6:
            com.google.android.gms.internal.ads.zzcbx r0 = r14.zzb
            r0.zzc()
            android.graphics.SurfaceTexture r0 = r14.zzo
            r0.setOnFrameAvailableListener(r4)
            r14.zzo = r4
            r14.zzg()
            return
        L_0x0306:
            r0 = move-exception
            java.lang.String r1 = "SphericalVideoProcessor died."
            com.google.android.gms.internal.ads.zzbzr.zzh(r1, r0)     // Catch:{ all -> 0x033a }
            com.google.android.gms.internal.ads.zzbza r1 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x033a }
            java.lang.String r2 = "SphericalVideoProcessor.run.2"
            r1.zzu(r0, r2)     // Catch:{ all -> 0x033a }
            com.google.android.gms.internal.ads.zzcbx r0 = r14.zzb
            r0.zzc()
            android.graphics.SurfaceTexture r0 = r14.zzo
            r0.setOnFrameAvailableListener(r4)
            r14.zzo = r4
            r14.zzg()
            return
        L_0x0325:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.internal.ads.zzbzr.zzj(r0)     // Catch:{ all -> 0x033a }
            com.google.android.gms.internal.ads.zzcbx r0 = r14.zzb
            r0.zzc()
            android.graphics.SurfaceTexture r0 = r14.zzo
            r0.setOnFrameAvailableListener(r4)
            r14.zzo = r4
            r14.zzg()
            return
        L_0x033a:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcbx r1 = r14.zzb
            r1.zzc()
            android.graphics.SurfaceTexture r1 = r14.zzo
            r1.setOnFrameAvailableListener(r4)
            r14.zzo = r4
            r14.zzg()
            throw r0
        L_0x034b:
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzw
            int r0 = r0.eglGetError()
            java.lang.String r0 = android.opengl.GLUtils.getEGLErrorString(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "EGL initialization failed: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzbzr.zzg(r0)
            com.google.android.gms.internal.ads.zzbza r1 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r1.zzu(r2, r0)
            r14.zzg()
            java.util.concurrent.CountDownLatch r0 = r14.zzu
            r0.countDown()
            return
        L_0x0379:
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.internal.ads.zzbzr.zzg(r0)
            java.util.concurrent.CountDownLatch r0 = r14.zzu
            r0.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcby.run():void");
    }

    public final void zza() {
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    public final SurfaceTexture zzb() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzc(int i2, int i3) {
        synchronized (this.zzv) {
            this.zzn = i2;
            this.zzm = i3;
            this.zzA = true;
            this.zzv.notifyAll();
        }
    }

    public final void zzd(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.zzn = i2;
        this.zzm = i3;
        this.zzp = surfaceTexture;
    }

    public final void zze() {
        synchronized (this.zzv) {
            this.zzB = true;
            this.zzp = null;
            this.zzv.notifyAll();
        }
    }

    public final void zzf(float f2, float f3) {
        int i2 = this.zzn;
        int i3 = this.zzm;
        float f4 = f2 * 1.7453293f;
        float f5 = f3 * 1.7453293f;
        float f6 = i2 > i3 ? (float) i2 : (float) i3;
        this.zzk -= f4 / f6;
        float f7 = this.zzl - (f5 / f6);
        this.zzl = f7;
        if (f7 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f7 = -1.5707964f;
        }
        if (f7 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzz;
        boolean z2 = false;
        if (!(eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE))) {
            z2 = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            z2 |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return z2;
        }
        boolean eglTerminate = this.zzw.eglTerminate(eGLDisplay) | z2;
        this.zzx = null;
        return eglTerminate;
    }
}
