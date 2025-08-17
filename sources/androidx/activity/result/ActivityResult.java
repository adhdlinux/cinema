package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
        /* renamed from: a */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: b */
        public ActivityResult[] newArray(int i2) {
            return new ActivityResult[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final int f55b;

    /* renamed from: c  reason: collision with root package name */
    private final Intent f56c;

    public ActivityResult(int i2, Intent intent) {
        this.f55b = i2;
        this.f56c = intent;
    }

    public static String d(int i2) {
        return i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent b() {
        return this.f56c;
    }

    public int c() {
        return this.f55b;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + d(this.f55b) + ", data=" + this.f56c + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        parcel.writeInt(this.f55b);
        if (this.f56c == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        parcel.writeInt(i3);
        Intent intent = this.f56c;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    ActivityResult(Parcel parcel) {
        this.f55b = parcel.readInt();
        this.f56c = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
