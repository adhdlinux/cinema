package com.google.android.gms.internal.cast;

public final class zzms extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzms zzb;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        zzms zzms = new zzms();
        zzb = zzms;
        zzsh.zzG(zzms.class, zzms);
    }

    private zzms() {
    }

    public static zzmr zza() {
        return (zzmr) zzb.zzu();
    }

    static /* synthetic */ void zzd(zzms zzms, String str) {
        str.getClass();
        zzms.zzd |= 1;
        zzms.zze = str;
    }

    static /* synthetic */ void zze(zzms zzms, long j2) {
        zzms.zzd |= 2;
        zzms.zzf = j2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzms();
        } else {
            if (i3 == 4) {
                return new zzmr((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
