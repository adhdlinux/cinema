package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdBreakInfoCreator")
@SafeParcelable.Reserved({1})
public class AdBreakInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdBreakInfo> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getPlaybackPositionInMs", id = 2)
    private final long zza;
    @SafeParcelable.Field(getter = "getId", id = 3)
    private final String zzb;
    @SafeParcelable.Field(getter = "getDurationInMs", id = 4)
    private final long zzc;
    @SafeParcelable.Field(getter = "isWatched", id = 5)
    private final boolean zzd;
    @SafeParcelable.Field(getter = "getBreakClipIds", id = 6)
    private final String[] zze;
    @SafeParcelable.Field(getter = "isEmbedded", id = 7)
    private final boolean zzf;
    @SafeParcelable.Field(getter = "isExpanded", id = 8)
    private final boolean zzg;

    public static class Builder {
        private final long zza;
        private String zzb;
        private long zzc;
        private boolean zzd;
        private boolean zze;
        private String[] zzf;
        private boolean zzg;

        public Builder(long j2) {
            this.zza = j2;
        }

        public AdBreakInfo build() {
            return new AdBreakInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg);
        }

        public Builder setBreakClipIds(String[] strArr) {
            this.zzf = strArr;
            return this;
        }

        public Builder setDurationInMs(long j2) {
            this.zzc = j2;
            return this;
        }

        public Builder setId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setIsEmbedded(boolean z2) {
            this.zze = z2;
            return this;
        }

        @KeepForSdk
        public Builder setIsExpanded(boolean z2) {
            this.zzg = z2;
            return this;
        }

        public Builder setIsWatched(boolean z2) {
            this.zzd = z2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public AdBreakInfo(@SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) long j3, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String[] strArr, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) boolean z4) {
        this.zza = j2;
        this.zzb = str;
        this.zzc = j3;
        this.zzd = z2;
        this.zze = strArr;
        this.zzf = z3;
        this.zzg = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakInfo)) {
            return false;
        }
        AdBreakInfo adBreakInfo = (AdBreakInfo) obj;
        if (CastUtils.zze(this.zzb, adBreakInfo.zzb) && this.zza == adBreakInfo.zza && this.zzc == adBreakInfo.zzc && this.zzd == adBreakInfo.zzd && Arrays.equals(this.zze, adBreakInfo.zze) && this.zzf == adBreakInfo.zzf && this.zzg == adBreakInfo.zzg) {
            return true;
        }
        return false;
    }

    public String[] getBreakClipIds() {
        return this.zze;
    }

    public long getDurationInMs() {
        return this.zzc;
    }

    public String getId() {
        return this.zzb;
    }

    public long getPlaybackPositionInMs() {
        return this.zza;
    }

    public int hashCode() {
        return this.zzb.hashCode();
    }

    public boolean isEmbedded() {
        return this.zzf;
    }

    @KeepForSdk
    public boolean isExpanded() {
        return this.zzg;
    }

    public boolean isWatched() {
        return this.zzd;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getPlaybackPositionInMs());
        SafeParcelWriter.writeString(parcel, 3, getId(), false);
        SafeParcelWriter.writeLong(parcel, 4, getDurationInMs());
        SafeParcelWriter.writeBoolean(parcel, 5, isWatched());
        SafeParcelWriter.writeStringArray(parcel, 6, getBreakClipIds(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmbedded());
        SafeParcelWriter.writeBoolean(parcel, 8, isExpanded());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.zzb);
            jSONObject.put(ViewProps.POSITION, CastUtils.millisecToSec(this.zza));
            jSONObject.put("isWatched", this.zzd);
            jSONObject.put("isEmbedded", this.zzf);
            jSONObject.put("duration", CastUtils.millisecToSec(this.zzc));
            jSONObject.put("expanded", this.zzg);
            if (this.zze != null) {
                JSONArray jSONArray = new JSONArray();
                for (String put : this.zze) {
                    jSONArray.put(put);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
