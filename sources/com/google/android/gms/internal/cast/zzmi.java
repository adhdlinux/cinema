package com.google.android.gms.internal.cast;

import com.google.protobuf.CodedOutputStream;
import okhttp3.internal.http2.Http2;

public final class zzmi extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmi zzb;
    private int zzd;
    private zznc zze;
    private boolean zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzov zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;

    static {
        zzmi zzmi = new zzmi();
        zzb = zzmi;
        zzsh.zzG(zzmi.class, zzmi);
    }

    private zzmi() {
    }

    public static zzmh zza() {
        return (zzmh) zzb.zzu();
    }

    public static zzmh zzc(zzmi zzmi) {
        zzse zzu = zzb.zzu();
        zzu.zzo(zzmi);
        return (zzmh) zzu;
    }

    public static zzmi zze() {
        return zzb;
    }

    static /* synthetic */ void zzf(zzmi zzmi, zznc zznc) {
        zznc.getClass();
        zzmi.zze = zznc;
        zzmi.zzd |= 1;
    }

    static /* synthetic */ void zzg(zzmi zzmi, boolean z2) {
        zzmi.zzd |= 2;
        zzmi.zzf = z2;
    }

    static /* synthetic */ void zzh(zzmi zzmi, long j2) {
        zzmi.zzd |= 4;
        zzmi.zzg = j2;
    }

    static /* synthetic */ void zzi(zzmi zzmi, int i2) {
        zzmi.zzd |= 64;
        zzmi.zzk = i2;
    }

    static /* synthetic */ void zzj(zzmi zzmi, int i2) {
        zzmi.zzd |= 128;
        zzmi.zzl = i2;
    }

    static /* synthetic */ void zzk(zzmi zzmi, int i2) {
        zzmi.zzd |= 1024;
        zzmi.zzo = i2;
    }

    static /* synthetic */ void zzl(zzmi zzmi, boolean z2) {
        zzmi.zzd |= 2048;
        zzmi.zzp = z2;
    }

    static /* synthetic */ void zzm(zzmi zzmi, int i2) {
        zzmi.zzd |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        zzmi.zzq = i2;
    }

    static /* synthetic */ void zzn(zzmi zzmi, int i2) {
        zzmi.zzd |= 8192;
        zzmi.zzr = i2;
    }

    static /* synthetic */ void zzo(zzmi zzmi, boolean z2) {
        zzmi.zzd |= Http2.INITIAL_MAX_FRAME_SIZE;
        zzmi.zzs = z2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007င\u0006\bင\u0007\tဉ\b\nဌ\t\u000bင\n\fဇ\u000b\rင\f\u000eင\r\u000fဇ\u000e", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzgu.zza(), "zzj", zzgr.zza(), "zzk", "zzl", "zzm", "zzn", zzih.zza(), "zzo", "zzp", "zzq", "zzr", "zzs"});
        } else if (i3 == 3) {
            return new zzmi();
        } else {
            if (i3 == 4) {
                return new zzmh((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
