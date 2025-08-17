package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

public final class DeviceInfo {

    /* renamed from: e  reason: collision with root package name */
    public static final DeviceInfo f3957e = new Builder(0).e();

    /* renamed from: f  reason: collision with root package name */
    private static final String f3958f = Util.B0(0);

    /* renamed from: g  reason: collision with root package name */
    private static final String f3959g = Util.B0(1);

    /* renamed from: h  reason: collision with root package name */
    private static final String f3960h = Util.B0(2);

    /* renamed from: i  reason: collision with root package name */
    private static final String f3961i = Util.B0(3);

    /* renamed from: a  reason: collision with root package name */
    public final int f3962a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3963b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3964c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3965d;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f3966a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f3967b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f3968c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f3969d;

        public Builder(int i2) {
            this.f3966a = i2;
        }

        public DeviceInfo e() {
            boolean z2;
            if (this.f3967b <= this.f3968c) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            return new DeviceInfo(this);
        }

        public Builder f(int i2) {
            this.f3968c = i2;
            return this;
        }

        public Builder g(int i2) {
            this.f3967b = i2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (this.f3962a == deviceInfo.f3962a && this.f3963b == deviceInfo.f3963b && this.f3964c == deviceInfo.f3964c && Util.c(this.f3965d, deviceInfo.f3965d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3 = (((((527 + this.f3962a) * 31) + this.f3963b) * 31) + this.f3964c) * 31;
        String str = this.f3965d;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        return i3 + i2;
    }

    private DeviceInfo(Builder builder) {
        this.f3962a = builder.f3966a;
        this.f3963b = builder.f3967b;
        this.f3964c = builder.f3968c;
        this.f3965d = builder.f3969d;
    }
}
