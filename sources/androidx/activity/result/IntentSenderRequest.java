package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() {
        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* renamed from: b */
        public IntentSenderRequest[] newArray(int i2) {
            return new IntentSenderRequest[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final IntentSender f79b;

    /* renamed from: c  reason: collision with root package name */
    private final Intent f80c;

    /* renamed from: d  reason: collision with root package name */
    private final int f81d;

    /* renamed from: e  reason: collision with root package name */
    private final int f82e;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private IntentSender f83a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f84b;

        /* renamed from: c  reason: collision with root package name */
        private int f85c;

        /* renamed from: d  reason: collision with root package name */
        private int f86d;

        public Builder(IntentSender intentSender) {
            this.f83a = intentSender;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f83a, this.f84b, this.f85c, this.f86d);
        }

        public Builder b(Intent intent) {
            this.f84b = intent;
            return this;
        }

        public Builder c(int i2, int i3) {
            this.f86d = i2;
            this.f85c = i3;
            return this;
        }
    }

    IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.f79b = intentSender;
        this.f80c = intent;
        this.f81d = i2;
        this.f82e = i3;
    }

    public Intent b() {
        return this.f80c;
    }

    public int c() {
        return this.f81d;
    }

    public int d() {
        return this.f82e;
    }

    public int describeContents() {
        return 0;
    }

    public IntentSender e() {
        return this.f79b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f79b, i2);
        parcel.writeParcelable(this.f80c, i2);
        parcel.writeInt(this.f81d);
        parcel.writeInt(this.f82e);
    }

    IntentSenderRequest(Parcel parcel) {
        this.f79b = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f80c = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f81d = parcel.readInt();
        this.f82e = parcel.readInt();
    }
}
