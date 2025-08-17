package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Display;
import android.view.Surface;

public final class zzzf {
    private final zzyj zza = new zzyj();
    private final zzzb zzb;
    private final zzze zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzzf(Context context) {
        zzzb zzzb;
        zzze zzze = null;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            int i2 = zzfj.zza;
            zzzb = zzzd.zzc(applicationContext);
            if (zzzb == null) {
                zzzb = zzzc.zzc(applicationContext);
            }
        } else {
            zzzb = null;
        }
        this.zzb = zzzb;
        this.zzc = zzzb != null ? zzze.zza() : zzze;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* synthetic */ void zzb(zzzf zzzf, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzzf.zzk = refreshRate;
            zzzf.zzl = (refreshRate * 80) / 100;
            return;
        }
        zzer.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        zzzf.zzk = -9223372036854775807L;
        zzzf.zzl = -9223372036854775807L;
    }

    private final void zzk() {
        Surface surface;
        if (zzfj.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE && this.zzh != 0.0f) {
            this.zzh = 0.0f;
            zzza.zza(surface, 0.0f);
        }
    }

    private final void zzl() {
        this.zzm = 0;
        this.zzp = -1;
        this.zzn = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (java.lang.Math.abs(r0 - r10.zzg) >= r2) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r10.zza.zzb() >= 30) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzm() {
        /*
            r10 = this;
            int r0 = com.google.android.gms.internal.ads.zzfj.zza
            r1 = 30
            if (r0 < r1) goto L_0x006d
            android.view.Surface r0 = r10.zze
            if (r0 != 0) goto L_0x000b
            goto L_0x006d
        L_0x000b:
            com.google.android.gms.internal.ads.zzyj r0 = r10.zza
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzyj r0 = r10.zza
            float r0 = r0.zza()
            goto L_0x001c
        L_0x001a:
            float r0 = r10.zzf
        L_0x001c:
            float r2 = r10.zzg
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0023
            return
        L_0x0023:
            r3 = 1
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0058
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzyj r1 = r10.zza
            boolean r1 = r1.zzg()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzyj r1 = r10.zza
            long r6 = r1.zzd()
            r8 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x004b
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L_0x004b:
            float r1 = r10.zzg
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0063
            goto L_0x0064
        L_0x0058:
            if (r6 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzyj r2 = r10.zza
            int r2 = r2.zzb()
            if (r2 < r1) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = 0
        L_0x0064:
            if (r3 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            return
        L_0x0068:
            r10.zzg = r0
            r10.zzn(r5)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzf.zzm():void");
    }

    private final void zzn(boolean z2) {
        Surface surface;
        if (zzfj.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE) {
            float f2 = 0.0f;
            if (this.zzd) {
                float f3 = this.zzg;
                if (f3 != -1.0f) {
                    f2 = this.zzi * f3;
                }
            }
            if (z2 || this.zzh != f2) {
                this.zzh = f2;
                zzza.zza(surface, f2);
            }
        }
    }

    public final long zza(long j2) {
        long j3;
        if (this.zzp != -1 && this.zza.zzg()) {
            long zzc2 = this.zza.zzc();
            long j4 = this.zzq + ((long) (((float) (zzc2 * (this.zzm - this.zzp))) / this.zzi));
            if (Math.abs(j2 - j4) > 20000000) {
                zzl();
            } else {
                j2 = j4;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j2;
        zzze zzze = this.zzc;
        if (zzze == null || this.zzk == -9223372036854775807L) {
            return j2;
        }
        long j5 = zzze.zza;
        if (j5 == -9223372036854775807L) {
            return j2;
        }
        long j6 = this.zzk;
        long j7 = j5 + (((j2 - j5) / j6) * j6);
        if (j2 <= j7) {
            j3 = j7 - j6;
        } else {
            long j8 = j7;
            j7 = j6 + j7;
            j3 = j8;
        }
        long j9 = this.zzl;
        if (j7 - j2 >= j2 - j3) {
            j7 = j3;
        }
        return j7 - j9;
    }

    public final void zzc(float f2) {
        this.zzf = f2;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j2) {
        long j3 = this.zzn;
        if (j3 != -1) {
            this.zzp = j3;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j2 * 1000);
        zzm();
    }

    public final void zze(float f2) {
        this.zzi = f2;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzze zzze = this.zzc;
            zzze.getClass();
            zzze.zzb();
            this.zzb.zzb(new zzyz(this));
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzzb zzzb = this.zzb;
        if (zzzb != null) {
            zzzb.zza();
            zzze zzze = this.zzc;
            zzze.getClass();
            zzze.zzc();
        }
        zzk();
    }

    public final void zzi(Surface surface) {
        if (true == (surface instanceof zzyx)) {
            surface = null;
        }
        if (this.zze != surface) {
            zzk();
            this.zze = surface;
            zzn(true);
        }
    }

    public final void zzj(int i2) {
        if (this.zzj != i2) {
            this.zzj = i2;
            zzn(true);
        }
    }
}
