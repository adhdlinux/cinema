package androidx.media3.exoplayer.dash.manifest;

import com.google.common.base.Objects;

public final class BaseUrl {

    /* renamed from: a  reason: collision with root package name */
    public final String f6045a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6046b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6047c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6048d;

    public BaseUrl(String str, String str2, int i2, int i3) {
        this.f6045a = str;
        this.f6046b = str2;
        this.f6047c = i2;
        this.f6048d = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseUrl)) {
            return false;
        }
        BaseUrl baseUrl = (BaseUrl) obj;
        if (this.f6047c != baseUrl.f6047c || this.f6048d != baseUrl.f6048d || !Objects.a(this.f6045a, baseUrl.f6045a) || !Objects.a(this.f6046b, baseUrl.f6046b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.b(this.f6045a, this.f6046b, Integer.valueOf(this.f6047c), Integer.valueOf(this.f6048d));
    }
}
