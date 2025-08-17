package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbvg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbvg> CREATOR = new zzbvh();
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @SafeParcelable.Field(id = 3)
    public final int zzb;

    @SafeParcelable.Constructor
    public zzbvg(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2) {
        this.zza = str;
        this.zzb = i2;
    }

    public static zzbvg zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzbvg(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbvg)) {
            zzbvg zzbvg = (zzbvg) obj;
            if (!Objects.equal(this.zza, zzbvg.zza) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbvg.zzb))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
