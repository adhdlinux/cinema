package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzck implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel2, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 5:
                    d2 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 6:
                    d3 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 7:
                    d4 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 8:
                    jArr = SafeParcelReader.createLongArray(parcel2, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaQueueItem(mediaInfo, i2, z2, d2, d3, d4, jArr, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new MediaQueueItem[i2];
    }
}
