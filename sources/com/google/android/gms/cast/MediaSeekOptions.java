package com.google.android.gms.cast;

import com.google.android.gms.common.internal.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

public class MediaSeekOptions {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    private final long zza;
    private final int zzb;
    private final boolean zzc;
    private final JSONObject zzd;

    public static class Builder {
        private long zza;
        private int zzb = 0;
        private boolean zzc;
        private JSONObject zzd;

        public MediaSeekOptions build() {
            return new MediaSeekOptions(this.zza, this.zzb, this.zzc, this.zzd, (zzcl) null);
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzd = jSONObject;
            return this;
        }

        public Builder setIsSeekToInfinite(boolean z2) {
            this.zzc = z2;
            return this;
        }

        public Builder setPosition(long j2) {
            this.zza = j2;
            return this;
        }

        public Builder setResumeState(int i2) {
            this.zzb = i2;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResumeState {
    }

    /* synthetic */ MediaSeekOptions(long j2, int i2, boolean z2, JSONObject jSONObject, zzcl zzcl) {
        this.zza = j2;
        this.zzb = i2;
        this.zzc = z2;
        this.zzd = jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSeekOptions)) {
            return false;
        }
        MediaSeekOptions mediaSeekOptions = (MediaSeekOptions) obj;
        if (this.zza == mediaSeekOptions.zza && this.zzb == mediaSeekOptions.zzb && this.zzc == mediaSeekOptions.zzc && Objects.equal(this.zzd, mediaSeekOptions.zzd)) {
            return true;
        }
        return false;
    }

    public JSONObject getCustomData() {
        return this.zzd;
    }

    public long getPosition() {
        return this.zza;
    }

    public int getResumeState() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Boolean.valueOf(this.zzc), this.zzd);
    }

    public boolean isSeekToInfinite() {
        return this.zzc;
    }
}
