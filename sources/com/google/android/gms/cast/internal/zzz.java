package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CastEurekaInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    @SafeParcelable.Field(getter = "getVersion", id = 2)
    private final int zza;
    @SafeParcelable.Field(getter = "getMultizoneSupported", id = 3)
    private final boolean zzb;
    @SafeParcelable.Field(getter = "getVirtualRemoteSupported", id = 4)
    private final boolean zzc;

    @SafeParcelable.Constructor
    zzz(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.zza = i2;
        this.zzb = z2;
        this.zzc = z3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzz)) {
            return false;
        }
        zzz zzz = (zzz) obj;
        if (this.zza == zzz.zza && this.zzb == zzz.zzb && this.zzc == zzz.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
