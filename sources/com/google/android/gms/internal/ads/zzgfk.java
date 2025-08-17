package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public final class zzgfk {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    /* synthetic */ zzgfk(zzgfe zzgfe, zzgfj zzgfj) {
        this.zza = new HashMap(zzgfe.zza);
        this.zzb = new HashMap(zzgfe.zzb);
        this.zzc = new HashMap(zzgfe.zzc);
        this.zzd = new HashMap(zzgfe.zzd);
    }

    public final zzfxn zza(zzgfd zzgfd, zzfyq zzfyq) throws GeneralSecurityException {
        zzgfg zzgfg = new zzgfg(zzgfd.getClass(), zzgfd.zzd(), (zzgff) null);
        if (this.zzb.containsKey(zzgfg)) {
            return ((zzgdn) this.zzb.get(zzgfg)).zza(zzgfd, zzfyq);
        }
        String obj = zzgfg.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final zzfyf zzb(zzgfd zzgfd) throws GeneralSecurityException {
        zzgfg zzgfg = new zzgfg(zzgfd.getClass(), zzgfd.zzd(), (zzgff) null);
        if (this.zzd.containsKey(zzgfg)) {
            return ((zzgek) this.zzd.get(zzgfg)).zza(zzgfd);
        }
        String obj = zzgfg.toString();
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + obj + " available");
    }

    public final zzgfd zzc(zzfyf zzfyf, Class cls) throws GeneralSecurityException {
        zzgfi zzgfi = new zzgfi(zzfyf.getClass(), cls, (zzgfh) null);
        if (this.zzc.containsKey(zzgfi)) {
            return ((zzgeo) this.zzc.get(zzgfi)).zza(zzfyf);
        }
        String obj = zzgfi.toString();
        throw new GeneralSecurityException("No Key Format serializer for " + obj + " available");
    }

    public final boolean zzh(zzgfd zzgfd) {
        return this.zzb.containsKey(new zzgfg(zzgfd.getClass(), zzgfd.zzd(), (zzgff) null));
    }

    public final boolean zzi(zzgfd zzgfd) {
        return this.zzd.containsKey(new zzgfg(zzgfd.getClass(), zzgfd.zzd(), (zzgff) null));
    }
}
