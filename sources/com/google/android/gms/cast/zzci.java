package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzci implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        MediaQueueContainerMetadata mediaQueueContainerMetadata = null;
        ArrayList<MediaQueueItem> arrayList = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    mediaQueueContainerMetadata = (MediaQueueContainerMetadata) SafeParcelReader.createParcelable(parcel2, readHeader, MediaQueueContainerMetadata.CREATOR);
                    break;
                case 7:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, MediaQueueItem.CREATOR);
                    break;
                case 9:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 11:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaQueueData(str, str2, i2, str3, mediaQueueContainerMetadata, i3, arrayList, i4, j2, z2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new MediaQueueData[i2];
    }
}
