package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoOptions;

public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    public static final int SWIPE_GESTURE_DIRECTION_DOWN = 8;
    public static final int SWIPE_GESTURE_DIRECTION_LEFT = 2;
    public static final int SWIPE_GESTURE_DIRECTION_RIGHT = 1;
    public static final int SWIPE_GESTURE_DIRECTION_UP = 4;
    private final boolean zza;
    private final int zzb;
    private final boolean zzc;
    private final int zzd;
    private final VideoOptions zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int zzh;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza = false;
        /* access modifiers changed from: private */
        public int zzb = 0;
        /* access modifiers changed from: private */
        public boolean zzc = false;
        /* access modifiers changed from: private */
        public VideoOptions zzd;
        /* access modifiers changed from: private */
        public int zze = 1;
        /* access modifiers changed from: private */
        public boolean zzf = false;
        /* access modifiers changed from: private */
        public boolean zzg = false;
        /* access modifiers changed from: private */
        public int zzh = 0;

        public NativeAdOptions build() {
            return new NativeAdOptions(this, (zza) null);
        }

        public Builder enableCustomClickGestureDirection(@SwipeGestureDirection int i2, boolean z2) {
            this.zzg = z2;
            this.zzh = i2;
            return this;
        }

        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i2) {
            this.zze = i2;
            return this;
        }

        public Builder setMediaAspectRatio(@NativeMediaAspectRatio int i2) {
            this.zzb = i2;
            return this;
        }

        public Builder setRequestCustomMuteThisAd(boolean z2) {
            this.zzf = z2;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z2) {
            this.zzc = z2;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z2) {
            this.zza = z2;
            return this;
        }

        public Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzd = videoOptions;
            return this;
        }
    }

    public @interface NativeMediaAspectRatio {
    }

    public @interface SwipeGestureDirection {
    }

    /* synthetic */ NativeAdOptions(Builder builder, zza zza2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zze;
        this.zze = builder.zzd;
        this.zzf = builder.zzf;
        this.zzg = builder.zzg;
        this.zzh = builder.zzh;
    }

    public int getAdChoicesPlacement() {
        return this.zzd;
    }

    public int getMediaAspectRatio() {
        return this.zzb;
    }

    public VideoOptions getVideoOptions() {
        return this.zze;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzc;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zza;
    }

    public final int zza() {
        return this.zzh;
    }

    public final boolean zzb() {
        return this.zzg;
    }

    public final boolean zzc() {
        return this.zzf;
    }
}
