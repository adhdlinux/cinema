package com.google.android.gms.cast.framework;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzar;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;

public interface IntroductoryOverlay {

    public interface OnOverlayDismissedListener {
        void onOverlayDismissed();
    }

    void remove();

    void show();

    public static class Builder {
        private final Activity zza;
        private final View zzb;
        private int zzc;
        private String zzd;
        private OnOverlayDismissedListener zze;
        private boolean zzf;
        private String zzg;

        public Builder(Activity activity, MenuItem menuItem) {
            this.zza = (Activity) Preconditions.checkNotNull(activity);
            this.zzb = ((MenuItem) Preconditions.checkNotNull(menuItem)).getActionView();
        }

        public IntroductoryOverlay build() {
            zzr.zzd(zzln.INSTRUCTIONS_VIEW);
            return new zzar(this);
        }

        public Builder setButtonText(int i2) {
            this.zzg = this.zza.getResources().getString(i2);
            return this;
        }

        public Builder setButtonText(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setFocusRadius(float f2) {
            return this;
        }

        public Builder setFocusRadiusId(int i2) {
            this.zza.getResources().getDimension(i2);
            return this;
        }

        public Builder setOnOverlayDismissedListener(OnOverlayDismissedListener onOverlayDismissedListener) {
            this.zze = onOverlayDismissedListener;
            return this;
        }

        public Builder setOverlayColor(int i2) {
            this.zzc = this.zza.getResources().getColor(i2);
            return this;
        }

        public Builder setSingleTime() {
            this.zzf = true;
            return this;
        }

        public Builder setTitleText(int i2) {
            this.zzd = this.zza.getResources().getString(i2);
            return this;
        }

        public Builder setTitleText(String str) {
            this.zzd = str;
            return this;
        }

        public final int zza() {
            return this.zzc;
        }

        public final Activity zzb() {
            return this.zza;
        }

        public final View zzc() {
            return this.zzb;
        }

        public final OnOverlayDismissedListener zzd() {
            return this.zze;
        }

        public final String zze() {
            return this.zzd;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public Builder(Activity activity, MediaRouteButton mediaRouteButton) {
            this.zza = (Activity) Preconditions.checkNotNull(activity);
            this.zzb = (View) Preconditions.checkNotNull(mediaRouteButton);
        }
    }
}
