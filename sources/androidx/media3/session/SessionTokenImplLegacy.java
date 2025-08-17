package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionToken;
import androidx.media3.session.legacy.MediaSessionCompat;
import com.google.common.base.Objects;

final class SessionTokenImplLegacy implements SessionToken.SessionTokenImpl {

    /* renamed from: g  reason: collision with root package name */
    private static final String f9640g = Util.B0(0);

    /* renamed from: h  reason: collision with root package name */
    private static final String f9641h = Util.B0(1);

    /* renamed from: i  reason: collision with root package name */
    private static final String f9642i = Util.B0(2);

    /* renamed from: j  reason: collision with root package name */
    private static final String f9643j = Util.B0(3);

    /* renamed from: k  reason: collision with root package name */
    private static final String f9644k = Util.B0(4);

    /* renamed from: l  reason: collision with root package name */
    private static final String f9645l = Util.B0(5);

    /* renamed from: a  reason: collision with root package name */
    private final MediaSessionCompat.Token f9646a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9647b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9648c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentName f9649d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9650e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f9651f;

    private SessionTokenImplLegacy(MediaSessionCompat.Token token, int i2, int i3, ComponentName componentName, String str, Bundle bundle) {
        this.f9646a = token;
        this.f9647b = i2;
        this.f9648c = i3;
        this.f9649d = componentName;
        this.f9650e = str;
        this.f9651f = bundle;
    }

    public static SessionTokenImplLegacy a(Bundle bundle) {
        MediaSessionCompat.Token token;
        Bundle bundle2 = bundle.getBundle(f9640g);
        if (bundle2 == null) {
            token = null;
        } else {
            token = MediaSessionCompat.Token.b(bundle2);
        }
        MediaSessionCompat.Token token2 = token;
        String str = f9641h;
        Assertions.b(bundle.containsKey(str), "uid should be set.");
        int i2 = bundle.getInt(str);
        String str2 = f9642i;
        Assertions.b(bundle.containsKey(str2), "type should be set.");
        int i3 = bundle.getInt(str2);
        ComponentName componentName = (ComponentName) bundle.getParcelable(f9643j);
        String e2 = Assertions.e(bundle.getString(f9644k), "package name should be set.");
        Bundle bundle3 = bundle.getBundle(f9645l);
        if (bundle3 == null) {
            bundle3 = Bundle.EMPTY;
        }
        return new SessionTokenImplLegacy(token2, i2, i3, componentName, e2, bundle3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplLegacy)) {
            return false;
        }
        SessionTokenImplLegacy sessionTokenImplLegacy = (SessionTokenImplLegacy) obj;
        int i2 = this.f9648c;
        if (i2 != sessionTokenImplLegacy.f9648c) {
            return false;
        }
        if (i2 == 100) {
            return Util.c(this.f9646a, sessionTokenImplLegacy.f9646a);
        }
        if (i2 != 101) {
            return false;
        }
        return Util.c(this.f9649d, sessionTokenImplLegacy.f9649d);
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f9648c), this.f9649d, this.f9646a);
    }

    public String toString() {
        return "SessionToken {legacyToken=" + this.f9646a + "}";
    }
}
