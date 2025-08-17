package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;

public final class DeviceInfo implements Bundleable {

    /* renamed from: e  reason: collision with root package name */
    public static final DeviceInfo f22883e = new DeviceInfo(0, 0, 0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f22884f = Util.u0(0);

    /* renamed from: g  reason: collision with root package name */
    private static final String f22885g = Util.u0(1);

    /* renamed from: h  reason: collision with root package name */
    private static final String f22886h = Util.u0(2);

    /* renamed from: i  reason: collision with root package name */
    public static final Bundleable.Creator<DeviceInfo> f22887i = new d();

    /* renamed from: b  reason: collision with root package name */
    public final int f22888b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22889c;

    /* renamed from: d  reason: collision with root package name */
    public final int f22890d;

    public DeviceInfo(int i2, int i3, int i4) {
        this.f22888b = i2;
        this.f22889c = i3;
        this.f22890d = i4;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DeviceInfo b(Bundle bundle) {
        return new DeviceInfo(bundle.getInt(f22884f, 0), bundle.getInt(f22885g, 0), bundle.getInt(f22886h, 0));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (this.f22888b == deviceInfo.f22888b && this.f22889c == deviceInfo.f22889c && this.f22890d == deviceInfo.f22890d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f22888b) * 31) + this.f22889c) * 31) + this.f22890d;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f22884f, this.f22888b);
        bundle.putInt(f22885g, this.f22889c);
        bundle.putInt(f22886h, this.f22890d);
        return bundle;
    }
}
