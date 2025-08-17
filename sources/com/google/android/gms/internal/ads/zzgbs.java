package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgbs extends zzfyt {
    private final zzgbx zza;
    private final zzgnl zzb;
    private final zzgnk zzc;
    private final Integer zzd;

    private zzgbs(zzgbx zzgbx, zzgnl zzgnl, zzgnk zzgnk, Integer num) {
        this.zza = zzgbx;
        this.zzb = zzgnl;
        this.zzc = zzgnk;
        this.zzd = num;
    }

    public static zzgbs zza(zzgbw zzgbw, zzgnl zzgnl, Integer num) throws GeneralSecurityException {
        zzgnk zzgnk;
        zzgbw zzgbw2 = zzgbw.zzc;
        if (zzgbw != zzgbw2 && num == null) {
            String obj = zzgbw.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgbw == zzgbw2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgnl.zza() == 32) {
            zzgbx zzb2 = zzgbx.zzb(zzgbw);
            if (zzb2.zza() == zzgbw2) {
                zzgnk = zzgnk.zzb(new byte[0]);
            } else if (zzb2.zza() == zzgbw.zzb) {
                zzgnk = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzb2.zza() == zzgbw.zza) {
                zzgnk = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
            }
            return new zzgbs(zzb2, zzgnl, zzgnk, num);
        } else {
            int zza2 = zzgnl.zza();
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }
}
