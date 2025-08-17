package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

public final class zzdhl {
    public static final zzdhl zza = new zzdhl(new zzdhj());
    private final zzbfs zzb;
    private final zzbfp zzc;
    private final zzbgf zzd;
    private final zzbgc zze;
    private final zzbla zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdhl(zzdhj zzdhj) {
        this.zzb = zzdhj.zza;
        this.zzc = zzdhj.zzb;
        this.zzd = zzdhj.zzc;
        this.zzg = new SimpleArrayMap(zzdhj.zzf);
        this.zzh = new SimpleArrayMap(zzdhj.zzg);
        this.zze = zzdhj.zzd;
        this.zzf = zzdhj.zze;
    }

    public final zzbfp zza() {
        return this.zzc;
    }

    public final zzbfs zzb() {
        return this.zzb;
    }

    public final zzbfv zzc(String str) {
        return (zzbfv) this.zzh.get(str);
    }

    public final zzbfy zzd(String str) {
        return (zzbfy) this.zzg.get(str);
    }

    public final zzbgc zze() {
        return this.zze;
    }

    public final zzbgf zzf() {
        return this.zzd;
    }

    public final zzbla zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i2 = 0; i2 < this.zzg.size(); i2++) {
            arrayList.add((String) this.zzg.j(i2));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
