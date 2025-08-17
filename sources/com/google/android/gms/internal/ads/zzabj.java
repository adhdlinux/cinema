package com.google.android.gms.internal.ads;

import com.startapp.y1;
import java.util.Collections;
import java.util.List;

public final class zzabj {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzabi zzk;
    private final zzbz zzl;

    private zzabj(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, zzabi zzabi, zzbz zzbz) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = zzi(i6);
        this.zzg = i7;
        this.zzh = i8;
        this.zzi = zzh(i8);
        this.zzj = j2;
        this.zzk = zzabi;
        this.zzl = zzbz;
    }

    public zzabj(byte[] bArr, int i2) {
        zzez zzez = new zzez(bArr, bArr.length);
        zzez.zzj(i2 * 8);
        this.zza = zzez.zzd(16);
        this.zzb = zzez.zzd(16);
        this.zzc = zzez.zzd(24);
        this.zzd = zzez.zzd(24);
        int zzd2 = zzez.zzd(20);
        this.zze = zzd2;
        this.zzf = zzi(zzd2);
        this.zzg = zzez.zzd(3) + 1;
        int zzd3 = zzez.zzd(5) + 1;
        this.zzh = zzd3;
        this.zzi = zzh(zzd3);
        int zzd4 = zzez.zzd(4);
        int zzd5 = zzez.zzd(32);
        int i3 = zzfj.zza;
        this.zzj = ((((long) zzd4) & 4294967295L) << 32) | (((long) zzd5) & 4294967295L);
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int i2) {
        if (i2 == 8) {
            return 1;
        }
        if (i2 == 12) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 != 20) {
            return i2 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int zzi(int i2) {
        switch (i2) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j2 = this.zzj;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j2) {
        return Math.max(0, Math.min((j2 * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzam zzc(byte[] bArr, zzbz zzbz) {
        bArr[4] = y1.f36938c;
        int i2 = this.zzd;
        if (i2 <= 0) {
            i2 = -1;
        }
        zzbz zzd2 = zzd(zzbz);
        zzak zzak = new zzak();
        zzak.zzS("audio/flac");
        zzak.zzL(i2);
        zzak.zzw(this.zzg);
        zzak.zzT(this.zze);
        zzak.zzI(Collections.singletonList(bArr));
        zzak.zzM(zzd2);
        return zzak.zzY();
    }

    public final zzbz zzd(zzbz zzbz) {
        zzbz zzbz2 = this.zzl;
        return zzbz2 == null ? zzbz : zzbz2.zzd(zzbz);
    }

    public final zzabj zze(List list) {
        return new zzabj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzbz(list)));
    }

    public final zzabj zzf(zzabi zzabi) {
        return new zzabj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzabi, this.zzl);
    }

    public final zzabj zzg(List list) {
        return new zzabj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzacf.zzb(list)));
    }
}
