package androidx.work;

import android.app.Notification;

public final class ForegroundInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f12175a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12176b;

    /* renamed from: c  reason: collision with root package name */
    private final Notification f12177c;

    public ForegroundInfo(int i2, Notification notification, int i3) {
        this.f12175a = i2;
        this.f12177c = notification;
        this.f12176b = i3;
    }

    public int a() {
        return this.f12176b;
    }

    public Notification b() {
        return this.f12177c;
    }

    public int c() {
        return this.f12175a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.f12175a == foregroundInfo.f12175a && this.f12176b == foregroundInfo.f12176b) {
            return this.f12177c.equals(foregroundInfo.f12177c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f12175a * 31) + this.f12176b) * 31) + this.f12177c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f12175a + ", mForegroundServiceType=" + this.f12176b + ", mNotification=" + this.f12177c + '}';
    }
}
