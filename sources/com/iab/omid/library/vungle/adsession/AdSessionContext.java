package com.iab.omid.library.vungle.adsession;

import android.webkit.WebView;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.iab.omid.library.vungle.utils.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AdSessionContext {

    /* renamed from: a  reason: collision with root package name */
    private final Partner f31629a;

    /* renamed from: b  reason: collision with root package name */
    private final WebView f31630b;

    /* renamed from: c  reason: collision with root package name */
    private final List<VerificationScriptResource> f31631c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f31632d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final String f31633e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31634f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31635g;

    /* renamed from: h  reason: collision with root package name */
    private final AdSessionContextType f31636h;

    private AdSessionContext(Partner partner, WebView webView, String str, List<VerificationScriptResource> list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f31631c = arrayList;
        this.f31629a = partner;
        this.f31630b = webView;
        this.f31633e = str;
        this.f31636h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (VerificationScriptResource put : list) {
                String uuid = UUID.randomUUID().toString();
                this.f31632d.put(uuid, put);
            }
        }
        this.f31635g = str2;
        this.f31634f = str3;
    }

    public static AdSessionContext a(Partner partner, WebView webView, String str, String str2) {
        g.c(partner, "Partner is null");
        g.c(webView, "WebView is null");
        if (str2 != null) {
            g.d(str2, UserVerificationMethods.USER_VERIFY_HANDPRINT, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, webView, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.HTML);
    }

    public AdSessionContextType b() {
        return this.f31636h;
    }

    public String c() {
        return this.f31635g;
    }

    public String d() {
        return this.f31634f;
    }

    public Map<String, VerificationScriptResource> e() {
        return Collections.unmodifiableMap(this.f31632d);
    }

    public String f() {
        return this.f31633e;
    }

    public Partner g() {
        return this.f31629a;
    }

    public List<VerificationScriptResource> h() {
        return Collections.unmodifiableList(this.f31631c);
    }

    public WebView i() {
        return this.f31630b;
    }
}
