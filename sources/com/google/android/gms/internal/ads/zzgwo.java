package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzgwo {
    private final List zza;
    private final List zzb;

    /* synthetic */ zzgwo(int i2, int i3, zzgwn zzgwn) {
        this.zza = zzgwb.zzc(i2);
        this.zzb = zzgwb.zzc(i3);
    }

    public final zzgwo zza(zzgwr zzgwr) {
        this.zzb.add(zzgwr);
        return this;
    }

    public final zzgwo zzb(zzgwr zzgwr) {
        this.zza.add(zzgwr);
        return this;
    }

    public final zzgwp zzc() {
        return new zzgwp(this.zza, this.zzb, (zzgwn) null);
    }
}
