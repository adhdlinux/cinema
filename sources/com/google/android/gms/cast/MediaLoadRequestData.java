package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.cast.MediaQueueData;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaLoadRequestDataCreator")
@SafeParcelable.Reserved({1})
public class MediaLoadRequestData extends AbstractSafeParcelable implements RequestData {
    @KeepForSdk
    public static final Parcelable.Creator<MediaLoadRequestData> CREATOR = new zzcc();
    public static final double PLAYBACK_RATE_MAX = 2.0d;
    public static final double PLAYBACK_RATE_MIN = 0.5d;
    public static final long PLAY_POSITION_UNASSIGNED = -1;
    private static final Logger zzb = new Logger("MediaLoadRequestData");
    @SafeParcelable.Field(id = 8)
    String zza;
    @SafeParcelable.Field(getter = "getMediaInfo", id = 2)
    private final MediaInfo zzc;
    @SafeParcelable.Field(getter = "getQueueData", id = 3)
    private final MediaQueueData zzd;
    @SafeParcelable.Field(getter = "getAutoplay", id = 4)
    private final Boolean zze;
    @SafeParcelable.Field(getter = "getCurrentTime", id = 5)
    private final long zzf;
    @SafeParcelable.Field(getter = "getPlaybackRate", id = 6)
    private final double zzg;
    @SafeParcelable.Field(getter = "getActiveTrackIds", id = 7)
    private final long[] zzh;
    private final JSONObject zzi;
    @SafeParcelable.Field(getter = "getCredentials", id = 9)
    private final String zzj;
    @SafeParcelable.Field(getter = "getCredentialsType", id = 10)
    private final String zzk;
    @SafeParcelable.Field(getter = "getAtvCredentials", id = 11)
    private final String zzl;
    @SafeParcelable.Field(getter = "getAtvCredentialsType", id = 12)
    private final String zzm;
    @SafeParcelable.Field(getter = "getRequestId", id = 13)
    private long zzn;

    public static class Builder {
        private MediaInfo zza;
        private MediaQueueData zzb;
        private Boolean zzc = Boolean.TRUE;
        private long zzd = -1;
        private double zze = 1.0d;
        private long[] zzf;
        private JSONObject zzg;
        private String zzh;
        private String zzi;
        private String zzj;
        private String zzk;
        private long zzl;

        public Builder() {
        }

        public MediaLoadRequestData build() {
            return new MediaLoadRequestData(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zzf = jArr;
            return this;
        }

        public Builder setAtvCredentials(String str) {
            this.zzj = str;
            return this;
        }

        public Builder setAtvCredentialsType(String str) {
            this.zzk = str;
            return this;
        }

        public Builder setAutoplay(Boolean bool) {
            this.zzc = bool;
            return this;
        }

        public Builder setCredentials(String str) {
            this.zzh = str;
            return this;
        }

        public Builder setCredentialsType(String str) {
            this.zzi = str;
            return this;
        }

        public Builder setCurrentTime(long j2) {
            this.zzd = j2;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzg = jSONObject;
            return this;
        }

        public Builder setMediaInfo(MediaInfo mediaInfo) {
            this.zza = mediaInfo;
            return this;
        }

        public Builder setPlaybackRate(double d2) {
            if (Double.compare(d2, 2.0d) > 0 || Double.compare(d2, 0.5d) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.zze = d2;
            return this;
        }

        public Builder setQueueData(MediaQueueData mediaQueueData) {
            this.zzb = mediaQueueData;
            return this;
        }

        public final Builder zza(long j2) {
            this.zzl = j2;
            return this;
        }

        public Builder(MediaLoadRequestData mediaLoadRequestData) {
            this.zza = mediaLoadRequestData.getMediaInfo();
            this.zzb = mediaLoadRequestData.getQueueData();
            this.zzc = mediaLoadRequestData.getAutoplay();
            this.zzd = mediaLoadRequestData.getCurrentTime();
            this.zze = mediaLoadRequestData.getPlaybackRate();
            this.zzf = mediaLoadRequestData.getActiveTrackIds();
            this.zzg = mediaLoadRequestData.getCustomData();
            this.zzh = mediaLoadRequestData.getCredentials();
            this.zzi = mediaLoadRequestData.getCredentialsType();
            this.zzj = mediaLoadRequestData.zza();
            this.zzk = mediaLoadRequestData.zzb();
            this.zzl = mediaLoadRequestData.getRequestId();
        }
    }

    @SafeParcelable.Constructor
    MediaLoadRequestData(@SafeParcelable.Param(id = 2) MediaInfo mediaInfo, @SafeParcelable.Param(id = 3) MediaQueueData mediaQueueData, @SafeParcelable.Param(id = 4) Boolean bool, @SafeParcelable.Param(id = 5) long j2, @SafeParcelable.Param(id = 6) double d2, @SafeParcelable.Param(id = 7) long[] jArr, @SafeParcelable.Param(id = 8) String str, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 11) String str4, @SafeParcelable.Param(id = 12) String str5, @SafeParcelable.Param(id = 13) long j3) {
        this(mediaInfo, mediaQueueData, bool, j2, d2, jArr, CastUtils.jsonStringToJsonObject(str), str2, str3, str4, str5, j3);
    }

    @KeepForSdk
    public static MediaLoadRequestData fromJson(JSONObject jSONObject) {
        Builder builder = new Builder();
        try {
            if (jSONObject.has("media")) {
                builder.setMediaInfo(new MediaInfo(jSONObject.getJSONObject("media")));
            }
            if (jSONObject.has("queueData")) {
                MediaQueueData.Builder builder2 = new MediaQueueData.Builder();
                builder2.zza(jSONObject.getJSONObject("queueData"));
                builder.setQueueData(builder2.build());
            }
            if (jSONObject.has(AudienceNetworkActivity.AUTOPLAY)) {
                builder.setAutoplay(Boolean.valueOf(jSONObject.getBoolean(AudienceNetworkActivity.AUTOPLAY)));
            } else {
                builder.setAutoplay((Boolean) null);
            }
            if (jSONObject.has("currentTime")) {
                builder.setCurrentTime(CastUtils.secToMillisec(jSONObject.getDouble("currentTime")));
            } else {
                builder.setCurrentTime(-1);
            }
            builder.setPlaybackRate(jSONObject.optDouble("playbackRate", 1.0d));
            builder.setCredentials(CastUtils.optStringOrNull(jSONObject, "credentials"));
            builder.setCredentialsType(CastUtils.optStringOrNull(jSONObject, "credentialsType"));
            builder.setAtvCredentials(CastUtils.optStringOrNull(jSONObject, "atvCredentials"));
            builder.setAtvCredentialsType(CastUtils.optStringOrNull(jSONObject, "atvCredentialsType"));
            builder.zza(jSONObject.optLong("requestId"));
            JSONArray optJSONArray = jSONObject.optJSONArray("activeTrackIds");
            if (optJSONArray != null) {
                long[] jArr = new long[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    jArr[i2] = optJSONArray.getLong(i2);
                }
                builder.setActiveTrackIds(jArr);
            }
            builder.setCustomData(jSONObject.optJSONObject("customData"));
            return builder.build();
        } catch (JSONException unused) {
            return builder.build();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaLoadRequestData)) {
            return false;
        }
        MediaLoadRequestData mediaLoadRequestData = (MediaLoadRequestData) obj;
        if (JsonUtils.areJsonValuesEquivalent(this.zzi, mediaLoadRequestData.zzi) && Objects.equal(this.zzc, mediaLoadRequestData.zzc) && Objects.equal(this.zzd, mediaLoadRequestData.zzd) && Objects.equal(this.zze, mediaLoadRequestData.zze) && this.zzf == mediaLoadRequestData.zzf && this.zzg == mediaLoadRequestData.zzg && Arrays.equals(this.zzh, mediaLoadRequestData.zzh) && Objects.equal(this.zzj, mediaLoadRequestData.zzj) && Objects.equal(this.zzk, mediaLoadRequestData.zzk) && Objects.equal(this.zzl, mediaLoadRequestData.zzl) && Objects.equal(this.zzm, mediaLoadRequestData.zzm) && this.zzn == mediaLoadRequestData.zzn) {
            return true;
        }
        return false;
    }

    public long[] getActiveTrackIds() {
        return this.zzh;
    }

    public Boolean getAutoplay() {
        return this.zze;
    }

    public String getCredentials() {
        return this.zzj;
    }

    public String getCredentialsType() {
        return this.zzk;
    }

    public long getCurrentTime() {
        return this.zzf;
    }

    public JSONObject getCustomData() {
        return this.zzi;
    }

    public MediaInfo getMediaInfo() {
        return this.zzc;
    }

    public double getPlaybackRate() {
        return this.zzg;
    }

    public MediaQueueData getQueueData() {
        return this.zzd;
    }

    @KeepForSdk
    public long getRequestId() {
        return this.zzn;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzc, this.zzd, this.zze, Long.valueOf(this.zzf), Double.valueOf(this.zzg), this.zzh, String.valueOf(this.zzi), this.zzj, this.zzk, this.zzl, this.zzm, Long.valueOf(this.zzn));
    }

    @KeepForSdk
    public void setRequestId(long j2) {
        this.zzn = j2;
    }

    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.zzc;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.zza());
            }
            MediaQueueData mediaQueueData = this.zzd;
            if (mediaQueueData != null) {
                jSONObject.put("queueData", mediaQueueData.zza());
            }
            jSONObject.putOpt(AudienceNetworkActivity.AUTOPLAY, this.zze);
            long j2 = this.zzf;
            if (j2 != -1) {
                jSONObject.put("currentTime", CastUtils.millisecToSec(j2));
            }
            jSONObject.put("playbackRate", this.zzg);
            jSONObject.putOpt("credentials", this.zzj);
            jSONObject.putOpt("credentialsType", this.zzk);
            jSONObject.putOpt("atvCredentials", this.zzl);
            jSONObject.putOpt("atvCredentialsType", this.zzm);
            if (this.zzh != null) {
                JSONArray jSONArray = new JSONArray();
                int i2 = 0;
                while (true) {
                    long[] jArr = this.zzh;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    jSONArray.put(i2, jArr[i2]);
                    i2++;
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            jSONObject.putOpt("customData", this.zzi);
            jSONObject.put("requestId", this.zzn);
            return jSONObject;
        } catch (JSONException e2) {
            zzb.e("Error transforming MediaLoadRequestData into JSONObject", e2);
            return new JSONObject();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        String str;
        JSONObject jSONObject = this.zzi;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zza = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMediaInfo(), i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getQueueData(), i2, false);
        SafeParcelWriter.writeBooleanObject(parcel, 4, getAutoplay(), false);
        SafeParcelWriter.writeLong(parcel, 5, getCurrentTime());
        SafeParcelWriter.writeDouble(parcel, 6, getPlaybackRate());
        SafeParcelWriter.writeLongArray(parcel, 7, getActiveTrackIds(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zza, false);
        SafeParcelWriter.writeString(parcel, 9, getCredentials(), false);
        SafeParcelWriter.writeString(parcel, 10, getCredentialsType(), false);
        SafeParcelWriter.writeString(parcel, 11, this.zzl, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzm, false);
        SafeParcelWriter.writeLong(parcel, 13, getRequestId());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zzl;
    }

    public final String zzb() {
        return this.zzm;
    }

    private MediaLoadRequestData(MediaInfo mediaInfo, MediaQueueData mediaQueueData, Boolean bool, long j2, double d2, long[] jArr, JSONObject jSONObject, String str, String str2, String str3, String str4, long j3) {
        this.zzc = mediaInfo;
        this.zzd = mediaQueueData;
        this.zze = bool;
        this.zzf = j2;
        this.zzg = d2;
        this.zzh = jArr;
        this.zzi = jSONObject;
        this.zzj = str;
        this.zzk = str2;
        this.zzl = str3;
        this.zzm = str4;
        this.zzn = j3;
    }
}
