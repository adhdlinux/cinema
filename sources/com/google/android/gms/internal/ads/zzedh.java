package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.zzb;
import java.util.concurrent.Executor;

public final class zzedh implements zzeci {
    private final Context zza;
    private final zzcpy zzb;
    private final Executor zzc;

    public zzedh(Context context, zzcpy zzcpy, Executor executor) {
        this.zza = context;
        this.zzb = zzcpy;
        this.zzc = executor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza(com.google.android.gms.internal.ads.zzezz r7, com.google.android.gms.internal.ads.zzezn r8, com.google.android.gms.internal.ads.zzecf r9) throws com.google.android.gms.internal.ads.zzfan, com.google.android.gms.internal.ads.zzefu {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzhs
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r8.zzah
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfbd r0 = (com.google.android.gms.internal.ads.zzfbd) r0
            com.google.android.gms.internal.ads.zzbof r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0060 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0060 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x007f
            com.google.android.gms.internal.ads.zzfwm r0 = com.google.android.gms.internal.ads.zzfwc.zzh(r1)
            com.google.android.gms.internal.ads.zzedg r3 = new com.google.android.gms.internal.ads.zzedg
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzfwn r2 = com.google.android.gms.internal.ads.zzcae.zze
            com.google.android.gms.internal.ads.zzfwm r0 = com.google.android.gms.internal.ads.zzfwc.zzm(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x007f
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzfan r8 = new com.google.android.gms.internal.ads.zzfan
            r8.<init>(r7)
            throw r8
        L_0x0053:
            com.google.android.gms.internal.ads.zzfan r7 = new com.google.android.gms.internal.ads.zzfan
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0060:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzfan r8 = new com.google.android.gms.internal.ads.zzfan
            r8.<init>(r7)
            throw r8
        L_0x0067:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.internal.ads.zzbzr.zzg(r7)
            com.google.android.gms.internal.ads.zzfan r8 = new com.google.android.gms.internal.ads.zzfan
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0077:
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfbd r0 = (com.google.android.gms.internal.ads.zzfbd) r0
            android.view.View r2 = r0.zza()
        L_0x007f:
            com.google.android.gms.internal.ads.zzcpy r0 = r6.zzb
            com.google.android.gms.internal.ads.zzcrs r3 = new com.google.android.gms.internal.ads.zzcrs
            java.lang.String r4 = r9.zza
            r3.<init>(r7, r8, r4)
            com.google.android.gms.internal.ads.zzcpi r7 = new com.google.android.gms.internal.ads.zzcpi
            java.lang.Object r4 = r9.zzb
            com.google.android.gms.internal.ads.zzfbd r4 = (com.google.android.gms.internal.ads.zzfbd) r4
            com.google.android.gms.internal.ads.zzedf r5 = new com.google.android.gms.internal.ads.zzedf
            r5.<init>(r4)
            java.util.List r8 = r8.zzv
            r4 = 0
            java.lang.Object r8 = r8.get(r4)
            com.google.android.gms.internal.ads.zzezo r8 = (com.google.android.gms.internal.ads.zzezo) r8
            r7.<init>(r2, r1, r5, r8)
            com.google.android.gms.internal.ads.zzcpc r7 = r0.zza(r3, r7)
            com.google.android.gms.internal.ads.zzdco r8 = r7.zzg()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzcwf r8 = r7.zzd()
            com.google.android.gms.internal.ads.zzcnd r0 = new com.google.android.gms.internal.ads.zzcnd
            java.lang.Object r1 = r9.zzb
            com.google.android.gms.internal.ads.zzfbd r1 = (com.google.android.gms.internal.ads.zzfbd) r1
            r0.<init>(r1)
            java.util.concurrent.Executor r1 = r6.zzc
            r8.zzm(r0, r1)
            com.google.android.gms.internal.ads.zzcwq r8 = r9.zzc
            com.google.android.gms.internal.ads.zzedy r8 = (com.google.android.gms.internal.ads.zzedy) r8
            com.google.android.gms.internal.ads.zzehj r9 = r7.zzj()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzcpb r7 = r7.zza()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedh.zza(com.google.android.gms.internal.ads.zzezz, com.google.android.gms.internal.ads.zzezn, com.google.android.gms.internal.ads.zzecf):java.lang.Object");
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        zzq zza2;
        zzq zzq = zzezz.zza.zza.zze;
        if (zzq.zzn) {
            zza2 = new zzq(this.zza, zzb.zzd(zzq.zze, zzq.zzb));
        } else {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() || !zzezn.zzah) {
                zza2 = zzfam.zza(this.zza, zzezn.zzv);
            } else {
                zza2 = new zzq(this.zza, zzb.zze(zzq.zze, zzq.zzb));
            }
        }
        zzq zzq2 = zza2;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() || !zzezn.zzah) {
            ((zzfbd) zzecf.zzb).zzm(this.zza, zzq2, zzezz.zza.zza.zzd, zzezn.zzw.toString(), zzbu.zzl(zzezn.zzt), (zzboc) zzecf.zzc);
        } else {
            ((zzfbd) zzecf.zzb).zzn(this.zza, zzq2, zzezz.zza.zza.zzd, zzezn.zzw.toString(), zzbu.zzl(zzezn.zzt), (zzboc) zzecf.zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(View view, zzezn zzezn, Object obj) throws Exception {
        return zzfwc.zzh(zzcqp.zza(this.zza, view, zzezn));
    }
}
