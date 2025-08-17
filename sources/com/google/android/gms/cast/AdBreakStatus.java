package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdBreakStatusCreator")
@SafeParcelable.Reserved({1})
public class AdBreakStatus extends AbstractSafeParcelable {
    @Deprecated
    public static final int AD_BREAK_CLIP_NOT_SKIPPABLE = -1;
    public static final Parcelable.Creator<AdBreakStatus> CREATOR = new zzc();
    private static final Logger zza = new Logger("AdBreakStatus");
    @SafeParcelable.Field(getter = "getCurrentBreakTimeInMs", id = 2)
    private final long zzb;
    @SafeParcelable.Field(getter = "getCurrentBreakClipTimeInMs", id = 3)
    private final long zzc;
    @SafeParcelable.Field(getter = "getBreakId", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getBreakClipId", id = 5)
    private final String zze;
    @SafeParcelable.Field(getter = "getWhenSkippableInMs", id = 6)
    private final long zzf;

    public static class Builder {
        private long zza;
        private long zzb;
        private String zzc;
        private String zzd;
        private long zze = -1;

        public AdBreakStatus build() {
            return new AdBreakStatus(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder setBreakClipId(String str) {
            this.zzd = str;
            return this;
        }

        public Builder setBreakId(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setCurrentBreakClipTimeInMs(long j2) {
            this.zzb = j2;
            return this;
        }

        public Builder setCurrentBreakTimeInMs(long j2) {
            this.zza = j2;
            return this;
        }

        public Builder setWhenSkippableInMs(long j2) {
            this.zze = j2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    AdBreakStatus(@SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) long j3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) long j4) {
        this.zzb = j2;
        this.zzc = j3;
        this.zzd = str;
        this.zze = str2;
        this.zzf = j4;
    }

    static AdBreakStatus zza(JSONObject jSONObject) {
        long j2;
        if (jSONObject != null && jSONObject.has("currentBreakTime") && jSONObject.has("currentBreakClipTime")) {
            try {
                long secToMillisec = CastUtils.secToMillisec(jSONObject.getLong("currentBreakTime"));
                long secToMillisec2 = CastUtils.secToMillisec(jSONObject.getLong("currentBreakClipTime"));
                String optStringOrNull = CastUtils.optStringOrNull(jSONObject, "breakId");
                String optStringOrNull2 = CastUtils.optStringOrNull(jSONObject, "breakClipId");
                long optLong = jSONObject.optLong("whenSkippable", -1);
                if (optLong != -1) {
                    j2 = CastUtils.secToMillisec(optLong);
                } else {
                    j2 = optLong;
                }
                return new AdBreakStatus(secToMillisec, secToMillisec2, optStringOrNull, optStringOrNull2, j2);
            } catch (JSONException e2) {
                zza.e(e2, "Error while creating an AdBreakClipInfo from JSON", new Object[0]);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakStatus)) {
            return false;
        }
        AdBreakStatus adBreakStatus = (AdBreakStatus) obj;
        if (this.zzb == adBreakStatus.zzb && this.zzc == adBreakStatus.zzc && CastUtils.zze(this.zzd, adBreakStatus.zzd) && CastUtils.zze(this.zze, adBreakStatus.zze) && this.zzf == adBreakStatus.zzf) {
            return true;
        }
        return false;
    }

    public String getBreakClipId() {
        return this.zze;
    }

    public String getBreakId() {
        return this.zzd;
    }

    public long getCurrentBreakClipTimeInMs() {
        return this.zzc;
    }

    public long getCurrentBreakTimeInMs() {
        return this.zzb;
    }

    public long getWhenSkippableInMs() {
        return this.zzf;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzd, this.zze, Long.valueOf(this.zzf));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getCurrentBreakTimeInMs());
        SafeParcelWriter.writeLong(parcel, 3, getCurrentBreakClipTimeInMs());
        SafeParcelWriter.writeString(parcel, 4, getBreakId(), false);
        SafeParcelWriter.writeString(parcel, 5, getBreakClipId(), false);
        SafeParcelWriter.writeLong(parcel, 6, getWhenSkippableInMs());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentBreakTime", CastUtils.millisecToSec(this.zzb));
            jSONObject.put("currentBreakClipTime", CastUtils.millisecToSec(this.zzc));
            jSONObject.putOpt("breakId", this.zzd);
            jSONObject.putOpt("breakClipId", this.zze);
            long j2 = this.zzf;
            if (j2 != -1) {
                jSONObject.put("whenSkippable", CastUtils.millisecToSec(j2));
            }
            return jSONObject;
        } catch (JSONException e2) {
            zza.e(e2, "Error transforming AdBreakStatus into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }
}
