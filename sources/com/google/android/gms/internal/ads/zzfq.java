package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzfq implements zzby {
    public static final Parcelable.Creator<zzfq> CREATOR = new zzfo();
    public final float zza;
    public final float zzb;

    public zzfq(float f2, float f3) {
        boolean z2 = false;
        if (f2 >= -90.0f && f2 <= 90.0f && f3 >= -180.0f && f3 <= 180.0f) {
            z2 = true;
        }
        zzdy.zze(z2, "Invalid latitude or longitude");
        this.zza = f2;
        this.zzb = f3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfq.class == obj.getClass()) {
            zzfq zzfq = (zzfq) obj;
            return this.zza == zzfq.zza && this.zzb == zzfq.zzb;
        }
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + Float.valueOf(this.zzb).hashCode();
    }

    public final String toString() {
        float f2 = this.zza;
        float f3 = this.zzb;
        return "xyz: latitude=" + f2 + ", longitude=" + f3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.zza);
        parcel.writeFloat(this.zzb);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }

    /* synthetic */ zzfq(Parcel parcel, zzfp zzfp) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readFloat();
    }
}
