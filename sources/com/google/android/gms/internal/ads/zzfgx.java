package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzfgx {
    private final zzfhe zza;
    private final zzfhe zzb;
    private final zzfhb zzc;
    private final zzfhd zzd;

    private zzfgx(zzfhb zzfhb, zzfhd zzfhd, zzfhe zzfhe, zzfhe zzfhe2, boolean z2) {
        this.zzc = zzfhb;
        this.zzd = zzfhd;
        this.zza = zzfhe;
        if (zzfhe2 == null) {
            this.zzb = zzfhe.NONE;
        } else {
            this.zzb = zzfhe2;
        }
    }

    public static zzfgx zza(zzfhb zzfhb, zzfhd zzfhd, zzfhe zzfhe, zzfhe zzfhe2, boolean z2) {
        zzfid.zzb(zzfhd, "ImpressionType is null");
        zzfid.zzb(zzfhe, "Impression owner is null");
        if (zzfhe == zzfhe.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzfhb == zzfhb.DEFINED_BY_JAVASCRIPT && zzfhe == zzfhe.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzfhd != zzfhd.DEFINED_BY_JAVASCRIPT || zzfhe != zzfhe.NATIVE) {
            return new zzfgx(zzfhb, zzfhd, zzfhe, zzfhe2, true);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfib.zze(jSONObject, "impressionOwner", this.zza);
        zzfib.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfib.zze(jSONObject, "creativeType", this.zzc);
        zzfib.zze(jSONObject, "impressionType", this.zzd);
        zzfib.zze(jSONObject, "isolateVerificationScripts", Boolean.TRUE);
        return jSONObject;
    }
}
