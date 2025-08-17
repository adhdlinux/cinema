package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final int[] f3267b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<String> f3268c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f3269d;

    /* renamed from: e  reason: collision with root package name */
    final int[] f3270e;

    /* renamed from: f  reason: collision with root package name */
    final int f3271f;

    /* renamed from: g  reason: collision with root package name */
    final String f3272g;

    /* renamed from: h  reason: collision with root package name */
    final int f3273h;

    /* renamed from: i  reason: collision with root package name */
    final int f3274i;

    /* renamed from: j  reason: collision with root package name */
    final CharSequence f3275j;

    /* renamed from: k  reason: collision with root package name */
    final int f3276k;

    /* renamed from: l  reason: collision with root package name */
    final CharSequence f3277l;

    /* renamed from: m  reason: collision with root package name */
    final ArrayList<String> f3278m;

    /* renamed from: n  reason: collision with root package name */
    final ArrayList<String> f3279n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f3280o;

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.f3513c.size();
        this.f3267b = new int[(size * 5)];
        if (backStackRecord.f3519i) {
            this.f3268c = new ArrayList<>(size);
            this.f3269d = new int[size];
            this.f3270e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                FragmentTransaction.Op op = backStackRecord.f3513c.get(i2);
                int i4 = i3 + 1;
                this.f3267b[i3] = op.f3530a;
                ArrayList<String> arrayList = this.f3268c;
                Fragment fragment = op.f3531b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f3267b;
                int i5 = i4 + 1;
                iArr[i4] = op.f3532c;
                int i6 = i5 + 1;
                iArr[i5] = op.f3533d;
                int i7 = i6 + 1;
                iArr[i6] = op.f3534e;
                iArr[i7] = op.f3535f;
                this.f3269d[i2] = op.f3536g.ordinal();
                this.f3270e[i2] = op.f3537h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f3271f = backStackRecord.f3518h;
            this.f3272g = backStackRecord.f3521k;
            this.f3273h = backStackRecord.f3266v;
            this.f3274i = backStackRecord.f3522l;
            this.f3275j = backStackRecord.f3523m;
            this.f3276k = backStackRecord.f3524n;
            this.f3277l = backStackRecord.f3525o;
            this.f3278m = backStackRecord.f3526p;
            this.f3279n = backStackRecord.f3527q;
            this.f3280o = backStackRecord.f3528r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackRecord b(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f3267b.length) {
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i4 = i2 + 1;
            op.f3530a = this.f3267b[i2];
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i3 + " base fragment #" + this.f3267b[i4]);
            }
            String str = this.f3268c.get(i3);
            if (str != null) {
                op.f3531b = fragmentManager.g0(str);
            } else {
                op.f3531b = null;
            }
            op.f3536g = Lifecycle.State.values()[this.f3269d[i3]];
            op.f3537h = Lifecycle.State.values()[this.f3270e[i3]];
            int[] iArr = this.f3267b;
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            op.f3532c = i6;
            int i7 = i5 + 1;
            int i8 = iArr[i5];
            op.f3533d = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            op.f3534e = i10;
            int i11 = iArr[i9];
            op.f3535f = i11;
            backStackRecord.f3514d = i6;
            backStackRecord.f3515e = i8;
            backStackRecord.f3516f = i10;
            backStackRecord.f3517g = i11;
            backStackRecord.f(op);
            i3++;
            i2 = i9 + 1;
        }
        backStackRecord.f3518h = this.f3271f;
        backStackRecord.f3521k = this.f3272g;
        backStackRecord.f3266v = this.f3273h;
        backStackRecord.f3519i = true;
        backStackRecord.f3522l = this.f3274i;
        backStackRecord.f3523m = this.f3275j;
        backStackRecord.f3524n = this.f3276k;
        backStackRecord.f3525o = this.f3277l;
        backStackRecord.f3526p = this.f3278m;
        backStackRecord.f3527q = this.f3279n;
        backStackRecord.f3528r = this.f3280o;
        backStackRecord.v(1);
        return backStackRecord;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f3267b);
        parcel.writeStringList(this.f3268c);
        parcel.writeIntArray(this.f3269d);
        parcel.writeIntArray(this.f3270e);
        parcel.writeInt(this.f3271f);
        parcel.writeString(this.f3272g);
        parcel.writeInt(this.f3273h);
        parcel.writeInt(this.f3274i);
        TextUtils.writeToParcel(this.f3275j, parcel, 0);
        parcel.writeInt(this.f3276k);
        TextUtils.writeToParcel(this.f3277l, parcel, 0);
        parcel.writeStringList(this.f3278m);
        parcel.writeStringList(this.f3279n);
        parcel.writeInt(this.f3280o ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f3267b = parcel.createIntArray();
        this.f3268c = parcel.createStringArrayList();
        this.f3269d = parcel.createIntArray();
        this.f3270e = parcel.createIntArray();
        this.f3271f = parcel.readInt();
        this.f3272g = parcel.readString();
        this.f3273h = parcel.readInt();
        this.f3274i = parcel.readInt();
        this.f3275j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3276k = parcel.readInt();
        this.f3277l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3278m = parcel.createStringArrayList();
        this.f3279n = parcel.createStringArrayList();
        this.f3280o = parcel.readInt() != 0;
    }
}
