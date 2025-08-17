package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

public final class zzgmq {
    public static final zzgmq zza = new zzgmq(new zzgmr());
    public static final zzgmq zzb = new zzgmq(new zzgmv());
    public static final zzgmq zzc = new zzgmq(new zzgmx());
    public static final zzgmq zzd = new zzgmq(new zzgmw());
    public static final zzgmq zze = new zzgmq(new zzgms());
    public static final zzgmq zzf = new zzgmq(new zzgmu());
    public static final zzgmq zzg = new zzgmq(new zzgmt());
    private final zzgmp zzh;

    public zzgmq(zzgmy zzgmy) {
        if (zzgdi.zzb()) {
            this.zzh = new zzgmo(zzgmy, (zzgmn) null);
        } else if (zzgnh.zza()) {
            this.zzh = new zzgmk(zzgmy, (zzgmj) null);
        } else {
            this.zzh = new zzgmm(zzgmy, (zzgml) null);
        }
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }
}
