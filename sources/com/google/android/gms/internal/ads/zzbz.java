package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class zzbz implements Parcelable {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzbx();
    public final long zza;
    private final zzby[] zzb;

    public zzbz(long j2, zzby... zzbyArr) {
        this.zza = j2;
        this.zzb = zzbyArr;
    }

    zzbz(Parcel parcel) {
        this.zzb = new zzby[parcel.readInt()];
        int i2 = 0;
        while (true) {
            zzby[] zzbyArr = this.zzb;
            if (i2 < zzbyArr.length) {
                zzbyArr[i2] = (zzby) parcel.readParcelable(zzby.class.getClassLoader());
                i2++;
            } else {
                this.zza = parcel.readLong();
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbz.class == obj.getClass()) {
            zzbz zzbz = (zzbz) obj;
            if (!Arrays.equals(this.zzb, zzbz.zzb) || this.zza != zzbz.zza) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.zza;
        return (Arrays.hashCode(this.zzb) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        String str;
        String arrays = Arrays.toString(this.zzb);
        long j2 = this.zza;
        if (j2 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j2;
        }
        return "entries=" + arrays + str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.zzb.length);
        for (zzby writeParcelable : this.zzb) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzby zzb(int i2) {
        return this.zzb[i2];
    }

    public final zzbz zzc(zzby... zzbyArr) {
        int length = zzbyArr.length;
        if (length == 0) {
            return this;
        }
        long j2 = this.zza;
        zzby[] zzbyArr2 = this.zzb;
        int i2 = zzfj.zza;
        int length2 = zzbyArr2.length;
        Object[] copyOf = Arrays.copyOf(zzbyArr2, length2 + length);
        System.arraycopy(zzbyArr, 0, copyOf, length2, length);
        return new zzbz(j2, (zzby[]) copyOf);
    }

    public final zzbz zzd(zzbz zzbz) {
        return zzbz == null ? this : zzc(zzbz.zzb);
    }

    public zzbz(List list) {
        this(-9223372036854775807L, (zzby[]) list.toArray(new zzby[0]));
    }
}
