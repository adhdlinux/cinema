package androidx.webkit;

import java.util.Objects;

public class WebMessageCompat {

    /* renamed from: a  reason: collision with root package name */
    private final WebMessagePortCompat[] f12059a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12060b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f12061c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12062d;

    public WebMessageCompat(String str, WebMessagePortCompat[] webMessagePortCompatArr) {
        this.f12060b = str;
        this.f12061c = null;
        this.f12059a = webMessagePortCompatArr;
        this.f12062d = 0;
    }

    public String a() {
        return this.f12060b;
    }

    public WebMessageCompat(byte[] bArr, WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.f12061c = bArr;
        this.f12060b = null;
        this.f12059a = webMessagePortCompatArr;
        this.f12062d = 1;
    }
}
