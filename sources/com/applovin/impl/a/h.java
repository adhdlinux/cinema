package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private a f13791a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f13792b;

    /* renamed from: c  reason: collision with root package name */
    private String f13793c;

    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private h() {
    }

    static h a(r rVar, h hVar, m mVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (hVar == null) {
                try {
                    hVar = new h();
                } catch (Throwable th) {
                    if (!v.a()) {
                        return null;
                    }
                    mVar.A().b("VastNonVideoResource", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (hVar.f13792b == null && !StringUtils.isValidString(hVar.f13793c)) {
                String a2 = a(rVar, "StaticResource");
                if (URLUtil.isValidUrl(a2)) {
                    hVar.f13792b = Uri.parse(a2);
                    hVar.f13791a = a.STATIC;
                    return hVar;
                }
                String a3 = a(rVar, "IFrameResource");
                if (StringUtils.isValidString(a3)) {
                    hVar.f13791a = a.IFRAME;
                    if (URLUtil.isValidUrl(a3)) {
                        hVar.f13792b = Uri.parse(a3);
                    } else {
                        hVar.f13793c = a3;
                    }
                    return hVar;
                }
                String a4 = a(rVar, "HTMLResource");
                if (StringUtils.isValidString(a4)) {
                    hVar.f13791a = a.HTML;
                    if (URLUtil.isValidUrl(a4)) {
                        hVar.f13792b = Uri.parse(a4);
                    } else {
                        hVar.f13793c = a4;
                    }
                }
            }
            return hVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    private static String a(r rVar, String str) {
        r b2 = rVar.b(str);
        if (b2 != null) {
            return b2.c();
        }
        return null;
    }

    public a a() {
        return this.f13791a;
    }

    public void a(Uri uri) {
        this.f13792b = uri;
    }

    public void a(String str) {
        this.f13793c = str;
    }

    public Uri b() {
        return this.f13792b;
    }

    public String c() {
        return this.f13793c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f13791a != hVar.f13791a) {
            return false;
        }
        Uri uri = this.f13792b;
        if (uri == null ? hVar.f13792b != null : !uri.equals(hVar.f13792b)) {
            return false;
        }
        String str = this.f13793c;
        String str2 = hVar.f13793c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        a aVar = this.f13791a;
        int i2 = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f13792b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f13793c;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f13791a + ", resourceUri=" + this.f13792b + ", resourceContents='" + this.f13793c + '\'' + '}';
    }
}
