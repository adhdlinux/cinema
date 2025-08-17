package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: b */
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<FragmentState> f3463b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<String> f3464c;

    /* renamed from: d  reason: collision with root package name */
    BackStackState[] f3465d;

    /* renamed from: e  reason: collision with root package name */
    int f3466e;

    /* renamed from: f  reason: collision with root package name */
    String f3467f = null;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<String> f3468g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<Bundle> f3469h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f3470i;

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f3463b);
        parcel.writeStringList(this.f3464c);
        parcel.writeTypedArray(this.f3465d, i2);
        parcel.writeInt(this.f3466e);
        parcel.writeString(this.f3467f);
        parcel.writeStringList(this.f3468g);
        parcel.writeTypedList(this.f3469h);
        parcel.writeTypedList(this.f3470i);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f3463b = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f3464c = parcel.createStringArrayList();
        this.f3465d = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f3466e = parcel.readInt();
        this.f3467f = parcel.readString();
        this.f3468g = parcel.createStringArrayList();
        this.f3469h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f3470i = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
