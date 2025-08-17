package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

public final class SessionResult {

    /* renamed from: e  reason: collision with root package name */
    private static final String f9608e = Util.B0(0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f9609f = Util.B0(1);

    /* renamed from: g  reason: collision with root package name */
    private static final String f9610g = Util.B0(2);

    /* renamed from: h  reason: collision with root package name */
    private static final String f9611h = Util.B0(3);

    /* renamed from: a  reason: collision with root package name */
    public final int f9612a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f9613b;

    /* renamed from: c  reason: collision with root package name */
    public final long f9614c;

    /* renamed from: d  reason: collision with root package name */
    public final SessionError f9615d;

    public SessionResult(int i2, Bundle bundle) {
        this(i2, bundle, SystemClock.elapsedRealtime(), (SessionError) null);
    }

    private SessionResult(int i2, Bundle bundle, long j2, SessionError sessionError) {
        Assertions.a(sessionError == null || i2 < 0);
        this.f9612a = i2;
        this.f9613b = new Bundle(bundle);
        this.f9614c = j2;
        if (sessionError == null && i2 < 0) {
            sessionError = new SessionError(i2, "no error message provided");
        }
        this.f9615d = sessionError;
    }
}
