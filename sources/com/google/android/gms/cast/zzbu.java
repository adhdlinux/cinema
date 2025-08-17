package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "JoinOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zzbu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbu> CREATOR = new zzbv();
    @SafeParcelable.Field(getter = "getConnectionType", id = 2)
    private final int zza;

    public zzbu() {
        this.zza = 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbu) && this.zza == ((zzbu) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza));
    }

    public final String toString() {
        int i2 = this.zza;
        return String.format("joinOptions(connectionType=%s)", new Object[]{i2 != 0 ? i2 != 2 ? "UNKNOWN" : "INVISIBLE" : "STRONG"});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzbu(@SafeParcelable.Param(id = 2) int i2) {
        this.zza = i2;
    }
}
