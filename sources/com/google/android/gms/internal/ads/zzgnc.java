package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

final class zzgnc extends ThreadLocal {
    final /* synthetic */ zzgnd zza;

    zzgnc(zzgnd zzgnd) {
        this.zza = zzgnd;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac mac = (Mac) zzgmq.zzb.zza(this.zza.zzb);
            mac.init(this.zza.zzc);
            return mac;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
