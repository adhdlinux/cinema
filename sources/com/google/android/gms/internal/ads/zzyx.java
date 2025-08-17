package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

public final class zzyx extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzyv zzd;
    private boolean zze;

    /* synthetic */ zzyx(zzyv zzyv, SurfaceTexture surfaceTexture, boolean z2, zzyw zzyw) {
        super(surfaceTexture);
        this.zzd = zzyv;
        this.zza = z2;
    }

    public static zzyx zza(Context context, boolean z2) {
        int i2 = 0;
        boolean z3 = true;
        if (z2 && !zzb(context)) {
            z3 = false;
        }
        zzdy.zzf(z3);
        zzyv zzyv = new zzyv();
        if (z2) {
            i2 = zzb;
        }
        return zzyv.zza(i2);
    }

    public static synchronized boolean zzb(Context context) {
        int i2;
        int i3;
        synchronized (zzyx.class) {
            if (!zzc) {
                int i4 = zzfj.zza;
                if (i4 >= 24) {
                    if (i4 < 26) {
                        if (!"samsung".equals(zzfj.zzc)) {
                            if ("XT1650".equals(zzfj.zzd)) {
                            }
                        }
                    }
                    if (i4 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                        if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                            String eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                            i3 = 2;
                            if (eglQueryString2 != null && eglQueryString2.contains("EGL_KHR_surfaceless_context")) {
                                i3 = 1;
                            }
                            zzb = i3;
                            zzc = true;
                        }
                    }
                }
                i3 = 0;
                zzb = i3;
                zzc = true;
            }
            i2 = zzb;
        }
        if (i2 != 0) {
            return true;
        }
        return false;
    }

    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
