package com.facebook.ads.internal.view.c.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.b;
import com.facebook.ads.internal.view.f.c.d;
import com.facebook.ads.internal.view.f.c.f;
import com.facebook.ads.internal.view.f.c.g;
import com.facebook.ads.internal.view.f.c.l;
import com.facebook.ads.internal.view.t;
import java.util.Map;

public class e extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f20986a = ((int) (x.f20694b * 16.0f));

    /* renamed from: b  reason: collision with root package name */
    private final c f20987b;

    /* renamed from: c  reason: collision with root package name */
    private t f20988c;

    /* renamed from: d  reason: collision with root package name */
    private f f20989d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public l f20990e;

    /* renamed from: f  reason: collision with root package name */
    private g f20991f;

    /* renamed from: g  reason: collision with root package name */
    private b f20992g;

    public e(Context context, c cVar) {
        super(context);
        this.f20987b = cVar;
        setUpView(context);
    }

    private void setUpPlugins(Context context) {
        this.f20988c.d();
        g gVar = new g(context);
        this.f20991f = gVar;
        this.f20988c.a((com.facebook.ads.internal.view.f.a.b) gVar);
        this.f20989d = new f(context);
        this.f20988c.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.b(context));
        this.f20988c.a((com.facebook.ads.internal.view.f.a.b) this.f20989d);
        l lVar = new l(context, true);
        this.f20990e = lVar;
        this.f20988c.a((com.facebook.ads.internal.view.f.a.b) lVar);
        this.f20988c.a((com.facebook.ads.internal.view.f.a.b) new d(this.f20990e, d.a.FADE_OUT_ON_PLAY, true, true));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i2 = f20986a;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.f20989d.setLayoutParams(layoutParams);
        this.f20988c.addView(this.f20989d);
    }

    private void setUpVideo(Context context) {
        t tVar = new t(context);
        this.f20988c = tVar;
        tVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        x.a((View) this.f20988c);
        addView(this.f20988c);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f20990e.performClick();
            }
        });
    }

    private void setUpView(Context context) {
        setUpVideo(context);
        setUpPlugins(context);
    }

    public void a() {
        this.f20988c.a(true);
    }

    public void a(com.facebook.ads.internal.j.f fVar) {
        this.f20988c.getEventBus().a(fVar);
    }

    public void a(c cVar, String str, Map<String, String> map) {
        c();
        this.f20992g = new b(getContext(), cVar, (a) this.f20988c, str, map);
    }

    public void a(com.facebook.ads.internal.view.f.a.a aVar) {
        this.f20988c.a(aVar);
    }

    public boolean b() {
        return this.f20988c.i();
    }

    public void c() {
        b bVar = this.f20992g;
        if (bVar != null) {
            bVar.a();
            this.f20992g = null;
        }
    }

    public float getVolume() {
        return this.f20988c.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.f20991f.setImage(str);
    }

    public void setVideoURI(String str) {
        this.f20988c.setVideoURI(str);
    }

    public void setVolume(float f2) {
        this.f20988c.setVolume(f2);
        this.f20989d.a();
    }
}
