package com.google.android.gms.internal.ads;

public final class zzang extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzang zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private long zzj;
    private long zzk;
    private String zzl = "";
    private long zzm;
    private String zzn = "";
    private String zzo = "";
    private zzgpv zzp = zzgpm.zzaN();
    private int zzq;

    static {
        zzang zzang = new zzang();
        zzb = zzang;
        zzgpm.zzaU(zzang.class, zzang);
    }

    private zzang() {
    }

    public static zzanc zza() {
        return (zzanc) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzang zzang, long j2) {
        zzang.zzd |= 2;
        zzang.zzf = j2;
    }

    static /* synthetic */ void zze(zzang zzang, String str) {
        str.getClass();
        zzang.zzd |= 4;
        zzang.zzg = str;
    }

    static /* synthetic */ void zzf(zzang zzang, String str) {
        str.getClass();
        zzang.zzd |= 8;
        zzang.zzh = str;
    }

    static /* synthetic */ void zzg(zzang zzang, String str) {
        zzang.zzd |= 16;
        zzang.zzi = str;
    }

    static /* synthetic */ void zzh(zzang zzang, String str) {
        zzang.zzd |= 1024;
        zzang.zzo = str;
    }

    static /* synthetic */ void zzi(zzang zzang, String str) {
        str.getClass();
        zzang.zzd |= 1;
        zzang.zze = str;
    }

    static /* synthetic */ void zzj(zzang zzang, int i2) {
        zzang.zzq = i2 - 1;
        zzang.zzd |= 2048;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzane.class, "zzq", zzanf.zza});
        } else if (i3 == 3) {
            return new zzang();
        } else {
            if (i3 == 4) {
                return new zzanc((zzanb) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
