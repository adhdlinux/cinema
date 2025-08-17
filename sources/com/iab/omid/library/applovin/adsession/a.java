package com.iab.omid.library.applovin.adsession;

import android.view.View;
import com.iab.omid.library.applovin.b.c;
import com.iab.omid.library.applovin.b.f;
import com.iab.omid.library.applovin.d.e;
import com.iab.omid.library.applovin.publisher.AdSessionStatePublisher;
import com.iab.omid.library.applovin.publisher.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a extends AdSession {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f31469a = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: b  reason: collision with root package name */
    private final AdSessionContext f31470b;

    /* renamed from: c  reason: collision with root package name */
    private final AdSessionConfiguration f31471c;

    /* renamed from: d  reason: collision with root package name */
    private final List<c> f31472d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private com.iab.omid.library.applovin.e.a f31473e;

    /* renamed from: f  reason: collision with root package name */
    private AdSessionStatePublisher f31474f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31475g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f31476h = false;

    /* renamed from: i  reason: collision with root package name */
    private final String f31477i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31478j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31479k;

    /* renamed from: l  reason: collision with root package name */
    private PossibleObstructionListener f31480l;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f31471c = adSessionConfiguration;
        this.f31470b = adSessionContext;
        this.f31477i = UUID.randomUUID().toString();
        c((View) null);
        this.f31474f = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.applovin.publisher.a(adSessionContext.getWebView()) : new b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f31474f.a();
        com.iab.omid.library.applovin.b.a.a().a(this);
        this.f31474f.a(adSessionConfiguration);
    }

    private c a(View view) {
        for (c next : this.f31472d) {
            if (next.a().get() == view) {
                return next;
            }
        }
        return null;
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!f31469a.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private static void b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void c(View view) {
        this.f31473e = new com.iab.omid.library.applovin.e.a(view);
    }

    private void d(View view) {
        Collection<a> b2 = com.iab.omid.library.applovin.b.a.a().b();
        if (b2 != null && !b2.isEmpty()) {
            for (a next : b2) {
                if (next != this && next.e() == view) {
                    next.f31473e.clear();
                }
            }
        }
    }

    private void k() {
        if (this.f31478j) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void l() {
        if (this.f31479k) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public List<c> a() {
        return this.f31472d;
    }

    public void a(List<com.iab.omid.library.applovin.e.a> list) {
        if (b()) {
            ArrayList arrayList = new ArrayList();
            for (com.iab.omid.library.applovin.e.a aVar : list) {
                View view = (View) aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f31480l.onPossibleObstructionsDetected(this.f31477i, arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        l();
        getAdSessionStatePublisher().a(jSONObject);
        this.f31479k = true;
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (!this.f31476h) {
            b(view);
            a(str);
            if (a(view) == null) {
                this.f31472d.add(new c(view, friendlyObstructionPurpose, str));
            }
        }
    }

    public boolean b() {
        return this.f31480l != null;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        k();
        getAdSessionStatePublisher().g();
        this.f31478j = true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        l();
        getAdSessionStatePublisher().h();
        this.f31479k = true;
    }

    public View e() {
        return (View) this.f31473e.get();
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f31476h) {
            e.a((Object) errorType, "Error type is null");
            e.a(str, "Message is null");
            getAdSessionStatePublisher().a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public boolean f() {
        return this.f31475g && !this.f31476h;
    }

    public void finish() {
        if (!this.f31476h) {
            this.f31473e.clear();
            removeAllFriendlyObstructions();
            this.f31476h = true;
            getAdSessionStatePublisher().f();
            com.iab.omid.library.applovin.b.a.a().c(this);
            getAdSessionStatePublisher().b();
            this.f31474f = null;
            this.f31480l = null;
        }
    }

    public boolean g() {
        return this.f31475g;
    }

    public String getAdSessionId() {
        return this.f31477i;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f31474f;
    }

    public boolean h() {
        return this.f31476h;
    }

    public boolean i() {
        return this.f31471c.isNativeImpressionOwner();
    }

    public boolean j() {
        return this.f31471c.isNativeMediaEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f31476h) {
            e.a((Object) view, "AdView is null");
            if (e() != view) {
                c(view);
                getAdSessionStatePublisher().i();
                d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f31476h) {
            this.f31472d.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f31476h) {
            b(view);
            c a2 = a(view);
            if (a2 != null) {
                this.f31472d.remove(a2);
            }
        }
    }

    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f31480l = possibleObstructionListener;
    }

    public void start() {
        if (!this.f31475g) {
            this.f31475g = true;
            com.iab.omid.library.applovin.b.a.a().b(this);
            this.f31474f.a(f.a().d());
            this.f31474f.a(this, this.f31470b);
        }
    }
}
