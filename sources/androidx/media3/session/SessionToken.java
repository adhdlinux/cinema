package androidx.media3.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.util.concurrent.SettableFuture;

public final class SessionToken {

    /* renamed from: b  reason: collision with root package name */
    private static final String f9616b = Util.B0(0);

    /* renamed from: c  reason: collision with root package name */
    private static final String f9617c = Util.B0(1);

    /* renamed from: a  reason: collision with root package name */
    private final SessionTokenImpl f9618a;

    /* renamed from: androidx.media3.session.SessionToken$1  reason: invalid class name */
    class AnonymousClass1 extends ResultReceiver {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Handler f9619b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SettableFuture f9620c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runnable f9621d;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i2, Bundle bundle) {
            this.f9619b.removeCallbacksAndMessages((Object) null);
            try {
                this.f9620c.A(SessionToken.a(bundle));
            } catch (RuntimeException unused) {
                this.f9621d.run();
            }
        }
    }

    interface SessionTokenImpl {
    }

    static {
        MediaLibraryInfo.a("media3.session");
    }

    private SessionToken(Bundle bundle) {
        String str = f9616b;
        Assertions.b(bundle.containsKey(str), "Impl type needs to be set.");
        int i2 = bundle.getInt(str);
        Bundle bundle2 = (Bundle) Assertions.f(bundle.getBundle(f9617c));
        if (i2 == 0) {
            this.f9618a = SessionTokenImplBase.a(bundle2);
        } else {
            this.f9618a = SessionTokenImplLegacy.a(bundle2);
        }
    }

    public static SessionToken a(Bundle bundle) {
        return new SessionToken(bundle);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionToken)) {
            return false;
        }
        return this.f9618a.equals(((SessionToken) obj).f9618a);
    }

    public int hashCode() {
        return this.f9618a.hashCode();
    }

    public String toString() {
        return this.f9618a.toString();
    }
}
