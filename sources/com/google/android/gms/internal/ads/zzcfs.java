package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.util.zzce;
import com.google.android.gms.ads.internal.util.zzci;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
final class zzcfs extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcez {
    public static final /* synthetic */ int zza = 0;
    private boolean zzA;
    private boolean zzB;
    private zzbee zzC;
    private zzbec zzD;
    private zzavn zzE;
    private int zzF;
    /* access modifiers changed from: private */
    public int zzG;
    private zzbcb zzH;
    private final zzbcb zzI;
    private zzbcb zzJ;
    private final zzbcc zzK;
    private int zzL;
    private zzl zzM;
    private boolean zzN;
    private final zzci zzO;
    private int zzP = -1;
    private int zzQ = -1;
    private int zzR = -1;
    private int zzS = -1;
    private Map zzT;
    private final WindowManager zzU;
    private final zzawz zzV;
    private final zzcgn zzb;
    private final zzaqs zzc;
    private final zzbco zzd;
    private final zzbzx zze;
    private com.google.android.gms.ads.internal.zzl zzf;
    private final zza zzg;
    private final DisplayMetrics zzh;
    private final float zzi;
    private zzezn zzj;
    private zzezq zzk;
    private boolean zzl = false;
    private boolean zzm = false;
    private zzcfg zzn;
    private zzl zzo;
    private zzfgw zzp;
    private zzcgo zzq;
    private final String zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private Boolean zzw;
    private boolean zzx = true;
    private final String zzy = "";
    private zzcfv zzz;

    protected zzcfs(zzcgn zzcgn, zzcgo zzcgo, String str, boolean z2, boolean z3, zzaqs zzaqs, zzbco zzbco, zzbzx zzbzx, zzbce zzbce, com.google.android.gms.ads.internal.zzl zzl2, zza zza2, zzawz zzawz, zzezn zzezn, zzezq zzezq) {
        super(zzcgn);
        zzezq zzezq2;
        this.zzb = zzcgn;
        this.zzq = zzcgo;
        this.zzr = str;
        this.zzu = z2;
        this.zzc = zzaqs;
        this.zzd = zzbco;
        this.zze = zzbzx;
        this.zzf = zzl2;
        this.zzg = zza2;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzU = windowManager;
        zzt.zzp();
        DisplayMetrics zzq2 = zzs.zzq(windowManager);
        this.zzh = zzq2;
        this.zzi = zzq2.density;
        this.zzV = zzawz;
        this.zzj = zzezn;
        this.zzk = zzezq;
        this.zzO = new zzci(zzcgn.zza(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            zzbzr.zzh("Unable to enable Javascript.", e2);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjX)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(zzt.zzp().zzc(zzcgn, zzbzx.zza));
        zzt.zzp();
        Context context = getContext();
        zzcb.zza(context, new zzm(settings, context));
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzaS();
        addJavascriptInterface(new zzcfz(this, new zzcfy(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzba();
        zzbcc zzbcc = new zzbcc(new zzbce(true, "make_wv", this.zzr));
        this.zzK = zzbcc;
        zzbcc.zza().zzc((zzbce) null);
        if (!(!((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() || (zzezq2 = this.zzk) == null || zzezq2.zzb == null)) {
            zzbcc.zza().zzd("gqi", this.zzk.zzb);
        }
        zzbcc.zza();
        zzbcb zzf2 = zzbce.zzf();
        this.zzI = zzf2;
        zzbcc.zzb("native:view_create", zzf2);
        this.zzJ = null;
        this.zzH = null;
        zzce.zza().zzb(zzcgn);
        zzt.zzo().zzr();
    }

    private final synchronized void zzaS() {
        zzezn zzezn = this.zzj;
        if (zzezn != null) {
            if (zzezn.zzan) {
                zzbzr.zze("Disabling hardware acceleration on an overlay.");
                zzaU();
                return;
            }
        }
        if (!this.zzu) {
            if (!this.zzq.zzi()) {
                zzbzr.zze("Enabling hardware acceleration on an AdView.");
                zzaW();
                return;
            }
        }
        zzbzr.zze("Enabling hardware acceleration on an overlay.");
        zzaW();
    }

    private final synchronized void zzaT() {
        if (!this.zzN) {
            this.zzN = true;
            zzt.zzo().zzq();
        }
    }

    private final synchronized void zzaU() {
        if (!this.zzv) {
            setLayerType(1, (Paint) null);
        }
        this.zzv = true;
    }

    private final void zzaV(boolean z2) {
        String str;
        HashMap hashMap = new HashMap();
        if (true != z2) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("isVisible", str);
        zzd("onAdVisibilityChanged", hashMap);
    }

    private final synchronized void zzaW() {
        if (this.zzv) {
            setLayerType(0, (Paint) null);
        }
        this.zzv = false;
    }

    private final synchronized void zzaX(String str) {
        try {
            super.loadUrl("about:blank");
        } catch (Throwable th) {
            zzt.zzo().zzu(th, "AdWebViewImpl.loadUrlUnsafe");
            zzbzr.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzaY() {
        zzbbw.zza(this.zzK.zza(), this.zzI, "aeh2");
    }

    private final synchronized void zzaZ() {
        Map map = this.zzT;
        if (map != null) {
            for (zzcdl release : map.values()) {
                release.release();
            }
        }
        this.zzT = null;
    }

    private final void zzba() {
        zzbcc zzbcc = this.zzK;
        if (zzbcc != null) {
            zzbce zza2 = zzbcc.zza();
            zzbbu zzf2 = zzt.zzo().zzf();
            if (zzf2 != null) {
                zzf2.zzf(zza2);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzaQ(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzbb() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbza r0 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x0023 }
            java.lang.Boolean r0 = r0.zzk()     // Catch:{ all -> 0x0023 }
            r2.zzw = r0     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            java.lang.String r0 = "(function(){})()"
            r1 = 0
            r2.evaluateJavascript(r0, r1)     // Catch:{ IllegalStateException -> 0x001a }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ IllegalStateException -> 0x001a }
            r2.zzaQ(r0)     // Catch:{ IllegalStateException -> 0x001a }
            monitor-exit(r2)
            return
        L_0x001a:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0023 }
            r2.zzaQ(r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.zzbb():void");
    }

    public final synchronized void destroy() {
        zzba();
        this.zzO.zza();
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzb();
            this.zzo.zzm();
            this.zzo = null;
        }
        this.zzp = null;
        this.zzn.zzh();
        this.zzE = null;
        this.zzf = null;
        setOnClickListener((View.OnClickListener) null);
        setOnTouchListener((View.OnTouchListener) null);
        if (!this.zzt) {
            zzt.zzy().zzd(this);
            zzaZ();
            this.zzt = true;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjt)).booleanValue()) {
                zze.zza("Initiating WebView self destruct sequence in 3...");
                zze.zza("Loading blank page in WebView, 2...");
                zzaX("about:blank");
                return;
            }
            zze.zza("Destroying the WebView immediately...");
            zzU();
        }
    }

    public final synchronized void evaluateJavascript(String str, ValueCallback valueCallback) {
        if (zzaz()) {
            zzbzr.zzl("#004 The webview is destroyed. Ignoring action.", (Throwable) null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue((Object) null);
                return;
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzt) {
                    this.zzn.zzh();
                    zzt.zzy().zzd(this);
                    zzaZ();
                    zzaT();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzaz()) {
            super.loadData(str, str2, str3);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!zzaz()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!zzaz()) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                zzt.zzo().zzu(th, "AdWebViewImpl.loadUrl");
                zzbzr.zzk("Could not call loadUrl. ", th);
            }
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void onAdClicked() {
        zzcfg zzcfg = this.zzn;
        if (zzcfg != null) {
            zzcfg.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaz()) {
            this.zzO.zzc();
        }
        boolean z2 = this.zzA;
        zzcfg zzcfg = this.zzn;
        if (zzcfg != null && zzcfg.zzL()) {
            if (!this.zzB) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = true;
            }
            zzaR();
            z2 = true;
        }
        zzaV(z2);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        zzcfg zzcfg;
        synchronized (this) {
            if (!zzaz()) {
                this.zzO.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzB && (zzcfg = this.zzn) != null && zzcfg.zzL() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = false;
            }
        }
        zzaV(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzt.zzp();
            zzs.zzP(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            zzbzr.zze("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!zzaz()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean zzaR = zzaR();
        zzl zzL2 = zzL();
        if (zzL2 != null && zzaR) {
            zzL2.zzn();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01bf A[SYNTHETIC, Splitter:B:113:0x01bf] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x013c  */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzaz()     // Catch:{ all -> 0x01e5 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x000d:
            boolean r0 = r8.isInEditMode()     // Catch:{ all -> 0x01e5 }
            if (r0 != 0) goto L_0x01e0
            boolean r0 = r8.zzu     // Catch:{ all -> 0x01e5 }
            if (r0 != 0) goto L_0x01e0
            com.google.android.gms.internal.ads.zzcgo r0 = r8.zzq     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.zzf()     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0021
            goto L_0x01e0
        L_0x0021:
            com.google.android.gms.internal.ads.zzcgo r0 = r8.zzq     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.zzh()     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzcgo r0 = r8.zzq     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.zzj()     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzdA     // Catch:{ all -> 0x01e5 }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x01e5 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzcfv r0 = r8.zzq()     // Catch:{ all -> 0x01e5 }
            r2 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.zze()     // Catch:{ all -> 0x01e5 }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0063
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x0063:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e5 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e5 }
            float r2 = (float) r10     // Catch:{ all -> 0x01e5 }
            float r2 = r2 * r0
            float r3 = (float) r9     // Catch:{ all -> 0x01e5 }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x01e5 }
            if (r10 != 0) goto L_0x007d
            if (r3 == 0) goto L_0x007c
            float r10 = (float) r3     // Catch:{ all -> 0x01e5 }
            float r10 = r10 * r0
            int r10 = (int) r10     // Catch:{ all -> 0x01e5 }
            r1 = r9
            r9 = r3
            goto L_0x008c
        L_0x007c:
            r10 = 0
        L_0x007d:
            int r2 = (int) r2     // Catch:{ all -> 0x01e5 }
            if (r9 != 0) goto L_0x0089
            if (r2 == 0) goto L_0x008a
            float r9 = (float) r2     // Catch:{ all -> 0x01e5 }
            float r9 = r9 / r0
            int r3 = (int) r9     // Catch:{ all -> 0x01e5 }
            r9 = r10
            r10 = r2
            r1 = r10
            goto L_0x008c
        L_0x0089:
            r1 = r9
        L_0x008a:
            r9 = r10
            r10 = r2
        L_0x008c:
            int r10 = java.lang.Math.min(r10, r1)     // Catch:{ all -> 0x01e5 }
            int r9 = java.lang.Math.min(r3, r9)     // Catch:{ all -> 0x01e5 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x0099:
            com.google.android.gms.internal.ads.zzcgo r0 = r8.zzq     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.zzg()     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x00e2
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzdG     // Catch:{ all -> 0x01e5 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x01e5 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x00b8
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x00b8:
            com.google.android.gms.internal.ads.zzcfq r0 = new com.google.android.gms.internal.ads.zzcfq     // Catch:{ all -> 0x01e5 }
            r0.<init>(r8)     // Catch:{ all -> 0x01e5 }
            java.lang.String r1 = "/contentHeight"
            r8.zzad(r1, r0)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r8.zzaO(r0)     // Catch:{ all -> 0x01e5 }
            android.util.DisplayMetrics r0 = r8.zzh     // Catch:{ all -> 0x01e5 }
            float r0 = r0.density     // Catch:{ all -> 0x01e5 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e5 }
            int r1 = r8.zzG     // Catch:{ all -> 0x01e5 }
            r2 = -1
            if (r1 == r2) goto L_0x00d9
            float r10 = (float) r1     // Catch:{ all -> 0x01e5 }
            float r10 = r10 * r0
            int r10 = (int) r10     // Catch:{ all -> 0x01e5 }
            goto L_0x00dd
        L_0x00d9:
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e5 }
        L_0x00dd:
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x00e2:
            com.google.android.gms.internal.ads.zzcgo r0 = r8.zzq     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.zzi()     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x00f5
            android.util.DisplayMetrics r9 = r8.zzh     // Catch:{ all -> 0x01e5 }
            int r10 = r9.widthPixels     // Catch:{ all -> 0x01e5 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01e5 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x00f5:
            int r0 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01e5 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e5 }
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x01e5 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e5 }
            r3 = 2147483647(0x7fffffff, float:NaN)
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r5) goto L_0x0115
            if (r0 != r4) goto L_0x0111
            goto L_0x0115
        L_0x0111:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0116
        L_0x0115:
            r0 = r9
        L_0x0116:
            if (r2 == r5) goto L_0x011a
            if (r2 != r4) goto L_0x011b
        L_0x011a:
            r3 = r10
        L_0x011b:
            com.google.android.gms.internal.ads.zzcgo r2 = r8.zzq     // Catch:{ all -> 0x01e5 }
            int r4 = r2.zzb     // Catch:{ all -> 0x01e5 }
            r5 = 1
            if (r4 > r0) goto L_0x0129
            int r2 = r2.zza     // Catch:{ all -> 0x01e5 }
            if (r2 <= r3) goto L_0x0127
            goto L_0x0129
        L_0x0127:
            r2 = 0
            goto L_0x012a
        L_0x0129:
            r2 = 1
        L_0x012a:
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzfg     // Catch:{ all -> 0x01e5 }
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x01e5 }
            java.lang.Object r4 = r6.zzb(r4)     // Catch:{ all -> 0x01e5 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01e5 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01e5 }
            if (r4 == 0) goto L_0x0158
            com.google.android.gms.internal.ads.zzcgo r4 = r8.zzq     // Catch:{ all -> 0x01e5 }
            int r6 = r4.zzb     // Catch:{ all -> 0x01e5 }
            float r6 = (float) r6     // Catch:{ all -> 0x01e5 }
            float r7 = r8.zzi     // Catch:{ all -> 0x01e5 }
            float r6 = r6 / r7
            float r0 = (float) r0     // Catch:{ all -> 0x01e5 }
            float r0 = r0 / r7
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0156
            int r0 = r4.zza     // Catch:{ all -> 0x01e5 }
            float r0 = (float) r0     // Catch:{ all -> 0x01e5 }
            float r0 = r0 / r7
            float r3 = (float) r3     // Catch:{ all -> 0x01e5 }
            float r3 = r3 / r7
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0156
            r0 = 1
            goto L_0x0157
        L_0x0156:
            r0 = 0
        L_0x0157:
            r2 = r2 & r0
        L_0x0158:
            r0 = 8
            if (r2 == 0) goto L_0x01bf
            com.google.android.gms.internal.ads.zzcgo r2 = r8.zzq     // Catch:{ all -> 0x01e5 }
            int r3 = r2.zzb     // Catch:{ all -> 0x01e5 }
            float r3 = (float) r3     // Catch:{ all -> 0x01e5 }
            float r4 = r8.zzi     // Catch:{ all -> 0x01e5 }
            float r3 = r3 / r4
            int r2 = r2.zza     // Catch:{ all -> 0x01e5 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e5 }
            float r2 = r2 / r4
            float r9 = (float) r9     // Catch:{ all -> 0x01e5 }
            float r9 = r9 / r4
            float r10 = (float) r10     // Catch:{ all -> 0x01e5 }
            float r10 = r10 / r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            r4.<init>()     // Catch:{ all -> 0x01e5 }
            java.lang.String r6 = "Not enough space to show ad. Needs "
            r4.append(r6)     // Catch:{ all -> 0x01e5 }
            int r3 = (int) r3     // Catch:{ all -> 0x01e5 }
            r4.append(r3)     // Catch:{ all -> 0x01e5 }
            java.lang.String r3 = "x"
            r4.append(r3)     // Catch:{ all -> 0x01e5 }
            int r2 = (int) r2     // Catch:{ all -> 0x01e5 }
            r4.append(r2)     // Catch:{ all -> 0x01e5 }
            java.lang.String r2 = " dp, but only has "
            r4.append(r2)     // Catch:{ all -> 0x01e5 }
            int r9 = (int) r9     // Catch:{ all -> 0x01e5 }
            r4.append(r9)     // Catch:{ all -> 0x01e5 }
            java.lang.String r9 = "x"
            r4.append(r9)     // Catch:{ all -> 0x01e5 }
            int r9 = (int) r10     // Catch:{ all -> 0x01e5 }
            r4.append(r9)     // Catch:{ all -> 0x01e5 }
            java.lang.String r9 = " dp."
            r4.append(r9)     // Catch:{ all -> 0x01e5 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x01e5 }
            com.google.android.gms.internal.ads.zzbzr.zzj(r9)     // Catch:{ all -> 0x01e5 }
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01e5 }
            if (r9 == r0) goto L_0x01ab
            r9 = 4
            r8.setVisibility(r9)     // Catch:{ all -> 0x01e5 }
        L_0x01ab:
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01e5 }
            boolean r9 = r8.zzl     // Catch:{ all -> 0x01e5 }
            if (r9 != 0) goto L_0x01bd
            com.google.android.gms.internal.ads.zzawz r9 = r8.zzV     // Catch:{ all -> 0x01e5 }
            r10 = 10001(0x2711, float:1.4014E-41)
            r9.zzc(r10)     // Catch:{ all -> 0x01e5 }
            r8.zzl = r5     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x01bd:
            monitor-exit(r8)
            return
        L_0x01bf:
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01e5 }
            if (r9 == r0) goto L_0x01c8
            r8.setVisibility(r1)     // Catch:{ all -> 0x01e5 }
        L_0x01c8:
            boolean r9 = r8.zzm     // Catch:{ all -> 0x01e5 }
            if (r9 != 0) goto L_0x01d5
            com.google.android.gms.internal.ads.zzawz r9 = r8.zzV     // Catch:{ all -> 0x01e5 }
            r10 = 10002(0x2712, float:1.4016E-41)
            r9.zzc(r10)     // Catch:{ all -> 0x01e5 }
            r8.zzm = r5     // Catch:{ all -> 0x01e5 }
        L_0x01d5:
            com.google.android.gms.internal.ads.zzcgo r9 = r8.zzq     // Catch:{ all -> 0x01e5 }
            int r10 = r9.zzb     // Catch:{ all -> 0x01e5 }
            int r9 = r9.zza     // Catch:{ all -> 0x01e5 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x01e0:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e5 }
            monitor-exit(r8)
            return
        L_0x01e5:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!zzaz()) {
            try {
                super.onPause();
            } catch (Exception e2) {
                zzbzr.zzh("Could not pause webview.", e2);
            }
        }
    }

    public final void onResume() {
        if (!zzaz()) {
            try {
                super.onResume();
            } catch (Exception e2) {
                zzbzr.zzh("Could not resume webview.", e2);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzn.zzL() || this.zzn.zzJ()) {
            zzaqs zzaqs = this.zzc;
            if (zzaqs != null) {
                zzaqs.zzd(motionEvent);
            }
            zzbco zzbco = this.zzd;
            if (zzbco != null) {
                zzbco.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzbee zzbee = this.zzC;
                if (zzbee != null) {
                    zzbee.zzd(motionEvent);
                }
            }
        }
        if (zzaz()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcfg) {
            this.zzn = (zzcfg) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!zzaz()) {
            try {
                super.stopLoading();
            } catch (Exception e2) {
                zzbzr.zzh("Could not stop loading webview.", e2);
            }
        }
    }

    public final synchronized void zzA(int i2) {
        this.zzL = i2;
    }

    public final void zzB(int i2) {
    }

    public final synchronized void zzC(zzcfv zzcfv) {
        if (this.zzz != null) {
            zzbzr.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzz = zzcfv;
        }
    }

    public final zzezn zzD() {
        return this.zzj;
    }

    public final Context zzE() {
        return this.zzb.zzb();
    }

    public final View zzF() {
        return this;
    }

    public final WebView zzG() {
        return this;
    }

    public final WebViewClient zzH() {
        return this.zzn;
    }

    public final zzaqs zzI() {
        return this.zzc;
    }

    public final synchronized zzavn zzJ() {
        return this.zzE;
    }

    public final synchronized zzbee zzK() {
        return this.zzC;
    }

    public final synchronized zzl zzL() {
        return this.zzo;
    }

    public final synchronized zzl zzM() {
        return this.zzM;
    }

    public final /* synthetic */ zzcgm zzN() {
        return this.zzn;
    }

    public final synchronized zzcgo zzO() {
        return this.zzq;
    }

    public final zzezq zzP() {
        return this.zzk;
    }

    public final synchronized zzfgw zzQ() {
        return this.zzp;
    }

    public final zzfwm zzR() {
        zzbco zzbco = this.zzd;
        if (zzbco == null) {
            return zzfwc.zzh((Object) null);
        }
        return zzbco.zza();
    }

    public final synchronized String zzS() {
        return this.zzr;
    }

    public final void zzT(zzezn zzezn, zzezq zzezq) {
        this.zzj = zzezn;
        this.zzk = zzezq;
    }

    public final synchronized void zzU() {
        zze.zza("Destroying WebView!");
        zzaT();
        zzs.zza.post(new zzcfr(this));
    }

    public final void zzV() {
        zzaY();
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.zze.zza);
        zzd("onhide", hashMap);
    }

    public final void zzW(int i2) {
        if (i2 == 0) {
            zzbbw.zza(this.zzK.zza(), this.zzI, "aebb2");
        }
        zzaY();
        this.zzK.zza();
        this.zzK.zza().zzd("close_type", String.valueOf(i2));
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i2));
        hashMap.put(MediationMetaData.KEY_VERSION, this.zze.zza);
        zzd("onhide", hashMap);
    }

    public final void zzX() {
        if (this.zzH == null) {
            zzbbw.zza(this.zzK.zza(), this.zzI, "aes2");
            this.zzK.zza();
            zzbcb zzf2 = zzbce.zzf();
            this.zzH = zzf2;
            this.zzK.zzb("native:view_show", zzf2);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.zze.zza);
        zzd("onshow", hashMap);
    }

    public final void zzY() {
        throw null;
    }

    public final void zzZ(boolean z2) {
        this.zzn.zzi(z2);
    }

    public final void zza(String str) {
        throw null;
    }

    public final synchronized boolean zzaA() {
        return this.zzu;
    }

    public final boolean zzaB() {
        return false;
    }

    public final synchronized boolean zzaC() {
        return this.zzx;
    }

    public final void zzaD(zzc zzc2, boolean z2) {
        this.zzn.zzt(zzc2, z2);
    }

    public final void zzaE(zzbr zzbr, String str, String str2, int i2) {
        this.zzn.zzu(zzbr, str, str2, 14);
    }

    public final void zzaF(boolean z2, int i2, boolean z3) {
        this.zzn.zzv(z2, i2, z3);
    }

    public final void zzaG(boolean z2, int i2, String str, boolean z3) {
        this.zzn.zzx(z2, i2, str, z3);
    }

    public final void zzaH(boolean z2, int i2, String str, String str2, boolean z3) {
        this.zzn.zzy(z2, i2, str, str2, z3);
    }

    public final zzcfg zzaJ() {
        return this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final synchronized Boolean zzaK() {
        return this.zzw;
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzaN(String str, ValueCallback valueCallback) {
        if (!zzaz()) {
            evaluateJavascript(str, (ValueCallback) null);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaO(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzaK() == null) {
                zzbb();
            }
            if (zzaK().booleanValue()) {
                zzaN(str, (ValueCallback) null);
            } else {
                zzaP("javascript:".concat(str));
            }
        } else {
            zzaP("javascript:".concat(str));
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzaP(String str) {
        if (!zzaz()) {
            loadUrl(str);
        } else {
            zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzaQ(Boolean bool) {
        synchronized (this) {
            this.zzw = bool;
        }
        zzt.zzo().zzv(bool);
    }

    public final boolean zzaR() {
        int i2;
        int i3;
        boolean z2 = false;
        if (!this.zzn.zzK() && !this.zzn.zzL()) {
            return false;
        }
        zzay.zzb();
        DisplayMetrics displayMetrics = this.zzh;
        int zzv2 = zzbzk.zzv(displayMetrics, displayMetrics.widthPixels);
        zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zzh;
        int zzv3 = zzbzk.zzv(displayMetrics2, displayMetrics2.heightPixels);
        Activity zza2 = this.zzb.zza();
        if (zza2 == null || zza2.getWindow() == null) {
            i3 = zzv2;
            i2 = zzv3;
        } else {
            zzt.zzp();
            int[] zzM2 = zzs.zzM(zza2);
            zzay.zzb();
            int zzv4 = zzbzk.zzv(this.zzh, zzM2[0]);
            zzay.zzb();
            i2 = zzbzk.zzv(this.zzh, zzM2[1]);
            i3 = zzv4;
        }
        int i4 = this.zzQ;
        if (i4 == zzv2 && this.zzP == zzv3 && this.zzR == i3 && this.zzS == i2) {
            return false;
        }
        if (!(i4 == zzv2 && this.zzP == zzv3)) {
            z2 = true;
        }
        this.zzQ = zzv2;
        this.zzP = zzv3;
        this.zzR = i3;
        this.zzS = i2;
        new zzbqw(this, "").zzi(zzv2, zzv3, i3, i2, this.zzh.density, this.zzU.getDefaultDisplay().getRotation());
        return z2;
    }

    public final void zzaa() {
        this.zzO.zzb();
    }

    public final synchronized void zzab(String str, String str2, String str3) {
        String str4;
        if (!zzaz()) {
            String[] strArr = new String[1];
            String str5 = (String) zzba.zzc().zzb(zzbbm.zzQ);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MediationMetaData.KEY_VERSION, str5);
                jSONObject.put(ServiceProvider.NAMED_SDK, "Google Mobile Ads");
                jSONObject.put("sdkVersion", "12.4.51-000");
                str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
            } catch (JSONException e2) {
                zzbzr.zzk("Unable to build MRAID_ENV", e2);
                str4 = null;
            }
            strArr[0] = str4;
            super.loadDataWithBaseURL(str, zzcgf.zza(str2, strArr), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8", (String) null);
            return;
        }
        zzbzr.zzj("#004 The webview is destroyed. Ignoring action.");
    }

    public final void zzac() {
        if (this.zzJ == null) {
            this.zzK.zza();
            zzbcb zzf2 = zzbce.zzf();
            this.zzJ = zzf2;
            this.zzK.zzb("native:view_load", zzf2);
        }
    }

    public final void zzad(String str, zzbij zzbij) {
        zzcfg zzcfg = this.zzn;
        if (zzcfg != null) {
            zzcfg.zzz(str, zzbij);
        }
    }

    public final void zzae() {
        throw null;
    }

    public final synchronized void zzaf(zzl zzl2) {
        this.zzo = zzl2;
    }

    public final synchronized void zzag(zzcgo zzcgo) {
        this.zzq = zzcgo;
        requestLayout();
    }

    public final synchronized void zzah(zzavn zzavn) {
        this.zzE = zzavn;
    }

    public final synchronized void zzai(boolean z2) {
        this.zzx = z2;
    }

    public final void zzaj() {
        setBackgroundColor(0);
    }

    public final void zzak(Context context) {
        this.zzb.setBaseContext(context);
        this.zzO.zze(this.zzb.zza());
    }

    public final synchronized void zzal(boolean z2) {
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzy(this.zzn.zzK(), z2);
        } else {
            this.zzs = z2;
        }
    }

    public final synchronized void zzam(zzbec zzbec) {
        this.zzD = zzbec;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzan(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzu     // Catch:{ all -> 0x003a }
            r2.zzu = r3     // Catch:{ all -> 0x003a }
            r2.zzaS()     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzR     // Catch:{ all -> 0x003a }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x003a }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzcgo r0 = r2.zzq     // Catch:{ all -> 0x003a }
            boolean r0 = r0.zzi()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0038
        L_0x0024:
            java.lang.String r0 = ""
            com.google.android.gms.internal.ads.zzbqw r1 = new com.google.android.gms.internal.ads.zzbqw     // Catch:{ all -> 0x003a }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x003a }
            r0 = 1
            if (r0 == r3) goto L_0x0031
            java.lang.String r3 = "default"
            goto L_0x0033
        L_0x0031:
            java.lang.String r3 = "expanded"
        L_0x0033:
            r1.zzk(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return
        L_0x0038:
            monitor-exit(r2)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.zzan(boolean):void");
    }

    public final synchronized void zzao(zzbee zzbee) {
        this.zzC = zzbee;
    }

    public final synchronized void zzap(zzfgw zzfgw) {
        this.zzp = zzfgw;
    }

    public final synchronized void zzaq(int i2) {
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzA(i2);
        }
    }

    public final synchronized void zzar(zzl zzl2) {
        this.zzM = zzl2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzas(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.zzF     // Catch:{ all -> 0x0017 }
            r1 = 1
            if (r1 == r3) goto L_0x0007
            r1 = -1
        L_0x0007:
            int r0 = r0 + r1
            r2.zzF = r0     // Catch:{ all -> 0x0017 }
            if (r0 > 0) goto L_0x0015
            com.google.android.gms.ads.internal.overlay.zzl r3 = r2.zzo     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            r3.zzE()     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            return
        L_0x0015:
            monitor-exit(r2)
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.zzas(boolean):void");
    }

    public final synchronized void zzat(boolean z2) {
        if (z2) {
            setBackgroundColor(0);
        }
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzB(z2);
        }
    }

    public final void zzau(String str, zzbij zzbij) {
        zzcfg zzcfg = this.zzn;
        if (zzcfg != null) {
            zzcfg.zzH(str, zzbij);
        }
    }

    public final void zzav(String str, Predicate predicate) {
        zzcfg zzcfg = this.zzn;
        if (zzcfg != null) {
            zzcfg.zzI(str, predicate);
        }
    }

    public final synchronized boolean zzaw() {
        return this.zzs;
    }

    public final synchronized boolean zzax() {
        return this.zzF > 0;
    }

    public final boolean zzay(boolean z2, int i2) {
        destroy();
        this.zzV.zzb(new zzcfp(z2, i2));
        this.zzV.zzc(10003);
        return true;
    }

    public final synchronized boolean zzaz() {
        return this.zzt;
    }

    public final void zzb(String str, String str2) {
        zzaO(str + "(" + str2 + ");");
    }

    public final synchronized void zzbj() {
        com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
        if (zzl2 != null) {
            zzl2.zzbj();
        }
    }

    public final synchronized void zzbk() {
        com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
        if (zzl2 != null) {
            zzl2.zzbk();
        }
    }

    public final synchronized String zzbl() {
        zzezq zzezq = this.zzk;
        if (zzezq == null) {
            return null;
        }
        return zzezq.zzb;
    }

    public final synchronized String zzbm() {
        return this.zzy;
    }

    public final void zzc(zzatz zzatz) {
        boolean z2;
        synchronized (this) {
            z2 = zzatz.zzj;
            this.zzA = z2;
        }
        zzaV(z2);
    }

    public final void zzd(String str, Map map) {
        try {
            zze(str, zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzbzr.zzj("Could not convert parameters to JSON.");
        }
    }

    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzbzr.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzaO(sb.toString());
    }

    public final synchronized int zzf() {
        return this.zzL;
    }

    public final int zzg() {
        return getMeasuredHeight();
    }

    public final int zzh() {
        return getMeasuredWidth();
    }

    public final Activity zzi() {
        return this.zzb.zza();
    }

    public final zza zzj() {
        return this.zzg;
    }

    public final zzbcb zzk() {
        return this.zzI;
    }

    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    public final zzbcc zzm() {
        return this.zzK;
    }

    public final zzbzx zzn() {
        return this.zze;
    }

    public final zzcbp zzo() {
        return null;
    }

    public final synchronized zzcdl zzp(String str) {
        Map map = this.zzT;
        if (map == null) {
            return null;
        }
        return (zzcdl) map.get(str);
    }

    public final synchronized zzcfv zzq() {
        return this.zzz;
    }

    public final void zzr() {
        zzcfg zzcfg = this.zzn;
        if (zzcfg != null) {
            zzcfg.zzr();
        }
    }

    public final void zzs() {
        zzcfg zzcfg = this.zzn;
        if (zzcfg != null) {
            zzcfg.zzs();
        }
    }

    public final synchronized void zzt(String str, zzcdl zzcdl) {
        if (this.zzT == null) {
            this.zzT = new HashMap();
        }
        this.zzT.put(str, zzcdl);
    }

    public final void zzu() {
        zzl zzL2 = zzL();
        if (zzL2 != null) {
            zzL2.zzd();
        }
    }

    public final void zzv(boolean z2, long j2) {
        String str;
        HashMap hashMap = new HashMap(2);
        if (true != z2) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("success", str);
        hashMap.put("duration", Long.toString(j2));
        zzd("onCacheAccessComplete", hashMap);
    }

    public final synchronized void zzw() {
        zzbec zzbec = this.zzD;
        if (zzbec != null) {
            zzs.zza.post(new zzdkw((zzdky) zzbec));
        }
    }

    public final void zzx(int i2) {
    }

    public final void zzy(int i2) {
    }

    public final void zzz(boolean z2) {
        this.zzn.zzC(false);
    }
}
