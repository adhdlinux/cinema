package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzay implements ConsentForm {
    private final Application zza;
    private final zzac zzb;
    private final zzbi zzc;
    private final zzam zzd;
    private final zzbc zze;
    private final zzcl<zzbg> zzf;
    private Dialog zzg;
    private zzbg zzh;
    private final AtomicBoolean zzi = new AtomicBoolean();
    private final AtomicReference<zzax> zzj = new AtomicReference<>();
    private final AtomicReference<ConsentForm.OnConsentFormDismissedListener> zzk = new AtomicReference<>();
    private final AtomicReference<zzaw> zzl = new AtomicReference<>();

    public zzay(Application application, zzac zzac, zzbi zzbi, zzam zzam, zzbc zzbc, zzcl<zzbg> zzcl) {
        this.zza = application;
        this.zzb = zzac;
        this.zzc = zzbi;
        this.zzd = zzam;
        this.zze = zzbc;
        this.zzf = zzcl;
    }

    private final void zzg() {
        Dialog dialog = this.zzg;
        if (dialog != null) {
            dialog.dismiss();
            this.zzg = null;
        }
        this.zzc.zza((Activity) null);
        zzaw andSet = this.zzl.getAndSet((Object) null);
        if (andSet != null) {
            andSet.zza.zza.unregisterActivityLifecycleCallbacks(andSet);
        }
    }

    public final void show(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        zzcd.zza();
        if (!this.zzi.compareAndSet(false, true)) {
            onConsentFormDismissedListener.a(new zzj(3, "ConsentForm#show can only be invoked once.").zza());
            return;
        }
        zzaw zzaw = new zzaw(this, activity);
        this.zza.registerActivityLifecycleCallbacks(zzaw);
        this.zzl.set(zzaw);
        this.zzc.zza(activity);
        Dialog dialog = new Dialog(activity, 16973840);
        dialog.setContentView(this.zzh);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        if (window == null) {
            onConsentFormDismissedListener.a(new zzj(3, "Activity with null windows is passed in.").zza());
            return;
        }
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        this.zzk.set(onConsentFormDismissedListener);
        dialog.show();
        this.zzg = dialog;
        this.zzh.zzb("UMP_messagePresented", "");
    }

    /* access modifiers changed from: package-private */
    public final zzbg zza() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(UserMessagingPlatform$OnConsentFormLoadSuccessListener userMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener userMessagingPlatform$OnConsentFormLoadFailureListener) {
        zzbg zza2 = ((zzbh) this.zzf).zzb();
        this.zzh = zza2;
        zza2.setBackgroundColor(0);
        zza2.getSettings().setJavaScriptEnabled(true);
        zza2.setWebViewClient(new zzbf(zza2, (zzbe) null));
        this.zzj.set(new zzax(userMessagingPlatform$OnConsentFormLoadSuccessListener, userMessagingPlatform$OnConsentFormLoadFailureListener, (zzav) null));
        this.zzh.loadDataWithBaseURL(this.zze.zza(), this.zze.zzb(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8", (String) null);
        zzcd.zza.postDelayed(new zzau(this), NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i2) {
        zzg();
        ConsentForm.OnConsentFormDismissedListener andSet = this.zzk.getAndSet((Object) null);
        if (andSet != null) {
            this.zzd.zzf(3);
            andSet.a((FormError) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzj zzj2) {
        zzg();
        ConsentForm.OnConsentFormDismissedListener andSet = this.zzk.getAndSet((Object) null);
        if (andSet != null) {
            andSet.a(zzj2.zza());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        zzax andSet = this.zzj.getAndSet((Object) null);
        if (andSet != null) {
            andSet.onConsentFormLoadSuccess(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzj zzj2) {
        zzax andSet = this.zzj.getAndSet((Object) null);
        if (andSet != null) {
            andSet.onConsentFormLoadFailure(zzj2.zza());
        }
    }
}
