package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

class zziy extends zzix {
    protected final byte[] zza;

    zziy(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjb) || zzd() != ((zzjb) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zziy)) {
            return obj.equals(this);
        }
        zziy zziy = (zziy) obj;
        int zzk = zzk();
        int zzk2 = zziy.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zziy.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd <= zziy.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zziy.zza;
            zziy.zzc();
            int i2 = 0;
            int i3 = 0;
            while (i2 < zzd) {
                if (bArr[i2] != bArr2[i3]) {
                    return false;
                }
                i2++;
                i3++;
            }
            return true;
        } else {
            int zzd3 = zziy.zzd();
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd3);
        }
    }

    public byte zza(int i2) {
        return this.zza[i2];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i2) {
        return this.zza[i2];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public final int zze(int i2, int i3, int i4) {
        return zzkk.zzd(i2, this.zza, 0, i4);
    }

    public final zzjb zzf(int i2, int i3) {
        int zzj = zzjb.zzj(0, i3, zzd());
        if (zzj == 0) {
            return zzjb.zzb;
        }
        return new zziv(this.zza, 0, zzj);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzir zzir) throws IOException {
        ((zzjg) zzir).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zzna.zzf(this.zza, 0, zzd());
    }
}
