package com.google.android.gms.internal.cast;

import java.util.List;

final class zzfg extends zzfh {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzfh zzc;

    zzfg(zzfh zzfh, int i2, int i3) {
        this.zzc = zzfh;
        this.zza = i2;
        this.zzb = i3;
    }

    public final Object get(int i2) {
        zzeu.zza(i2, this.zzb, "index");
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
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzfh zzh(int i2, int i3) {
        zzeu.zzd(i2, i3, this.zzb);
        zzfh zzfh = this.zzc;
        int i4 = this.zza;
        return zzfh.subList(i2 + i4, i3 + i4);
    }
}
