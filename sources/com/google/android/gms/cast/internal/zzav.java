package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzdy;
import java.util.Locale;

public final class zzav {
    public static final Object zza = new Object();
    private static final Logger zze = new Logger("RequestTracker");
    @VisibleForTesting
    long zzb = -1;
    @VisibleForTesting
    zzat zzc;
    @VisibleForTesting
    Runnable zzd;
    private final long zzf;
    private final Handler zzg = new zzdy(Looper.getMainLooper());

    public zzav(long j2) {
        this.zzf = j2;
    }

    public static /* synthetic */ void zza(zzav zzav) {
        synchronized (zza) {
            if (zzav.zzb != -1) {
                zzav.zzh(15, (Object) null);
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final void zzg(int r4, java.lang.Object r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.cast.internal.Logger r0 = zze
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.d(r6, r1)
            java.lang.Object r6 = zza
            monitor-enter(r6)
            com.google.android.gms.cast.internal.zzat r0 = r3.zzc     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0014
            long r1 = r3.zzb     // Catch:{ all -> 0x002f }
            r0.zza(r1, r4, r5)     // Catch:{ all -> 0x002f }
        L_0x0014:
            r4 = -1
            r3.zzb = r4     // Catch:{ all -> 0x002f }
            r4 = 0
            r3.zzc = r4     // Catch:{ all -> 0x002f }
            monitor-enter(r6)     // Catch:{ all -> 0x002f }
            java.lang.Runnable r5 = r3.zzd     // Catch:{ all -> 0x002c }
            if (r5 != 0) goto L_0x0022
            monitor-exit(r6)     // Catch:{ all -> 0x002c }
            goto L_0x002a
        L_0x0022:
            android.os.Handler r0 = r3.zzg     // Catch:{ all -> 0x002c }
            r0.removeCallbacks(r5)     // Catch:{ all -> 0x002c }
            r3.zzd = r4     // Catch:{ all -> 0x002c }
            monitor-exit(r6)     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r6)     // Catch:{ all -> 0x002f }
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x002c }
            throw r4     // Catch:{ all -> 0x002f }
        L_0x002f:
            r4 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x002f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzav.zzg(int, java.lang.Object, java.lang.String):void");
    }

    private final boolean zzh(int i2, Object obj) {
        synchronized (zza) {
            long j2 = this.zzb;
            if (j2 == -1) {
                return false;
            }
            zzg(i2, (Object) null, String.format(Locale.ROOT, "clearing request %d", new Object[]{Long.valueOf(j2)}));
            return true;
        }
    }

    public final void zzb(long j2, zzat zzat) {
        zzat zzat2;
        long j3;
        Object obj = zza;
        synchronized (obj) {
            zzat2 = this.zzc;
            j3 = this.zzb;
            this.zzb = j2;
            this.zzc = zzat;
        }
        if (zzat2 != null) {
            zzat2.zzb(j3);
        }
        synchronized (obj) {
            Runnable runnable = this.zzd;
            if (runnable != null) {
                this.zzg.removeCallbacks(runnable);
            }
            zzau zzau = new zzau(this);
            this.zzd = zzau;
            this.zzg.postDelayed(zzau, this.zzf);
        }
    }

    public final boolean zzc(int i2) {
        return zzh(2002, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(long r8, int r10, java.lang.Object r11) {
        /*
            r7 = this;
            java.lang.Object r0 = zza
            monitor-enter(r0)
            long r1 = r7.zzb     // Catch:{ all -> 0x0028 }
            r3 = -1
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0026
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0026
            java.util.Locale r1 = java.util.Locale.ROOT     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "request %d completed"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0028 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0028 }
            r4[r5] = r8     // Catch:{ all -> 0x0028 }
            java.lang.String r8 = java.lang.String.format(r1, r2, r4)     // Catch:{ all -> 0x0028 }
            r7.zzg(r10, r11, r8)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return r3
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return r5
        L_0x0028:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzav.zzd(long, int, java.lang.Object):boolean");
    }

    public final boolean zze() {
        boolean z2;
        synchronized (zza) {
            if (this.zzb != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public final boolean zzf(long j2) {
        boolean z2;
        synchronized (zza) {
            long j3 = this.zzb;
            z2 = false;
            if (j3 != -1 && j3 == j2) {
                z2 = true;
            }
        }
        return z2;
    }
}
