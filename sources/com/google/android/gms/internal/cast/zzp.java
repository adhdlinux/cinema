package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class zzp {
    private static final Logger zza = new Logger("DialogDiscovery");
    private static final String zzb = "21.3.0";
    private static zzp zzc;
    private final zzf zzd;
    private final String zze;
    private final zzn zzf;
    private final Map zzg = Collections.synchronizedMap(new HashMap());
    private final Clock zzh;
    private String zzi;
    private long zzj = 1;
    private long zzk = 1;
    private long zzl = -1;
    private int zzm = -1;
    private int zzn = 0;
    private int zzo = 0;
    private int zzp = 1;

    private zzp(zzf zzf2, String str) {
        this.zzd = zzf2;
        this.zze = str;
        this.zzf = new zzn(this);
        this.zzh = DefaultClock.getInstance();
    }

    public static zzv zza() {
        zzp zzp2 = zzc;
        if (zzp2 == null) {
            return null;
        }
        return zzp2.zzf;
    }

    public static void zzg(zzf zzf2, String str) {
        if (zzc == null) {
            zzc = new zzp(zzf2, str);
        }
    }

    private final long zzh() {
        return this.zzh.currentTimeMillis();
    }

    private final zzo zzi(MediaRouter.RouteInfo routeInfo) {
        String str;
        String str2;
        CastDevice fromBundle = CastDevice.getFromBundle(routeInfo.i());
        if (fromBundle == null || fromBundle.getDeviceId() == null) {
            int i2 = this.zzn;
            this.zzn = i2 + 1;
            str = "UNKNOWN_DEVICE_ID" + i2;
        } else {
            str = fromBundle.getDeviceId();
        }
        if (fromBundle == null || fromBundle.zzc() == null) {
            int i3 = this.zzo;
            this.zzo = i3 + 1;
            str2 = "UNKNOWN_RECEIVER_METRICS_ID" + i3;
        } else {
            str2 = fromBundle.zzc();
        }
        if (!str.startsWith("UNKNOWN_DEVICE_ID") && this.zzg.containsKey(str)) {
            return (zzo) this.zzg.get(str);
        }
        zzo zzo2 = new zzo((String) Preconditions.checkNotNull(str2), zzh());
        this.zzg.put(str, zzo2);
        return zzo2;
    }

    private final zzmq zzj(zzmt zzmt) {
        zzmf zza2 = zzmg.zza();
        zza2.zzb(zzb);
        zza2.zza(this.zze);
        zzmp zzc2 = zzmq.zzc();
        zzc2.zzb((zzmg) zza2.zzp());
        if (zzmt != null) {
            CastContext sharedInstance = CastContext.getSharedInstance();
            boolean z2 = false;
            if (sharedInstance != null && sharedInstance.getCastOptions().zze()) {
                z2 = true;
            }
            zzmt.zzh(z2);
            zzmt.zzd(this.zzj);
            zzc2.zzg(zzmt);
        }
        return (zzmq) zzc2.zzp();
    }

    private final void zzk() {
        this.zzg.clear();
        this.zzi = "";
        this.zzj = -1;
        this.zzk = -1;
        this.zzl = -1;
        this.zzm = -1;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = 1;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzl(int i2) {
        zzk();
        this.zzi = UUID.randomUUID().toString();
        this.zzj = zzh();
        this.zzm = 1;
        this.zzp = 2;
        zzmt zza2 = zzmu.zza();
        zza2.zzg(this.zzi);
        zza2.zzd(this.zzj);
        zza2.zzb(1);
        this.zzd.zzd(zzj(zza2), 351);
    }

    /* access modifiers changed from: private */
    public final synchronized void zzm(MediaRouter.RouteInfo routeInfo) {
        if (this.zzp == 1) {
            this.zzd.zzd(zzj((zzmt) null), 353);
            return;
        }
        this.zzp = 4;
        zzmt zza2 = zzmu.zza();
        zza2.zzg(this.zzi);
        zza2.zzd(this.zzj);
        zza2.zze(this.zzk);
        zza2.zzf(this.zzl);
        zza2.zzb(this.zzm);
        zza2.zzc(zzh());
        ArrayList arrayList = new ArrayList();
        for (zzo zzo2 : this.zzg.values()) {
            zzmr zza3 = zzms.zza();
            zza3.zzb(zzo2.zza);
            zza3.zza(zzo2.zzb);
            arrayList.add((zzms) zza3.zzp());
        }
        zza2.zza(arrayList);
        if (routeInfo != null) {
            zza2.zzi(zzi(routeInfo).zza);
        }
        zzmq zzj2 = zzj(zza2);
        zzk();
        Logger logger = zza;
        int size = this.zzg.size();
        logger.d("logging ClientDiscoverySessionSummary. Device Count: " + size, new Object[0]);
        this.zzd.zzd(zzj2, 353);
    }

    /* access modifiers changed from: private */
    public final synchronized void zzn(List list) {
        if (this.zzp == 2) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                zzi((MediaRouter.RouteInfo) it2.next());
            }
            if (this.zzl < 0) {
                this.zzl = zzh();
            }
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzo() {
        if (this.zzp != 2) {
            this.zzd.zzd(zzj((zzmt) null), 352);
            return;
        }
        this.zzk = zzh();
        this.zzp = 3;
        zzmt zza2 = zzmu.zza();
        zza2.zzg(this.zzi);
        zza2.zze(this.zzk);
        this.zzd.zzd(zzj(zza2), 352);
    }
}
