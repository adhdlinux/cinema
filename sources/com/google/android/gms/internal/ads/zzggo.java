package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

final class zzggo extends zzget {
    zzggo(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzgjz zzgjz = (zzgjz) zzgqw;
        int zzg = zzgjz.zzg().zzg();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzgjz.zzh().zzA(), "HMAC");
        int zza = zzgjz.zzg().zza();
        int i2 = zzg - 2;
        if (i2 == 1) {
            return new zzgne(new zzgnd("HMACSHA1", secretKeySpec), zza);
        }
        if (i2 == 2) {
            return new zzgne(new zzgnd("HMACSHA384", secretKeySpec), zza);
        }
        if (i2 == 3) {
            return new zzgne(new zzgnd("HMACSHA256", secretKeySpec), zza);
        }
        if (i2 == 4) {
            return new zzgne(new zzgnd("HMACSHA512", secretKeySpec), zza);
        }
        if (i2 == 5) {
            return new zzgne(new zzgnd("HMACSHA224", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
