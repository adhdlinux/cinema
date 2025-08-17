package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

public final class zzayp extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzayp zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private int zzg;
    private int zzh = 1000;
    private zzazz zzi;
    /* access modifiers changed from: private */
    public zzgpu zzj = zzgpm.zzaL();
    private zzayh zzk;
    private zzayk zzl;
    private zzazd zzm;
    private zzaxl zzn;
    private zzazn zzo;
    private zzbau zzp;
    private zzaxu zzq;

    static {
        zzayp zzayp = new zzayp();
        zzb = zzayp;
        zzgpm.zzaU(zzayp.class, zzayp);
    }

    private zzayp() {
    }

    public static zzayo zzd() {
        return (zzayo) zzb.zzaA();
    }

    static /* synthetic */ void zzg(zzayp zzayp, String str) {
        str.getClass();
        zzayp.zzd |= 2;
        zzayp.zzf = str;
    }

    static /* synthetic */ void zzh(zzayp zzayp, Iterable iterable) {
        zzgpu zzgpu = zzayp.zzj;
        if (!zzgpu.zzc()) {
            zzayp.zzj = zzgpm.zzaM(zzgpu);
        }
        zzgnn.zzav(iterable, zzayp.zzj);
    }

    static /* synthetic */ void zzj(zzayp zzayp, zzayh zzayh) {
        zzayh.getClass();
        zzayp.zzk = zzayh;
        zzayp.zzd |= 32;
    }

    static /* synthetic */ void zzk(zzayp zzayp, zzaxl zzaxl) {
        zzaxl.getClass();
        zzayp.zzn = zzaxl;
        zzayp.zzd |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
    }

    static /* synthetic */ void zzl(zzayp zzayp, zzazn zzazn) {
        zzazn.getClass();
        zzayp.zzo = zzazn;
        zzayp.zzd |= 512;
    }

    static /* synthetic */ void zzm(zzayp zzayp, zzbau zzbau) {
        zzbau.getClass();
        zzayp.zzp = zzbau;
        zzayp.zzd |= 1024;
    }

    static /* synthetic */ void zzn(zzayp zzayp, zzaxu zzaxu) {
        zzaxu.getClass();
        zzayp.zzq = zzaxu;
        zzayp.zzd |= 2048;
    }

    public final zzaxl zza() {
        zzaxl zzaxl = this.zzn;
        return zzaxl == null ? zzaxl.zzc() : zzaxl;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\f᠌\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzaym.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
        } else if (i3 == 3) {
            return new zzayp();
        } else {
            if (i3 == 4) {
                return new zzayo((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzayh zzc() {
        zzayh zzayh = this.zzk;
        return zzayh == null ? zzayh.zzc() : zzayh;
    }

    public final String zzf() {
        return this.zzf;
    }
}
