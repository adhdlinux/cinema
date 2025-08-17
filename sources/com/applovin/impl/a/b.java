package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f13753a;

    /* renamed from: b  reason: collision with root package name */
    private final List<g> f13754b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13755c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<j> f13756d;

    private b(String str, List<g> list, String str2, Set<j> set) {
        this.f13753a = str;
        this.f13754b = list;
        this.f13755c = str2;
        this.f13756d = set;
    }

    public static b a(r rVar, e eVar, m mVar) {
        try {
            String str = rVar.b().get("vendor");
            r c2 = rVar.c("VerificationParameters");
            String c3 = c2 != null ? c2.c() : null;
            List<r> a2 = rVar.a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(a2.size());
            for (r a3 : a2) {
                g a4 = g.a(a3, mVar);
                if (a4 != null) {
                    arrayList.add(a4);
                }
            }
            HashMap hashMap = new HashMap();
            l.a(rVar, (Map<String, Set<j>>) hashMap, eVar, mVar);
            return new b(str, arrayList, c3, (Set) hashMap.get("verificationNotExecuted"));
        } catch (Throwable th) {
            if (v.a()) {
                mVar.A().b("VastAdVerification", "Error occurred while initializing", th);
            }
            return null;
        }
    }

    public String a() {
        return this.f13753a;
    }

    public List<g> b() {
        return this.f13754b;
    }

    public String c() {
        return this.f13755c;
    }

    public Set<j> d() {
        return this.f13756d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f13753a;
        if (str == null ? bVar.f13753a != null : !str.equals(bVar.f13753a)) {
            return false;
        }
        List<g> list = this.f13754b;
        if (list == null ? bVar.f13754b != null : !list.equals(bVar.f13754b)) {
            return false;
        }
        String str2 = this.f13755c;
        if (str2 == null ? bVar.f13755c != null : !str2.equals(bVar.f13755c)) {
            return false;
        }
        Set<j> set = this.f13756d;
        Set<j> set2 = bVar.f13756d;
        return set != null ? set.equals(set2) : set2 == null;
    }

    public int hashCode() {
        String str = this.f13753a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<g> list = this.f13754b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f13755c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<j> set = this.f13756d;
        if (set != null) {
            i2 = set.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.f13753a + '\'' + "javascriptResources='" + this.f13754b + '\'' + "verificationParameters='" + this.f13755c + '\'' + "errorEventTrackers='" + this.f13756d + '\'' + '}';
    }
}
