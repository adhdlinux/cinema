package com.applovin.impl.a;

import android.net.Uri;
import com.applovin.impl.a.m;
import com.applovin.impl.sdk.a.g;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final String f13719a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13720b;

    /* renamed from: c  reason: collision with root package name */
    private final i f13721c;

    /* renamed from: d  reason: collision with root package name */
    private final long f13722d;

    /* renamed from: e  reason: collision with root package name */
    private final m f13723e;

    /* renamed from: f  reason: collision with root package name */
    private final d f13724f;

    /* renamed from: g  reason: collision with root package name */
    private final String f13725g;

    /* renamed from: h  reason: collision with root package name */
    private final c f13726h;

    /* renamed from: i  reason: collision with root package name */
    private final g f13727i;

    /* renamed from: j  reason: collision with root package name */
    private final Set<j> f13728j;

    /* renamed from: k  reason: collision with root package name */
    private final Set<j> f13729k;

    /* renamed from: com.applovin.impl.a.a$a  reason: collision with other inner class name */
    public static class C0006a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f13730a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f13731b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public com.applovin.impl.sdk.ad.b f13732c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public m f13733d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public long f13734e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f13735f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String f13736g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public i f13737h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public m f13738i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public d f13739j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public c f13740k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public Set<j> f13741l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public Set<j> f13742m;

        public C0006a a(long j2) {
            this.f13734e = j2;
            return this;
        }

        public C0006a a(c cVar) {
            this.f13740k = cVar;
            return this;
        }

        public C0006a a(d dVar) {
            this.f13739j = dVar;
            return this;
        }

        public C0006a a(i iVar) {
            this.f13737h = iVar;
            return this;
        }

        public C0006a a(m mVar) {
            this.f13738i = mVar;
            return this;
        }

        public C0006a a(com.applovin.impl.sdk.ad.b bVar) {
            this.f13732c = bVar;
            return this;
        }

        public C0006a a(m mVar) {
            if (mVar != null) {
                this.f13733d = mVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        public C0006a a(String str) {
            this.f13735f = str;
            return this;
        }

        public C0006a a(Set<j> set) {
            this.f13741l = set;
            return this;
        }

        public C0006a a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f13730a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        public a a() {
            return new a(this);
        }

        public C0006a b(String str) {
            this.f13736g = str;
            return this;
        }

        public C0006a b(Set<j> set) {
            this.f13742m = set;
            return this;
        }

        public C0006a b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f13731b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }
    }

    public enum b {
        COMPANION_AD,
        VIDEO
    }

    public enum c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        ERROR
    }

    private a(C0006a aVar) {
        super(aVar.f13730a, aVar.f13731b, aVar.f13732c, aVar.f13733d);
        this.f13719a = aVar.f13735f;
        this.f13721c = aVar.f13737h;
        this.f13720b = aVar.f13736g;
        this.f13723e = aVar.f13738i;
        this.f13724f = aVar.f13739j;
        this.f13726h = aVar.f13740k;
        this.f13728j = aVar.f13741l;
        this.f13729k = aVar.f13742m;
        this.f13727i = new g(this);
        Uri h2 = h();
        this.f13725g = h2 != null ? h2.toString() : "";
        this.f13722d = aVar.f13734e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r6 = r5.f13724f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<com.applovin.impl.a.j> a(com.applovin.impl.a.a.b r6, java.lang.String[] r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x004a
            int r0 = r7.length
            if (r0 <= 0) goto L_0x004a
            com.applovin.impl.a.a$b r0 = com.applovin.impl.a.a.b.VIDEO
            if (r6 != r0) goto L_0x0012
            com.applovin.impl.a.m r0 = r5.f13723e
            if (r0 == 0) goto L_0x0012
            java.util.Map r6 = r0.e()
            goto L_0x0020
        L_0x0012:
            com.applovin.impl.a.a$b r0 = com.applovin.impl.a.a.b.COMPANION_AD
            if (r6 != r0) goto L_0x001f
            com.applovin.impl.a.d r6 = r5.f13724f
            if (r6 == 0) goto L_0x001f
            java.util.Map r6 = r6.d()
            goto L_0x0020
        L_0x001f:
            r6 = 0
        L_0x0020:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r6 == 0) goto L_0x0045
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x0045
            int r1 = r7.length
            r2 = 0
        L_0x002f:
            if (r2 >= r1) goto L_0x0045
            r3 = r7[r2]
            boolean r4 = r6.containsKey(r3)
            if (r4 == 0) goto L_0x0042
            java.lang.Object r3 = r6.get(r3)
            java.util.Collection r3 = (java.util.Collection) r3
            r0.addAll(r3)
        L_0x0042:
            int r2 = r2 + 1
            goto L_0x002f
        L_0x0045:
            java.util.Set r6 = java.util.Collections.unmodifiableSet(r0)
            return r6
        L_0x004a:
            java.util.Set r6 = java.util.Collections.emptySet()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a.a.a(com.applovin.impl.a.a$b, java.lang.String[]):java.util.Set");
    }

    private String aT() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace(Utils.MACRO_CLCODE, getClCode());
        }
        return null;
    }

    private m.a aU() {
        m.a[] values = m.a.values();
        int intValue = ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.em)).intValue();
        return (intValue < 0 || intValue >= values.length) ? m.a.UNSPECIFIED : values[intValue];
    }

    private Set<j> aV() {
        m mVar = this.f13723e;
        return mVar != null ? mVar.d() : Collections.emptySet();
    }

    private Set<j> aW() {
        d dVar = this.f13724f;
        return dVar != null ? dVar.c() : Collections.emptySet();
    }

    public boolean D() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && j() != null;
    }

    public Set<j> a(c cVar, String str) {
        return a(cVar, new String[]{str});
    }

    public Set<j> a(c cVar, String[] strArr) {
        b bVar;
        if (v.a()) {
            v A = this.sdk.A();
            A.b("VastAd", "Retrieving trackers of type '" + cVar + "' and events '" + strArr + "'...");
        }
        if (cVar == c.IMPRESSION) {
            return this.f13728j;
        }
        if (cVar == c.VIDEO_CLICK) {
            return aV();
        }
        if (cVar == c.COMPANION_CLICK) {
            return aW();
        }
        if (cVar == c.VIDEO) {
            bVar = b.VIDEO;
        } else if (cVar == c.COMPANION) {
            bVar = b.COMPANION_AD;
        } else if (cVar == c.ERROR) {
            return this.f13729k;
        } else {
            if (v.a()) {
                v A2 = this.sdk.A();
                A2.e("VastAd", "Failed to retrieve trackers of invalid type '" + cVar + "' and events '" + strArr + "'");
            }
            return Collections.emptySet();
        }
        return a(bVar, strArr);
    }

    public void a() {
    }

    public void a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    public d aM() {
        return this.f13724f;
    }

    public boolean aN() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    public String aO() {
        return getStringFromAdObject("html_template", "");
    }

    public Uri aP() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean aQ() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    public boolean aR() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    public c aS() {
        return this.f13726h;
    }

    public List<com.applovin.impl.sdk.d.a> at() {
        List<com.applovin.impl.sdk.d.a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("vimp_urls", this.adObject, getClCode(), (Map<String, String>) null, aT(), au(), y(), this.sdk);
        }
        return postbacks;
    }

    public void b() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    /* renamed from: c */
    public g o() {
        return this.f13727i;
    }

    public String d() {
        return this.f13725g;
    }

    public long e() {
        return getLongFromAdObject("real_close_delay", 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a) || !super.equals(obj)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f13719a;
        if (str == null ? aVar.f13719a != null : !str.equals(aVar.f13719a)) {
            return false;
        }
        String str2 = this.f13720b;
        if (str2 == null ? aVar.f13720b != null : !str2.equals(aVar.f13720b)) {
            return false;
        }
        i iVar = this.f13721c;
        if (iVar == null ? aVar.f13721c != null : !iVar.equals(aVar.f13721c)) {
            return false;
        }
        m mVar = this.f13723e;
        if (mVar == null ? aVar.f13723e != null : !mVar.equals(aVar.f13723e)) {
            return false;
        }
        d dVar = this.f13724f;
        if (dVar == null ? aVar.f13724f != null : !dVar.equals(aVar.f13724f)) {
            return false;
        }
        c cVar = this.f13726h;
        if (cVar == null ? aVar.f13726h != null : !cVar.equals(aVar.f13726h)) {
            return false;
        }
        Set<j> set = this.f13728j;
        if (set == null ? aVar.f13728j != null : !set.equals(aVar.f13728j)) {
            return false;
        }
        Set<j> set2 = this.f13729k;
        Set<j> set3 = aVar.f13729k;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    public boolean f() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    public b g() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? b.COMPANION_AD : b.VIDEO;
    }

    public long getCreatedAtMillis() {
        return this.f13722d;
    }

    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    public Uri h() {
        n n2 = n();
        if (n2 != null) {
            return n2.b();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasVideoUrl() {
        /*
            r2 = this;
            com.applovin.impl.a.m r0 = r2.f13723e
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.a()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0012
            r1 = 1
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a.a.hasVideoUrl():boolean");
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f13719a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13720b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        i iVar = this.f13721c;
        int hashCode4 = (hashCode3 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        m mVar = this.f13723e;
        int hashCode5 = (hashCode4 + (mVar != null ? mVar.hashCode() : 0)) * 31;
        d dVar = this.f13724f;
        int hashCode6 = (hashCode5 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        c cVar = this.f13726h;
        int hashCode7 = (hashCode6 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        Set<j> set = this.f13728j;
        int hashCode8 = (hashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set<j> set2 = this.f13729k;
        if (set2 != null) {
            i2 = set2.hashCode();
        }
        return hashCode8 + i2;
    }

    public boolean i() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.TRUE) && this.f13726h != null;
    }

    public Uri j() {
        m mVar = this.f13723e;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    public Uri k() {
        return j();
    }

    public i l() {
        return this.f13721c;
    }

    public m m() {
        return this.f13723e;
    }

    public n n() {
        m mVar = this.f13723e;
        if (mVar != null) {
            return mVar.a(aU());
        }
        return null;
    }

    public String toString() {
        return "VastAd{title='" + this.f13719a + '\'' + ", adDescription='" + this.f13720b + '\'' + ", systemInfo=" + this.f13721c + ", videoCreative=" + this.f13723e + ", companionAd=" + this.f13724f + ", adVerifications=" + this.f13726h + ", impressionTrackers=" + this.f13728j + ", errorTrackers=" + this.f13729k + '}';
    }
}
