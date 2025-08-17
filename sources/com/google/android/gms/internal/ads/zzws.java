package com.google.android.gms.internal.ads;

final class zzws extends zzwu implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzws(int i2, zzcy zzcy, int i3, zzwm zzwm, int i4, String str) {
        super(i2, zzcy, i3);
        boolean z2;
        boolean z3;
        zzfsc zzfsc;
        int i5;
        boolean z4;
        boolean z5;
        int i6 = 0;
        this.zzf = zzwy.zzn(i4, false);
        int i7 = this.zzd.zze;
        int i8 = zzwm.zzy;
        if (1 != (i7 & 1)) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.zzg = z2;
        if ((i7 & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzh = z3;
        if (zzwm.zzw.isEmpty()) {
            zzfsc = zzfsc.zzm("");
        } else {
            zzfsc = zzwm.zzw;
        }
        int i9 = 0;
        while (true) {
            if (i9 >= zzfsc.size()) {
                i9 = Integer.MAX_VALUE;
                i5 = 0;
                break;
            }
            i5 = zzwy.zza(this.zzd, (String) zzfsc.get(i9), false);
            if (i5 > 0) {
                break;
            }
            i9++;
        }
        this.zzi = i9;
        this.zzj = i5;
        int i10 = this.zzd.zzf;
        int bitCount = Integer.bitCount(0);
        this.zzk = bitCount;
        int i11 = this.zzd.zzf;
        this.zzm = false;
        if (zzwy.zzg(str) == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        int zza = zzwy.zza(this.zzd, str, z4);
        this.zzl = zza;
        if (i5 > 0 || ((zzwm.zzw.isEmpty() && bitCount > 0) || this.zzg || (this.zzh && zza > 0))) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (zzwy.zzn(i4, zzwm.zzR) && z5) {
            i6 = 1;
        }
        this.zze = i6;
    }

    /* renamed from: zza */
    public final int compareTo(zzws zzws) {
        zzftl zzftl;
        zzfrr zzd = zzfrr.zzj().zzd(this.zzf, zzws.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzws.zzi), zzftl.zzc().zza()).zzb(this.zzj, zzws.zzj).zzb(this.zzk, zzws.zzk).zzd(this.zzg, zzws.zzg);
        Boolean valueOf = Boolean.valueOf(this.zzh);
        Boolean valueOf2 = Boolean.valueOf(zzws.zzh);
        if (this.zzj == 0) {
            zzftl = zzftl.zzc();
        } else {
            zzftl = zzftl.zzc().zza();
        }
        zzfrr zzb = zzd.zzc(valueOf, valueOf2, zzftl).zzb(this.zzl, zzws.zzl);
        if (this.zzk == 0) {
            zzb = zzb.zze(false, false);
        }
        return zzb.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzwu zzwu) {
        zzws zzws = (zzws) zzwu;
        return false;
    }
}
