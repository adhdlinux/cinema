package com.google.android.gms.internal.ads;

public final class zzapa extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzapa zzb;
    private int zzd;
    private zzgpv zze = zzgpm.zzaN();
    private zzgoe zzf = zzgoe.zzb;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzapa zzapa = new zzapa();
        zzb = zzapa;
        zzgpm.zzaU(zzapa.class, zzapa);
    }

    private zzapa() {
    }

    public static zzaoz zza() {
        return (zzaoz) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzapa zzapa, zzgoe zzgoe) {
        zzgpv zzgpv = zzapa.zze;
        if (!zzgpv.zzc()) {
            zzapa.zze = zzgpm.zzaO(zzgpv);
        }
        zzapa.zze.add(zzgoe);
    }

    static /* synthetic */ void zze(zzapa zzapa, zzgoe zzgoe) {
        zzapa.zzd |= 1;
        zzapa.zzf = zzgoe;
    }

    static /* synthetic */ void zzf(zzapa zzapa, int i2) {
        zzapa.zzh = 4;
        zzapa.zzd = 4 | zzapa.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzaou.zza, "zzh", zzaos.zza});
        } else if (i3 == 3) {
            return new zzapa();
        } else {
            if (i3 == 4) {
                return new zzaoz((zzanp) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
