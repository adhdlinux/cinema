package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzfl;

public final class VideoOptions {
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza = true;
        /* access modifiers changed from: private */
        public boolean zzb = false;
        /* access modifiers changed from: private */
        public boolean zzc = false;

        public VideoOptions build() {
            return new VideoOptions(this, (zzi) null);
        }

        public Builder setClickToExpandRequested(boolean z2) {
            this.zzc = z2;
            return this;
        }

        public Builder setCustomControlsRequested(boolean z2) {
            this.zzb = z2;
            return this;
        }

        public Builder setStartMuted(boolean z2) {
            this.zza = z2;
            return this;
        }
    }

    /* synthetic */ VideoOptions(Builder builder, zzi zzi) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
    }

    public VideoOptions(zzfl zzfl) {
        this.zza = zzfl.zza;
        this.zzb = zzfl.zzb;
        this.zzc = zzfl.zzc;
    }

    public boolean getClickToExpandRequested() {
        return this.zzc;
    }

    public boolean getCustomControlsRequested() {
        return this.zzb;
    }

    public boolean getStartMuted() {
        return this.zza;
    }
}
