package com.iab.omid.library.adcolony.adsession;

import android.webkit.WebView;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.iab.omid.library.adcolony.d.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AdSessionContext {

    /* renamed from: a  reason: collision with root package name */
    private final Partner f31293a;

    /* renamed from: b  reason: collision with root package name */
    private final WebView f31294b;

    /* renamed from: c  reason: collision with root package name */
    private final List<VerificationScriptResource> f31295c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f31296d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final String f31297e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31298f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31299g;

    /* renamed from: h  reason: collision with root package name */
    private final AdSessionContextType f31300h;

    private AdSessionContext(Partner partner, WebView webView, String str, List<VerificationScriptResource> list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f31295c = arrayList;
        this.f31293a = partner;
        this.f31294b = webView;
        this.f31297e = str;
        this.f31300h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (VerificationScriptResource put : list) {
                String uuid = UUID.randomUUID().toString();
                this.f31296d.put(uuid, put);
            }
        }
        this.f31299g = str2;
        this.f31298f = str3;
    }

    public static AdSessionContext a(Partner partner, WebView webView, String str, String str2) {
        e.d(partner, "Partner is null");
        e.d(webView, "WebView is null");
        if (str2 != null) {
            e.e(str2, UserVerificationMethods.USER_VERIFY_HANDPRINT, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, webView, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.HTML);
    }

    public static AdSessionContext b(Partner partner, String str, List<VerificationScriptResource> list, String str2, String str3) {
        e.d(partner, "Partner is null");
        e.d(str, "OM SDK JS script content is null");
        e.d(list, "VerificationScriptResources is null");
        if (str3 != null) {
            e.e(str3, UserVerificationMethods.USER_VERIFY_HANDPRINT, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, (WebView) null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType c() {
        return this.f31300h;
    }

    public String d() {
        return this.f31299g;
    }

    public String e() {
        return this.f31298f;
    }

    public Map<String, VerificationScriptResource> f() {
        return Collections.unmodifiableMap(this.f31296d);
    }

    public String g() {
        return this.f31297e;
    }

    public Partner h() {
        return this.f31293a;
    }

    public List<VerificationScriptResource> i() {
        return Collections.unmodifiableList(this.f31295c);
    }

    public WebView j() {
        return this.f31294b;
    }
}
