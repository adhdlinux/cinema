package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: b */
        public RatingCompat[] newArray(int i2) {
            return new RatingCompat[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final int f9750b;

    /* renamed from: c  reason: collision with root package name */
    private final float f9751c;

    RatingCompat(int i2, float f2) {
        this.f9750b = i2;
        this.f9751c = f2;
    }

    public int describeContents() {
        return this.f9750b;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f9750b);
        sb.append(" rating=");
        float f2 = this.f9751c;
        if (f2 < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f2);
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f9750b);
        parcel.writeFloat(this.f9751c);
    }
}
