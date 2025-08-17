package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class zzfn implements zzby {
    public static final Parcelable.Creator<zzfn> CREATOR = new zzfl();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* synthetic */ zzfn(Parcel parcel, zzfm zzfm) {
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzfn(String str, byte[] bArr, int i2, int i3) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfn.class == obj.getClass()) {
            zzfn zzfn = (zzfn) obj;
            if (!this.zza.equals(zzfn.zza) || !Arrays.equals(this.zzb, zzfn.zzb) || this.zzc != zzfn.zzc || this.zzd != zzfn.zzd) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        String str;
        if (this.zzd == 23) {
            str = Float.toString(ByteBuffer.wrap(this.zzb).getFloat());
        } else {
            byte[] bArr = this.zzb;
            int length = bArr.length;
            StringBuilder sb = new StringBuilder(length + length);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
                sb.append(Character.forDigit(bArr[i2] & 15, 16));
            }
            str = sb.toString();
        }
        String str2 = this.zza;
        return "mdta: key=" + str2 + ", value=" + str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}
