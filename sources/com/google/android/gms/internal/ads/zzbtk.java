package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbtk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbtk> CREATOR = new zzbtl();
    @SafeParcelable.Field(id = 2)
    public final boolean zza;
    @SafeParcelable.Field(id = 3)
    public final List zzb;

    public zzbtk() {
        this(false, Collections.emptyList());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zza);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzbtk(@SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) List list) {
        this.zza = z2;
        this.zzb = list;
    }
}
