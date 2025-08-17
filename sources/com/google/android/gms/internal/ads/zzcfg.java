package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.joda.time.DateTimeConstants;

public class zzcfg extends WebViewClient implements zzcgm {
    public static final /* synthetic */ int zzb = 0;
    private final HashSet zzA;
    private final zzebl zzB;
    private View.OnAttachStateChangeListener zzC;
    protected zzbws zza;
    private final zzcez zzc;
    private final zzawz zzd;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private zza zzg;
    private zzo zzh;
    private zzcgk zzi;
    private zzcgl zzj;
    private zzbhc zzk;
    private zzbhe zzl;
    private zzdcu zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private zzz zzs;
    private zzbqv zzt;
    private zzb zzu;
    private zzbqq zzv;
    private boolean zzw;
    private boolean zzx;
    private int zzy;
    private boolean zzz;

    public zzcfg(zzcez zzcez, zzawz zzawz, boolean z2, zzbqv zzbqv, zzbqq zzbqq, zzebl zzebl) {
        this.zzd = zzawz;
        this.zzc = zzcez;
        this.zzp = z2;
        this.zzt = zzbqv;
        this.zzv = null;
        this.zzA = new HashSet(Arrays.asList(((String) zzba.zzc().zzb(zzbbm.zzfr)).split(",")));
        this.zzB = zzebl;
    }

    private static WebResourceResponse zzN() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaG)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzO(String str, Map map) throws IOException {
        HttpURLConnection httpURLConnection;
        String str2;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i2 = 0;
            while (true) {
                i2++;
                if (i2 <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry entry : map.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzt.zzp().zzf(this.zzc.getContext(), this.zzc.zzn().zza, false, httpURLConnection, false, DateTimeConstants.MILLIS_PER_MINUTE);
                        zzbzq zzbzq = new zzbzq((String) null);
                        zzbzq.zzc(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzbzq.zze(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzt.zzp();
                            zzt.zzp();
                            String contentType = httpURLConnection.getContentType();
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField == null) {
                                throw new IOException("Missing Location header in redirect");
                            } else if (headerField.startsWith("tel:")) {
                                TrafficStats.clearThreadStatsTag();
                                return null;
                            } else {
                                URL url2 = new URL(url, headerField);
                                String protocol = url2.getProtocol();
                                if (protocol == null) {
                                    zzbzr.zzj("Protocol is null");
                                    WebResourceResponse zzN = zzN();
                                    TrafficStats.clearThreadStatsTag();
                                    return zzN;
                                } else if (protocol.equals(UriUtil.HTTP_SCHEME) || protocol.equals(UriUtil.HTTPS_SCHEME)) {
                                    zzbzr.zze("Redirecting to " + headerField);
                                    httpURLConnection.disconnect();
                                    url = url2;
                                } else {
                                    zzbzr.zzj("Unsupported scheme: " + protocol);
                                    return zzN();
                                }
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            zzt.zzp();
            zzt.zzp();
            String contentType2 = httpURLConnection.getContentType();
            String str3 = "";
            if (TextUtils.isEmpty(contentType2)) {
                str2 = str3;
            } else {
                str2 = contentType2.split(";")[0].trim();
            }
            zzt.zzp();
            String contentType3 = httpURLConnection.getContentType();
            if (!TextUtils.isEmpty(contentType3)) {
                String[] split = contentType3.split(";");
                if (split.length != 1) {
                    int i3 = 1;
                    while (true) {
                        if (i3 >= split.length) {
                            break;
                        }
                        if (split[i3].trim().startsWith("charset")) {
                            String[] split2 = split[i3].trim().split("=");
                            if (split2.length > 1) {
                                str3 = split2[1].trim();
                                break;
                            }
                        }
                        i3++;
                    }
                }
            }
            String str4 = str3;
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            HashMap hashMap = new HashMap(headerFields.size());
            for (Map.Entry next : headerFields.entrySet()) {
                if (!(next.getKey() == null || next.getValue() == null || ((List) next.getValue()).isEmpty())) {
                    hashMap.put((String) next.getKey(), (String) ((List) next.getValue()).get(0));
                }
            }
            WebResourceResponse zzc2 = zzt.zzq().zzc(str2, str4, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
            TrafficStats.clearThreadStatsTag();
            return zzc2;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzP(Map map, List list, String str) {
        if (zze.zzc()) {
            zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((zzbij) it2.next()).zza(this.zzc, map);
        }
    }

    private final void zzQ() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzC;
        if (onAttachStateChangeListener != null) {
            ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    /* access modifiers changed from: private */
    public final void zzR(View view, zzbws zzbws, int i2) {
        if (zzbws.zzi() && i2 > 0) {
            zzbws.zzg(view);
            if (zzbws.zzi()) {
                zzs.zza.postDelayed(new zzcfc(this, view, zzbws, i2), 100);
            }
        }
    }

    private static final boolean zzS(zzcez zzcez) {
        if (zzcez.zzD() != null) {
            return zzcez.zzD().zzaj;
        }
        return false;
    }

    private static final boolean zzT(boolean z2, zzcez zzcez) {
        if (!z2 || zzcez.zzO().zzi() || zzcez.zzS().equals("interstitial_mb")) {
            return false;
        }
        return true;
    }

    public final void onAdClicked() {
        zza zza2 = this.zzg;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zza();
        r0.zzj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzw = true;
        r1 = r0.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.zzf
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcez r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.zzaz()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzcez r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            r2.zzU()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzw = r1
            com.google.android.gms.internal.ads.zzcgl r1 = r0.zzj
            if (r1 == 0) goto L_0x0025
            r1.zza()
            r1 = 0
            r0.zzj = r1
        L_0x0025:
            r0.zzg()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfg.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        this.zzo = true;
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzay(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case EMPTY_TPAT_ERROR_VALUE:
                    case MRAID_DOWNLOAD_JS_ERROR_VALUE:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = parse.getScheme();
                if (UriUtil.HTTP_SCHEME.equalsIgnoreCase(scheme) || UriUtil.HTTPS_SCHEME.equalsIgnoreCase(scheme)) {
                    zza zza2 = this.zzg;
                    if (zza2 != null) {
                        zza2.onAdClicked();
                        zzbws zzbws = this.zza;
                        if (zzbws != null) {
                            zzbws.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdcu zzdcu = this.zzm;
                    if (zzdcu != null) {
                        zzdcu.zzr();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzc.zzG().willNotDraw()) {
                try {
                    zzaqs zzI = this.zzc.zzI();
                    if (zzI != null && zzI.zzf(parse)) {
                        Context context = this.zzc.getContext();
                        zzcez zzcez = this.zzc;
                        parse = zzI.zza(parse, context, (View) zzcez, zzcez.zzi());
                    }
                } catch (zzaqt unused) {
                    zzbzr.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                zzb zzb2 = this.zzu;
                if (zzb2 == null || zzb2.zzc()) {
                    zzt(new zzc("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (zzx) null), true);
                } else {
                    this.zzu.zzb(str);
                }
            } else {
                zzbzr.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            }
        } else {
            zzj(parse);
        }
        return true;
    }

    public final void zzA(zzcgk zzcgk) {
        this.zzi = zzcgk;
    }

    public final void zzB(int i2, int i3) {
        zzbqq zzbqq = this.zzv;
        if (zzbqq != null) {
            zzbqq.zzd(i2, i3);
        }
    }

    public final void zzC(boolean z2) {
        this.zzn = false;
    }

    public final void zzD(boolean z2) {
        synchronized (this.zzf) {
            this.zzr = z2;
        }
    }

    public final void zzE() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzp = true;
            zzcae.zze.execute(new zzcfb(this));
        }
    }

    public final void zzF(boolean z2) {
        synchronized (this.zzf) {
            this.zzq = true;
        }
    }

    public final void zzG(zzcgl zzcgl) {
        this.zzj = zzcgl;
    }

    public final void zzH(String str, zzbij zzbij) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list != null) {
                list.remove(zzbij);
            }
        }
    }

    public final void zzI(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbij> list = (List) this.zze.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzbij zzbij : list) {
                    if (predicate.apply(zzbij)) {
                        arrayList.add(zzbij);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final boolean zzJ() {
        boolean z2;
        synchronized (this.zzf) {
            z2 = this.zzr;
        }
        return z2;
    }

    public final boolean zzK() {
        boolean z2;
        synchronized (this.zzf) {
            z2 = this.zzp;
        }
        return z2;
    }

    public final boolean zzL() {
        boolean z2;
        synchronized (this.zzf) {
            z2 = this.zzq;
        }
        return z2;
    }

    public final void zzM(zza zza2, zzbhc zzbhc, zzo zzo2, zzbhe zzbhe, zzz zzz2, boolean z2, zzbil zzbil, zzb zzb2, zzbqx zzbqx, zzbws zzbws, zzeba zzeba, zzfgr zzfgr, zzdqa zzdqa, zzfev zzfev, zzbjb zzbjb, zzdcu zzdcu, zzbja zzbja, zzbiu zzbiu) {
        zzbhc zzbhc2 = zzbhc;
        zzbhe zzbhe2 = zzbhe;
        zzbil zzbil2 = zzbil;
        zzbqx zzbqx2 = zzbqx;
        zzbws zzbws2 = zzbws;
        zzeba zzeba2 = zzeba;
        zzfgr zzfgr2 = zzfgr;
        zzbjb zzbjb2 = zzbjb;
        zzdcu zzdcu2 = zzdcu;
        zzbja zzbja2 = zzbja;
        zzbiu zzbiu2 = zzbiu;
        zzb zzb3 = zzb2 == null ? new zzb(this.zzc.getContext(), zzbws2, (zzbtk) null) : zzb2;
        this.zzv = new zzbqq(this.zzc, zzbqx2);
        this.zza = zzbws2;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaO)).booleanValue()) {
            zzz("/adMetadata", new zzbhb(zzbhc2));
        }
        if (zzbhe2 != null) {
            zzz("/appEvent", new zzbhd(zzbhe2));
        }
        zzz("/backButton", zzbii.zzj);
        zzz("/refresh", zzbii.zzk);
        zzz("/canOpenApp", zzbii.zzb);
        zzz("/canOpenURLs", zzbii.zza);
        zzz("/canOpenIntents", zzbii.zzc);
        zzz("/close", zzbii.zzd);
        zzz("/customClose", zzbii.zze);
        zzz("/instrument", zzbii.zzn);
        zzz("/delayPageLoaded", zzbii.zzp);
        zzz("/delayPageClosed", zzbii.zzq);
        zzz("/getLocationInfo", zzbii.zzr);
        zzz("/log", zzbii.zzg);
        zzz("/mraid", new zzbip(zzb3, this.zzv, zzbqx2));
        zzbqv zzbqv = this.zzt;
        if (zzbqv != null) {
            zzz("/mraidLoaded", zzbqv);
        }
        zzbit zzbit = r4;
        zzb zzb4 = zzb3;
        zzbit zzbit2 = new zzbit(zzb3, this.zzv, zzeba, zzdqa, zzfev);
        zzz("/open", zzbit);
        zzz("/precache", new zzcdm());
        zzz("/touch", zzbii.zzi);
        zzz("/video", zzbii.zzl);
        zzz("/videoMeta", zzbii.zzm);
        if (zzeba2 == null || zzfgr2 == null) {
            zzz("/click", new zzbhk(zzdcu2));
            zzz("/httpTrack", zzbii.zzf);
        } else {
            zzz("/click", new zzfap(zzdcu2, zzfgr2, zzeba2));
            zzz("/httpTrack", new zzfao(zzfgr2, zzeba2));
        }
        if (zzt.zzn().zzu(this.zzc.getContext())) {
            zzz("/logScionEvent", new zzbio(this.zzc.getContext()));
        }
        if (zzbil2 != null) {
            zzz("/setInterstitialProperties", new zzbik(zzbil2));
        }
        if (zzbjb2 != null) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
                zzz("/inspectorNetworkExtras", zzbjb2);
            }
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziN)).booleanValue() && zzbja2 != null) {
            zzz("/shareSheet", zzbja2);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziQ)).booleanValue() && zzbiu2 != null) {
            zzz("/inspectorOutOfContextTest", zzbiu2);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjR)).booleanValue()) {
            zzz("/bindPlayStoreOverlay", zzbii.zzu);
            zzz("/presentPlayStoreOverlay", zzbii.zzv);
            zzz("/expandPlayStoreOverlay", zzbii.zzw);
            zzz("/collapsePlayStoreOverlay", zzbii.zzx);
            zzz("/closePlayStoreOverlay", zzbii.zzy);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzcR)).booleanValue()) {
                zzz("/setPAIDPersonalizationEnabled", zzbii.zzA);
                zzz("/resetPAID", zzbii.zzz);
            }
        }
        this.zzg = zza2;
        this.zzh = zzo2;
        this.zzk = zzbhc2;
        this.zzl = zzbhe;
        this.zzs = zzz2;
        this.zzu = zzb4;
        this.zzm = zzdcu2;
        this.zzn = z2;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzc(String str, Map map) {
        zzawi zzb2;
        try {
            String zzc2 = zzbxy.zzc(str, this.zzc.getContext(), this.zzz);
            if (!zzc2.equals(str)) {
                return zzO(zzc2, map);
            }
            zzawl zza2 = zzawl.zza(Uri.parse(str));
            if (zza2 != null && (zzb2 = zzt.zzc().zzb(zza2)) != null && zzb2.zze()) {
                return new WebResourceResponse("", "", zzb2.zzc());
            }
            if (!zzbzq.zzk() || !((Boolean) zzbdb.zzb.zze()).booleanValue()) {
                return null;
            }
            return zzO(str, map);
        } catch (Exception | NoClassDefFoundError e2) {
            zzt.zzo().zzu(e2, "AdWebViewClient.interceptRequest");
            return zzN();
        }
    }

    public final zzb zzd() {
        return this.zzu;
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzw && this.zzy <= 0) || this.zzx || this.zzo)) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && this.zzc.zzm() != null) {
                zzbbw.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzcgk zzcgk = this.zzi;
            boolean z2 = false;
            if (!this.zzx && !this.zzo) {
                z2 = true;
            }
            zzcgk.zza(z2);
            this.zzi = null;
        }
        this.zzc.zzac();
    }

    public final void zzh() {
        zzbws zzbws = this.zza;
        if (zzbws != null) {
            zzbws.zze();
            this.zza = null;
        }
        zzQ();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzp = false;
            this.zzq = false;
            this.zzs = null;
            this.zzu = null;
            this.zzt = null;
            zzbqq zzbqq = this.zzv;
            if (zzbqq != null) {
                zzbqq.zza(true);
                this.zzv = null;
            }
        }
    }

    public final void zzi(boolean z2) {
        this.zzz = z2;
    }

    public final void zzj(Uri uri) {
        String str;
        String path = uri.getPath();
        List list = (List) this.zze.get(path);
        if (path == null || list == null) {
            zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzgz)).booleanValue() && zzt.zzo().zzf() != null) {
                if (path == null || path.length() < 2) {
                    str = "null";
                } else {
                    str = path.substring(1);
                }
                zzcae.zza.execute(new zzcfa(str));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfq)).booleanValue() && this.zzA.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzba.zzc().zzb(zzbbm.zzfs)).intValue()) {
                zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzfwc.zzq(zzt.zzp().zzb(uri), new zzcfe(this, list, path, uri), zzcae.zze);
                return;
            }
        }
        zzt.zzp();
        zzP(zzs.zzL(uri), list, path);
    }

    public final void zzk() {
        zzawz zzawz = this.zzd;
        if (zzawz != null) {
            zzawz.zzc(10005);
        }
        this.zzx = true;
        zzg();
        this.zzc.destroy();
    }

    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzy++;
        zzg();
    }

    public final void zzm() {
        this.zzy--;
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zzc.zzaa();
        zzl zzL = this.zzc.zzL();
        if (zzL != null) {
            zzL.zzz();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(View view, zzbws zzbws, int i2) {
        zzR(view, zzbws, i2 - 1);
    }

    public final void zzp(int i2, int i3, boolean z2) {
        zzbqv zzbqv = this.zzt;
        if (zzbqv != null) {
            zzbqv.zzb(i2, i3);
        }
        zzbqq zzbqq = this.zzv;
        if (zzbqq != null) {
            zzbqq.zzc(i2, i3, false);
        }
    }

    public final void zzq() {
        zzbws zzbws = this.zza;
        if (zzbws != null) {
            WebView zzG = this.zzc.zzG();
            if (ViewCompat.U(zzG)) {
                zzR(zzG, zzbws, 10);
                return;
            }
            zzQ();
            zzcfd zzcfd = new zzcfd(this, zzbws);
            this.zzC = zzcfd;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcfd);
        }
    }

    public final void zzr() {
        zzdcu zzdcu = this.zzm;
        if (zzdcu != null) {
            zzdcu.zzr();
        }
    }

    public final void zzs() {
        zzdcu zzdcu = this.zzm;
        if (zzdcu != null) {
            zzdcu.zzs();
        }
    }

    public final void zzt(zzc zzc2, boolean z2) {
        zza zza2;
        zzo zzo2;
        zzdcu zzdcu;
        boolean zzaA = this.zzc.zzaA();
        boolean zzT = zzT(zzaA, this.zzc);
        boolean z3 = true;
        if (!zzT && z2) {
            z3 = false;
        }
        if (zzT) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        if (zzaA) {
            zzo2 = null;
        } else {
            zzo2 = this.zzh;
        }
        zzz zzz2 = this.zzs;
        zzbzx zzn2 = this.zzc.zzn();
        zzcez zzcez = this.zzc;
        if (z3) {
            zzdcu = null;
        } else {
            zzdcu = this.zzm;
        }
        zzw(new AdOverlayInfoParcel(zzc2, zza2, zzo2, zzz2, zzn2, zzcez, zzdcu));
    }

    public final void zzu(zzbr zzbr, String str, String str2, int i2) {
        zzcez zzcez = this.zzc;
        zzw(new AdOverlayInfoParcel(zzcez, zzcez.zzn(), zzbr, str, str2, 14, (zzbrm) this.zzB));
    }

    public final void zzv(boolean z2, int i2, boolean z3) {
        zza zza2;
        zzdcu zzdcu;
        zzebl zzebl;
        boolean zzT = zzT(this.zzc.zzaA(), this.zzc);
        boolean z4 = true;
        if (!zzT && z3) {
            z4 = false;
        }
        if (zzT) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        zzo zzo2 = this.zzh;
        zzz zzz2 = this.zzs;
        zzcez zzcez = this.zzc;
        zzbzx zzn2 = zzcez.zzn();
        if (z4) {
            zzdcu = null;
        } else {
            zzdcu = this.zzm;
        }
        if (zzS(this.zzc)) {
            zzebl = this.zzB;
        } else {
            zzebl = null;
        }
        zzw(new AdOverlayInfoParcel(zza2, zzo2, zzz2, zzcez, z2, i2, zzn2, zzdcu, zzebl));
    }

    public final void zzw(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z2;
        zzc zzc2;
        zzbqq zzbqq = this.zzv;
        if (zzbqq != null) {
            z2 = zzbqq.zze();
        } else {
            z2 = false;
        }
        zzt.zzi();
        zzm.zza(this.zzc.getContext(), adOverlayInfoParcel, !z2);
        zzbws zzbws = this.zza;
        if (zzbws != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzc2 = adOverlayInfoParcel.zza) != null) {
                str = zzc2.zzb;
            }
            zzbws.zzh(str);
        }
    }

    public final void zzx(boolean z2, int i2, String str, boolean z3) {
        zza zza2;
        zzcff zzcff;
        zzdcu zzdcu;
        zzebl zzebl;
        boolean zzaA = this.zzc.zzaA();
        boolean zzT = zzT(zzaA, this.zzc);
        boolean z4 = true;
        if (!zzT && z3) {
            z4 = false;
        }
        if (zzT) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        if (zzaA) {
            zzcff = null;
        } else {
            zzcff = new zzcff(this.zzc, this.zzh);
        }
        zzbhc zzbhc = this.zzk;
        zzbhe zzbhe = this.zzl;
        zzz zzz2 = this.zzs;
        zzcez zzcez = this.zzc;
        zzbzx zzn2 = zzcez.zzn();
        if (z4) {
            zzdcu = null;
        } else {
            zzdcu = this.zzm;
        }
        if (zzS(this.zzc)) {
            zzebl = this.zzB;
        } else {
            zzebl = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zza2, zzcff, zzbhc, zzbhe, zzz2, zzcez, z2, i2, str, zzn2, zzdcu, zzebl);
        zzw(adOverlayInfoParcel);
    }

    public final void zzy(boolean z2, int i2, String str, String str2, boolean z3) {
        zza zza2;
        zzcff zzcff;
        zzdcu zzdcu;
        zzebl zzebl;
        boolean zzaA = this.zzc.zzaA();
        boolean zzT = zzT(zzaA, this.zzc);
        boolean z4 = true;
        if (!zzT && z3) {
            z4 = false;
        }
        if (zzT) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        if (zzaA) {
            zzcff = null;
        } else {
            zzcff = new zzcff(this.zzc, this.zzh);
        }
        zzbhc zzbhc = this.zzk;
        zzbhe zzbhe = this.zzl;
        zzz zzz2 = this.zzs;
        zzcez zzcez = this.zzc;
        zzbzx zzn2 = zzcez.zzn();
        if (z4) {
            zzdcu = null;
        } else {
            zzdcu = this.zzm;
        }
        if (zzS(this.zzc)) {
            zzebl = this.zzB;
        } else {
            zzebl = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zza2, (zzo) zzcff, zzbhc, zzbhe, zzz2, zzcez, z2, i2, str, str2, zzn2, zzdcu, (zzbrm) zzebl);
        zzw(adOverlayInfoParcel);
    }

    public final void zzz(String str, zzbij zzbij) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzbij);
        }
    }
}
