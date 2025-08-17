package com.applovin.impl.sdk.e;

import com.applovin.impl.a.e;
import com.applovin.impl.a.f;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

public abstract class r extends a {

    /* renamed from: a  reason: collision with root package name */
    private final AppLovinAdLoadListener f15425a;

    /* renamed from: c  reason: collision with root package name */
    private final a f15426c;

    private static final class a extends e {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, m mVar) {
            super(jSONObject, jSONObject2, bVar, mVar);
        }

        /* access modifiers changed from: package-private */
        public void a(com.applovin.impl.sdk.utils.r rVar) {
            if (rVar != null) {
                this.f13765a.add(rVar);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }

    private static final class b extends r {

        /* renamed from: a  reason: collision with root package name */
        private final String f15427a;

        b(String str, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            this.f15427a = str;
        }

        public void run() {
            a(e(this.f15427a));
        }
    }

    private static final class c extends r {

        /* renamed from: a  reason: collision with root package name */
        private final JSONObject f15428a;

        c(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            this.f15428a = eVar.c();
        }

        public void run() {
            f fVar;
            if (v.a()) {
                a("Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.f15428a, "xml", (String) null);
            if (!StringUtils.isValidString(string)) {
                if (v.a()) {
                    d("No VAST response received.");
                }
                fVar = f.NO_WRAPPER_RESPONSE;
            } else if (string.length() < ((Integer) this.f15333b.a(com.applovin.impl.sdk.c.b.eh)).intValue()) {
                a(e(string));
                return;
            } else {
                if (v.a()) {
                    d("VAST response is over max length");
                }
                fVar = f.XML_PARSING;
            }
            a(fVar);
        }
    }

    private static final class d extends r {

        /* renamed from: a  reason: collision with root package name */
        private final com.applovin.impl.sdk.utils.r f15429a;

        d(com.applovin.impl.sdk.utils.r rVar, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            if (rVar == null) {
                throw new IllegalArgumentException("No response specified.");
            } else if (eVar == null) {
                throw new IllegalArgumentException("No context specified.");
            } else if (appLovinAdLoadListener != null) {
                this.f15429a = rVar;
            } else {
                throw new IllegalArgumentException("No callback specified.");
            }
        }

        public void run() {
            if (v.a()) {
                a("Processing VAST Wrapper response...");
            }
            a(this.f15429a);
        }
    }

    r(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskProcessVastResponse", mVar);
        if (eVar != null) {
            this.f15425a = appLovinAdLoadListener;
            this.f15426c = (a) eVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    public static r a(com.applovin.impl.sdk.utils.r rVar, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        return new d(rVar, eVar, appLovinAdLoadListener, mVar);
    }

    public static r a(String str, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        return new b(str, new a(jSONObject, jSONObject2, bVar, mVar), appLovinAdLoadListener, mVar);
    }

    public static r a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        return new c(new a(jSONObject, jSONObject2, bVar, mVar), appLovinAdLoadListener, mVar);
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        if (v.a()) {
            d("Failed to process VAST response due to VAST error code " + fVar);
        }
        l.a((e) this.f15426c, this.f15425a, fVar, -6, this.f15333b);
    }

    /* access modifiers changed from: package-private */
    public void a(com.applovin.impl.sdk.utils.r rVar) {
        f fVar;
        a aVar;
        int a2 = this.f15426c.a();
        if (v.a()) {
            a("Finished parsing XML at depth " + a2);
        }
        this.f15426c.a(rVar);
        if (l.a(rVar)) {
            int intValue = ((Integer) this.f15333b.a(com.applovin.impl.sdk.c.b.ei)).intValue();
            if (a2 < intValue) {
                if (v.a()) {
                    a("VAST response is wrapper. Resolving...");
                }
                aVar = new x(this.f15426c, this.f15425a, this.f15333b);
            } else {
                if (v.a()) {
                    d("Reached beyond max wrapper depth of " + intValue);
                }
                fVar = f.WRAPPER_LIMIT_REACHED;
                a(fVar);
                return;
            }
        } else if (l.b(rVar)) {
            if (v.a()) {
                a("VAST response is inline. Rendering ad...");
            }
            aVar = new t(this.f15426c, this.f15425a, this.f15333b);
        } else {
            if (v.a()) {
                d("VAST response is an error");
            }
            fVar = f.NO_WRAPPER_RESPONSE;
            a(fVar);
            return;
        }
        this.f15333b.S().a(aVar);
    }

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.utils.r e(String str) {
        try {
            return s.a(str, this.f15333b);
        } catch (Throwable th) {
            if (v.a()) {
                a("Failed to process VAST response", th);
            }
            a(f.XML_PARSING);
            return null;
        }
    }
}
