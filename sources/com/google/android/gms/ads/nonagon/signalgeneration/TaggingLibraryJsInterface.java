package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfwn;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

final class TaggingLibraryJsInterface {
    private final Context zza;
    /* access modifiers changed from: private */
    public final WebView zzb;
    private final zzaqs zzc;
    private final int zzd;
    private final zzdqf zze;
    private final boolean zzf;
    private final zzfwn zzg = zzcae.zze;
    private final zzfgr zzh;

    TaggingLibraryJsInterface(WebView webView, zzaqs zzaqs, zzdqf zzdqf, zzfgr zzfgr) {
        this.zzb = webView;
        Context context = webView.getContext();
        this.zza = context;
        this.zzc = zzaqs;
        this.zze = zzdqf;
        zzbbm.zza(context);
        this.zzd = ((Integer) zzba.zzc().zzb(zzbbm.zziV)).intValue();
        this.zzf = ((Boolean) zzba.zzc().zzb(zzbbm.zziW)).booleanValue();
        this.zzh = zzfgr;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getClickSignals(String str) {
        try {
            long currentTimeMillis = zzt.zzB().currentTimeMillis();
            String zze2 = this.zzc.zzc().zze(this.zza, str, this.zzb);
            if (this.zzf) {
                long currentTimeMillis2 = zzt.zzB().currentTimeMillis() - currentTimeMillis;
                zzf.zzc(this.zze, (zzdpv) null, "csg", new Pair("clat", String.valueOf(currentTimeMillis2)));
            }
            return zze2;
        } catch (RuntimeException e2) {
            zzbzr.zzh("Exception getting click signals. ", e2);
            zzt.zzo().zzu(e2, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getClickSignalsWithTimeout(String str, int i2) {
        if (i2 <= 0) {
            zzbzr.zzg("Invalid timeout for getting click signals. Timeout=" + i2);
            return "";
        }
        int min = Math.min(i2, this.zzd);
        try {
            return (String) zzcae.zza.zzb(new zzaq(this, str)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzbzr.zzh("Exception getting click signals with timeout. ", e2);
            zzt.zzo().zzu(e2, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            if (e2 instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getQueryInfo() {
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        zzar zzar = new zzar(this, uuid);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziY)).booleanValue()) {
            this.zzg.execute(new zzao(this, bundle, zzar));
        } else {
            Context context = this.zza;
            AdFormat adFormat = AdFormat.BANNER;
            AdRequest.Builder builder = new AdRequest.Builder();
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
            QueryInfo.generate(context, adFormat, builder.build(), zzar);
        }
        return uuid;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getViewSignals() {
        try {
            long currentTimeMillis = zzt.zzB().currentTimeMillis();
            String zzh2 = this.zzc.zzc().zzh(this.zza, this.zzb, (Activity) null);
            if (this.zzf) {
                long currentTimeMillis2 = zzt.zzB().currentTimeMillis() - currentTimeMillis;
                zzf.zzc(this.zze, (zzdpv) null, "vsg", new Pair("vlat", String.valueOf(currentTimeMillis2)));
            }
            return zzh2;
        } catch (RuntimeException e2) {
            zzbzr.zzh("Exception getting view signals. ", e2);
            zzt.zzo().zzu(e2, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getViewSignalsWithTimeout(int i2) {
        if (i2 <= 0) {
            zzbzr.zzg("Invalid timeout for getting view signals. Timeout=" + i2);
            return "";
        }
        int min = Math.min(i2, this.zzd);
        try {
            return (String) zzcae.zza.zzb(new zzap(this)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzbzr.zzh("Exception getting view signals with timeout. ", e2);
            zzt.zzo().zzu(e2, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            if (e2 instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public void recordClick(String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzja)).booleanValue() && !TextUtils.isEmpty(str)) {
            zzcae.zza.execute(new zzan(this, str));
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public void reportTouchEvent(String str) {
        int i2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("x");
            int i4 = jSONObject.getInt("y");
            int i5 = jSONObject.getInt("duration_ms");
            float f2 = (float) jSONObject.getDouble("force");
            int i6 = jSONObject.getInt("type");
            if (i6 == 0) {
                i2 = 0;
            } else if (i6 == 1) {
                i2 = 1;
            } else if (i6 == 2) {
                i2 = 2;
            } else if (i6 != 3) {
                i2 = -1;
            } else {
                i2 = 3;
            }
            try {
                this.zzc.zzd(MotionEvent.obtain(0, (long) i5, i2, (float) i3, (float) i4, f2, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException e2) {
                e = e2;
                zzbzr.zzh("Failed to parse the touch string. ", e);
                zzt.zzo().zzu(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException e3) {
            e = e3;
            zzbzr.zzh("Failed to parse the touch string. ", e);
            zzt.zzo().zzu(e, "TaggingLibraryJsInterface.reportTouchEvent");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        boolean z2;
        CookieManager zzb2 = zzt.zzq().zzb(this.zza);
        if (zzb2 != null) {
            z2 = zzb2.acceptThirdPartyCookies(this.zzb);
        } else {
            z2 = false;
        }
        bundle.putBoolean("accept_3p_cookie", z2);
        Context context = this.zza;
        AdFormat adFormat = AdFormat.BANNER;
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        QueryInfo.generate(context, adFormat, builder.build(), queryInfoGenerationCallback);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(String str) {
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzc.zza(parse, this.zza, this.zzb, (Activity) null);
        } catch (zzaqt e2) {
            zzbzr.zzf("Failed to append the click signal to URL: ", e2);
            zzt.zzo().zzu(e2, "TaggingLibraryJsInterface.recordClick");
        }
        this.zzh.zzc(parse.toString(), (zzffy) null);
    }
}
