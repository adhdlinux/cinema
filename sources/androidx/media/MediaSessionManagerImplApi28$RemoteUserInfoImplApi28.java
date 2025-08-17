package androidx.media;

import android.media.session.MediaSessionManager;

final class MediaSessionManagerImplApi28$RemoteUserInfoImplApi28 extends MediaSessionManagerImplBase$RemoteUserInfoImplBase {

    /* renamed from: d  reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f3850d;

    MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(String str, int i2, int i3) {
        super(str, i2, i3);
        this.f3850d = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
    }

    static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getPackageName();
    }

    MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        this.f3850d = remoteUserInfo;
    }
}
