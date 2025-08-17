package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import java.util.HashSet;

public final class zzaub implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) zzba.zzc().zzb(zzbbm.zzbi)).longValue();
    BroadcastReceiver zza;
    final WeakReference zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference zzi;
    private zzaun zzj;
    private final zzbz zzk = new zzbz(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzaub(Context context, View view) {
        View view2;
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.zzf = windowManager;
        this.zzg = (PowerManager) applicationContext.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.zze = application;
            this.zzj = new zzaun(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.zzb;
        if (weakReference != null) {
            view2 = (View) weakReference.get();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i2) {
        return (int) (((float) i2) / this.zzo.density);
    }

    private final void zzi(Activity activity, int i2) {
        Window window;
        if (this.zzb != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzb.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzm = i2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012f, code lost:
        if (r9 == 0) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0145, code lost:
        if (r9 == 0) goto L_0x0147;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01bb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(int r34) {
        /*
            r33 = this;
            r1 = r33
            r2 = r34
            java.util.HashSet r0 = r1.zzn
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference r0 = r1.zzb
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r0 = 2
            int[] r8 = new int[r0]
            int[] r9 = new int[r0]
            r11 = 1
            r12 = 0
            if (r3 == 0) goto L_0x0085
            boolean r13 = r3.getGlobalVisibleRect(r5)
            boolean r14 = r3.getLocalVisibleRect(r6)
            r3.getHitRect(r7)
            r3.getLocationOnScreen(r8)     // Catch:{ Exception -> 0x0048 }
            r3.getLocationInWindow(r9)     // Catch:{ Exception -> 0x0048 }
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            java.lang.String r15 = "Failure getting view location."
            com.google.android.gms.internal.ads.zzbzr.zzh(r15, r0)
        L_0x004e:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzeE
            com.google.android.gms.internal.ads.zzbbk r15 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r15.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0069
            r0 = r9[r12]
            r4.left = r0
            r0 = r9[r11]
            r4.top = r0
            goto L_0x0071
        L_0x0069:
            r0 = r8[r12]
            r4.left = r0
            r0 = r8[r11]
            r4.top = r0
        L_0x0071:
            int r0 = r4.left
            int r8 = r3.getWidth()
            int r0 = r0 + r8
            r4.right = r0
            int r0 = r4.top
            int r8 = r3.getHeight()
            int r0 = r0 + r8
            r4.bottom = r0
            r8 = r3
            goto L_0x0088
        L_0x0085:
            r8 = 0
            r13 = 0
            r14 = 0
        L_0x0088:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzbl
            com.google.android.gms.internal.ads.zzbbk r9 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r9.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00d9
            if (r8 == 0) goto L_0x00d9
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ca }
            r0.<init>()     // Catch:{ Exception -> 0x00ca }
            android.view.ViewParent r9 = r8.getParent()     // Catch:{ Exception -> 0x00ca }
        L_0x00a5:
            boolean r15 = r9 instanceof android.view.View     // Catch:{ Exception -> 0x00ca }
            if (r15 == 0) goto L_0x00dd
            r15 = r9
            android.view.View r15 = (android.view.View) r15     // Catch:{ Exception -> 0x00ca }
            android.graphics.Rect r12 = new android.graphics.Rect     // Catch:{ Exception -> 0x00ca }
            r12.<init>()     // Catch:{ Exception -> 0x00ca }
            boolean r17 = r15.isScrollContainer()     // Catch:{ Exception -> 0x00ca }
            if (r17 == 0) goto L_0x00c4
            boolean r15 = r15.getGlobalVisibleRect(r12)     // Catch:{ Exception -> 0x00ca }
            if (r15 == 0) goto L_0x00c4
            android.graphics.Rect r12 = r1.zza(r12)     // Catch:{ Exception -> 0x00ca }
            r0.add(r12)     // Catch:{ Exception -> 0x00ca }
        L_0x00c4:
            android.view.ViewParent r9 = r9.getParent()     // Catch:{ Exception -> 0x00ca }
            r12 = 0
            goto L_0x00a5
        L_0x00ca:
            r0 = move-exception
            java.lang.String r9 = "PositionWatcher.getParentScrollViewRects"
            com.google.android.gms.internal.ads.zzbza r12 = com.google.android.gms.ads.internal.zzt.zzo()
            r12.zzu(r0, r9)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00dd
        L_0x00d9:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x00dd:
            r32 = r0
            if (r8 == 0) goto L_0x00e6
            int r9 = r8.getWindowVisibility()
            goto L_0x00e8
        L_0x00e6:
            r9 = 8
        L_0x00e8:
            int r12 = r1.zzm
            r15 = -1
            if (r12 == r15) goto L_0x00ee
            r9 = r12
        L_0x00ee:
            com.google.android.gms.ads.internal.zzt.zzp()
            long r27 = com.google.android.gms.ads.internal.util.zzs.zzs(r8)
            com.google.android.gms.internal.ads.zzbbe r12 = com.google.android.gms.internal.ads.zzbbm.zzji
            com.google.android.gms.internal.ads.zzbbk r15 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r12 = r15.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0132
            if (r3 == 0) goto L_0x014a
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r12 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzs.zzO(r8, r3, r12)
            if (r3 == 0) goto L_0x014a
            if (r13 == 0) goto L_0x014a
            if (r14 == 0) goto L_0x014a
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzjl
            com.google.android.gms.internal.ads.zzbbk r12 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r12.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            long r10 = (long) r3
            int r3 = (r27 > r10 ? 1 : (r27 == r10 ? 0 : -1))
            if (r3 < 0) goto L_0x014a
            if (r9 != 0) goto L_0x014a
            goto L_0x0147
        L_0x0132:
            if (r3 == 0) goto L_0x014a
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r10 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzs.zzO(r8, r3, r10)
            if (r3 == 0) goto L_0x014a
            if (r13 == 0) goto L_0x014a
            if (r14 == 0) goto L_0x014a
            if (r9 != 0) goto L_0x014a
        L_0x0147:
            r3 = 1
            r9 = 0
            goto L_0x014b
        L_0x014a:
            r3 = 0
        L_0x014b:
            com.google.android.gms.internal.ads.zzbbe r10 = com.google.android.gms.internal.ads.zzbbm.zzjn
            com.google.android.gms.internal.ads.zzbbk r11 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r10 = r11.zzb(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x01aa
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r10 = r1.zzg
            android.app.KeyguardManager r11 = r1.zzh
            boolean r10 = com.google.android.gms.ads.internal.util.zzs.zzO(r8, r10, r11)
            r11 = 1
            if (r11 == r10) goto L_0x016d
            r10 = 0
            goto L_0x016f
        L_0x016d:
            r10 = 64
        L_0x016f:
            if (r11 == r13) goto L_0x0174
            r17 = 0
            goto L_0x0176
        L_0x0174:
            r17 = 8
        L_0x0176:
            if (r11 == r14) goto L_0x017a
            r11 = 0
            goto L_0x017c
        L_0x017a:
            r11 = 16
        L_0x017c:
            if (r9 != 0) goto L_0x0181
            r9 = 128(0x80, float:1.794E-43)
            goto L_0x0182
        L_0x0181:
            r9 = 0
        L_0x0182:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjl
            com.google.android.gms.internal.ads.zzbbk r12 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r12.zzb(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r12 = r14
            long r14 = (long) r0
            int r0 = (r27 > r14 ? 1 : (r27 == r14 ? 0 : -1))
            if (r0 < 0) goto L_0x019b
            r0 = 32
            goto L_0x019c
        L_0x019b:
            r0 = 0
        L_0x019c:
            r10 = r10 | r17
            r10 = r10 | r11
            r9 = r9 | r10
            r0 = r0 | r9
            r0 = r0 | r3
            com.google.android.gms.ads.internal.zzt.zzp()
            r9 = 0
            com.google.android.gms.ads.internal.util.zzs.zzF(r8, r0, r9)
            goto L_0x01ab
        L_0x01aa:
            r12 = r14
        L_0x01ab:
            r9 = 1
            if (r2 != r9) goto L_0x01bc
            com.google.android.gms.ads.internal.util.zzbz r0 = r1.zzk
            boolean r0 = r0.zzb()
            if (r0 != 0) goto L_0x01bc
            boolean r0 = r1.zzl
            if (r3 == r0) goto L_0x01bb
            goto L_0x01bc
        L_0x01bb:
            return
        L_0x01bc:
            if (r3 != 0) goto L_0x01c7
            boolean r0 = r1.zzl
            if (r0 != 0) goto L_0x01c7
            r9 = 1
            if (r2 == r9) goto L_0x01c6
            goto L_0x01c8
        L_0x01c6:
            return
        L_0x01c7:
            r9 = 1
        L_0x01c8:
            com.google.android.gms.internal.ads.zzatz r0 = new com.google.android.gms.internal.ads.zzatz
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzt.zzB()
            long r10 = r2.elapsedRealtime()
            android.os.PowerManager r2 = r1.zzg
            boolean r2 = r2.isScreenOn()
            if (r8 == 0) goto L_0x01e3
            boolean r14 = r8.isAttachedToWindow()
            if (r14 == 0) goto L_0x01e3
            r19 = 1
            goto L_0x01e5
        L_0x01e3:
            r19 = 0
        L_0x01e5:
            if (r8 == 0) goto L_0x01ee
            int r8 = r8.getWindowVisibility()
            r20 = r8
            goto L_0x01f0
        L_0x01ee:
            r20 = 8
        L_0x01f0:
            android.graphics.Rect r8 = r1.zzp
            android.graphics.Rect r21 = r1.zza(r8)
            android.graphics.Rect r22 = r1.zza(r4)
            android.graphics.Rect r23 = r1.zza(r5)
            android.graphics.Rect r25 = r1.zza(r6)
            android.graphics.Rect r29 = r1.zza(r7)
            android.util.DisplayMetrics r4 = r1.zzo
            float r4 = r4.density
            r30 = r4
            r15 = r0
            r16 = r10
            r18 = r2
            r24 = r13
            r26 = r12
            r31 = r3
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32)
            java.util.HashSet r2 = r1.zzn
            java.util.Iterator r2 = r2.iterator()
        L_0x0220:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0230
            java.lang.Object r4 = r2.next()
            com.google.android.gms.internal.ads.zzaua r4 = (com.google.android.gms.internal.ads.zzaua) r4
            r4.zzc(r0)
            goto L_0x0220
        L_0x0230:
            r1.zzl = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaub.zzj(int):void");
    }

    private final void zzk() {
        zzs.zza.post(new zzatx(this));
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzaty(this);
            zzt.zzv().zzc(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e2) {
                zzbzr.zzh("Error registering activity lifecycle callbacks.", e2);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e2) {
            zzbzr.zzh("Error while unregistering listeners from the last ViewTreeObserver.", e2);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e3) {
            zzbzr.zzh("Error while unregistering listeners from the ViewTreeObserver.", e3);
        }
        if (this.zza != null) {
            try {
                zzt.zzv().zzd(this.zzd, this.zza);
            } catch (IllegalStateException e4) {
                zzbzr.zzh("Failed trying to unregister the receiver", e4);
            } catch (Exception e5) {
                zzt.zzo().zzu(e5, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e6) {
                zzbzr.zzh("Error registering activity lifecycle callbacks.", e6);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    public final void onScrollChanged() {
        zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    /* access modifiers changed from: package-private */
    public final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzc(zzaua zzaua) {
        this.zzn.add(zzaua);
        zzj(3);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzj(3);
    }

    public final void zze(zzaua zzaua) {
        this.zzn.remove(zzaua);
    }

    public final void zzf() {
        this.zzk.zza(zzc);
    }

    public final void zzg(long j2) {
        this.zzk.zza(j2);
    }
}
