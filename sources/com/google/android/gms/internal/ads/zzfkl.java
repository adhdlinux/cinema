package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzfkl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfkl> CREATOR = new zzfkm();
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzaon zzb = null;
    private byte[] zzc;

    @SafeParcelable.Constructor
    zzfkl(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i2;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzaon zzaon = this.zzb;
        if (zzaon == null && this.zzc != null) {
            return;
        }
        if (zzaon != null && this.zzc == null) {
            return;
        }
        if (zzaon != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zzaon == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzax();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzaon zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzaon.zze(this.zzc, zzgoy.zza());
                this.zzc = null;
            } catch (zzgpy | NullPointerException e2) {
                throw new IllegalStateException(e2);
            }
        }
        zzb();
        return this.zzb;
    }
}
