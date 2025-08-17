package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

public final class zzdhj {
    zzbfs zza;
    zzbfp zzb;
    zzbgf zzc;
    zzbgc zzd;
    zzbla zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdhj zza(zzbfp zzbfp) {
        this.zzb = zzbfp;
        return this;
    }

    public final zzdhj zzb(zzbfs zzbfs) {
        this.zza = zzbfs;
        return this;
    }

    public final zzdhj zzc(String str, zzbfy zzbfy, zzbfv zzbfv) {
        this.zzf.put(str, zzbfy);
        if (zzbfv != null) {
            this.zzg.put(str, zzbfv);
        }
        return this;
    }

    public final zzdhj zzd(zzbla zzbla) {
        this.zze = zzbla;
        return this;
    }

    public final zzdhj zze(zzbgc zzbgc) {
        this.zzd = zzbgc;
        return this;
    }

    public final zzdhj zzf(zzbgf zzbgf) {
        this.zzc = zzbgf;
        return this;
    }

    public final zzdhl zzg() {
        return new zzdhl(this);
    }
}
