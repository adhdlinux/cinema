package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import java.util.Locale;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private Uri f13821a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f13822b;

    /* renamed from: c  reason: collision with root package name */
    private a f13823c;

    /* renamed from: d  reason: collision with root package name */
    private String f13824d;

    /* renamed from: e  reason: collision with root package name */
    private int f13825e;

    /* renamed from: f  reason: collision with root package name */
    private int f13826f;

    /* renamed from: g  reason: collision with root package name */
    private int f13827g;

    public enum a {
        Progressive,
        Streaming
    }

    private n() {
    }

    private static a a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    public static n a(r rVar, m mVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                String c2 = rVar.c();
                if (URLUtil.isValidUrl(c2)) {
                    Uri parse = Uri.parse(c2);
                    n nVar = new n();
                    nVar.f13821a = parse;
                    nVar.f13822b = parse;
                    nVar.f13827g = StringUtils.parseInt(rVar.b().get("bitrate"));
                    nVar.f13823c = a(rVar.b().get("delivery"));
                    nVar.f13826f = StringUtils.parseInt(rVar.b().get("height"));
                    nVar.f13825e = StringUtils.parseInt(rVar.b().get("width"));
                    nVar.f13824d = rVar.b().get("type").toLowerCase(Locale.ENGLISH);
                    return nVar;
                } else if (!v.a()) {
                    return null;
                } else {
                    mVar.A().e("VastVideoFile", "Unable to create video file. Could not find URL.");
                    return null;
                }
            } catch (Throwable th) {
                if (!v.a()) {
                    return null;
                }
                mVar.A().b("VastVideoFile", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public Uri a() {
        return this.f13821a;
    }

    public void a(Uri uri) {
        this.f13822b = uri;
    }

    public Uri b() {
        return this.f13822b;
    }

    public String c() {
        return this.f13824d;
    }

    public int d() {
        return this.f13827g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f13825e != nVar.f13825e || this.f13826f != nVar.f13826f || this.f13827g != nVar.f13827g) {
            return false;
        }
        Uri uri = this.f13821a;
        if (uri == null ? nVar.f13821a != null : !uri.equals(nVar.f13821a)) {
            return false;
        }
        Uri uri2 = this.f13822b;
        if (uri2 == null ? nVar.f13822b != null : !uri2.equals(nVar.f13822b)) {
            return false;
        }
        if (this.f13823c != nVar.f13823c) {
            return false;
        }
        String str = this.f13824d;
        String str2 = nVar.f13824d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f13821a;
        int i2 = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f13822b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.f13823c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f13824d;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((((((hashCode3 + i2) * 31) + this.f13825e) * 31) + this.f13826f) * 31) + this.f13827g;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f13821a + ", videoUri=" + this.f13822b + ", deliveryType=" + this.f13823c + ", fileType='" + this.f13824d + '\'' + ", width=" + this.f13825e + ", height=" + this.f13826f + ", bitrate=" + this.f13827g + '}';
    }
}
