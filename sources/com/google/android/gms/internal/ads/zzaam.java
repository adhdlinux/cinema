package com.google.android.gms.internal.ads;

import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class zzaam implements zzaax {
    private final byte[] zza = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
    private final zzt zzb;
    private final long zzc;
    private long zzd;
    private byte[] zze = new byte[65536];
    private int zzf;
    private int zzg;

    static {
        zzbq.zzb("media3.extractor");
    }

    public zzaam(zzt zzt, long j2, long j3) {
        this.zzb = zzt;
        this.zzd = j2;
        this.zzc = j3;
    }

    private final int zzp(byte[] bArr, int i2, int i3) {
        int i4 = this.zzg;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.zze, 0, bArr, i2, min);
        zzu(min);
        return min;
    }

    private final int zzq(byte[] bArr, int i2, int i3, int i4, boolean z2) throws IOException {
        if (!Thread.interrupted()) {
            int zza2 = this.zzb.zza(bArr, i2 + i4, i3 - i4);
            if (zza2 != -1) {
                return i4 + zza2;
            }
            if (i4 == 0 && z2) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private final int zzr(int i2) {
        int min = Math.min(this.zzg, i2);
        zzu(min);
        return min;
    }

    private final void zzs(int i2) {
        if (i2 != -1) {
            this.zzd += (long) i2;
        }
    }

    private final void zzt(int i2) {
        int i3 = this.zzf + i2;
        int length = this.zze.length;
        if (i3 > length) {
            this.zze = Arrays.copyOf(this.zze, Math.max(65536 + i3, Math.min(length + length, i3 + ImageMetadata.LENS_APERTURE)));
        }
    }

    private final void zzu(int i2) {
        byte[] bArr;
        int i3 = this.zzg - i2;
        this.zzg = i3;
        this.zzf = 0;
        byte[] bArr2 = this.zze;
        if (i3 < bArr2.length - 524288) {
            bArr = new byte[(65536 + i3)];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i2, bArr, 0, i3);
        this.zze = bArr;
    }

    public final int zza(byte[] bArr, int i2, int i3) throws IOException {
        int zzp = zzp(bArr, i2, i3);
        if (zzp == 0) {
            zzp = zzq(bArr, i2, i3, 0, true);
        }
        zzs(zzp);
        return zzp;
    }

    public final int zzb(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        zzt(i3);
        int i5 = this.zzg;
        int i6 = this.zzf;
        int i7 = i5 - i6;
        if (i7 == 0) {
            i4 = zzq(this.zze, i6, i3, 0, true);
            if (i4 == -1) {
                return -1;
            }
            this.zzg += i4;
        } else {
            i4 = Math.min(i3, i7);
        }
        System.arraycopy(this.zze, this.zzf, bArr, i2, i4);
        this.zzf += i4;
        return i4;
    }

    public final int zzc(int i2) throws IOException {
        int zzr = zzr(1);
        if (zzr == 0) {
            zzr = zzq(this.zza, 0, Math.min(1, CodedOutputStream.DEFAULT_BUFFER_SIZE), 0, true);
        }
        zzs(zzr);
        return zzr;
    }

    public final long zzd() {
        return this.zzc;
    }

    public final long zze() {
        return this.zzd + ((long) this.zzf);
    }

    public final long zzf() {
        return this.zzd;
    }

    public final void zzg(int i2) throws IOException {
        zzl(i2, false);
    }

    public final void zzh(byte[] bArr, int i2, int i3) throws IOException {
        zzm(bArr, i2, i3, false);
    }

    public final void zzi(byte[] bArr, int i2, int i3) throws IOException {
        zzn(bArr, i2, i3, false);
    }

    public final void zzj() {
        this.zzf = 0;
    }

    public final void zzk(int i2) throws IOException {
        zzo(i2, false);
    }

    public final boolean zzl(int i2, boolean z2) throws IOException {
        zzt(i2);
        int i3 = this.zzg - this.zzf;
        while (i3 < i2) {
            i3 = zzq(this.zze, this.zzf, i2, i3, z2);
            if (i3 == -1) {
                return false;
            }
            this.zzg = this.zzf + i3;
        }
        this.zzf += i2;
        return true;
    }

    public final boolean zzm(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        if (!zzl(i3, z2)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i3, bArr, i2, i3);
        return true;
    }

    public final boolean zzn(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        int zzp = zzp(bArr, i2, i3);
        while (zzp < i3 && zzp != -1) {
            zzp = zzq(bArr, i2, i3, zzp, z2);
        }
        zzs(zzp);
        if (zzp != -1) {
            return true;
        }
        return false;
    }

    public final boolean zzo(int i2, boolean z2) throws IOException {
        int zzr = zzr(i2);
        while (zzr < i2 && zzr != -1) {
            zzr = zzq(this.zza, -zzr, Math.min(i2, zzr + CodedOutputStream.DEFAULT_BUFFER_SIZE), zzr, false);
        }
        zzs(zzr);
        if (zzr != -1) {
            return true;
        }
        return false;
    }
}
