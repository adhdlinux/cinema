package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.common.time.Clock;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdsx implements zzdtv, zzdsi {
    private final zzdtf zza;
    private final zzdtw zzb;
    private final zzdsj zzc;
    private final zzdss zzd;
    private final zzdsh zze;
    private final zzdtr zzf;
    private final String zzg;
    private final String zzh;
    private final Map zzi = new HashMap();
    private final Map zzj = new HashMap();
    private final Map zzk = new HashMap();
    private String zzl = JsonUtils.EMPTY_JSON;
    private JSONObject zzm;
    private long zzn = Clock.MAX_TIME;
    private zzdst zzo = zzdst.NONE;
    private boolean zzp;
    private int zzq;
    private boolean zzr;
    private zzdsw zzs = zzdsw.UNKNOWN;

    zzdsx(zzdtf zzdtf, zzdtw zzdtw, zzdsj zzdsj, Context context, zzbzx zzbzx, zzdss zzdss, zzdtr zzdtr, String str) {
        this.zza = zzdtf;
        this.zzb = zzdtw;
        this.zzc = zzdsj;
        this.zze = new zzdsh(context);
        this.zzg = zzbzx.zza;
        this.zzh = str;
        this.zzd = zzdss;
        this.zzf = zzdtr;
        zzt.zzs().zzg(this);
    }

    private final synchronized JSONObject zzq() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : this.zzi.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzdsl zzdsl : (List) entry.getValue()) {
                if (zzdsl.zzg()) {
                    jSONArray.put(zzdsl.zzd());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzr() {
        this.zzr = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzc(this);
        this.zzc.zzc(this);
        this.zzf.zzf(this);
        zzx(zzt.zzo().zzh().zzo());
    }

    private final void zzs() {
        zzt.zzo().zzh().zzG(zzd());
    }

    private final synchronized void zzt(zzdst zzdst, boolean z2) {
        if (this.zzo != zzdst) {
            if (zzo()) {
                zzv();
            }
            this.zzo = zzdst;
            if (zzo()) {
                zzw();
            }
            if (z2) {
                zzs();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzu(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzp     // Catch:{ all -> 0x003d }
            if (r0 != r2) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r1.zzp = r2     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zziJ     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x003d }
            java.lang.Object r2 = r0.zzb(r2)     // Catch:{ all -> 0x003d }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x003d }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0027
            com.google.android.gms.ads.internal.util.zzaw r2 = com.google.android.gms.ads.internal.zzt.zzs()     // Catch:{ all -> 0x003d }
            boolean r2 = r2.zzl()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x002b
        L_0x0027:
            r1.zzw()     // Catch:{ all -> 0x003d }
            goto L_0x0034
        L_0x002b:
            boolean r2 = r1.zzo()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0034
            r1.zzv()     // Catch:{ all -> 0x003d }
        L_0x0034:
            if (r3 == 0) goto L_0x003b
            r1.zzs()     // Catch:{ all -> 0x003d }
            monitor-exit(r1)
            return
        L_0x003b:
            monitor-exit(r1)
            return
        L_0x003d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zzu(boolean, boolean):void");
    }

    private final synchronized void zzv() {
        zzdst zzdst = zzdst.NONE;
        int ordinal = this.zzo.ordinal();
        if (ordinal == 1) {
            this.zzb.zza();
        } else if (ordinal == 2) {
            this.zzc.zza();
        }
    }

    private final synchronized void zzw() {
        zzdst zzdst = zzdst.NONE;
        int ordinal = this.zzo.ordinal();
        if (ordinal == 1) {
            this.zzb.zzb();
        } else if (ordinal == 2) {
            this.zzc.zzb();
        }
    }

    private final synchronized void zzx(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                zzu(jSONObject.optBoolean("isTestMode", false), false);
                zzt((zzdst) Enum.valueOf(zzdst.class, jSONObject.optString("gesture", "NONE")), false);
                this.zzl = jSONObject.optString("networkExtras", JsonUtils.EMPTY_JSON);
                this.zzn = jSONObject.optLong("networkExtrasExpirationSecs", Clock.MAX_TIME);
            } catch (JSONException unused) {
            }
        }
    }

    public final zzdst zza() {
        return this.zzo;
    }

    public final synchronized zzfwm zzb(String str) {
        zzcaj zzcaj;
        zzcaj = new zzcaj();
        if (this.zzj.containsKey(str)) {
            zzcaj.zzd((zzdsl) this.zzj.get(str));
        } else {
            if (!this.zzk.containsKey(str)) {
                this.zzk.put(str, new ArrayList());
            }
            ((List) this.zzk.get(str)).add(zzcaj);
        }
        return zzcaj;
    }

    public final synchronized String zzc() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            if (zzo()) {
                if (this.zzn < zzt.zzB().currentTimeMillis() / 1000) {
                    this.zzl = JsonUtils.EMPTY_JSON;
                    this.zzn = Clock.MAX_TIME;
                    return "";
                } else if (this.zzl.equals(JsonUtils.EMPTY_JSON)) {
                    return "";
                } else {
                    return this.zzl;
                }
            }
        }
        return "";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|(1:7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzd() {
        /*
            r7 = this;
            monitor-enter(r7)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0039 }
            r0.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "isTestMode"
            boolean r2 = r7.zzp     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "gesture"
            com.google.android.gms.internal.ads.zzdst r2 = r7.zzo     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            long r1 = r7.zzn     // Catch:{ JSONException -> 0x0033 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ JSONException -> 0x0033 }
            long r3 = r3.currentTimeMillis()     // Catch:{ JSONException -> 0x0033 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0033
            java.lang.String r1 = "networkExtras"
            java.lang.String r2 = r7.zzl     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "networkExtrasExpirationSecs"
            long r2 = r7.zzn     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
        L_0x0033:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0039 }
            monitor-exit(r7)
            return r0
        L_0x0039:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zzd():java.lang.String");
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            if (!TextUtils.isEmpty(this.zzh)) {
                String str = this.zzh;
                jSONObject.put("sdkVersion", "afma-sdk-a-v" + str);
            }
            jSONObject.put("internalSdkVersion", this.zzg);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("adapters", this.zzd.zza());
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziS)).booleanValue()) {
                String zzm2 = zzt.zzo().zzm();
                if (!TextUtils.isEmpty(zzm2)) {
                    jSONObject.put("plugin", zzm2);
                }
            }
            if (this.zzn < zzt.zzB().currentTimeMillis() / 1000) {
                this.zzl = JsonUtils.EMPTY_JSON;
            }
            jSONObject.put("networkExtras", this.zzl);
            jSONObject.put("adSlots", zzq());
            jSONObject.put("appInfo", this.zze.zza());
            String zzc2 = zzt.zzo().zzh().zzh().zzc();
            if (!TextUtils.isEmpty(zzc2)) {
                jSONObject.put("cld", new JSONObject(zzc2));
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziK)).booleanValue() && (jSONObject2 = this.zzm) != null) {
                String obj = jSONObject2.toString();
                zzbzr.zze("Server data: " + obj);
                jSONObject.put("serverData", this.zzm);
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
                jSONObject.put("openAction", this.zzs);
                jSONObject.put("gesture", this.zzo);
            }
        } catch (JSONException e2) {
            zzt.zzo().zzt(e2, "Inspector.toJson");
            zzbzr.zzk("Ad inspector encountered an error", e2);
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf(java.lang.String r4, com.google.android.gms.internal.ads.zzdsl r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zziu     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a3 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00a3 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a3 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a3 }
            if (r0 == 0) goto L_0x00a1
            boolean r0 = r3.zzo()     // Catch:{ all -> 0x00a3 }
            if (r0 != 0) goto L_0x001b
            goto L_0x00a1
        L_0x001b:
            int r0 = r3.zzq     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zziw     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a3 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x00a3 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00a3 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00a3 }
            if (r0 < r1) goto L_0x0036
            java.lang.String r4 = "Maximum number of ad requests stored reached. Dropping the current request."
            com.google.android.gms.internal.ads.zzbzr.zzj(r4)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r3)
            return
        L_0x0036:
            java.util.Map r0 = r3.zzi     // Catch:{ all -> 0x00a3 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x00a3 }
            if (r0 != 0) goto L_0x0048
            java.util.Map r0 = r3.zzi     // Catch:{ all -> 0x00a3 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00a3 }
            r1.<init>()     // Catch:{ all -> 0x00a3 }
            r0.put(r4, r1)     // Catch:{ all -> 0x00a3 }
        L_0x0048:
            int r0 = r3.zzq     // Catch:{ all -> 0x00a3 }
            int r0 = r0 + 1
            r3.zzq = r0     // Catch:{ all -> 0x00a3 }
            java.util.Map r0 = r3.zzi     // Catch:{ all -> 0x00a3 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x00a3 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x00a3 }
            r4.add(r5)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zziQ     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a3 }
            java.lang.Object r4 = r0.zzb(r4)     // Catch:{ all -> 0x00a3 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x00a3 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x006d
            monitor-exit(r3)
            return
        L_0x006d:
            java.lang.String r4 = r5.zzc()     // Catch:{ all -> 0x00a3 }
            java.util.Map r0 = r3.zzj     // Catch:{ all -> 0x00a3 }
            r0.put(r4, r5)     // Catch:{ all -> 0x00a3 }
            java.util.Map r0 = r3.zzk     // Catch:{ all -> 0x00a3 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x00a3 }
            if (r0 == 0) goto L_0x009f
            java.util.Map r0 = r3.zzk     // Catch:{ all -> 0x00a3 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x00a3 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x00a3 }
            java.util.Iterator r0 = r4.iterator()     // Catch:{ all -> 0x00a3 }
        L_0x008a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x009a
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzcaj r1 = (com.google.android.gms.internal.ads.zzcaj) r1     // Catch:{ all -> 0x00a3 }
            r1.zzd(r5)     // Catch:{ all -> 0x00a3 }
            goto L_0x008a
        L_0x009a:
            r4.clear()     // Catch:{ all -> 0x00a3 }
            monitor-exit(r3)
            return
        L_0x009f:
            monitor-exit(r3)
            return
        L_0x00a1:
            monitor-exit(r3)
            return
        L_0x00a3:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zzf(java.lang.String, com.google.android.gms.internal.ads.zzdsl):void");
    }

    public final void zzg() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue() || !zzt.zzo().zzh().zzO()) {
                String zzo2 = zzt.zzo().zzh().zzo();
                if (!TextUtils.isEmpty(zzo2)) {
                    try {
                        if (new JSONObject(zzo2).optBoolean("isTestMode", false)) {
                            zzr();
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else {
                zzr();
            }
        }
    }

    public final synchronized void zzh(zzda zzda, zzdsw zzdsw) {
        if (!zzo()) {
            try {
                zzda.zze(zzfbi.zzd(18, (String) null, (zze) null));
            } catch (RemoteException unused) {
                zzbzr.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
            }
        } else {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
                try {
                    zzda.zze(zzfbi.zzd(1, (String) null, (zze) null));
                } catch (RemoteException unused2) {
                    zzbzr.zzj("Ad inspector had an internal error.");
                }
            } else {
                this.zzs = zzdsw;
                this.zza.zzj(zzda, new zzbjb(this), new zzbiu(this.zzf));
            }
        }
    }

    public final synchronized void zzi(String str, long j2) {
        this.zzl = str;
        this.zzn = j2;
        zzs();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r2 != false) goto L_0x000c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzr
            if (r0 != 0) goto L_0x000a
            if (r2 == 0) goto L_0x0015
            r1.zzr()
            goto L_0x000c
        L_0x000a:
            if (r2 == 0) goto L_0x0015
        L_0x000c:
            boolean r2 = r1.zzp
            if (r2 == 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            r1.zzw()
            return
        L_0x0015:
            boolean r2 = r1.zzo()
            if (r2 != 0) goto L_0x001e
            r1.zzv()
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zzj(boolean):void");
    }

    public final void zzk(zzdst zzdst) {
        zzt(zzdst, true);
    }

    public final synchronized void zzl(JSONObject jSONObject) {
        this.zzm = jSONObject;
    }

    public final void zzm(boolean z2) {
        if (!this.zzr && z2) {
            zzr();
        }
        zzu(z2, true);
    }

    public final boolean zzn() {
        return this.zzm != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzo() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zziJ     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x002c }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x002c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0028
            boolean r0 = r2.zzp     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0025
            com.google.android.gms.ads.internal.util.zzaw r0 = com.google.android.gms.ads.internal.zzt.zzs()     // Catch:{ all -> 0x002c }
            boolean r0 = r0.zzl()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0025:
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x0028:
            boolean r0 = r2.zzp     // Catch:{ all -> 0x002c }
            monitor-exit(r2)
            return r0
        L_0x002c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zzo():boolean");
    }

    public final synchronized boolean zzp() {
        return this.zzp;
    }
}
