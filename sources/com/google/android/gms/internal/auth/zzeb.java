package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

class zzeb extends zzea {
    protected final byte[] zza;

    zzeb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzee) || zzd() != ((zzee) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzeb)) {
            return obj.equals(this);
        }
        zzeb zzeb = (zzeb) obj;
        int zzj = zzj();
        int zzj2 = zzeb.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzeb.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd <= zzeb.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzeb.zza;
            zzeb.zzc();
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
            int zzd3 = zzeb.zzd();
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
        return zzez.zzd(i2, this.zza, 0, i4);
    }

    public final zzee zzf(int i2, int i3) {
        int zzi = zzee.zzi(0, i3, zzd());
        if (zzi == 0) {
            return zzee.zzb;
        }
        return new zzdy(this.zza, 0, zzi);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final boolean zzh() {
        return zzhm.zzd(this.zza, 0, zzd());
    }
}
