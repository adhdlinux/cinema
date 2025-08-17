package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzauz;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzj implements zzg {
    private boolean zzA = false;
    private String zzB = "";
    private int zzC = -1;
    private int zzD = -1;
    private long zzE = 0;
    private final Object zza = new Object();
    private boolean zzb;
    private final List zzc = new ArrayList();
    private zzfwm zzd;
    private zzauz zze = null;
    private SharedPreferences zzf;
    private SharedPreferences.Editor zzg;
    private boolean zzh = true;
    private String zzi;
    private String zzj;
    private boolean zzk = true;
    private String zzl = "-1";
    private String zzm = "-1";
    private String zzn = "-1";
    private int zzo = -1;
    private zzbyu zzp = new zzbyu("", 0);
    private long zzq = 0;
    private long zzr = 0;
    private int zzs = -1;
    private int zzt = 0;
    private Set zzu = Collections.emptySet();
    private JSONObject zzv = new JSONObject();
    private boolean zzw = true;
    private boolean zzx = true;
    private String zzy = null;
    private String zzz = "";

    private final void zzR() {
        zzfwm zzfwm = this.zzd;
        if (zzfwm != null && !zzfwm.isDone()) {
            try {
                this.zzd.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                zzbzr.zzk("Interrupted while waiting for preferences loaded.", e2);
            } catch (CancellationException | ExecutionException | TimeoutException e3) {
                zzbzr.zzh("Fail to initialize AdSharedPreferenceManager.", e3);
            }
        }
    }

    private final void zzS() {
        zzcae.zza.execute(new zzi(this));
    }

    public final void zzA(String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzB.equals(str)) {
                    this.zzB = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzB(boolean z2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (this.zzA != z2) {
                    this.zzA = z2;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z2);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzC(String str) {
        zzR();
        synchronized (this.zza) {
            if (!TextUtils.equals(this.zzy, str)) {
                this.zzy = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzD(long j2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzr != j2) {
                this.zzr = j2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzE(int i2) {
        zzR();
        synchronized (this.zza) {
            this.zzo = i2;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                if (i2 == -1) {
                    editor.remove("gad_has_consent_for_cookies");
                } else {
                    editor.putInt("gad_has_consent_for_cookies", i2);
                }
                this.zzg.apply();
            }
            zzS();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            r5.zzR()
            java.lang.Object r0 = r5.zza
            monitor-enter(r0)
            int r1 = r6.hashCode()     // Catch:{ all -> 0x006c }
            r2 = -2004976699(0xffffffff887e7bc5, float:-7.6580835E-34)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x0030
            r2 = 83641339(0x4fc43fb, float:5.9307345E-36)
            if (r1 == r2) goto L_0x0026
            r2 = 1218895378(0x48a6de12, float:341744.56)
            if (r1 == r2) goto L_0x001c
            goto L_0x003a
        L_0x001c:
            java.lang.String r1 = "IABTCF_TCString"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x003a
            r1 = 1
            goto L_0x003b
        L_0x0026:
            java.lang.String r1 = "IABTCF_gdprApplies"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x003a
            r1 = 0
            goto L_0x003b
        L_0x0030:
            java.lang.String r1 = "IABTCF_PurposeConsents"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x003a
            r1 = 2
            goto L_0x003b
        L_0x003a:
            r1 = -1
        L_0x003b:
            if (r1 == 0) goto L_0x0049
            if (r1 == r4) goto L_0x0046
            if (r1 == r3) goto L_0x0043
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x0043:
            r5.zzn = r7     // Catch:{ all -> 0x006c }
            goto L_0x004b
        L_0x0046:
            r5.zzm = r7     // Catch:{ all -> 0x006c }
            goto L_0x004b
        L_0x0049:
            r5.zzl = r7     // Catch:{ all -> 0x006c }
        L_0x004b:
            android.content.SharedPreferences$Editor r1 = r5.zzg     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = "-1"
            boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x005d
            android.content.SharedPreferences$Editor r7 = r5.zzg     // Catch:{ all -> 0x006c }
            r7.remove(r6)     // Catch:{ all -> 0x006c }
            goto L_0x0062
        L_0x005d:
            android.content.SharedPreferences$Editor r1 = r5.zzg     // Catch:{ all -> 0x006c }
            r1.putString(r6, r7)     // Catch:{ all -> 0x006c }
        L_0x0062:
            android.content.SharedPreferences$Editor r6 = r5.zzg     // Catch:{ all -> 0x006c }
            r6.apply()     // Catch:{ all -> 0x006c }
        L_0x0067:
            r5.zzS()     // Catch:{ all -> 0x006c }
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x006c:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzj.zzF(java.lang.String, java.lang.String):void");
    }

    public final void zzG(String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzz.equals(str)) {
                    this.zzz = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzH(boolean z2) {
        zzR();
        synchronized (this.zza) {
            if (z2 != this.zzk) {
                this.zzk = z2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzI(String str, String str2, boolean z2) {
        zzR();
        synchronized (this.zza) {
            JSONArray optJSONArray = this.zzv.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i2 = 0;
            while (true) {
                if (i2 < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        if (str2.equals(optJSONObject.optString("template_id"))) {
                            if (z2) {
                                if (optJSONObject.optBoolean("uses_media_view", false)) {
                                    return;
                                }
                            }
                            length = i2;
                        } else {
                            i2++;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z2);
                jSONObject.put("timestamp_ms", zzt.zzB().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzv.put(str, optJSONArray);
            } catch (JSONException e2) {
                zzbzr.zzk("Could not update native advanced settings", e2);
            }
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.zzv.toString());
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzJ(int i2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzs != i2) {
                this.zzs = i2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzK(int i2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzD != i2) {
                this.zzD = i2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzL(long j2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzE != j2) {
                this.zzE = j2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final boolean zzM() {
        boolean z2;
        zzR();
        synchronized (this.zza) {
            z2 = this.zzw;
        }
        return z2;
    }

    public final boolean zzN() {
        boolean z2;
        zzR();
        synchronized (this.zza) {
            z2 = this.zzx;
        }
        return z2;
    }

    public final boolean zzO() {
        boolean z2;
        zzR();
        synchronized (this.zza) {
            z2 = this.zzA;
        }
        return z2;
    }

    public final boolean zzP() {
        boolean z2;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzau)).booleanValue()) {
            return false;
        }
        zzR();
        synchronized (this.zza) {
            z2 = this.zzk;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.zza) {
            this.zzf = sharedPreferences;
            this.zzg = edit;
            if (PlatformVersion.isAtLeastM()) {
                boolean unused = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.zzh = this.zzf.getBoolean("use_https", this.zzh);
            this.zzw = this.zzf.getBoolean("content_url_opted_out", this.zzw);
            this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
            this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
            this.zzx = this.zzf.getBoolean("content_vertical_opted_out", this.zzx);
            this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
            this.zzt = this.zzf.getInt("version_code", this.zzt);
            this.zzp = new zzbyu(this.zzf.getString("app_settings_json", this.zzp.zzc()), this.zzf.getLong("app_settings_last_update_ms", this.zzp.zza()));
            this.zzq = this.zzf.getLong("app_last_background_time_ms", this.zzq);
            this.zzs = this.zzf.getInt("request_in_session_count", this.zzs);
            this.zzr = this.zzf.getLong("first_ad_req_time_ms", this.zzr);
            this.zzu = this.zzf.getStringSet("never_pool_slots", this.zzu);
            this.zzy = this.zzf.getString("display_cutout", this.zzy);
            this.zzC = this.zzf.getInt("app_measurement_npa", this.zzC);
            this.zzD = this.zzf.getInt("sd_app_measure_npa", this.zzD);
            this.zzE = this.zzf.getLong("sd_app_measure_npa_ts", this.zzE);
            this.zzz = this.zzf.getString("inspector_info", this.zzz);
            this.zzA = this.zzf.getBoolean("linked_device", this.zzA);
            this.zzB = this.zzf.getString("linked_ad_unit", this.zzB);
            this.zzl = this.zzf.getString("IABTCF_gdprApplies", this.zzl);
            this.zzn = this.zzf.getString("IABTCF_PurposeConsents", this.zzn);
            this.zzm = this.zzf.getString("IABTCF_TCString", this.zzm);
            this.zzo = this.zzf.getInt("gad_has_consent_for_cookies", this.zzo);
            try {
                this.zzv = new JSONObject(this.zzf.getString("native_advanced_settings", JsonUtils.EMPTY_JSON));
            } catch (JSONException e2) {
                zzbzr.zzk("Could not convert native advanced settings to json object", e2);
            }
            zzS();
        }
    }

    public final int zza() {
        int i2;
        zzR();
        synchronized (this.zza) {
            i2 = this.zzt;
        }
        return i2;
    }

    public final int zzb() {
        int i2;
        zzR();
        synchronized (this.zza) {
            i2 = this.zzo;
        }
        return i2;
    }

    public final int zzc() {
        int i2;
        zzR();
        synchronized (this.zza) {
            i2 = this.zzs;
        }
        return i2;
    }

    public final long zzd() {
        long j2;
        zzR();
        synchronized (this.zza) {
            j2 = this.zzq;
        }
        return j2;
    }

    public final long zze() {
        long j2;
        zzR();
        synchronized (this.zza) {
            j2 = this.zzr;
        }
        return j2;
    }

    public final long zzf() {
        long j2;
        zzR();
        synchronized (this.zza) {
            j2 = this.zzE;
        }
        return j2;
    }

    public final zzauz zzg() {
        if (!this.zzb) {
            return null;
        }
        if ((zzM() && zzN()) || !((Boolean) zzbcx.zzb.zze()).booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = new zzauz();
            }
            this.zze.zze();
            zzbzr.zzi("start fetching content...");
            zzauz zzauz = this.zze;
            return zzauz;
        }
    }

    public final zzbyu zzh() {
        zzbyu zzbyu;
        zzR();
        synchronized (this.zza) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzkc)).booleanValue() && this.zzp.zzj()) {
                for (Runnable run : this.zzc) {
                    run.run();
                }
            }
            zzbyu = this.zzp;
        }
        return zzbyu;
    }

    public final zzbyu zzi() {
        zzbyu zzbyu;
        synchronized (this.zza) {
            zzbyu = this.zzp;
        }
        return zzbyu;
    }

    public final String zzj() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzi;
        }
        return str;
    }

    public final String zzk() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzj;
        }
        return str;
    }

    public final String zzl() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzB;
        }
        return str;
    }

    public final String zzm() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzy;
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzn(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzR()
            java.lang.Object r0 = r5.zza
            monitor-enter(r0)
            int r1 = r6.hashCode()     // Catch:{ all -> 0x0050 }
            r2 = -2004976699(0xffffffff887e7bc5, float:-7.6580835E-34)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x0030
            r2 = 83641339(0x4fc43fb, float:5.9307345E-36)
            if (r1 == r2) goto L_0x0026
            r2 = 1218895378(0x48a6de12, float:341744.56)
            if (r1 == r2) goto L_0x001c
            goto L_0x003a
        L_0x001c:
            java.lang.String r1 = "IABTCF_TCString"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x003a
            r6 = 1
            goto L_0x003b
        L_0x0026:
            java.lang.String r1 = "IABTCF_gdprApplies"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x003a
            r6 = 0
            goto L_0x003b
        L_0x0030:
            java.lang.String r1 = "IABTCF_PurposeConsents"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x003a
            r6 = 2
            goto L_0x003b
        L_0x003a:
            r6 = -1
        L_0x003b:
            if (r6 == 0) goto L_0x004c
            if (r6 == r4) goto L_0x0048
            if (r6 == r3) goto L_0x0044
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            r6 = 0
            return r6
        L_0x0044:
            java.lang.String r6 = r5.zzn     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return r6
        L_0x0048:
            java.lang.String r6 = r5.zzm     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return r6
        L_0x004c:
            java.lang.String r6 = r5.zzl     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return r6
        L_0x0050:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzj.zzn(java.lang.String):java.lang.String");
    }

    public final String zzo() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzz;
        }
        return str;
    }

    public final JSONObject zzp() {
        JSONObject jSONObject;
        zzR();
        synchronized (this.zza) {
            jSONObject = this.zzv;
        }
        return jSONObject;
    }

    public final void zzq(Runnable runnable) {
        this.zzc.add(runnable);
    }

    public final void zzr(Context context) {
        synchronized (this.zza) {
            if (this.zzf == null) {
                this.zzd = zzcae.zza.zza(new zzh(this, context, AppLovinMediationProvider.ADMOB));
                this.zzb = true;
            }
        }
    }

    public final void zzs() {
        zzR();
        synchronized (this.zza) {
            this.zzv = new JSONObject();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzt(long j2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzq != j2) {
                this.zzq = j2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzu(String str) {
        zzR();
        synchronized (this.zza) {
            long currentTimeMillis = zzt.zzB().currentTimeMillis();
            if (str != null) {
                if (!str.equals(this.zzp.zzc())) {
                    this.zzp = new zzbyu(str, currentTimeMillis);
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzg.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzg.apply();
                    }
                    zzS();
                    for (Runnable run : this.zzc) {
                        run.run();
                    }
                    return;
                }
            }
            this.zzp.zzg(currentTimeMillis);
        }
    }

    public final void zzv(int i2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzt != i2) {
                this.zzt = i2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzw(String str) {
        zzR();
        synchronized (this.zza) {
            if (!str.equals(this.zzi)) {
                this.zzi = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_url_hashes", str);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzx(boolean z2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzw != z2) {
                this.zzw = z2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzy(String str) {
        zzR();
        synchronized (this.zza) {
            if (!str.equals(this.zzj)) {
                this.zzj = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_vertical_hashes", str);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzz(boolean z2) {
        zzR();
        synchronized (this.zza) {
            if (this.zzx != z2) {
                this.zzx = z2;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z2);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }
}
