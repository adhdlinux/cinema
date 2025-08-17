package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzbmn implements zzble, zzbmm {
    private final zzbmm zza;
    private final HashSet zzb = new HashSet();

    public zzbmn(zzbmm zzbmm) {
        this.zza = zzbmm;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbld.zzc(this, str, str2);
    }

    public final void zzc() {
        Iterator it2 = this.zzb.iterator();
        while (it2.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it2.next();
            zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzbij) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbij) simpleEntry.getValue());
        }
        this.zzb.clear();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbld.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbld.zzb(this, str, jSONObject);
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbld.zzd(this, str, jSONObject);
    }

    public final void zzq(String str, zzbij zzbij) {
        this.zza.zzq(str, zzbij);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbij));
    }

    public final void zzr(String str, zzbij zzbij) {
        this.zza.zzr(str, zzbij);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbij));
    }
}
