package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.ImagesContract;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdkb {
    private final Context zza;
    private final zzdjk zzb;
    private final zzaqs zzc;
    private final zzbzx zzd;
    private final zza zze;
    private final zzawz zzf;
    private final Executor zzg;
    private final zzbef zzh;
    private final zzdkt zzi;
    private final zzdni zzj;
    private final ScheduledExecutorService zzk;
    private final zzdmd zzl;
    private final zzdqa zzm;
    private final zzfev zzn;
    private final zzfgr zzo;
    private final zzeba zzp;
    private final zzebl zzq;

    public zzdkb(Context context, zzdjk zzdjk, zzaqs zzaqs, zzbzx zzbzx, zza zza2, zzawz zzawz, Executor executor, zzfai zzfai, zzdkt zzdkt, zzdni zzdni, ScheduledExecutorService scheduledExecutorService, zzdqa zzdqa, zzfev zzfev, zzfgr zzfgr, zzeba zzeba, zzdmd zzdmd, zzebl zzebl) {
        this.zza = context;
        this.zzb = zzdjk;
        this.zzc = zzaqs;
        this.zzd = zzbzx;
        this.zze = zza2;
        this.zzf = zzawz;
        this.zzg = executor;
        this.zzh = zzfai.zzi;
        this.zzi = zzdkt;
        this.zzj = zzdni;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdqa;
        this.zzn = zzfev;
        this.zzo = zzfgr;
        this.zzp = zzeba;
        this.zzl = zzdmd;
        this.zzq = zzebl;
    }

    public static final zzel zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzfsc.zzl();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfsc.zzl();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            zzel zzr = zzr(optJSONArray.optJSONObject(i2));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzfsc.zzj(arrayList);
    }

    private final zzq zzk(int i2, int i3) {
        if (i2 == 0) {
            if (i3 == 0) {
                return zzq.zzc();
            }
            i2 = 0;
        }
        return new zzq(this.zza, new AdSize(i2, i3));
    }

    private static zzfwm zzl(zzfwm zzfwm, Object obj) {
        return zzfwc.zzf(zzfwm, Exception.class, new zzdjy((Object) null), zzcae.zzf);
    }

    private static zzfwm zzm(boolean z2, zzfwm zzfwm, Object obj) {
        if (z2) {
            return zzfwc.zzm(zzfwm, new zzdjw(zzfwm), zzcae.zzf);
        }
        return zzl(zzfwm, (Object) null);
    }

    private final zzfwm zzn(JSONObject jSONObject, boolean z2) {
        if (jSONObject == null) {
            return zzfwc.zzh((Object) null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzfwc.zzh((Object) null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z2) {
            return zzfwc.zzh(new zzbed((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzfwc.zzl(this.zzb.zzb(optString, optDouble, optBoolean), new zzdjz(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private final zzfwm zzo(JSONArray jSONArray, boolean z2, boolean z3) {
        int i2;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzfwc.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            i2 = jSONArray.length();
        } else {
            i2 = 1;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i3), z2));
        }
        return zzfwc.zzl(zzfwc.zzd(arrayList), zzdjx.zza, this.zzg);
    }

    private final zzfwm zzp(JSONObject jSONObject, zzezn zzezn, zzezq zzezq) {
        zzfwm zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzezn, zzezq, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzfwc.zzm(zzb2, new zzdka(zzb2), zzcae.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final zzel zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzel(optString, optString2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbea zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzq2 = zzq(jSONObject, "bg_color");
        Integer zzq3 = zzq(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzbea(optString, list, zzq2, zzq3, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzq zzq2, zzezn zzezn, zzezq zzezq, String str, String str2, Object obj) throws Exception {
        zzcez zza2 = this.zzj.zza(zzq2, zzezn, zzezq);
        zzcai zza3 = zzcai.zza(zza2);
        zzdma zzb2 = this.zzl.zzb();
        zzdma zzdma = zzb2;
        zzcgm zzN = zza2.zzN();
        zzb zzb3 = r3;
        zzb zzb4 = new zzb(this.zza, (zzbws) null, (zzbtk) null);
        zzN.zzM(zzb2, zzdma, zzb2, zzb2, zzb2, false, (zzbil) null, zzb3, (zzbqx) null, (zzbws) null, this.zzp, this.zzo, this.zzm, this.zzn, (zzbjb) null, zzb2, (zzbja) null, (zzbiu) null);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdw)).booleanValue()) {
            zza2.zzad("/getNativeAdViewSignals", zzbii.zzs);
        }
        zza2.zzad("/getNativeClickMeta", zzbii.zzt);
        zza2.zzN().zzA(new zzdjv(zza3));
        zza2.zzab(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(String str, Object obj) throws Exception {
        zzt.zzz();
        zzcez zza2 = zzcfl.zza(this.zza, zzcgo.zza(), "native-omid", false, false, this.zzc, (zzbco) null, this.zzd, (zzbce) null, (zzl) null, this.zze, this.zzf, (zzezn) null, (zzezq) null, this.zzq);
        zzcai zza3 = zzcai.zza(zza2);
        zza2.zzN().zzA(new zzdjr(zza3));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeP)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "base64");
        } else {
            zza2.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8");
        }
        return zza3;
    }

    public final zzfwm zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzfwc.zzh((Object) null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzfwc.zzl(zzo(optJSONArray, false, true), new zzdjs(this, optJSONObject), this.zzg), (Object) null);
    }

    public final zzfwm zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final zzfwm zzf(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        zzbef zzbef = this.zzh;
        return zzo(optJSONArray, zzbef.zzb, zzbef.zzd);
    }

    public final zzfwm zzg(JSONObject jSONObject, String str, zzezn zzezn, zzezq zzezq) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjg)).booleanValue()) {
            return zzfwc.zzh((Object) null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfwc.zzh((Object) null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzfwc.zzh((Object) null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString("html");
        zzq zzk2 = zzk(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzfwc.zzh((Object) null);
        }
        zzfwm zzm2 = zzfwc.zzm(zzfwc.zzh((Object) null), new zzdjt(this, zzk2, zzezn, zzezq, optString, optString2), zzcae.zze);
        return zzfwc.zzm(zzm2, new zzdju(zzm2), zzcae.zzf);
    }

    public final zzfwm zzh(JSONObject jSONObject, zzezn zzezn, zzezq zzezq) {
        zzfwm zzfwm;
        JSONObject zzg2 = zzbu.zzg(jSONObject, "html_containers", "instream");
        if (zzg2 != null) {
            return zzp(zzg2, zzezn, zzezq);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(MimeTypes.BASE_TYPE_VIDEO);
        if (optJSONObject == null) {
            return zzfwc.zzh((Object) null);
        }
        String optString = optJSONObject.optString("vast_xml");
        boolean z2 = false;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjf)).booleanValue() && optJSONObject.has("html")) {
            z2 = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z2) {
                zzbzr.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzfwc.zzh((Object) null);
            }
        } else if (!z2) {
            zzfwm = this.zzi.zza(optJSONObject);
            return zzl(zzfwc.zzn(zzfwm, (long) ((Integer) zzba.zzc().zzb(zzbbm.zzdx)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        zzfwm = zzp(optJSONObject, zzezn, zzezq);
        return zzl(zzfwc.zzn(zzfwm, (long) ((Integer) zzba.zzc().zzb(zzbbm.zzdx)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }
}
