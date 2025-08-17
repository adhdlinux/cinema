package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzaee extends zzaen {
    public static final Parcelable.Creator<zzaee> CREATOR = new zzaed();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzaen[] zze;

    zzaee(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        boolean z2 = true;
        this.zzb = parcel.readByte() != 0;
        this.zzc = parcel.readByte() == 0 ? false : z2;
        this.zzd = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.zze = new zzaen[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            this.zze[i3] = (zzaen) parcel.readParcelable(zzaen.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaee.class == obj.getClass()) {
            zzaee zzaee = (zzaee) obj;
            if (this.zzb != zzaee.zzb || this.zzc != zzaee.zzc || !zzfj.zzC(this.zza, zzaee.zza) || !Arrays.equals(this.zzd, zzaee.zzd) || !Arrays.equals(this.zze, zzaee.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (((this.zzb ? 1 : 0) + true) * 31) + (this.zzc ? 1 : 0);
        String str = this.zza;
        return (i2 * 31) + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zza);
        parcel.writeByte(this.zzb ? (byte) 1 : 0);
        parcel.writeByte(this.zzc ? (byte) 1 : 0);
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        for (zzaen writeParcelable : this.zze) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public zzaee(String str, boolean z2, boolean z3, String[] strArr, zzaen[] zzaenArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = strArr;
        this.zze = zzaenArr;
    }
}
