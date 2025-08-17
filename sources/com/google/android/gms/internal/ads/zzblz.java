package com.google.android.gms.internal.ads;

import java.util.ArrayList;

final class zzblz implements Runnable {
    final /* synthetic */ zzbmk zza;
    final /* synthetic */ zzblg zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzbml zze;

    zzblz(zzbml zzbml, zzbmk zzbmk, zzblg zzblg, ArrayList arrayList, long j2) {
        this.zze = zzbml;
        this.zza = zzbmk;
        this.zzb = zzblg;
        this.zzc = arrayList;
        this.zzd = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00af, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzbml r0 = r9.zze
            java.lang.Object r0 = r0.zza
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzbmk r1 = r9.zza     // Catch:{ all -> 0x00b0 }
            int r1 = r1.zze()     // Catch:{ all -> 0x00b0 }
            r2 = -1
            if (r1 == r2) goto L_0x00ae
            com.google.android.gms.internal.ads.zzbmk r1 = r9.zza     // Catch:{ all -> 0x00b0 }
            int r1 = r1.zze()     // Catch:{ all -> 0x00b0 }
            r2 = 1
            if (r1 != r2) goto L_0x001b
            goto L_0x00ae
        L_0x001b:
            com.google.android.gms.internal.ads.zzbmk r1 = r9.zza     // Catch:{ all -> 0x00b0 }
            r1.zzg()     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzfwn r1 = com.google.android.gms.internal.ads.zzcae.zze     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzblg r2 = r9.zzb     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbly r3 = new com.google.android.gms.internal.ads.zzbly     // Catch:{ all -> 0x00b0 }
            r3.<init>(r2)     // Catch:{ all -> 0x00b0 }
            r1.execute(r3)     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzd     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbmk r2 = r9.zza     // Catch:{ all -> 0x00b0 }
            int r2 = r2.zze()     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbml r3 = r9.zze     // Catch:{ all -> 0x00b0 }
            int r3 = r3.zzi     // Catch:{ all -> 0x00b0 }
            java.util.ArrayList r4 = r9.zzc     // Catch:{ all -> 0x00b0 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x0051
            java.lang.String r4 = ". Still waiting for the engine to be loaded"
            goto L_0x006d
        L_0x0051:
            java.util.ArrayList r4 = r9.zzc     // Catch:{ all -> 0x00b0 }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r5.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is "
            r5.append(r6)     // Catch:{ all -> 0x00b0 }
            r5.append(r4)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00b0 }
        L_0x006d:
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ all -> 0x00b0 }
            long r5 = r5.currentTimeMillis()     // Catch:{ all -> 0x00b0 }
            long r7 = r9.zzd     // Catch:{ all -> 0x00b0 }
            long r5 = r5 - r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r7.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r8 = "Could not finish the full JS engine loading in "
            r7.append(r8)     // Catch:{ all -> 0x00b0 }
            r7.append(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = " ms. JS engine session reference status(fullLoadTimeout) is "
            r7.append(r1)     // Catch:{ all -> 0x00b0 }
            r7.append(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = ". Update status(fullLoadTimeout) is "
            r7.append(r1)     // Catch:{ all -> 0x00b0 }
            r7.append(r3)     // Catch:{ all -> 0x00b0 }
            r7.append(r4)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = " ms. Total latency(fullLoadTimeout) is "
            r7.append(r1)     // Catch:{ all -> 0x00b0 }
            r7.append(r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = " ms at timeout. Rejecting."
            r7.append(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.ads.internal.util.zze.zza(r1)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x00ae:
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x00b0:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblz.run():void");
    }
}
