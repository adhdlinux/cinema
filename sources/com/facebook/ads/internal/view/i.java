package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.a;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.adapters.a.g;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.r;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.f;

public abstract class i extends RelativeLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f21613a = ((int) (x.f20694b * 56.0f));
    /* access modifiers changed from: protected */

    /* renamed from: b  reason: collision with root package name */
    public final c f21614b;

    /* renamed from: c  reason: collision with root package name */
    protected final f f21615c = new f(getContext());

    /* renamed from: d  reason: collision with root package name */
    protected a f21616d;

    /* renamed from: e  reason: collision with root package name */
    private a.C0037a f21617e;

    /* renamed from: f  reason: collision with root package name */
    private final r f21618f = new r(this);

    protected i(Context context, c cVar) {
        super(context.getApplicationContext());
        this.f21614b = cVar;
    }

    private void a() {
        removeAllViews();
        x.b(this);
    }

    /* access modifiers changed from: protected */
    public void a(View view, boolean z2, int i2) {
        int i3;
        d dVar;
        f fVar;
        this.f21618f.a(r.a.DEFAULT);
        a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, z2 ? 0 : f21613a, 0, 0);
        addView(view, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, f21613a);
        layoutParams2.addRule(10);
        if (i2 == 1) {
            i3 = this.f21616d.a().d(z2);
            fVar = this.f21615c;
            dVar = this.f21616d.a();
        } else {
            i3 = this.f21616d.b().d(z2);
            fVar = this.f21615c;
            dVar = this.f21616d.b();
        }
        fVar.a(dVar, z2);
        addView(this.f21615c, layoutParams2);
        x.a((View) this, i3);
        a.C0037a aVar = this.f21617e;
        if (aVar != null) {
            aVar.a((View) this);
            if (z2) {
                this.f21618f.a(r.a.FULL_SCREEN);
            }
        }
    }

    public void a(final AudienceNetworkActivity audienceNetworkActivity, g gVar) {
        this.f21618f.a(audienceNetworkActivity.getWindow());
        this.f21616d = gVar.b();
        this.f21615c.a(gVar.a(), gVar.c(), gVar.d().get(0).c().c());
        this.f21615c.setToolbarListener(new f.a() {
            public void a() {
                audienceNetworkActivity.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public a.C0037a getAudienceNetworkListener() {
        return this.f21617e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        this.f21615c.d();
        super.onConfigurationChanged(configuration);
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                i.this.f21615c.e();
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        });
    }

    public void onDestroy() {
        this.f21618f.a();
        this.f21615c.setToolbarListener((f.a) null);
        a();
    }

    public void setListener(a.C0037a aVar) {
        this.f21617e = aVar;
    }
}
