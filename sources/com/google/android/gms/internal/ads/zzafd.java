package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzafd implements zzby {
    public static final Parcelable.Creator<zzafd> CREATOR = new zzafb();
    public final float zza;
    public final int zzb;

    public zzafd(float f2, int i2) {
        this.zza = f2;
        this.zzb = i2;
    }

    /* synthetic */ zzafd(Parcel parcel, zzafc zzafc) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafd.class == obj.getClass()) {
            zzafd zzafd = (zzafd) obj;
            return this.zza == zzafd.zza && this.zzb == zzafd.zzb;
        }
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + this.zzb;
    }

    public final String toString() {
        float f2 = this.zza;
        int i2 = this.zzb;
        return "smta: captureFrameRate=" + f2 + ", svcTemporalLayerCount=" + i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}
