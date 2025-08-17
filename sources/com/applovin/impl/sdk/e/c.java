package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.q;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.vungle.ads.internal.model.AdPayload;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c extends a implements h.a {

    /* renamed from: a  reason: collision with root package name */
    protected final e f15341a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AppLovinAdLoadListener f15342c;

    /* renamed from: d  reason: collision with root package name */
    private final q f15343d;

    /* renamed from: e  reason: collision with root package name */
    private final r f15344e;

    /* renamed from: f  reason: collision with root package name */
    private final Collection<Character> f15345f;

    /* renamed from: g  reason: collision with root package name */
    private final com.applovin.impl.sdk.d.e f15346g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15347h;

    c(String str, e eVar, m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, mVar);
        if (eVar != null) {
            this.f15341a = eVar;
            this.f15342c = appLovinAdLoadListener;
            this.f15343d = mVar.ab();
            this.f15344e = mVar.aa();
            this.f15345f = j();
            this.f15346g = new com.applovin.impl.sdk.d.e();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    private Uri a(Uri uri, String str) {
        String str2;
        StringBuilder sb;
        if (uri != null) {
            String uri2 = uri.toString();
            if (StringUtils.isValidString(uri2)) {
                if (v.a()) {
                    a("Caching " + str + " image...");
                }
                return g(uri2);
            } else if (!v.a()) {
                return null;
            } else {
                sb = new StringBuilder();
                sb.append("Failed to cache ");
                sb.append(str);
                str2 = " image";
            }
        } else if (!v.a()) {
            return null;
        } else {
            sb = new StringBuilder();
            sb.append("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        a(sb.toString());
        return null;
    }

    private Uri a(String str, String str2) {
        StringBuilder sb;
        if (this.f15344e != null) {
            return b(str, str2);
        }
        String replace = str2.replace("/", "_");
        String L = this.f15341a.L();
        if (StringUtils.isValidString(L)) {
            replace = L + replace;
        }
        File a2 = this.f15343d.a(replace, this.f15333b.L());
        if (a2 == null) {
            return null;
        }
        if (a2.exists()) {
            this.f15346g.b(a2.length());
            sb = new StringBuilder();
        } else {
            if (!this.f15343d.a(a2, str + str2, (List<String>) Arrays.asList(new String[]{str}), this.f15346g)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append(AdPayload.FILE_SCHEME);
        sb.append(a2.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    private Uri b(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace("/", "_");
        String L = this.f15341a.L();
        if (StringUtils.isValidString(L)) {
            replace = L + replace;
        }
        File a2 = this.f15344e.a(replace, this.f15333b.L());
        if (a2 == null) {
            return null;
        }
        if (a2.exists()) {
            this.f15346g.b(a2.length());
            sb = new StringBuilder();
        } else {
            if (!this.f15344e.a(a2, str + str2, (List<String>) Arrays.asList(new String[]{str}), this.f15346g)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append(AdPayload.FILE_SCHEME);
        sb.append(a2.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    private Uri g(String str) {
        return c(str, this.f15341a.H(), true);
    }

    private Collection<Character> j() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f15333b.a(b.bm)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public Uri a(String str, List<String> list, boolean z2) {
        String str2;
        if (this.f15344e != null) {
            return b(str, list, z2);
        }
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (v.a()) {
            a("Caching video " + str + "...");
        }
        String a2 = this.f15343d.a(f(), str, this.f15341a.L(), list, z2, this.f15346g);
        if (StringUtils.isValidString(a2)) {
            File a3 = this.f15343d.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    if (v.a()) {
                        a("Finish caching video for ad #" + this.f15341a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a2);
                    }
                    return fromFile;
                } else if (!v.a()) {
                    return null;
                } else {
                    str2 = "Unable to create URI from cached video file = " + a3;
                }
            } else if (!v.a()) {
                return null;
            } else {
                str2 = "Unable to cache video = " + str + "Video file was missing or null";
            }
            d(str2);
            return null;
        }
        if (v.a()) {
            d("Failed to cache video");
        }
        h();
        return null;
    }

    /* access modifiers changed from: package-private */
    public String a(String str, List<String> list) {
        InputStream inputStream;
        if (this.f15344e != null) {
            return b(str, list);
        }
        if (StringUtils.isValidString(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                if (v.a()) {
                    a("Nothing to cache, skipping...");
                }
                return null;
            }
            String fileName = ((Boolean) this.f15333b.a(b.eT)).booleanValue() ? Utils.getFileName(parse) : parse.getLastPathSegment();
            if (StringUtils.isValidString(this.f15341a.L())) {
                fileName = this.f15341a.L() + fileName;
            }
            try {
                File a2 = this.f15343d.a(fileName, f());
                if (a2 != null && a2.exists()) {
                    return this.f15343d.a(a2);
                }
                inputStream = this.f15343d.a(str, list, true, this.f15346g);
                if (inputStream != null) {
                    try {
                        this.f15343d.b(inputStream, a2);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                Utils.close(inputStream, this.f15333b);
                return this.f15343d.a(a2);
            } catch (Throwable th2) {
                if (v.a()) {
                    a("Resource at " + str + " failed to load.", th2);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String a(String str, List<String> list, e eVar) {
        StringBuilder sb;
        if (!StringUtils.isValidString(str)) {
            return str;
        }
        if (!((Boolean) this.f15333b.a(b.bn)).booleanValue()) {
            if (v.a()) {
                a("Resource caching is disabled, skipping cache...");
            }
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        boolean shouldCancelHtmlCachingIfShown = eVar.shouldCancelHtmlCachingIfShown();
        boolean aK = eVar.aK();
        List<String> G = eVar.G();
        for (String next : list) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < sb2.length()) {
                if (b()) {
                    return str;
                }
                i2 = sb2.indexOf(next, i3);
                if (i2 == -1) {
                    continue;
                    break;
                }
                int length = sb2.length();
                int i4 = i2;
                while (!this.f15345f.contains(Character.valueOf(sb2.charAt(i4))) && i4 < length) {
                    i4++;
                }
                if (i4 <= i2 || i4 == length) {
                    if (v.a()) {
                        d("Unable to cache resource; ad HTML is invalid.");
                    }
                    return str;
                }
                String substring = sb2.substring(next.length() + i2, i4);
                if (StringUtils.isValidString(substring)) {
                    if (!shouldCancelHtmlCachingIfShown || !eVar.hasShown()) {
                        if (aK) {
                            String d2 = eVar.d();
                            if (d2.equals(next + substring)) {
                                if (v.a()) {
                                    sb = new StringBuilder();
                                    sb.append("Postponing caching for \"");
                                    sb.append(substring);
                                    substring = "\" video resource";
                                } else {
                                    i3 = i4;
                                }
                            }
                        }
                        Uri a2 = a(next, substring);
                        if (a2 != null) {
                            sb2.replace(i2, i4, a2.toString());
                            eVar.b(a2);
                            this.f15346g.e();
                        } else {
                            if (G.contains(next + substring)) {
                                h();
                                this.f15347h = true;
                            }
                            this.f15346g.f();
                        }
                        i3 = i4;
                    } else {
                        if (v.a()) {
                            a("Cancelling HTML caching due to ad being shown already");
                        }
                        this.f15346g.a();
                        return str;
                    }
                } else if (v.a()) {
                    sb = new StringBuilder();
                    sb.append("Skip caching of non-resource ");
                } else {
                    i3 = i4;
                }
                sb.append(substring);
                a(sb.toString());
                i3 = i4;
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f15333b.H().b(this);
    }

    public void a(a aVar) {
        if (aVar.f().equalsIgnoreCase(this.f15341a.N())) {
            if (v.a()) {
                d("Updating flag for timeout...");
            }
            this.f15347h = true;
        }
        this.f15333b.H().b(this);
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAdBase appLovinAdBase) {
        d.a(this.f15346g, appLovinAdBase, this.f15333b);
    }

    /* access modifiers changed from: package-private */
    public Uri b(String str, List<String> list, boolean z2) {
        String str2;
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        a("Caching video " + str + "...");
        String a2 = this.f15344e.a(f(), str, this.f15341a.L(), list, z2, this.f15346g);
        if (StringUtils.isValidString(a2)) {
            File a3 = this.f15344e.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    a("Finish caching video for ad #" + this.f15341a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a2);
                    return fromFile;
                }
                str2 = "Unable to create URI from cached video file = " + a3;
            } else {
                str2 = "Unable to cache video = " + str + "Video file was missing or null";
            }
            d(str2);
            return null;
        }
        d("Failed to cache video");
        h();
        Bundle bundle = new Bundle();
        bundle.putLong("ad_id", this.f15341a.getAdIdNumber());
        bundle.putInt("load_response_code", this.f15346g.j());
        Exception i2 = this.f15346g.i();
        if (i2 != null) {
            bundle.putString("load_exception_message", i2.getMessage());
        }
        this.f15333b.ag().a(bundle, "video_caching_failed");
        return null;
    }

    /* access modifiers changed from: package-private */
    public String b(String str, List<String> list) {
        if (StringUtils.isValidString(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                a("Nothing to cache, skipping...");
                return null;
            }
            String fileName = ((Boolean) this.f15333b.a(b.eT)).booleanValue() ? Utils.getFileName(parse) : parse.getLastPathSegment();
            if (StringUtils.isValidString(this.f15341a.L())) {
                fileName = this.f15341a.L() + fileName;
            }
            File a2 = this.f15344e.a(fileName, f());
            ByteArrayOutputStream a3 = (a2 == null || !a2.exists()) ? null : this.f15344e.a(a2);
            if (a3 == null) {
                a3 = this.f15344e.a(str, list, true, this.f15346g);
                if (a3 != null) {
                    this.f15344e.a(a3, a2);
                    this.f15346g.a((long) a3.size());
                }
            } else {
                this.f15346g.b((long) a3.size());
            }
            try {
                return a3.toString("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                a("UTF-8 encoding not supported.", e2);
            } catch (Throwable th) {
                a("String resource at " + str + " failed to load.", th);
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.f15347h;
    }

    /* access modifiers changed from: package-private */
    public Uri c(String str, List<String> list, boolean z2) {
        String str2;
        if (this.f15344e != null) {
            return d(str, list, z2);
        }
        try {
            String a2 = this.f15343d.a(f(), str, this.f15341a.L(), list, z2, this.f15346g);
            if (!StringUtils.isValidString(a2)) {
                return null;
            }
            File a3 = this.f15343d.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    return fromFile;
                }
                if (!v.a()) {
                    return null;
                }
                str2 = "Unable to extract Uri from image file";
            } else if (!v.a()) {
                return null;
            } else {
                str2 = "Unable to retrieve File from cached image filename = " + a2;
            }
            d(str2);
            return null;
        } catch (Throwable th) {
            if (!v.a()) {
                return null;
            }
            a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (v.a()) {
            a("Caching mute images...");
        }
        Uri a2 = a(this.f15341a.aC(), "mute");
        if (a2 != null) {
            this.f15341a.c(a2);
        }
        Uri a3 = a(this.f15341a.aD(), "unmute");
        if (a3 != null) {
            this.f15341a.d(a3);
        }
        if (v.a()) {
            a("Ad updated with muteImageFilename = " + this.f15341a.aC() + ", unmuteImageFilename = " + this.f15341a.aD());
        }
    }

    /* access modifiers changed from: package-private */
    public Uri d(String str, List<String> list, boolean z2) {
        String str2;
        try {
            String a2 = this.f15344e.a(f(), str, this.f15341a.L(), list, z2, this.f15346g);
            if (!StringUtils.isValidString(a2)) {
                return null;
            }
            File a3 = this.f15344e.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    return fromFile;
                }
                str2 = "Unable to extract Uri from image file";
            } else {
                str2 = "Unable to retrieve File from cached image filename = " + a2;
            }
            d(str2);
            return null;
        } catch (Throwable th) {
            a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Uri e(String str) {
        return a(str, this.f15341a.H(), true);
    }

    /* access modifiers changed from: package-private */
    public String f(final String str) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        com.applovin.impl.sdk.network.c a2 = com.applovin.impl.sdk.network.c.a(this.f15333b).a(str).b("GET").a("").a(0).a();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        this.f15333b.R().a(a2, new b.a(), new b.c<String>() {
            public void a(int i2, String str, String str2) {
                c cVar = c.this;
                cVar.d("Failed to load resource from '" + str + "'");
            }

            public void a(String str, int i2) {
                atomicReference.set(str);
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.f15346g.a((long) str2.length());
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f15342c;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            this.f15342c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (v.a()) {
            a("Rendered new ad:" + this.f15341a);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (c.this.f15342c != null) {
                    c.this.f15342c.adReceived(c.this.f15341a);
                    AppLovinAdLoadListener unused = c.this.f15342c = null;
                }
            }
        });
    }

    public void run() {
        if (this.f15341a.M()) {
            if (v.a()) {
                a("Subscribing to timeout events...");
            }
            this.f15333b.H().a((h.a) this);
        }
    }
}
