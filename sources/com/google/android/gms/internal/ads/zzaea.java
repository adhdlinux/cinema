package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzaea extends zzaen {
    public static final Parcelable.Creator<zzaea> CREATOR = new zzadz();
    public final byte[] zza;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzaea(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzfj.zza
            r2.<init>(r0)
            byte[] r3 = r3.createByteArray()
            r2.zza = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaea.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaea.class == obj.getClass()) {
            zzaea zzaea = (zzaea) obj;
            if (!this.zzf.equals(zzaea.zzf) || !Arrays.equals(this.zza, zzaea.zza)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzf.hashCode() + 527) * 31) + Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zzf);
        parcel.writeByteArray(this.zza);
    }

    public zzaea(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }
}
