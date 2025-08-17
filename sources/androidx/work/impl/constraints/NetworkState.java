package androidx.work.impl.constraints;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;

public class NetworkState {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12414a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12415b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12416c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12417d;

    public NetworkState(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f12414a = z2;
        this.f12415b = z3;
        this.f12416c = z4;
        this.f12417d = z5;
    }

    public boolean a() {
        return this.f12414a;
    }

    public boolean b() {
        return this.f12416c;
    }

    public boolean c() {
        return this.f12417d;
    }

    public boolean d() {
        return this.f12415b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        if (this.f12414a == networkState.f12414a && this.f12415b == networkState.f12415b && this.f12416c == networkState.f12416c && this.f12417d == networkState.f12417d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f12414a;
        if (this.f12415b) {
            i2 += 16;
        }
        if (this.f12416c) {
            i2 += UserVerificationMethods.USER_VERIFY_HANDPRINT;
        }
        if (this.f12417d) {
            return i2 + CodedOutputStream.DEFAULT_BUFFER_SIZE;
        }
        return i2;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.f12414a), Boolean.valueOf(this.f12415b), Boolean.valueOf(this.f12416c), Boolean.valueOf(this.f12417d)});
    }
}
