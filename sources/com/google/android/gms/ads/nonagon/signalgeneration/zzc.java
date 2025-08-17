package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzc {
    /* access modifiers changed from: private */
    public final int zza;
    private final long zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final Map zze;
    /* access modifiers changed from: private */
    public final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();
    private final zzdqf zzh;
    private Map zzi;

    public zzc(zzdqf zzdqf) {
        this.zzh = zzdqf;
        this.zza = ((Integer) zzba.zzc().zzb(zzbbm.zzgL)).intValue();
        this.zzb = ((Long) zzba.zzc().zzb(zzbbm.zzgM)).longValue();
        this.zzc = ((Boolean) zzba.zzc().zzb(zzbbm.zzgR)).booleanValue();
        this.zzd = ((Boolean) zzba.zzc().zzb(zzbbm.zzgP)).booleanValue();
        this.zze = Collections.synchronizedMap(new zzb(this));
    }

    private final synchronized void zzg(zzdpv zzdpv) {
        if (this.zzc) {
            ArrayDeque clone = this.zzg.clone();
            this.zzg.clear();
            ArrayDeque clone2 = this.zzf.clone();
            this.zzf.clear();
            zzcae.zza.execute(new zza(this, zzdpv, clone, clone2));
        }
    }

    private final void zzh(zzdpv zzdpv, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdpv.zza());
            this.zzi = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.zzi.put("e_r", str);
            this.zzi.put("e_id", (String) pair2.first);
            if (this.zzd) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzf.zza(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                zzj(this.zzi, "e_type", (String) pair.first);
                zzj(this.zzi, "e_agent", (String) pair.second);
            }
            this.zzh.zze(this.zzi);
        }
    }

    private final synchronized void zzi() {
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        try {
            Iterator it2 = this.zze.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (currentTimeMillis - ((Long) ((Pair) entry.getValue()).first).longValue() <= this.zzb) {
                    break;
                }
                this.zzg.add(new Pair((String) entry.getKey(), (String) ((Pair) entry.getValue()).second));
                it2.remove();
            }
        } catch (ConcurrentModificationException e2) {
            zzt.zzo().zzu(e2, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private static final void zzj(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public final synchronized String zzb(String str, zzdpv zzdpv) {
        Pair pair = (Pair) this.zze.get(str);
        zzdpv.zza().put("rid", str);
        if (pair != null) {
            String str2 = (String) pair.second;
            this.zze.remove(str);
            zzdpv.zza().put("mhit", "true");
            return str2;
        }
        zzdpv.zza().put("mhit", Constants.CASEFIRST_FALSE);
        return null;
    }

    public final synchronized void zzd(String str, String str2, zzdpv zzdpv) {
        this.zze.put(str, new Pair(Long.valueOf(zzt.zzB().currentTimeMillis()), str2));
        zzi();
        zzg(zzdpv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzdpv zzdpv, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        zzh(zzdpv, arrayDeque, "to");
        zzh(zzdpv, arrayDeque2, "of");
    }

    public final synchronized void zzf(String str) {
        this.zze.remove(str);
    }
}
