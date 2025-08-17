package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b */
        public ParcelImpl[] newArray(int i2) {
            return new ParcelImpl[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final VersionedParcelable f11926b;

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.f11926b = versionedParcelable;
    }

    public <T extends VersionedParcelable> T b() {
        return this.f11926b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        new VersionedParcelParcel(parcel).L(this.f11926b);
    }

    protected ParcelImpl(Parcel parcel) {
        this.f11926b = new VersionedParcelParcel(parcel).u();
    }
}
