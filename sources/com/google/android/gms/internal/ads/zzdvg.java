package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdvg {
    private final zzcgu zza;
    private final Context zzb;
    private final zzbzx zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final String zzf;
    private final zzffy zzg;
    private final zzfau zzh;
    private final zzdpv zzi;

    public zzdvg(zzcgu zzcgu, Context context, zzbzx zzbzx, zzfai zzfai, Executor executor, String str, zzffy zzffy, zzdpv zzdpv) {
        this.zza = zzcgu;
        this.zzb = context;
        this.zzc = zzbzx;
        this.zzd = zzfai;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzffy;
        this.zzh = zzcgu.zzv();
        this.zzi = zzdpv;
    }

    private final zzfwm zzc(String str, String str2) {
        zzffn zza2 = zzffm.zza(this.zzb, 11);
        zza2.zzh();
        zzbmz zza3 = zzt.zzf().zza(this.zzb, this.zzc, this.zza.zzy());
        zzbmt zzbmt = zzbmw.zza;
        zzfwm zzm = zzfwc.zzm(zzfwc.zzm(zzfwc.zzm(zzfwc.zzh(""), new zzdvd(this, str, str2), this.zze), new zzdve(zza3.zza("google.afma.response.normalize", zzbmt, zzbmt)), this.zze), new zzdvf(this), this.zze);
        zzffx.zza(zzm, this.zzg, zza2);
        return zzm;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            zzbzr.zzj("Failed to update the ad types for rendering. ".concat(e2.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfwm zza() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzfai r0 = r10.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            java.lang.String r0 = r0.zzx
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "true"
            if (r1 != 0) goto L_0x0115
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzgK
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0115
            java.lang.String r1 = zze(r0)
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzgW
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r4.zzb(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r5 = -1
            if (r4 == 0) goto L_0x004e
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x004e
            java.lang.String r1 = "&request_id="
            int r1 = r0.lastIndexOf(r1)
            if (r1 == r5) goto L_0x004c
            int r1 = r1 + 12
            java.lang.String r1 = r0.substring(r1)
            goto L_0x004e
        L_0x004c:
            java.lang.String r1 = ""
        L_0x004e:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzefu r0 = new com.google.android.gms.internal.ads.zzefu
            r1 = 15
            java.lang.String r2 = "Invalid ad string."
            r0.<init>(r1, r2)
            com.google.android.gms.internal.ads.zzfwm r0 = com.google.android.gms.internal.ads.zzfwc.zzg(r0)
            return r0
        L_0x0062:
            com.google.android.gms.internal.ads.zzcgu r4 = r10.zza
            com.google.android.gms.ads.nonagon.signalgeneration.zzc r4 = r4.zzm()
            com.google.android.gms.internal.ads.zzdpv r6 = r10.zzi
            java.lang.String r4 = r4.zzb(r1, r6)
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r6.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0105
            com.google.android.gms.internal.ads.zzdpv r3 = r10.zzi
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x0105
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x009a }
            r6.<init>(r4)     // Catch:{ JSONException -> 0x009a }
            java.lang.String r7 = "is_gbid"
            java.lang.String r6 = r6.optString(r7)     // Catch:{ JSONException -> 0x009a }
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x009a }
            if (r6 == 0) goto L_0x009a
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x009a }
            goto L_0x009c
        L_0x009a:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
        L_0x009c:
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x00a3
            goto L_0x0105
        L_0x00a3:
            java.lang.String r6 = "&"
            int r6 = r0.lastIndexOf(r6)
            r7 = 0
            if (r6 == r5) goto L_0x00b2
            r5 = 0
            java.lang.String r5 = r0.substring(r5, r6)
            goto L_0x00b3
        L_0x00b2:
            r5 = r7
        L_0x00b3:
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x00ba
            goto L_0x0105
        L_0x00ba:
            r6 = 11
            byte[] r5 = android.util.Base64.decode(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x00ee }
            java.lang.String r6 = "UTF-8"
            byte[] r1 = r1.getBytes(r6)     // Catch:{ UnsupportedEncodingException -> 0x00ee }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d2 }
            r6.<init>(r4)     // Catch:{ JSONException -> 0x00d2 }
            java.lang.String r8 = "arek"
            java.lang.String r7 = r6.getString(r8)     // Catch:{ JSONException -> 0x00d2 }
            goto L_0x00e9
        L_0x00d2:
            r6 = move-exception
            java.lang.String r8 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x00ee }
            java.lang.String r9 = "Failed to get key from QueryJSONMap"
            java.lang.String r8 = r9.concat(r8)     // Catch:{ UnsupportedEncodingException -> 0x00ee }
            com.google.android.gms.ads.internal.util.zze.zza(r8)     // Catch:{ UnsupportedEncodingException -> 0x00ee }
            com.google.android.gms.internal.ads.zzbza r8 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ UnsupportedEncodingException -> 0x00ee }
            java.lang.String r9 = "CryptoUtils.getKeyFromQueryJsonMap"
            r8.zzu(r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x00ee }
        L_0x00e9:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfau.zzb(r5, r1, r7, r3)     // Catch:{ UnsupportedEncodingException -> 0x00ee }
            goto L_0x0105
        L_0x00ee:
            r1 = move-exception
            java.lang.String r3 = "Failed to decode the adResponse. "
            java.lang.String r5 = r1.toString()
            java.lang.String r3 = r3.concat(r5)
            com.google.android.gms.ads.internal.util.zze.zza(r3)
            java.lang.String r3 = "PreloadedLoader.decryptAdResponseIfNecessary"
            com.google.android.gms.internal.ads.zzbza r5 = com.google.android.gms.ads.internal.zzt.zzo()
            r5.zzu(r1, r3)
        L_0x0105:
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x010c
            goto L_0x0115
        L_0x010c:
            java.lang.String r1 = r10.zzd(r4)
            com.google.android.gms.internal.ads.zzfwm r0 = r10.zzc(r0, r1)
            return r0
        L_0x0115:
            com.google.android.gms.internal.ads.zzfai r0 = r10.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            com.google.android.gms.ads.internal.client.zzc r0 = r0.zzs
            if (r0 == 0) goto L_0x0174
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzgI
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0130
            goto L_0x015c
        L_0x0130:
            java.lang.String r1 = r0.zza
            java.lang.String r1 = zze(r1)
            java.lang.String r3 = r0.zzb
            java.lang.String r3 = zze(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0169
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0169
            com.google.android.gms.internal.ads.zzcgu r2 = r10.zza
            com.google.android.gms.ads.nonagon.signalgeneration.zzc r2 = r2.zzm()
            r2.zzf(r1)
            com.google.android.gms.internal.ads.zzdpv r2 = r10.zzi
            java.util.Map r2 = r2.zza()
            java.lang.String r3 = "rid"
            r2.put(r3, r1)
        L_0x015c:
            java.lang.String r1 = r0.zza
            java.lang.String r0 = r0.zzb
            java.lang.String r0 = r10.zzd(r0)
            com.google.android.gms.internal.ads.zzfwm r0 = r10.zzc(r1, r0)
            return r0
        L_0x0169:
            com.google.android.gms.internal.ads.zzdpv r0 = r10.zzi
            java.util.Map r0 = r0.zza()
            java.lang.String r1 = "ridmm"
            r0.put(r1, r2)
        L_0x0174:
            com.google.android.gms.internal.ads.zzefu r0 = new com.google.android.gms.internal.ads.zzefu
            r1 = 14
            java.lang.String r2 = "Mismatch request IDs."
            r0.<init>(r1, r2)
            com.google.android.gms.internal.ads.zzfwm r0 = com.google.android.gms.internal.ads.zzfwc.zzg(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvg.zza():com.google.android.gms.internal.ads.zzfwm");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(JSONObject jSONObject) throws Exception {
        return zzfwc.zzh(new zzezz(new zzezw(this.zzd), zzezy.zza(new StringReader(jSONObject.toString()))));
    }
}
