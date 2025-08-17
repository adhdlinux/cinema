package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgck extends zzfyt {
    private final zzgcp zza;
    private final zzgnl zzb;
    private final zzgnk zzc;
    private final Integer zzd;

    private zzgck(zzgcp zzgcp, zzgnl zzgnl, zzgnk zzgnk, Integer num) {
        this.zza = zzgcp;
        this.zzb = zzgnl;
        this.zzc = zzgnk;
        this.zzd = num;
    }

    public static zzgck zza(zzgco zzgco, zzgnl zzgnl, Integer num) throws GeneralSecurityException {
        zzgnk zzgnk;
        zzgco zzgco2 = zzgco.zzc;
        if (zzgco != zzgco2 && num == null) {
            String obj = zzgco.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgco == zzgco2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgnl.zza() == 32) {
            zzgcp zzb2 = zzgcp.zzb(zzgco);
            if (zzb2.zza() == zzgco2) {
                zzgnk = zzgnk.zzb(new byte[0]);
            } else if (zzb2.zza() == zzgco.zzb) {
                zzgnk = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzb2.zza() == zzgco.zza) {
                zzgnk = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
            }
            return new zzgck(zzb2, zzgnl, zzgnk, num);
        } else {
            int zza2 = zzgnl.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }
}
