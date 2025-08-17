package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgot extends zzgnt {
    private static final Logger zza = Logger.getLogger(zzgot.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzb = zzgsq.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgou zze;

    private zzgot() {
    }

    /* synthetic */ zzgot(zzgos zzgos) {
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
            j2 >>>= 14;
            i2 += 2;
        }
        return (j2 & -16384) != 0 ? i2 + 1 : i2;
    }

    public static zzgot zzC(byte[] bArr, int i2, int i3) {
        return new zzgop(bArr, 0, i3);
    }

    @Deprecated
    static int zzw(int i2, zzgqw zzgqw, zzgrp zzgrp) {
        int zzat = ((zzgnn) zzgqw).zzat(zzgrp);
        int zzA = zzA(i2 << 3);
        return zzA + zzA + zzat;
    }

    public static int zzx(int i2) {
        if (i2 >= 0) {
            return zzA(i2);
        }
        return 10;
    }

    static int zzy(zzgqw zzgqw, zzgrp zzgrp) {
        int zzat = ((zzgnn) zzgqw).zzat(zzgrp);
        return zzA(zzat) + zzat;
    }

    public static int zzz(String str) {
        int i2;
        try {
            i2 = zzgsv.zze(str);
        } catch (zzgsu unused) {
            i2 = str.getBytes(zzgpw.zzb).length;
        }
        return zzA(i2) + i2;
    }

    public final void zzD() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str, zzgsu zzgsu) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzgsu);
        byte[] bytes = str.getBytes(zzgpw.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgoq(e2);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b2) throws IOException;

    public abstract void zzK(int i2, boolean z2) throws IOException;

    public abstract void zzL(int i2, zzgoe zzgoe) throws IOException;

    public abstract void zza(byte[] bArr, int i2, int i3) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i2, int i3) throws IOException;

    public abstract void zzi(int i2) throws IOException;

    public abstract void zzj(int i2, long j2) throws IOException;

    public abstract void zzk(long j2) throws IOException;

    public abstract void zzl(int i2, int i3) throws IOException;

    public abstract void zzm(int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzn(int i2, zzgqw zzgqw, zzgrp zzgrp) throws IOException;

    public abstract void zzo(int i2, String str) throws IOException;

    public abstract void zzq(int i2, int i3) throws IOException;

    public abstract void zzr(int i2, int i3) throws IOException;

    public abstract void zzs(int i2) throws IOException;

    public abstract void zzt(int i2, long j2) throws IOException;

    public abstract void zzu(long j2) throws IOException;
}
