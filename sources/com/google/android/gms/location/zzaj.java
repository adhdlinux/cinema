package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.Reserved({1000})
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
    @SafeParcelable.Field(getter = "getStartHour", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getStartMinute", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getEndHour", id = 3)
    private final int zzc;
    @SafeParcelable.Field(getter = "getEndMinute", id = 4)
    private final int zzd;

    @SafeParcelable.Constructor
    public zzaj(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) int i5) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = true;
        if (i2 < 0 || i2 > 23) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkState(z2, "Start hour must be in range [0, 23].");
        if (i3 < 0 || i3 > 59) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkState(z3, "Start minute must be in range [0, 59].");
        if (i4 < 0 || i4 > 23) {
            z4 = false;
        } else {
            z4 = true;
        }
        Preconditions.checkState(z4, "End hour must be in range [0, 23].");
        if (i5 < 0 || i5 > 59) {
            z5 = false;
        } else {
            z5 = true;
        }
        Preconditions.checkState(z5, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i2 + i3) + i4) + i5 <= 0 ? false : z6, "Parameters can't be all 0.");
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzaj = (zzaj) obj;
        if (this.zza == zzaj.zza && this.zzb == zzaj.zzb && this.zzc == zzaj.zzc && this.zzd == zzaj.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i2 = this.zza;
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = this.zzd;
        return "UserPreferredSleepWindow [startHour=" + i2 + ", startMinute=" + i3 + ", endHour=" + i4 + ", endMinute=" + i5 + "]";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
