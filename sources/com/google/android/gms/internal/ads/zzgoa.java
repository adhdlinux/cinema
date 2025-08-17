package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class zzgoa extends zzgnz {
    protected final byte[] zza;

    zzgoa(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgoe) || zzd() != ((zzgoe) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgoa)) {
            return obj.equals(this);
        }
        zzgoa zzgoa = (zzgoa) obj;
        int zzr = zzr();
        int zzr2 = zzgoa.zzr();
        if (zzr == 0 || zzr2 == 0 || zzr == zzr2) {
            return zzg(zzgoa, 0, zzd());
        }
        return false;
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
    public void zze(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zza, i2, bArr, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(zzgoe zzgoe, int i2, int i3) {
        if (i3 <= zzgoe.zzd()) {
            int i4 = i2 + i3;
            if (i4 > zzgoe.zzd()) {
                int zzd = zzgoe.zzd();
                throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + zzd);
            } else if (!(zzgoe instanceof zzgoa)) {
                return zzgoe.zzk(i2, i4).equals(zzk(0, i3));
            } else {
                zzgoa zzgoa = (zzgoa) zzgoe;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzgoa.zza;
                int zzc = zzc() + i3;
                int zzc2 = zzc();
                int zzc3 = zzgoa.zzc() + i2;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
        } else {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + i3 + zzd2);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzi(int i2, int i3, int i4) {
        return zzgpw.zzb(i2, this.zza, zzc() + i3, i4);
    }

    /* access modifiers changed from: protected */
    public final int zzj(int i2, int i3, int i4) {
        int zzc = zzc() + i3;
        return zzgsv.zzf(i2, this.zza, zzc, i4 + zzc);
    }

    public final zzgoe zzk(int i2, int i3) {
        int zzq = zzgoe.zzq(i2, i3, zzd());
        if (zzq == 0) {
            return zzgoe.zzb;
        }
        return new zzgnx(this.zza, zzc() + i2, zzq);
    }

    public final zzgom zzl() {
        return zzgom.zzI(this.zza, zzc(), zzd(), true);
    }

    /* access modifiers changed from: protected */
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public final void zzo(zzgnt zzgnt) throws IOException {
        zzgnt.zza(this.zza, zzc(), zzd());
    }

    public final boolean zzp() {
        int zzc = zzc();
        return zzgsv.zzj(this.zza, zzc, zzd() + zzc);
    }
}
