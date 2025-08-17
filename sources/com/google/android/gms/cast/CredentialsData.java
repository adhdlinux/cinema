package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "CredentialsDataCreator")
public class CredentialsData extends AbstractSafeParcelable {
    @KeepForSdk
    public static final Parcelable.Creator<CredentialsData> CREATOR = new zzas();
    public static final String CREDENTIALS_TYPE_ANDROID = "android";
    public static final String CREDENTIALS_TYPE_CLOUD = "cloud";
    public static final String CREDENTIALS_TYPE_IOS = "ios";
    public static final String CREDENTIALS_TYPE_WEB = "web";
    @SafeParcelable.Field(getter = "getCredentials", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getCredentialsType", id = 2)
    private final String zzb;

    public static class Builder {
        private String zza;
        private String zzb = "android";

        public CredentialsData build() {
            return new CredentialsData(this.zza, this.zzb);
        }

        public Builder setCredentials(String str) {
            this.zza = str;
            return this;
        }

        public Builder setCredentialsType(String str) {
            this.zzb = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CredentialsData(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @KeepForSdk
    public static CredentialsData fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new CredentialsData(CastUtils.optStringOrNull(jSONObject, "credentials"), CastUtils.optStringOrNull(jSONObject, "credentialsType"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CredentialsData)) {
            return false;
        }
        CredentialsData credentialsData = (CredentialsData) obj;
        if (!Objects.equal(this.zza, credentialsData.zza) || !Objects.equal(this.zzb, credentialsData.zzb)) {
            return false;
        }
        return true;
    }

    public String getCredentials() {
        return this.zza;
    }

    public String getCredentialsType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getCredentials(), false);
        SafeParcelWriter.writeString(parcel, 2, getCredentialsType(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
