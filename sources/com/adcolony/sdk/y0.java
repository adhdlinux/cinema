package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;

@SuppressLint({"AppCompatCustomView"})
class y0 extends Button {

    /* renamed from: b  reason: collision with root package name */
    private int f13507b;

    /* renamed from: c  reason: collision with root package name */
    private int f13508c;

    /* renamed from: d  reason: collision with root package name */
    private int f13509d;

    /* renamed from: e  reason: collision with root package name */
    private int f13510e;

    /* renamed from: f  reason: collision with root package name */
    private int f13511f;

    /* renamed from: g  reason: collision with root package name */
    private int f13512g;

    /* renamed from: h  reason: collision with root package name */
    private int f13513h;

    /* renamed from: i  reason: collision with root package name */
    private int f13514i;

    /* renamed from: j  reason: collision with root package name */
    private int f13515j;

    /* renamed from: k  reason: collision with root package name */
    private int f13516k;

    /* renamed from: l  reason: collision with root package name */
    private String f13517l;

    /* renamed from: m  reason: collision with root package name */
    private String f13518m;

    /* renamed from: n  reason: collision with root package name */
    private String f13519n;

    /* renamed from: o  reason: collision with root package name */
    private String f13520o;

    /* renamed from: p  reason: collision with root package name */
    private c f13521p;

    /* renamed from: q  reason: collision with root package name */
    private h0 f13522q;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.c(h0Var);
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.m(h0Var);
            }
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.g(h0Var);
            }
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.h(h0Var);
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.f(h0Var);
            }
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.l(h0Var);
            }
        }
    }

    class g implements j0 {
        g() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.i(h0Var);
            }
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.j(h0Var);
            }
        }
    }

    class i implements j0 {
        i() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.d(h0Var);
            }
        }
    }

    class j implements j0 {
        j() {
        }

        public void a(h0 h0Var) {
            if (y0.this.e(h0Var)) {
                y0.this.k(h0Var);
            }
        }
    }

    y0(Context context, h0 h0Var, int i2, c cVar) {
        super(context);
        this.f13507b = i2;
        this.f13522q = h0Var;
        this.f13521p = cVar;
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
        FrameLayout.LayoutParams layoutParams;
        int i2;
        int i3;
        f1 a2 = this.f13522q.a();
        this.f13520o = c0.E(a2, "ad_session_id");
        this.f13508c = c0.A(a2, "x");
        this.f13509d = c0.A(a2, "y");
        this.f13510e = c0.A(a2, "width");
        this.f13511f = c0.A(a2, "height");
        this.f13513h = c0.A(a2, "font_family");
        this.f13512g = c0.A(a2, "font_style");
        this.f13514i = c0.A(a2, "font_size");
        this.f13517l = c0.E(a2, "background_color");
        this.f13518m = c0.E(a2, "font_color");
        this.f13519n = c0.E(a2, "text");
        this.f13515j = c0.A(a2, "align_x");
        this.f13516k = c0.A(a2, "align_y");
        k f2 = a.f();
        if (this.f13519n.equals("")) {
            this.f13519n = "Learn More";
        }
        setVisibility(4);
        if (c0.t(a2, "wrap_content")) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f13510e, this.f13511f);
        }
        layoutParams.gravity = 0;
        setText(this.f13519n);
        setTextSize((float) this.f13514i);
        if (c0.t(a2, "overlay")) {
            this.f13508c = 0;
            this.f13509d = 0;
            i3 = (int) (f2.x0().U() * 6.0f);
            i2 = (int) (f2.x0().U() * 6.0f);
            int U = (int) (f2.x0().U() * 4.0f);
            setPadding(U, U, U, U);
            layoutParams.gravity = 8388693;
        } else {
            i3 = 0;
            i2 = 0;
        }
        layoutParams.setMargins(this.f13508c, this.f13509d, i3, i2);
        this.f13521p.addView(this, layoutParams);
        int i4 = this.f13513h;
        if (i4 == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (i4 == 1) {
            setTypeface(Typeface.SERIF);
        } else if (i4 == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (i4 == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
        int i5 = this.f13512g;
        if (i5 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (i5 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (i5 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (i5 == 3) {
            setTypeface(getTypeface(), 3);
        }
        setGravity(a(true, this.f13515j) | a(false, this.f13516k));
        if (!this.f13517l.equals("")) {
            setBackgroundColor(z0.L(this.f13517l));
        }
        if (!this.f13518m.equals("")) {
            setTextColor(z0.L(this.f13518m));
        }
        this.f13521p.E().add(a.b("TextView.set_visible", new b(), true));
        this.f13521p.E().add(a.b("TextView.set_bounds", new c(), true));
        this.f13521p.E().add(a.b("TextView.set_font_color", new d(), true));
        this.f13521p.E().add(a.b("TextView.set_background_color", new e(), true));
        this.f13521p.E().add(a.b("TextView.set_typeface", new f(), true));
        this.f13521p.E().add(a.b("TextView.set_font_size", new g(), true));
        this.f13521p.E().add(a.b("TextView.set_font_style", new h(), true));
        this.f13521p.E().add(a.b("TextView.get_text", new i(), true));
        this.f13521p.E().add(a.b("TextView.set_text", new j(), true));
        this.f13521p.E().add(a.b("TextView.align", new a(), true));
        this.f13521p.G().add("TextView.set_visible");
        this.f13521p.G().add("TextView.set_bounds");
        this.f13521p.G().add("TextView.set_font_color");
        this.f13521p.G().add("TextView.set_background_color");
        this.f13521p.G().add("TextView.set_typeface");
        this.f13521p.G().add("TextView.set_font_size");
        this.f13521p.G().add("TextView.set_font_style");
        this.f13521p.G().add("TextView.get_text");
        this.f13521p.G().add("TextView.set_text");
        this.f13521p.G().add("TextView.align");
    }

    /* access modifiers changed from: package-private */
    public void c(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.f13515j = c0.A(a2, "x");
        this.f13516k = c0.A(a2, "y");
        setGravity(a(true, this.f13515j) | a(false, this.f13516k));
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
        if (c0.A(a2, "id") == this.f13507b && c0.A(a2, "container_id") == this.f13521p.p() && c0.E(a2, "ad_session_id").equals(this.f13521p.b())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f(h0 h0Var) {
        String E = c0.E(h0Var.a(), "background_color");
        this.f13517l = E;
        setBackgroundColor(z0.L(E));
    }

    /* access modifiers changed from: package-private */
    public void g(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.f13508c = c0.A(a2, "x");
        this.f13509d = c0.A(a2, "y");
        this.f13510e = c0.A(a2, "width");
        this.f13511f = c0.A(a2, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f13508c, this.f13509d, 0, 0);
        layoutParams.width = this.f13510e;
        layoutParams.height = this.f13511f;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void h(h0 h0Var) {
        String E = c0.E(h0Var.a(), "font_color");
        this.f13518m = E;
        setTextColor(z0.L(E));
    }

    /* access modifiers changed from: package-private */
    public void i(h0 h0Var) {
        int A = c0.A(h0Var.a(), "font_size");
        this.f13514i = A;
        setTextSize((float) A);
    }

    /* access modifiers changed from: package-private */
    public void j(h0 h0Var) {
        int A = c0.A(h0Var.a(), "font_style");
        this.f13512g = A;
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
        this.f13519n = E;
        setText(E);
    }

    /* access modifiers changed from: package-private */
    public void l(h0 h0Var) {
        int A = c0.A(h0Var.a(), "font_family");
        this.f13513h = A;
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
        c0.u(q2, "view_id", this.f13507b);
        c0.n(q2, "ad_session_id", this.f13520o);
        c0.u(q2, "container_x", this.f13508c + x2);
        c0.u(q2, "container_y", this.f13509d + y2);
        c0.u(q2, "view_x", x2);
        c0.u(q2, "view_y", y2);
        c0.u(q2, "id", this.f13521p.getId());
        if (action != 0) {
            int i2 = y2;
            if (action == 1) {
                if (!this.f13521p.N()) {
                    f2.v(T.s().get(this.f13520o));
                }
                if (x2 <= 0 || x2 >= getWidth() || i2 <= 0 || i2 >= getHeight()) {
                    new h0("AdContainer.on_touch_cancelled", this.f13521p.I(), q2).e();
                    return true;
                }
                new h0("AdContainer.on_touch_ended", this.f13521p.I(), q2).e();
                return true;
            } else if (action == 2) {
                new h0("AdContainer.on_touch_moved", this.f13521p.I(), q2).e();
                return true;
            } else if (action == 3) {
                new h0("AdContainer.on_touch_cancelled", this.f13521p.I(), q2).e();
                return true;
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                c0.u(q2, "container_x", ((int) motionEvent2.getX(action2)) + this.f13508c);
                c0.u(q2, "container_y", ((int) motionEvent2.getY(action2)) + this.f13509d);
                c0.u(q2, "view_x", (int) motionEvent2.getX(action2));
                c0.u(q2, "view_y", (int) motionEvent2.getY(action2));
                new h0("AdContainer.on_touch_began", this.f13521p.I(), q2).e();
                return true;
            } else if (action != 6) {
                return true;
            } else {
                int action3 = (motionEvent.getAction() & 65280) >> 8;
                int x3 = (int) motionEvent2.getX(action3);
                int y3 = (int) motionEvent2.getY(action3);
                c0.u(q2, "container_x", ((int) motionEvent2.getX(action3)) + this.f13508c);
                c0.u(q2, "container_y", ((int) motionEvent2.getY(action3)) + this.f13509d);
                c0.u(q2, "view_x", (int) motionEvent2.getX(action3));
                c0.u(q2, "view_y", (int) motionEvent2.getY(action3));
                if (!this.f13521p.N()) {
                    f2.v(T.s().get(this.f13520o));
                }
                if (x3 <= 0 || x3 >= getWidth() || y3 <= 0 || y3 >= getHeight()) {
                    new h0("AdContainer.on_touch_cancelled", this.f13521p.I(), q2).e();
                    return true;
                }
                new h0("AdContainer.on_touch_ended", this.f13521p.I(), q2).e();
                return true;
            }
        } else {
            new h0("AdContainer.on_touch_began", this.f13521p.I(), q2).e();
            return true;
        }
    }

    y0(Context context, int i2, h0 h0Var, int i3, c cVar) {
        super(context, (AttributeSet) null, i2);
        this.f13507b = i3;
        this.f13522q = h0Var;
        this.f13521p = cVar;
    }
}
