package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "RegisterRequestCreator")
@Deprecated
public class RegisterRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RegisterRequest> CREATOR = new zzg();
    public static final int U2F_V1_CHALLENGE_BYTE_LENGTH = 65;
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getProtocolVersionAsString", id = 2, type = "java.lang.String")
    private final ProtocolVersion zzb;
    @SafeParcelable.Field(getter = "getChallengeValue", id = 3)
    private final byte[] zzc;
    @SafeParcelable.Field(getter = "getAppId", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    RegisterRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) String str2) {
        this.zza = i2;
        try {
            this.zzb = ProtocolVersion.fromString(str);
            this.zzc = bArr;
            this.zzd = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static RegisterRequest parseFromJson(JSONObject jSONObject) throws JSONException {
        String str;
        String str2 = null;
        if (jSONObject.has(MediationMetaData.KEY_VERSION)) {
            str = jSONObject.getString(MediationMetaData.KEY_VERSION);
        } else {
            str = null;
        }
        try {
            ProtocolVersion fromString = ProtocolVersion.fromString(str);
            try {
                byte[] decode = Base64.decode(jSONObject.getString(ClientData.KEY_CHALLENGE), 8);
                if (jSONObject.has("appId")) {
                    str2 = jSONObject.getString("appId");
                }
                try {
                    return new RegisterRequest(fromString, decode, str2);
                } catch (IllegalArgumentException e2) {
                    throw new JSONException(e2.getMessage());
                }
            } catch (IllegalArgumentException e3) {
                throw new JSONException(e3.toString());
            }
        } catch (ProtocolVersion.UnsupportedProtocolException e4) {
            throw new JSONException(e4.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        if (!Arrays.equals(this.zzc, registerRequest.zzc) || this.zzb != registerRequest.zzb) {
            return false;
        }
        String str = this.zzd;
        if (str == null) {
            if (registerRequest.zzd != null) {
                return false;
            }
        } else if (!str.equals(registerRequest.zzd)) {
            return false;
        }
        return true;
    }

    public String getAppId() {
        return this.zzd;
    }

    public byte[] getChallengeValue() {
        return this.zzc;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.zzb;
    }

    public int getVersionCode() {
        return this.zza;
    }

    public int hashCode() {
        int i2;
        int hashCode = ((Arrays.hashCode(this.zzc) + 31) * 31) + this.zzb.hashCode();
        String str = this.zzd;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        return (hashCode * 31) + i2;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationMetaData.KEY_VERSION, this.zzb.toString());
            jSONObject.put(ClientData.KEY_CHALLENGE, Base64.encodeToString(this.zzc, 11));
            String str = this.zzd;
            if (str != null) {
                jSONObject.put("appId", str);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeString(parcel, 2, this.zzb.toString(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getChallengeValue(), false);
        SafeParcelWriter.writeString(parcel, 4, getAppId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public RegisterRequest(ProtocolVersion protocolVersion, byte[] bArr, String str) {
        boolean z2 = true;
        this.zza = 1;
        this.zzb = (ProtocolVersion) Preconditions.checkNotNull(protocolVersion);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
        if (protocolVersion == ProtocolVersion.V1) {
            Preconditions.checkArgument(bArr.length != 65 ? false : z2, "invalid challengeValue length for V1");
        }
        this.zzd = str;
    }
}
