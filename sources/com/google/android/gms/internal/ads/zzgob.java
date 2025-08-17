package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzgob extends OutputStream {
    private static final byte[] zza = new byte[0];
    private final int zzb = 128;
    private final ArrayList zzc = new ArrayList();
    private int zzd;
    private byte[] zze = new byte[128];
    private int zzf;

    zzgob(int i2) {
    }

    private final void zzd(int i2) {
        this.zzc.add(new zzgoa(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i2, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza())});
    }

    public final synchronized void write(int i2) {
        if (this.zzf == this.zze.length) {
            zzd(1);
        }
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        this.zzf = i3 + 1;
        bArr[i3] = (byte) i2;
    }

    public final synchronized int zza() {
        return this.zzd + this.zzf;
    }

    public final synchronized zzgoe zzb() {
        int i2 = this.zzf;
        byte[] bArr = this.zze;
        if (i2 >= bArr.length) {
            this.zzc.add(new zzgoa(this.zze));
            this.zze = zza;
        } else if (i2 > 0) {
            this.zzc.add(new zzgoa(Arrays.copyOf(bArr, i2)));
        }
        this.zzd += this.zzf;
        this.zzf = 0;
        return zzgoe.zzu(this.zzc);
    }

    public final synchronized void zzc() {
        this.zzc.clear();
        this.zzd = 0;
        this.zzf = 0;
    }

    public final synchronized void write(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i4 = this.zzf;
        int i5 = length - i4;
        if (i3 <= i5) {
            System.arraycopy(bArr, i2, bArr2, i4, i3);
            this.zzf += i3;
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i4, i5);
        int i6 = i3 - i5;
        zzd(i6);
        System.arraycopy(bArr, i2 + i5, this.zze, 0, i6);
        this.zzf = i6;
    }
}
