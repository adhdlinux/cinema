package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Iterator;
import java.util.List;

public final class zzazi extends zzgpm implements zzgqx {
    private static final zzgps zzb = new zzazg();
    /* access modifiers changed from: private */
    public static final zzazi zzd;
    private int zze;
    private long zzf;
    private int zzg;
    private long zzh;
    private long zzi;
    private zzgpr zzj = zzgpm.zzaJ();
    private zzazd zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private long zzr;

    static {
        zzazi zzazi = new zzazi();
        zzd = zzazi;
        zzgpm.zzaU(zzazi.class, zzazi);
    }

    private zzazi() {
    }

    static /* synthetic */ void zzA(zzazi zzazi, int i2) {
        zzazi.zzm = i2 - 1;
        zzazi.zze |= 64;
    }

    static /* synthetic */ void zzB(zzazi zzazi, int i2) {
        zzazi.zzn = i2 - 1;
        zzazi.zze |= 128;
    }

    static /* synthetic */ void zzC(zzazi zzazi, int i2) {
        zzazi.zzp = i2 - 1;
        zzazi.zze |= 512;
    }

    public static zzazh zzg() {
        return (zzazh) zzd.zzaA();
    }

    public static zzazi zzi(byte[] bArr) throws zzgpy {
        return (zzazi) zzgpm.zzaF(zzd, bArr);
    }

    static /* synthetic */ void zzl(zzazi zzazi, long j2) {
        zzazi.zze |= 1;
        zzazi.zzf = j2;
    }

    static /* synthetic */ void zzm(zzazi zzazi, long j2) {
        zzazi.zze |= 4;
        zzazi.zzh = j2;
    }

    static /* synthetic */ void zzn(zzazi zzazi, long j2) {
        zzazi.zze |= 8;
        zzazi.zzi = j2;
    }

    static /* synthetic */ void zzo(zzazi zzazi, Iterable iterable) {
        zzgpr zzgpr = zzazi.zzj;
        if (!zzgpr.zzc()) {
            zzazi.zzj = zzgpm.zzaK(zzgpr);
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            zzazi.zzj.zzh(((zzaxx) it2.next()).zza());
        }
    }

    static /* synthetic */ void zzp(zzazi zzazi, zzazd zzazd) {
        zzazd.getClass();
        zzazi.zzk = zzazd;
        zzazi.zze |= 16;
    }

    static /* synthetic */ void zzq(zzazi zzazi, int i2) {
        zzazi.zze |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
        zzazi.zzo = i2;
    }

    static /* synthetic */ void zzr(zzazi zzazi, zzazm zzazm) {
        zzazi.zzq = zzazm.zza();
        zzazi.zze |= 1024;
    }

    static /* synthetic */ void zzs(zzazi zzazi, long j2) {
        zzazi.zze |= 2048;
        zzazi.zzr = j2;
    }

    static /* synthetic */ void zzy(zzazi zzazi, int i2) {
        zzazi.zzg = i2 - 1;
        zzazi.zze |= 2;
    }

    static /* synthetic */ void zzz(zzazi zzazi, int i2) {
        zzazi.zzl = i2 - 1;
        zzazi.zze |= 32;
    }

    public final int zza() {
        return this.zzo;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzgpq zzgpq = zzaym.zza;
            return zzgpm.zzaR(zzd, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ࠞ\u0006ဉ\u0004\u0007᠌\u0005\b᠌\u0006\t᠌\u0007\nင\b\u000b᠌\t\f᠌\n\rဂ\u000b", new Object[]{"zze", "zzf", "zzg", zzgpq, "zzh", "zzi", "zzj", zzaxw.zza, "zzk", "zzl", zzgpq, "zzm", zzgpq, "zzn", zzgpq, "zzo", "zzp", zzgpq, "zzq", zzazl.zza, "zzr"});
        } else if (i3 == 3) {
            return new zzazi();
        } else {
            if (i3 == 4) {
                return new zzazh((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzd;
        }
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzazd zzf() {
        zzazd zzazd = this.zzk;
        return zzazd == null ? zzazd.zzd() : zzazd;
    }

    public final zzazm zzj() {
        zzazm zzb2 = zzazm.zzb(this.zzq);
        return zzb2 == null ? zzazm.UNSPECIFIED : zzb2;
    }

    public final List zzk() {
        return new zzgpt(this.zzj, zzb);
    }

    public final int zzt() {
        int zza = zzayn.zza(this.zzm);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzu() {
        int zza = zzayn.zza(this.zzn);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzv() {
        int zza = zzayn.zza(this.zzp);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzw() {
        int zza = zzayn.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzx() {
        int zza = zzayn.zza(this.zzl);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
