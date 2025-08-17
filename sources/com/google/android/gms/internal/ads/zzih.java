package com.google.android.gms.internal.ads;

import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.IOException;

public final class zzih extends zzcf {
    public static final zzn zzd = zzig.zza;
    private static final String zzl = Integer.toString(1001, 36);
    private static final String zzm = Integer.toString(1002, 36);
    private static final String zzn = Integer.toString(1003, 36);
    private static final String zzo = Integer.toString(GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION, 36);
    private static final String zzp = Integer.toString(1005, 36);
    private static final String zzq = Integer.toString(1006, 36);
    public final int zze;
    public final String zzf;
    public final int zzg;
    public final zzam zzh;
    public final int zzi;
    public final zzbw zzj;
    final boolean zzk;

    private zzih(int i2, Throwable th, int i3) {
        this(i2, th, (String) null, i3, (String) null, -1, (zzam) null, 4, false);
    }

    public static zzih zzb(Throwable th, String str, int i2, zzam zzam, int i3, boolean z2, int i4) {
        return new zzih(1, th, (String) null, i4, str, i2, zzam, zzam == null ? 4 : i3, z2);
    }

    public static zzih zzc(IOException iOException, int i2) {
        return new zzih(0, iOException, i2);
    }

    public static zzih zzd(RuntimeException runtimeException, int i2) {
        return new zzih(2, runtimeException, i2);
    }

    /* access modifiers changed from: package-private */
    public final zzih zza(zzbw zzbw) {
        String message = getMessage();
        int i2 = zzfj.zza;
        return new zzih(message, getCause(), this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, zzbw, this.zzc, this.zzk);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzih(int r14, java.lang.Throwable r15, java.lang.String r16, int r17, java.lang.String r18, int r19, com.google.android.gms.internal.ads.zzam r20, int r21, boolean r22) {
        /*
            r13 = this;
            r4 = r14
            r8 = r21
            if (r4 == 0) goto L_0x005f
            r0 = 1
            if (r4 == r0) goto L_0x000f
            java.lang.String r0 = "Unexpected runtime error"
            r5 = r18
            r6 = r19
            goto L_0x0065
        L_0x000f:
            java.lang.String r1 = java.lang.String.valueOf(r20)
            int r2 = com.google.android.gms.internal.ads.zzfj.zza
            if (r8 == 0) goto L_0x0034
            if (r8 == r0) goto L_0x0031
            r0 = 2
            if (r8 == r0) goto L_0x002e
            r0 = 3
            if (r8 == r0) goto L_0x002b
            r0 = 4
            if (r8 != r0) goto L_0x0025
            java.lang.String r0 = "YES"
            goto L_0x0036
        L_0x0025:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x002b:
            java.lang.String r0 = "NO_EXCEEDS_CAPABILITIES"
            goto L_0x0036
        L_0x002e:
            java.lang.String r0 = "NO_UNSUPPORTED_DRM"
            goto L_0x0036
        L_0x0031:
            java.lang.String r0 = "NO_UNSUPPORTED_TYPE"
            goto L_0x0036
        L_0x0034:
            java.lang.String r0 = "NO"
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r5 = r18
            r2.append(r5)
            java.lang.String r3 = " error, index="
            r2.append(r3)
            r6 = r19
            r2.append(r6)
            java.lang.String r3 = ", format="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = ", format_supported="
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0065
        L_0x005f:
            r5 = r18
            r6 = r19
            java.lang.String r0 = "Source error"
        L_0x0065:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0072
            java.lang.String r1 = ": null"
            java.lang.String r0 = r0.concat(r1)
        L_0x0072:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r2 = r15
            r3 = r17
            r4 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r12 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzih.<init>(int, java.lang.Throwable, java.lang.String, int, java.lang.String, int, com.google.android.gms.internal.ads.zzam, int, boolean):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzih(java.lang.String r9, java.lang.Throwable r10, int r11, int r12, java.lang.String r13, int r14, com.google.android.gms.internal.ads.zzam r15, int r16, com.google.android.gms.internal.ads.zzbw r17, long r18, boolean r20) {
        /*
            r8 = this;
            r6 = r8
            r7 = r20
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r18
            r0.<init>(r1, r2, r3, r4)
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x0017
            r2 = r12
            if (r2 != r1) goto L_0x0015
            r2 = 1
            goto L_0x0018
        L_0x0015:
            r3 = 0
            goto L_0x0019
        L_0x0017:
            r2 = r12
        L_0x0018:
            r3 = 1
        L_0x0019:
            com.google.android.gms.internal.ads.zzdy.zzd(r3)
            if (r10 != 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            com.google.android.gms.internal.ads.zzdy.zzd(r0)
            r6.zze = r2
            r0 = r13
            r6.zzf = r0
            r0 = r14
            r6.zzg = r0
            r0 = r15
            r6.zzh = r0
            r0 = r16
            r6.zzi = r0
            r0 = r17
            r6.zzj = r0
            r6.zzk = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzih.<init>(java.lang.String, java.lang.Throwable, int, int, java.lang.String, int, com.google.android.gms.internal.ads.zzam, int, com.google.android.gms.internal.ads.zzbw, long, boolean):void");
    }
}
