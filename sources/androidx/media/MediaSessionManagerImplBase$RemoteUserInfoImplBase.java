package androidx.media;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;

class MediaSessionManagerImplBase$RemoteUserInfoImplBase implements MediaSessionManager$RemoteUserInfoImpl {

    /* renamed from: a  reason: collision with root package name */
    private String f3851a;

    /* renamed from: b  reason: collision with root package name */
    private int f3852b;

    /* renamed from: c  reason: collision with root package name */
    private int f3853c;

    MediaSessionManagerImplBase$RemoteUserInfoImplBase(String str, int i2, int i3) {
        this.f3851a = str;
        this.f3852b = i2;
        this.f3853c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManagerImplBase$RemoteUserInfoImplBase)) {
            return false;
        }
        MediaSessionManagerImplBase$RemoteUserInfoImplBase mediaSessionManagerImplBase$RemoteUserInfoImplBase = (MediaSessionManagerImplBase$RemoteUserInfoImplBase) obj;
        if (this.f3852b < 0 || mediaSessionManagerImplBase$RemoteUserInfoImplBase.f3852b < 0) {
            if (!TextUtils.equals(this.f3851a, mediaSessionManagerImplBase$RemoteUserInfoImplBase.f3851a) || this.f3853c != mediaSessionManagerImplBase$RemoteUserInfoImplBase.f3853c) {
                return false;
            }
            return true;
        } else if (TextUtils.equals(this.f3851a, mediaSessionManagerImplBase$RemoteUserInfoImplBase.f3851a) && this.f3852b == mediaSessionManagerImplBase$RemoteUserInfoImplBase.f3852b && this.f3853c == mediaSessionManagerImplBase$RemoteUserInfoImplBase.f3853c) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return ObjectsCompat.b(this.f3851a, Integer.valueOf(this.f3853c));
    }
}
