package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaErrorCreator")
@SafeParcelable.Reserved({1})
public class MediaError extends AbstractSafeParcelable implements ReflectedParcelable {
    @KeepForSdk
    public static final Parcelable.Creator<MediaError> CREATOR = new zzbx();
    public static final String ERROR_REASON_APP_ERROR = "APP_ERROR";
    public static final String ERROR_REASON_AUTHENTICATION_EXPIRED = "AUTHENTICATION_EXPIRED";
    public static final String ERROR_REASON_CONCURRENT_STREAM_LIMIT = "CONCURRENT_STREAM_LIMIT";
    public static final String ERROR_REASON_CONTENT_ALREADY_PLAYING = "CONTENT_ALREADY_PLAYING";
    public static final String ERROR_REASON_CONTENT_FILTERED = "CONTENT_FILTERED";
    public static final String ERROR_REASON_DUPLICATE_REQUEST_ID = "DUPLICATE_REQUEST_ID";
    public static final String ERROR_REASON_END_OF_QUEUE = "END_OF_QUEUE";
    public static final String ERROR_REASON_GENERIC_LOAD_ERROR = "GENERIC_LOAD_ERROR";
    public static final String ERROR_REASON_INVALID_COMMAND = "INVALID_COMMAND";
    public static final String ERROR_REASON_INVALID_MEDIA_SESSION_ID = "INVALID_MEDIA_SESSION_ID";
    public static final String ERROR_REASON_INVALID_PARAMS = "INVALID_PARAMS";
    public static final String ERROR_REASON_INVALID_REQUEST = "INVALID_REQUEST";
    public static final String ERROR_REASON_LANGUAGE_NOT_SUPPORTED = "LANGUAGE_NOT_SUPPORTED";
    public static final String ERROR_REASON_NOT_AVAILABLE_IN_REGION = "NOT_AVAILABLE_IN_REGION";
    public static final String ERROR_REASON_NOT_SUPPORTED = "NOT_SUPPORTED";
    public static final String ERROR_REASON_PARENTAL_CONTROL_RESTRICTED = "PARENTAL_CONTROL_RESTRICTED";
    public static final String ERROR_REASON_PREMIUM_ACCOUNT_REQUIRED = "PREMIUM_ACCOUNT_REQUIRED";
    public static final String ERROR_REASON_SKIP_LIMIT_REACHED = "SKIP_LIMIT_REACHED";
    public static final String ERROR_REASON_VIDEO_DEVICE_REQUIRED = "VIDEO_DEVICE_REQUIRED";
    public static final String ERROR_TYPE_ERROR = "ERROR";
    public static final String ERROR_TYPE_INVALID_PLAYER_STATE = "INVALID_PLAYER_STATE";
    public static final String ERROR_TYPE_INVALID_REQUEST = "INVALID_REQUEST";
    public static final String ERROR_TYPE_LOAD_CANCELLED = "LOAD_CANCELLED";
    public static final String ERROR_TYPE_LOAD_FAILED = "LOAD_FAILED";
    @SafeParcelable.Field(id = 6)
    String zza;
    @SafeParcelable.Field(getter = "getType", id = 2)
    private String zzb;
    @SafeParcelable.Field(getter = "getRequestId", id = 3)
    private long zzc;
    @DetailedErrorCode
    @SafeParcelable.Field(getter = "getDetailedErrorCode", id = 4)
    private final Integer zzd;
    @SafeParcelable.Field(getter = "getReason", id = 5)
    private final String zze;
    private final JSONObject zzf;

    public static class Builder {
        private Integer zza;
        private long zzb;
        private String zzc;
        private JSONObject zzd;
        private String zze = MediaError.ERROR_TYPE_ERROR;

        public MediaError build() {
            String str = this.zze;
            if (str == null) {
                str = MediaError.ERROR_TYPE_ERROR;
            }
            return new MediaError(str, this.zzb, this.zza, this.zzc, this.zzd);
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzd = jSONObject;
            return this;
        }

        public Builder setDetailedErrorCode(Integer num) {
            this.zza = num;
            return this;
        }

        public Builder setReason(String str) {
            this.zzc = str;
            return this;
        }

        @KeepForSdk
        public Builder setRequestId(long j2) {
            this.zzb = j2;
            return this;
        }

        public Builder setType(String str) {
            this.zze = str;
            return this;
        }
    }

    public @interface DetailedErrorCode {
        public static final int APP = 900;
        public static final int BREAK_CLIP_LOADING_ERROR = 901;
        public static final int BREAK_SEEK_INTERCEPTOR_ERROR = 902;
        public static final int DASH_INVALID_SEGMENT_INFO = 423;
        public static final int DASH_MANIFEST_NO_MIMETYPE = 422;
        public static final int DASH_MANIFEST_NO_PERIODS = 421;
        public static final int DASH_MANIFEST_UNKNOWN = 420;
        public static final int DASH_NETWORK = 321;
        public static final int DASH_NO_INIT = 322;
        public static final int GENERIC = 999;
        public static final int HLS_MANIFEST_MASTER = 411;
        public static final int HLS_MANIFEST_PLAYLIST = 412;
        public static final int HLS_NETWORK_INVALID_SEGMENT = 315;
        public static final int HLS_NETWORK_KEY_LOAD = 314;
        public static final int HLS_NETWORK_MASTER_PLAYLIST = 311;
        public static final int HLS_NETWORK_NO_KEY_RESPONSE = 313;
        public static final int HLS_NETWORK_PLAYLIST = 312;
        public static final int HLS_SEGMENT_PARSING = 316;
        public static final int IMAGE_ERROR = 903;
        public static final int LOAD_FAILED = 905;
        public static final int LOAD_INTERRUPTED = 904;
        public static final int MANIFEST_UNKNOWN = 400;
        public static final int MEDIAKEYS_NETWORK = 201;
        public static final int MEDIAKEYS_UNKNOWN = 200;
        public static final int MEDIAKEYS_UNSUPPORTED = 202;
        public static final int MEDIAKEYS_WEBCRYPTO = 203;
        public static final int MEDIA_ABORTED = 101;
        public static final int MEDIA_DECODE = 102;
        public static final int MEDIA_ERROR_MESSAGE = 906;
        public static final int MEDIA_NETWORK = 103;
        public static final int MEDIA_SRC_NOT_SUPPORTED = 104;
        public static final int MEDIA_UNKNOWN = 100;
        public static final int NETWORK_UNKNOWN = 300;
        public static final int SEGMENT_NETWORK = 301;
        public static final int SEGMENT_UNKNOWN = 500;
        public static final int SMOOTH_MANIFEST = 431;
        public static final int SMOOTH_NETWORK = 331;
        public static final int SMOOTH_NO_MEDIA_DATA = 332;
        public static final int SOURCE_BUFFER_FAILURE = 110;
        public static final int TEXT_UNKNOWN = 600;
    }

    @KeepForSdk
    public MediaError(String str, long j2, Integer num, String str2, JSONObject jSONObject) {
        this.zzb = str;
        this.zzc = j2;
        this.zzd = num;
        this.zze = str2;
        this.zzf = jSONObject;
    }

    public static MediaError zza(JSONObject jSONObject) {
        Integer num;
        JSONObject jSONObject2;
        String optString = jSONObject.optString("type", ERROR_TYPE_ERROR);
        long optLong = jSONObject.optLong("requestId");
        if (jSONObject.has("detailedErrorCode")) {
            num = Integer.valueOf(jSONObject.optInt("detailedErrorCode"));
        } else {
            num = null;
        }
        String optStringOrNull = CastUtils.optStringOrNull(jSONObject, "reason");
        if (jSONObject.has("customData")) {
            jSONObject2 = jSONObject.optJSONObject("customData");
        } else {
            jSONObject2 = null;
        }
        return new MediaError(optString, optLong, num, optStringOrNull, jSONObject2);
    }

    public JSONObject getCustomData() {
        return this.zzf;
    }

    public Integer getDetailedErrorCode() {
        return this.zzd;
    }

    public String getReason() {
        return this.zze;
    }

    @KeepForSdk
    public long getRequestId() {
        return this.zzc;
    }

    public String getType() {
        return this.zzb;
    }

    @KeepForSdk
    public void setRequestId(long j2) {
        this.zzc = j2;
    }

    @KeepForSdk
    public void setType(String str) {
        this.zzb = str;
    }

    @KeepForSdk
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", this.zzc);
            jSONObject.putOpt("detailedErrorCode", this.zzd);
            jSONObject.putOpt("reason", this.zze);
            jSONObject.put("customData", this.zzf);
            String str = this.zzb;
            if (str == null) {
                str = ERROR_TYPE_ERROR;
            }
            jSONObject.putOpt("type", str);
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        String str;
        JSONObject jSONObject = this.zzf;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zza = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeLong(parcel, 3, getRequestId());
        SafeParcelWriter.writeIntegerObject(parcel, 4, getDetailedErrorCode(), false);
        SafeParcelWriter.writeString(parcel, 5, getReason(), false);
        SafeParcelWriter.writeString(parcel, 6, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
