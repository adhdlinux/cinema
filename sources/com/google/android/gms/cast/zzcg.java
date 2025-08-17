package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzcg implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d2 = 0.0d;
        String str = null;
        ArrayList<MediaMetadata> arrayList = null;
        ArrayList<WebImage> arrayList2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 4) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, MediaMetadata.CREATOR);
            } else if (fieldId == 5) {
                arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, WebImage.CREATOR);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                d2 = SafeParcelReader.readDouble(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MediaQueueContainerMetadata(i2, str, arrayList, arrayList2, d2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new MediaQueueContainerMetadata[i2];
    }
}
