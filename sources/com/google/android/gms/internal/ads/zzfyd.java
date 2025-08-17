package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzfyd {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzfyc zza(String str) throws GeneralSecurityException {
        Iterator it2 = zza.iterator();
        while (it2.hasNext()) {
            zzfyc zzfyc = (zzfyc) it2.next();
            if (zzfyc.zza()) {
                return zzfyc;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
