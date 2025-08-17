package com.startapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.AnimationUtils;

public abstract class d4 implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public float f34337a;

    /* renamed from: b  reason: collision with root package name */
    public float f34338b;

    /* renamed from: c  reason: collision with root package name */
    public float f34339c = Float.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public float f34340d = -3.4028235E38f;

    /* renamed from: e  reason: collision with root package name */
    public long f34341e = 0;

    public d4() {
    }

    public String toString() {
        return "Position: [" + this.f34337a + "], Velocity:[" + this.f34338b + "], MaxPos: [" + this.f34339c + "], mMinPos: [" + this.f34340d + "] LastTime:[" + this.f34341e + "]";
    }

    public d4(Parcel parcel) {
        this.f34337a = parcel.readFloat();
        this.f34338b = parcel.readFloat();
        this.f34339c = parcel.readFloat();
        this.f34340d = parcel.readFloat();
        this.f34341e = AnimationUtils.currentAnimationTimeMillis();
    }
}
