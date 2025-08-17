package com.google.android.gms.internal.ads;

import java.util.List;

final class zzfsb extends zzfsc {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzfsc zzc;

    zzfsb(zzfsc zzfsc, int i2, int i3) {
        this.zzc = zzfsc;
        this.zza = i2;
        this.zzb = i3;
    }

    public final Object get(int i2) {
        zzfph.zza(i2, this.zzb, "index");
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

    public final zzfsc zzh(int i2, int i3) {
        zzfph.zzg(i2, i3, this.zzb);
        zzfsc zzfsc = this.zzc;
        int i4 = this.zza;
        return zzfsc.subList(i2 + i4, i3 + i4);
    }
}
