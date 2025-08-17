package com.applovin.impl.a;

import android.net.Uri;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f13758a;

    /* renamed from: b  reason: collision with root package name */
    private int f13759b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f13760c;

    /* renamed from: d  reason: collision with root package name */
    private h f13761d;

    /* renamed from: e  reason: collision with root package name */
    private Set<j> f13762e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Set<j>> f13763f = new HashMap();

    private d() {
    }

    public static d a(r rVar, d dVar, e eVar, m mVar) {
        r b2;
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (dVar == null) {
                try {
                    dVar = new d();
                } catch (Throwable th) {
                    if (!v.a()) {
                        return null;
                    }
                    mVar.A().b("VastCompanionAd", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (dVar.f13758a == 0 && dVar.f13759b == 0) {
                int parseInt = StringUtils.parseInt(rVar.b().get("width"));
                int parseInt2 = StringUtils.parseInt(rVar.b().get("height"));
                if (parseInt > 0 && parseInt2 > 0) {
                    dVar.f13758a = parseInt;
                    dVar.f13759b = parseInt2;
                }
            }
            dVar.f13761d = h.a(rVar, dVar.f13761d, mVar);
            if (dVar.f13760c == null && (b2 = rVar.b("CompanionClickThrough")) != null) {
                String c2 = b2.c();
                if (StringUtils.isValidString(c2)) {
                    dVar.f13760c = Uri.parse(c2);
                }
            }
            l.a(rVar.a("CompanionClickTracking"), dVar.f13762e, eVar, mVar);
            l.a(rVar, dVar.f13763f, eVar, mVar);
            return dVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public Uri a() {
        return this.f13760c;
    }

    public h b() {
        return this.f13761d;
    }

    public Set<j> c() {
        return this.f13762e;
    }

    public Map<String, Set<j>> d() {
        return this.f13763f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f13758a != dVar.f13758a || this.f13759b != dVar.f13759b) {
            return false;
        }
        Uri uri = this.f13760c;
        if (uri == null ? dVar.f13760c != null : !uri.equals(dVar.f13760c)) {
            return false;
        }
        h hVar = this.f13761d;
        if (hVar == null ? dVar.f13761d != null : !hVar.equals(dVar.f13761d)) {
            return false;
        }
        Set<j> set = this.f13762e;
        if (set == null ? dVar.f13762e != null : !set.equals(dVar.f13762e)) {
            return false;
        }
        Map<String, Set<j>> map = this.f13763f;
        Map<String, Set<j>> map2 = dVar.f13763f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i2 = ((this.f13758a * 31) + this.f13759b) * 31;
        Uri uri = this.f13760c;
        int i3 = 0;
        int hashCode = (i2 + (uri != null ? uri.hashCode() : 0)) * 31;
        h hVar = this.f13761d;
        int hashCode2 = (hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31;
        Set<j> set = this.f13762e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<j>> map = this.f13763f;
        if (map != null) {
            i3 = map.hashCode();
        }
        return hashCode3 + i3;
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f13758a + ", height=" + this.f13759b + ", destinationUri=" + this.f13760c + ", nonVideoResource=" + this.f13761d + ", clickTrackers=" + this.f13762e + ", eventTrackers=" + this.f13763f + '}';
    }
}
