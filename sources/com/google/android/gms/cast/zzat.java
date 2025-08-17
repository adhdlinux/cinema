package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "EqualizerBandSettingsCreator")
@SafeParcelable.Reserved({1})
public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzat> CREATOR = new zzau();
    @SafeParcelable.Field(getter = "getFrequency", id = 2)
    private final float zza;
    @SafeParcelable.Field(getter = "getQFactor", id = 3)
    private final float zzb;
    @SafeParcelable.Field(getter = "getGainDb", id = 4)
    private final float zzc;

    @SafeParcelable.Constructor
    public zzat(@SafeParcelable.Param(id = 2) float f2, @SafeParcelable.Param(id = 3) float f3, @SafeParcelable.Param(id = 4) float f4) {
        this.zza = f2;
        this.zzb = f3;
        this.zzc = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzat = (zzat) obj;
        if (this.zza == zzat.zza && this.zzb == zzat.zzb && this.zzc == zzat.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zza), Float.valueOf(this.zzb), Float.valueOf(this.zzc));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.zza);
        SafeParcelWriter.writeFloat(parcel, 3, this.zzb);
        SafeParcelWriter.writeFloat(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
