package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() {
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f2996c;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public AbsSavedState[] newArray(int i2) {
            return new AbsSavedState[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final AbsSavedState f2996c = new AbsSavedState() {
    };

    /* renamed from: b  reason: collision with root package name */
    private final Parcelable f2997b;

    public final Parcelable b() {
        return this.f2997b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f2997b, i2);
    }

    private AbsSavedState() {
        this.f2997b = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f2997b = parcelable == f2996c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f2997b = readParcelable == null ? f2996c : readParcelable;
    }
}
