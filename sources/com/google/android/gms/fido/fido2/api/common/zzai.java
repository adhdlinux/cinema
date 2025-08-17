package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PrfExtensionCreator")
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    @SafeParcelable.Field(getter = "getEvaluationPoints", id = 1)
    private final byte[][] zza;

    @SafeParcelable.Constructor
    public zzai(@SafeParcelable.Param(id = 1) byte[][] bArr) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (bArr != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (1 != ((bArr.length & 1) ^ 1)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            if (i2 == 0 || bArr[i2] != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4);
            int i3 = i2 + 1;
            if (bArr[i3] != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            int length = bArr[i3].length;
            if (length == 32 || length == 64) {
                z6 = true;
            } else {
                z6 = false;
            }
            Preconditions.checkArgument(z6);
        }
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        return Arrays.deepEquals(this.zza, ((zzai) obj).zza);
    }

    public final int hashCode() {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 ^= Objects.hashCode(objArr[i3]);
        }
        return i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArrayArray(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
