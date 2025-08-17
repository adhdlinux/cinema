package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.d;
import com.facebook.ads.internal.view.f.b.e;
import com.facebook.ads.internal.view.f.b.g;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;
import com.facebook.ads.internal.view.f.b.p;

public class u implements a {

    /* renamed from: a  reason: collision with root package name */
    private final k f21713a;

    /* renamed from: b  reason: collision with root package name */
    private final i f21714b;

    /* renamed from: c  reason: collision with root package name */
    private final c f21715c;

    /* renamed from: d  reason: collision with root package name */
    private final e f21716d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AudienceNetworkActivity f21717e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.ads.internal.m.c f21718f;

    /* renamed from: g  reason: collision with root package name */
    private final a f21719g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final a.C0037a f21720h;

    /* renamed from: i  reason: collision with root package name */
    private b f21721i;

    /* renamed from: j  reason: collision with root package name */
    private int f21722j;

    public u(final AudienceNetworkActivity audienceNetworkActivity, com.facebook.ads.internal.m.c cVar, a.C0037a aVar) {
        AnonymousClass1 r02 = new k() {
            public void a(j jVar) {
                u.this.f21720h.a("videoInterstitalEvent", jVar);
            }
        };
        this.f21713a = r02;
        AnonymousClass2 r12 = new i() {
            public void a(h hVar) {
                u.this.f21720h.a("videoInterstitalEvent", hVar);
            }
        };
        this.f21714b = r12;
        AnonymousClass3 r2 = new c() {
            public void a(com.facebook.ads.internal.view.f.b.b bVar) {
                u.this.f21720h.a("videoInterstitalEvent", bVar);
            }
        };
        this.f21715c = r2;
        AnonymousClass4 r3 = new e() {
            public void a(d dVar) {
                u.this.f21717e.finish();
            }
        };
        this.f21716d = r3;
        this.f21717e = audienceNetworkActivity;
        this.f21718f = cVar;
        com.facebook.ads.internal.view.f.a aVar2 = new com.facebook.ads.internal.view.f.a(audienceNetworkActivity);
        this.f21719g = aVar2;
        aVar2.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.b(audienceNetworkActivity));
        aVar2.getEventBus().a((T[]) new f[]{r02, r12, r2, r3});
        this.f21720h = aVar;
        aVar2.setIsFullScreen(true);
        aVar2.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        aVar2.setLayoutParams(layoutParams);
        aVar.a((View) aVar2);
        d dVar = new d(audienceNetworkActivity);
        dVar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                audienceNetworkActivity.finish();
            }
        });
        aVar.a((View) dVar);
    }

    public void a(int i2) {
        this.f21719g.setVideoProgressReportIntervalMs(i2);
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        String stringExtra = intent.getStringExtra("useNativeCtaButton");
        if (stringExtra != null && !stringExtra.isEmpty()) {
            com.facebook.ads.internal.view.c.b bVar = new com.facebook.ads.internal.view.c.b(audienceNetworkActivity, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i2 = (int) (x.f20694b * 16.0f);
            layoutParams.setMargins(i2, i2, i2, i2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            bVar.setLayoutParams(layoutParams);
            bVar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    u.this.f21720h.a("performCtaClick");
                }
            });
            this.f21720h.a((View) bVar);
        }
        this.f21722j = intent.getIntExtra(AudienceNetworkActivity.VIDEO_SEEK_TIME, 0);
        this.f21721i = new b((Context) audienceNetworkActivity, this.f21718f, this.f21719g, intent.getStringExtra(AudienceNetworkActivity.CLIENT_TOKEN), intent.getBundleExtra(AudienceNetworkActivity.VIDEO_LOGGER));
        this.f21719g.setVideoMPD(intent.getStringExtra(AudienceNetworkActivity.VIDEO_MPD));
        this.f21719g.setVideoURI(intent.getStringExtra(AudienceNetworkActivity.VIDEO_URL));
        int i3 = this.f21722j;
        if (i3 > 0) {
            this.f21719g.a(i3);
        }
        if (intent.getBooleanExtra(AudienceNetworkActivity.AUTOPLAY, false)) {
            this.f21719g.a(com.facebook.ads.internal.view.f.a.a.USER_STARTED);
        }
    }

    public void a(Bundle bundle) {
    }

    public void a(View view) {
        this.f21719g.setControlsAnchorView(view);
    }

    public void i() {
        this.f21720h.a("videoInterstitalEvent", new com.facebook.ads.internal.view.f.b.f());
        this.f21719g.a(false);
    }

    public void j() {
        this.f21720h.a("videoInterstitalEvent", new g());
        this.f21719g.a(com.facebook.ads.internal.view.f.a.a.USER_STARTED);
    }

    public void onDestroy() {
        this.f21720h.a("videoInterstitalEvent", new p(this.f21722j, this.f21719g.getCurrentPositionInMillis()));
        this.f21721i.b(this.f21719g.getCurrentPositionInMillis());
        this.f21719g.f();
        this.f21719g.k();
    }

    public void setListener(a.C0037a aVar) {
    }
}
