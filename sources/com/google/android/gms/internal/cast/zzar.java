package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.internal.featurehighlight.HelpTextView;
import com.google.android.gms.cast.framework.internal.featurehighlight.zzh;

public final class zzar extends RelativeLayout implements IntroductoryOverlay {
    private final boolean zza;
    private Activity zzb;
    /* access modifiers changed from: private */
    public IntroductoryOverlay.OnOverlayDismissedListener zzc;
    private View zzd;
    private String zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    private int zzg;

    public zzar(IntroductoryOverlay.Builder builder) {
        super(builder.zzb());
        this.zzb = builder.zzb();
        this.zza = builder.zzf();
        this.zzc = builder.zzd();
        this.zzd = builder.zzc();
        this.zze = builder.zze();
        this.zzg = builder.zza();
    }

    /* access modifiers changed from: private */
    public final void zzd() {
        removeAllViews();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzg = 0;
        this.zzf = false;
    }

    public final void remove() {
        Activity activity;
        if (this.zzf && (activity = this.zzb) != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(this);
            zzd();
        }
    }

    public final void show() {
        View view;
        Activity activity = this.zzb;
        if (activity != null && (view = this.zzd) != null && !this.zzf) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) activity.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return;
            }
            if (!this.zza || !PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("googlecast-introOverlayShown", false)) {
                zzh zzh = new zzh(activity);
                int i2 = this.zzg;
                if (i2 != 0) {
                    zzh.zzj(i2);
                }
                addView(zzh);
                HelpTextView helpTextView = (HelpTextView) activity.getLayoutInflater().inflate(R.layout.cast_help_text, zzh, false);
                helpTextView.setText(this.zze, (CharSequence) null);
                zzh.zzn(helpTextView);
                zzh.zzi(view, (View) null, true, new zzaq(this, activity, zzh));
                this.zzf = true;
                ((ViewGroup) activity.getWindow().getDecorView()).addView(this);
                zzh.zzl((Runnable) null);
                return;
            }
            zzd();
        }
    }
}
