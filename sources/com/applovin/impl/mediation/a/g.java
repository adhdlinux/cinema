package com.applovin.impl.mediation.a;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final h f14237a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14238b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14239c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14240d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14241e;

    public interface a {
        void a(g gVar);
    }

    private g(h hVar, com.applovin.impl.mediation.g gVar, String str, String str2) {
        String str3;
        this.f14237a = hVar;
        this.f14240d = str;
        this.f14241e = str2;
        if (gVar != null) {
            this.f14238b = gVar.h();
            str3 = gVar.i();
        } else {
            str3 = null;
            this.f14238b = null;
        }
        this.f14239c = str3;
    }

    public static g a(h hVar, com.applovin.impl.mediation.g gVar, String str) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (gVar != null) {
            return new g(hVar, gVar, str, (String) null);
        } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
    }

    public static g a(h hVar, String str) {
        return b(hVar, (com.applovin.impl.mediation.g) null, str);
    }

    public static g b(h hVar, com.applovin.impl.mediation.g gVar, String str) {
        if (hVar != null) {
            return new g(hVar, gVar, (String) null, str);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public h a() {
        return this.f14237a;
    }

    public String b() {
        return this.f14238b;
    }

    public String c() {
        return this.f14239c;
    }

    public String d() {
        return this.f14240d;
    }

    public String e() {
        return this.f14241e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f14237a);
        sb.append(", mSdkVersion='");
        sb.append(this.f14238b);
        sb.append('\'');
        sb.append(", mAdapterVersion='");
        sb.append(this.f14239c);
        sb.append('\'');
        sb.append(", mSignalDataLength='");
        String str = this.f14240d;
        sb.append(str != null ? str.length() : 0);
        sb.append('\'');
        sb.append(", mErrorMessage=");
        sb.append(this.f14241e);
        sb.append('}');
        return sb.toString();
    }
}
