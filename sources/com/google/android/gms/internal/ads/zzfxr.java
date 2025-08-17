package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

final class zzfxr {
    private static final Logger zza = Logger.getLogger(zzfxr.class.getName());
    private final ConcurrentMap zzb;

    zzfxr() {
        this.zzb = new ConcurrentHashMap();
    }

    private final synchronized zzfxq zze(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzfxq) this.zzb.get(str);
    }

    private final synchronized void zzf(zzfxq zzfxq, boolean z2) throws GeneralSecurityException {
        String zzc = zzfxq.zza().zzc();
        zzfxq zzfxq2 = (zzfxq) this.zzb.get(zzc);
        if (zzfxq2 != null) {
            if (!zzfxq2.zza.getClass().equals(zzfxq.zza.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(zzc));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zzc, zzfxq2.zza.getClass().getName(), zzfxq.zza.getClass().getName()}));
            }
        }
        this.zzb.putIfAbsent(zzc, zzfxq);
    }

    /* access modifiers changed from: package-private */
    public final zzfxo zza(String str, Class cls) throws GeneralSecurityException {
        zzfxq zze = zze(str);
        if (zze.zza.zzl().contains(cls)) {
            try {
                return new zzfxp(zze.zza, cls);
            } catch (IllegalArgumentException e2) {
                throw new GeneralSecurityException("Primitive type not supported", e2);
            }
        } else {
            String name = cls.getName();
            String valueOf = String.valueOf(zze.zza.getClass());
            Set<Class> zzl = zze.zza.zzl();
            StringBuilder sb = new StringBuilder();
            boolean z2 = true;
            for (Class cls2 : zzl) {
                if (!z2) {
                    sb.append(", ");
                }
                sb.append(cls2.getCanonicalName());
                z2 = false;
            }
            String sb2 = sb.toString();
            throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzfxo zzb(String str) throws GeneralSecurityException {
        return zze(str).zza();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(zzgdu zzgdu) throws GeneralSecurityException {
        if (zzgdh.zza(zzgdu.zzf())) {
            zzf(new zzfxq(zzgdu), false);
        } else {
            String valueOf = String.valueOf(zzgdu.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(String str) {
        return this.zzb.containsKey(str);
    }

    zzfxr(zzfxr zzfxr) {
        this.zzb = new ConcurrentHashMap(zzfxr.zzb);
    }
}
