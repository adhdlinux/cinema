package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public class zzegi extends zzehj {
    private final zzddd zza;

    public zzegi(zzcve zzcve, zzdcs zzdcs, zzcvy zzcvy, zzcwn zzcwn, zzcws zzcws, zzcvt zzcvt, zzdaa zzdaa, zzddk zzddk, zzcxm zzcxm, zzddd zzddd, zzczw zzczw) {
        super(zzcve, zzdcs, zzcvy, zzcwn, zzcws, zzdaa, zzcxm, zzddk, zzczw, zzcvt);
        this.zza = zzddd;
    }

    public final void zzs(zzbvg zzbvg) {
        this.zza.zza(zzbvg);
    }

    public final void zzt(zzbvk zzbvk) throws RemoteException {
        this.zza.zza(new zzbvg(zzbvk.zzf(), zzbvk.zze()));
    }

    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    public final void zzv() {
        this.zza.zzb();
    }

    public final void zzy() {
        this.zza.zzc();
    }
}
