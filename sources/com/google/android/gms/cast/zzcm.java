package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzcm implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        ArrayList<MediaQueueItem> arrayList = null;
        AdBreakStatus adBreakStatus = null;
        VideoInfo videoInfo = null;
        MediaLiveSeekableRange mediaLiveSeekableRange = null;
        MediaQueueData mediaQueueData = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel2, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    d2 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 6:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 9:
                    j4 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 10:
                    d3 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 11:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 12:
                    jArr = SafeParcelReader.createLongArray(parcel2, readHeader);
                    break;
                case 13:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    i6 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 15:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 16:
                    i7 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 17:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, MediaQueueItem.CREATOR);
                    break;
                case 18:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    adBreakStatus = (AdBreakStatus) SafeParcelReader.createParcelable(parcel2, readHeader, AdBreakStatus.CREATOR);
                    break;
                case 20:
                    videoInfo = (VideoInfo) SafeParcelReader.createParcelable(parcel2, readHeader, VideoInfo.CREATOR);
                    break;
                case 21:
                    mediaLiveSeekableRange = (MediaLiveSeekableRange) SafeParcelReader.createParcelable(parcel2, readHeader, MediaLiveSeekableRange.CREATOR);
                    break;
                case 22:
                    mediaQueueData = (MediaQueueData) SafeParcelReader.createParcelable(parcel2, readHeader, MediaQueueData.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaStatus(mediaInfo, j2, i2, d2, i3, i4, j3, j4, d3, z2, jArr, i5, i6, str, i7, arrayList, z3, adBreakStatus, videoInfo, mediaLiveSeekableRange, mediaQueueData);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new MediaStatus[i2];
    }
}
