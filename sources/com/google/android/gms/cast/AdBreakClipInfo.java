package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdBreakClipInfoCreator")
@SafeParcelable.Reserved({1})
public class AdBreakClipInfo extends AbstractSafeParcelable {
    public static final long AD_BREAK_CLIP_NOT_SKIPPABLE = -1;
    public static final Parcelable.Creator<AdBreakClipInfo> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getId", id = 2)
    private final String zza;
    @SafeParcelable.Field(getter = "getTitle", id = 3)
    private final String zzb;
    @SafeParcelable.Field(getter = "getDurationInMs", id = 4)
    private final long zzc;
    @SafeParcelable.Field(getter = "getContentUrl", id = 5)
    private final String zzd;
    @SafeParcelable.Field(getter = "getMimeType", id = 6)
    private final String zze;
    @SafeParcelable.Field(getter = "getClickThroughUrl", id = 7)
    private final String zzf;
    @SafeParcelable.Field(getter = "getCustomDataAsString", id = 8)
    private String zzg;
    @SafeParcelable.Field(getter = "getContentId", id = 9)
    private final String zzh;
    @SafeParcelable.Field(getter = "getImageUrl", id = 10)
    private final String zzi;
    @SafeParcelable.Field(getter = "getWhenSkippableInMs", id = 11)
    private final long zzj;
    @HlsSegmentFormat
    @SafeParcelable.Field(getter = "getHlsSegmentFormat", id = 12)
    private final String zzk;
    @SafeParcelable.Field(getter = "getVastAdsRequest", id = 13)
    private final VastAdsRequest zzl;
    private JSONObject zzm;

    public static class Builder {
        private final String zza;
        private String zzb;
        private long zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private String zzg;
        private String zzh;
        private String zzi;
        private long zzj = -1;
        @HlsSegmentFormat
        private String zzk;
        private VastAdsRequest zzl;

        public Builder(String str) {
            this.zza = str;
        }

        public AdBreakClipInfo build() {
            return new AdBreakClipInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
        }

        public Builder setClickThroughUrl(String str) {
            this.zzf = str;
            return this;
        }

        public Builder setContentId(String str) {
            this.zzh = str;
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zzd = str;
            return this;
        }

        public Builder setCustomDataJsonString(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setDurationInMs(long j2) {
            this.zzc = j2;
            return this;
        }

        public Builder setHlsSegmentFormat(String str) {
            this.zzk = str;
            return this;
        }

        public Builder setImageUrl(String str) {
            this.zzi = str;
            return this;
        }

        public Builder setMimeType(String str) {
            this.zze = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setVastAdsRequest(VastAdsRequest vastAdsRequest) {
            this.zzl = vastAdsRequest;
            return this;
        }

        public Builder setWhenSkippableInMs(long j2) {
            this.zzj = j2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    AdBreakClipInfo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) long j2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) String str6, @SafeParcelable.Param(id = 9) String str7, @SafeParcelable.Param(id = 10) String str8, @SafeParcelable.Param(id = 11) long j3, @HlsSegmentFormat @SafeParcelable.Param(id = 12) String str9, @SafeParcelable.Param(id = 13) VastAdsRequest vastAdsRequest) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
        this.zzh = str7;
        this.zzi = str8;
        this.zzj = j3;
        this.zzk = str9;
        this.zzl = vastAdsRequest;
        if (!TextUtils.isEmpty(str6)) {
            try {
                this.zzm = new JSONObject(this.zzg);
            } catch (JSONException e2) {
                Log.w("AdBreakClipInfo", String.format(Locale.ROOT, "Error creating AdBreakClipInfo: %s", new Object[]{e2.getMessage()}));
                this.zzg = null;
                this.zzm = new JSONObject();
            }
        } else {
            this.zzm = new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakClipInfo)) {
            return false;
        }
        AdBreakClipInfo adBreakClipInfo = (AdBreakClipInfo) obj;
        if (!CastUtils.zze(this.zza, adBreakClipInfo.zza) || !CastUtils.zze(this.zzb, adBreakClipInfo.zzb) || this.zzc != adBreakClipInfo.zzc || !CastUtils.zze(this.zzd, adBreakClipInfo.zzd) || !CastUtils.zze(this.zze, adBreakClipInfo.zze) || !CastUtils.zze(this.zzf, adBreakClipInfo.zzf) || !CastUtils.zze(this.zzg, adBreakClipInfo.zzg) || !CastUtils.zze(this.zzh, adBreakClipInfo.zzh) || !CastUtils.zze(this.zzi, adBreakClipInfo.zzi) || this.zzj != adBreakClipInfo.zzj || !CastUtils.zze(this.zzk, adBreakClipInfo.zzk) || !CastUtils.zze(this.zzl, adBreakClipInfo.zzl)) {
            return false;
        }
        return true;
    }

    public String getClickThroughUrl() {
        return this.zzf;
    }

    public String getContentId() {
        return this.zzh;
    }

    public String getContentUrl() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzm;
    }

    public long getDurationInMs() {
        return this.zzc;
    }

    public String getHlsSegmentFormat() {
        return this.zzk;
    }

    public String getId() {
        return this.zza;
    }

    public String getImageUrl() {
        return this.zzi;
    }

    public String getMimeType() {
        return this.zze;
    }

    public String getTitle() {
        return this.zzb;
    }

    public VastAdsRequest getVastAdsRequest() {
        return this.zzl;
    }

    public long getWhenSkippableInMs() {
        return this.zzj;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Long.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, Long.valueOf(this.zzj), this.zzk, this.zzl);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeLong(parcel, 4, getDurationInMs());
        SafeParcelWriter.writeString(parcel, 5, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 6, getMimeType(), false);
        SafeParcelWriter.writeString(parcel, 7, getClickThroughUrl(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, getContentId(), false);
        SafeParcelWriter.writeString(parcel, 10, getImageUrl(), false);
        SafeParcelWriter.writeLong(parcel, 11, getWhenSkippableInMs());
        SafeParcelWriter.writeString(parcel, 12, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVastAdsRequest(), i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.zza);
            jSONObject.put("duration", CastUtils.millisecToSec(this.zzc));
            long j2 = this.zzj;
            if (j2 != -1) {
                jSONObject.put("whenSkippable", CastUtils.millisecToSec(j2));
            }
            String str = this.zzh;
            if (str != null) {
                jSONObject.put("contentId", str);
            }
            String str2 = this.zze;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            String str3 = this.zzb;
            if (str3 != null) {
                jSONObject.put("title", str3);
            }
            String str4 = this.zzd;
            if (str4 != null) {
                jSONObject.put("contentUrl", str4);
            }
            String str5 = this.zzf;
            if (str5 != null) {
                jSONObject.put("clickThroughUrl", str5);
            }
            JSONObject jSONObject2 = this.zzm;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str6 = this.zzi;
            if (str6 != null) {
                jSONObject.put("posterUrl", str6);
            }
            String str7 = this.zzk;
            if (str7 != null) {
                jSONObject.put("hlsSegmentFormat", str7);
            }
            VastAdsRequest vastAdsRequest = this.zzl;
            if (vastAdsRequest != null) {
                jSONObject.put("vastAdsRequest", vastAdsRequest.zza());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
