package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: l  reason: collision with root package name */
    private static TooltipCompatHandler f1526l;

    /* renamed from: m  reason: collision with root package name */
    private static TooltipCompatHandler f1527m;

    /* renamed from: b  reason: collision with root package name */
    private final View f1528b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f1529c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1530d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1531e = new g1(this);

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f1532f = new h1(this);

    /* renamed from: g  reason: collision with root package name */
    private int f1533g;

    /* renamed from: h  reason: collision with root package name */
    private int f1534h;

    /* renamed from: i  reason: collision with root package name */
    private TooltipPopup f1535i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1536j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1537k;

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f1528b = view;
        this.f1529c = charSequence;
        this.f1530d = ViewConfigurationCompat.c(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f1528b.removeCallbacks(this.f1531e);
    }

    private void c() {
        this.f1537k = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f1528b.postDelayed(this.f1531e, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void g(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = f1526l;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.b();
        }
        f1526l = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = f1526l;
        if (tooltipCompatHandler != null && tooltipCompatHandler.f1528b == view) {
            g((TooltipCompatHandler) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = f1527m;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.f1528b == view) {
                tooltipCompatHandler2.d();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    private boolean j(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (!this.f1537k && Math.abs(x2 - this.f1533g) <= this.f1530d && Math.abs(y2 - this.f1534h) <= this.f1530d) {
            return false;
        }
        this.f1533g = x2;
        this.f1534h = y2;
        this.f1537k = false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (f1527m == this) {
            f1527m = null;
            TooltipPopup tooltipPopup = this.f1535i;
            if (tooltipPopup != null) {
                tooltipPopup.c();
                this.f1535i = null;
                c();
                this.f1528b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1526l == this) {
            g((TooltipCompatHandler) null);
        }
        this.f1528b.removeCallbacks(this.f1532f);
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z2) {
        long j2;
        long j3;
        long j4;
        if (ViewCompat.U(this.f1528b)) {
            g((TooltipCompatHandler) null);
            TooltipCompatHandler tooltipCompatHandler = f1527m;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.d();
            }
            f1527m = this;
            this.f1536j = z2;
            TooltipPopup tooltipPopup = new TooltipPopup(this.f1528b.getContext());
            this.f1535i = tooltipPopup;
            tooltipPopup.e(this.f1528b, this.f1533g, this.f1534h, this.f1536j, this.f1529c);
            this.f1528b.addOnAttachStateChangeListener(this);
            if (this.f1536j) {
                j2 = 2500;
            } else {
                if ((ViewCompat.N(this.f1528b) & 1) == 1) {
                    j4 = (long) ViewConfiguration.getLongPressTimeout();
                    j3 = 3000;
                } else {
                    j4 = (long) ViewConfiguration.getLongPressTimeout();
                    j3 = 15000;
                }
                j2 = j3 - j4;
            }
            this.f1528b.removeCallbacks(this.f1532f);
            this.f1528b.postDelayed(this.f1532f, j2);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1535i != null && this.f1536j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1528b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1528b.isEnabled() && this.f1535i == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1533g = view.getWidth() / 2;
        this.f1534h = view.getHeight() / 2;
        i(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
