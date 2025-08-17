package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzeww implements zzfov {
    final /* synthetic */ zzexa zza;

    zzeww(zzexa zzexa) {
        this.zza = zzexa;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbzr.zzh("", (zzdwa) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzexa zzexa = this.zza;
        zzexa.zzd = new zzewz((zzbue) null, zzexa.zze(), (zzewy) null);
        return this.zza.zzd;
    }
}
