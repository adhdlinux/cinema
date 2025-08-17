package androidx.media3.exoplayer.scheduler;

import android.os.Parcel;
import android.os.Parcelable;

public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() {
        /* renamed from: a */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        /* renamed from: b */
        public Requirements[] newArray(int i2) {
            return new Requirements[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final int f6809b;

    public Requirements(int i2) {
        this.f6809b = (i2 & 2) != 0 ? i2 | 1 : i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Requirements.class == obj.getClass() && this.f6809b == ((Requirements) obj).f6809b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6809b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6809b);
    }
}
