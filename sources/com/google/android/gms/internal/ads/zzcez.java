package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.common.util.Predicate;

public interface zzcez extends zza, zzdcu, zzceq, zzblc, zzcfw, zzcga, zzblp, zzaua, zzcge, zzl, zzcgh, zzcgi, zzcca, zzcgj {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i2, int i3);

    void onPause();

    void onResume();

    void setBackgroundColor(int i2);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zzC(zzcfv zzcfv);

    zzezn zzD();

    Context zzE();

    View zzF();

    WebView zzG();

    WebViewClient zzH();

    zzaqs zzI();

    zzavn zzJ();

    zzbee zzK();

    com.google.android.gms.ads.internal.overlay.zzl zzL();

    com.google.android.gms.ads.internal.overlay.zzl zzM();

    zzcgm zzN();

    zzcgo zzO();

    zzezq zzP();

    zzfgw zzQ();

    zzfwm zzR();

    String zzS();

    void zzT(zzezn zzezn, zzezq zzezq);

    void zzU();

    void zzV();

    void zzW(int i2);

    void zzX();

    void zzY();

    void zzZ(boolean z2);

    boolean zzaA();

    boolean zzaB();

    boolean zzaC();

    void zzaa();

    void zzab(String str, String str2, String str3);

    void zzac();

    void zzad(String str, zzbij zzbij);

    void zzae();

    void zzaf(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzag(zzcgo zzcgo);

    void zzah(zzavn zzavn);

    void zzai(boolean z2);

    void zzaj();

    void zzak(Context context);

    void zzal(boolean z2);

    void zzam(zzbec zzbec);

    void zzan(boolean z2);

    void zzao(zzbee zzbee);

    void zzap(zzfgw zzfgw);

    void zzaq(int i2);

    void zzar(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzas(boolean z2);

    void zzat(boolean z2);

    void zzau(String str, zzbij zzbij);

    void zzav(String str, Predicate predicate);

    boolean zzaw();

    boolean zzax();

    boolean zzay(boolean z2, int i2);

    boolean zzaz();

    Activity zzi();

    com.google.android.gms.ads.internal.zza zzj();

    zzbcc zzm();

    zzbzx zzn();

    zzcfv zzq();

    void zzt(String str, zzcdl zzcdl);
}
