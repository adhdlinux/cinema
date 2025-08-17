package com.google.android.gms.internal.ads;

final class zzgqo implements zzgrq {
    private static final zzgqu zza = new zzgqm();
    private final zzgqu zzb;

    public zzgqo() {
        zzgqu zzgqu;
        zzgqu[] zzgquArr = new zzgqu[2];
        zzgquArr[0] = zzgph.zza();
        try {
            zzgqu = (zzgqu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzgqu = zza;
        }
        zzgquArr[1] = zzgqu;
        zzgqn zzgqn = new zzgqn(zzgquArr);
        byte[] bArr = zzgpw.zzd;
        this.zzb = zzgqn;
    }

    private static boolean zzb(zzgqt zzgqt) {
        return zzgqt.zzc() + -1 != 1;
    }

    public final zzgrp zza(Class cls) {
        zzgrr.zzD(cls);
        zzgqt zzb2 = this.zzb.zzb(cls);
        Class<zzgpm> cls2 = zzgpm.class;
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzgra.zzc(zzgrr.zzz(), zzgpb.zzb(), zzb2.zza());
            }
            return zzgra.zzc(zzgrr.zzy(), zzgpb.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzgqz.zzl(cls, zzb2, zzgrc.zzb(), zzgqk.zze(), zzgrr.zzz(), zzgpb.zzb(), zzgqs.zzb());
            }
            return zzgqz.zzl(cls, zzb2, zzgrc.zzb(), zzgqk.zze(), zzgrr.zzz(), (zzgoz) null, zzgqs.zzb());
        } else if (zzb(zzb2)) {
            return zzgqz.zzl(cls, zzb2, zzgrc.zza(), zzgqk.zzd(), zzgrr.zzy(), zzgpb.zza(), zzgqs.zza());
        } else {
            return zzgqz.zzl(cls, zzb2, zzgrc.zza(), zzgqk.zzd(), zzgrr.zzy(), (zzgoz) null, zzgqs.zza());
        }
    }
}
