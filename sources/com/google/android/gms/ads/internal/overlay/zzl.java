package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbce;
import com.google.android.gms.internal.ads.zzbco;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhe;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbiu;
import com.google.android.gms.internal.ads.zzbja;
import com.google.android.gms.internal.ads.zzbjb;
import com.google.android.gms.internal.ads.zzbqw;
import com.google.android.gms.internal.ads.zzbqx;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgo;
import com.google.android.gms.internal.ads.zzdcu;
import com.google.android.gms.internal.ads.zzdqa;
import com.google.android.gms.internal.ads.zzeba;
import com.google.android.gms.internal.ads.zzebl;
import com.google.android.gms.internal.ads.zzebm;
import com.google.android.gms.internal.ads.zzebn;
import com.google.android.gms.internal.ads.zzezn;
import com.google.android.gms.internal.ads.zzezq;
import com.google.android.gms.internal.ads.zzfev;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfgw;
import com.google.android.gms.internal.ads.zzfmd;
import java.util.Collections;
import okhttp3.internal.http2.Http2Connection;

public class zzl extends zzbrs implements zzad {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcez zzd;
    zzh zze;
    zzr zzf;
    boolean zzg = false;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    boolean zzj = false;
    boolean zzk = false;
    zzg zzl;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private Runnable zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs = false;
    private boolean zzt = false;
    private boolean zzu = true;

    public zzl(Activity activity) {
        this.zzb = activity;
    }

    private final void zzI(Configuration configuration) {
        boolean z2;
        int i2;
        zzj zzj2;
        zzj zzj3;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        boolean z3 = true;
        boolean z4 = false;
        if (adOverlayInfoParcel == null || (zzj3 = adOverlayInfoParcel.zzo) == null || !zzj3.zzb) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean zze2 = zzt.zzq().zze(this.zzb, configuration);
        if ((!this.zzk || z2) && !zze2) {
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (!(adOverlayInfoParcel2 == null || (zzj2 = adOverlayInfoParcel2.zzo) == null || !zzj2.zzg)) {
                z4 = true;
            }
        } else {
            z3 = false;
        }
        Window window = this.zzb.getWindow();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbb)).booleanValue()) {
            View decorView = window.getDecorView();
            if (!z3) {
                i2 = UserVerificationMethods.USER_VERIFY_HANDPRINT;
            } else if (z4) {
                i2 = 5894;
            } else {
                i2 = 5380;
            }
            decorView.setSystemUiVisibility(i2);
        } else if (z3) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (z4) {
                window.getDecorView().setSystemUiVisibility(4098);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }

    private static final void zzJ(zzfgw zzfgw, View view) {
        if (zzfgw != null && view != null) {
            zzt.zzA().zzh(zzfgw, view);
        }
    }

    public final void zzA(int i2) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.zzc().zzb(zzbbm.zzfL)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.zzc().zzb(zzbbm.zzfM)).intValue()) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= ((Integer) zzba.zzc().zzb(zzbbm.zzfN)).intValue()) {
                    if (i3 <= ((Integer) zzba.zzc().zzb(zzbbm.zzfO)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i2);
        } catch (Throwable th) {
            zzt.zzo().zzt(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z2) {
        if (z2) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(-16777216);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzr = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* access modifiers changed from: protected */
    public final void zzD(boolean z2) throws zzf {
        zzcgm zzcgm;
        boolean z3;
        zzcgo zzcgo;
        String str;
        zza zza2;
        if (!this.zzr) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window != null) {
            zzcez zzcez = this.zzc.zzd;
            zzb zzb2 = null;
            if (zzcez != null) {
                zzcgm = zzcez.zzN();
            } else {
                zzcgm = null;
            }
            boolean z4 = false;
            if (zzcgm == null || !zzcgm.zzK()) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.zzm = false;
            if (z3) {
                int i2 = this.zzc.zzj;
                if (i2 == 6) {
                    if (this.zzb.getResources().getConfiguration().orientation == 1) {
                        z4 = true;
                    }
                    this.zzm = z4;
                } else if (i2 == 7) {
                    if (this.zzb.getResources().getConfiguration().orientation == 2) {
                        z4 = true;
                    }
                    this.zzm = z4;
                }
            }
            zzbzr.zze("Delay onShow to next orientation change: " + z4);
            zzA(this.zzc.zzj);
            window.setFlags(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            zzbzr.zze("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzk) {
                this.zzl.setBackgroundColor(-16777216);
            } else {
                this.zzl.setBackgroundColor(zza);
            }
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            if (z2) {
                try {
                    zzt.zzz();
                    Activity activity = this.zzb;
                    zzcez zzcez2 = this.zzc.zzd;
                    if (zzcez2 != null) {
                        zzcgo = zzcez2.zzO();
                    } else {
                        zzcgo = null;
                    }
                    zzcez zzcez3 = this.zzc.zzd;
                    if (zzcez3 != null) {
                        str = zzcez3.zzS();
                    } else {
                        str = null;
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                    zzbzx zzbzx = adOverlayInfoParcel.zzm;
                    zzcez zzcez4 = adOverlayInfoParcel.zzd;
                    if (zzcez4 != null) {
                        zza2 = zzcez4.zzj();
                    } else {
                        zza2 = null;
                    }
                    zzcez zza3 = zzcfl.zza(activity, zzcgo, str, true, z3, (zzaqs) null, (zzbco) null, zzbzx, (zzbce) null, (com.google.android.gms.ads.internal.zzl) null, zza2, zzawz.zza(), (zzezn) null, (zzezq) null, (zzebl) null);
                    this.zzd = zza3;
                    zzcgm zzN = zza3.zzN();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                    zzbhc zzbhc = adOverlayInfoParcel2.zzp;
                    zzbhe zzbhe = adOverlayInfoParcel2.zze;
                    zzz zzz = adOverlayInfoParcel2.zzi;
                    zzcez zzcez5 = adOverlayInfoParcel2.zzd;
                    if (zzcez5 != null) {
                        zzb2 = zzcez5.zzN().zzd();
                    }
                    zzN.zzM((com.google.android.gms.ads.internal.client.zza) null, zzbhc, (zzo) null, zzbhe, zzz, true, (zzbil) null, zzb2, (zzbqx) null, (zzbws) null, (zzeba) null, (zzfgr) null, (zzdqa) null, (zzfev) null, (zzbjb) null, (zzdcu) null, (zzbja) null, (zzbiu) null);
                    this.zzd.zzN().zzA(new zzd(this));
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                    String str2 = adOverlayInfoParcel3.zzl;
                    if (str2 != null) {
                        this.zzd.loadUrl(str2);
                    } else {
                        String str3 = adOverlayInfoParcel3.zzh;
                        if (str3 != null) {
                            this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str3, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8", (String) null);
                        } else {
                            throw new zzf("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzcez zzcez6 = this.zzc.zzd;
                    if (zzcez6 != null) {
                        zzcez6.zzar(this);
                    }
                } catch (Exception e2) {
                    zzbzr.zzh("Error obtaining webview.", e2);
                    throw new zzf("Could not obtain webview for the overlay.", e2);
                }
            } else {
                zzcez zzcez7 = this.zzc.zzd;
                this.zzd = zzcez7;
                zzcez7.zzak(this.zzb);
            }
            this.zzd.zzaf(this);
            zzcez zzcez8 = this.zzc.zzd;
            if (zzcez8 != null) {
                zzJ(zzcez8.zzQ(), this.zzl);
            }
            if (this.zzc.zzk != 5) {
                ViewParent parent = this.zzd.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.zzd.zzF());
                }
                if (this.zzk) {
                    this.zzd.zzaj();
                }
                this.zzl.addView(this.zzd.zzF(), -1, -1);
            }
            if (!z2 && !this.zzm) {
                zze();
            }
            if (this.zzc.zzk != 5) {
                zzw(z3);
                if (this.zzd.zzaw()) {
                    zzy(z3, true);
                    return;
                }
                return;
            }
            zzebm zzf2 = zzebn.zzf();
            zzf2.zza(this.zzb);
            zzf2.zzb(this);
            zzf2.zze(this.zzc.zzr);
            zzf2.zzc(this.zzc.zzq);
            zzf2.zzd(this.zzc.zzs);
            try {
                zzf(zzf2.zzf());
            } catch (RemoteException | zzf e3) {
                throw new zzf(e3.getMessage(), e3);
            }
        } else {
            throw new zzf("Invalid activity, no window available.");
        }
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzq = true;
            Runnable runnable = this.zzp;
            if (runnable != null) {
                zzfmd zzfmd = zzs.zza;
                zzfmd.removeCallbacks(runnable);
                zzfmd.post(this.zzp);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzo zzo2;
        if (this.zzb.isFinishing() && !this.zzs) {
            this.zzs = true;
            zzcez zzcez = this.zzd;
            if (zzcez != null) {
                zzcez.zzW(this.zzn - 1);
                synchronized (this.zzo) {
                    if (!this.zzq && this.zzd.zzax()) {
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeA)).booleanValue() && !this.zzt && (adOverlayInfoParcel = this.zzc) != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
                            zzo2.zzby();
                        }
                        zze zze2 = new zze(this);
                        this.zzp = zze2;
                        zzs.zza.postDelayed(zze2, ((Long) zzba.zzc().zzb(zzbbm.zzaU)).longValue());
                        return;
                    }
                }
            }
            zzc();
        }
    }

    public final boolean zzG() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzaC = this.zzd.zzaC();
            if (!zzaC) {
                this.zzd.zzd("onbackblocked", Collections.emptyMap());
            }
            return zzaC;
        }
        this.zzd.goBack();
        return false;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzcez zzcez;
        zzo zzo2;
        if (!this.zzt) {
            this.zzt = true;
            zzcez zzcez2 = this.zzd;
            if (zzcez2 != null) {
                this.zzl.removeView(zzcez2.zzF());
                zzh zzh2 = this.zze;
                if (zzh2 != null) {
                    this.zzd.zzak(zzh2.zzd);
                    this.zzd.zzan(false);
                    ViewGroup viewGroup = this.zze.zzc;
                    View zzF = this.zzd.zzF();
                    zzh zzh3 = this.zze;
                    viewGroup.addView(zzF, zzh3.zza, zzh3.zzb);
                    this.zze = null;
                } else if (this.zzb.getApplicationContext() != null) {
                    this.zzd.zzak(this.zzb.getApplicationContext());
                }
                this.zzd = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
                zzo2.zzf(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzcez = adOverlayInfoParcel2.zzd) != null) {
                zzJ(zzcez.zzQ(), this.zzc.zzd.zzF());
            }
        }
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    /* access modifiers changed from: protected */
    public final void zze() {
        this.zzd.zzX();
    }

    public final void zzf(zzebn zzebn) throws zzf, RemoteException {
        zzbrm zzbrm;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbrm = adOverlayInfoParcel.zzw) == null) {
            throw new zzf("noioou");
        }
        zzbrm.zzg(ObjectWrapper.wrap(zzebn));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzh(int i2, int i3, Intent intent) {
    }

    public final void zzi() {
        this.zzn = 1;
    }

    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzI((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075 A[Catch:{ zzf -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8 A[Catch:{ zzf -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ed A[Catch:{ zzf -> 0x00f9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzl(android.os.Bundle r9) {
        /*
            r8 = this;
            boolean r0 = r8.zzr
            r1 = 1
            if (r0 != 0) goto L_0x000a
            android.app.Activity r0 = r8.zzb
            r0.requestWindowFeature(r1)
        L_0x000a:
            r0 = 0
            if (r9 == 0) goto L_0x0017
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r9.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0017
            r2 = 1
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            r8.zzj = r2
            r2 = 4
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzf -> 0x00f9 }
            r8.zzc = r3     // Catch:{ zzf -> 0x00f9 }
            if (r3 == 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzbzx r3 = r3.zzm     // Catch:{ zzf -> 0x00f9 }
            int r3 = r3.zzc     // Catch:{ zzf -> 0x00f9 }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x0034
            r8.zzn = r2     // Catch:{ zzf -> 0x00f9 }
        L_0x0034:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f9 }
            if (r3 == 0) goto L_0x004a
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzf -> 0x00f9 }
            r8.zzu = r3     // Catch:{ zzf -> 0x00f9 }
        L_0x004a:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.zzj r4 = r3.zzo     // Catch:{ zzf -> 0x00f9 }
            r5 = 5
            if (r4 == 0) goto L_0x0058
            boolean r6 = r4.zza     // Catch:{ zzf -> 0x00f9 }
            r8.zzk = r6     // Catch:{ zzf -> 0x00f9 }
            if (r6 == 0) goto L_0x0073
            goto L_0x005e
        L_0x0058:
            int r6 = r3.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r6 != r5) goto L_0x0071
            r8.zzk = r1     // Catch:{ zzf -> 0x00f9 }
        L_0x005e:
            int r3 = r3.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r3 == r5) goto L_0x0073
            int r3 = r4.zzf     // Catch:{ zzf -> 0x00f9 }
            r4 = -1
            if (r3 == r4) goto L_0x0073
            com.google.android.gms.ads.internal.overlay.zzk r3 = new com.google.android.gms.ads.internal.overlay.zzk     // Catch:{ zzf -> 0x00f9 }
            r4 = 0
            r3.<init>(r8, r4)     // Catch:{ zzf -> 0x00f9 }
            r3.zzb()     // Catch:{ zzf -> 0x00f9 }
            goto L_0x0073
        L_0x0071:
            r8.zzk = r0     // Catch:{ zzf -> 0x00f9 }
        L_0x0073:
            if (r9 != 0) goto L_0x00a1
            boolean r9 = r8.zzu     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x008b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzcvt r9 = r9.zzu     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x0082
            r9.zze()     // Catch:{ zzf -> 0x00f9 }
        L_0x0082:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.zzo r9 = r9.zzc     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x008b
            r9.zzb()     // Catch:{ zzf -> 0x00f9 }
        L_0x008b:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            int r3 = r9.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r3 == r1) goto L_0x00a1
            com.google.android.gms.ads.internal.client.zza r9 = r9.zzb     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x0098
            r9.onAdClicked()     // Catch:{ zzf -> 0x00f9 }
        L_0x0098:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzdcu r9 = r9.zzv     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x00a1
            r9.zzr()     // Catch:{ zzf -> 0x00f9 }
        L_0x00a1:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzf -> 0x00f9 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r6 = r4.zzn     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzbzx r7 = r4.zzm     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r7 = r7.zza     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r4 = r4.zzt     // Catch:{ zzf -> 0x00f9 }
            r9.<init>(r3, r6, r7, r4)     // Catch:{ zzf -> 0x00f9 }
            r8.zzl = r9     // Catch:{ zzf -> 0x00f9 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9.setId(r3)     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.util.zzaa r9 = com.google.android.gms.ads.internal.zzt.zzq()     // Catch:{ zzf -> 0x00f9 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            r9.zzl(r3)     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            int r3 = r9.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r3 == r1) goto L_0x00ed
            r4 = 2
            if (r3 == r4) goto L_0x00e0
            r9 = 3
            if (r3 == r9) goto L_0x00dc
            if (r3 != r5) goto L_0x00d4
            r8.zzD(r0)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00d4:
            com.google.android.gms.ads.internal.overlay.zzf r9 = new com.google.android.gms.ads.internal.overlay.zzf     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r0 = "Could not determine ad overlay type."
            r9.<init>(r0)     // Catch:{ zzf -> 0x00f9 }
            throw r9     // Catch:{ zzf -> 0x00f9 }
        L_0x00dc:
            r8.zzD(r1)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00e0:
            com.google.android.gms.ads.internal.overlay.zzh r1 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzcez r9 = r9.zzd     // Catch:{ zzf -> 0x00f9 }
            r1.<init>(r9)     // Catch:{ zzf -> 0x00f9 }
            r8.zze = r1     // Catch:{ zzf -> 0x00f9 }
            r8.zzD(r0)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00ed:
            r8.zzD(r0)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00f1:
            com.google.android.gms.ads.internal.overlay.zzf r9 = new com.google.android.gms.ads.internal.overlay.zzf     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r0 = "Could not get info for ad overlay."
            r9.<init>(r0)     // Catch:{ zzf -> 0x00f9 }
            throw r9     // Catch:{ zzf -> 0x00f9 }
        L_0x00f9:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.google.android.gms.internal.ads.zzbzr.zzj(r9)
            r8.zzn = r2
            android.app.Activity r9 = r8.zzb
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzl(android.os.Bundle):void");
    }

    public final void zzm() {
        zzcez zzcez = this.zzd;
        if (zzcez != null) {
            try {
                this.zzl.removeView(zzcez.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    public final void zzo() {
        zzo zzo2;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzbo();
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzp(int i2, String[] strArr, int[] iArr) {
        zzl zzl2;
        if (i2 == 12345) {
            zzebm zzf2 = zzebn.zzf();
            zzf2.zza(this.zzb);
            if (this.zzc.zzk == 5) {
                zzl2 = this;
            } else {
                zzl2 = null;
            }
            zzf2.zzb(zzl2);
            zzf2.zze(this.zzc.zzr);
            try {
                this.zzc.zzw.zzf(strArr, iArr, ObjectWrapper.wrap(zzf2.zzf()));
            } catch (RemoteException unused) {
            }
        }
    }

    public final void zzq() {
    }

    public final void zzr() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzbF();
        }
        zzI(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue()) {
            zzcez zzcez = this.zzd;
            if (zzcez == null || zzcez.zzaz()) {
                zzbzr.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzt() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue()) {
            zzcez zzcez = this.zzd;
            if (zzcez == null || zzcez.zzaz()) {
                zzbzr.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzu() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeC)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzv() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
            zzo2.zze();
        }
    }

    public final void zzw(boolean z2) {
        boolean z3;
        int i2;
        int i3;
        int intValue = ((Integer) zzba.zzc().zzb(zzbbm.zzeF)).intValue();
        int i4 = 0;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaX)).booleanValue() || z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzq zzq2 = new zzq();
        zzq2.zzd = 50;
        if (true != z3) {
            i2 = 0;
        } else {
            i2 = intValue;
        }
        zzq2.zza = i2;
        if (true != z3) {
            i4 = intValue;
        }
        zzq2.zzb = i4;
        zzq2.zzc = intValue;
        this.zzf = new zzr(this.zzb, zzq2, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        if (true != z3) {
            i3 = 9;
        } else {
            i3 = 11;
        }
        layoutParams.addRule(i3);
        zzy(z2, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    public final void zzx() {
        this.zzr = true;
    }

    public final void zzy(boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzj zzj2;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzj zzj3;
        boolean z6 = true;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzaV)).booleanValue() || (adOverlayInfoParcel2 = this.zzc) == null || (zzj3 = adOverlayInfoParcel2.zzo) == null || !zzj3.zzh) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzaW)).booleanValue() || (adOverlayInfoParcel = this.zzc) == null || (zzj2 = adOverlayInfoParcel.zzo) == null || !zzj2.zzi) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z2 && z3 && z4 && !z5) {
            new zzbqw(this.zzd, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzr zzr2 = this.zzf;
        if (zzr2 != null) {
            if (!z5 && (!z3 || z4)) {
                z6 = false;
            }
            zzr2.zzb(z6);
        }
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }
}
