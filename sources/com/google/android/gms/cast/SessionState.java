package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "SessionStateCreator")
@SafeParcelable.Reserved({1})
public class SessionState extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SessionState> CREATOR = new zzdr();
    @SafeParcelable.Field(id = 3)
    String zza;
    @SafeParcelable.Field(getter = "getLoadRequestData", id = 2)
    private final MediaLoadRequestData zzb;
    private final JSONObject zzc;

    public static class Builder {
        private MediaLoadRequestData zza;
        private JSONObject zzb;

        public SessionState build() {
            return new SessionState(this.zza, this.zzb);
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzb = jSONObject;
            return this;
        }

        public Builder setLoadRequestData(MediaLoadRequestData mediaLoadRequestData) {
            this.zza = mediaLoadRequestData;
            return this;
        }
    }

    SessionState(MediaLoadRequestData mediaLoadRequestData, JSONObject jSONObject) {
        this.zzb = mediaLoadRequestData;
        this.zzc = jSONObject;
    }

    @KeepForSdk
    public static SessionState fromJson(JSONObject jSONObject) {
        MediaLoadRequestData mediaLoadRequestData;
        JSONObject optJSONObject = jSONObject.optJSONObject("loadRequestData");
        if (optJSONObject != null) {
            mediaLoadRequestData = MediaLoadRequestData.fromJson(optJSONObject);
        } else {
            mediaLoadRequestData = null;
        }
        return new SessionState(mediaLoadRequestData, jSONObject.optJSONObject("customData"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionState)) {
            return false;
        }
        SessionState sessionState = (SessionState) obj;
        if (!JsonUtils.areJsonValuesEquivalent(this.zzc, sessionState.zzc)) {
            return false;
        }
        return Objects.equal(this.zzb, sessionState.zzb);
    }

    public JSONObject getCustomData() {
        return this.zzc;
    }

    public MediaLoadRequestData getLoadRequestData() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, String.valueOf(this.zzc));
    }

    @KeepForSdk
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            MediaLoadRequestData mediaLoadRequestData = this.zzb;
            if (mediaLoadRequestData != null) {
                jSONObject.put("loadRequestData", mediaLoadRequestData.toJson());
            }
            jSONObject.put("customData", this.zzc);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        String str;
        JSONObject jSONObject = this.zzc;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zza = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getLoadRequestData(), i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
