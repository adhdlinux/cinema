package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdxl extends zzdxr {
    private zzbtm zzh;

    zzdxl(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = zzt.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r4 = r3.zzc     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x0037
            r4 = 1
            r3.zzc = r4     // Catch:{ all -> 0x0039 }
            com.google.android.gms.internal.ads.zzbth r0 = r3.zzd     // Catch:{ RemoteException -> 0x002b, all -> 0x001a }
            com.google.android.gms.internal.ads.zzbtu r0 = r0.zzp()     // Catch:{ RemoteException -> 0x002b, all -> 0x001a }
            com.google.android.gms.internal.ads.zzbtm r1 = r3.zzh     // Catch:{ RemoteException -> 0x002b, all -> 0x001a }
            com.google.android.gms.internal.ads.zzdxq r2 = new com.google.android.gms.internal.ads.zzdxq     // Catch:{ RemoteException -> 0x002b, all -> 0x001a }
            r2.<init>(r3)     // Catch:{ RemoteException -> 0x002b, all -> 0x001a }
            r0.zze(r1, r2)     // Catch:{ RemoteException -> 0x002b, all -> 0x001a }
            monitor-exit(r3)
            return
        L_0x001a:
            r4 = move-exception
            java.lang.String r0 = "RemoteAdsServiceProxyClientTask.onConnected"
            com.google.android.gms.internal.ads.zzbza r1 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x0039 }
            r1.zzu(r4, r0)     // Catch:{ all -> 0x0039 }
            com.google.android.gms.internal.ads.zzcaj r0 = r3.zza     // Catch:{ all -> 0x0039 }
            r0.zze(r4)     // Catch:{ all -> 0x0039 }
            monitor-exit(r3)
            return
        L_0x002b:
            com.google.android.gms.internal.ads.zzcaj r0 = r3.zza     // Catch:{ all -> 0x0039 }
            com.google.android.gms.internal.ads.zzdwa r1 = new com.google.android.gms.internal.ads.zzdwa     // Catch:{ all -> 0x0039 }
            r1.<init>(r4)     // Catch:{ all -> 0x0039 }
            r0.zze(r1)     // Catch:{ all -> 0x0039 }
            monitor-exit(r3)
            return
        L_0x0037:
            monitor-exit(r3)
            return
        L_0x0039:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxl.onConnected(android.os.Bundle):void");
    }

    public final synchronized zzfwm zza(zzbtm zzbtm, long j2) {
        if (this.zzb) {
            return zzfwc.zzn(this.zza, j2, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbtm;
        zzb();
        zzfwm zzn = zzfwc.zzn(this.zza, j2, TimeUnit.MILLISECONDS, this.zzg);
        zzn.zzc(new zzdxk(this), zzcae.zzf);
        return zzn;
    }
}
