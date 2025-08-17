package com.google.android.gms.internal.ads;

import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class zzgom {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzgon zzc;

    /* synthetic */ zzgom(zzgol zzgol) {
    }

    public static int zzF(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public static long zzG(long j2) {
        return (j2 >>> 1) ^ (-(1 & j2));
    }

    public static zzgom zzH(InputStream inputStream, int i2) {
        return new zzgok(inputStream, CodedOutputStream.DEFAULT_BUFFER_SIZE, (zzgoj) null);
    }

    static zzgom zzI(byte[] bArr, int i2, int i3, boolean z2) {
        zzgog zzgog = new zzgog(bArr, i2, i3, z2, (zzgof) null);
        try {
            zzgog.zze(i3);
            return zzgog;
        } catch (zzgpy e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract void zzA(int i2);

    public abstract boolean zzC() throws IOException;

    public abstract boolean zzD() throws IOException;

    public abstract boolean zzE(int i2) throws IOException;

    public abstract double zzb() throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzd();

    public abstract int zze(int i2) throws zzgpy;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract long zzv() throws IOException;

    public abstract zzgoe zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i2) throws zzgpy;
}
