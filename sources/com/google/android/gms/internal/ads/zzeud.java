package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.HashSet;
import java.util.concurrent.Executor;

public final class zzeud implements zzgwe {
    public static zzerb zza(Context context, zzbyo zzbyo, zzbyp zzbyp, Object obj, zzert zzert, zzetj zzetj, zzgvy zzgvy, zzgvy zzgvy2, zzgvy zzgvy3, zzgvy zzgvy4, zzgvy zzgvy5, zzgvy zzgvy6, zzgvy zzgvy7, zzgvy zzgvy8, zzgvy zzgvy9, Executor executor, zzffy zzffy, zzdqa zzdqa) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzetc) obj);
        zzert zzert2 = zzert;
        hashSet.add(zzert);
        zzetj zzetj2 = zzetj;
        hashSet.add(zzetj);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfx)).booleanValue()) {
            hashSet.add((zzeqy) zzgvy.zzb());
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfy)).booleanValue()) {
            hashSet.add((zzeqy) zzgvy2.zzb());
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfz)).booleanValue()) {
            hashSet.add((zzeqy) zzgvy3.zzb());
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfA)).booleanValue()) {
            hashSet.add((zzeqy) zzgvy4.zzb());
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfE)).booleanValue()) {
            hashSet.add((zzeqy) zzgvy6.zzb());
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfF)).booleanValue()) {
            hashSet.add((zzeqy) zzgvy7.zzb());
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcA)).booleanValue()) {
            hashSet.add((zzeqy) zzgvy9.zzb());
        }
        return new zzerb(context, executor, hashSet, zzffy, zzdqa);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
