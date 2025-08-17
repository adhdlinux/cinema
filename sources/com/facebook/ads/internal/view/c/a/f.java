package com.facebook.ads.internal.view.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.PagerSnapHelper;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.g;
import com.facebook.ads.internal.adapters.a.h;
import com.facebook.ads.internal.d.b;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.c.a.d;
import com.facebook.ads.internal.view.component.d;
import com.facebook.ads.internal.view.i;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f extends i {

    /* renamed from: e  reason: collision with root package name */
    private static final int f20994e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f20995f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f20996g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f20997h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f20998i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final u f20999j = new u();

    /* renamed from: k  reason: collision with root package name */
    private b f21000k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f21001l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f21002m;

    /* renamed from: n  reason: collision with root package name */
    private long f21003n;

    /* renamed from: o  reason: collision with root package name */
    private String f21004o;

    /* renamed from: p  reason: collision with root package name */
    private List<b> f21005p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public d f21006q;

    /* renamed from: r  reason: collision with root package name */
    private c f21007r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public a f21008s;

    /* renamed from: t  reason: collision with root package name */
    private a.C0035a f21009t;

    /* renamed from: u  reason: collision with root package name */
    private int f21010u;

    /* renamed from: v  reason: collision with root package name */
    private int f21011v;

    static {
        float f2 = x.f20694b;
        f20994e = (int) (48.0f * f2);
        f20995f = (int) (f2 * 8.0f);
        f20996g = (int) (8.0f * f2);
        f20997h = (int) (56.0f * f2);
        f20998i = (int) (f2 * 12.0f);
    }

    public f(Context context, c cVar, b bVar) {
        super(context, cVar);
        this.f21000k = bVar;
    }

    private void a(g gVar) {
        this.f21002m = gVar.c();
        this.f21004o = gVar.e();
        this.f21010u = gVar.f();
        this.f21011v = gVar.g();
        List<h> d2 = gVar.d();
        this.f21005p = new ArrayList(d2.size());
        for (int i2 = 0; i2 < d2.size(); i2++) {
            this.f21005p.add(new b(i2, d2.size(), d2.get(i2)));
        }
    }

    private void a(a aVar) {
        new PagerSnapHelper().b(this.f21007r);
        aVar.a((d.a) new d.a() {
            public void a(int i2) {
                if (f.this.f21006q != null) {
                    f.this.f21006q.a(i2);
                }
            }
        });
        this.f21006q = new com.facebook.ads.internal.view.component.d(getContext(), this.f21616d.a(), this.f21005p.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f20996g);
        layoutParams.setMargins(0, f20998i, 0, 0);
        this.f21006q.setLayoutParams(layoutParams);
    }

    public void a() {
        LinearLayout linearLayout = this.f21001l;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.f21001l = null;
        }
        c cVar = this.f21007r;
        if (cVar != null) {
            cVar.removeAllViews();
            this.f21007r = null;
        }
        com.facebook.ads.internal.view.component.d dVar = this.f21006q;
        if (dVar != null) {
            dVar.removeAllViews();
            this.f21006q = null;
        }
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        g gVar = (g) intent.getSerializableExtra("ad_data_bundle");
        super.a(audienceNetworkActivity, gVar);
        a(gVar);
        setUpLayout(audienceNetworkActivity.getResources().getConfiguration().orientation);
        this.f21003n = System.currentTimeMillis();
    }

    public void a(Bundle bundle) {
    }

    public void i() {
    }

    public void j() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        a();
        setUpLayout(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        super.onDestroy();
        com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(this.f21003n, a.C0033a.XOUT, this.f21004o));
        if (!TextUtils.isEmpty(this.f21002m)) {
            HashMap hashMap = new HashMap();
            this.f21008s.a((Map<String, String>) hashMap);
            hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(this.f20999j.e()));
            this.f21614b.i(this.f21002m, hashMap);
        }
        a();
        this.f21008s.c();
        this.f21008s = null;
        this.f21009t = null;
        this.f21005p = null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f20999j.a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setUpLayout(int i2) {
        int i3;
        int i4;
        int i5;
        f fVar;
        int i6 = i2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f21001l = linearLayout;
        linearLayout.setGravity(i6 == 1 ? 17 : 48);
        this.f21001l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f21001l.setOrientation(1);
        DisplayMetrics displayMetrics = x.f20693a;
        int i7 = displayMetrics.widthPixels;
        int i8 = displayMetrics.heightPixels;
        if (i6 == 1) {
            int min = Math.min(i7 - (f20995f * 4), i8 / 2);
            int i9 = (i7 - min) / 8;
            i5 = min;
            i4 = i9;
            i3 = i9 * 4;
        } else {
            int i10 = f20997h + f20994e;
            int i11 = f20995f;
            i5 = i8 - (i10 + (i11 * 2));
            i3 = i11 * 2;
            i4 = i11;
        }
        this.f21009t = new a.C0035a() {
            public void a() {
                HashMap hashMap = new HashMap();
                if (!f.this.f20999j.b()) {
                    f.this.f20999j.a();
                    if (f.this.getAudienceNetworkListener() != null) {
                        f.this.getAudienceNetworkListener().a("com.facebook.ads.interstitial.impression.logged");
                    }
                    if (!TextUtils.isEmpty(f.this.f21002m)) {
                        f.this.f21008s.a((Map<String, String>) hashMap);
                        hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(f.this.f20999j.e()));
                        f.this.f21614b.a(f.this.f21002m, hashMap);
                    }
                }
            }
        };
        com.facebook.ads.internal.r.a aVar = new com.facebook.ads.internal.r.a(this, 1, this.f21009t);
        this.f21008s = aVar;
        aVar.a(this.f21010u);
        this.f21008s.b(this.f21011v);
        c cVar = new c(getContext());
        this.f21007r = cVar;
        cVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        a aVar2 = new a(this.f21007r, i6, this.f21005p, this.f21008s);
        c cVar2 = this.f21007r;
        List<b> list = this.f21005p;
        c cVar3 = this.f21614b;
        b bVar = this.f21000k;
        com.facebook.ads.internal.r.a aVar3 = this.f21008s;
        u uVar = this.f20999j;
        a.C0037a audienceNetworkListener = getAudienceNetworkListener();
        com.facebook.ads.internal.adapters.a.a aVar4 = this.f21616d;
        d dVar = r1;
        a aVar5 = aVar2;
        d dVar2 = new d(list, cVar3, bVar, aVar3, uVar, audienceNetworkListener, i6 == 1 ? aVar4.a() : aVar4.b(), this.f21002m, i5, i4, i3, i2, aVar5);
        cVar2.setAdapter(dVar);
        int i12 = i2;
        if (i12 == 1) {
            fVar = this;
            fVar.a(aVar5);
        } else {
            fVar = this;
        }
        fVar.f21001l.addView(fVar.f21007r);
        com.facebook.ads.internal.view.component.d dVar3 = fVar.f21006q;
        if (dVar3 != null) {
            fVar.f21001l.addView(dVar3);
        }
        fVar.a(fVar.f21001l, false, i12);
    }
}
