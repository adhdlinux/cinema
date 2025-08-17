package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class zzcfo extends FrameLayout implements zzcez {
    private final zzcez zza;
    private final zzcbp zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcfo(zzcez zzcez) {
        super(zzcez.getContext());
        this.zza = zzcez;
        this.zzb = new zzcbp(zzcez.zzE(), this, this);
        addView((View) zzcez);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        zzfgw zzQ = zzQ();
        if (zzQ != null) {
            zzfmd zzfmd = zzs.zza;
            zzfmd.post(new zzcfm(zzQ));
            zzcez zzcez = this.zza;
            zzcez.getClass();
            zzfmd.postDelayed(new zzcfn(zzcez), (long) ((Integer) zzba.zzc().zzb(zzbbm.zzeN)).intValue());
            return;
        }
        this.zza.destroy();
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8", (String) null);
    }

    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    public final void onAdClicked() {
        zzcez zzcez = this.zza;
        if (zzcez != null) {
            zzcez.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA(int i2) {
        this.zza.zzA(i2);
    }

    public final void zzB(int i2) {
        this.zzb.zzg(i2);
    }

    public final void zzC(zzcfv zzcfv) {
        this.zza.zzC(zzcfv);
    }

    public final zzezn zzD() {
        return this.zza.zzD();
    }

    public final Context zzE() {
        return this.zza.zzE();
    }

    public final View zzF() {
        return this;
    }

    public final WebView zzG() {
        return (WebView) this.zza;
    }

    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    public final zzaqs zzI() {
        return this.zza.zzI();
    }

    public final zzavn zzJ() {
        return this.zza.zzJ();
    }

    public final zzbee zzK() {
        return this.zza.zzK();
    }

    public final zzl zzL() {
        return this.zza.zzL();
    }

    public final zzl zzM() {
        return this.zza.zzM();
    }

    public final zzcgm zzN() {
        return ((zzcfs) this.zza).zzaJ();
    }

    public final zzcgo zzO() {
        return this.zza.zzO();
    }

    public final zzezq zzP() {
        return this.zza.zzP();
    }

    public final zzfgw zzQ() {
        return this.zza.zzQ();
    }

    public final zzfwm zzR() {
        return this.zza.zzR();
    }

    public final String zzS() {
        return this.zza.zzS();
    }

    public final void zzT(zzezn zzezn, zzezq zzezq) {
        this.zza.zzT(zzezn, zzezq);
    }

    public final void zzU() {
        this.zzb.zze();
        this.zza.zzU();
    }

    public final void zzV() {
        this.zza.zzV();
    }

    public final void zzW(int i2) {
        this.zza.zzW(i2);
    }

    public final void zzX() {
        this.zza.zzX();
    }

    public final void zzY() {
        zzcez zzcez = this.zza;
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzt.zzr().zze()));
        hashMap.put("app_volume", String.valueOf(zzt.zzr().zza()));
        zzcfs zzcfs = (zzcfs) zzcez;
        hashMap.put("device_volume", String.valueOf(zzab.zzb(zzcfs.getContext())));
        zzcfs.zzd("volume", hashMap);
    }

    public final void zzZ(boolean z2) {
        this.zza.zzZ(z2);
    }

    public final void zza(String str) {
        ((zzcfs) this.zza).zzaO(str);
    }

    public final boolean zzaA() {
        return this.zza.zzaA();
    }

    public final boolean zzaB() {
        return this.zzc.get();
    }

    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    public final void zzaD(zzc zzc2, boolean z2) {
        this.zza.zzaD(zzc2, z2);
    }

    public final void zzaE(zzbr zzbr, String str, String str2, int i2) {
        this.zza.zzaE(zzbr, str, str2, 14);
    }

    public final void zzaF(boolean z2, int i2, boolean z3) {
        this.zza.zzaF(z2, i2, z3);
    }

    public final void zzaG(boolean z2, int i2, String str, boolean z3) {
        this.zza.zzaG(z2, i2, str, z3);
    }

    public final void zzaH(boolean z2, int i2, String str, String str2, boolean z3) {
        this.zza.zzaH(z2, i2, str, str2, z3);
    }

    public final void zzaa() {
        this.zza.zzaa();
    }

    public final void zzab(String str, String str2, String str3) {
        this.zza.zzab(str, str2, (String) null);
    }

    public final void zzac() {
        this.zza.zzac();
    }

    public final void zzad(String str, zzbij zzbij) {
        this.zza.zzad(str, zzbij);
    }

    public final void zzae() {
        TextView textView = new TextView(getContext());
        zzt.zzp();
        textView.setText(zzs.zzu());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzaf(zzl zzl) {
        this.zza.zzaf(zzl);
    }

    public final void zzag(zzcgo zzcgo) {
        this.zza.zzag(zzcgo);
    }

    public final void zzah(zzavn zzavn) {
        this.zza.zzah(zzavn);
    }

    public final void zzai(boolean z2) {
        this.zza.zzai(z2);
    }

    public final void zzaj() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzak(Context context) {
        this.zza.zzak(context);
    }

    public final void zzal(boolean z2) {
        this.zza.zzal(z2);
    }

    public final void zzam(zzbec zzbec) {
        this.zza.zzam(zzbec);
    }

    public final void zzan(boolean z2) {
        this.zza.zzan(z2);
    }

    public final void zzao(zzbee zzbee) {
        this.zza.zzao(zzbee);
    }

    public final void zzap(zzfgw zzfgw) {
        this.zza.zzap(zzfgw);
    }

    public final void zzaq(int i2) {
        this.zza.zzaq(i2);
    }

    public final void zzar(zzl zzl) {
        this.zza.zzar(zzl);
    }

    public final void zzas(boolean z2) {
        this.zza.zzas(z2);
    }

    public final void zzat(boolean z2) {
        this.zza.zzat(z2);
    }

    public final void zzau(String str, zzbij zzbij) {
        this.zza.zzau(str, zzbij);
    }

    public final void zzav(String str, Predicate predicate) {
        this.zza.zzav(str, predicate);
    }

    public final boolean zzaw() {
        return this.zza.zzaw();
    }

    public final boolean zzax() {
        return this.zza.zzax();
    }

    public final boolean zzay(boolean z2, int i2) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaI)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzay(z2, i2);
        return true;
    }

    public final boolean zzaz() {
        return this.zza.zzaz();
    }

    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    public final void zzbj() {
        this.zza.zzbj();
    }

    public final void zzbk() {
        this.zza.zzbk();
    }

    public final String zzbl() {
        return this.zza.zzbl();
    }

    public final String zzbm() {
        return this.zza.zzbm();
    }

    public final void zzc(zzatz zzatz) {
        this.zza.zzc(zzatz);
    }

    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    public final int zzf() {
        return this.zza.zzf();
    }

    public final int zzg() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdB)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    public final int zzh() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdB)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    public final Activity zzi() {
        return this.zza.zzi();
    }

    public final zza zzj() {
        return this.zza.zzj();
    }

    public final zzbcb zzk() {
        return this.zza.zzk();
    }

    public final void zzl(String str, JSONObject jSONObject) {
        ((zzcfs) this.zza).zzb(str, jSONObject.toString());
    }

    public final zzbcc zzm() {
        return this.zza.zzm();
    }

    public final zzbzx zzn() {
        return this.zza.zzn();
    }

    public final zzcbp zzo() {
        return this.zzb;
    }

    public final zzcdl zzp(String str) {
        return this.zza.zzp(str);
    }

    public final zzcfv zzq() {
        return this.zza.zzq();
    }

    public final void zzr() {
        zzcez zzcez = this.zza;
        if (zzcez != null) {
            zzcez.zzr();
        }
    }

    public final void zzs() {
        zzcez zzcez = this.zza;
        if (zzcez != null) {
            zzcez.zzs();
        }
    }

    public final void zzt(String str, zzcdl zzcdl) {
        this.zza.zzt(str, zzcdl);
    }

    public final void zzu() {
        this.zza.zzu();
    }

    public final void zzv(boolean z2, long j2) {
        this.zza.zzv(z2, j2);
    }

    public final void zzw() {
        this.zza.zzw();
    }

    public final void zzx(int i2) {
    }

    public final void zzy(int i2) {
    }

    public final void zzz(boolean z2) {
        this.zza.zzz(false);
    }
}
