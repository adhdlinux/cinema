package com.applovin.impl.mediation.debugger.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private final com.applovin.impl.mediation.debugger.b.b.b f14678a;

    /* renamed from: b  reason: collision with root package name */
    private List<c> f14679b;

    /* renamed from: d  reason: collision with root package name */
    private final List<c> f14680d;

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f14681e;

    /* renamed from: f  reason: collision with root package name */
    private final List<c> f14682f;

    /* renamed from: g  reason: collision with root package name */
    private final List<c> f14683g;

    /* renamed from: h  reason: collision with root package name */
    private SpannedString f14684h;

    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    b(com.applovin.impl.mediation.debugger.b.b.b bVar, Context context) {
        super(context);
        this.f14678a = bVar;
        if (bVar.a() == b.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f14684h = new SpannedString(spannableString);
        } else {
            this.f14684h = new SpannedString("");
        }
        this.f14679b = d();
        this.f14680d = a(bVar.r());
        this.f14681e = a(bVar.t());
        this.f14682f = b(bVar.s());
        this.f14683g = h();
        notifyDataSetChanged();
    }

    private int a(boolean z2) {
        return z2 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }

    private c a(b.C0015b bVar) {
        c.a p2 = c.p();
        if (bVar == b.C0015b.READY) {
            p2.a(this.f14736c);
        }
        return p2.a("Test Mode").b(bVar.a()).b(bVar.b()).d(bVar.c()).a(true).a();
    }

    private List<c> a(com.applovin.impl.mediation.debugger.b.b.c cVar) {
        ArrayList arrayList = new ArrayList(1);
        if (cVar.a()) {
            boolean b2 = cVar.b();
            arrayList.add(c.a(b2 ? c.b.RIGHT_DETAIL : c.b.DETAIL).a("Cleartext Traffic").b(b2 ? null : this.f14684h).d(cVar.c()).a(a(b2)).c(b(b2)).a(true ^ b2).a());
        }
        return arrayList;
    }

    private List<c> a(List<com.applovin.impl.mediation.debugger.b.b.d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.b.d next : list) {
                boolean c2 = next.c();
                arrayList.add(c.a(c2 ? c.b.RIGHT_DETAIL : c.b.DETAIL).a(next.a()).b(c2 ? null : this.f14684h).d(next.b()).a(a(c2)).c(b(c2)).a(!c2).a());
            }
        }
        return arrayList;
    }

    private int b(boolean z2) {
        return f.a(z2 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f14736c);
    }

    private List<c> b(List<com.applovin.impl.mediation.debugger.b.b.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.b.a next : list) {
                boolean c2 = next.c();
                arrayList.add(c.a(c2 ? c.b.RIGHT_DETAIL : c.b.DETAIL).a(next.a()).b(c2 ? null : this.f14684h).d(next.b()).a(a(c2)).c(b(c2)).a(!c2).a());
            }
        }
        return arrayList;
    }

    private c c(List<String> list) {
        return c.p().a("Region/VPN Required").b(CollectionUtils.implode(list, ", ", list.size())).a();
    }

    private List<c> d() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(e());
        arrayList.add(f());
        arrayList.add(g());
        return arrayList;
    }

    private c e() {
        c.a b2 = c.p().a("SDK").b(this.f14678a.j());
        if (TextUtils.isEmpty(this.f14678a.j())) {
            b2.a(a(this.f14678a.d())).c(b(this.f14678a.d()));
        }
        return b2.a();
    }

    private String e(int i2) {
        return (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i2 || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i2 || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i2) ? "Initialized" : MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i2 ? "Failure" : MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i2 ? "Initializing..." : "Not Initialized";
    }

    private c f() {
        c.a b2 = c.p().a("Adapter").b(this.f14678a.k());
        if (TextUtils.isEmpty(this.f14678a.k())) {
            b2.a(a(this.f14678a.e())).c(b(this.f14678a.e()));
        }
        return b2.a();
    }

    private c g() {
        return c.p().a("Initialization Status").b(e(this.f14678a.b())).a(false).a();
    }

    private List<c> h() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.f14678a.u())) {
            arrayList.add(c.a(c.b.DETAIL).a(this.f14678a.u()).a());
        }
        if (this.f14678a.c() != b.C0015b.NOT_SUPPORTED) {
            if (this.f14678a.n() != null) {
                arrayList.add(c(this.f14678a.n()));
            }
            arrayList.add(a(this.f14678a.c()));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        return (i2 == a.INTEGRATIONS.ordinal() ? this.f14679b : i2 == a.PERMISSIONS.ordinal() ? this.f14680d : i2 == a.CONFIGURATION.ordinal() ? this.f14681e : i2 == a.DEPENDENCIES.ordinal() ? this.f14682f : this.f14683g).size();
    }

    public com.applovin.impl.mediation.debugger.b.b.b a() {
        return this.f14678a;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return a.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public c b(int i2) {
        return i2 == a.INTEGRATIONS.ordinal() ? new e("INTEGRATIONS") : i2 == a.PERMISSIONS.ordinal() ? new e("PERMISSIONS") : i2 == a.CONFIGURATION.ordinal() ? new e("CONFIGURATION") : i2 == a.DEPENDENCIES.ordinal() ? new e("DEPENDENCIES") : new e("TEST ADS");
    }

    /* access modifiers changed from: protected */
    public List<c> c(int i2) {
        return i2 == a.INTEGRATIONS.ordinal() ? this.f14679b : i2 == a.PERMISSIONS.ordinal() ? this.f14680d : i2 == a.CONFIGURATION.ordinal() ? this.f14681e : i2 == a.DEPENDENCIES.ordinal() ? this.f14682f : this.f14683g;
    }

    public void c() {
        this.f14679b = d();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }
}
