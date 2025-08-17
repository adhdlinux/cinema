package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

class FragmentTabHost$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<FragmentTabHost$SavedState> CREATOR = new Parcelable.Creator<FragmentTabHost$SavedState>() {
        /* renamed from: a */
        public FragmentTabHost$SavedState createFromParcel(Parcel parcel) {
            return new FragmentTabHost$SavedState(parcel);
        }

        /* renamed from: b */
        public FragmentTabHost$SavedState[] newArray(int i2) {
            return new FragmentTabHost$SavedState[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    String f3510b;

    FragmentTabHost$SavedState(Parcel parcel) {
        super(parcel);
        this.f3510b = parcel.readString();
    }

    public String toString() {
        return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f3510b + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.f3510b);
    }
}
