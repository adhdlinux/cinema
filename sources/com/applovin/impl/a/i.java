package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import com.unity3d.ads.metadata.MediationMetaData;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private String f13799a;

    /* renamed from: b  reason: collision with root package name */
    private String f13800b;

    private i() {
    }

    public static i a(r rVar, i iVar, m mVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (iVar == null) {
                try {
                    iVar = new i();
                } catch (Throwable th) {
                    if (!v.a()) {
                        return null;
                    }
                    mVar.A().b("VastSystemInfo", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (!StringUtils.isValidString(iVar.f13799a)) {
                String c2 = rVar.c();
                if (StringUtils.isValidString(c2)) {
                    iVar.f13799a = c2;
                }
            }
            if (!StringUtils.isValidString(iVar.f13800b)) {
                String str = rVar.b().get(MediationMetaData.KEY_VERSION);
                if (StringUtils.isValidString(str)) {
                    iVar.f13800b = str;
                }
            }
            return iVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        String str = this.f13799a;
        if (str == null ? iVar.f13799a != null : !str.equals(iVar.f13799a)) {
            return false;
        }
        String str2 = this.f13800b;
        String str3 = iVar.f13800b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f13799a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f13800b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f13799a + '\'' + ", version='" + this.f13800b + '\'' + '}';
    }
}
