package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzaer extends zzaen {
    public static final Parcelable.Creator<zzaer> CREATOR = new zzaeq();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzaer(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaer.class == obj.getClass()) {
            zzaer zzaer = (zzaer) obj;
            if (this.zza == zzaer.zza && this.zzb == zzaer.zzb && this.zzc == zzaer.zzc && Arrays.equals(this.zzd, zzaer.zzd) && Arrays.equals(this.zze, zzaer.zze)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }

    zzaer(Parcel parcel) {
        super("MLLT");
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int i2 = zzfj.zza;
        this.zzd = createIntArray;
        this.zze = parcel.createIntArray();
    }
}
