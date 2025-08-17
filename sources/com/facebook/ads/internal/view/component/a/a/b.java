package com.facebook.ads.internal.view.component.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.b.m;
import com.facebook.ads.internal.view.f.b.v;
import com.facebook.ads.internal.view.f.b.w;
import com.facebook.ads.internal.view.s;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract class b extends com.facebook.ads.internal.view.component.a.b {

    /* renamed from: c  reason: collision with root package name */
    private static final int f21055c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f21056d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f21057e;

    /* renamed from: f  reason: collision with root package name */
    private s f21058f;

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.ads.internal.view.c.a.e f21059g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f21060h;

    /* renamed from: i  reason: collision with root package name */
    private final String f21061i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f21062j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21063k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public com.facebook.ads.internal.view.c.a.a f21064l;

    /* renamed from: m  reason: collision with root package name */
    private final Path f21065m = new Path();

    /* renamed from: n  reason: collision with root package name */
    private final RectF f21066n = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f21067o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f21068p;

    /* renamed from: q  reason: collision with root package name */
    private a f21069q;

    /* renamed from: r  reason: collision with root package name */
    private final w f21070r = new w() {
        public void a(v vVar) {
            b.this.f21064l.a().a(b.this.getVideoView().getVolume());
        }
    };

    /* renamed from: s  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.b.c f21071s = new com.facebook.ads.internal.view.f.b.c() {
        public void a(com.facebook.ads.internal.view.f.b.b bVar) {
            b.this.f21064l.b().a(((Integer) b.this.getTag(-1593835536)).intValue());
        }
    };

    /* renamed from: t  reason: collision with root package name */
    private final k f21072t = new k() {
        public void a(j jVar) {
            b.this.f21064l.c().a(b.this);
        }
    };

    /* renamed from: u  reason: collision with root package name */
    private final i f21073u = new i() {
        public void a(h hVar) {
            b.this.f21064l.c().b(b.this);
        }
    };

    /* renamed from: v  reason: collision with root package name */
    private final m f21074v = new m() {
        public void a(l lVar) {
            boolean unused = b.this.f21068p = true;
            b.this.k();
        }
    };

    public interface a {
        void a();
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$b  reason: collision with other inner class name */
    private static class C0040b implements com.facebook.ads.internal.view.b.e {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<b> f21080a;

        private C0040b(b bVar) {
            this.f21080a = new WeakReference<>(bVar);
        }

        public void a(boolean z2) {
            b bVar = this.f21080a.get();
            if (bVar != null) {
                boolean unused = bVar.f21067o = z2;
                bVar.k();
            }
        }
    }

    public interface c {
        void a(int i2);
    }

    public interface d {
        void a(View view);

        void b(View view);
    }

    public interface e {
        float a();

        void a(float f2);
    }

    static {
        float f2 = x.f20694b;
        f21055c = (int) (1.0f * f2);
        f21056d = (int) (4.0f * f2);
        f21057e = (int) (f2 * 6.0f);
    }

    b(com.facebook.ads.internal.view.component.a.d dVar, com.facebook.ads.internal.adapters.a.d dVar2, boolean z2, String str, com.facebook.ads.internal.view.c.a.a aVar) {
        super(dVar, dVar2, z2);
        this.f21064l = aVar;
        this.f21061i = str;
        setGravity(17);
        int i2 = f21055c;
        setPadding(i2, 0, i2, i2);
        x.a((View) this, 0);
        setUpView(getContext());
        Paint paint = new Paint();
        this.f21062j = paint;
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(16);
        paint.setAntiAlias(true);
    }

    private void a(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        x.a(view);
    }

    /* access modifiers changed from: private */
    public void k() {
        if (this.f21069q != null) {
            if ((f() && this.f21068p) || (!f() && this.f21067o)) {
                this.f21069q.a();
            }
        }
    }

    private void setUpView(Context context) {
        setUpImageView(context);
        setUpVideoView(context);
        setUpMediaContainer(context);
        this.f21060h.addView(this.f21058f);
        this.f21060h.addView(this.f21059g);
        a(context);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context);

    public void a(String str, String str2) {
        getTitleDescContainer().a(str, str2, true, false);
    }

    public void a(String str, String str2, Map<String, String> map) {
        getCtaButton().a(str, str2, this.f21061i, map);
    }

    public void a(Map<String, String> map) {
        this.f21059g.c();
        if (f()) {
            this.f21059g.a(getAdEventManager(), this.f21061i, map);
        }
    }

    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.f21063k;
    }

    public boolean g() {
        return f() && this.f21059g.b();
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout getMediaContainer() {
        return this.f21060h;
    }

    /* access modifiers changed from: protected */
    public final com.facebook.ads.internal.view.c.a.e getVideoView() {
        return this.f21059g;
    }

    public void h() {
        if (f()) {
            j();
            this.f21059g.a(com.facebook.ads.internal.view.f.a.a.AUTO_STARTED);
        }
    }

    public void i() {
        if (f()) {
            this.f21059g.a();
        }
    }

    public void j() {
        float a2 = this.f21064l.a().a();
        if (f() && a2 != this.f21059g.getVolume()) {
            this.f21059g.setVolume(a2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f21065m.reset();
        this.f21066n.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        Path path = this.f21065m;
        RectF rectF = this.f21066n;
        int i2 = f21057e;
        path.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
        canvas.drawPath(this.f21065m, this.f21062j);
        RectF rectF2 = this.f21066n;
        int i3 = f21055c;
        rectF2.set((float) i3, 0.0f, (float) (getWidth() - i3), (float) (getHeight() - i3));
        Path path2 = this.f21065m;
        RectF rectF3 = this.f21066n;
        int i4 = f21056d;
        path2.addRoundRect(rectF3, (float) i4, (float) i4, Path.Direction.CW);
        canvas.clipPath(this.f21065m);
        super.onDraw(canvas);
    }

    public void setImageUrl(String str) {
        this.f21058f.setVisibility(0);
        this.f21059g.setVisibility(8);
        new com.facebook.ads.internal.view.b.d((ImageView) this.f21058f).a().a((com.facebook.ads.internal.view.b.e) new C0040b()).a(str);
    }

    public void setIsVideo(boolean z2) {
        this.f21063k = z2;
    }

    public void setOnAssetsLoadedListener(a aVar) {
        this.f21069q = aVar;
    }

    /* access modifiers changed from: protected */
    public void setUpImageView(Context context) {
        s sVar = new s(context);
        this.f21058f = sVar;
        a((View) sVar);
    }

    /* access modifiers changed from: protected */
    public void setUpMediaContainer(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f21060h = relativeLayout;
        a((View) relativeLayout);
    }

    /* access modifiers changed from: protected */
    public void setUpVideoView(Context context) {
        com.facebook.ads.internal.view.c.a.e eVar = new com.facebook.ads.internal.view.c.a.e(context, getAdEventManager());
        this.f21059g = eVar;
        a((View) eVar);
    }

    public void setVideoPlaceholderUrl(String str) {
        this.f21059g.setPlaceholderUrl(str);
    }

    public void setVideoUrl(String str) {
        this.f21058f.setVisibility(8);
        this.f21059g.setVisibility(0);
        this.f21059g.setVideoURI(str);
        this.f21059g.a((f) this.f21070r);
        this.f21059g.a((f) this.f21071s);
        this.f21059g.a((f) this.f21072t);
        this.f21059g.a((f) this.f21073u);
        this.f21059g.a((f) this.f21074v);
    }
}
