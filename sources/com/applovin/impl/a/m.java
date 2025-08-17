package com.applovin.impl.a;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private List<n> f13809a = Collections.emptyList();

    /* renamed from: b  reason: collision with root package name */
    private List<String> f13810b = Collections.emptyList();

    /* renamed from: c  reason: collision with root package name */
    private int f13811c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f13812d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<j> f13813e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Set<j>> f13814f = new HashMap();

    public enum a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH
    }

    private m() {
    }

    private m(e eVar) {
        this.f13810b = eVar.g();
    }

    private static int a(String str, com.applovin.impl.sdk.m mVar) {
        try {
            List<String> explode = CollectionUtils.explode(str, ":");
            if (explode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) StringUtils.parseInt(explode.get(0))) + TimeUnit.MINUTES.toSeconds((long) StringUtils.parseInt(explode.get(1))) + ((long) StringUtils.parseInt(explode.get(2))));
            }
        } catch (Throwable unused) {
            if (v.a()) {
                v A = mVar.A();
                A.e("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    public static m a(r rVar, m mVar, e eVar, com.applovin.impl.sdk.m mVar2) {
        r b2;
        List<n> a2;
        r b3;
        int a3;
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (eVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (mVar2 != null) {
            if (mVar == null) {
                try {
                    mVar = new m(eVar);
                } catch (Throwable th) {
                    if (!v.a()) {
                        return null;
                    }
                    mVar2.A().b("VastVideoCreative", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (mVar.f13811c == 0 && (b3 = rVar.b("Duration")) != null && (a3 = a(b3.c(), mVar2)) > 0) {
                mVar.f13811c = a3;
            }
            r b4 = rVar.b("MediaFiles");
            if (!(b4 == null || (a2 = a(b4, mVar2)) == null || a2.size() <= 0)) {
                List<n> list = mVar.f13809a;
                if (list != null) {
                    a2.addAll(list);
                }
                mVar.f13809a = a2;
            }
            r b5 = rVar.b("VideoClicks");
            if (b5 != null) {
                if (mVar.f13812d == null && (b2 = b5.b("ClickThrough")) != null) {
                    String c2 = b2.c();
                    if (StringUtils.isValidString(c2)) {
                        mVar.f13812d = Uri.parse(c2);
                    }
                }
                l.a(b5.a("ClickTracking"), mVar.f13813e, eVar, mVar2);
            }
            l.a(rVar, mVar.f13814f, eVar, mVar2);
            return mVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    private static List<n> a(r rVar, com.applovin.impl.sdk.m mVar) {
        List<r> a2 = rVar.a("MediaFile");
        ArrayList arrayList = new ArrayList(a2.size());
        List<String> explode = CollectionUtils.explode((String) mVar.a(b.ek));
        List<String> explode2 = CollectionUtils.explode((String) mVar.a(b.ej));
        for (r a3 : a2) {
            n a4 = n.a(a3, mVar);
            if (a4 != null) {
                try {
                    String c2 = a4.c();
                    if (!StringUtils.isValidString(c2) || explode.contains(c2)) {
                        if (((Boolean) mVar.a(b.el)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a4.b().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !explode2.contains(fileExtensionFromUrl)) {
                            }
                        }
                        if (v.a()) {
                            v A = mVar.A();
                            A.d("VastVideoCreative", "Video file not supported: " + a4);
                        }
                    }
                    arrayList.add(a4);
                } catch (Throwable th) {
                    if (v.a()) {
                        v A2 = mVar.A();
                        A2.b("VastVideoCreative", "Failed to validate video file: " + a4, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public n a(a aVar) {
        List<n> list = this.f13809a;
        if (list == null || list.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(3);
        for (String next : this.f13810b) {
            for (n next2 : this.f13809a) {
                String c2 = next2.c();
                if (StringUtils.isValidString(c2) && next.equalsIgnoreCase(c2)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f13809a;
        }
        if (g.c()) {
            Collections.sort(arrayList, new Comparator<n>() {
                @TargetApi(19)
                /* renamed from: a */
                public int compare(n nVar, n nVar2) {
                    return Integer.compare(nVar.d(), nVar2.d());
                }
            });
        }
        return (n) arrayList.get(aVar == a.LOW ? 0 : aVar == a.MEDIUM ? arrayList.size() / 2 : arrayList.size() - 1);
    }

    public List<n> a() {
        return this.f13809a;
    }

    public int b() {
        return this.f13811c;
    }

    public Uri c() {
        return this.f13812d;
    }

    public Set<j> d() {
        return this.f13813e;
    }

    public Map<String, Set<j>> e() {
        return this.f13814f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f13811c != mVar.f13811c) {
            return false;
        }
        List<n> list = this.f13809a;
        if (list == null ? mVar.f13809a != null : !list.equals(mVar.f13809a)) {
            return false;
        }
        Uri uri = this.f13812d;
        if (uri == null ? mVar.f13812d != null : !uri.equals(mVar.f13812d)) {
            return false;
        }
        Set<j> set = this.f13813e;
        if (set == null ? mVar.f13813e != null : !set.equals(mVar.f13813e)) {
            return false;
        }
        Map<String, Set<j>> map = this.f13814f;
        Map<String, Set<j>> map2 = mVar.f13814f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        List<n> list = this.f13809a;
        int i2 = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f13811c) * 31;
        Uri uri = this.f13812d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<j> set = this.f13813e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<j>> map = this.f13814f;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f13809a + ", durationSeconds=" + this.f13811c + ", destinationUri=" + this.f13812d + ", clickTrackers=" + this.f13813e + ", eventTrackers=" + this.f13814f + '}';
    }
}
