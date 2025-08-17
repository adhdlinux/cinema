package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

final class zzghh implements zzfyn {
    /* access modifiers changed from: private */
    public static final Logger zza = Logger.getLogger(zzghh.class.getName());
    /* access modifiers changed from: private */
    public static final byte[] zzb = {0};
    private static final zzghh zzc = new zzghh();

    zzghh() {
    }

    public static void zze() throws GeneralSecurityException {
        zzfyp.zzf(zzc);
    }

    public final Class zza() {
        return zzfye.class;
    }

    public final Class zzb() {
        return zzfye.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzfym zzfym) throws GeneralSecurityException {
        for (List it2 : zzfym.zzd()) {
            Iterator it3 = it2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    zzfyi zzfyi = (zzfyi) it3.next();
                    if (zzfyi.zzb() instanceof zzghd) {
                        zzghd zzghd = (zzghd) zzfyi.zzb();
                        zzgnk zzb2 = zzgnk.zzb(zzfyi.zzg());
                        if (!zzb2.equals(zzghd.zzb())) {
                            String valueOf = String.valueOf(zzghd.zza());
                            String obj = zzghd.zzb().toString();
                            String obj2 = zzb2.toString();
                            throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + obj + ") instead of (" + obj2 + ")");
                        }
                    }
                }
            }
        }
        return new zzghg(zzfym, (zzghf) null);
    }
}
