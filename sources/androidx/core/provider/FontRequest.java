package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f2639a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2640b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2641c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f2642d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2643e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f2644f;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2639a = (String) Preconditions.g(str);
        this.f2640b = (String) Preconditions.g(str2);
        this.f2641c = (String) Preconditions.g(str3);
        this.f2642d = (List) Preconditions.g(list);
        this.f2644f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f2642d;
    }

    public int c() {
        return this.f2643e;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f2644f;
    }

    public String e() {
        return this.f2639a;
    }

    public String f() {
        return this.f2640b;
    }

    public String g() {
        return this.f2641c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2639a + ", mProviderPackage: " + this.f2640b + ", mQuery: " + this.f2641c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f2642d.size(); i2++) {
            sb.append(" [");
            List list = this.f2642d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2643e);
        return sb.toString();
    }
}
