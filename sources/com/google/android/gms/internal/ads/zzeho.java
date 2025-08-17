package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzeho implements zzecc {
    private final Context zza;
    private final zzcpy zzb;
    private final zzbck zzc;
    private final zzfwn zzd;
    private final zzfel zze;

    public zzeho(Context context, zzcpy zzcpy, zzfel zzfel, zzfwn zzfwn, zzbck zzbck) {
        this.zza = context;
        this.zzb = zzcpy;
        this.zze = zzfel;
        this.zzd = zzfwn;
        this.zzc = zzbck;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        zzcpc zza2 = this.zzb.zza(new zzcrs(zzezz, zzezn, (String) null), new zzehm(this, new View(this.zza), (zzcez) null, zzehk.zza, (zzezo) zzezn.zzv.get(0)));
        zzehn zzk = zza2.zzk();
        zzezs zzezs = zzezn.zzt;
        zzbcf zzbcf = new zzbcf(zzk, zzezs.zzb, zzezs.zza);
        zzfel zzfel = this.zze;
        return zzfdv.zzd(new zzehl(this, zzbcf), this.zzd, zzfef.CUSTOM_RENDER_SYN, zzfel).zzb(zzfef.CUSTOM_RENDER_ACK).zzd(zzfwc.zzh(zza2.zza())).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzezz r1, com.google.android.gms.internal.ads.zzezn r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbck r1 = r0.zzc
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzezs r1 = r2.zzt
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeho.zzb(com.google.android.gms.internal.ads.zzezz, com.google.android.gms.internal.ads.zzezn):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbcf zzbcf) throws Exception {
        this.zzc.zze(zzbcf);
    }
}
