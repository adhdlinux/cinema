package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzeii {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Executor zzd;
    private JSONObject zze;

    zzeii(Executor executor) {
        this.zzd = executor;
    }

    private final synchronized List zzg(JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        Bundle zzl = zzl(jSONObject.optJSONObject("data"));
        JSONArray optJSONArray = jSONObject.optJSONArray("rtb_adapters");
        if (optJSONArray == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            String optString = optJSONArray.optString(i2, "");
            if (!TextUtils.isEmpty(optString)) {
                arrayList2.add(optString);
            }
        }
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = (String) arrayList2.get(i3);
            zzf(str2);
            if (((zzeik) this.zza.get(str2)) != null) {
                arrayList.add(new zzeik(str2, str, zzl));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzh() {
        this.zzb.clear();
        this.zza.clear();
        zzj();
        zzk();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzi(java.lang.String r3, java.lang.String r4, java.util.List r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0036
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0036
            java.util.Map r0 = r2.zzc     // Catch:{ all -> 0x0038 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0038 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x001c
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0038 }
            r0.<init>()     // Catch:{ all -> 0x0038 }
        L_0x001c:
            java.util.Map r1 = r2.zzc     // Catch:{ all -> 0x0038 }
            r1.put(r3, r0)     // Catch:{ all -> 0x0038 }
            java.lang.Object r3 = r0.get(r4)     // Catch:{ all -> 0x0038 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0038 }
            if (r3 != 0) goto L_0x002e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0038 }
            r3.<init>()     // Catch:{ all -> 0x0038 }
        L_0x002e:
            r3.addAll(r5)     // Catch:{ all -> 0x0038 }
            r0.put(r4, r3)     // Catch:{ all -> 0x0038 }
            monitor-exit(r2)
            return
        L_0x0036:
            monitor-exit(r2)
            return
        L_0x0038:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeii.zzi(java.lang.String, java.lang.String, java.util.List):void");
    }

    private final synchronized void zzj() {
        String str;
        JSONObject zzf = zzt.zzo().zzh().zzh().zzf();
        if (zzf != null) {
            try {
                JSONArray optJSONArray = zzf.optJSONArray("ad_unit_id_settings");
                this.zze = zzf.optJSONObject("ad_unit_patterns");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjv)).booleanValue()) {
                            str = jSONObject.optString("ad_unit_id", "").toLowerCase(Locale.ROOT);
                        } else {
                            str = jSONObject.optString("ad_unit_id", "");
                        }
                        String optString = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("ad_networks");
                            if (optJSONArray2 != null) {
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    arrayList.addAll(zzg(optJSONArray2.getJSONObject(i3), optString));
                                }
                            }
                        }
                        zzi(optString, str, arrayList);
                    }
                }
            } catch (JSONException e2) {
                zze.zzb("Malformed config loading JSON.", e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzk() {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdk.zzf     // Catch:{ all -> 0x0083 }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0083 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzbF     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0083 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0083 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x0022
            goto L_0x0081
        L_0x0022:
            com.google.android.gms.internal.ads.zzbza r0 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x0083 }
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzh()     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzbyu r0 = r0.zzh()     // Catch:{ all -> 0x0083 }
            org.json.JSONObject r0 = r0.zzf()     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x0036
            monitor-exit(r9)
            return
        L_0x0036:
            java.lang.String r1 = "signal_adapters"
            org.json.JSONArray r0 = r0.getJSONArray(r1)     // Catch:{ JSONException -> 0x0079 }
            r1 = 0
            r2 = 0
        L_0x003e:
            int r3 = r0.length()     // Catch:{ JSONException -> 0x0079 }
            if (r2 >= r3) goto L_0x0077
            org.json.JSONObject r3 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r4 = "data"
            org.json.JSONObject r4 = r3.optJSONObject(r4)     // Catch:{ JSONException -> 0x0079 }
            android.os.Bundle r4 = zzl(r4)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r5 = "adapter_class_name"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r6 = "render"
            boolean r6 = r3.optBoolean(r6, r1)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r7 = "collect_signals"
            boolean r3 = r3.optBoolean(r7, r1)     // Catch:{ JSONException -> 0x0079 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0079 }
            if (r7 != 0) goto L_0x0074
            java.util.Map r7 = r9.zzb     // Catch:{ JSONException -> 0x0079 }
            com.google.android.gms.internal.ads.zzeim r8 = new com.google.android.gms.internal.ads.zzeim     // Catch:{ JSONException -> 0x0079 }
            r8.<init>(r5, r3, r6, r4)     // Catch:{ JSONException -> 0x0079 }
            r7.put(r5, r8)     // Catch:{ JSONException -> 0x0079 }
        L_0x0074:
            int r2 = r2 + 1
            goto L_0x003e
        L_0x0077:
            monitor-exit(r9)
            return
        L_0x0079:
            r0 = move-exception
            java.lang.String r1 = "Malformed config loading JSON."
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r0)     // Catch:{ all -> 0x0083 }
            monitor-exit(r9)
            return
        L_0x0081:
            monitor-exit(r9)
            return
        L_0x0083:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeii.zzk():void");
    }

    private static final Bundle zzl(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next, ""));
            }
        }
        return bundle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.Map zza(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00a7 }
            if (r0 != 0) goto L_0x00a1
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a7 }
            if (r0 != 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzbza r0 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzh()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.ads.zzbyu r0 = r0.zzh()     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r0.zzc()     // Catch:{ all -> 0x00a7 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x0025
            goto L_0x00a1
        L_0x0025:
            java.util.Map r0 = r3.zzc     // Catch:{ all -> 0x00a7 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x00a7 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00a7 }
            if (r0 != 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzfsf r4 = com.google.android.gms.internal.ads.zzfsf.zzd()     // Catch:{ all -> 0x00a7 }
            monitor-exit(r3)
            return r4
        L_0x0035:
            java.lang.Object r1 = r0.get(r5)     // Catch:{ all -> 0x00a7 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x0062
            org.json.JSONObject r1 = r3.zze     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = com.google.android.gms.internal.ads.zzdoc.zza(r1, r5, r4)     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.ads.zzbbe r5 = com.google.android.gms.internal.ads.zzbbm.zzjv     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a7 }
            java.lang.Object r5 = r1.zzb(r5)     // Catch:{ all -> 0x00a7 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x00a7 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x00a7 }
            if (r5 == 0) goto L_0x005b
            java.util.Locale r5 = java.util.Locale.ROOT     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.toLowerCase(r5)     // Catch:{ all -> 0x00a7 }
        L_0x005b:
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x00a7 }
            r1 = r4
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00a7 }
        L_0x0062:
            if (r1 != 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzfsf r4 = com.google.android.gms.internal.ads.zzfsf.zzd()     // Catch:{ all -> 0x00a7 }
            monitor-exit(r3)
            return r4
        L_0x006a:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00a7 }
            r4.<init>()     // Catch:{ all -> 0x00a7 }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ all -> 0x00a7 }
        L_0x0073:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x009b
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.ads.zzeik r0 = (com.google.android.gms.internal.ads.zzeik) r0     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = r0.zza     // Catch:{ all -> 0x00a7 }
            boolean r2 = r4.containsKey(r1)     // Catch:{ all -> 0x00a7 }
            if (r2 != 0) goto L_0x008f
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00a7 }
            r2.<init>()     // Catch:{ all -> 0x00a7 }
            r4.put(r1, r2)     // Catch:{ all -> 0x00a7 }
        L_0x008f:
            java.lang.Object r1 = r4.get(r1)     // Catch:{ all -> 0x00a7 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00a7 }
            android.os.Bundle r0 = r0.zzc     // Catch:{ all -> 0x00a7 }
            r1.add(r0)     // Catch:{ all -> 0x00a7 }
            goto L_0x0073
        L_0x009b:
            com.google.android.gms.internal.ads.zzfsf r4 = com.google.android.gms.internal.ads.zzfsf.zzc(r4)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r3)
            return r4
        L_0x00a1:
            com.google.android.gms.internal.ads.zzfsf r4 = com.google.android.gms.internal.ads.zzfsf.zzd()     // Catch:{ all -> 0x00a7 }
            monitor-exit(r3)
            return r4
        L_0x00a7:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeii.zza(java.lang.String, java.lang.String):java.util.Map");
    }

    public final synchronized Map zzb() {
        if (TextUtils.isEmpty(zzt.zzo().zzh().zzh().zzc())) {
            return zzfsf.zzd();
        }
        return zzfsf.zzc(this.zzb);
    }

    public final void zzd() {
        zzt.zzo().zzh().zzq(new zzeig(this));
        this.zzd.execute(new zzeih(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzd.execute(new zzeih(this));
    }

    public final synchronized void zzf(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!this.zza.containsKey(str)) {
                this.zza.put(str, new zzeik(str, "", new Bundle()));
            }
        }
    }
}
