package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "EqualizerSettingsCreator")
@SafeParcelable.Reserved({1})
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    @SafeParcelable.Field(getter = "getLowShelf", id = 2)
    private final zzat zza;
    @SafeParcelable.Field(getter = "getHighShelf", id = 3)
    private final zzat zzb;

    @SafeParcelable.Constructor
    public zzav(@SafeParcelable.Param(id = 2) zzat zzat, @SafeParcelable.Param(id = 3) zzat zzat2) {
        this.zza = zzat;
        this.zzb = zzat2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzav = (zzav) obj;
        if (!CastUtils.zze(this.zza, zzav.zza) || !CastUtils.zze(this.zzb, zzav.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
