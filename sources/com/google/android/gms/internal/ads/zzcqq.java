package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.zzt;

public final class zzcqq implements zzcwu, zzcwa {
    private final Context zza;
    private final zzcez zzb;
    private final zzezn zzc;
    private final zzbzx zzd;
    private zzfgw zze;
    private boolean zzf;

    public zzcqq(Context context, zzcez zzcez, zzezn zzezn, zzbzx zzbzx) {
        this.zza = context;
        this.zzb = zzcez;
        this.zzc = zzezn;
        this.zzd = zzbzx;
    }

    private final synchronized void zza() {
        zzeca zzeca;
        zzecb zzecb;
        if (this.zzc.zzU) {
            if (this.zzb != null) {
                if (zzt.zzA().zzj(this.zza)) {
                    zzbzx zzbzx = this.zzd;
                    String str = zzbzx.zzb + "." + zzbzx.zzc;
                    String zza2 = this.zzc.zzW.zza();
                    if (this.zzc.zzW.zzb() == 1) {
                        zzeca = zzeca.VIDEO;
                        zzecb = zzecb.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzeca = zzeca.HTML_DISPLAY;
                        if (this.zzc.zzf == 1) {
                            zzecb = zzecb.ONE_PIXEL;
                        } else {
                            zzecb = zzecb.BEGIN_TO_RENDER;
                        }
                    }
                    zzfgw zza3 = zzt.zzA().zza(str, this.zzb.zzG(), "", "javascript", zza2, zzecb, zzeca, this.zzc.zzam);
                    this.zze = zza3;
                    zzcez zzcez = this.zzb;
                    if (zza3 != null) {
                        zzt.zzA().zzh(this.zze, (View) zzcez);
                        this.zzb.zzap(this.zze);
                        zzt.zzA().zzi(this.zze);
                        this.zzf = true;
                        this.zzb.zzd("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzf     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0008
            r3.zza()     // Catch:{ all -> 0x0024 }
        L_0x0008:
            com.google.android.gms.internal.ads.zzezn r0 = r3.zzc     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.zzU     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzfgw r0 = r3.zze     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzcez r0 = r3.zzb     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "onSdkImpression"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x0024 }
            monitor-exit(r3)
            return
        L_0x0022:
            monitor-exit(r3)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqq.zzl():void");
    }

    public final synchronized void zzn() {
        if (!this.zzf) {
            zza();
        }
    }
}
