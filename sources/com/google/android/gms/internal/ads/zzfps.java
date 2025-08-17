package com.google.android.gms.internal.ads;

abstract class zzfps extends zzfom {
    final CharSequence zzb;
    final zzfos zzc;
    int zzd = 0;
    int zze;

    protected zzfps(zzfpu zzfpu, CharSequence charSequence) {
        this.zzc = zzfpu.zza;
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        int i2;
        int i3 = this.zzd;
        while (true) {
            int i4 = this.zzd;
            if (i4 != -1) {
                int zzd2 = zzd(i4);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zzd = -1;
                    i2 = -1;
                } else {
                    i2 = zzc(zzd2);
                    this.zzd = i2;
                }
                if (i2 == i3) {
                    int i5 = i2 + 1;
                    this.zzd = i5;
                    if (i5 > this.zzb.length()) {
                        this.zzd = -1;
                    }
                } else {
                    if (i3 < zzd2) {
                        this.zzb.charAt(i3);
                    }
                    if (i3 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    int i6 = this.zze;
                    if (i6 == 1) {
                        zzd2 = this.zzb.length();
                        this.zzd = -1;
                        if (zzd2 > i3) {
                            this.zzb.charAt(zzd2 - 1);
                        }
                    } else {
                        this.zze = i6 - 1;
                    }
                    return this.zzb.subSequence(i3, zzd2).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i2);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i2);
}
