package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

public final class zzasa implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final Handler zza = new Handler(Looper.getMainLooper());
    private final Context zzb;
    private Application zzc;
    private final PowerManager zzd;
    private final KeyguardManager zze;
    private BroadcastReceiver zzf;
    private final zzarm zzg;
    private WeakReference zzh;
    private WeakReference zzi;
    private zzari zzj;
    private byte zzk = -1;
    private int zzl = -1;
    private long zzm = -3;

    public zzasa(Context context, zzarm zzarm) {
        Context applicationContext = context.getApplicationContext();
        this.zzb = applicationContext;
        this.zzg = zzarm;
        this.zzd = (PowerManager) applicationContext.getSystemService("power");
        this.zze = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.zzc = application;
            this.zzj = new zzari(application, this);
        }
        zzd((View) null);
    }

    private final void zze(Activity activity, int i2) {
        Window window;
        if (this.zzi != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View zzb2 = zzb();
            if (zzb2 != null && peekDecorView != null && zzb2.getRootView() == peekDecorView.getRootView()) {
                this.zzl = i2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007f, code lost:
        if ((r8.flags & com.google.ar.core.ImageMetadata.LENS_APERTURE) != 0) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r9 = this;
            java.lang.ref.WeakReference r0 = r9.zzi
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.View r0 = r9.zzb()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L_0x0013
            r9.zzm = r2
            r9.zzk = r1
            return
        L_0x0013:
            int r4 = r0.getVisibility()
            r5 = 0
            if (r4 == 0) goto L_0x001c
            r4 = 1
            goto L_0x001d
        L_0x001c:
            r4 = 0
        L_0x001d:
            boolean r6 = r0.isShown()
            if (r6 != 0) goto L_0x0025
            r4 = r4 | 2
        L_0x0025:
            android.os.PowerManager r6 = r9.zzd
            if (r6 == 0) goto L_0x0031
            boolean r6 = r6.isScreenOn()
            if (r6 != 0) goto L_0x0031
            r4 = r4 | 4
        L_0x0031:
            com.google.android.gms.internal.ads.zzarm r6 = r9.zzg
            boolean r6 = r6.zza()
            if (r6 != 0) goto L_0x0083
            android.app.KeyguardManager r6 = r9.zze
            if (r6 == 0) goto L_0x0081
            boolean r6 = r6.inKeyguardRestrictedInputMode()
            if (r6 == 0) goto L_0x0081
            int r6 = com.google.android.gms.internal.ads.zzarw.zza
            android.view.View r6 = r0.getRootView()
            if (r6 != 0) goto L_0x004c
            r6 = r0
        L_0x004c:
            android.content.Context r6 = r6.getContext()
        L_0x0050:
            boolean r7 = r6 instanceof android.content.ContextWrapper
            r8 = 0
            if (r7 == 0) goto L_0x0069
            r7 = 10
            if (r5 >= r7) goto L_0x0069
            boolean r7 = r6 instanceof android.app.Activity
            if (r7 == 0) goto L_0x0060
            android.app.Activity r6 = (android.app.Activity) r6
            goto L_0x006a
        L_0x0060:
            android.content.ContextWrapper r6 = (android.content.ContextWrapper) r6
            android.content.Context r6 = r6.getBaseContext()
            int r5 = r5 + 1
            goto L_0x0050
        L_0x0069:
            r6 = r8
        L_0x006a:
            if (r6 != 0) goto L_0x006d
            goto L_0x0081
        L_0x006d:
            android.view.Window r5 = r6.getWindow()
            if (r5 != 0) goto L_0x0074
            goto L_0x0078
        L_0x0074:
            android.view.WindowManager$LayoutParams r8 = r5.getAttributes()
        L_0x0078:
            if (r8 == 0) goto L_0x0081
            int r5 = r8.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0083
        L_0x0081:
            r4 = r4 | 8
        L_0x0083:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L_0x0090
            r4 = r4 | 16
        L_0x0090:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L_0x009d
            r4 = r4 | 32
        L_0x009d:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.zzl
            if (r5 == r1) goto L_0x00a6
            r0 = r5
        L_0x00a6:
            if (r0 == 0) goto L_0x00aa
            r4 = r4 | 64
        L_0x00aa:
            byte r0 = r9.zzk
            if (r0 == r4) goto L_0x00bd
            byte r0 = (byte) r4
            r9.zzk = r0
            if (r4 != 0) goto L_0x00b8
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L_0x00bb
        L_0x00b8:
            long r0 = (long) r4
            long r0 = r2 - r0
        L_0x00bb:
            r9.zzm = r0
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasa.zzf():void");
    }

    private final void zzg() {
        zza.post(new zzary(this));
    }

    private final void zzh(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzh = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzf == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzarz zzarz = new zzarz(this);
            this.zzf = zzarz;
            this.zzb.registerReceiver(zzarz, intentFilter);
        }
        Application application = this.zzc;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(3:4|(1:8)|9)|10|11|(1:13)|15|(3:17|18|19)|21|(3:23|24|26)(1:28)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ Exception -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[SYNTHETIC, Splitter:B:17:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003c A[SYNTHETIC, Splitter:B:23:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzi(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            java.lang.ref.WeakReference r1 = r3.zzh     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x001b
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x001b }
            android.view.ViewTreeObserver r1 = (android.view.ViewTreeObserver) r1     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.isAlive()     // Catch:{ Exception -> 0x001b }
            if (r2 == 0) goto L_0x0019
            r1.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x001b }
            r1.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x001b }
        L_0x0019:
            r3.zzh = r0     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            android.view.ViewTreeObserver r4 = r4.getViewTreeObserver()     // Catch:{ Exception -> 0x002c }
            boolean r1 = r4.isAlive()     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x002d
            r4.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x002c }
            r4.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x002c }
            goto L_0x002d
        L_0x002c:
        L_0x002d:
            android.content.BroadcastReceiver r4 = r3.zzf
            if (r4 == 0) goto L_0x0038
            android.content.Context r1 = r3.zzb     // Catch:{ Exception -> 0x0036 }
            r1.unregisterReceiver(r4)     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            r3.zzf = r0
        L_0x0038:
            android.app.Application r4 = r3.zzc
            if (r4 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzari r0 = r3.zzj     // Catch:{ Exception -> 0x0041 }
            r4.unregisterActivityLifecycleCallbacks(r0)     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasa.zzi(android.view.View):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zze(activity, 0);
        zzf();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzf();
    }

    public final void onActivityPaused(Activity activity) {
        zze(activity, 4);
        zzf();
    }

    public final void onActivityResumed(Activity activity) {
        zze(activity, 0);
        zzf();
        zzg();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzf();
    }

    public final void onActivityStarted(Activity activity) {
        zze(activity, 0);
        zzf();
    }

    public final void onActivityStopped(Activity activity) {
        zzf();
    }

    public final void onGlobalLayout() {
        zzf();
    }

    public final void onScrollChanged() {
        zzf();
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzl = -1;
        zzh(view);
        zzf();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzl = -1;
        zzf();
        zzg();
        zzi(view);
    }

    public final long zza() {
        if (this.zzm <= -2 && zzb() == null) {
            this.zzm = -3;
        }
        return this.zzm;
    }

    /* access modifiers changed from: package-private */
    public final View zzb() {
        WeakReference weakReference = this.zzi;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        long j2;
        View zzb2 = zzb();
        if (zzb2 != null) {
            zzb2.removeOnAttachStateChangeListener(this);
            zzi(zzb2);
        }
        this.zzi = new WeakReference(view);
        if (view != null) {
            if (!(view.getWindowToken() == null && view.getWindowVisibility() == 8)) {
                zzh(view);
            }
            view.addOnAttachStateChangeListener(this);
            j2 = -2;
        } else {
            j2 = -3;
        }
        this.zzm = j2;
    }
}
