package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzam {
    private static final zzam zzG = new zzam(new zzak());
    private static final String zzH = Integer.toString(0, 36);
    private static final String zzI = Integer.toString(1, 36);
    private static final String zzJ = Integer.toString(2, 36);
    private static final String zzK = Integer.toString(3, 36);
    private static final String zzL = Integer.toString(4, 36);
    private static final String zzM = Integer.toString(5, 36);
    private static final String zzN = Integer.toString(6, 36);
    private static final String zzO = Integer.toString(7, 36);
    private static final String zzP = Integer.toString(8, 36);
    private static final String zzQ = Integer.toString(9, 36);
    private static final String zzR = Integer.toString(10, 36);
    private static final String zzS = Integer.toString(11, 36);
    private static final String zzT = Integer.toString(12, 36);
    private static final String zzU = Integer.toString(13, 36);
    private static final String zzV = Integer.toString(14, 36);
    private static final String zzW = Integer.toString(15, 36);
    private static final String zzX = Integer.toString(16, 36);
    private static final String zzY = Integer.toString(17, 36);
    private static final String zzZ = Integer.toString(18, 36);
    public static final zzn zza = zzai.zza;
    private static final String zzaa = Integer.toString(19, 36);
    private static final String zzab = Integer.toString(20, 36);
    private static final String zzac = Integer.toString(21, 36);
    private static final String zzad = Integer.toString(22, 36);
    private static final String zzae = Integer.toString(23, 36);
    private static final String zzaf = Integer.toString(24, 36);
    private static final String zzag = Integer.toString(25, 36);
    private static final String zzah = Integer.toString(26, 36);
    private static final String zzai = Integer.toString(27, 36);
    private static final String zzaj = Integer.toString(28, 36);
    private static final String zzak = Integer.toString(29, 36);
    private static final String zzal = Integer.toString(30, 36);
    private static final String zzam = Integer.toString(31, 36);
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    private int zzan;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final String zzj;
    public final zzbz zzk;
    public final String zzl;
    public final String zzm;
    public final int zzn;
    public final List zzo;
    public final zzad zzp;
    public final long zzq;
    public final int zzr;
    public final int zzs;
    public final float zzt;
    public final int zzu;
    public final float zzv;
    public final byte[] zzw;
    public final int zzx;
    public final zzs zzy;
    public final int zzz;

    private zzam(zzak zzak2) {
        List list;
        int i2;
        float f2;
        int i3;
        int zzf2;
        this.zzb = zzak2.zza;
        this.zzc = zzak2.zzb;
        this.zzd = zzfj.zzz(zzak2.zzc);
        this.zze = zzak2.zzd;
        int i4 = 0;
        this.zzf = 0;
        int zzd2 = zzak2.zze;
        this.zzg = zzd2;
        int zzl2 = zzak2.zzf;
        this.zzh = zzl2;
        this.zzi = zzl2 != -1 ? zzl2 : zzd2;
        this.zzj = zzak2.zzg;
        this.zzk = zzak2.zzh;
        this.zzl = zzak2.zzi;
        this.zzm = zzak2.zzj;
        this.zzn = zzak2.zzk;
        if (zzak2.zzl == null) {
            list = Collections.emptyList();
        } else {
            list = zzak2.zzl;
        }
        this.zzo = list;
        zzad zzt2 = zzak2.zzm;
        this.zzp = zzt2;
        this.zzq = zzak2.zzn;
        this.zzr = zzak2.zzo;
        this.zzs = zzak2.zzp;
        this.zzt = zzak2.zzq;
        if (zzak2.zzr == -1) {
            i2 = 0;
        } else {
            i2 = zzak2.zzr;
        }
        this.zzu = i2;
        if (zzak2.zzs == -1.0f) {
            f2 = 1.0f;
        } else {
            f2 = zzak2.zzs;
        }
        this.zzv = f2;
        this.zzw = zzak2.zzt;
        this.zzx = zzak2.zzu;
        this.zzy = zzak2.zzv;
        this.zzz = zzak2.zzw;
        this.zzA = zzak2.zzx;
        this.zzB = zzak2.zzy;
        if (zzak2.zzz == -1) {
            i3 = 0;
        } else {
            i3 = zzak2.zzz;
        }
        this.zzC = i3;
        this.zzD = zzak2.zzA != -1 ? zzak2.zzA : i4;
        this.zzE = zzak2.zzB;
        if (zzak2.zzC != 0 || zzt2 == null) {
            zzf2 = zzak2.zzC;
        } else {
            zzf2 = 1;
        }
        this.zzF = zzf2;
    }

    public final boolean equals(Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzam.class == obj.getClass()) {
            zzam zzam2 = (zzam) obj;
            int i3 = this.zzan;
            if ((i3 == 0 || (i2 = zzam2.zzan) == 0 || i3 == i2) && this.zze == zzam2.zze && this.zzg == zzam2.zzg && this.zzh == zzam2.zzh && this.zzn == zzam2.zzn && this.zzq == zzam2.zzq && this.zzr == zzam2.zzr && this.zzs == zzam2.zzs && this.zzu == zzam2.zzu && this.zzx == zzam2.zzx && this.zzz == zzam2.zzz && this.zzA == zzam2.zzA && this.zzB == zzam2.zzB && this.zzC == zzam2.zzC && this.zzD == zzam2.zzD && this.zzE == zzam2.zzE && this.zzF == zzam2.zzF && Float.compare(this.zzt, zzam2.zzt) == 0 && Float.compare(this.zzv, zzam2.zzv) == 0 && zzfj.zzC(this.zzb, zzam2.zzb) && zzfj.zzC(this.zzc, zzam2.zzc) && zzfj.zzC(this.zzj, zzam2.zzj) && zzfj.zzC(this.zzl, zzam2.zzl) && zzfj.zzC(this.zzm, zzam2.zzm) && zzfj.zzC(this.zzd, zzam2.zzd) && Arrays.equals(this.zzw, zzam2.zzw) && zzfj.zzC(this.zzk, zzam2.zzk) && zzfj.zzC(this.zzy, zzam2.zzy) && zzfj.zzC(this.zzp, zzam2.zzp) && zzd(zzam2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = this.zzan;
        if (i8 != 0) {
            return i8;
        }
        String str = this.zzb;
        int i9 = 0;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        String str2 = this.zzc;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i10 = i2 + 527;
        String str3 = this.zzd;
        if (str3 == null) {
            i4 = 0;
        } else {
            i4 = str3.hashCode();
        }
        int i11 = (((((((((i10 * 31) + i3) * 31) + i4) * 31) + this.zze) * 961) + this.zzg) * 31) + this.zzh;
        String str4 = this.zzj;
        if (str4 == null) {
            i5 = 0;
        } else {
            i5 = str4.hashCode();
        }
        int i12 = ((i11 * 31) + i5) * 31;
        zzbz zzbz = this.zzk;
        if (zzbz == null) {
            i6 = 0;
        } else {
            i6 = zzbz.hashCode();
        }
        int i13 = (i12 + i6) * 31;
        String str5 = this.zzl;
        if (str5 == null) {
            i7 = 0;
        } else {
            i7 = str5.hashCode();
        }
        int i14 = (i13 + i7) * 31;
        String str6 = this.zzm;
        if (str6 != null) {
            i9 = str6.hashCode();
        }
        int floatToIntBits = ((((((((((((((((((((((((((((((((((i14 + i9) * 31) + this.zzn) * 31) + ((int) this.zzq)) * 31) + this.zzr) * 31) + this.zzs) * 31) + Float.floatToIntBits(this.zzt)) * 31) + this.zzu) * 31) + Float.floatToIntBits(this.zzv)) * 31) + this.zzx) * 31) + this.zzz) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) - 1) * 31) - 1) * 31) + this.zzF;
        this.zzan = floatToIntBits;
        return floatToIntBits;
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        String str3 = this.zzl;
        String str4 = this.zzm;
        String str5 = this.zzj;
        int i2 = this.zzi;
        String str6 = this.zzd;
        int i3 = this.zzr;
        int i4 = this.zzs;
        float f2 = this.zzt;
        String valueOf = String.valueOf(this.zzy);
        int i5 = this.zzz;
        int i6 = this.zzA;
        return "Format(" + str + ", " + str2 + ", " + str3 + ", " + str4 + ", " + str5 + ", " + i2 + ", " + str6 + ", [" + i3 + ", " + i4 + ", " + f2 + ", " + valueOf + "], [" + i5 + ", " + i6 + "])";
    }

    public final int zza() {
        int i2;
        int i3 = this.zzr;
        if (i3 == -1 || (i2 = this.zzs) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public final zzak zzb() {
        return new zzak(this, (zzaj) null);
    }

    public final zzam zzc(int i2) {
        zzak zzak2 = new zzak(this, (zzaj) null);
        zzak2.zzA(i2);
        return new zzam(zzak2);
    }

    public final boolean zzd(zzam zzam2) {
        if (this.zzo.size() != zzam2.zzo.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.zzo.size(); i2++) {
            if (!Arrays.equals((byte[]) this.zzo.get(i2), (byte[]) zzam2.zzo.get(i2))) {
                return false;
            }
        }
        return true;
    }
}
