package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzgva extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgva zzb;
    private zzgpv zzA = zzgpm.zzaN();
    private zzgtr zzB;
    private String zzC = "";
    private zzgtj zzD;
    private zzgpv zzE = zzgpm.zzaN();
    private zzguk zzF;
    private int zzG;
    private byte zzH = 2;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzgtn zzj;
    private zzgpv zzk = zzgpm.zzaN();
    private zzgpv zzl = zzgpm.zzaN();
    private String zzm = "";
    private zzgun zzn;
    private boolean zzo;
    private zzgpv zzp = zzgpm.zzaN();
    private String zzq = "";
    private boolean zzr;
    private boolean zzs;
    private zzgoe zzt = zzgoe.zzb;
    private zzguv zzu;
    private boolean zzv;
    private String zzw = "";
    private zzgpv zzx = zzgpm.zzaN();
    private zzgpv zzy = zzgpm.zzaN();
    private zzguz zzz;

    static {
        zzgva zzgva = new zzgva();
        zzb = zzgva;
        zzgpm.zzaU(zzgva.class, zzgva);
    }

    private zzgva() {
    }

    public static zzgtl zza() {
        return (zzgtl) zzb.zzaA();
    }

    static /* synthetic */ void zzg(zzgva zzgva, String str) {
        str.getClass();
        zzgva.zzd |= 4;
        zzgva.zzg = str;
    }

    static /* synthetic */ void zzh(zzgva zzgva, String str) {
        str.getClass();
        zzgva.zzd |= 8;
        zzgva.zzh = str;
    }

    static /* synthetic */ void zzi(zzgva zzgva, zzgtn zzgtn) {
        zzgtn.getClass();
        zzgva.zzj = zzgtn;
        zzgva.zzd |= 32;
    }

    static /* synthetic */ void zzj(zzgva zzgva, zzgut zzgut) {
        zzgut.getClass();
        zzgpv zzgpv = zzgva.zzk;
        if (!zzgpv.zzc()) {
            zzgva.zzk = zzgpm.zzaO(zzgpv);
        }
        zzgva.zzk.add(zzgut);
    }

    static /* synthetic */ void zzk(zzgva zzgva, String str) {
        zzgva.zzd |= 64;
        zzgva.zzm = str;
    }

    static /* synthetic */ void zzl(zzgva zzgva) {
        zzgva.zzd &= -65;
        zzgva.zzm = zzb.zzm;
    }

    static /* synthetic */ void zzm(zzgva zzgva, zzgun zzgun) {
        zzgun.getClass();
        zzgva.zzn = zzgun;
        zzgva.zzd |= 128;
    }

    static /* synthetic */ void zzn(zzgva zzgva, zzguv zzguv) {
        zzguv.getClass();
        zzgva.zzu = zzguv;
        zzgva.zzd |= 8192;
    }

    static /* synthetic */ void zzo(zzgva zzgva, Iterable iterable) {
        zzgpv zzgpv = zzgva.zzx;
        if (!zzgpv.zzc()) {
            zzgva.zzx = zzgpm.zzaO(zzgpv);
        }
        zzgnn.zzav(iterable, zzgva.zzx);
    }

    static /* synthetic */ void zzp(zzgva zzgva, Iterable iterable) {
        zzgpv zzgpv = zzgva.zzy;
        if (!zzgpv.zzc()) {
            zzgva.zzy = zzgpm.zzaO(zzgpv);
        }
        zzgnn.zzav(iterable, zzgva.zzy);
    }

    static /* synthetic */ void zzq(zzgva zzgva, int i2) {
        zzgva.zze = i2 - 1;
        zzgva.zzd |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzH);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u001d\u0000\u0001\u0001\u001d\u001d\u0000\u0007\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015", new Object[]{"zzd", "zzg", "zzh", "zzi", "zzk", zzgut.class, "zzo", "zzp", "zzq", "zzr", "zzs", "zze", zzguo.zza, "zzf", zzgtk.zza, "zzj", "zzm", "zzn", "zzt", "zzl", zzgve.class, "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", zzgvk.class, "zzB", "zzC", "zzD", "zzE", zzgtv.class, "zzF", "zzG", zzgux.zza});
        } else if (i3 == 3) {
            return new zzgva();
        } else {
            if (i3 == 4) {
                return new zzgtl((zzgtb) null);
            }
            if (i3 == 5) {
                return zzb;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzH = b2;
            return null;
        }
    }

    public final String zzd() {
        return this.zzm;
    }

    public final String zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzk;
    }
}
