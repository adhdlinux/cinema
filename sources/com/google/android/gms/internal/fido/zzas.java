package com.google.android.gms.internal.fido;

import java.util.List;

final class zzas extends zzat {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzat zzc;

    zzas(zzat zzat, int i2, int i3) {
        this.zzc = zzat;
        this.zza = i2;
        this.zzb = i3;
    }

    public final Object get(int i2) {
        zzam.zza(i2, this.zzb, "index");
        return this.zzc.get(i2 + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzat zzf(int i2, int i3) {
        zzam.zze(i2, i3, this.zzb);
        zzat zzat = this.zzc;
        int i4 = this.zza;
        return zzat.subList(i2 + i4, i3 + i4);
    }
}
