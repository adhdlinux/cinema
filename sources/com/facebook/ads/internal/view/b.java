package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.a.a;
import com.facebook.ads.internal.view.a.c;
import com.facebook.ads.internal.view.a.f;

@TargetApi(19)
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20871a = "b";

    /* renamed from: b  reason: collision with root package name */
    private final AudienceNetworkActivity f20872b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f20873c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final f f20874d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.facebook.ads.internal.view.a.b f20875e;

    /* renamed from: f  reason: collision with root package name */
    private final c f20876f;

    /* renamed from: g  reason: collision with root package name */
    private final AudienceNetworkActivity.BackButtonInterceptor f20877g;

    /* renamed from: h  reason: collision with root package name */
    private String f20878h;

    /* renamed from: i  reason: collision with root package name */
    private String f20879i;

    /* renamed from: j  reason: collision with root package name */
    private long f20880j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f20881k = true;

    /* renamed from: l  reason: collision with root package name */
    private long f20882l = -1;

    /* renamed from: m  reason: collision with root package name */
    private boolean f20883m = true;

    public b(final AudienceNetworkActivity audienceNetworkActivity, c cVar, a.C0037a aVar) {
        AnonymousClass1 r02 = new AudienceNetworkActivity.BackButtonInterceptor() {
            public boolean interceptBackButton() {
                if (!b.this.f20874d.canGoBack()) {
                    return false;
                }
                b.this.f20874d.goBack();
                return true;
            }
        };
        this.f20877g = r02;
        this.f20872b = audienceNetworkActivity;
        this.f20876f = cVar;
        int i2 = (int) (x.f20694b * 2.0f);
        com.facebook.ads.internal.view.a.a aVar2 = new com.facebook.ads.internal.view.a.a(audienceNetworkActivity);
        this.f20873c = aVar2;
        aVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        aVar2.setLayoutParams(layoutParams);
        aVar2.setListener(new a.C0038a() {
            public void a() {
                audienceNetworkActivity.finish();
            }
        });
        aVar.a((View) aVar2);
        f fVar = new f(audienceNetworkActivity);
        this.f20874d = fVar;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, aVar2.getId());
        layoutParams2.addRule(12);
        fVar.setLayoutParams(layoutParams2);
        fVar.setListener(new f.a() {
            public void a(int i2) {
                if (b.this.f20881k) {
                    b.this.f20875e.setProgress(i2);
                }
            }

            public void a(String str) {
                boolean unused = b.this.f20881k = true;
                b.this.f20873c.setUrl(str);
            }

            public void b(String str) {
                b.this.f20873c.setTitle(str);
            }

            public void c(String str) {
                b.this.f20875e.setProgress(100);
                boolean unused = b.this.f20881k = false;
            }
        });
        aVar.a((View) fVar);
        com.facebook.ads.internal.view.a.b bVar = new com.facebook.ads.internal.view.a.b(audienceNetworkActivity, (AttributeSet) null, 16842872);
        this.f20875e = bVar;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i2);
        layoutParams3.addRule(3, aVar2.getId());
        bVar.setLayoutParams(layoutParams3);
        bVar.setProgress(0);
        aVar.a((View) bVar);
        audienceNetworkActivity.addBackButtonInterceptor(r02);
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        long j2;
        if (this.f20882l < 0) {
            this.f20882l = System.currentTimeMillis();
        }
        if (bundle == null) {
            this.f20878h = intent.getStringExtra(AudienceNetworkActivity.BROWSER_URL);
            this.f20879i = intent.getStringExtra(AudienceNetworkActivity.CLIENT_TOKEN);
            j2 = intent.getLongExtra(AudienceNetworkActivity.HANDLER_TIME, -1);
        } else {
            this.f20878h = bundle.getString(AudienceNetworkActivity.BROWSER_URL);
            this.f20879i = bundle.getString(AudienceNetworkActivity.CLIENT_TOKEN);
            j2 = bundle.getLong(AudienceNetworkActivity.HANDLER_TIME, -1);
        }
        this.f20880j = j2;
        String str = this.f20878h;
        if (str == null) {
            str = "about:blank";
        }
        this.f20873c.setUrl(str);
        this.f20874d.loadUrl(str);
    }

    public void a(Bundle bundle) {
        bundle.putString(AudienceNetworkActivity.BROWSER_URL, this.f20878h);
    }

    public void i() {
        this.f20874d.onPause();
        if (this.f20883m) {
            this.f20883m = false;
            this.f20876f.g(this.f20879i, new c.a(this.f20874d.getFirstUrl()).a(this.f20880j).b(this.f20882l).c(this.f20874d.getResponseEndMs()).d(this.f20874d.getDomContentLoadedMs()).e(this.f20874d.getScrollReadyMs()).f(this.f20874d.getLoadFinishMs()).g(System.currentTimeMillis()).a().a());
        }
    }

    public void j() {
        this.f20874d.onResume();
    }

    public void onDestroy() {
        this.f20872b.removeBackButtonInterceptor(this.f20877g);
        com.facebook.ads.internal.q.c.b.a(this.f20874d);
        this.f20874d.destroy();
    }

    public void setListener(a.C0037a aVar) {
    }
}
