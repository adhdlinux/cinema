package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.nio.charset.Charset;

class zzrj extends zzri {
    protected final byte[] zza;

    zzrj(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrm) || zzd() != ((zzrm) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzrj)) {
            return obj.equals(this);
        }
        zzrj zzrj = (zzrj) obj;
        int zzk = zzk();
        int zzk2 = zzrj.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzrj.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd <= zzrj.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzrj.zza;
            zzrj.zzc();
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
            int zzd3 = zzrj.zzd();
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
        return zzsq.zzb(i2, this.zza, 0, i4);
    }

    public final zzrm zzf(int i2, int i3) {
        zzrm.zzj(0, i3, zzd());
        if (i3 == 0) {
            return zzrm.zzb;
        }
        return new zzrg(this.zza, 0, i3);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzrc zzrc) throws IOException {
        ((zzrr) zzrc).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zzvf.zze(this.zza, 0, zzd());
    }
}
