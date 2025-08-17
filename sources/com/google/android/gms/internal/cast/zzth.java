package com.google.android.gms.internal.cast;

final class zzth implements zzub {
    private static final zztn zza = new zztf();
    private final zztn zzb;

    public zzth() {
        zztn zztn;
        zztn[] zztnArr = new zztn[2];
        zztnArr[0] = zzsd.zza();
        try {
            zztn = (zztn) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zztn = zza;
        }
        zztnArr[1] = zztn;
        zztg zztg = new zztg(zztnArr);
        byte[] bArr = zzsq.zzd;
        this.zzb = zztg;
    }

    private static boolean zzb(zztm zztm) {
        return zztm.zzc() == 1;
    }

    public final zzua zza(Class cls) {
        zzuc.zzC(cls);
        zztm zzb2 = this.zzb.zzb(cls);
        Class<zzsh> cls2 = zzsh.class;
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zztt.zzi(zzuc.zzA(), zzrz.zzb(), zzb2.zza());
            }
            return zztt.zzi(zzuc.zzy(), zzrz.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzts.zzi(cls, zzb2, zztv.zzb(), zztd.zzd(), zzuc.zzA(), zzrz.zzb(), zztl.zzb());
            }
            return zzts.zzi(cls, zzb2, zztv.zzb(), zztd.zzd(), zzuc.zzA(), (zzrx) null, zztl.zzb());
        } else if (zzb(zzb2)) {
            return zzts.zzi(cls, zzb2, zztv.zza(), zztd.zzc(), zzuc.zzy(), zzrz.zza(), zztl.zza());
        } else {
            return zzts.zzi(cls, zzb2, zztv.zza(), zztd.zzc(), zzuc.zzz(), (zzrx) null, zztl.zza());
        }
    }
}
