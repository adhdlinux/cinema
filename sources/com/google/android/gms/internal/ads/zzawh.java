package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzawh {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzawd(this);
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public zzawk zzd;
    private Context zze;
    /* access modifiers changed from: private */
    public zzawn zzf;

    static /* bridge */ /* synthetic */ void zzh(zzawh zzawh) {
        synchronized (zzawh.zzc) {
            zzawk zzawk = zzawh.zzd;
            if (zzawk != null) {
                if (zzawk.isConnected() || zzawh.zzd.isConnecting()) {
                    zzawh.zzd.disconnect();
                }
                zzawh.zzd = null;
                zzawh.zzf = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzc
            monitor-enter(r0)
            android.content.Context r1 = r3.zze     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzawk r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.zzawf r1 = new com.google.android.gms.internal.ads.zzawf     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzawg r2 = new com.google.android.gms.internal.ads.zzawg     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzawk r1 = r3.zzd(r1, r2)     // Catch:{ all -> 0x0023 }
            r3.zzd = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawh.zzl():void");
    }

    public final long zza(zzawl zzawl) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2;
            }
            if (this.zzd.zzp()) {
                try {
                    long zze2 = this.zzf.zze(zzawl);
                    return zze2;
                } catch (RemoteException e2) {
                    zzbzr.zzh("Unable to call into cache service.", e2);
                    return -2;
                }
            }
        }
    }

    public final zzawi zzb(zzawl zzawl) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                zzawi zzawi = new zzawi();
                return zzawi;
            }
            try {
                if (this.zzd.zzp()) {
                    zzawi zzg = this.zzf.zzg(zzawl);
                    return zzg;
                }
                zzawi zzf2 = this.zzf.zzf(zzawl);
                return zzf2;
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to call into cache service.", e2);
                return new zzawi();
            }
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final synchronized zzawk zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzawk(this.zze, zzt.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.zzc
            monitor-enter(r0)
            android.content.Context r1 = r2.zze     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zze = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzdU     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.zzl()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzdT     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzawe r3 = new com.google.android.gms.internal.ads.zzawe     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzauu r1 = com.google.android.gms.ads.internal.zzt.zzb()     // Catch:{ all -> 0x0048 }
            r1.zzc(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawh.zzi(android.content.Context):void");
    }

    public final void zzj() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdV)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzcae.zzd.schedule(this.zzb, ((Long) zzba.zzc().zzb(zzbbm.zzdW)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }
}
