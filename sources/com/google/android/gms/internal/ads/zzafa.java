package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzafa implements zzby {
    public static final Parcelable.Creator<zzafa> CREATOR = new zzaey();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzafa(long j2, long j3, long j4, long j5, long j6) {
        this.zza = j2;
        this.zzb = j3;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = j6;
    }

    /* synthetic */ zzafa(Parcel parcel, zzaez zzaez) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafa.class == obj.getClass()) {
            zzafa zzafa = (zzafa) obj;
            return this.zza == zzafa.zza && this.zzb == zzafa.zzb && this.zzc == zzafa.zzc && this.zzd == zzafa.zzd && this.zze == zzafa.zze;
        }
    }

    public final int hashCode() {
        long j2 = this.zza;
        long j3 = j2 ^ (j2 >>> 32);
        long j4 = this.zzb;
        long j5 = j4 ^ (j4 >>> 32);
        long j6 = this.zzc;
        long j7 = j6 ^ (j6 >>> 32);
        long j8 = this.zzd;
        long j9 = j8 ^ (j8 >>> 32);
        long j10 = this.zze;
        return ((((((((((int) j3) + 527) * 31) + ((int) j5)) * 31) + ((int) j7)) * 31) + ((int) j9)) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        long j2 = this.zza;
        long j3 = this.zzb;
        long j4 = this.zzc;
        long j5 = this.zzd;
        long j6 = this.zze;
        return "Motion photo metadata: photoStartPosition=" + j2 + ", photoSize=" + j3 + ", photoPresentationTimestampUs=" + j4 + ", videoStartPosition=" + j5 + ", videoSize=" + j6;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}
