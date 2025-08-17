package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class zzgkx extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgkx zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgpv zze = zzgpm.zzaN();

    static {
        zzgkx zzgkx = new zzgkx();
        zzb = zzgkx;
        zzgpm.zzaU(zzgkx.class, zzgkx);
    }

    private zzgkx() {
    }

    public static zzgku zzd() {
        return (zzgku) zzb.zzaA();
    }

    public static zzgkx zzg(InputStream inputStream, zzgoy zzgoy) throws IOException {
        return (zzgkx) zzgpm.zzaH(zzb, inputStream, zzgoy);
    }

    static /* synthetic */ void zzj(zzgkx zzgkx, zzgkw zzgkw) {
        zzgkw.getClass();
        zzgpv zzgpv = zzgkx.zze;
        if (!zzgpv.zzc()) {
            zzgkx.zze = zzgpm.zzaO(zzgpv);
        }
        zzgkx.zze.add(zzgkw);
    }

    public final int zza() {
        return this.zze.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzgkw.class});
        } else if (i3 == 3) {
            return new zzgkx();
        } else {
            if (i3 == 4) {
                return new zzgku((zzgkt) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzgkw zze(int i2) {
        return (zzgkw) this.zze.get(i2);
    }

    public final List zzh() {
        return this.zze;
    }
}
