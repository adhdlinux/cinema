package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaLiveSeekableRangeCreator")
@SafeParcelable.Reserved({1})
public class MediaLiveSeekableRange extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaLiveSeekableRange> CREATOR = new zzbz();
    private static final Logger zza = new Logger("MediaLiveSeekableRange");
    @SafeParcelable.Field(getter = "getStartTime", id = 2)
    private final long zzb;
    @SafeParcelable.Field(getter = "getEndTime", id = 3)
    private final long zzc;
    @SafeParcelable.Field(getter = "isMovingWindow", id = 4)
    private final boolean zzd;
    @SafeParcelable.Field(getter = "isLiveDone", id = 5)
    private final boolean zze;

    public static class Builder {
        private long zza;
        private long zzb;
        private boolean zzc;
        private boolean zzd;

        public MediaLiveSeekableRange build() {
            return new MediaLiveSeekableRange(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public Builder setEndTime(long j2) {
            this.zzb = j2;
            return this;
        }

        public Builder setIsLiveDone(boolean z2) {
            this.zzd = z2;
            return this;
        }

        public Builder setIsMovingWindow(boolean z2) {
            this.zzc = z2;
            return this;
        }

        public Builder setStartTime(long j2) {
            this.zza = j2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    MediaLiveSeekableRange(@SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) long j3, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) boolean z3) {
        this.zzb = Math.max(j2, 0);
        this.zzc = Math.max(j3, 0);
        this.zzd = z2;
        this.zze = z3;
    }

    static MediaLiveSeekableRange zza(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(ViewProps.START) && jSONObject.has(ViewProps.END)) {
            try {
                return new MediaLiveSeekableRange(CastUtils.secToMillisec(jSONObject.getDouble(ViewProps.START)), CastUtils.secToMillisec(jSONObject.getDouble(ViewProps.END)), jSONObject.optBoolean("isMovingWindow"), jSONObject.optBoolean("isLiveDone"));
            } catch (JSONException unused) {
                zza.e("Ignoring Malformed MediaLiveSeekableRange: ".concat(jSONObject.toString()), new Object[0]);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaLiveSeekableRange)) {
            return false;
        }
        MediaLiveSeekableRange mediaLiveSeekableRange = (MediaLiveSeekableRange) obj;
        if (this.zzb == mediaLiveSeekableRange.zzb && this.zzc == mediaLiveSeekableRange.zzc && this.zzd == mediaLiveSeekableRange.zzd && this.zze == mediaLiveSeekableRange.zze) {
            return true;
        }
        return false;
    }

    public long getEndTime() {
        return this.zzc;
    }

    public long getStartTime() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Long.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze));
    }

    public boolean isLiveDone() {
        return this.zze;
    }

    public boolean isMovingWindow() {
        return this.zzd;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getStartTime());
        SafeParcelWriter.writeLong(parcel, 3, getEndTime());
        SafeParcelWriter.writeBoolean(parcel, 4, isMovingWindow());
        SafeParcelWriter.writeBoolean(parcel, 5, isLiveDone());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject zzb() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ViewProps.START, CastUtils.millisecToSec(this.zzb));
            jSONObject.put(ViewProps.END, CastUtils.millisecToSec(this.zzc));
            jSONObject.put("isMovingWindow", this.zzd);
            jSONObject.put("isLiveDone", this.zze);
            return jSONObject;
        } catch (JSONException unused) {
            zza.e("Error transforming MediaLiveSeekableRange into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }
}
