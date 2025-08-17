package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import java.io.File;

@SuppressLint({"AppCompatCustomView"})
class a0 extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    private int f12897b;

    /* renamed from: c  reason: collision with root package name */
    private int f12898c;

    /* renamed from: d  reason: collision with root package name */
    private int f12899d;

    /* renamed from: e  reason: collision with root package name */
    private int f12900e;

    /* renamed from: f  reason: collision with root package name */
    private int f12901f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12902g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12903h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12904i;

    /* renamed from: j  reason: collision with root package name */
    private String f12905j;

    /* renamed from: k  reason: collision with root package name */
    private String f12906k;

    /* renamed from: l  reason: collision with root package name */
    private h0 f12907l;

    /* renamed from: m  reason: collision with root package name */
    private c f12908m;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (a0.this.c(h0Var)) {
                a0.this.i(h0Var);
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (a0.this.c(h0Var)) {
                a0.this.e(h0Var);
            }
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            if (a0.this.c(h0Var)) {
                a0.this.g(h0Var);
            }
        }
    }

    a0(Context context, h0 h0Var, int i2, c cVar) {
        super(context);
        this.f12897b = i2;
        this.f12907l = h0Var;
        this.f12908m = cVar;
    }

    /* access modifiers changed from: private */
    public boolean c(h0 h0Var) {
        f1 a2 = h0Var.a();
        if (c0.A(a2, "id") == this.f12897b && c0.A(a2, "container_id") == this.f12908m.p() && c0.E(a2, "ad_session_id").equals(this.f12908m.b())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void e(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.f12898c = c0.A(a2, "x");
        this.f12899d = c0.A(a2, "y");
        this.f12900e = c0.A(a2, "width");
        this.f12901f = c0.A(a2, "height");
        if (this.f12902g) {
            float U = (((float) this.f12901f) * a.f().x0().U()) / ((float) getDrawable().getIntrinsicHeight());
            this.f12901f = (int) (((float) getDrawable().getIntrinsicHeight()) * U);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * U);
            this.f12900e = intrinsicWidth;
            this.f12898c -= intrinsicWidth;
            this.f12899d -= this.f12901f;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f12898c, this.f12899d, 0, 0);
        layoutParams.width = this.f12900e;
        layoutParams.height = this.f12901f;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void g(h0 h0Var) {
        this.f12905j = c0.E(h0Var.a(), "filepath");
        setImageURI(Uri.fromFile(new File(this.f12905j)));
    }

    /* access modifiers changed from: private */
    public void i(h0 h0Var) {
        if (c0.t(h0Var.a(), ViewProps.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        FrameLayout.LayoutParams layoutParams;
        int i2;
        f1 a2 = this.f12907l.a();
        this.f12906k = c0.E(a2, "ad_session_id");
        this.f12898c = c0.A(a2, "x");
        this.f12899d = c0.A(a2, "y");
        this.f12900e = c0.A(a2, "width");
        this.f12901f = c0.A(a2, "height");
        this.f12905j = c0.E(a2, "filepath");
        this.f12902g = c0.t(a2, "dpi");
        this.f12903h = c0.t(a2, "invert_y");
        this.f12904i = c0.t(a2, "wrap_content");
        setImageURI(Uri.fromFile(new File(this.f12905j)));
        if (this.f12902g) {
            float U = (((float) this.f12901f) * a.f().x0().U()) / ((float) getDrawable().getIntrinsicHeight());
            this.f12901f = (int) (((float) getDrawable().getIntrinsicHeight()) * U);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * U);
            this.f12900e = intrinsicWidth;
            this.f12898c -= intrinsicWidth;
            if (this.f12903h) {
                i2 = this.f12899d + this.f12901f;
            } else {
                i2 = this.f12899d - this.f12901f;
            }
            this.f12899d = i2;
        }
        setVisibility(4);
        if (this.f12904i) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f12900e, this.f12901f);
        }
        layoutParams.setMargins(this.f12898c, this.f12899d, 0, 0);
        layoutParams.gravity = 0;
        this.f12908m.addView(this, layoutParams);
        this.f12908m.E().add(a.b("ImageView.set_visible", new a(), true));
        this.f12908m.E().add(a.b("ImageView.set_bounds", new b(), true));
        this.f12908m.E().add(a.b("ImageView.set_image", new c(), true));
        this.f12908m.G().add("ImageView.set_visible");
        this.f12908m.G().add("ImageView.set_bounds");
        this.f12908m.G().add("ImageView.set_image");
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
        c0.u(q2, "view_id", this.f12897b);
        c0.n(q2, "ad_session_id", this.f12906k);
        c0.u(q2, "container_x", this.f12898c + x2);
        c0.u(q2, "container_y", this.f12899d + y2);
        c0.u(q2, "view_x", x2);
        c0.u(q2, "view_y", y2);
        c0.u(q2, "id", this.f12908m.getId());
        if (action != 0) {
            int i2 = y2;
            if (action == 1) {
                if (!this.f12908m.N()) {
                    f2.v(T.s().get(this.f12906k));
                }
                if (x2 <= 0 || x2 >= this.f12900e || i2 <= 0 || i2 >= this.f12901f) {
                    new h0("AdContainer.on_touch_cancelled", this.f12908m.I(), q2).e();
                    return true;
                }
                new h0("AdContainer.on_touch_ended", this.f12908m.I(), q2).e();
                return true;
            } else if (action == 2) {
                new h0("AdContainer.on_touch_moved", this.f12908m.I(), q2).e();
                return true;
            } else if (action == 3) {
                new h0("AdContainer.on_touch_cancelled", this.f12908m.I(), q2).e();
                return true;
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                c0.u(q2, "container_x", ((int) motionEvent2.getX(action2)) + this.f12898c);
                c0.u(q2, "container_y", ((int) motionEvent2.getY(action2)) + this.f12899d);
                c0.u(q2, "view_x", (int) motionEvent2.getX(action2));
                c0.u(q2, "view_y", (int) motionEvent2.getY(action2));
                new h0("AdContainer.on_touch_began", this.f12908m.I(), q2).e();
                return true;
            } else if (action != 6) {
                return true;
            } else {
                int action3 = (motionEvent.getAction() & 65280) >> 8;
                int x3 = (int) motionEvent2.getX(action3);
                int y3 = (int) motionEvent2.getY(action3);
                c0.u(q2, "container_x", ((int) motionEvent2.getX(action3)) + this.f12898c);
                c0.u(q2, "container_y", ((int) motionEvent2.getY(action3)) + this.f12899d);
                c0.u(q2, "view_x", (int) motionEvent2.getX(action3));
                c0.u(q2, "view_y", (int) motionEvent2.getY(action3));
                if (!this.f12908m.N()) {
                    f2.v(T.s().get(this.f12906k));
                }
                if (x3 <= 0 || x3 >= this.f12900e || y3 <= 0 || y3 >= this.f12901f) {
                    new h0("AdContainer.on_touch_cancelled", this.f12908m.I(), q2).e();
                    return true;
                }
                new h0("AdContainer.on_touch_ended", this.f12908m.I(), q2).e();
                return true;
            }
        } else {
            new h0("AdContainer.on_touch_began", this.f12908m.I(), q2).e();
            return true;
        }
    }
}
