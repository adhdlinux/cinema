package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class zzdhw extends zzbeu implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdiw {
    public static final zzfsc zza = zzfsc.zzo("2011", "1009", "3010");
    private final String zzb;
    private Map zzc = new HashMap();
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzfwn zzf;
    private View zzg;
    private final int zzh;
    private zzdgv zzi;
    private zzaub zzj;
    private IObjectWrapper zzk = null;
    private zzbeo zzl;
    private boolean zzm;
    private boolean zzn = false;
    private GestureDetector zzo;

    public zzdhw(FrameLayout frameLayout, FrameLayout frameLayout2, int i2) {
        String str;
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        this.zzh = ModuleDescriptor.MODULE_VERSION;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            str = "3012";
        }
        this.zzb = str;
        zzt.zzx();
        zzcar.zza(frameLayout, this);
        zzt.zzx();
        zzcar.zzb(frameLayout, this);
        this.zzf = zzcae.zze;
        this.zzj = new zzaub(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzt(String str) {
        DisplayMetrics displayMetrics;
        FrameLayout frameLayout = new FrameLayout(this.zze.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.zze.getContext();
        frameLayout.setClickable(false);
        frameLayout.setFocusable(false);
        if (!TextUtils.isEmpty(str)) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Resources resources = context.getResources();
            if (!(resources == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                try {
                    byte[] decode = Base64.decode(str, 0);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    bitmapDrawable.setTileModeXY(tileMode, tileMode);
                    frameLayout.setBackground(bitmapDrawable);
                } catch (IllegalArgumentException e2) {
                    zzbzr.zzk("Encountered invalid base64 watermark.", e2);
                }
            }
        }
        this.zze.addView(frameLayout);
    }

    private final synchronized void zzu() {
        this.zzf.execute(new zzdhv(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzv() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjS     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzdgv r0 = r4.zzi     // Catch:{ all -> 0x0033 }
            int r0 = r0.zza()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            android.view.GestureDetector r0 = new android.view.GestureDetector     // Catch:{ all -> 0x0033 }
            android.widget.FrameLayout r1 = r4.zzd     // Catch:{ all -> 0x0033 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzdic r2 = new com.google.android.gms.internal.ads.zzdic     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzdgv r3 = r4.zzi     // Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0033 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0033 }
            r4.zzo = r0     // Catch:{ all -> 0x0033 }
            monitor-exit(r4)
            return
        L_0x0031:
            monitor-exit(r4)
            return
        L_0x0033:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdhw.zzv():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onClick(android.view.View r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.gms.internal.ads.zzdgv r0 = r7.zzi     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            boolean r0 = r0.zzT()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzdgv r0 = r7.zzi     // Catch:{ all -> 0x0025 }
            r0.zzs()     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdgv r1 = r7.zzi     // Catch:{ all -> 0x0025 }
            android.widget.FrameLayout r3 = r7.zzd     // Catch:{ all -> 0x0025 }
            java.util.Map r4 = r7.zzl()     // Catch:{ all -> 0x0025 }
            java.util.Map r5 = r7.zzm()     // Catch:{ all -> 0x0025 }
            r6 = 0
            r2 = r8
            r1.zzC(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0025 }
            monitor-exit(r7)
            return
        L_0x0023:
            monitor-exit(r7)
            return
        L_0x0025:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdhw.onClick(android.view.View):void");
    }

    public final synchronized void onGlobalLayout() {
        zzdgv zzdgv = this.zzi;
        if (zzdgv != null) {
            FrameLayout frameLayout = this.zzd;
            zzdgv.zzA(frameLayout, zzl(), zzm(), zzdgv.zzW(frameLayout));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdgv zzdgv = this.zzi;
        if (zzdgv != null) {
            FrameLayout frameLayout = this.zzd;
            zzdgv.zzA(frameLayout, zzl(), zzm(), zzdgv.zzW(frameLayout));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzdgv r0 = r3.zzi     // Catch:{ all -> 0x0032 }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            android.widget.FrameLayout r2 = r3.zzd     // Catch:{ all -> 0x0032 }
            r0.zzJ(r4, r5, r2)     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzjS     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0032 }
            java.lang.Object r4 = r0.zzb(r4)     // Catch:{ all -> 0x0032 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0032 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0032 }
            if (r4 == 0) goto L_0x0030
            android.view.GestureDetector r4 = r3.zzo     // Catch:{ all -> 0x0032 }
            if (r4 == 0) goto L_0x0030
            com.google.android.gms.internal.ads.zzdgv r4 = r3.zzi     // Catch:{ all -> 0x0032 }
            int r4 = r4.zza()     // Catch:{ all -> 0x0032 }
            if (r4 == 0) goto L_0x0030
            android.view.GestureDetector r4 = r3.zzo     // Catch:{ all -> 0x0032 }
            r4.onTouchEvent(r5)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r3)
            return r1
        L_0x0032:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdhw.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final synchronized IObjectWrapper zzb(String str) {
        return ObjectWrapper.wrap(zzg(str));
    }

    public final synchronized void zzbs(String str, IObjectWrapper iObjectWrapper) {
        zzq(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzbt(IObjectWrapper iObjectWrapper) {
        this.zzi.zzL((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzbu(zzbeo zzbeo) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbeo;
            zzdgv zzdgv = this.zzi;
            if (zzdgv != null) {
                zzdgv.zzc().zzb(zzbeo);
            }
        }
    }

    public final synchronized void zzbv(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            this.zzk = iObjectWrapper;
        }
    }

    public final synchronized void zzbw(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof zzdgv)) {
                zzbzr.zzj("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzdgv zzdgv = this.zzi;
            if (zzdgv != null) {
                zzdgv.zzR(this);
            }
            zzu();
            zzdgv zzdgv2 = (zzdgv) unwrap;
            this.zzi = zzdgv2;
            zzdgv2.zzQ(this);
            this.zzi.zzI(this.zzd);
            this.zzi.zzr(this.zze);
            if (this.zzm) {
                this.zzi.zzc().zzb(this.zzl);
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdF)).booleanValue() && !TextUtils.isEmpty(this.zzi.zzg())) {
                zzt(this.zzi.zzg());
            }
            zzv();
        }
    }

    public final synchronized void zzc() {
        if (!this.zzn) {
            zzdgv zzdgv = this.zzi;
            if (zzdgv != null) {
                zzdgv.zzR(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i2) {
    }

    public final /* synthetic */ View zzf() {
        return this.zzd;
    }

    public final synchronized View zzg(String str) {
        if (this.zzn) {
            return null;
        }
        WeakReference weakReference = (WeakReference) this.zzc.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final FrameLayout zzh() {
        return this.zze;
    }

    public final zzaub zzi() {
        return this.zzj;
    }

    public final IObjectWrapper zzj() {
        return this.zzk;
    }

    public final synchronized String zzk() {
        return this.zzb;
    }

    public final synchronized Map zzl() {
        return this.zzc;
    }

    public final synchronized Map zzm() {
        return this.zzc;
    }

    public final synchronized Map zzn() {
        return null;
    }

    public final synchronized JSONObject zzo() {
        zzdgv zzdgv = this.zzi;
        if (zzdgv == null) {
            return null;
        }
        return zzdgv.zzi(this.zzd, zzl(), zzm());
    }

    public final synchronized JSONObject zzp() {
        zzdgv zzdgv = this.zzi;
        if (zzdgv == null) {
            return null;
        }
        return zzdgv.zzk(this.zzd, zzl(), zzm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzn     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map r3 = r1.zzc     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map r4 = r1.zzc     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzh     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbx.zzi(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdhw.zzq(java.lang.String, android.view.View, boolean):void");
    }

    public final FrameLayout zzr() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs() {
        if (this.zzg == null) {
            View view = new View(this.zzd.getContext());
            this.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
