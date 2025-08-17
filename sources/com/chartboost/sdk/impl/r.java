package com.chartboost.sdk.impl;

import android.webkit.WebView;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final e9 f18498a;

    /* renamed from: b  reason: collision with root package name */
    public final WebView f18499b;

    /* renamed from: c  reason: collision with root package name */
    public final List f18500c;

    /* renamed from: d  reason: collision with root package name */
    public final Map f18501d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final String f18502e;

    /* renamed from: f  reason: collision with root package name */
    public final String f18503f;

    /* renamed from: g  reason: collision with root package name */
    public final String f18504g;

    /* renamed from: h  reason: collision with root package name */
    public final s f18505h;

    public r(e9 e9Var, WebView webView, String str, List list, String str2, String str3, s sVar) {
        ArrayList arrayList = new ArrayList();
        this.f18500c = arrayList;
        this.f18498a = e9Var;
        this.f18499b = webView;
        this.f18502e = str;
        this.f18505h = sVar;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String uuid = UUID.randomUUID().toString();
                this.f18501d.put(uuid, (qc) it2.next());
            }
        }
        this.f18504g = str2;
        this.f18503f = str3;
    }

    public static r a(e9 e9Var, WebView webView, String str, String str2) {
        df.a((Object) e9Var, "Partner is null");
        df.a((Object) webView, "WebView is null");
        if (str2 != null) {
            df.a(str2, (int) UserVerificationMethods.USER_VERIFY_HANDPRINT, "CustomReferenceData is greater than 256 characters");
        }
        return new r(e9Var, webView, (String) null, (List) null, str, str2, s.HTML);
    }

    public String b() {
        return this.f18504g;
    }

    public String c() {
        return this.f18503f;
    }

    public Map d() {
        return Collections.unmodifiableMap(this.f18501d);
    }

    public String e() {
        return this.f18502e;
    }

    public e9 f() {
        return this.f18498a;
    }

    public List g() {
        return Collections.unmodifiableList(this.f18500c);
    }

    public WebView h() {
        return this.f18499b;
    }

    public static r a(e9 e9Var, String str, List list, String str2, String str3) {
        df.a((Object) e9Var, "Partner is null");
        df.a((Object) str, "OM SDK JS script content is null");
        df.a((Object) list, "VerificationScriptResources is null");
        if (str3 != null) {
            df.a(str3, (int) UserVerificationMethods.USER_VERIFY_HANDPRINT, "CustomReferenceData is greater than 256 characters");
        }
        return new r(e9Var, (WebView) null, str, list, str2, str3, s.NATIVE);
    }

    public s a() {
        return this.f18505h;
    }
}
