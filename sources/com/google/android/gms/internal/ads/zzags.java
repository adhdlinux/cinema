package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

final class zzags {
    public final zzabz zza;
    public final zzahe zzb = new zzahe();
    public final zzfa zzc = new zzfa();
    public zzahf zzd;
    public zzago zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzfa zzj = new zzfa(1);
    private final zzfa zzk = new zzfa();
    /* access modifiers changed from: private */
    public boolean zzl;

    public zzags(zzabz zzabz, zzahf zzahf, zzago zzago) {
        this.zza = zzabz;
        this.zzd = zzahf;
        this.zze = zzago;
        zzh(zzahf, zzago);
    }

    public final int zza() {
        int i2;
        if (!this.zzl) {
            i2 = this.zzd.zzg[this.zzf];
        } else if (this.zzb.zzj[this.zzf]) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (zzf() != null) {
            return i2 | 1073741824;
        }
        return i2;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i2, int i3) {
        zzfa zzfa;
        boolean z2;
        int i4;
        zzahd zzf2 = zzf();
        if (zzf2 == null) {
            return 0;
        }
        int i5 = zzf2.zzd;
        if (i5 != 0) {
            zzfa = this.zzb.zzn;
        } else {
            byte[] bArr = zzf2.zze;
            int i6 = zzfj.zza;
            zzfa zzfa2 = this.zzk;
            int length = bArr.length;
            zzfa2.zzD(bArr, length);
            zzfa = this.zzk;
            i5 = length;
        }
        boolean zzb2 = this.zzb.zzb(this.zzf);
        if (zzb2 || i3 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfa zzfa3 = this.zzj;
        byte[] zzH = zzfa3.zzH();
        if (true != z2) {
            i4 = 0;
        } else {
            i4 = 128;
        }
        zzH[0] = (byte) (i4 | i5);
        zzfa3.zzF(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzfa, i5, 1);
        if (!z2) {
            return i5 + 1;
        }
        if (!zzb2) {
            this.zzc.zzC(8);
            zzfa zzfa4 = this.zzc;
            byte[] zzH2 = zzfa4.zzH();
            zzH2[0] = 0;
            zzH2[1] = 1;
            zzH2[2] = 0;
            zzH2[3] = (byte) i3;
            zzH2[4] = (byte) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
            zzH2[5] = (byte) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
            zzH2[6] = (byte) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
            zzH2[7] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
            this.zza.zzr(zzfa4, 8, 1);
            return i5 + 9;
        }
        zzfa zzfa5 = this.zzb.zzn;
        int zzo = zzfa5.zzo();
        zzfa5.zzG(-2);
        int i7 = (zzo * 6) + 2;
        if (i3 != 0) {
            this.zzc.zzC(i7);
            byte[] zzH3 = this.zzc.zzH();
            zzfa5.zzB(zzH3, 0, i7);
            int i8 = (((zzH3[2] & 255) << 8) | (zzH3[3] & 255)) + i3;
            zzH3[2] = (byte) ((i8 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
            zzH3[3] = (byte) (i8 & JfifUtil.MARKER_FIRST_BYTE);
            zzfa5 = this.zzc;
        }
        this.zza.zzr(zzfa5, i7, 1);
        return i5 + 1 + i7;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzahe zzahe = this.zzb;
        return zzahe.zzi[this.zzf];
    }

    public final zzahd zzf() {
        if (!this.zzl) {
            return null;
        }
        zzahe zzahe = this.zzb;
        zzago zzago = zzahe.zza;
        int i2 = zzfj.zza;
        int i3 = zzago.zza;
        zzahd zzahd = zzahe.zzm;
        if (zzahd == null) {
            zzahd = this.zzd.zza.zza(i3);
        }
        if (zzahd == null || !zzahd.zza) {
            return null;
        }
        return zzahd;
    }

    public final void zzh(zzahf zzahf, zzago zzago) {
        this.zzd = zzahf;
        this.zze = zzago;
        this.zza.zzk(zzahf.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzahe zzahe = this.zzb;
        zzahe.zzd = 0;
        zzahe.zzp = 0;
        zzahe.zzq = false;
        zzahe.zzk = false;
        zzahe.zzo = false;
        zzahe.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i2 = this.zzg + 1;
        this.zzg = i2;
        int[] iArr = this.zzb.zzg;
        int i3 = this.zzh;
        if (i2 != iArr[i3]) {
            return true;
        }
        this.zzh = i3 + 1;
        this.zzg = 0;
        return false;
    }
}
