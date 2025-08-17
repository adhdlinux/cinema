package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final String f3479b;

    /* renamed from: c  reason: collision with root package name */
    final String f3480c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f3481d;

    /* renamed from: e  reason: collision with root package name */
    final int f3482e;

    /* renamed from: f  reason: collision with root package name */
    final int f3483f;

    /* renamed from: g  reason: collision with root package name */
    final String f3484g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f3485h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f3486i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f3487j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f3488k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f3489l;

    /* renamed from: m  reason: collision with root package name */
    final int f3490m;

    /* renamed from: n  reason: collision with root package name */
    Bundle f3491n;

    FragmentState(Fragment fragment) {
        this.f3479b = fragment.getClass().getName();
        this.f3480c = fragment.mWho;
        this.f3481d = fragment.mFromLayout;
        this.f3482e = fragment.mFragmentId;
        this.f3483f = fragment.mContainerId;
        this.f3484g = fragment.mTag;
        this.f3485h = fragment.mRetainInstance;
        this.f3486i = fragment.mRemoving;
        this.f3487j = fragment.mDetached;
        this.f3488k = fragment.mArguments;
        this.f3489l = fragment.mHidden;
        this.f3490m = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3479b);
        sb.append(" (");
        sb.append(this.f3480c);
        sb.append(")}:");
        if (this.f3481d) {
            sb.append(" fromLayout");
        }
        if (this.f3483f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3483f));
        }
        String str = this.f3484g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f3484g);
        }
        if (this.f3485h) {
            sb.append(" retainInstance");
        }
        if (this.f3486i) {
            sb.append(" removing");
        }
        if (this.f3487j) {
            sb.append(" detached");
        }
        if (this.f3489l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3479b);
        parcel.writeString(this.f3480c);
        parcel.writeInt(this.f3481d ? 1 : 0);
        parcel.writeInt(this.f3482e);
        parcel.writeInt(this.f3483f);
        parcel.writeString(this.f3484g);
        parcel.writeInt(this.f3485h ? 1 : 0);
        parcel.writeInt(this.f3486i ? 1 : 0);
        parcel.writeInt(this.f3487j ? 1 : 0);
        parcel.writeBundle(this.f3488k);
        parcel.writeInt(this.f3489l ? 1 : 0);
        parcel.writeBundle(this.f3491n);
        parcel.writeInt(this.f3490m);
    }

    FragmentState(Parcel parcel) {
        this.f3479b = parcel.readString();
        this.f3480c = parcel.readString();
        boolean z2 = true;
        this.f3481d = parcel.readInt() != 0;
        this.f3482e = parcel.readInt();
        this.f3483f = parcel.readInt();
        this.f3484g = parcel.readString();
        this.f3485h = parcel.readInt() != 0;
        this.f3486i = parcel.readInt() != 0;
        this.f3487j = parcel.readInt() != 0;
        this.f3488k = parcel.readBundle();
        this.f3489l = parcel.readInt() == 0 ? false : z2;
        this.f3491n = parcel.readBundle();
        this.f3490m = parcel.readInt();
    }
}
