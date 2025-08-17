package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f13757a;

    private c(List<b> list) {
        this.f13757a = list;
    }

    public static c a(r rVar, c cVar, e eVar, m mVar) {
        List list;
        if (cVar != null) {
            try {
                list = cVar.a();
            } catch (Throwable th) {
                if (!v.a()) {
                    return null;
                }
                mVar.A().b("VastAdVerifications", "Error occurred while initializing", th);
                return null;
            }
        } else {
            list = new ArrayList();
        }
        for (r a2 : rVar.a("Verification")) {
            b a3 = b.a(a2, eVar, mVar);
            if (a3 != null) {
                list.add(a3);
            }
        }
        return new c(list);
    }

    public List<b> a() {
        return this.f13757a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f13757a.equals(((c) obj).f13757a);
    }

    public int hashCode() {
        return this.f13757a.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.f13757a + '\'' + '}';
    }
}
