package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.d.e;
import java.net.URL;

public final class VerificationScriptResource {

    /* renamed from: a  reason: collision with root package name */
    private final String f31339a;

    /* renamed from: b  reason: collision with root package name */
    private final URL f31340b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31341c;

    private VerificationScriptResource(String str, URL url, String str2) {
        this.f31339a = str;
        this.f31340b = url;
        this.f31341c = str2;
    }

    public static VerificationScriptResource a(String str, URL url, String str2) {
        e.f(str, "VendorKey is null or empty");
        e.d(url, "ResourceURL is null");
        e.f(str2, "VerificationParameters is null or empty");
        return new VerificationScriptResource(str, url, str2);
    }

    public static VerificationScriptResource b(URL url) {
        e.d(url, "ResourceURL is null");
        return new VerificationScriptResource((String) null, url, (String) null);
    }

    public URL c() {
        return this.f31340b;
    }

    public String d() {
        return this.f31339a;
    }

    public String e() {
        return this.f31341c;
    }
}
