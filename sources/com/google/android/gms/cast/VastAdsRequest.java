package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "VastAdsRequestCreator")
@SafeParcelable.Reserved({1})
public class VastAdsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VastAdsRequest> CREATOR = new zzdt();
    @SafeParcelable.Field(getter = "getAdTagUrl", id = 2)
    private final String zza;
    @SafeParcelable.Field(getter = "getAdsResponse", id = 3)
    private final String zzb;

    public static class Builder {
        private String zza;
        private String zzb;

        public VastAdsRequest build() {
            return new VastAdsRequest(this.zza, this.zzb);
        }

        public Builder setAdTagUrl(String str) {
            this.zza = str;
            return this;
        }

        public Builder setAdsResponse(String str) {
            this.zzb = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    VastAdsRequest(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static VastAdsRequest fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new VastAdsRequest(CastUtils.optStringOrNull(jSONObject, "adTagUrl"), CastUtils.optStringOrNull(jSONObject, "adsResponse"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastAdsRequest)) {
            return false;
        }
        VastAdsRequest vastAdsRequest = (VastAdsRequest) obj;
        if (!CastUtils.zze(this.zza, vastAdsRequest.zza) || !CastUtils.zze(this.zzb, vastAdsRequest.zzb)) {
            return false;
        }
        return true;
    }

    public String getAdTagUrl() {
        return this.zza;
    }

    public String getAdsResponse() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAdTagUrl(), false);
        SafeParcelWriter.writeString(parcel, 3, getAdsResponse(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.zza;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.zzb;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
