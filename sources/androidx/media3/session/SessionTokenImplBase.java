package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.app.BundleCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionToken;
import com.google.common.base.Objects;

final class SessionTokenImplBase implements SessionToken.SessionTokenImpl {

    /* renamed from: j  reason: collision with root package name */
    private static final String f9622j = Util.B0(0);

    /* renamed from: k  reason: collision with root package name */
    private static final String f9623k = Util.B0(1);

    /* renamed from: l  reason: collision with root package name */
    private static final String f9624l = Util.B0(2);

    /* renamed from: m  reason: collision with root package name */
    private static final String f9625m = Util.B0(3);

    /* renamed from: n  reason: collision with root package name */
    private static final String f9626n = Util.B0(4);

    /* renamed from: o  reason: collision with root package name */
    private static final String f9627o = Util.B0(5);

    /* renamed from: p  reason: collision with root package name */
    private static final String f9628p = Util.B0(6);

    /* renamed from: q  reason: collision with root package name */
    private static final String f9629q = Util.B0(7);

    /* renamed from: r  reason: collision with root package name */
    private static final String f9630r = Util.B0(8);

    /* renamed from: a  reason: collision with root package name */
    private final int f9631a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9632b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9633c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9634d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9635e;

    /* renamed from: f  reason: collision with root package name */
    private final String f9636f;

    /* renamed from: g  reason: collision with root package name */
    private final ComponentName f9637g;

    /* renamed from: h  reason: collision with root package name */
    private final IBinder f9638h;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f9639i;

    private SessionTokenImplBase(int i2, int i3, int i4, int i5, String str, String str2, ComponentName componentName, IBinder iBinder, Bundle bundle) {
        this.f9631a = i2;
        this.f9632b = i3;
        this.f9633c = i4;
        this.f9634d = i5;
        this.f9635e = str;
        this.f9636f = str2;
        this.f9637g = componentName;
        this.f9638h = iBinder;
        this.f9639i = bundle;
    }

    public static SessionTokenImplBase a(Bundle bundle) {
        String str = f9622j;
        Assertions.b(bundle.containsKey(str), "uid should be set.");
        int i2 = bundle.getInt(str);
        String str2 = f9623k;
        Assertions.b(bundle.containsKey(str2), "type should be set.");
        int i3 = bundle.getInt(str2);
        int i4 = bundle.getInt(f9624l, 0);
        int i5 = bundle.getInt(f9630r, 0);
        String e2 = Assertions.e(bundle.getString(f9625m), "package name should be set.");
        String string = bundle.getString(f9626n, "");
        IBinder a2 = BundleCompat.a(bundle, f9628p);
        ComponentName componentName = (ComponentName) bundle.getParcelable(f9627o);
        Bundle bundle2 = bundle.getBundle(f9629q);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionTokenImplBase(i2, i3, i4, i5, e2, string, componentName, a2, bundle2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplBase)) {
            return false;
        }
        SessionTokenImplBase sessionTokenImplBase = (SessionTokenImplBase) obj;
        if (this.f9631a != sessionTokenImplBase.f9631a || this.f9632b != sessionTokenImplBase.f9632b || this.f9633c != sessionTokenImplBase.f9633c || this.f9634d != sessionTokenImplBase.f9634d || !TextUtils.equals(this.f9635e, sessionTokenImplBase.f9635e) || !TextUtils.equals(this.f9636f, sessionTokenImplBase.f9636f) || !Util.c(this.f9637g, sessionTokenImplBase.f9637g) || !Util.c(this.f9638h, sessionTokenImplBase.f9638h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f9631a), Integer.valueOf(this.f9632b), Integer.valueOf(this.f9633c), Integer.valueOf(this.f9634d), this.f9635e, this.f9636f, this.f9637g, this.f9638h);
    }

    public String toString() {
        return "SessionToken {pkg=" + this.f9635e + " type=" + this.f9632b + " libraryVersion=" + this.f9633c + " interfaceVersion=" + this.f9634d + " service=" + this.f9636f + " IMediaSession=" + this.f9638h + " extras=" + this.f9639i + "}";
    }
}
