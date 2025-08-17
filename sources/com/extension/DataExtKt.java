package com.extension;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.Data;
import kotlin.jvm.internal.Intrinsics;

public final class DataExtKt {
    public static final Data.Builder a(Data.Builder builder, String str, Parcelable parcelable) {
        Intrinsics.f(builder, "<this>");
        Intrinsics.f(str, "key");
        Intrinsics.f(parcelable, "parcelable");
        Parcel obtain = Parcel.obtain();
        Intrinsics.e(obtain, "obtain(...)");
        try {
            parcelable.writeToParcel(obtain, 0);
            builder.e(str, obtain.marshall());
            return builder;
        } finally {
            obtain.recycle();
        }
    }
}
