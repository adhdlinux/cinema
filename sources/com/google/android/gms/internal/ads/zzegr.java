package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzegr implements zzdew {
    private final Context zza;
    private final zzdni zzb;
    private final zzfai zzc;
    private final zzbzx zzd;
    private final zzezn zze;
    private final zzfwm zzf;
    private final zzcez zzg;
    private final zzbil zzh;
    private final boolean zzi;
    private final zzebl zzj;

    zzegr(Context context, zzdni zzdni, zzfai zzfai, zzbzx zzbzx, zzezn zzezn, zzfwm zzfwm, zzcez zzcez, zzbil zzbil, boolean z2, zzebl zzebl) {
        this.zza = context;
        this.zzb = zzdni;
        this.zzc = zzfai;
        this.zzd = zzbzx;
        this.zze = zzezn;
        this.zzf = zzfwm;
        this.zzg = zzcez;
        this.zzh = zzbil;
        this.zzi = z2;
        this.zzj = zzebl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r22, android.content.Context r23, com.google.android.gms.internal.ads.zzcvt r24) {
        /*
            r21 = this;
            r1 = r21
            com.google.android.gms.internal.ads.zzfwm r0 = r1.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzfwc.zzp(r0)
            com.google.android.gms.internal.ads.zzdmn r0 = (com.google.android.gms.internal.ads.zzdmn) r0
            com.google.android.gms.internal.ads.zzezn r2 = r1.zze     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzcez r3 = r1.zzg     // Catch:{ zzcfk -> 0x0107 }
            boolean r3 = r3.zzaB()     // Catch:{ zzcfk -> 0x0107 }
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcez r2 = r1.zzg     // Catch:{ zzcfk -> 0x0107 }
        L_0x0018:
            r11 = r2
            goto L_0x007e
        L_0x001a:
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzaJ     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzcfk -> 0x0107 }
            java.lang.Object r3 = r6.zzb(r3)     // Catch:{ zzcfk -> 0x0107 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzcfk -> 0x0107 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzcfk -> 0x0107 }
            if (r3 != 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzcez r2 = r1.zzg     // Catch:{ zzcfk -> 0x0107 }
            goto L_0x0018
        L_0x002f:
            com.google.android.gms.internal.ads.zzdni r3 = r1.zzb     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzfai r6 = r1.zzc     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.ads.internal.client.zzq r6 = r6.zze     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzcez r3 = r3.zza(r6, r5, r5)     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzddd r6 = r0.zzg()     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzbiz.zzb(r3, r6)     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzdnm r6 = new com.google.android.gms.internal.ads.zzdnm     // Catch:{ zzcfk -> 0x0107 }
            r6.<init>()     // Catch:{ zzcfk -> 0x0107 }
            android.content.Context r7 = r1.zza     // Catch:{ zzcfk -> 0x0107 }
            r8 = r3
            android.view.View r8 = (android.view.View) r8     // Catch:{ zzcfk -> 0x0107 }
            r6.zza(r7, r8)     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzdnh r7 = r0.zzl()     // Catch:{ zzcfk -> 0x0107 }
            boolean r8 = r1.zzi     // Catch:{ zzcfk -> 0x0107 }
            if (r8 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzbil r8 = r1.zzh     // Catch:{ zzcfk -> 0x0107 }
            goto L_0x0059
        L_0x0058:
            r8 = r5
        L_0x0059:
            r7.zzi(r3, r4, r8)     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzcgm r7 = r3.zzN()     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzegp r8 = new com.google.android.gms.internal.ads.zzegp     // Catch:{ zzcfk -> 0x0107 }
            r8.<init>(r6, r3)     // Catch:{ zzcfk -> 0x0107 }
            r7.zzA(r8)     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzcgm r6 = r3.zzN()     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzegq r7 = new com.google.android.gms.internal.ads.zzegq     // Catch:{ zzcfk -> 0x0107 }
            r7.<init>(r3)     // Catch:{ zzcfk -> 0x0107 }
            r6.zzG(r7)     // Catch:{ zzcfk -> 0x0107 }
            com.google.android.gms.internal.ads.zzezs r2 = r2.zzt     // Catch:{ zzcfk -> 0x0107 }
            java.lang.String r6 = r2.zzb     // Catch:{ zzcfk -> 0x0107 }
            java.lang.String r2 = r2.zza     // Catch:{ zzcfk -> 0x0107 }
            r3.zzab(r6, r2, r5)     // Catch:{ zzcfk -> 0x0107 }
            r11 = r3
        L_0x007e:
            r11.zzan(r4)
            com.google.android.gms.ads.internal.zzj r2 = new com.google.android.gms.ads.internal.zzj
            boolean r3 = r1.zzi
            r6 = 0
            if (r3 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzbil r3 = r1.zzh
            boolean r3 = r3.zze(r6)
            r13 = r3
            goto L_0x0091
        L_0x0090:
            r13 = 0
        L_0x0091:
            com.google.android.gms.ads.internal.zzt.zzp()
            android.content.Context r3 = r1.zza
            boolean r14 = com.google.android.gms.ads.internal.util.zzs.zzE(r3)
            boolean r3 = r1.zzi
            if (r3 == 0) goto L_0x00a6
            com.google.android.gms.internal.ads.zzbil r6 = r1.zzh
            boolean r6 = r6.zzd()
            r15 = r6
            goto L_0x00a7
        L_0x00a6:
            r15 = 0
        L_0x00a7:
            if (r3 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzbil r3 = r1.zzh
            float r3 = r3.zza()
            r16 = r3
            goto L_0x00b5
        L_0x00b2:
            r3 = 0
            r16 = 0
        L_0x00b5:
            com.google.android.gms.internal.ads.zzezn r3 = r1.zze
            r17 = -1
            boolean r6 = r3.zzP
            boolean r3 = r3.zzQ
            r12 = r2
            r18 = r22
            r19 = r6
            r20 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            if (r24 == 0) goto L_0x00cc
            r24.zzf()
        L_0x00cc:
            com.google.android.gms.ads.internal.zzt.zzi()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdel r9 = r0.zzh()
            com.google.android.gms.internal.ads.zzezn r0 = r1.zze
            int r12 = r0.zzR
            com.google.android.gms.internal.ads.zzbzx r13 = r1.zzd
            java.lang.String r14 = r0.zzC
            com.google.android.gms.internal.ads.zzezs r6 = r0.zzt
            java.lang.String r15 = r6.zzb
            java.lang.String r6 = r6.zza
            com.google.android.gms.internal.ads.zzfai r7 = r1.zzc
            java.lang.String r10 = r7.zzf
            boolean r0 = r0.zzaj
            if (r0 == 0) goto L_0x00ed
            com.google.android.gms.internal.ads.zzebl r5 = r1.zzj
        L_0x00ed:
            r20 = r5
            r8 = 0
            r0 = 0
            r7 = r3
            r5 = r10
            r10 = r0
            r0 = r15
            r15 = r2
            r16 = r0
            r17 = r6
            r18 = r5
            r19 = r24
            r7.<init>((com.google.android.gms.ads.internal.client.zza) r8, (com.google.android.gms.ads.internal.overlay.zzo) r9, (com.google.android.gms.ads.internal.overlay.zzz) r10, (com.google.android.gms.internal.ads.zzcez) r11, (int) r12, (com.google.android.gms.internal.ads.zzbzx) r13, (java.lang.String) r14, (com.google.android.gms.ads.internal.zzj) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (com.google.android.gms.internal.ads.zzcvt) r19, (com.google.android.gms.internal.ads.zzbrm) r20)
            r0 = r23
            com.google.android.gms.ads.internal.overlay.zzm.zza(r0, r3, r4)
            return
        L_0x0107:
            r0 = move-exception
            java.lang.String r2 = ""
            com.google.android.gms.internal.ads.zzbzr.zzh(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegr.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzcvt):void");
    }
}
