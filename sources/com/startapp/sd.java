package com.startapp;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.startapp.ic;
import com.startapp.lb;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class sd extends r6 {

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f35861g = new HashSet();

    /* renamed from: h  reason: collision with root package name */
    public Set<String> f35862h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public GetAdRequest f35863i;

    /* renamed from: j  reason: collision with root package name */
    public int f35864j = 0;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f35865k;

    /* renamed from: l  reason: collision with root package name */
    public k3 f35866l;

    public class a implements sa<String, Void> {
        public a() {
        }

        public Object a(Object obj) {
            sd.this.f35758f = (String) obj;
            return null;
        }
    }

    public sd(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement, boolean z2) {
        super(context, ad, adPreferences, adEventListener, placement);
        this.f35865k = z2;
    }

    public boolean a(Object obj) {
        boolean z2;
        if (obj == null) {
            if (this.f35758f == null) {
                this.f35758f = "No response";
            }
            return false;
        } else if (!(obj instanceof ic.a)) {
            if (this.f35758f == null) {
                this.f35758f = "Unknown error";
            }
            return false;
        } else {
            ic.a aVar = (ic.a) obj;
            String str = aVar.f34700a;
            try {
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(str)) {
                    if (this.f35758f == null) {
                        GetAdRequest getAdRequest = this.f35863i;
                        if (getAdRequest == null || !getAdRequest.b()) {
                            this.f35758f = "Empty Ad";
                        } else {
                            this.f35758f = "Video isn't available";
                        }
                    }
                    return false;
                }
                boolean H = AdsCommonMetaData.f36186h.H();
                String a2 = lb.a(str, "@adId@", "@adId@");
                if (a2 != null && a2.length() > 0) {
                    this.f35866l = new k3(a2, aVar, this.f35865k, H);
                }
                List<AppPresenceDetails> a3 = p.a(str, this.f35864j);
                if (!H || !p.a(this.f35753a, a3, this.f35864j, this.f35861g, (List<AppPresenceDetails>) arrayList).booleanValue()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                k3 k3Var = this.f35866l;
                if (k3Var != null) {
                    k3Var.f34806g = z2;
                }
                if (z2) {
                    new s7(this.f35753a, arrayList).a();
                } else {
                    HtmlAd htmlAd = (HtmlAd) this.f35754b;
                    htmlAd.a(a3);
                    htmlAd.c(str);
                }
                k3 k3Var2 = this.f35866l;
                if (k3Var2 != null) {
                    k3Var2.f34807h = lb.a();
                }
                if (!z2) {
                    return true;
                }
                f();
                this.f35864j++;
                return b();
            } catch (Throwable th) {
                y8.a(this.f35753a, th);
                return false;
            }
        }
    }

    public void b(boolean z2) {
        this.f35754b.setState(z2 ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
    }

    public boolean b(GetAdRequest getAdRequest) {
        return getAdRequest != null;
    }

    public void c(boolean z2) {
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.f35754b.hashCode());
        intent.putExtra("adResult", z2);
        wb.a(this.f35753a).a(intent);
        if (!z2) {
            p.a(this.f35753a, a(), this.f35754b);
            f();
        } else if (this.f35865k) {
            k3 k3Var = this.f35866l;
            if (k3Var != null) {
                k3Var.f34808i = lb.a();
            }
            ComponentLocator.a(this.f35753a).f36430d.b().a(((HtmlAd) this.f35754b).j(), new b());
        } else {
            p.b(this.f35753a, a(), this.f35754b);
            f();
        }
    }

    public Object e() {
        GetAdRequest d2 = d();
        this.f35863i = d2;
        if (!b(d2)) {
            return null;
        }
        if (this.f35861g.size() == 0) {
            this.f35861g.add(this.f35753a.getPackageName());
        }
        GetAdRequest getAdRequest = this.f35863i;
        getAdRequest.B0 = this.f35861g;
        getAdRequest.D0 = this.f35862h;
        if (this.f35864j > 0) {
            getAdRequest.F0 = false;
            if (MetaData.f36379h.E().a(this.f35753a)) {
                SimpleTokenUtils.e(this.f35753a);
            }
        }
        w8 j2 = ComponentLocator.a(this.f35753a).j();
        String a2 = AdsConstants.a(AdsConstants.AdApiType.HTML, this.f35757e);
        j2.getClass();
        try {
            return j2.a(a2, this.f35863i, new a());
        } catch (Throwable th) {
            y8.a(j2.f36819a, th);
            return null;
        }
    }

    public final void f() {
        k3 k3Var = this.f35866l;
        if (k3Var != null) {
            Context context = this.f35753a;
            try {
                ComponentLocator.a(context).I.b().a(k3Var);
            } catch (Throwable th) {
                y8.a(context, th);
            }
            this.f35866l = null;
        }
    }

    public class b implements lb.a {
        public b() {
        }

        public void a(boolean z2, long j2, long j3, boolean z3) {
            sd sdVar = sd.this;
            p.b(sdVar.f35753a, sdVar.a(), sd.this.f35754b);
            sd sdVar2 = sd.this;
            k3 k3Var = sdVar2.f35866l;
            if (k3Var != null) {
                k3Var.f34805f = z2;
                k3Var.f34809j = j2;
                k3Var.f34810k = j3;
                k3Var.f34812m = z3;
                sdVar2.f();
            }
        }

        public void a(int i2, String str) {
            sd.this.f35754b.setErrorMessage(str);
            sd sdVar = sd.this;
            p.a(sdVar.f35753a, sdVar.a(), sd.this.f35754b);
            sd sdVar2 = sd.this;
            k3 k3Var = sdVar2.f35866l;
            if (k3Var != null) {
                k3Var.f34811l = i2;
                sdVar2.f();
            }
        }
    }
}
