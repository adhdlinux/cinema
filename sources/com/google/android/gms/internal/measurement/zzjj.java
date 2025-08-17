package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzjj extends zzir {
    private static final Logger zzb = Logger.getLogger(zzjj.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzmv.zzx();
    zzjk zza;

    private zzjj() {
    }

    /* synthetic */ zzjj(zzji zzji) {
    }

    public static int zzA(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j2) {
        int i2;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if ((-34359738368L & j2) != 0) {
            j2 >>>= 28;
            i2 = 6;
        } else {
            i2 = 2;
        }
        if ((-2097152 & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? i2 + 1 : i2;
    }

    public static zzjj zzC(byte[] bArr) {
        return new zzjg(bArr, 0, bArr.length);
    }

    public static int zzt(zzjb zzjb) {
        int zzd = zzjb.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    static int zzu(int i2, zzlj zzlj, zzlu zzlu) {
        int zzA = zzA(i2 << 3);
        int i3 = zzA + zzA;
        zzil zzil = (zzil) zzlj;
        int zzbu = zzil.zzbu();
        if (zzbu == -1) {
            zzbu = zzlu.zza(zzil);
            zzil.zzbx(zzbu);
        }
        return i3 + zzbu;
    }

    public static int zzv(int i2) {
        if (i2 >= 0) {
            return zzA(i2);
        }
        return 10;
    }

    public static int zzw(zzkp zzkp) {
        int zza2 = zzkp.zza();
        return zzA(zza2) + zza2;
    }

    static int zzx(zzlj zzlj, zzlu zzlu) {
        zzil zzil = (zzil) zzlj;
        int zzbu = zzil.zzbu();
        if (zzbu == -1) {
            zzbu = zzlu.zza(zzil);
            zzil.zzbx(zzbu);
        }
        return zzA(zzbu) + zzbu;
    }

    public static int zzy(String str) {
        int i2;
        try {
            i2 = zzna.zzc(str);
        } catch (zzmz unused) {
            i2 = str.getBytes(zzkk.zzb).length;
        }
        return zzA(i2) + i2;
    }

    public static int zzz(int i2) {
        return zzA(i2 << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str, zzmz zzmz) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzmz);
        byte[] bytes = str.getBytes(zzkk.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(e2);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b2) throws IOException;

    public abstract void zzd(int i2, boolean z2) throws IOException;

    public abstract void zze(int i2, zzjb zzjb) throws IOException;

    public abstract void zzf(int i2, int i3) throws IOException;

    public abstract void zzg(int i2) throws IOException;

    public abstract void zzh(int i2, long j2) throws IOException;

    public abstract void zzi(long j2) throws IOException;

    public abstract void zzj(int i2, int i3) throws IOException;

    public abstract void zzk(int i2) throws IOException;

    public abstract void zzl(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void zzm(int i2, String str) throws IOException;

    public abstract void zzo(int i2, int i3) throws IOException;

    public abstract void zzp(int i2, int i3) throws IOException;

    public abstract void zzq(int i2) throws IOException;

    public abstract void zzr(int i2, long j2) throws IOException;

    public abstract void zzs(long j2) throws IOException;
}
