package com.google.android.gms.internal.cast;

import android.os.Bundle;
import com.google.android.gms.cast.internal.Logger;
import java.math.BigInteger;
import java.util.Map;

public final class zzm {
    private static final Logger zza = new Logger("ApplicationAnalyticsUtils");
    private static final String zzb = "21.3.0";
    private final String zzc;
    private final Map zzd;
    private final Map zze;

    public zzm(Bundle bundle, String str) {
        this.zzc = str;
        this.zzd = zzag.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR");
        this.zze = zzag.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON");
    }

    private final zzmp zzh(zzl zzl) {
        long j2;
        zzmp zzc2 = zzmq.zzc();
        zzc2.zzl(zzl.zzd);
        int i2 = zzl.zze;
        zzl.zze = i2 + 1;
        zzc2.zzi(i2);
        String str = zzl.zzc;
        if (str != null) {
            zzc2.zzj(str);
        }
        String str2 = zzl.zzh;
        if (str2 != null) {
            zzc2.zzh(str2);
        }
        zzmf zza2 = zzmg.zza();
        zza2.zzb(zzb);
        zza2.zza(this.zzc);
        zzc2.zzb((zzmg) zza2.zzp());
        zzmh zza3 = zzmi.zza();
        if (zzl.zzb != null) {
            zznb zza4 = zznc.zza();
            zza4.zza(zzl.zzb);
            zza3.zza((zznc) zza4.zzp());
        }
        zza3.zzf(false);
        String str3 = zzl.zzf;
        if (str3 != null) {
            try {
                String replace = str3.replace("-", "");
                j2 = new BigInteger(replace.substring(0, Math.min(16, replace.length())), 16).longValue();
            } catch (NumberFormatException e2) {
                zza.w(e2, "receiverSessionId %s is not valid for hash", str3);
                j2 = 0;
            }
            zza3.zzh(j2);
        }
        zza3.zzb(zzl.zzg);
        zza3.zzd(zzl.zzi);
        zza3.zze(zzl.zzj);
        zzc2.zzd(zza3);
        return zzc2;
    }

    private static void zzi(zzmp zzmp, boolean z2) {
        zzmh zzc2 = zzmi.zzc(zzmp.zza());
        zzc2.zzf(z2);
        zzmp.zzd(zzc2);
    }

    public final zzmq zza(zzl zzl) {
        return (zzmq) zzh(zzl).zzp();
    }

    public final zzmq zzb(zzl zzl, boolean z2) {
        zzmp zzh = zzh(zzl);
        zzi(zzh, z2);
        return (zzmq) zzh.zzp();
    }

    public final zzmq zzc(zzl zzl) {
        zzmp zzh = zzh(zzl);
        zzmh zzc2 = zzmi.zzc(zzh.zza());
        zzc2.zzg(10);
        zzh.zze((zzmi) zzc2.zzp());
        zzi(zzh, true);
        return (zzmq) zzh.zzp();
    }

    public final zzmq zzd(zzl zzl) {
        zzmp zzh = zzh(zzl);
        if (zzl.zzk == 1) {
            zzmh zzc2 = zzmi.zzc(zzh.zza());
            zzc2.zzg(17);
            zzh.zze((zzmi) zzc2.zzp());
        }
        return (zzmq) zzh.zzp();
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    @org.checkerframework.dataflow.qual.Pure
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.cast.zzmq zze(com.google.android.gms.internal.cast.zzl r4, int r5) {
        /*
            r3 = this;
            com.google.android.gms.internal.cast.zzmp r4 = r3.zzh(r4)
            com.google.android.gms.internal.cast.zzmi r0 = r4.zza()
            com.google.android.gms.internal.cast.zzmh r0 = com.google.android.gms.internal.cast.zzmi.zzc(r0)
            java.util.Map r1 = r3.zze
            if (r1 == 0) goto L_0x002e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x001b
            goto L_0x002e
        L_0x001b:
            java.util.Map r1 = r3.zze
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0030
        L_0x002e:
            int r1 = r5 + 10000
        L_0x0030:
            r0.zzg(r1)
            java.util.Map r1 = r3.zzd
            if (r1 == 0) goto L_0x0055
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0042
            goto L_0x0055
        L_0x0042:
            java.util.Map r5 = r3.zzd
            java.lang.Object r5 = r5.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x0057
        L_0x0055:
            int r5 = r5 + 10000
        L_0x0057:
            r0.zzc(r5)
            com.google.android.gms.internal.cast.zzsh r5 = r0.zzp()
            com.google.android.gms.internal.cast.zzmi r5 = (com.google.android.gms.internal.cast.zzmi) r5
            r4.zze(r5)
            com.google.android.gms.internal.cast.zzsh r4 = r4.zzp()
            com.google.android.gms.internal.cast.zzmq r4 = (com.google.android.gms.internal.cast.zzmq) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzm.zze(com.google.android.gms.internal.cast.zzl, int):com.google.android.gms.internal.cast.zzmq");
    }

    public final zzmq zzf(zzl zzl, int i2, int i3) {
        zzmp zzh = zzh(zzl);
        zzmh zzc2 = zzmi.zzc(zzh.zza());
        zzc2.zzj(i2);
        zzc2.zzi(i3);
        zzh.zze((zzmi) zzc2.zzp());
        return (zzmq) zzh.zzp();
    }

    public final zzmq zzg(zzl zzl, int i2) {
        zzmp zzh = zzh(zzl);
        zzmh zzc2 = zzmi.zzc(zzh.zza());
        zzc2.zzj(i2);
        zzh.zze((zzmi) zzc2.zzp());
        return (zzmq) zzh.zzp();
    }
}
