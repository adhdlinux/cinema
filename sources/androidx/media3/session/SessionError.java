package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Objects;

public final class SessionError {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9602d = Util.B0(0);

    /* renamed from: e  reason: collision with root package name */
    private static final String f9603e = Util.B0(1);

    /* renamed from: f  reason: collision with root package name */
    private static final String f9604f = Util.B0(2);

    /* renamed from: a  reason: collision with root package name */
    public int f9605a;

    /* renamed from: b  reason: collision with root package name */
    public String f9606b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f9607c;

    public SessionError(int i2, String str) {
        this(i2, str, Bundle.EMPTY);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionError)) {
            return false;
        }
        SessionError sessionError = (SessionError) obj;
        if (this.f9605a != sessionError.f9605a || !Objects.equals(this.f9606b, sessionError.f9606b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f9605a), this.f9606b});
    }

    public SessionError(int i2, String str, Bundle bundle) {
        boolean z2 = true;
        if (i2 >= 0 && i2 != 1) {
            z2 = false;
        }
        Assertions.a(z2);
        this.f9605a = i2;
        this.f9606b = str;
        this.f9607c = bundle;
    }
}
