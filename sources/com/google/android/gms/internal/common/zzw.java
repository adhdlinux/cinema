package com.google.android.gms.internal.common;

abstract class zzw extends zzj {
    final CharSequence zzb;
    final zzo zzc;
    final boolean zzd;
    int zze = 0;
    int zzf;

    protected zzw(zzx zzx, CharSequence charSequence) {
        this.zzc = zzx.zza;
        this.zzd = zzx.zzb;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        int zzd2;
        int i2;
        int i3 = this.zze;
        while (true) {
            int i4 = this.zze;
            if (i4 != -1) {
                zzd2 = zzd(i4);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zze = -1;
                    i2 = -1;
                } else {
                    i2 = zzc(zzd2);
                    this.zze = i2;
                }
                if (i2 == i3) {
                    int i5 = i2 + 1;
                    this.zze = i5;
                    if (i5 > this.zzb.length()) {
                        this.zze = -1;
                    }
                } else {
                    if (i3 < zzd2) {
                        this.zzb.charAt(i3);
                    }
                    if (i3 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    if (!this.zzd || i3 != zzd2) {
                        int i6 = this.zzf;
                    } else {
                        i3 = this.zze;
                    }
                }
            } else {
                zzb();
                return null;
            }
        }
        int i62 = this.zzf;
        if (i62 == 1) {
            zzd2 = this.zzb.length();
            this.zze = -1;
            if (zzd2 > i3) {
                this.zzb.charAt(zzd2 - 1);
            }
        } else {
            this.zzf = i62 - 1;
        }
        return this.zzb.subSequence(i3, zzd2).toString();
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i2);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i2);
}
