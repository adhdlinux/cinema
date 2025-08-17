package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() {
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public int f9728b;

    /* renamed from: c  reason: collision with root package name */
    public int f9729c;

    /* renamed from: d  reason: collision with root package name */
    public int f9730d;

    /* renamed from: e  reason: collision with root package name */
    public int f9731e;

    /* renamed from: f  reason: collision with root package name */
    public int f9732f;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f9728b = parcel.readInt();
        this.f9730d = parcel.readInt();
        this.f9731e = parcel.readInt();
        this.f9732f = parcel.readInt();
        this.f9729c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f9728b);
        parcel.writeInt(this.f9730d);
        parcel.writeInt(this.f9731e);
        parcel.writeInt(this.f9732f);
        parcel.writeInt(this.f9729c);
    }
}
