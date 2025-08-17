package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f13789a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13790b;

    private g(String str, String str2) {
        this.f13789a = str;
        this.f13790b = str2;
    }

    public static g a(r rVar, m mVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                return new g(rVar.b().get("apiFramework"), rVar.c());
            } catch (Throwable th) {
                if (!v.a()) {
                    return null;
                }
                mVar.A().b("VastJavaScriptResource", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public String a() {
        return this.f13789a;
    }

    public String b() {
        return this.f13790b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        String str = this.f13789a;
        if (str == null ? gVar.f13789a != null : !str.equals(gVar.f13789a)) {
            return false;
        }
        String str2 = this.f13790b;
        String str3 = gVar.f13790b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f13789a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f13790b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.f13789a + '\'' + ", javascriptResourceUrl='" + this.f13790b + '\'' + '}';
    }
}
