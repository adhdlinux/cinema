package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

public final class MediaSessionManager$RemoteUserInfo {

    /* renamed from: a  reason: collision with root package name */
    MediaSessionManager$RemoteUserInfoImpl f3849a;

    public MediaSessionManager$RemoteUserInfo(String str, int i2, int i3) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.f3849a = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(str, i2, i3);
        } else {
            this.f3849a = new MediaSessionManagerImplBase$RemoteUserInfoImplBase(str, i2, i3);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManager$RemoteUserInfo)) {
            return false;
        }
        return this.f3849a.equals(((MediaSessionManager$RemoteUserInfo) obj).f3849a);
    }

    public int hashCode() {
        return this.f3849a.hashCode();
    }

    public MediaSessionManager$RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String a2 = MediaSessionManagerImplApi28$RemoteUserInfoImplApi28.a(remoteUserInfo);
        if (a2 == null) {
            throw new NullPointerException("package shouldn't be null");
        } else if (!TextUtils.isEmpty(a2)) {
            this.f3849a = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(remoteUserInfo);
        } else {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
    }
}
