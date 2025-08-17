package com.google.android.gms.cast;

import org.json.JSONObject;

public class MediaLoadOptions {
    public static final double PLAYBACK_RATE_MAX = 2.0d;
    public static final double PLAYBACK_RATE_MIN = 0.5d;
    private final boolean zza;
    private final long zzb;
    private final double zzc;
    private final long[] zzd;
    private final JSONObject zze;
    private final String zzf;
    private final String zzg;

    public static class Builder {
        private boolean zza = true;
        private long zzb = -1;
        private double zzc = 1.0d;
        private long[] zzd;
        private JSONObject zze;
        private String zzf;
        private String zzg;

        public MediaLoadOptions build() {
            return new MediaLoadOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, (zzca) null);
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zzd = jArr;
            return this;
        }

        public Builder setAutoplay(boolean z2) {
            this.zza = z2;
            return this;
        }

        public Builder setCredentials(String str) {
            this.zzf = str;
            return this;
        }

        public Builder setCredentialsType(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zze = jSONObject;
            return this;
        }

        public Builder setPlayPosition(long j2) {
            this.zzb = j2;
            return this;
        }

        public Builder setPlaybackRate(double d2) {
            if (Double.compare(d2, 2.0d) > 0 || Double.compare(d2, 0.5d) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.zzc = d2;
            return this;
        }
    }

    /* synthetic */ MediaLoadOptions(boolean z2, long j2, double d2, long[] jArr, JSONObject jSONObject, String str, String str2, zzca zzca) {
        this.zza = z2;
        this.zzb = j2;
        this.zzc = d2;
        this.zzd = jArr;
        this.zze = jSONObject;
        this.zzf = str;
        this.zzg = str2;
    }

    public long[] getActiveTrackIds() {
        return this.zzd;
    }

    public boolean getAutoplay() {
        return this.zza;
    }

    public String getCredentials() {
        return this.zzf;
    }

    public String getCredentialsType() {
        return this.zzg;
    }

    public JSONObject getCustomData() {
        return this.zze;
    }

    public long getPlayPosition() {
        return this.zzb;
    }

    public double getPlaybackRate() {
        return this.zzc;
    }
}
