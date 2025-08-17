package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class zzbze implements zzaut {
    final zzbzb zza;
    final HashSet zzb = new HashSet();
    final HashSet zzc = new HashSet();
    private final Object zzd = new Object();
    private final zzg zze;
    private final zzbzc zzf;
    private boolean zzg = false;

    public zzbze(String str, zzg zzg2) {
        this.zza = new zzbzb(str, zzg2);
        this.zze = zzg2;
        this.zzf = new zzbzc();
    }

    public final void zza(boolean z2) {
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        if (z2) {
            if (currentTimeMillis - this.zze.zzd() > ((Long) zzba.zzc().zzb(zzbbm.zzaQ)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzc();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzt(currentTimeMillis);
        this.zze.zzJ(this.zza.zzd);
    }

    public final zzbyt zzb(Clock clock, String str) {
        return new zzbyt(clock, this, this.zzf.zza(), str);
    }

    public final String zzc() {
        return this.zzf.zzb();
    }

    public final void zzd(zzbyt zzbyt) {
        synchronized (this.zzd) {
            this.zzb.add(zzbyt);
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            this.zza.zzb();
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzi(zzl zzl, long j2) {
        synchronized (this.zzd) {
            this.zza.zzf(zzl, j2);
        }
    }

    public final void zzj(HashSet hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzk() {
        return this.zzg;
    }

    public final Bundle zzl(Context context, zzfbo zzfbo) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zza(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator it2 = this.zzc.iterator();
        if (!it2.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                arrayList.add(((zzbyt) it3.next()).zza());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzfbo.zzc(hashSet);
            return bundle;
        }
        zzbzd zzbzd = (zzbzd) it2.next();
        throw null;
    }
}
