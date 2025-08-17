package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;

final class zzwg extends zzwu implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg = zzwy.zzg(this.zzd.zzd);
    private final zzwm zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzwg(int i2, zzcy zzcy, int i3, zzwm zzwm, int i4, boolean z2, zzfpi zzfpi) {
        super(i2, zzcy, i3);
        int i5;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        boolean z5;
        boolean z6;
        this.zzh = zzwm;
        int i8 = 0;
        this.zzi = zzwy.zzn(i4, false);
        int i9 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i9 >= zzwm.zzq.size()) {
                i9 = Integer.MAX_VALUE;
                i6 = 0;
                break;
            }
            i6 = zzwy.zza(this.zzd, (String) zzwm.zzq.get(i9), false);
            if (i6 > 0) {
                break;
            }
            i9++;
        }
        this.zzk = i9;
        this.zzj = i6;
        int i10 = this.zzd.zzf;
        this.zzl = Integer.bitCount(0);
        zzam zzam = this.zzd;
        int i11 = zzam.zzf;
        this.zzm = true;
        if (1 != (zzam.zze & 1)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.zzp = z3;
        this.zzq = zzam.zzz;
        this.zzr = zzam.zzA;
        this.zzs = zzam.zzi;
        this.zzf = zzfpi.zza(zzam);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] split = zzfj.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{zzfj.zzx(configuration.locale)};
        for (int i12 = 0; i12 < split.length; i12++) {
            split[i12] = zzfj.zzz(split[i12]);
        }
        int i13 = 0;
        while (true) {
            if (i13 >= split.length) {
                i13 = Integer.MAX_VALUE;
                i7 = 0;
                break;
            }
            i7 = zzwy.zza(this.zzd, split[i13], false);
            if (i7 > 0) {
                break;
            }
            i13++;
        }
        this.zzn = i13;
        this.zzo = i7;
        int i14 = 0;
        while (true) {
            if (i14 < zzwm.zzu.size()) {
                String str = this.zzd.zzm;
                if (str != null && str.equals(zzwm.zzu.get(i14))) {
                    i5 = i14;
                    break;
                }
                i14++;
            } else {
                break;
            }
        }
        this.zzt = i5;
        if ((i4 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 128) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzu = z4;
        if ((i4 & 64) == 64) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.zzv = z5;
        zzwm zzwm2 = this.zzh;
        if (zzwy.zzn(i4, zzwm2.zzR) && ((z6 = this.zzf) || zzwm2.zzL)) {
            i8 = (!zzwy.zzn(i4, false) || !z6 || this.zzd.zzi == -1 || (!zzwm2.zzT && z2)) ? 1 : 2;
        }
        this.zze = i8;
    }

    /* renamed from: zza */
    public final int compareTo(zzwg zzwg) {
        zzftl zzftl;
        if (!this.zzf || !this.zzi) {
            zzftl = zzwy.zzc.zza();
        } else {
            zzftl = zzwy.zzc;
        }
        zzfrr zzc = zzfrr.zzj().zzd(this.zzi, zzwg.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzwg.zzk), zzftl.zzc().zza()).zzb(this.zzj, zzwg.zzj).zzb(this.zzl, zzwg.zzl).zzd(this.zzp, zzwg.zzp).zzd(true, true).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzwg.zzn), zzftl.zzc().zza()).zzb(this.zzo, zzwg.zzo).zzd(this.zzf, zzwg.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzwg.zzt), zzftl.zzc().zza());
        Integer valueOf = Integer.valueOf(this.zzs);
        Integer valueOf2 = Integer.valueOf(zzwg.zzs);
        boolean z2 = this.zzh.zzA;
        zzfrr zzc2 = zzc.zzc(valueOf, valueOf2, zzwy.zzd).zzd(this.zzu, zzwg.zzu).zzd(this.zzv, zzwg.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzwg.zzq), zzftl).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzwg.zzr), zzftl);
        Integer valueOf3 = Integer.valueOf(this.zzs);
        Integer valueOf4 = Integer.valueOf(zzwg.zzs);
        if (!zzfj.zzC(this.zzg, zzwg.zzg)) {
            zzftl = zzwy.zzd;
        }
        return zzc2.zzc(valueOf3, valueOf4, zzftl).zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzwu zzwu) {
        String str;
        zzwg zzwg = (zzwg) zzwu;
        boolean z2 = this.zzh.zzO;
        zzam zzam = this.zzd;
        int i2 = zzam.zzz;
        if (i2 == -1) {
            return false;
        }
        zzam zzam2 = zzwg.zzd;
        if (i2 != zzam2.zzz || (str = zzam.zzm) == null || !TextUtils.equals(str, zzam2.zzm)) {
            return false;
        }
        boolean z3 = this.zzh.zzN;
        int i3 = this.zzd.zzA;
        if (i3 != -1 && i3 == zzwg.zzd.zzA && this.zzu == zzwg.zzu && this.zzv == zzwg.zzv) {
            return true;
        }
        return false;
    }
}
