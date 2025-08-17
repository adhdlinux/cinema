package com.google.android.gms.internal.cast;

public final class zzme extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzme zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private zzsp zzi = zzsh.zzz();
    private zzsp zzj = zzsh.zzz();
    private String zzk = "";

    static {
        zzme zzme = new zzme();
        zzb = zzme;
        zzsh.zzG(zzme.class, zzme);
    }

    private zzme() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            Class<zzon> cls = zzon.class;
            return zzsh.zzD(zzb, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0007\u001b\b\u001b\tဈ\u0004", new Object[]{"zzd", "zze", zzgo.zza(), "zzf", "zzg", zzie.zza(), "zzh", "zzi", cls, "zzj", cls, "zzk"});
        } else if (i3 == 3) {
            return new zzme();
        } else {
            if (i3 == 4) {
                return new zzmd((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
