package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.adcolony.sdk.e0;
import com.facebook.imageutils.JfifUtil;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class c extends FrameLayout {
    VideoView A;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, a1> f13002b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, y0> f13003c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<Integer, b1> f13004d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, u> f13005e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, a0> f13006f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, Boolean> f13007g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<Integer, View> f13008h;

    /* renamed from: i  reason: collision with root package name */
    private int f13009i;

    /* renamed from: j  reason: collision with root package name */
    private int f13010j;

    /* renamed from: k  reason: collision with root package name */
    private int f13011k;

    /* renamed from: l  reason: collision with root package name */
    private int f13012l;

    /* renamed from: m  reason: collision with root package name */
    private String f13013m;

    /* renamed from: n  reason: collision with root package name */
    boolean f13014n;

    /* renamed from: o  reason: collision with root package name */
    boolean f13015o;

    /* renamed from: p  reason: collision with root package name */
    private float f13016p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    private double f13017q = 0.0d;

    /* renamed from: r  reason: collision with root package name */
    private int f13018r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f13019s = 0;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<j0> f13020t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<String> f13021u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f13022v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f13023w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f13024x;

    /* renamed from: y  reason: collision with root package name */
    private AdSession f13025y;

    /* renamed from: z  reason: collision with root package name */
    Context f13026z;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                c cVar = c.this;
                cVar.f(cVar.q(h0Var), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                c.this.B(h0Var);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$c  reason: collision with other inner class name */
    class C0000c implements j0 {

        /* renamed from: com.adcolony.sdk.c$c$a */
        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13030b;

            a(h0 h0Var) {
                this.f13030b = h0Var;
            }

            public void run() {
                c cVar = c.this;
                cVar.f(cVar.t(this.f13030b), FriendlyObstructionPurpose.OTHER);
            }
        }

        C0000c() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                z0.A(new a(h0Var));
            }
        }
    }

    class d implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13033b;

            a(h0 h0Var) {
                this.f13033b = h0Var;
            }

            public void run() {
                c.this.D(this.f13033b);
            }
        }

        d() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                z0.A(new a(h0Var));
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                c cVar = c.this;
                cVar.f(cVar.l(h0Var), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                c.this.z(h0Var);
            }
        }
    }

    class g implements j0 {
        g() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                c cVar = c.this;
                cVar.f(cVar.a(h0Var), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            if (c.this.F(h0Var)) {
                c.this.x(h0Var);
            }
        }
    }

    class i implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13039b;

        i(boolean z2) {
            this.f13039b = z2;
        }

        public void run() {
            c cVar = c.this;
            if (!cVar.f13014n) {
                cVar.j(this.f13039b);
                c.this.o(this.f13039b);
            }
        }
    }

    c(Context context, String str) {
        super(context);
        this.f13026z = context;
        this.f13013m = str;
        setBackgroundColor(-16777216);
    }

    private void c(float f2, double d2) {
        f1 q2 = c0.q();
        c0.u(q2, "id", this.f13011k);
        c0.n(q2, "ad_session_id", this.f13013m);
        c0.k(q2, "exposure", (double) f2);
        c0.k(q2, "volume", d2);
        new h0("AdContainer.on_exposure_change", this.f13012l, q2).e();
    }

    private void e(int i2, int i3, b1 b1Var) {
        float U = a.f().x0().U();
        if (b1Var != null) {
            f1 q2 = c0.q();
            c0.u(q2, "app_orientation", z0.F(z0.M()));
            c0.u(q2, "width", (int) (((float) b1Var.getCurrentWidth()) / U));
            c0.u(q2, "height", (int) (((float) b1Var.getCurrentHeight()) / U));
            c0.u(q2, "x", i2);
            c0.u(q2, "y", i3);
            c0.n(q2, "ad_session_id", this.f13013m);
            new h0("MRAID.on_size_change", this.f13012l, q2).e();
        }
    }

    /* access modifiers changed from: private */
    public void j(boolean z2) {
        b1 b1Var;
        boolean z3;
        double d2;
        View view = (View) getParent();
        AdColonyAdView adColonyAdView = a.f().T().s().get(this.f13013m);
        if (adColonyAdView == null) {
            b1Var = null;
        } else {
            b1Var = adColonyAdView.getWebView();
        }
        b1 b1Var2 = b1Var;
        Context a2 = a.a();
        boolean z4 = true;
        if (adColonyAdView != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        float a3 = g1.a(view, a2, true, z2, true, z3);
        if (a2 == null) {
            d2 = 0.0d;
        } else {
            d2 = z0.a(z0.d(a2));
        }
        int b2 = z0.b(b1Var2);
        int s2 = z0.s(b1Var2);
        if (b2 == this.f13018r && s2 == this.f13019s) {
            z4 = false;
        }
        if (z4) {
            this.f13018r = b2;
            this.f13019s = s2;
            e(b2, s2, b1Var2);
        }
        if (!(this.f13016p == a3 && this.f13017q == d2 && !z4)) {
            c(a3, d2);
        }
        this.f13016p = a3;
        this.f13017q = d2;
    }

    /* access modifiers changed from: private */
    public void o(boolean z2) {
        z0.n(new i(z2), 200);
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, Boolean> A() {
        return this.f13007g;
    }

    /* access modifiers changed from: package-private */
    public boolean B(h0 h0Var) {
        int A2 = c0.A(h0Var.a(), "id");
        View remove = this.f13008h.remove(Integer.valueOf(A2));
        a1 remove2 = this.f13002b.remove(Integer.valueOf(A2));
        if (remove == null || remove2 == null) {
            d T = a.f().T();
            String c2 = h0Var.c();
            T.i(c2, "" + A2);
            return false;
        }
        if (remove2.r()) {
            remove2.L();
        }
        remove2.d();
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, a0> C() {
        return this.f13006f;
    }

    /* access modifiers changed from: package-private */
    public boolean D(h0 h0Var) {
        int A2 = c0.A(h0Var.a(), "id");
        k f2 = a.f();
        View remove = this.f13008h.remove(Integer.valueOf(A2));
        b1 remove2 = this.f13004d.remove(Integer.valueOf(A2));
        if (remove2 == null || remove == null) {
            d T = f2.T();
            String c2 = h0Var.c();
            T.i(c2, "" + A2);
            return false;
        }
        if (remove2 instanceof k0) {
            f2.F0().p((k0) remove2);
        }
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<j0> E() {
        return this.f13020t;
    }

    /* access modifiers changed from: package-private */
    public boolean F(h0 h0Var) {
        f1 a2 = h0Var.a();
        if (c0.A(a2, "container_id") != this.f13011k || !c0.E(a2, "ad_session_id").equals(this.f13013m)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> G() {
        return this.f13021u;
    }

    /* access modifiers changed from: package-private */
    public void H(h0 h0Var) {
        boolean z2;
        Rect rect;
        this.f13002b = new HashMap<>();
        this.f13003c = new HashMap<>();
        this.f13004d = new HashMap<>();
        this.f13005e = new HashMap<>();
        this.f13006f = new HashMap<>();
        this.f13007g = new HashMap<>();
        this.f13008h = new HashMap<>();
        this.f13020t = new ArrayList<>();
        this.f13021u = new ArrayList<>();
        f1 a2 = h0Var.a();
        if (c0.t(a2, "transparent")) {
            setBackgroundColor(0);
        }
        this.f13011k = c0.A(a2, "id");
        this.f13009i = c0.A(a2, "width");
        this.f13010j = c0.A(a2, "height");
        this.f13012l = c0.A(a2, "module_id");
        this.f13015o = c0.t(a2, "viewability_enabled");
        if (this.f13011k == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f13022v = z2;
        k f2 = a.f();
        if (this.f13009i == 0 && this.f13010j == 0) {
            if (this.f13024x) {
                rect = f2.x0().Z();
            } else {
                rect = f2.x0().Y();
            }
            this.f13009i = rect.width();
            this.f13010j = rect.height();
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(this.f13009i, this.f13010j));
        }
        this.f13020t.add(a.b("VideoView.create", new a(), true));
        this.f13020t.add(a.b("VideoView.destroy", new b(), true));
        this.f13020t.add(a.b("WebView.create", new C0000c(), true));
        this.f13020t.add(a.b("WebView.destroy", new d(), true));
        this.f13020t.add(a.b("TextView.create", new e(), true));
        this.f13020t.add(a.b("TextView.destroy", new f(), true));
        this.f13020t.add(a.b("ImageView.create", new g(), true));
        this.f13020t.add(a.b("ImageView.destroy", new h(), true));
        this.f13021u.add("VideoView.create");
        this.f13021u.add("VideoView.destroy");
        this.f13021u.add("WebView.create");
        this.f13021u.add("WebView.destroy");
        this.f13021u.add("TextView.create");
        this.f13021u.add("TextView.destroy");
        this.f13021u.add("ImageView.create");
        this.f13021u.add("ImageView.destroy");
        VideoView videoView = new VideoView(this.f13026z);
        this.A = videoView;
        videoView.setVisibility(8);
        addView(this.A);
        setClipToPadding(false);
        if (this.f13015o) {
            o(c0.t(h0Var.a(), "advanced_viewability"));
        }
    }

    /* access modifiers changed from: package-private */
    public int I() {
        return this.f13012l;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, y0> J() {
        return this.f13003c;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, a1> K() {
        return this.f13002b;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, b1> L() {
        return this.f13004d;
    }

    /* access modifiers changed from: package-private */
    public boolean M() {
        return this.f13023w;
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        return this.f13022v;
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return this.f13024x;
    }

    /* access modifiers changed from: package-private */
    public a0 a(h0 h0Var) {
        int A2 = c0.A(h0Var.a(), "id");
        a0 a0Var = new a0(this.f13026z, h0Var, A2, this);
        a0Var.a();
        this.f13006f.put(Integer.valueOf(A2), a0Var);
        this.f13008h.put(Integer.valueOf(A2), a0Var);
        return a0Var;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f13013m;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        this.f13010j = i2;
    }

    /* access modifiers changed from: package-private */
    public void f(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.f13025y;
        if (adSession != null && view != null) {
            try {
                adSession.a(view, friendlyObstructionPurpose, (String) null);
            } catch (RuntimeException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(AdSession adSession) {
        this.f13025y = adSession;
        i(this.f13008h);
    }

    /* access modifiers changed from: package-private */
    public void i(Map map) {
        if (this.f13025y != null && map != null) {
            for (Map.Entry value : map.entrySet()) {
                f((View) value.getValue(), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f13010j;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"InlinedApi"})
    public View l(h0 h0Var) {
        f1 a2 = h0Var.a();
        int A2 = c0.A(a2, "id");
        if (c0.t(a2, "editable")) {
            u uVar = new u(this.f13026z, h0Var, A2, this);
            uVar.b();
            this.f13005e.put(Integer.valueOf(A2), uVar);
            this.f13008h.put(Integer.valueOf(A2), uVar);
            this.f13007g.put(Integer.valueOf(A2), Boolean.TRUE);
            return uVar;
        } else if (!c0.t(a2, "button")) {
            y0 y0Var = new y0(this.f13026z, h0Var, A2, this);
            y0Var.b();
            this.f13003c.put(Integer.valueOf(A2), y0Var);
            this.f13008h.put(Integer.valueOf(A2), y0Var);
            this.f13007g.put(Integer.valueOf(A2), Boolean.FALSE);
            return y0Var;
        } else {
            y0 y0Var2 = new y0(this.f13026z, 16974145, h0Var, A2, this);
            y0Var2.b();
            this.f13003c.put(Integer.valueOf(A2), y0Var2);
            this.f13008h.put(Integer.valueOf(A2), y0Var2);
            this.f13007g.put(Integer.valueOf(A2), Boolean.FALSE);
            return y0Var2;
        }
    }

    /* access modifiers changed from: package-private */
    public void m(int i2) {
        this.f13009i = i2;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        k f2 = a.f();
        d T = f2.T();
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        f1 q2 = c0.q();
        c0.u(q2, "view_id", -1);
        c0.n(q2, "ad_session_id", this.f13013m);
        c0.u(q2, "container_x", x2);
        c0.u(q2, "container_y", y2);
        c0.u(q2, "view_x", x2);
        c0.u(q2, "view_y", y2);
        c0.u(q2, "id", this.f13011k);
        if (action == 0) {
            new h0("AdContainer.on_touch_began", this.f13012l, q2).e();
        } else if (action == 1) {
            if (!this.f13022v) {
                f2.v(T.s().get(this.f13013m));
            }
            new h0("AdContainer.on_touch_ended", this.f13012l, q2).e();
        } else if (action == 2) {
            new h0("AdContainer.on_touch_moved", this.f13012l, q2).e();
        } else if (action == 3) {
            new h0("AdContainer.on_touch_cancelled", this.f13012l, q2).e();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            c0.u(q2, "container_x", (int) motionEvent2.getX(action2));
            c0.u(q2, "container_y", (int) motionEvent2.getY(action2));
            c0.u(q2, "view_x", (int) motionEvent2.getX(action2));
            c0.u(q2, "view_y", (int) motionEvent2.getY(action2));
            new h0("AdContainer.on_touch_began", this.f13012l, q2).e();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & 65280) >> 8;
            c0.u(q2, "container_x", (int) motionEvent2.getX(action3));
            c0.u(q2, "container_y", (int) motionEvent2.getY(action3));
            c0.u(q2, "view_x", (int) motionEvent2.getX(action3));
            c0.u(q2, "view_y", (int) motionEvent2.getY(action3));
            c0.u(q2, "x", (int) motionEvent2.getX(action3));
            c0.u(q2, "y", (int) motionEvent2.getY(action3));
            if (!this.f13022v) {
                f2.v(T.s().get(this.f13013m));
            }
            new h0("AdContainer.on_touch_ended", this.f13012l, q2).e();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f13011k;
    }

    /* access modifiers changed from: package-private */
    public a1 q(h0 h0Var) {
        int A2 = c0.A(h0Var.a(), "id");
        a1 a1Var = new a1(this.f13026z, h0Var, A2, this);
        a1Var.t();
        this.f13002b.put(Integer.valueOf(A2), a1Var);
        this.f13008h.put(Integer.valueOf(A2), a1Var);
        return a1Var;
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z2) {
        this.f13022v = z2;
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f13009i;
    }

    /* access modifiers changed from: package-private */
    public b1 t(h0 h0Var) {
        b1 b1Var;
        f1 a2 = h0Var.a();
        int A2 = c0.A(a2, "id");
        boolean t2 = c0.t(a2, "is_module");
        k f2 = a.f();
        if (t2) {
            b1Var = f2.b().get(Integer.valueOf(c0.A(a2, "module_id")));
            if (b1Var == null) {
                new e0.a().c("Module WebView created with invalid id").d(e0.f13113h);
                return null;
            }
            b1Var.o(h0Var, A2, this);
        } else {
            try {
                b1Var = b1.b(this.f13026z, h0Var, A2, this);
            } catch (RuntimeException e2) {
                e0.a aVar = new e0.a();
                aVar.c(e2.toString() + ": during WebView initialization.").c(" Disabling AdColony.").d(e0.f13113h);
                AdColony.f();
                return null;
            }
        }
        this.f13004d.put(Integer.valueOf(A2), b1Var);
        this.f13008h.put(Integer.valueOf(A2), b1Var);
        f1 q2 = c0.q();
        c0.u(q2, "module_id", b1Var.getWebViewModuleId());
        if (b1Var instanceof l0) {
            c0.u(q2, "mraid_module_id", ((l0) b1Var).getAdcModuleId());
        }
        h0Var.b(q2).e();
        return b1Var;
    }

    /* access modifiers changed from: package-private */
    public void u(boolean z2) {
        this.f13024x = z2;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, View> v() {
        return this.f13008h;
    }

    /* access modifiers changed from: package-private */
    public void w(boolean z2) {
        this.f13023w = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean x(h0 h0Var) {
        int A2 = c0.A(h0Var.a(), "id");
        View remove = this.f13008h.remove(Integer.valueOf(A2));
        a0 remove2 = this.f13006f.remove(Integer.valueOf(A2));
        if (remove == null || remove2 == null) {
            d T = a.f().T();
            String c2 = h0Var.c();
            T.i(c2, "" + A2);
            return false;
        }
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, u> y() {
        return this.f13005e;
    }

    /* access modifiers changed from: package-private */
    public boolean z(h0 h0Var) {
        TextView textView;
        int A2 = c0.A(h0Var.a(), "id");
        View remove = this.f13008h.remove(Integer.valueOf(A2));
        if (this.f13007g.remove(Integer.valueOf(A2)).booleanValue()) {
            textView = this.f13005e.remove(Integer.valueOf(A2));
        } else {
            textView = this.f13003c.remove(Integer.valueOf(A2));
        }
        if (remove == null || textView == null) {
            d T = a.f().T();
            String c2 = h0Var.c();
            T.i(c2, "" + A2);
            return false;
        }
        removeView(textView);
        return true;
    }
}
