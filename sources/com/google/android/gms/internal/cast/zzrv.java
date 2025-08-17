package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.List;

final class zzrv implements zzvi {
    private final zzru zza;

    private zzrv(zzru zzru) {
        byte[] bArr = zzsq.zzd;
        this.zza = zzru;
        zzru.zza = this;
    }

    public static zzrv zza(zzru zzru) {
        zzrv zzrv = zzru.zza;
        return zzrv != null ? zzrv : new zzrv(zzru);
    }

    public final void zzA(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int intValue = ((Integer) list.get(i5)).intValue();
                i4 += zzru.zzx((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                zzru zzru = this.zza;
                int intValue2 = ((Integer) list.get(i3)).intValue();
                zzru.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            zzru zzru2 = this.zza;
            int intValue3 = ((Integer) list.get(i3)).intValue();
            zzru2.zzp(i2, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i3++;
        }
    }

    public final void zzB(int i2, long j2) throws IOException {
        this.zza.zzr(i2, (j2 >> 63) ^ (j2 + j2));
    }

    public final void zzC(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long longValue = ((Long) list.get(i5)).longValue();
                i4 += zzru.zzy((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                zzru zzru = this.zza;
                long longValue2 = ((Long) list.get(i3)).longValue();
                zzru.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            zzru zzru2 = this.zza;
            long longValue3 = ((Long) list.get(i3)).longValue();
            zzru2.zzr(i2, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i3++;
        }
    }

    public final void zzD(int i2, String str) throws IOException {
        this.zza.zzm(i2, str);
    }

    public final void zzE(int i2, List list) throws IOException {
        int i3 = 0;
        if (list instanceof zzsx) {
            zzsx zzsx = (zzsx) list;
            while (i3 < list.size()) {
                Object zze = zzsx.zze(i3);
                if (zze instanceof String) {
                    this.zza.zzm(i2, (String) zze);
                } else {
                    this.zza.zze(i2, (zzrm) zze);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzm(i2, (String) list.get(i3));
            i3++;
        }
    }

    public final void zzF(int i2, int i3) throws IOException {
        this.zza.zzp(i2, i3);
    }

    public final void zzG(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzru.zzx(((Integer) list.get(i5)).intValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzq(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzp(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void zzH(int i2, long j2) throws IOException {
        this.zza.zzr(i2, j2);
    }

    public final void zzI(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzru.zzy(((Long) list.get(i5)).longValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzs(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzr(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void zzb(int i2, boolean z2) throws IOException {
        this.zza.zzd(i2, z2);
    }

    public final void zzc(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Boolean) list.get(i5)).booleanValue();
                i4++;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : 0);
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzd(i2, ((Boolean) list.get(i3)).booleanValue());
            i3++;
        }
    }

    public final void zzd(int i2, zzrm zzrm) throws IOException {
        this.zza.zze(i2, zzrm);
    }

    public final void zze(int i2, List list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zza.zze(i2, (zzrm) list.get(i3));
        }
    }

    public final void zzf(int i2, double d2) throws IOException {
        this.zza.zzh(i2, Double.doubleToRawLongBits(d2));
    }

    public final void zzg(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Double) list.get(i5)).doubleValue();
                i4 += 8;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i2, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    public final void zzh(int i2, int i3) throws IOException {
        this.zza.zzj(i2, i3);
    }

    public final void zzi(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzru.zzu(((Integer) list.get(i5)).intValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzk(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzj(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void zzj(int i2, int i3) throws IOException {
        this.zza.zzf(i2, i3);
    }

    public final void zzk(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).intValue();
                i4 += 4;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzg(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void zzl(int i2, long j2) throws IOException {
        this.zza.zzh(i2, j2);
    }

    public final void zzm(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).longValue();
                i4 += 8;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzi(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void zzn(int i2, float f2) throws IOException {
        this.zza.zzf(i2, Float.floatToRawIntBits(f2));
    }

    public final void zzo(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Float) list.get(i5)).floatValue();
                i4 += 4;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i2, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    public final void zzp(int i2, Object obj, zzua zzua) throws IOException {
        zzru zzru = this.zza;
        zzru.zzo(i2, 3);
        zzua.zzf((zztp) obj, zzru.zza);
        zzru.zzo(i2, 4);
    }

    public final void zzq(int i2, int i3) throws IOException {
        this.zza.zzj(i2, i3);
    }

    public final void zzr(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzru.zzu(((Integer) list.get(i5)).intValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzk(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzj(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void zzs(int i2, long j2) throws IOException {
        this.zza.zzr(i2, j2);
    }

    public final void zzt(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzru.zzy(((Long) list.get(i5)).longValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzs(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzr(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void zzu(int i2, Object obj, zzua zzua) throws IOException {
        zztp zztp = (zztp) obj;
        zzrr zzrr = (zzrr) this.zza;
        zzrr.zzq((i2 << 3) | 2);
        zzrr.zzq(((zzqz) zztp).zzp(zzua));
        zzua.zzf(zztp, zzrr.zza);
    }

    public final void zzv(int i2, int i3) throws IOException {
        this.zza.zzf(i2, i3);
    }

    public final void zzw(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).intValue();
                i4 += 4;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzg(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i2, ((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    public final void zzx(int i2, long j2) throws IOException {
        this.zza.zzh(i2, j2);
    }

    public final void zzy(int i2, List list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).longValue();
                i4 += 8;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzi(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i2, ((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    public final void zzz(int i2, int i3) throws IOException {
        this.zza.zzp(i2, (i3 >> 31) ^ (i3 + i3));
    }
}
