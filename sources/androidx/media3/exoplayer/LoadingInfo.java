package androidx.media3.exoplayer;

import androidx.media3.common.util.Assertions;
import com.google.common.base.Objects;

public final class LoadingInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f5395a;

    /* renamed from: b  reason: collision with root package name */
    public final float f5396b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5397c;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public long f5398a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f5399b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f5400c;

        public LoadingInfo d() {
            return new LoadingInfo(this);
        }

        public Builder e(long j2) {
            boolean z2;
            if (j2 >= 0 || j2 == -9223372036854775807L) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f5400c = j2;
            return this;
        }

        public Builder f(long j2) {
            this.f5398a = j2;
            return this;
        }

        public Builder g(float f2) {
            boolean z2;
            if (f2 > 0.0f || f2 == -3.4028235E38f) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f5399b = f2;
            return this;
        }

        public Builder() {
            this.f5398a = -9223372036854775807L;
            this.f5399b = -3.4028235E38f;
            this.f5400c = -9223372036854775807L;
        }

        private Builder(LoadingInfo loadingInfo) {
            this.f5398a = loadingInfo.f5395a;
            this.f5399b = loadingInfo.f5396b;
            this.f5400c = loadingInfo.f5397c;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadingInfo)) {
            return false;
        }
        LoadingInfo loadingInfo = (LoadingInfo) obj;
        if (this.f5395a == loadingInfo.f5395a && this.f5396b == loadingInfo.f5396b && this.f5397c == loadingInfo.f5397c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.f5395a), Float.valueOf(this.f5396b), Long.valueOf(this.f5397c));
    }

    private LoadingInfo(Builder builder) {
        this.f5395a = builder.f5398a;
        this.f5396b = builder.f5399b;
        this.f5397c = builder.f5400c;
    }
}
