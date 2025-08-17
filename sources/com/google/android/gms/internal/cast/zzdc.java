package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzas;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzdc implements zzcz {
    private static final Logger zzb = new Logger("ConnectivityMonitor");
    @VisibleForTesting
    public final Set zza = Collections.synchronizedSet(new HashSet());
    private final zzqp zzc;
    private final ConnectivityManager.NetworkCallback zzd;
    private final ConnectivityManager zze;
    private final Map zzf;
    private final List zzg;
    private boolean zzh;
    private final Context zzi;
    private final Object zzj = new Object();

    @TargetApi(23)
    public zzdc(Context context, zzqp zzqp) {
        this.zzc = zzqp;
        this.zzi = context;
        this.zze = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzf = Collections.synchronizedMap(new HashMap());
        this.zzg = Collections.synchronizedList(new ArrayList());
        this.zzd = new zzdb(this);
    }

    static /* bridge */ /* synthetic */ void zzd(zzdc zzdc) {
        synchronized (Preconditions.checkNotNull(zzdc.zzj)) {
            if (zzdc.zzf != null) {
                if (zzdc.zzg != null) {
                    zzb.d("all networks are unavailable.", new Object[0]);
                    zzdc.zzf.clear();
                    zzdc.zzg.clear();
                    zzdc.zzh();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r4.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ void zze(com.google.android.gms.internal.cast.zzdc r4, android.net.Network r5) {
        /*
            java.lang.Object r0 = r4.zzj
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            monitor-enter(r0)
            java.util.Map r1 = r4.zzf     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x002c
            java.util.List r1 = r4.zzg     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0010
            goto L_0x002c
        L_0x0010:
            com.google.android.gms.cast.internal.Logger r1 = zzb     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "the network is lost"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x002e }
            r1.d(r2, r3)     // Catch:{ all -> 0x002e }
            java.util.List r1 = r4.zzg     // Catch:{ all -> 0x002e }
            boolean r1 = r1.remove(r5)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0027
            java.util.Map r1 = r4.zzf     // Catch:{ all -> 0x002e }
            r1.remove(r5)     // Catch:{ all -> 0x002e }
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            r4.zzh()
            return
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return
        L_0x002e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzdc.zze(com.google.android.gms.internal.cast.zzdc, android.net.Network):void");
    }

    /* access modifiers changed from: private */
    public final void zzg(Network network, LinkProperties linkProperties) {
        synchronized (Preconditions.checkNotNull(this.zzj)) {
            if (this.zzf != null) {
                if (this.zzg != null) {
                    zzb.d("a new network is available", new Object[0]);
                    if (this.zzf.containsKey(network)) {
                        this.zzg.remove(network);
                    }
                    this.zzf.put(network, linkProperties);
                    this.zzg.add(network);
                    zzh();
                }
            }
        }
    }

    private final void zzh() {
        if (this.zzc != null) {
            synchronized (this.zza) {
                for (zzcy zzcy : this.zza) {
                    if (!this.zzc.isShutdown()) {
                        this.zzc.execute(new zzda(this, zzcy));
                    }
                }
            }
        }
    }

    @TargetApi(23)
    public final void zza() {
        LinkProperties linkProperties;
        zzb.d("Start monitoring connectivity changes", new Object[0]);
        if (!this.zzh && this.zze != null && zzas.zza(this.zzi)) {
            Network a2 = this.zze.getActiveNetwork();
            if (!(a2 == null || (linkProperties = this.zze.getLinkProperties(a2)) == null)) {
                zzg(a2, linkProperties);
            }
            this.zze.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), this.zzd);
            this.zzh = true;
        }
    }

    public final boolean zzb() {
        NetworkInfo activeNetworkInfo;
        if (this.zze == null || !zzas.zza(this.zzi) || (activeNetworkInfo = this.zze.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public final boolean zzf() {
        List list = this.zzg;
        return list != null && !list.isEmpty();
    }
}
