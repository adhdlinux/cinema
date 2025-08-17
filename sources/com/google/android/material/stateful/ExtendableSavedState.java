package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new Parcelable.ClassLoaderCreator<ExtendableSavedState>() {
        /* renamed from: a */
        public ExtendableSavedState createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader);
        }

        /* renamed from: c */
        public ExtendableSavedState[] newArray(int i2) {
            return new ExtendableSavedState[i2];
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final SimpleArrayMap<String, Bundle> f30056d;

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f30056d + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        int size = this.f30056d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = this.f30056d.j(i3);
            bundleArr[i3] = this.f30056d.n(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f30056d = new SimpleArrayMap<>();
    }

    private ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f30056d = new SimpleArrayMap<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f30056d.put(strArr[i2], bundleArr[i2]);
        }
    }
}
