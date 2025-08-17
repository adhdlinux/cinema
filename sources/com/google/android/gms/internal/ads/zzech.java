package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzech {
    private final List zza = Collections.synchronizedList(new ArrayList());
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final String zzc;
    private zzezq zzd = null;
    private zzezn zze = null;
    private zzu zzf = null;

    public zzech(String str) {
        this.zzc = str;
    }

    private final synchronized void zzi(zzezn zzezn, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            str = zzezn.zzaq;
        } else {
            str = zzezn.zzx;
        }
        if (!this.zzb.containsKey(str)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzezn.zzw.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzezn.zzw.getString(next));
                } catch (JSONException unused) {
                }
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzgB)).booleanValue()) {
                str5 = zzezn.zzG;
                str4 = zzezn.zzH;
                str3 = zzezn.zzI;
                str2 = zzezn.zzJ;
            } else {
                str5 = "";
                str4 = "";
                str3 = "";
                str2 = "";
            }
            zzu zzu = new zzu(zzezn.zzF, 0, (zze) null, bundle, str5, str4, str3, str2);
            try {
                this.zza.add(i2, zzu);
            } catch (IndexOutOfBoundsException e2) {
                zzt.zzo().zzu(e2, "AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation");
            }
            this.zzb.put(str, zzu);
        }
    }

    private final void zzj(zzezn zzezn, long j2, zze zze2, boolean z2) {
        String str;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdj)).booleanValue()) {
            str = zzezn.zzaq;
        } else {
            str = zzezn.zzx;
        }
        if (this.zzb.containsKey(str)) {
            if (this.zze == null) {
                this.zze = zzezn;
            }
            zzu zzu = (zzu) this.zzb.get(str);
            zzu.zzb = j2;
            zzu.zzc = zze2;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzgC)).booleanValue() && z2) {
                this.zzf = zzu;
            }
        }
    }

    public final zzu zza() {
        return this.zzf;
    }

    public final zzcuz zzb() {
        return new zzcuz(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzezn zzezn) {
        zzi(zzezn, this.zza.size());
    }

    public final void zze(zzezn zzezn, long j2, zze zze2) {
        zzj(zzezn, j2, zze2, false);
    }

    public final void zzf(zzezn zzezn, long j2, zze zze2) {
        zzj(zzezn, j2, (zze) null, true);
    }

    public final synchronized void zzg(String str, List list) {
        if (this.zzb.containsKey(str)) {
            int indexOf = this.zza.indexOf((zzu) this.zzb.get(str));
            try {
                this.zza.remove(indexOf);
            } catch (IndexOutOfBoundsException e2) {
                zzt.zzo().zzu(e2, "AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry");
            }
            this.zzb.remove(str);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                zzi((zzezn) it2.next(), indexOf);
                indexOf++;
            }
        }
    }

    public final void zzh(zzezq zzezq) {
        this.zzd = zzezq;
    }
}
