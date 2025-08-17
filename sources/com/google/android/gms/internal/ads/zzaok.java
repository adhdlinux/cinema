package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import okhttp3.internal.http2.Http2;

public final class zzaok extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaok zzb;
    private int zzd;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private int zzk = 1000;
    private long zzl = -1;
    private long zzm = -1;
    private long zzn = -1;
    private int zzo = 1000;
    private long zzp = -1;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzt;
    private long zzu;
    private long zzv = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;

    static {
        zzaok zzaok = new zzaok();
        zzb = zzaok;
        zzgpm.zzaU(zzaok.class, zzaok);
    }

    private zzaok() {
    }

    public static zzaoj zza() {
        return (zzaoj) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzaok zzaok, long j2) {
        zzaok.zzd |= 1;
        zzaok.zze = j2;
    }

    static /* synthetic */ void zze(zzaok zzaok, long j2) {
        zzaok.zzd |= 2;
        zzaok.zzf = j2;
    }

    static /* synthetic */ void zzf(zzaok zzaok, long j2) {
        zzaok.zzd |= 4;
        zzaok.zzg = j2;
    }

    static /* synthetic */ void zzg(zzaok zzaok, long j2) {
        zzaok.zzd |= 8;
        zzaok.zzh = j2;
    }

    static /* synthetic */ void zzh(zzaok zzaok) {
        zzaok.zzd &= -9;
        zzaok.zzh = -1;
    }

    static /* synthetic */ void zzi(zzaok zzaok, long j2) {
        zzaok.zzd |= 16;
        zzaok.zzi = j2;
    }

    static /* synthetic */ void zzj(zzaok zzaok, long j2) {
        zzaok.zzd |= 32;
        zzaok.zzj = j2;
    }

    static /* synthetic */ void zzk(zzaok zzaok, long j2) {
        zzaok.zzd |= 128;
        zzaok.zzl = j2;
    }

    static /* synthetic */ void zzl(zzaok zzaok, long j2) {
        zzaok.zzd |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
        zzaok.zzm = j2;
    }

    static /* synthetic */ void zzm(zzaok zzaok, long j2) {
        zzaok.zzd |= 512;
        zzaok.zzn = j2;
    }

    static /* synthetic */ void zzn(zzaok zzaok, long j2) {
        zzaok.zzd |= 2048;
        zzaok.zzp = j2;
    }

    static /* synthetic */ void zzo(zzaok zzaok, long j2) {
        zzaok.zzd |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        zzaok.zzq = j2;
    }

    static /* synthetic */ void zzp(zzaok zzaok, long j2) {
        zzaok.zzd |= 8192;
        zzaok.zzr = j2;
    }

    static /* synthetic */ void zzq(zzaok zzaok, long j2) {
        zzaok.zzd |= Http2.INITIAL_MAX_FRAME_SIZE;
        zzaok.zzs = j2;
    }

    static /* synthetic */ void zzr(zzaok zzaok, long j2) {
        zzaok.zzd |= 32768;
        zzaok.zzt = j2;
    }

    static /* synthetic */ void zzs(zzaok zzaok, long j2) {
        zzaok.zzd |= 65536;
        zzaok.zzu = j2;
    }

    static /* synthetic */ void zzt(zzaok zzaok, long j2) {
        zzaok.zzd |= 131072;
        zzaok.zzv = j2;
    }

    static /* synthetic */ void zzu(zzaok zzaok, long j2) {
        zzaok.zzd |= 262144;
        zzaok.zzw = j2;
    }

    static /* synthetic */ void zzv(zzaok zzaok, int i2) {
        zzaok.zzk = i2 - 1;
        zzaok.zzd |= 64;
    }

    static /* synthetic */ void zzw(zzaok zzaok, int i2) {
        zzaok.zzo = i2 - 1;
        zzaok.zzd |= 1024;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzgpq zzgpq = zzaot.zza;
            return zzgpm.zzaR(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzgpq, "zzl", "zzm", "zzn", "zzo", zzgpq, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
        } else if (i3 == 3) {
            return new zzaok();
        } else {
            if (i3 == 4) {
                return new zzaoj((zzanp) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
