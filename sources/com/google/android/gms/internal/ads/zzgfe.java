package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public final class zzgfe {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzgfe() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgfe zza(zzgdn zzgdn) throws GeneralSecurityException {
        zzgfg zzgfg = new zzgfg(zzgdn.zzd(), zzgdn.zzc(), (zzgff) null);
        if (this.zzb.containsKey(zzgfg)) {
            zzgdn zzgdn2 = (zzgdn) this.zzb.get(zzgfg);
            if (!zzgdn2.equals(zzgdn) || !zzgdn.equals(zzgdn2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgfg.toString()));
            }
        } else {
            this.zzb.put(zzgfg, zzgdn);
        }
        return this;
    }

    public final zzgfe zzb(zzgdr zzgdr) throws GeneralSecurityException {
        zzgfi zzgfi = new zzgfi(zzgdr.zzb(), zzgdr.zzc(), (zzgfh) null);
        if (this.zza.containsKey(zzgfi)) {
            zzgdr zzgdr2 = (zzgdr) this.zza.get(zzgfi);
            if (!zzgdr2.equals(zzgdr) || !zzgdr.equals(zzgdr2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgfi.toString()));
            }
        } else {
            this.zza.put(zzgfi, zzgdr);
        }
        return this;
    }

    public final zzgfe zzc(zzgek zzgek) throws GeneralSecurityException {
        zzgfg zzgfg = new zzgfg(zzgek.zzd(), zzgek.zzc(), (zzgff) null);
        if (this.zzd.containsKey(zzgfg)) {
            zzgek zzgek2 = (zzgek) this.zzd.get(zzgfg);
            if (!zzgek2.equals(zzgek) || !zzgek.equals(zzgek2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgfg.toString()));
            }
        } else {
            this.zzd.put(zzgfg, zzgek);
        }
        return this;
    }

    public final zzgfe zzd(zzgeo zzgeo) throws GeneralSecurityException {
        zzgfi zzgfi = new zzgfi(zzgeo.zzc(), zzgeo.zzd(), (zzgfh) null);
        if (this.zzc.containsKey(zzgfi)) {
            zzgeo zzgeo2 = (zzgeo) this.zzc.get(zzgfi);
            if (!zzgeo2.equals(zzgeo) || !zzgeo.equals(zzgeo2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgfi.toString()));
            }
        } else {
            this.zzc.put(zzgfi, zzgeo);
        }
        return this;
    }

    public zzgfe(zzgfk zzgfk) {
        this.zza = new HashMap(zzgfk.zza);
        this.zzb = new HashMap(zzgfk.zzb);
        this.zzc = new HashMap(zzgfk.zzc);
        this.zzd = new HashMap(zzgfk.zzd);
    }
}
