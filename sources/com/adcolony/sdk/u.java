package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;

@SuppressLint({"AppCompatCustomView"})
class u extends EditText {

    /* renamed from: b  reason: collision with root package name */
    private int f13408b;

    /* renamed from: c  reason: collision with root package name */
    private int f13409c;

    /* renamed from: d  reason: collision with root package name */
    private int f13410d;

    /* renamed from: e  reason: collision with root package name */
    private int f13411e;

    /* renamed from: f  reason: collision with root package name */
    private int f13412f;

    /* renamed from: g  reason: collision with root package name */
    private int f13413g;

    /* renamed from: h  reason: collision with root package name */
    private int f13414h;

    /* renamed from: i  reason: collision with root package name */
    private int f13415i;

    /* renamed from: j  reason: collision with root package name */
    private int f13416j;

    /* renamed from: k  reason: collision with root package name */
    private int f13417k;

    /* renamed from: l  reason: collision with root package name */
    private String f13418l;

    /* renamed from: m  reason: collision with root package name */
    private String f13419m;

    /* renamed from: n  reason: collision with root package name */
    private String f13420n;

    /* renamed from: o  reason: collision with root package name */
    private String f13421o;

    /* renamed from: p  reason: collision with root package name */
    private c f13422p;

    /* renamed from: q  reason: collision with root package name */
    private h0 f13423q;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.c(h0Var);
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.m(h0Var);
            }
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.g(h0Var);
            }
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.h(h0Var);
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.f(h0Var);
            }
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.l(h0Var);
            }
        }
    }

    class g implements j0 {
        g() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.i(h0Var);
            }
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.j(h0Var);
            }
        }
    }

    class i implements j0 {
        i() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.d(h0Var);
            }
        }
    }

    class j implements j0 {
        j() {
        }

        public void a(h0 h0Var) {
            if (u.this.e(h0Var)) {
                u.this.k(h0Var);
            }
        }
    }

    u(Context context, h0 h0Var, int i2, c cVar) {
        super(context);
        this.f13408b = i2;
        this.f13423q = h0Var;
        this.f13422p = cVar;
    }

    /* access modifiers changed from: package-private */
    public int a(boolean z2, int i2) {
        if (i2 == 0) {
            return z2 ? 1 : 16;
        }
        if (i2 == 1) {
            return z2 ? 8388611 : 48;
        }
        if (i2 != 2) {
            return 17;
        }
        return z2 ? 8388613 : 80;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        f1 a2 = this.f13423q.a();
        this.f13418l = c0.E(a2, "ad_session_id");
        this.f13409c = c0.A(a2, "x");
        this.f13410d = c0.A(a2, "y");
        this.f13411e = c0.A(a2, "width");
        this.f13412f = c0.A(a2, "height");
        this.f13414h = c0.A(a2, "font_family");
        this.f13413g = c0.A(a2, "font_style");
        this.f13415i = c0.A(a2, "font_size");
        this.f13419m = c0.E(a2, "background_color");
        this.f13420n = c0.E(a2, "font_color");
        this.f13421o = c0.E(a2, "text");
        this.f13416j = c0.A(a2, "align_x");
        this.f13417k = c0.A(a2, "align_y");
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f13411e, this.f13412f);
        layoutParams.setMargins(this.f13409c, this.f13410d, 0, 0);
        layoutParams.gravity = 0;
        this.f13422p.addView(this, layoutParams);
        int i2 = this.f13414h;
        if (i2 == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (i2 == 1) {
            setTypeface(Typeface.SERIF);
        } else if (i2 == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (i2 == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
        int i3 = this.f13413g;
        if (i3 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (i3 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (i3 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (i3 == 3) {
            setTypeface(getTypeface(), 3);
        }
        setText(this.f13421o);
        setTextSize((float) this.f13415i);
        setGravity(a(true, this.f13416j) | a(false, this.f13417k));
        if (!this.f13419m.equals("")) {
            setBackgroundColor(z0.L(this.f13419m));
        }
        if (!this.f13420n.equals("")) {
            setTextColor(z0.L(this.f13420n));
        }
        this.f13422p.E().add(a.b("TextView.set_visible", new b(), true));
        this.f13422p.E().add(a.b("TextView.set_bounds", new c(), true));
        this.f13422p.E().add(a.b("TextView.set_font_color", new d(), true));
        this.f13422p.E().add(a.b("TextView.set_background_color", new e(), true));
        this.f13422p.E().add(a.b("TextView.set_typeface", new f(), true));
        this.f13422p.E().add(a.b("TextView.set_font_size", new g(), true));
        this.f13422p.E().add(a.b("TextView.set_font_style", new h(), true));
        this.f13422p.E().add(a.b("TextView.get_text", new i(), true));
        this.f13422p.E().add(a.b("TextView.set_text", new j(), true));
        this.f13422p.E().add(a.b("TextView.align", new a(), true));
        this.f13422p.G().add("TextView.set_visible");
        this.f13422p.G().add("TextView.set_bounds");
        this.f13422p.G().add("TextView.set_font_color");
        this.f13422p.G().add("TextView.set_background_color");
        this.f13422p.G().add("TextView.set_typeface");
        this.f13422p.G().add("TextView.set_font_size");
        this.f13422p.G().add("TextView.set_font_style");
        this.f13422p.G().add("TextView.get_text");
        this.f13422p.G().add("TextView.set_text");
        this.f13422p.G().add("TextView.align");
    }

    /* access modifiers changed from: package-private */
    public void c(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.f13416j = c0.A(a2, "x");
        this.f13417k = c0.A(a2, "y");
        setGravity(a(true, this.f13416j) | a(false, this.f13417k));
    }

    /* access modifiers changed from: package-private */
    public void d(h0 h0Var) {
        f1 q2 = c0.q();
        c0.n(q2, "text", getText().toString());
        h0Var.b(q2).e();
    }

    /* access modifiers changed from: package-private */
    public boolean e(h0 h0Var) {
        f1 a2 = h0Var.a();
        if (c0.A(a2, "id") == this.f13408b && c0.A(a2, "container_id") == this.f13422p.p() && c0.E(a2, "ad_session_id").equals(this.f13422p.b())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f(h0 h0Var) {
        String E = c0.E(h0Var.a(), "background_color");
        this.f13419m = E;
        setBackgroundColor(z0.L(E));
    }

    /* access modifiers changed from: package-private */
    public void g(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.f13409c = c0.A(a2, "x");
        this.f13410d = c0.A(a2, "y");
        this.f13411e = c0.A(a2, "width");
        this.f13412f = c0.A(a2, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f13409c, this.f13410d, 0, 0);
        layoutParams.width = this.f13411e;
        layoutParams.height = this.f13412f;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void h(h0 h0Var) {
        String E = c0.E(h0Var.a(), "font_color");
        this.f13420n = E;
        setTextColor(z0.L(E));
    }

    /* access modifiers changed from: package-private */
    public void i(h0 h0Var) {
        int A = c0.A(h0Var.a(), "font_size");
        this.f13415i = A;
        setTextSize((float) A);
    }

    /* access modifiers changed from: package-private */
    public void j(h0 h0Var) {
        int A = c0.A(h0Var.a(), "font_style");
        this.f13413g = A;
        if (A == 0) {
            setTypeface(getTypeface(), 0);
        } else if (A == 1) {
            setTypeface(getTypeface(), 1);
        } else if (A == 2) {
            setTypeface(getTypeface(), 2);
        } else if (A == 3) {
            setTypeface(getTypeface(), 3);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(h0 h0Var) {
        String E = c0.E(h0Var.a(), "text");
        this.f13421o = E;
        setText(E);
    }

    /* access modifiers changed from: package-private */
    public void l(h0 h0Var) {
        int A = c0.A(h0Var.a(), "font_family");
        this.f13414h = A;
        if (A == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (A == 1) {
            setTypeface(Typeface.SERIF);
        } else if (A == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (A == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
    }

    /* access modifiers changed from: package-private */
    public void m(h0 h0Var) {
        if (c0.t(h0Var.a(), ViewProps.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        k f2 = a.f();
        d T = f2.T();
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        f1 q2 = c0.q();
        c0.u(q2, "view_id", this.f13408b);
        c0.n(q2, "ad_session_id", this.f13418l);
        c0.u(q2, "container_x", this.f13409c + x2);
        c0.u(q2, "container_y", this.f13410d + y2);
        c0.u(q2, "view_x", x2);
        c0.u(q2, "view_y", y2);
        c0.u(q2, "id", this.f13422p.p());
        if (action == 0) {
            new h0("AdContainer.on_touch_began", this.f13422p.I(), q2).e();
        } else if (action == 1) {
            if (!this.f13422p.N()) {
                f2.v(T.s().get(this.f13418l));
            }
            new h0("AdContainer.on_touch_ended", this.f13422p.I(), q2).e();
        } else if (action == 2) {
            new h0("AdContainer.on_touch_moved", this.f13422p.I(), q2).e();
        } else if (action == 3) {
            new h0("AdContainer.on_touch_cancelled", this.f13422p.I(), q2).e();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            c0.u(q2, "container_x", ((int) motionEvent2.getX(action2)) + this.f13409c);
            c0.u(q2, "container_y", ((int) motionEvent2.getY(action2)) + this.f13410d);
            c0.u(q2, "view_x", (int) motionEvent2.getX(action2));
            c0.u(q2, "view_y", (int) motionEvent2.getY(action2));
            new h0("AdContainer.on_touch_began", this.f13422p.I(), q2).e();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & 65280) >> 8;
            c0.u(q2, "container_x", ((int) motionEvent2.getX(action3)) + this.f13409c);
            c0.u(q2, "container_y", ((int) motionEvent2.getY(action3)) + this.f13410d);
            c0.u(q2, "view_x", (int) motionEvent2.getX(action3));
            c0.u(q2, "view_y", (int) motionEvent2.getY(action3));
            if (!this.f13422p.N()) {
                f2.v(T.s().get(this.f13418l));
            }
            new h0("AdContainer.on_touch_ended", this.f13422p.I(), q2).e();
        }
        return true;
    }
}
