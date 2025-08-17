package com.google.android.gms.internal.ads;

public final class zzatp extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzatp zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzatp zzatp = new zzatp();
        zzb = zzatp;
        zzgpm.zzaU(zzatp.class, zzatp);
    }

    private zzatp() {
    }

    public static zzato zze() {
        return (zzato) zzb.zzaA();
    }

    public static zzatp zzg() {
        return zzb;
    }

    public static zzatp zzh(zzgoe zzgoe) throws zzgpy {
        return (zzatp) zzgpm.zzaE(zzb, zzgoe);
    }

    public static zzatp zzi(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzatp) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzl(zzatp zzatp, String str) {
        str.getClass();
        zzatp.zzd |= 1;
        zzatp.zze = str;
    }

    static /* synthetic */ void zzm(zzatp zzatp, long j2) {
        zzatp.zzd |= 16;
        zzatp.zzi = j2;
    }

    static /* synthetic */ void zzn(zzatp zzatp, String str) {
        str.getClass();
        zzatp.zzd |= 2;
        zzatp.zzf = str;
    }

    static /* synthetic */ void zzo(zzatp zzatp, long j2) {
        zzatp.zzd |= 4;
        zzatp.zzg = j2;
    }

    static /* synthetic */ void zzp(zzatp zzatp, long j2) {
        zzatp.zzd |= 8;
        zzatp.zzh = j2;
    }

    public final long zza() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i3 == 3) {
            return new zzatp();
        } else {
            if (i3 == 4) {
                return new zzato((zzatn) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final long zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final String zzk() {
        return this.zze;
    }
}
